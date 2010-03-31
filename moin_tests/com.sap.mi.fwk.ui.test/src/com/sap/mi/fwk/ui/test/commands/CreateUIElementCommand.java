package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import com.sap.ide.metamodel.webdynpro.component.view.uielement.Uielement;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateUIElementCommand extends Command {

	private UielementContainer container;

	private String name;

	private RefClass type;

	private Uielement uiElement;

	private final static String DESCRIPTION = "Create UI Element";

	public CreateUIElementCommand(Connection connection, UielementContainer container, RefClass type, String name) {
		super(connection, DESCRIPTION);
		this.container = container;
		this.name = name;
		this.type = type;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = (Partitionable) container;
		PRI mri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		affectedPartitions.add(editOperation);
		return affectedPartitions;
	}

	@Override
	public void doExecute() {
		uiElement = (Uielement) type.refCreateInstance(null);
		uiElement.setName(name);
		container.getChildren().add(uiElement);
	}

	public Uielement getUiElement() {
		return uiElement;
	}

	@Override
	public boolean canExecute() {
		return true;
	}
}