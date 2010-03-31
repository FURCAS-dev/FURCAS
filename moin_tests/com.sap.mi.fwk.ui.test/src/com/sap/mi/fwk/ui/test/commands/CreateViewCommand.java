package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.controller.Controller;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.ide.metamodel.webdynpro.enums.ControllerTypeEnumEnum;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.commands.NavigationCommand;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateViewCommand extends NavigationCommand {

	private Component mComponent;

	private String mName;

	private View mView;

	private final static String DESCRIPTION = "Create View '";

	public CreateViewCommand(Connection connection, Component component, String name) {
		super(connection, DESCRIPTION + name + "'");
		mComponent = ModelAdapter.getInstance().resolveInConnection(component, connection);
		mName = name;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = (Partitionable) mComponent;
		PRI mri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		affectedPartitions.add(editOperation);
		if (mView != null) {
			affectedPartitions.add(new PartitionOperation(PartitionOperation.Operation.CREATE, ModelAdapter
					.getInstance().getMri(mView).getPri()));
		}
		return affectedPartitions;
	}

	@Override
	public void doExecute() {
		ComponentPackage compPackage = (ComponentPackage) mComponent.refImmediatePackage();
		mView = (View) compPackage.getView().getView().refCreateInstance();
		mComponent.getViews().add(mView);
		mView.setName(mName);
		Controller controller = (Controller) compPackage.getController().getController().refCreateInstance();
		mComponent.getControllers().add(controller);
		mView.setViewController(controller);
		controller.setName(mName);
		controller.setType(ControllerTypeEnumEnum.VIEW);

		ViewPackage viewPackage = (ViewPackage) mView.refClass().refImmediatePackage();
		UielementContainer container = (UielementContainer) viewPackage.getUielement().getTransparentContainer()
				.refCreateInstance();
		container.setName("RootElement");
		mView.setRootUielementContainer(container);
	}

	@Override
	public RefBaseObject getNavigationObject() {
		return mView;
	}
}