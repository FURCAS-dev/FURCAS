package com.sap.mi.fwk.ui.test.commands;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Deletes a set of objects
 * 
 * @author d031150
 */
public class DeleteElementCommand extends Command {

	private final static String DESCRIPTION = "Delete UI Element";
	private final List<RefObject> elements;

	public DeleteElementCommand(RefObject obj) {
		this(Collections.singletonList(obj));
	}

	public DeleteElementCommand(List<RefObject> objects) {
		super(((Partitionable) objects.get(0)).get___Connection(), DESCRIPTION);
		this.elements = objects;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Set<PartitionOperation> affectedPartitions = new HashSet<PartitionOperation>();

		for (RefObject element : elements) {
			Partitionable partitionable = (Partitionable) element;
			PRI pri = partitionable.get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
			affectedPartitions.add(editOperation);
		}
		return affectedPartitions;
	}

	@Override
	public void doExecute() {
		for (RefObject element : elements) {
			element.refDelete();
		}
	}

	@Override
	public boolean canExecute() {
		return true;
	}
}