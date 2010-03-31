package com.sap.mi.fwk.ui.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.mi.fwk.commands.CommandManagerCore;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.test.editors.TestEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Smoke test for {@link CommandManagerCore} and {@link CommandManager}, that
 * implicitly tests basic connection handling and editor launching as well.
 * 
 * @author d031150
 */
public class CommandManagerTestSmoke extends WebDynproProjectTest {

	private static final String DC_NAME = "test/cmdmanager/smoke";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/cmdmgr");

	private Component mComponent;

	protected View mView;

	protected LFactory mAbbotFactory;

	protected LShell mShell;

	protected Collection<IEditorPart> mParts;

	protected Component mComponent2;

	public CommandManagerTestSmoke() {
		this(CommandManagerTestSmoke.class.getName());
	}

	public CommandManagerTestSmoke(String name) {
		super(name);
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
		mShell = mAbbotFactory.getShell(Display.getDefault());
		mParts = new HashSet<IEditorPart>();
		Connection connection = createConnection();

		mComponent = createComponent(connection, getProject(), "Component1");
		ComponentPackage compPackage = (ComponentPackage) mComponent.refImmediatePackage();

		// a View
		RefClass viewClass = compPackage.getView().getView();
		mView = (View) viewClass.refCreateInstance();
		mView.setName("testView");
		mComponent.getViews().add(mView);

		// RootUIElementContainer
		UielementPackage uielementPackage = compPackage.getView().getUielement();
		RefClass uielementContainerClass = uielementPackage.getTransparentContainer();
		TransparentContainer rootContainer = (TransparentContainer) uielementContainerClass.refCreateInstance();
		rootContainer.setName("RootElement");
		mView.setRootUielementContainer(rootContainer);

		mComponent2 = createComponent(connection, getProject(), "Component2");

		connection.save();
	}

	protected static Component createComponent(Connection connection, IProject project, String partitionName) {
		PRI pri = getPri(project, PARTITION_FOLDER.append(partitionName));

		ModelPartition partition = connection.getPartition(pri);
		if (partition != null && partition.isAlive() && connection.partitionExists(pri)) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		Component component = (Component) compPackage.getComponent().refCreateInstance();
		component.setName("testComponent");
		assertNotNull(component);
		partition.assignElement((Partitionable) component);
		return component;
	}

	@Override
	protected void tearDown() throws Exception {
		if (mParts != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					for (IEditorPart part : mParts) {
						if (part != null)
							part.getSite().getPage().closeEditor(part, false);
					}
					return null;
				}
			});
			mParts = null;
		}

		mComponent = null;
		mView = null;

		mAbbotFactory = null;
		mShell = null;

		super.tearDown();
	}

	public void testOpenGroup() throws Exception {
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				TestEditor editor = TestEditor.open(mView);
				mParts.add(editor);
				editor.getModelEditor().getWorkingConnection().getCommandStack().openGroup("Test command group");
				CommandHandle handle = editor.getModelEditor().getWorkingConnection().getCommandStack().closeGroup();
				assertNull("Command handle must be null if no jmi call has been executed", handle);
				return null;
			}
		});
	}

	protected static final LShell waitForSaveConfirmation(LShell parent) throws WidgetException {
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

	protected static final void assertStatusOk(final IStatus result) {
		if (!result.isOK())
			fail(result.getMessage(), result.getException());
	}

	protected static final class CreateButtonCommand extends Command {
		private View view;

		CreateButtonCommand(View view, String desc) {
			super(((Partitionable) view).get___Connection(), desc);
			this.view = view;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			UielementPackage uielementPackage = ((ViewPackage) view.refImmediatePackage()).getUielement();
			Button button = (Button) uielementPackage.getButton().refCreateInstance();
			button.setName("Button");
			view.getRootUielementContainer().getChildren().add(button);
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			PRI pri = ((Partitionable) view).get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, pri);
			return Collections.singleton(editOperation);
		}
	}
}
