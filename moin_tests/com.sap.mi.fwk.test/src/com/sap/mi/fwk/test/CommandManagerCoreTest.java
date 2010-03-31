package com.sap.mi.fwk.test;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionAlreadyModifiedException;
import com.sap.mi.fwk.SourceControlException;
import com.sap.mi.fwk.commands.CommandManagerCore;
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
 * Test for {@link CommandManagerCore}
 * 
 * @author d022960
 */
public class CommandManagerCoreTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/cmdmanagercore";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/cmdmgr");

	private Component mComponent;

	protected View mView;

	public CommandManagerCoreTest() {
		this(CommandManagerCoreTest.class.getName());
	}

	public CommandManagerCoreTest(String name) {
		super(name);
	}

	public void testPrepareExecutionHeadless() {
		Connection connection = createConnection();
		View newView = ModelAdapter.getInstance().resolveInConnection(mView, connection);
		SetNameCommand cmd = new SetNameCommand(newView, "the name");
		CommandHandle cmdHnd = null;
		try {
			cmdHnd = cmd.getConnection().getCommandStack().execute(cmd);
		} catch (Exception e) {
			fail(e);
		}
		assertNotNull(cmdHnd);

		try {
			PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, newView.get___Partition()
					.getPri());
			CommandManagerCore.getInstance().prepareExecutionHeadless(connection, Collections.singleton(editOperation));
		} catch (Exception e) {
			fail(e);
		}
		// check whether a PartitionAlreadyModifiedException is thrown
		connection = createConnection();
		newView = ModelAdapter.getInstance().resolveInConnection(mView, connection);

		try {
			PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, newView.get___Partition()
					.getPri());
			CommandManagerCore.getInstance().prepareExecutionHeadless(connection, Collections.singleton(editOperation));
			fail("PartitionAlreadyModifiedException expected");
		} catch (PartitionAlreadyModifiedException e) {
			// expected;
		} catch (SourceControlException e) {
			fail(e);
		}
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

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
		mComponent = null;
		mView = null;

		super.tearDown();
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
