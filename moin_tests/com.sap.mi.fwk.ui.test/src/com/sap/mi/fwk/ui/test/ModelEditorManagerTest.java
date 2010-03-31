package com.sap.mi.fwk.ui.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CloseResourceAction;
import org.eclipse.ui.part.FileEditorInput;

import abbot.WaitTimedOutError;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LCondition;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.LWidget;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.Window;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Uielement;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.TextPool;
import com.sap.mi.fwk.ui.internal.TextPool.UIText;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.internal.preferences.EditorSaveInitializer;
import com.sap.mi.fwk.ui.internal.preferences.EditorSavePreferencesHelper;
import com.sap.mi.fwk.ui.test.CommandManagerTestSmoke.CreateButtonCommand;
import com.sap.mi.fwk.ui.test.editors.SimpleViewEditor;
import com.sap.mi.fwk.ui.test.editors.TestEditor;
import com.sap.mi.fwk.ui.test.editors.TestEditorInput;
import com.sap.mi.fwk.ui.test.editors.ViewEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link ModelEditorManager}
 * 
 * @author d024127
 * @author d031150
 */
public class ModelEditorManagerTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modeleditor/manager";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/edmgr");

	private Component mComponent;
	private View mView;
	private View mView2;
	private LFactory mAbbotFactory;
	private Display mDisplay;
	private LShell mShell;
	private Set<IEditorPart> mParts;

	private Component mComponent2;

	private ModelEditorManager mManager;

	private IProject mProject2;

	private Window mWindow;

	public ModelEditorManagerTest() {
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

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);

		mParts = new HashSet<IEditorPart>(4);

		Connection connection = createConnection();

		PRI pri1 = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition1 = connection.getPartition(pri1);
		if (partition1 != null && partition1.isAlive() && connection.partitionExists(pri1))
			try {
				partition1.delete();
			} catch (Exception e) {

			}
		partition1 = connection.createPartition(pri1);

		PRI pri2 = getPri(getProject(), PARTITION_FOLDER.append("Partition2"));
		ModelPartition partition2 = connection.getPartition(pri2);
		if (partition2 != null)
			try {
				partition2.delete();
			} catch (Exception e) {

			}
		partition2 = connection.createPartition(pri2);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		mComponent = (Component) compPackage.getComponent().refCreateInstance();
		mComponent.setName("testComponent");
		partition1.assignElement((Partitionable) mComponent);
		mComponent2 = (Component) compPackage.getComponent().refCreateInstance();
		mComponent2.setName("testComponent2");
		partition2.assignElement((Partitionable) mComponent2);

		// two Views
		RefClass viewClass = compPackage.getView().getView();
		mView = (View) viewClass.refCreateInstance();
		mComponent.getViews().add(mView);
		mView.setName("testView");
		UielementPackage uielementPackage = compPackage.getView().getUielement();
		TransparentContainer container = (TransparentContainer) uielementPackage.getTransparentContainer()
				.refCreateInstance();
		mView.setRootUielementContainer(container);
		Button button = (Button) uielementPackage.getButton().refCreateInstance();
		container.getChildren().add(button);

		mView2 = (View) viewClass.refCreateInstance();
		mComponent2.getViews().add(mView2);
		mView2.setName("testView2");

		mWindow = (Window) compPackage.getWindow().refCreateInstance();
		mComponent.getWindows().add(mWindow);
		mWindow.setName("Window");

		connection.save();

		mManager = ModelEditorManager.getInstance();
	}

	@Override
	protected void tearDown() throws Exception {
		// close potentially remaining dialogs
		Keys esc = mAbbotFactory.key().esc();
		mShell.enter(esc).enter(esc).enter(esc);

		closeOpenedEditors();

		if (mProject2 != null)
			TestUtil.deleteLocalMoinDCProject(mProject2);

		super.tearDown();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	public void testOpenEditor() throws Exception {
		TestEditor openEditor = openTestEditor(mView);
		assertNotNull("Editor must have opened", openEditor);

		{
			TestEditor editor = openTestEditor(mView);
			assertEquals("Only one editor must have opened for the same object", openEditor, editor);
		}
		{
			IEditorPart editor = openEditor(mView, "someInvalidId", null);
			assertNull("No editor must have opened for invalid id: " + editor, editor);
		}
		{
			IEditorPart editor = openEditor(mView, SimpleViewEditor.ID, null);
			assertNotSame("Different editors must have opened for same object: " + editor, openEditor, editor);
		}

		{
			final Uielement toSelect = mView.getRootUielementContainer().getChildren().get(0);
			final AtomicBoolean followUpCalled = new AtomicBoolean(false);
			IEditorPart editor = mShell.syncExec(new LRunnable<IEditorPart>() {
				public IEditorPart run() throws Exception {
					// cannot use TestUtil.openModelEditor since we want to test
					// pure openEditor(), which is asynchronous
					return mManager.openEditor(toSelect, null, new Runnable() {
						public void run() {
							followUpCalled.set(true);
						}
					});
				}
			});
			// wait until selection is set for this deferred editor
			try {
				mShell.wait(new LCondition() {
					public boolean test() throws Exception {
						return followUpCalled.get();
					}
				});
			} catch (WaitTimedOutError e) {
				fail("Follow up action must have been called for editor " + editor, e);
			}

			final ViewEditor viewEditor = (ViewEditor) editor;
			assertEquals("Default editor for view must have opened", ViewEditor.ID, editor.getSite().getId());
			assertNotNull("Start object must be a view", viewEditor.getView());

			Object selectedObject = mShell.syncExec(new LRunnable<Object>() {
				public Object run() throws Exception {
					IStructuredSelection sel = (IStructuredSelection) viewEditor.getSite().getSelectionProvider()
							.getSelection();
					return sel.getFirstElement();
				}
			});
			assertEquals("Selection must be set by editor opening", toSelect, selectedObject);
		}
		{
			closeOpenedEditors();

			SimpleViewEditor.setErrorOnSelectionChange(true);
			try {
				Uielement toSelect = mView.getRootUielementContainer().getChildren().get(0);
				SimpleViewEditor editor = (SimpleViewEditor) openEditor(toSelect, SimpleViewEditor.ID, null);
				assertNotNull("Editor must have opened with logged exception for selectionChange", editor);
			} finally {
				SimpleViewEditor.setErrorOnSelectionChange(false);
			}
		}
	}

	public void testConvertEditorInput() throws Exception {
		IFile file = ModelAdapter.getInstance().getFile(mView);
		final IFileEditorInput fileInput = new FileEditorInput(file);
		TestEditorInput result = mShell.syncExec(new LRunnable<TestEditorInput>() {
			public TestEditorInput run() throws Exception {
				IEditorInput input = mManager.convertEditorInput(fileInput, TestEditor.ID);
				assertEquals("Input must have been converted", TestEditorInput.class, input.getClass());
				((TestEditorInput) input).setEditorConnection(ModelAdapter.getInstance().getConnection(mView));
				return (TestEditorInput) input;
			}
		});

		RefBaseObject view = (RefBaseObject) result.getAdapter(RefBaseObject.class);
		assertEquals("Input object must be view", mView, view);
	}

	public void testGetActiveModelEditor() throws Exception {
		TestEditor editor1 = openTestEditor(mView);
		IModelEditor mEditor1 = (IModelEditor) editor1.getAdapter(IModelEditor.class);
		IModelEditor editor = mManager.getActiveModelEditor();
		assertEquals("Editor must the active one", editor, mEditor1);
	}

	public void testGetAllActiveModelEditors() throws Exception {
		TestEditor editor1 = openTestEditor(mView);
		IModelEditor mEditor1 = (IModelEditor) editor1.getAdapter(IModelEditor.class);
		Set<IModelEditor> editors = mManager.getAllActiveModelEditors();
		assertTrue("Editor " + editor1 + " must be contained in the set of active editors: " + editors, editors
				.contains(mEditor1));
	}

	public void testGetAllActiveModelEditorsByPage() throws Exception {
		openTestEditor(mView);
		TestEditor editor2 = openTestEditor(mView2, "org.eclipse.debug.ui.DebugPerspective");

		Map<IWorkbenchPage, Set<IModelEditor>> editorsByPage = mManager.getAllActiveModelEditorsByPage();
		Set<Entry<IWorkbenchPage, Set<IModelEditor>>> entries = editorsByPage.entrySet();
		for (Entry<IWorkbenchPage, Set<IModelEditor>> entry : entries) {
			if (editor2.getSite().getPage().equals(entry.getKey())) {
				IModelEditor mEditor2 = (IModelEditor) editor2.getAdapter(IModelEditor.class);
				Set<IModelEditor> editorsOfPage = entry.getValue();
				assertTrue("Editor " + mEditor2 + " must be contained in the set of active editors: " + editorsOfPage,
						editorsOfPage.contains(mEditor2));
			}
		}
	}

	public void testGetEditorDescriptors() throws Exception {
		{
			Collection<IEditorDescriptor> descs = mManager.getEditorDescriptors(mView);
			boolean testEditorFound = false;
			boolean viewEditorFound = false;
			boolean simpleViewEditorFound = false;
			for (IEditorDescriptor d : descs) {
				String id = d.getId();
				if (id.equals(TestEditor.ID))
					testEditorFound = true;
				else if (id.equals(ViewEditor.ID))
					viewEditorFound = true;
				else if (id.equals(SimpleViewEditor.ID))
					simpleViewEditorFound = true;
			}
			assertTrue(TestEditor.ID + " is registered for Views (subclass of AbstractView): " + descs, testEditorFound);
			assertTrue(ViewEditor.ID + " is registered for Views: " + descs, viewEditorFound);
			assertTrue(SimpleViewEditor.ID + " is registered for Views: " + descs, simpleViewEditorFound);
		}
		{
			Collection<IEditorDescriptor> descs = mManager.getEditorDescriptors(mWindow);
			boolean editorFound = false;
			for (IEditorDescriptor d : descs) {
				if (d.getId().equals(TestEditor.ID)) {
					editorFound = true;
					break;
				}
			}
			assertTrue(TestEditor.ID + " is registered for Windows (subclass of AbstractView): " + descs, editorFound);
		}
		{
			Collection<IEditorDescriptor> descs = mManager.getEditorDescriptors(mView.getRootUielementContainer());
			boolean viewEditorFound = false;
			boolean simpleViewEditorFound = false;
			for (IEditorDescriptor d : descs) {
				String id = d.getId();
				if (id.equals(ViewEditor.ID))
					viewEditorFound = true;
				else if (id.equals(SimpleViewEditor.ID))
					simpleViewEditorFound = true;
				else if (id.equals(TestEditor.ID)) {
					fail(TestEditor.ID + " is not registered for UI elements (composite children of Views): " + descs);
				}
			}
			assertTrue(ViewEditor.ID + " is registered for UI elements (composite children of Views): " + descs,
					viewEditorFound);
			assertTrue(SimpleViewEditor.ID + " is registered for UI elements (composite children of Views): " + descs,
					simpleViewEditorFound);
		}
	}

	public void testHasEditorDescriptors() throws Exception {
		boolean descs = mManager.hasEditorDescriptors(mView);
		assertTrue("At least 3 editors must be registered for Views: ", descs);
	}

	public void testCloseEditorsOnProjectClose() throws Exception {
		IProject project = getProject();

		TestEditor editor = openTestEditor(mView);
		IWorkbenchPage page = editor.getEditorSite().getPage();
		project.close(null);

		IWorkbenchPartReference ref = page.getReference(editor);
		assertNotNull("Editor must be closed: " + ref, ref);
	}

	public void testCloseDirtyEditorsOnProjectClose() throws Exception {
		final IProject project = getProject();

		TestEditor editor1 = openTestEditor(mView);
		TestEditor editor2 = openTestEditor(mView2);
		IWorkbenchPage page = editor1.getEditorSite().getPage();
		// make dirty
		View view = (View) editor1.getEditorInput().getAdapter(View.class);
		view.setName("changedName");
		View view2 = (View) editor2.getEditorInput().getAdapter(View.class);
		view2.setName("changedName");

		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				CloseResourceAction action = new CloseResourceAction(mShell.getWidget());
				action.selectionChanged(new StructuredSelection(project));
				action.run();
				return null;
			}
		});

		LShell dialog = waitForSaveEditorsDialog();
		if (dialog != null) {
			LButton button = dialog.button().ok();
			dialog.clickOn(button);
			dialog.waitForClosed();
		}

		IWorkbenchPartReference ref1 = page.getReference(editor1);
		assertNotNull("Editor must be closed: " + ref1, ref1);
		IWorkbenchPartReference ref2 = page.getReference(editor2);
		assertNotNull("Editor must be closed: " + ref2, ref2);
	}

	public void testCloseEditorsOnProjectDeletion() throws Exception {
		IProject project = getProject();

		TestEditor editor = openTestEditor(mView);
		IWorkbenchPage page = editor.getEditorSite().getPage();
		TestUtil.deleteLocalMoinDCProject(project);

		IWorkbenchPartReference ref = page.getReference(editor);
		assertNotNull("Editor must be closed: " + ref, ref);
	}

	public void testGetActiveProject() throws Exception {
		final IProject project = getProject();
		// create second project to avoid trivial one-project-case
		mProject2 = TestUtil.createLocalMoinDCProject("test/modeleditor/manager2");

		final SimpleViewEditor editor = openSimpleViewEditor(mView);

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IProject activeProject = mManager.getActiveProject();
				assertEquals("Project must be inferred from editor", project, activeProject);
				return null;
			}
		});

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				View view = (View) editor.getEditorInput().getAdapter(View.class);
				RefBaseObject child = view.getRootUielementContainer().getChildren().get(0);
				editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(child));

				IProject activeProject = mManager.getActiveProject();
				assertEquals("Project must be inferred from editor", project, activeProject);
				return null;
			}
		});
	}

	public void testCloseAllActiveModelEditorsSave() throws Exception {
		TestEditor editor1 = openTestEditor(mView);
		TestEditor editor2 = openTestEditor(mView2);
		// make dirty
		View view = (View) editor1.getEditorInput().getAdapter(View.class);
		view.setName("changedName");
		View view2 = (View) editor2.getEditorInput().getAdapter(View.class);
		view2.setName("changedName");

		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				mManager.closeAllActiveModelEditors(true);
				return null;
			}
		});

		LShell dialog = waitForSaveEditorsDialog();
		if (dialog != null) {
			ConnectionManagerUITest.pressOk(dialog);
			dialog.waitForClosed();
			Set<IModelEditor> editors = mManager.getAllActiveModelEditors();
			int i = 0;
			while (i < 10 && !editors.isEmpty()) {
				mAbbotFactory.delay(200);
				editors = mManager.getAllActiveModelEditors();
				i++;
			}
			assertTrue("All editors must be closed: " + editors, editors.isEmpty());
		}
	}

	public void testCloseAllActiveModelEditorsNoSave() throws Exception {
		TestEditor editor1 = openTestEditor(mView);
		TestEditor editor2 = openTestEditor(mView2);
		// make dirty
		View view = (View) editor1.getEditorInput().getAdapter(View.class);
		view.setName("changedName");
		View view2 = (View) editor2.getEditorInput().getAdapter(View.class);
		view2.setName("changedName");

		mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				mManager.closeAllActiveModelEditors(false);
				return null;
			}
		});

		try {
			// wait for save dialog not to come
			LShell dialog = waitForSaveEditorsDialog();
			fail("Save dialog must not appear for save=false: " + dialog);
		} catch (WaitTimedOutError expected) {
			Set<IModelEditor> editors = mManager.getAllActiveModelEditors();
			assertTrue("All editors must be closed: " + editors, editors.isEmpty());
		}
	}

	public void testCloseModelEditors() throws Exception {
		openTestEditor(mView);

		Set<IModelEditor> editors = mShell.syncExec(new LRunnable<Set<IModelEditor>>() {
			public Set<IModelEditor> run() throws Exception {
				mManager.closeModelEditors(mView, true);
				return mManager.getAllActiveModelEditors();
			}
		});

		assertTrue("All editors must be closed: " + editors, editors.isEmpty());
	}

	public void testFindEditorParts() throws Exception {
		TestEditor editor = openTestEditor(mView);

		Collection<IEditorPart> editors = mShell.syncExec(new LRunnable<Collection<IEditorPart>>() {
			public Collection<IEditorPart> run() throws Exception {
				return mManager.findEditorParts(mView);
			}
		});

		assertTrue("Editor " + editor + " must be found in " + editors, editors.contains(editor));
	}

	public void testPreferences() {

		EditorSaveInitializer initializer = new EditorSaveInitializer();
		initializer.initializeDefaultPreferences();

		EditorSavePreferencesHelper helper = EditorSavePreferencesHelper.getInstance();
		assertNotNull(helper);

		helper.setEditorSaveState(false);
		assertFalse("State not correctly set by helper.", helper.getEditorSaveState());

		helper.setEditorSaveState(true);
		assertTrue("State not correctly set by helper.", helper.getEditorSaveState());
	}

	public void testPreferencePage() throws Exception {
		EditorSavePreferencesHelper.getInstance().setEditorSaveState(true);

		mShell.has(mShell.menu().withItem(mShell.menuItem().withText("&Window")));
		mShell.clickOn(mShell.menuItem().withText("&Window"));
		mShell.clickOn(mShell.menuItem().withText("&Preferences"));
		LShell preferences = mShell.waitForVisible(mShell.childShell().withText("Preferences"));
		assertNotNull(preferences.getWidget());
		LTree prefTree = preferences.has(preferences.tree().withItem(preferences.treeItem().withText("Java")).andItem(
				preferences.treeItem().withText("General")).andItem(preferences.treeItem().withText("Help")));
		assertNotNull(prefTree.getWidget());
		prefTree.expand(preferences.treeItem().withText("Modeling Infrastructure"));

		String editorSaveDialogPref = TextPool.getString(UIText._editor_save_preference_page_name);

		prefTree.expand(preferences.treeItem().withText(editorSaveDialogPref));
		LTreeItem buildPath = prefTree.waitForVisible(preferences.treeItem().withText(editorSaveDialogPref));
		assertTrue(buildPath.isResolved());
		preferences.clickOn(buildPath);

		String checkboxText = MiFwkUiMessages.ModelEditorSavePreferencePage_show_editor_save_dialog;

		LWidget checkBox = preferences.waitForVisible(preferences.widget().withText(checkboxText));
		preferences.clickOn(checkBox);
		preferences.clickOn(preferences.button().withText("OK"));
		preferences.waitForClosed();

		assertFalse("Editor save dialog not disabled", EditorSavePreferencesHelper.getInstance().getEditorSaveState());
	}

	public void testExecuteEditorsLockUI() throws Exception {
		setDeleteProjectOnTearDown();

		// ensure that save confirmation dialog comes up
		EditorSavePreferencesHelper.getInstance().setEditorSaveState(true);

		IEditorPart[] mParts = mShell.syncExec(new LRunnable<IEditorPart[]>() {
			public IEditorPart[] run() throws Exception {
				IEditorPart part1 = SimpleViewEditor.open(mView);
				assertNotNull("Editor must be created for " + mView, part1);
				assertTrue("Editor must be open: " + part1, part1.getEditorSite().getPage().isPartVisible(part1));

				IEditorPart part2 = ViewEditor.open(mView);
				assertNotNull("Editor must be created for " + mView, part2);
				assertTrue("Editor must be open: " + part2, part2.getEditorSite().getPage().isPartVisible(part2));
				return new IEditorPart[] { part1, part2 };
			}
		});

		View view1 = (View) mParts[0].getEditorInput().getAdapter(View.class);
		CreateButtonCommand cmd1 = new CreateButtonCommand(view1, "cmd1");
		CommandHandle cmdHnd = null;
		try {
			cmdHnd = cmd1.getConnection().getCommandStack().execute(cmd1);
		} catch (Exception e) {
			fail(e);
		}
		assertNotNull(cmdHnd);

		View view2 = (View) mParts[1].getEditorInput().getAdapter(View.class);
		final CreateButtonCommand cmd2 = new CreateButtonCommand(view2, "cmd2");

		{

			LRunnable<Void> runnable = new LRunnable<Void>() {
				public Void run() throws Exception {
					CommandHandle cmdHnd = null;
					boolean exceptionThrown = false;
					try {
						cmdHnd = cmd2.getConnection().getCommandStack().execute(cmd2);
					} catch (ExecutionCancelledException e) {
						exceptionThrown = true;
					} catch (Exception e) {
						fail(e);
					}
					assertTrue(exceptionThrown);
					assertNull(cmdHnd);
					return null;
				}
			};

			try {
				mShell.asyncExec(runnable);
			} catch (WidgetException e) {
				fail(e);
			}
			LShell dialog = waitForSaveConfirmation(mShell);
			pressCancel(dialog);

			// cancel
		}
		{
			// ok
			LRunnable<Void> runnable = new LRunnable<Void>() {
				public Void run() throws Exception {
					CommandHandle cmdHnd = null;
					try {
						cmdHnd = cmd2.getConnection().getCommandStack().execute(cmd2);
					} catch (Exception e) {
						fail(e);
					}
					assertNotNull(cmdHnd);
					return null;
				}
			};

			try {
				mShell.asyncExec(runnable);
			} catch (WidgetException e) {
				fail(e);
			}
			LShell dialog = waitForSaveConfirmation(mShell);
			selectCheckbox(dialog);
			pressOk(dialog);

			boolean saveState = EditorSavePreferencesHelper.getInstance().getEditorSaveState();
			assertFalse("Editor save preference not set correctly", saveState);
		}
	}

	private LShell waitForSaveEditorsDialog() throws Exception {
		try {
			LShell dialog = waitForDialogWithText(mShell, "/.*Save.*/");
			return dialog;
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

	private TestEditor openTestEditor(final View view) throws Exception {
		return openTestEditor(view, null);
	}

	private TestEditor openTestEditor(final View view, final String perspective) throws Exception {
		return (TestEditor) openEditor(view, TestEditor.ID, perspective);
	}

	private SimpleViewEditor openSimpleViewEditor(final View view) throws Exception {
		return (SimpleViewEditor) openEditor(view, SimpleViewEditor.ID, null);
	}

	private IEditorPart openEditor(final RefBaseObject object, final String editorId, final String perspective)
			throws Exception {
		return mShell.syncExec(new LRunnable<IEditorPart>() {
			public IEditorPart run() throws Exception {
				String oldPersp = null;
				if (perspective != null) {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					oldPersp = page.getPerspective().getId();
					PDEUtil.openPerspective(perspective);
					mAbbotFactory.delay(500); // time for perspective switch
				}
				IEditorPart editor = TestUtil.openModelEditor(object, editorId);
				if (editor != null) {
					mParts.add(editor);
				}
				if (oldPersp != null) {
					mAbbotFactory.delay(100);
					PDEUtil.openPerspective(oldPersp);
					mAbbotFactory.delay(500); // time for perspective switch
				}
				return editor;
			}
		});
	}

	private void closeOpenedEditors() throws WidgetException {
		if (mParts.size() > 0) {
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
			mParts.clear();
		}
	}

	private static LShell waitForDialogWithText(LShell parent, String text) throws Exception {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withText(text));
		return dialogShell;
	}

	static final LShell waitForSaveConfirmation(LShell parent) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell()
				.withName("ModelEditorManager.Dialog.ConfirmSave"));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	protected static final void pressOk(LShell dialog) throws Exception {
		LButton button = dialog.button().ok();
		assertNotNull("No Ok button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	protected static final void pressCancel(LShell dialog) throws Exception {
		LButton button = dialog.button().cancel();
		assertNotNull("No Cancel button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	protected static final void selectCheckbox(LShell dialog) throws Exception {
		LButton button = dialog.button().withName("ModelEditorManager.Dialog.EditorSaveDialogState");
		assertNotNull("No State change checkbox (button) found", button);
		dialog.clickOn(button);
	}
}
