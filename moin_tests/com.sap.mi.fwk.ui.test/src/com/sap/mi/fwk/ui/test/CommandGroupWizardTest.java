package com.sap.mi.fwk.ui.test;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ui.test.wizards.TestCommandGroupWizard;
import com.sap.mi.fwk.ui.wizard.CommandGroupWizard;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Test for {@link CommandGroupWizard}
 * 
 * @author d031150
 */
public class CommandGroupWizardTest extends WebDynproProjectTest {

	private static final String INITIAL_VIEW_NAME = "initialName";

	private static final String DC_NAME = "test/commandgroupwizard";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/cmdgrp");

	private LFactory mAbbotFactory;
	private Connection mConnection;
	private IEditorPart[] mParts;
	private TestCommandGroupWizard mWizard;

	private View mView;

	private LShell mShell;

	public CommandGroupWizardTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mShell = mAbbotFactory.getShell(Display.getDefault());

		mConnection = createConnection();

		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = mConnection.getPartition(partitionMRI);
		if (partition != null) {
			partition.delete();
		}
		partition = mConnection.createPartition(partitionMRI);
		assertNotNull("Partition creation failed", partition);

		Component component = partition.createElement(Component.class);
		mView = partition.createElement(View.class);
		mView.setName(INITIAL_VIEW_NAME);
		component.getViews().add(mView);

		assertConnectionSave(mConnection);
	}

	@Override
	protected void tearDown() throws Exception {
		if (mParts != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					for (IEditorPart part : mParts) {
						if (part != null) {
							part.getSite().getPage().closeEditor(part, false);
						}
					}
					return null;
				}
			});
			// mParts = null;
			for (IEditorPart part : mParts) {
				IEditorInput input = part.getEditorInput();
				IEditorPart part2 = part.getSite().getPage().findEditor(input);
				int count = 0;
				while (part2 != null && count < 10) {
					mAbbotFactory.delay(200);
					part2 = part.getSite().getPage().findEditor(input);
					count++;
				}
			}
			mParts = null;
		}

		mConnection = null;

		// close a potentially remaining dialog
		Keys esc = mAbbotFactory.key().esc();
		getShell().enter(esc).enter(esc).enter(esc);

		super.tearDown();
	}

	public void testCancel() throws Exception {
		{
			String name = "ViewName";
			LShell wizard = openWizard(true, false, false);
			enterViewName(wizard, name);
			wizard.clickOn(wizard.button().cancel());
			wizard.waitForClosed();

			assertEquals("View name must not have changed: " + mView, INITIAL_VIEW_NAME, mView.getName());
			assertNull("Connection must have been closed", mWizard.getConnection());
		}
		// existing connection
		{
			LShell wizard = openWizard(false, false, false);
			wizard.clickOn(wizard.button().cancel());
			wizard.waitForClosed();

			Connection connection = mWizard.getConnection();
			assertNotNull("Connection must not have been closed", connection);
			assertTrue("Connection must be alive", connection.isAlive());
			assertFalse("Command group must have been cancelled: " + connection, connection.getCommandStack()
					.isGroupOpen());
		}
	}

	public void testFinish() throws Exception {
		{
			String name = "ViewName";
			LShell wizard = openWizard(true, false, false);
			enterViewName(wizard, name);
			wizard.clickOn(wizard.button().finish());
			wizard.waitForClosed();

			assertEquals("View name must have changed: " + mView, name, mView.getName());
		}
		// existing connection
		{
			String name = "ViewName_2";
			LShell wizard = openWizard(false, false, true);
			enterViewName(wizard, name);
			wizard.clickOn(wizard.button().finish());
			wizard.waitForClosed();

			Connection connection = mWizard.getConnection();
			assertTrue("Connection must have been modified, but not saved: " + connection, connection.isDirty());
			List<CommandHandle> undoStack = connection.getCommandStack().getUndoStack();
			assertTrue("Command group must have been closed, at least one entry on undo stack expected: " + undoStack,
					undoStack.size() > 0);
		}
	}

	public void testFailingCommand() throws Exception {
		String name = "ViewName";

		{
			LShell wizard = openWizard(true, true, false);
			enterViewName(wizard, name);
			wizard.clickOn(wizard.button().finish());

			LShell shell = getShell();
			LShell errorDialog = shell.waitForShowing(shell.childShell()
					.withName(ExtendedMessageDialog.class.getName()));
			errorDialog.clickOn(errorDialog.button().ok());
			errorDialog.waitForClosed();
		}
		// existing connection
		{
			LShell wizard = openWizard(false, true, false);
			enterViewName(wizard, name);
			wizard.clickOn(wizard.button().finish());

			LShell shell = getShell();
			LShell errorDialog = shell.waitForShowing(shell.childShell()
					.withName(ExtendedMessageDialog.class.getName()));
			errorDialog.clickOn(errorDialog.button().ok());
			errorDialog.waitForClosed();
		}
	}

	public void testNoCommand() throws Exception {
		String name = "ViewName";

		LShell wizard = openWizard(true, false, true);
		enterViewName(wizard, name);
		wizard.clickOn(wizard.button().finish());
		wizard.waitForClosed();

		assertEquals("View name must have changed: " + mView, name, mView.getName());
	}

	public void testConnectionLabelIsSet() throws Exception {
		LShell wizard = openWizard(true, false, false);
		String label = mWizard.getConnection().getLabel();
		assertTrue("Wizards connection must contains the command description: " + label, label.contains(mWizard
				.getDescription()));
		wizard.clickOn(wizard.button().cancel());
		wizard.waitForClosed();
	}

	public void testInCommand() throws Exception {
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				new Command(mConnection, getName()) {
					@Override
					public boolean canExecute() {
						return true;
					}

					@Override
					public Collection<PartitionOperation> getAffectedPartitions() {
						return null;
					}

					@Override
					public void doExecute() {
						try {
							// existing connection
							WizardDialog wizard = getWizard(false, false, true);
							wizard.open();
							wizard.close();
							fail("Wizard must not open when running in a command");
						} catch (RuntimeException expected) {
						}
					}
				}.execute();

				return null;
			}
		});
	}

	private LShell openWizard(final boolean newConnection, final boolean useFailingCommand, final boolean useNoCommand)
			throws WidgetException {

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				final WizardDialog dialog = getWizard(newConnection, useFailingCommand, useNoCommand);
				dialog.open();
				return null;
			}
		};

		mShell.asyncExec(runnable);

		LShell shell = getShell();
		LShell wizard = shell.waitForShowing(shell.childShell().withName(TestCommandGroupWizard.class.getSimpleName()));
		assertNotNull("No Wizard shell found", wizard);
		return wizard;
	}

	private WizardDialog getWizard(final boolean newConnection, final boolean useFailingCommand,
			final boolean useNoCommand) {
		mWizard = new TestCommandGroupWizard();
		mWizard.setUseFailingCommand(useFailingCommand);
		mWizard.setUseNoCommand(useNoCommand);
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (newConnection) {
			mWizard.init(workbench, getProject());
			mWizard.setSelection(new StructuredSelection(mView));
		} else {
			mWizard.init(workbench, new StructuredSelection(mView));
		}

		Shell shell = workbench.getActiveWorkbenchWindow().getShell();
		final WizardDialog dialog = new WizardDialog(shell, mWizard) {
			@Override
			protected void configureShell(Shell shell) {
				super.configureShell(shell);
				shell.setData("name", mWizard.getClass().getSimpleName());
			}
		};
		return dialog;
	}

	private void enterViewName(LShell wizard, String name) throws WidgetException {
		LText text = wizard.text().withName("TestWizardPage.name");
		text.setFocus();
		wizard.enter(name);
	}

	private LShell getShell() {
		return mAbbotFactory.getShell(Display.getDefault());
	}

}