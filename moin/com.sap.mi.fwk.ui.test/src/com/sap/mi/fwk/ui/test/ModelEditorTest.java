package com.sap.mi.fwk.ui.test;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import abbot.WaitTimedOutError;
import abbot.script.Condition;
import abbot.tester.swt.Robot;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LCondition;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.NoWidgetFoundException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorPart;
import com.sap.mi.fwk.ui.internal.editor.StatusPart;
import com.sap.mi.fwk.ui.test.editors.SimpleViewEditor;
import com.sap.mi.fwk.ui.test.editors.TestEditor;
import com.sap.mi.fwk.ui.tree.TreeNodeDecorator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link ModelEditor} and respective {@link IEditorPart}
 * implementations
 * 
 * @author d031150
 */
public class ModelEditorTest extends WebDynproProjectTest implements IPropertyListener {

	private static final String DC_NAME = "test/modeleditor";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/me");

	private LFactory mAbbotFactory;
	private Connection mConnection;
	private View mView;
	private Button mButton;
	private IEditorPart[] mParts;
	private volatile boolean mDirtyStateToggled; // read and written by test
	// and UI thread

	private Display mDisplay;

	private LShell mShell;

	public ModelEditorTest() {
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

		// each test should start on a clean project
		setDeleteProjectOnTearDown();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);

		mConnection = createConnection();

		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = null;
		if (mConnection.partitionExists(partitionMRI)) {
			partition = mConnection.getPartition(partitionMRI);
			if (partition != null) {
				partition.delete();
			}
		}
		partition = mConnection.createPartition(partitionMRI);
		assertNotNull("Partition creation failed", partition);

		Component component = mConnection.createElementInPartition(Component.class, partition);
		component.setName("testComponent");

		mView = mConnection.createElementInPartition(View.class, partition);
		mView.setName("testView1");
		component.getViews().add(mView);

		UielementContainer container = mConnection.createElementInPartition(TransparentContainer.class, partition);
		container.setName("RootElement");
		mView.setRootUielementContainer(container);

		// intentionally do not add the button to the view hierarchy
		mButton = mConnection.createElementInPartition(Button.class, partition);
		partition.assignElement(mButton);

		assertConnectionSave(mConnection);
	}

	@Override
	protected void tearDown() throws Exception {
		if (mParts != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					for (IEditorPart part : mParts) {
						if (part != null) {
							part.removePropertyListener(ModelEditorTest.this);
							part.getSite().getPage().closeEditor(part, false);
						}
					}
					return null;
				}
			});
		}

		if (mParts != null) {
			for (IEditorPart part : mParts) {
				IEditorInput input = part.getEditorInput();
				IEditorPart part2 = part.getSite().getPage().findEditor(input);
				int count = 0;
				while (part2 != null && count < 10) {
					mAbbotFactory.delay(400);
					part2 = part.getSite().getPage().findEditor(input);
					count++;
				}
			}
		}
		mParts = null;
		// connection will be closed in super class
		mConnection = null;
		mView = null;
		mButton = null;

		super.tearDown();
	}

	public void testDirtyToggleAttributeChange() throws Exception {
		TestEditor editor = openEditor();

		Connection connection = editor.getModelEditor().getWorkingConnection();
		final View view = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);

		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				view.setName("changedName");
				return null;
			}

			@Override
			public String toString() {
				return "Attribute Change";
			}
		}, editor);

		assertEditorDirty(editor);
	}

	public void testDirtyToggleLinkChange() throws Exception {
		TestEditor editor = openEditor();

		Connection connection = editor.getModelEditor().getWorkingConnection();
		final View view = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);
		final Button button = ModelAdapterUI.getInstance().resolveInConnection(mButton, connection);

		// create link
		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				view.getRootUielementContainer().getChildren().add(button);
				return null;
			}

			@Override
			public String toString() {
				return "Link Creation";
			}
		}, editor);

		assertEditorDirty(editor);
	}

	public void testDirtyToggleElementCreate() throws Exception {
		TestEditor editor = openEditor();

		Connection connection = editor.getModelEditor().getWorkingConnection();
		final View view = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);

		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				((ViewPackage) view.refImmediatePackage()).getUielement().getButton().refCreateInstance();
				return null;
			}

			@Override
			public String toString() {
				return "Element Creation";
			}
		}, editor);

		assertEditorDirty(editor);
	}

	public void testDirtyTogglePartitionChange() throws Exception {
		TestEditor editor = openEditor();

		// Modify view in external connection. PartitionChange must be fired on
		// save.
		mView.setName("newName");
		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				ModelAdapterUI.getInstance().getConnection(mView).save();
				return null;
			}

			@Override
			public String toString() {
				return "Partition Change";
			}
		}, editor);
	}

	public void testDirtyToggleElementCreateInCommand() throws Exception {
		final TestEditor editor = openEditor();

		Connection connection = editor.getModelEditor().getWorkingConnection();
		final View view = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);

		// after command: flag must be toggled
		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				CreateButtonCommand cmd = new CreateButtonCommand(view, editor);
				cmd.getConnection().getCommandStack().execute(cmd);
				return null;
			}

			@Override
			public String toString() {
				return "Element Creation in Command: After Command";
			}
		}, editor);

		assertEditorDirty(editor);
	}

	public void testDirtyToggleElementCreateInCommandGroup() throws Exception {
		TestEditor editor = openEditor();

		final Connection connection = editor.getModelEditor().getWorkingConnection();
		final View view = ModelAdapterUI.getInstance().resolveInConnection(mView, connection);
		final String changeName = "Element Change in Comand Group";

		// open group
		mDirtyStateToggled = false;
		connection.getCommandStack().openGroup(changeName);

		// do something: flag must be not toggled
		assertDirtyStateNotToggled(new Callable<Void>() {
			public Void call() throws Exception {
				((ViewPackage) view.refImmediatePackage()).getUielement().getButton().refCreateInstance();
				return null;
			}

			@Override
			public String toString() {
				return changeName + ": Within Group";
			}
		}, editor);

		// close group: flag must be toggled
		assertDirtyStateToggled(new Callable<Void>() {
			public Void call() throws Exception {
				connection.getCommandStack().closeGroup();
				return null;
			}

			@Override
			public String toString() {
				return changeName + ": After Close";
			}
		}, editor);

		assertEditorDirty(editor);
	}

	public void testLabelIsSet() throws Exception {
		TestEditor editor = openEditor();

		Connection connection = editor.getWorkingConnection();
		String label = connection.getLabel();
		assertEquals("Editor input name must be set as label of connection " + connection, editor.getEditorInput()
				.getName(), label);

		if (connection.isAlive()) {
			connection.close();
		}
	}

	public void testErrorDuringInit() throws Exception {
		// create a view that is not persisted, this will not be resolvable in
		// the editor's connection, which leads to an exception
		View view = mConnection.createElement(View.class);
		view.setName("view");

		// we must not wait for the editor to complete since this would timeout
		// (due to the provoked error)
		openSimpleViewEditor(view, false);

		// find the error text widget; may take a while --> retry several times
		LText text = null;
		int retries = 0;
		while (retries < 10) {
			try {
				text = mShell.text().withName(StatusPart.WIDGET_NAME_TEXT).resolve();
				// Success --> continue with test
				break;
			} catch (NoWidgetFoundException e) {
				// Ignore for the allowed number of repetitions
				if (retries >= 10) {
					throw e;
				}
			}
			retries++;
			sleep(100);
		}
		String errorMsg = text.getText();
		assertTrue("Error message must contain object name: " + errorMsg, errorMsg.contains(view.getName()));
		assertTrue("Error message must contain project name: " + errorMsg, errorMsg.contains(getProject().getName()));

		LButton detailsButton = mShell.button().withName(StatusPart.WIDGET_NAME_BUTTON).resolve();
		mShell.clickOn(detailsButton);

		LText detailsText = mShell.text().withName(StatusPart.WIDGET_NAME_TEXT_DETAILS).resolve();
		String stackTrace = detailsText.getText();
		assertTrue("Stack trace must not be empty", stackTrace.length() > 0);
	}

	private TestEditor openEditor() throws Exception {
		return mShell.syncExec(new LRunnable<TestEditor>() {
			public TestEditor run() throws Exception {
				TestEditor editor = TestEditor.open(mView);
				editor.addPropertyListener(ModelEditorTest.this);
				mParts = new IEditorPart[] { editor };
				return editor;
			}
		});
	}

	private SimpleViewEditor openSimpleViewEditor(final View view, final boolean wait) throws Exception {
		return mShell.syncExec(new LRunnable<SimpleViewEditor>() {
			public SimpleViewEditor run() throws Exception {
				SimpleViewEditor editor = SimpleViewEditor.open(view, wait);
				editor.addPropertyListener(ModelEditorTest.this);
				mParts = new IEditorPart[] { editor };
				return editor;
			}
		});
	}

	private <T> T assertDirtyStateToggled(Callable<T> change, IEditorPart editor) throws Exception {
		mDirtyStateToggled = false;
		T result = change.call();

		// toggling happens async, so wait for it a certain time
		mAbbotFactory.setWaitTimeout(6000);
		try {
			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return mDirtyStateToggled;
				}
			});
		} catch (WaitTimedOutError e) {
			fail("Editor must be dirty after change: " + change, e);
		}
		return result;
	}

	private <T> T assertDirtyStateNotToggled(Callable<T> change, IEditorPart editor) throws Exception {
		mDirtyStateToggled = false;
		T result = change.call();

		// toggling happens async, so wait for it a certain time
		mAbbotFactory.setWaitTimeout(6000);
		try {
			mShell.wait(new LCondition() {
				public boolean test() throws Exception {
					return mDirtyStateToggled;
				}
			});
			fail("Editor must NOT be dirty after change: " + change);
		} catch (WaitTimedOutError expected) {
		}
		return result;
	}

	private void assertEditorDirty(final IEditorPart editor) {
		boolean isDirty = editor.isDirty();
		assertTrue("Editor must be dirty after change: " + editor, isDirty);
	}

	public void propertyChanged(Object source, int propId) {
		if (IEditorPart.PROP_DIRTY == propId) {
			mDirtyStateToggled = true;
		}
	}

	private final class CreateButtonCommand extends Command {

		private final View mView;
		private final TestEditor mEditor;

		CreateButtonCommand(View view, TestEditor editor) {
			super(ModelAdapterUI.getInstance().getConnection(view));
			mView = view;
			mEditor = editor;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			try {
				// in the middle of command: flag must not be toggled
				assertDirtyStateNotToggled(new Callable<Void>() {
					public Void call() throws Exception {
						((ViewPackage) mView.refImmediatePackage()).getUielement().getButton().refCreateInstance();
						return null;
					}

					@Override
					public String toString() {
						return "Element Creation in Command: During Command";
					}
				}, mEditor);
			} catch (Exception e) {
				fail(e);
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			PartitionOperation op = new PartitionOperation(Operation.EDIT, ModelAdapterUI.getInstance().getPri(mView));
			return Collections.singleton(op);
		}
	}

	private final class DeleteViewCommand extends Command {

		private final View mView;

		DeleteViewCommand(View view) {
			super(ModelAdapterUI.getInstance().getConnection(view));
			mView = view;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			try {
				mView.refDelete();
			} catch (Exception e) {
				fail(e);
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			PartitionOperation op = new PartitionOperation(Operation.EDIT, ModelAdapterUI.getInstance().getPri(mView));
			return Collections.singleton(op);
		}
	}

	public void testDecorationStateChanged() throws Exception {
		final TestEditor editor = openEditor();

		final IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		final boolean oldValue = decoratorManager.getEnabled(TreeNodeDecorator.DECORATOR_ID);
		decoratorManager.setEnabled(TreeNodeDecorator.DECORATOR_ID, !oldValue);

		LShell shell = mAbbotFactory.getShell(Display.getDefault());
		shell.syncExec(new LRunnable<Object>() {
			public Object run() throws Exception {
				decoratorManager.update(TreeNodeDecorator.DECORATOR_ID);
				return null;
			}
		});
		Robot.wait(new Condition() {
			public boolean test() {
				return oldValue != editor.getDecoState();
			}
		}, 5000);

		decoratorManager.setEnabled(TreeNodeDecorator.DECORATOR_ID, oldValue);
		shell.syncExec(new LRunnable<Object>() {
			public Object run() throws Exception {
				decoratorManager.update(TreeNodeDecorator.DECORATOR_ID);
				return null;
			}
		});
		Robot.wait(new Condition() {
			public boolean test() {
				return oldValue == editor.getDecoState();
			}
		}, 5000);
	}

	public void testEditorCloseOnDelete() {

		ModelEditorPart openEditor = null;
		try {
			openEditor = openEditor();
		} catch (Exception e) {
			fail(e);
		}
		assertNotNull(openEditor);

		IEditorInput input = openEditor.getEditorInput();
		assertNotNull(input);

		DeleteViewCommand cmd = new DeleteViewCommand(mView);
		cmd.execute();
		try {
			ModelManager.getConnectionManager().save(mConnection);
		} catch (Exception e1) {
			fail(e1);
		}

		IWorkbenchPage page = openEditor.getEditorSite().getPage();
		IEditorPart findEditor = page.findEditor(input);
		int count = 0;
		while (findEditor != null && count < 10) {
			findEditor = page.findEditor(input);
			count++;
			mAbbotFactory.delay(200);
		}
		assertNull(findEditor);
	}
}