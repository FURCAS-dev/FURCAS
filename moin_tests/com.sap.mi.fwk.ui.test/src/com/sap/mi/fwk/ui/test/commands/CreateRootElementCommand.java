package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateRootElementCommand extends Command {

	private String name;

	private RefClass type;

	private UielementContainer root;

	private View view;

	private final static String DESCRIPTION = "Create Root Container";

	public CreateRootElementCommand(View view, RefClass type, String name) {
		super(((Partitionable) view).get___Connection(), DESCRIPTION);
		this.view = view;
		this.name = name;
		this.type = type;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = (Partitionable) view;
		PRI mri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		affectedPartitions.add(editOperation);
		return affectedPartitions;
	}

	@Override
	public void doExecute() {
		root = (UielementContainer) type.refCreateInstance(null);
		root.setName(name);
		view.setRootUielementContainer(root);
	}

	public UielementContainer getRootElement() {
		return root;
	}

	@Override
	public boolean canExecute() {
		return view.getRootUielementContainer() == null;
	}
}