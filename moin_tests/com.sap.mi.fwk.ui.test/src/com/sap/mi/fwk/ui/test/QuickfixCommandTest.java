package com.sap.mi.fwk.ui.test;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;

import abbot.swt.Robot;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.resolution.QuickfixCommand;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Tests marker resolution for Moin markers by {@link QuickfixCommand}s
 * 
 * @author d024127
 */
public class QuickfixCommandTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/quickfixcommand";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/marker");

	// name
	private Connection connection;
	private IFile partitionFile;

	private Component component;

	private LShell mShell;
	private Display mDisplay;
	private LFactory mAbbotFactory;

	public QuickfixCommandTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		connection = createConnection();

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro", new String[] {
				"WebDynpro", "component" });
		component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		partition.assignElement((Partitionable) component);

		ModelManager.getConnectionManager().save(connection);

		// retrieve file after connection.save() because file may not be there
		// before
		partitionFile = ModelAdapter.getInstance().getFile(pri);
		// clean all markers before next test
		if (partitionFile != null && partitionFile.exists())
			partitionFile.deleteMarkers(null, true, IResource.DEPTH_INFINITE);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(5000);
		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);
	}

	@Override
	protected void tearDown() throws Exception {
		connection.close();
		connection = null;
		component = null;

		partitionFile.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		partitionFile = null;

		// close a potentially remaining dialog
		mShell.enter(mAbbotFactory.key().esc());

		super.tearDown();
	}

	public void testExecuteCommand() {

		try {

			IMarker marker = ModelManager.getMarkerManager().createMarker(component, "dummy", IMarker.SEVERITY_ERROR, "message");
			assertNotNull(partitionFile.findMarker(marker.getId()));

			QuickFixCmd1 cmd = new QuickFixCmd1();
			cmd.run(marker);

			int i = 0;
			while (cmd.dummy == null && i < 15) {
				Robot.delay(300);
				i++;
			}

			assertNotNull(cmd.dummy);
			assertTrue(cmd.dummy.executed);

			marker.delete();
		} catch (Exception e) {
			fail(e);
		}
	}

	public void testExecuteBadCommand() {

		try {

			final IMarker marker = ModelManager.getMarkerManager().createMarker(component, "dummy", IMarker.SEVERITY_ERROR, "message");
			assertNotNull(partitionFile.findMarker(marker.getId()));

			final BadQuickFixCmd cmd = new BadQuickFixCmd();

			LRunnable<Void> runnable = new LRunnable<Void>() {
				public Void run() throws Exception {
					cmd.run(marker);
					return null;
				}
			};

			try {
				mShell.asyncExec(runnable);
			} catch (WidgetException e) {
				fail(e);
			}

			LShell dialog = waitForMessageDialog();
			LButton button = dialog.button().ok();
			dialog.clickOn(button);
			dialog.waitForClosed();

			marker.delete();
		} catch (Exception e) {
			fail(e);
		}
	}

	private LShell waitForMessageDialog() throws Exception {
		try {
			LShell dialogShell = mShell.waitForShowing(mShell.childShell().withName(ExtendedMessageDialog.class.getName()));
			assertNotNull("No Dialog shell found", dialogShell);
			return dialogShell;
		} catch (SWTException e) {
			// TODO [Tests] AbbotBug with disposed widgets: how to avoid it?
			String msg = e.getMessage();
			if (msg != null && msg.contains("disposed")) {
				TestUtil.printInfo(this, TestUtil.exceptionToString(e));
				return null;
			} else
				throw e; // other error
		}
	}

	private final class DummyCommand extends Command {

		public boolean executed = false;

		public DummyCommand(Connection connection) {
			super(connection, "dummy command");
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			executed = true;
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return null;
		}

	}

	private final class QuickFixCmd1 extends QuickfixCommand {

		public DummyCommand dummy;

		@Override
		protected Command getCommand() {
			dummy = new DummyCommand(getConnection());
			RefBaseObject obj = getModelElement();
			assertNotNull(obj);

			IMarker marker = getMarker();
			assertNotNull(marker);

			return dummy;
		}

		public String getLabel() {
			return QuickFixCmd1.class.getName();
		}

	}

	private final class BadQuickFixCmd extends QuickfixCommand {

		@Override
		protected Command getCommand() {
			return null;
		}

		public String getLabel() {
			return BadQuickFixCmd.class.getName();
		}
	}
}