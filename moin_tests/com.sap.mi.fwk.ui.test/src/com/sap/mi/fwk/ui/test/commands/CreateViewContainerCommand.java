package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewContainer;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.ViewContainerUielement;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateViewContainerCommand extends Command {
	private View mView;

	private final static String DESCRIPTION = "Create View Container";

	private String name;

	public CreateViewContainerCommand(Connection connection, View view) {
		super(connection, DESCRIPTION);
		mView = view;
		name = null;
	}

	public CreateViewContainerCommand(Connection connection, View view, String name) {
		super(connection, DESCRIPTION);
		mView = view;
		this.name = name;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = (Partitionable) mView;
		PRI mri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		affectedPartitions.add(editOperation);
		return affectedPartitions;
	}

	@Override
	public void doExecute() {
		exec(mView, name);
	}

	public static ViewContainer exec(View view, String name) {
		ViewPackage viewPackage = (ViewPackage) view.refClass().refImmediatePackage();
		ViewContainer viewContainer = (ViewContainer) viewPackage.getViewContainer().refCreateInstance();

		UielementPackage uielementPackage = viewPackage.getUielement();
		ViewContainerUielement vcUielement = (ViewContainerUielement) uielementPackage.getViewContainerUielement()
				.refCreateInstance();
		UielementContainer uiContainer = view.getRootUielementContainer();
		if (uiContainer == null) {
			uiContainer = (UielementContainer) uielementPackage.getUielementContainer().refCreateInstance();
			view.setRootUielementContainer(uiContainer);
		}
		uiContainer.getChildren().add(vcUielement);
		viewContainer.setViewContainerUielement(vcUielement);
		if (name != null) {
			viewContainer.setName(name);
			vcUielement.setName(name);
		}
		view.getViewContainers().add(viewContainer);
		return viewContainer;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

}
