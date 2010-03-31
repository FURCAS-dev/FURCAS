package com.sap.mi.fwk.ui.test;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.prefs.BackingStoreException;

import abbot.WaitTimedOutError;

import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.commands.CommandManagerCore;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.preferences.EditorSaveConstants;
import com.sap.mi.fwk.ui.test.editors.TestEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;

/**
 * Test for {@link CommandManagerCore} and {@link CommandManager}
 * 
 * @author d031150
 */
public class CommandManagerTest extends CommandManagerTestSmoke {

	private static final String DC_NAME = "test/cmdmanager";

	public CommandManagerTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// each test should start on a clean project
		setDeleteProjectOnTearDown();
	}

	public void testOpenGroupTwice() throws Exception {
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				TestEditor editor = TestEditor.open(mView);
				mParts.add(editor);
				Connection connection = editor.getModelEditor().getWorkingConnection();
				connection.getCommandStack().openGroup("Test command group 1");
				connection.getCommandStack().openGroup("Test command group 2");

				CommandHandle handle = editor.getModelEditor().getWorkingConnection().getCommandStack().closeGroup();
				assertNull("Command handle must be null if no jmi call has been executed", handle);
				handle = editor.getModelEditor().getWorkingConnection().getCommandStack().closeGroup();
				assertNull("Command handle must be null if no jmi call has been executed", handle);
				return null;
			}
		});
	}

	public void testCloseWoOpen() throws Exception {
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				TestEditor editor = TestEditor.open(mView);

				mParts.add(editor);
				editor.getModelEditor().getWorkingConnection().getCommandStack().openGroup("Test command group 1");

				CommandHandle handle = editor.getModelEditor().getWorkingConnection().getCommandStack().closeGroup();
				assertNull("Command handle must be null if no jmi call has been executed", handle);
				try {
					handle = editor.getModelEditor().getWorkingConnection().getCommandStack().closeGroup();
					fail("Must throw exception !");
				} catch (IllegalStateException e) {
				}
				return null;
			}
		});
	}

	public void testGroupWithJmiCall() throws Exception {
		final Connection connection = createConnection();
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				View newView = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);
				connection.getCommandStack().openGroup("Test command group");

				// newView.setName("The new view name");

				SetNameCommand cmd = new SetNameCommand(newView, "new name");
				cmd.getConnection().getCommandStack().execute(cmd);
				CommandHandle handle = connection.getCommandStack().closeGroup();
				assertNotNull("Command handle must not be null if a jmi call has been executed", handle);
				return null;
			}
		});
	}

	public void testOpenGroupNoSaveForCallingEditor() throws Exception {
		final TestEditor editor = openEditor(mView);

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				// make dirty
				Connection connection = editor.getModelEditor().getWorkingConnection();
				SetNameCommand cmd = new SetNameCommand(ModelAdapterUI.getInstance().resolveInConnection(mView, connection), "new name");
				cmd.getConnection().getCommandStack().execute(cmd);

				// open new group - this must not cause the editor to be saved
				connection.getCommandStack().openGroup("Test command group");
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}
		// save dialog must not be shown for calling editor
		LShell dialogShell = null;
		try {
			dialogShell = waitForSaveConfirmation(mShell);
			fail("Save dialog must not be shown for calling editor: " + dialogShell + ". Editor: " + editor);
		} catch (WaitTimedOutError expected) {
			Connection connection = editor.getModelEditor().getWorkingConnection();
			assertTrue("Editors connection must be dirty: " + connection, ConnectionManager.getInstance().isDirty(connection));
		} finally {
			if (dialogShell != null) // close potentially opened
				// dialog
				dialogShell.enter(mAbbotFactory.key().esc());
			// editor is closed in tearDown
		}
	}

	public void testExecuteNoEditorsNoLock() {
		Connection connection = createConnection();
		View newView = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);
		SetNameCommand cmd = new SetNameCommand(newView, "the name");
		CommandHandle cmdHnd = null;
		try {
			cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
		} catch (Exception e) {
			fail(e);
		}
		assertNotNull(cmdHnd);
	}

	public void testOpenGroupNoDescription() {
		Connection connection = createConnection();
		connection.getCommandStack().openGroup(null);
		SetNameCommand cmd = new SetNameCommand(ModelAdapterUI.getInstance().resolveInConnection(mView, connection), "new name");
		CommandHandle cmdHnd = null;
		try {
			cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
		} catch (Exception e) {
			fail(e);
		}
		assertNotNull(cmdHnd);
		connection.getCommandStack().setGroupDescription(cmd.getDescription());
		CommandHandle handle = connection.getCommandStack().closeGroup();
		String description = handle.getDescription();
		assertNotNull("Group description must not be null", description);
	}

	public void testOpenGroupWAffectedParts() throws Exception {
		final TestEditor editor = openEditor(mView);

		final Connection connection2 = ModelManager.getConnectionManager().createConnection(getProject());

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				// make dirty
				Connection connection = editor.getModelEditor().getWorkingConnection();
				SetNameCommand cmd = new SetNameCommand(ModelAdapterUI.getInstance().resolveInConnection(mView, connection), "new name");
				CommandHandle cmdHnd = null;
				try {
					cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
				} catch (Exception e) {
					fail(e);
				}
				assertNotNull(cmdHnd);
				// open new group - this must not cause the editor to be saved

				PRI pri = ((Partitionable) mComponent2).get___Partition().getPri();
				PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, pri);

				// this would usually bring up the save dialog. but since
				// affected partitions are handed over
				// the dialog must not appear
				CommandManager.getInstance().prepareExecution(connection2, Collections.singleton(editOperation));
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}
		// save dialog must not be shown for calling editor
		LShell dialogShell = null;
		try {
			dialogShell = waitForSaveConfirmation(mShell);
			fail("Save dialog must not be shown for calling editor: " + dialogShell + ". Editor: " + editor);
		} catch (WaitTimedOutError expected) {
			Connection connection = editor.getModelEditor().getWorkingConnection();
			assertTrue("Editors connection must be dirty: " + connection, ConnectionManager.getInstance().isDirty(connection));
		} finally {
			if (connection2.getCommandStack().isGroupOpen()) {
				connection2.getCommandStack().closeGroup();
			}
			connection2.close();

			if (dialogShell != null) // close potentially opened
				// dialog
				dialogShell.enter(mAbbotFactory.key().esc());
			// editor is closed in tearDown
		}
	}


	public void testPrepareExecution() throws Exception {
		
		enableEditorSaveDialog();
		
		// creating test data
		View newView1 = mView.get___Connection().createElement(View.CLASS_DESCRIPTOR);
		newView1.setName("View1");
		mComponent2.getViews().add(newView1);
		View newView2 = mView.get___Connection().createElement(View.CLASS_DESCRIPTOR);
		newView2.setName("View2");
		mComponent2.getViews().add(newView2);
		mView.get___Connection().save();

		{
			TestEditor editor = openEditor(newView1);
			Connection connection = editor.getWorkingConnection();
			View view = ModelAdapterUI.getInstance().resolveInConnection(newView1, connection);
			SetNameCommand cmd = new SetNameCommand(view, "View1Renamed");
			CommandHandle cmdHnd = null;
			cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
			assertNotNull(cmdHnd);
			assertTrue("Connection of first view must be dirty: " + connection.getPartitionsToBeSaved(), connection.isDirty());
		}
		{
			// issue command in the view in a second connection so that first
			// one needs to be saved
			TestEditor editor = openEditor(newView2);
			final Connection connection = editor.getWorkingConnection();
			View view = ModelAdapterUI.getInstance().resolveInConnection(newView2, connection);
			final SetNameCommand cmd = new SetNameCommand(view, "View2Renamed");
			final Exception[] exceptions = new Exception[1];
			
			mShell.asyncExec(new LRunnable<Void>() {
				public Void run() {
					try {
						CommandHandle cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
						assertNotNull(cmdHnd);
					} catch (Exception e) {
						exceptions[0] = e;
					}
					return null;
				}
			});
			if (exceptions[0] != null) {
				fail(exceptions[0]);
			}
		}
		LShell dialog = null;
		try {
			dialog = waitForSaveConfirmation(mShell);
			pressOk(dialog);
		} catch (Exception e) {
			if (dialog != null) {
				dialog.enter(mAbbotFactory.key().esc());
			}
		}
	}

	private void enableEditorSaveDialog() throws BackingStoreException {
		// ensure import dialog is raised by default
		IEclipsePreferences nodeMmDeployPlugin = new InstanceScope().getNode(MiFwkUIPlugin.PLUGIN_ID);
		nodeMmDeployPlugin.putBoolean(EditorSaveConstants.SHOW_EDITOR_SAVE_DIALOG, true);
		nodeMmDeployPlugin.flush();
	}

	private TestEditor openEditor(final View view) throws WidgetException {
		LShell shell = mAbbotFactory.getShell(Display.getDefault());
		final TestEditor editor = shell.syncExec(new LRunnable<TestEditor>() {
			public TestEditor run() throws Exception {
				TestEditor editor = TestEditor.open(view);
				mParts.add(editor);
				return editor;
			}
		});
		return editor;
	}

	private static class SetNameCommand extends Command {
		private final View view;

		private final String name;

		SetNameCommand(View view, String name) {
			super(((Partitionable) view).get___Connection(), name);
			this.view = view;
			this.name = name;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			view.setName(name);
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			PRI pri = ((Partitionable) view).get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, pri);
			return Collections.singleton(editOperation);
		}
	}
}