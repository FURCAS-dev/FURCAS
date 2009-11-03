package com.sap.mi.fwk.ui.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

import abbot.WaitTimedOutError;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LCondition;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTable;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.controller.Controller;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.AssignElementsDialog;
import com.sap.mi.fwk.ui.internal.preferences.EditorSavePreferencesHelper;
import com.sap.mi.fwk.ui.test.editors.TestEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Tests {@link ConnectionManagerUI} class
 * 
 * @author d031150
 */
public class ConnectionManagerUITest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/connectionmanager/ui";
	private static final IPath PARTITION_PATH = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/conmgrui/Partition").addFileExtension(
			PARTITION_EXTENSION_WEBDYNPRO);
	private static final IPath PARTITION_PATH_2 = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/conmgrui/newPartition").addFileExtension(
			PARTITION_EXTENSION_WEBDYNPRO);

	private Connection mConnection;
	private Component mComponent;
	private View mView;
	private ModelPartition mPartition;

	private LFactory mAbbotFactory;
	private IEditorPart mPart;
	private LShell mShell;

	public ConnectionManagerUITest() {
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

		mConnection = createConnection();

		// clean up all partitions
		Collection<PRI> partitions = PartitionService.getInstance().getPartitions(mConnection, getProject());
		for (PRI pri : partitions) {
			ModelPartition part = mConnection.getPartition(pri);
			if (part != null)
				part.delete();
		}

		PRI partitionMRI = ModelManager.getPartitionService().getPRI(getProject(), PARTITION_PATH);
		mPartition = mConnection.createPartition(partitionMRI);
		assertNotNull("Partition creation failed", mPartition);

		mComponent = mPartition.createElement(Component.CLASS_DESCRIPTOR);
		mComponent.setName("testComponent");

		RefClass viewClass = mConnection.getPackage(ViewPackage.PACKAGE_DESCRIPTOR).getView();
		mView = (View) viewClass.refCreateInstance( );
		mView.setName("view1");
		mComponent.getViews().add(mView);

		UielementContainer container = mPartition.createElement(TransparentContainer.CLASS_DESCRIPTOR);
		container.setName("RootElement");
		mView.setRootUielementContainer(container);

		ModelManager.getConnectionManager().save(mConnection);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mShell = mAbbotFactory.getShell(Display.getDefault());
	}

	@Override
	protected void tearDown() throws Exception {
		// close a potentially remaining dialogs
		Keys esc = mAbbotFactory.key().esc();
		mShell.enter(esc).enter(esc).enter(esc);

		if (mPart != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					mPart.getSite().getPage().closeEditor(mPart, false);
					return null;
				}
			});
			// mPart = null;

			IEditorInput input = mPart.getEditorInput();
			IEditorPart part2 = mPart.getSite().getPage().findEditor(input);
			int count = 0;
			while (part2 != null && count < 10) {
				mAbbotFactory.delay(200);
				part2 = mPart.getSite().getPage().findEditor(input);
				count++;
			}
		}
		mPart = null;

		super.tearDown();
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		// Nearly all tests save connections and therefore leave a persistently
		// changed state behind, which could influence the next test.
		return true;
	}

	public void testGetOrCreateDefaultConnectionAsync() throws Exception {
		// hide explorer so that its tree does not trigger the connection
		// creation
		PDEUtil.hideView("org.eclipse.ui.navigator.ProjectExplorer");

		// if there is a connection, close it
		Connection defConnection = ConnectionManager.getInstance().getDefaultConnection(getProject(), false);
		if (defConnection != null) {
			defConnection.close();
			defConnection = ConnectionManager.getInstance().getDefaultConnection(getProject(), false);
			assertNull("Default connection probably created from some tool. Test is not stable.", defConnection);
		}

		// use AtomicReference since data is written from UI thread and read
		// from test thread
		final AtomicReference<Connection> connectionAsync = new AtomicReference<Connection>();
		final IRunnableWithConnection followUp = new IRunnableWithConnection() {
			public void run(Connection connection, IProgressMonitor monitor) {
				connectionAsync.set(connection);
			}
		};
		Connection connectionSync = mShell.syncExec(new LRunnable<Connection>() {
			public Connection run() throws Exception {
				Connection connection = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(getProject(), followUp);
				return connection;
			}
		});
		assertNull("Null as connection expected from getOrCreateDefaultConnectionAsync", connectionSync);

		mShell.wait(new LCondition() {
			public boolean test() throws Exception {
				return connectionAsync.get() != null;
			}
		});

		connectionSync = mShell.syncExec(new LRunnable<Connection>() {
			public Connection run() throws Exception {
				Connection connection = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(getProject(), null);
				return connection;
			}
		});
		assertNotNull("Connection expected from getOrCreateDefaultConnectionAsync", connectionSync);
	}

	public void testCreateConnectionAsync() throws Exception {
		// use AtomicReference since data is written from UI thread and read
		// from test thread
		final AtomicReference<Connection> connectionAsync = new AtomicReference<Connection>();
		final IRunnableWithConnection followUp = new IRunnableWithConnection() {
			public void run(Connection connection, IProgressMonitor monitor) {
				connectionAsync.set(connection);
			}
		};
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ConnectionManagerUI.getInstance().createConnectionAsync(getProject(), followUp);
				return null;
			}
		});

		mShell.wait(new LCondition() {
			public boolean test() throws Exception {
				return connectionAsync.get() != null;
			}
		});
		connectionAsync.get().close();
	}

	public void testSave() throws Exception {
		Collection<RefObject> transientObjects = createNullAndTransientObjects();

		final Future<IStatus> result = saveAsync(mConnection);

		LShell dialog = waitForSaveDialog(mShell);

		// select partition we want to check later
		selectPartitionItem(dialog, mPartition.getPri());
		pressOk(dialog);

		mShell.wait(new LCondition() {
			public boolean test() throws Exception {
				return result.get() != null;
			}
		});

		Collection<Partitionable> elements = mPartition.getElements();
		assertTrue("Objects should have been assigned to partition " + mPartition + ". Elements: " + elements, elements
				.containsAll(transientObjects));
		assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
	}

	/*
	 * this time only use transient objects to also cover special handling for
	 * them
	 */
	public void testSave_TransientObjectsOnly() throws Exception {
		RefObject transientObject = createTransientObject(mComponent);

		{
			final Future<IStatus> result = saveAsync(mConnection, getProject());

			LShell dialog = waitForSaveDialog(mShell);
			pressCancel(dialog);
			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return result.get() != null;
				}
			});

			assertTrue("Connection must be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
		}
		{
			final Future<IStatus> result = saveAsync(mConnection, getProject());

			LShell dialog = waitForSaveDialog(mShell);

			// select partition we want to check later
			selectPartitionItem(dialog, mPartition.getPri());
			pressOk(dialog);

			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return result.get() != null;
				}
			});

			Collection<Partitionable> elements = mPartition.getElements();
			assertTrue("Object should have been assigned to partition " + mPartition + ". Elements: " + elements, elements
					.contains(transientObject));
			assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
		}
	}

	public void testSave_Cancel() throws Exception {
		createNullAndTransientObjects();

		saveAsync(mConnection, getProject());

		LShell dialog = waitForSaveDialog(mShell);
		pressCancel(dialog);

		assertTrue("Connection must be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
	}

	public void testSave_Clear() throws Exception {
		createNullAndTransientObjects();

		final Future<IStatus> result = saveAsync(mConnection, getProject());

		LShell dialog = waitForSaveDialog(mShell);
		pressClear(dialog);
		mShell.wait(new LCondition() {
			public boolean test() throws Exception {
				return result.get() != null;
			}
		});

		assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
	}

	public void testSave_NewPartition() throws Exception {
		createNullAndTransientObjects();

		final Future<IStatus> result = saveAsync(mConnection, getProject());

		LShell dialog = waitForSaveDialog(mShell);
		// open new dialog
		pressNew(dialog);
		LShell newDialog = waitForNewDialog(dialog);
		LText text = newDialog.text().withName(AssignElementsDialog.TEXT_NAME_PARTITION_INPUT);
		LButton okButton = newDialog.button().ok();

		// negative
		text.setText(PARTITION_PATH.toString());
		assertFalse("Partition must exist: " + PARTITION_PATH, okButton.isEnabled());

		// positive
		text.setText(PARTITION_PATH_2.toString());
		assertTrue("Partition must not exist: " + PARTITION_PATH_2, okButton.isEnabled());

		pressOk(newDialog);
		pressOk(dialog);

		mShell.wait(new LCondition() {
			public boolean test() throws Exception {
				return result.get() != null;
			}
		});

		Collection<PRI> partitions = PartitionService.getInstance().getPartitions(mConnection, getProject());
		for (PRI pri : partitions) {
			String priPath = pri.getPartitionName();
			if (priPath.equals(PARTITION_PATH_2.toString())) {
				ModelPartition newPart = mConnection.getPartition(pri);
				Collection<Partitionable> elements = newPart.getElements();
				assertFalse("Objects should have been assigned to new partition " + newPart, elements.isEmpty());
				assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
				return;
			}
		}

		fail("No partition " + PARTITION_PATH_2 + " found in " + partitions);
	}

	public void testSave_NoDialog() throws Exception {
		saveAsync(mConnection, getProject());

		try {
			LShell dialog = mShell.waitForShowing(mShell.childShell().withName(AssignElementsDialog.class.getSimpleName()));
			Collection<ModelPartition> dirtyPartitions = mConnection.getPartitionsToBeSaved();
			fail("Dialog " + dialog + " should not be raised for clean connection: " + dirtyPartitions);
		} catch (WaitTimedOutError expected) {
		}
	}

	public void testSave_Editor() throws Exception {
		mPart = mShell.syncExec(new LRunnable<IEditorPart>() {
			public IEditorPart run() throws Exception {
				IEditorPart part = TestUtil.openModelEditor(mView, null);
				assertNotNull("Editor must be created for " + mView, part);
				assertTrue("Editor must be open: " + part, part.getEditorSite().getPage().isPartVisible(part));
				return part;
			}
		});

		final ModelEditorManager editorManager = ModelManagerUI.getEditorManager();
		final IModelEditor editor = editorManager.findModelEditor(mPart);

		// make editor dirty by creating a view with editor's connection
		View viewOfEditor = (View) mPart.getEditorInput().getAdapter(RefObject.class);
		View view = (View) viewOfEditor.refClass().refCreateInstance( );
		view.setName("newView");

		saveAsync(editor.getConnection(), getProject());

		mAbbotFactory.delay(2000);

		LShell dialog = waitForSaveDialog(mShell);
		// select partition we want to check later
		selectPartitionItem(dialog, mPartition.getPri());
		pressOk(dialog);

		mAbbotFactory.delay(4000);

		Collection<Partitionable> elements = mPartition.getElements();
		assertTrue("View " + view + " should have been assignend to partition " + mPartition, elements.contains(view));
		assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
	}

	public void testSave_ifNecessaryWithEditor() throws Exception {
		mPart = mShell.syncExec(new LRunnable<IEditorPart>() {
			public IEditorPart run() throws Exception {
				IEditorPart part = TestUtil.openModelEditor(mView, null);
				assertNotNull("Editor must be created for " + mView, part);
				assertTrue("Editor must be open: " + part, part.getEditorSite().getPage().isPartVisible(part));
				return part;
			}
		});

		final ModelEditorManager editorManager = ModelManagerUI.getEditorManager();
		final IModelEditor editor = editorManager.findModelEditor(mPart);

		// make editor dirty by creating a view with editor's connection
		View viewOfEditor = (View) mPart.getEditorInput().getAdapter(RefObject.class);
		View view = (View) viewOfEditor.refClass().refCreateInstance( );
		view.setName("newView");

		final FutureWithAtomicReference<IStatus> result = new FutureWithAtomicReference<IStatus>();
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IStatus r = ModelManagerUI.getConnectionManagerUI().saveIfNecessary(editor.getConnection(), null);
				result.set(r);
				return null;
			}
		});

		mAbbotFactory.delay(2000);

		// must not save since connection belongs to editor
		assertTrue("Connection must be dirty, no save took place", editor.getConnection().isDirty());
	}

	public void testSave_ifNecessaryWithoutEditor() throws Exception {

		
		RefClass viewClass = mConnection.getPackage(ViewPackage.PACKAGE_DESCRIPTOR).getView();
		mView = (View) viewClass.refCreateInstance( );
		mView.setName("view2");
		mComponent.getViews().add(mView);

		final FutureWithAtomicReference<IStatus> result = new FutureWithAtomicReference<IStatus>();
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IStatus r = ModelManagerUI.getConnectionManagerUI().saveIfNecessary(mConnection, null);
				result.set(r);
				return null;
			}
		});

		mAbbotFactory.delay(2000);

		// must save since no editor holds the connection
		assertTrue("Connection must not be dirty, save must take place", !mConnection.isDirty());
	}

	public void testSave_NonUiThread() throws Exception {
		try {
			IStatus result = ModelManagerUI.getConnectionManagerUI().save(mConnection, getProject(), null);
			fail("Exception expected for non UI-thread call. Result: " + result);
		} catch (RuntimeException expected) {
		}
	}

	public void testSave_NoProject() throws Exception {
		Connection transientConnection = ConnectionManager.getInstance().createTransientConnection();
		try {
			try {
				IStatus result = ModelManagerUI.getConnectionManagerUI().save(transientConnection, null);
				fail("Exception expected for transient connection (no project scope). Result: " + result);
			} catch (RuntimeException expected) {
			}
			try {
				IStatus result = ModelManagerUI.getConnectionManagerUI().save(transientConnection, null, null);
				fail("Exception expected for transient connection (no project scope). Result: " + result);
			} catch (RuntimeException expected) {
			}
		} finally {
			transientConnection.close();
		}
	}

	public void testSave_ClosedProject() throws Exception {
		final IProject project = getProject();
		project.close(null);
		
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ModelManagerUI.getConnectionManagerUI().save(mConnection, null);
				return null;
			}
		});
		LShell dialogShell = mShell.waitForShowing(mShell.childShell().withName(com.tssap.util.ui.dialog.ExtendedMessageDialog.class.getName()));
		assertNotNull("No Dialog shell found", dialogShell);
		dialogShell.close();
	}

	public void testSave_NotPossible() throws Exception {
		mComponent.setName("newValue");

		// Aim is to provoke a PartitionsNotSavedException so that save fails.
		// For this we set the partition file readonly.
		IFile file = ModelAdapterUI.getInstance().getFile(mComponent);
		ResourceAttributes resAtts = file.getResourceAttributes();
		resAtts.setReadOnly(true);
		file.setResourceAttributes(resAtts);

		try {
			saveAsync(mConnection, getProject());

			LShell dialog = mShell.childShell().withText("Modification Not Possible"); // TODO: set widget name!!!
			mShell.waitForShowing(dialog);
			pressCancel(dialog);
			
			dialog = mShell.childShell().withName(ExtendedMessageDialog.class.getName());
			mShell.waitForShowing(dialog);
			pressOk(dialog);

			assertTrue("Connection must be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
		} finally {
			resAtts.setReadOnly(false);
			file.setResourceAttributes(resAtts);
		}
	}

	public void testSaveAll_Editors() throws Exception {
		IProject project = getProject();

		// make a connection dirty that is not used by any editor
		RefClass viewClass = mConnection.getPackage(ViewPackage.PACKAGE_DESCRIPTOR).getView();
		viewClass.refCreateInstance( );

		// clear any "Save editor without confirmation" preference
		EditorSavePreferencesHelper.getInstance().setEditorSaveState(true);

		// open an editor
		TestEditor editor = mShell.syncExec(new LRunnable<TestEditor>() {
			public TestEditor run() throws Exception {
				TestEditor editor = TestEditor.open(mView);
				return editor;
			}
		});
		View editorView = (View) editor.getEditorInput().getAdapter(View.class);
		editorView.setName("newValue");

		// Cancel save
		{
			final Future<IStatus> result = saveAllAsync(project);

			LShell dialog = ModelEditorManagerTest.waitForSaveConfirmation(mShell);
			pressCancel(dialog);

			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return result.get() != null;
				}
			});

			IStatus status = result.get();
			assertNotNull(status);
			assertEquals("Cancellation expected: " + status, IStatus.CANCEL, status.getSeverity());
		}

		// Confirm editor save, cancel other connection save
		{
			final Future<IStatus> result = saveAllAsync(project);

			LShell confirmation = ModelEditorManagerTest.waitForSaveConfirmation(mShell);
			pressOk(confirmation);
			final Connection editorConnection = ModelAdapterUI.getInstance().getConnection(editorView);

			try {
				mShell.wait(new LCondition() {
					public boolean test() throws Exception {
						return !editorConnection.isDirty();
					}
				});
			} catch (WaitTimedOutError e) {
				fail("Connection must not be dirty: " + editorConnection.getPartitionsToBeSaved());
			}

			// save dialog is shown since mConnection, which is not used by any
			// editor, is also dirty
			LShell dialog = waitForSaveDialog(mShell);
			pressCancel(dialog);

			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return result.get() != null;
				}
			});

			// now the result status from saveAll is available
			IStatus status = result.get();
			assertNotNull(status);
			assertEquals("Cancellation expected: " + status, IStatus.CANCEL, status.getSeverity());
			assertTrue("Connection must be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
		}

		// Confirm other connection save
		{
			final Future<IStatus> result = saveAllAsync(project);

			LShell dialog = waitForSaveDialog(mShell);
			pressOk(dialog);

			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return result.get() != null;
				}
			});

			// now the result status from saveAll is available
			IStatus status = result.get();
			assertNotNull(status);
			assertEquals("Ok expected: " + status, IStatus.OK, status.getSeverity());
			assertFalse("Connection must not be dirty: " + mConnection.getPartitionsToBeSaved(), mConnection.isDirty());
		}
	}

	public void testSaveAll_NoDialog() throws Exception {
		createConnection();
		createConnection();

		Future<IStatus> result = saveAllAsync(getProject());
		try {
			LShell dialog = waitForSaveDialog(mShell);
			Collection<ModelPartition> dirtyPartitions = mConnection.getPartitionsToBeSaved();
			fail("Dialog " + dialog + " should not be raised for clean connection: " + dirtyPartitions);
		} catch (WaitTimedOutError expected) {
			assertTrue(result.isDone());
			IStatus status = result.get();
			assertTrue("Ok status expected: " + status, status.isOK());
		}
	}

	public void testSaveAll_NonUiThread() throws Exception {
		try {
			IStatus result = ModelManagerUI.getConnectionManagerUI().saveAll(getProject(), null);
			fail("Exception expected for non UI-thread call. Result:" + result);
		} catch (RuntimeException expected) {
		}
	}

	/**
	 * Checks that dialog does not grow excessively if there are many unassigned
	 * elements to display. Instead it's supposed to show scrollbars.
	 */
	public void testSave_ManyUnassignedDialogSize() throws Exception {
		RefClass viewClass = mView.refClass();
		final Connection connection = ((Partitionable) viewClass).get___Connection();

		final int elementCount = 15;
		for (int i = 0; i < elementCount; i++) {
			final View newView = (View) viewClass.refCreateInstance( );
			newView.setName("newView_" + i);
		}

		saveAsync(connection, getProject());

		LShell dialog = waitForSaveDialog(mShell);

		Point size = dialog.getSize();
		// assumed increasement for each additional element
		int heightFactor = 48;
		int maxHeight = elementCount * heightFactor;
		assertTrue("Dialog height must not grow for many unassigned elements: " + size.y + " > " + maxHeight, size.y <= maxHeight);
		pressCancel(dialog);
	}

	public void testSave_PartitionInfo() throws Exception {
		RefClass viewClass = mView.refClass();
		final Connection connection = ((Partitionable) viewClass).get___Connection();

		final int elementCount = 2;
		for (int i = 0; i < elementCount; i++) {
			final View newView = (View) viewClass.refCreateInstance( );
			newView.setName("newView_" + i);
		}

		final String infoExpected = "View: name = newView_0" + System.getProperty("line.separator") + "View: name = newView_1";

		saveAsync(connection, getProject());

		LShell dialog = waitForSaveDialog(mShell);
		LText text = dialog.text().withName(AssignElementsDialog.TEXT_NAME_ELEMENTS);

		String infoActual = text.getText();
		assertEquals("Partition information differs", infoExpected, infoActual);
		pressCancel(dialog);
	}

	private Future<IStatus> saveAsync(final Connection connection, final IProject project) throws Exception {
		final FutureWithAtomicReference<IStatus> result = new FutureWithAtomicReference<IStatus>();
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IStatus r = ModelManagerUI.getConnectionManagerUI().save(connection, project, null);
				result.set(r);
				return null;
			}
		});
		return result;
	}

	private Future<IStatus> saveAsync(final Connection connection) throws Exception {
		final FutureWithAtomicReference<IStatus> result = new FutureWithAtomicReference<IStatus>();
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IStatus r = ModelManagerUI.getConnectionManagerUI().save(connection, null);
				result.set(r);
				return null;
			}
		});
		return result;
	}

	private Future<IStatus> saveAllAsync(final IProject project) throws Exception {
		final FutureWithAtomicReference<IStatus> result = new FutureWithAtomicReference<IStatus>();
		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IStatus r = ModelManagerUI.getConnectionManagerUI().saveAll(project, null);
				result.set(r);
				return null;
			}
		});
		return result;
	}

	static LShell waitForSaveDialog(LShell parent) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName(AssignElementsDialog.SHELL_NAME));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	private static LShell waitForNewDialog(LShell parent) throws Exception {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName(AssignElementsDialog.SHELL_NAME_PARTITION_INPUT));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	protected static final LShell waitForSaveConfirmation(LShell parent) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName("ModelEditorManager.Dialog.ConfirmSave"));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	static void pressOk(LShell dialog) throws Exception {
		LButton button = dialog.button().ok();
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	static void pressYes(LShell dialog) throws Exception {
		LButton button = dialog.button().yes();
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	private void pressCancel(LShell dialog) throws Exception {
		LButton button = dialog.button().cancel();
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	private void pressClear(LShell dialog) throws Exception {
		LButton button = dialog.button().withName(AssignElementsDialog.BUTTON_NAME_CLEAR);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	private void pressNew(LShell dialog) throws Exception {
		LButton button = dialog.button().withName(AssignElementsDialog.BUTTON_NAME_NEW);
		dialog.clickOn(button);
	}

	private void selectPartitionItem(LShell dialog, PRI pri) throws Exception {
		LTable table = dialog.table().withName(AssignElementsDialog.TABLE_NAME_PARTITIONS);
		LItem item = table.item().withText(pri.getPartitionName());
		mAbbotFactory.setTryMultipleClicks(false);
		try {
			dialog.clickOn(item);
		} finally {
			mAbbotFactory.setTryMultipleClicks(true);
		}
	}

	private Collection<RefObject> createNullAndTransientObjects() {
		Collection<RefObject> objects = new ArrayList<RefObject>();
		final View view = (View) mView.refClass().refCreateInstance( );
		view.setName("viewInNullPartition");
		objects.add(view);

		objects.add(createTransientObject(mComponent));

		return objects;
	}

	private RefObject createTransientObject(Component persistentComponent) {
		ModelPartition transientPartition = mConnection.getOrCreateTransientPartition("transientPartition");
		final Controller transientController = transientPartition.createElement(Controller.class);
		transientController.setName("transientController");
		persistentComponent.setComponentController(transientController);

		return transientController;
	}

	static final class FutureWithAtomicReference<T> implements Future<T> {
		private final AtomicReference<T> ref;

		private FutureWithAtomicReference() {
			this.ref = new AtomicReference<T>();
		}

		public boolean cancel(boolean mayInterruptIfRunning) {
			return false;
		}

		public T get() throws InterruptedException, ExecutionException {
			return ref.get();
		}

		public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			return get();
		}

		public boolean isCancelled() {
			return false;
		}

		public boolean isDone() {
			return ref.get() != null;
		}

		public void set(T newValue) {
			this.ref.set(newValue);
		}
	}

}
