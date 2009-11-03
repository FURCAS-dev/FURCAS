/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.model.command;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.Assert;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;

/**
 * @author d003456
 * 
 */
public class MoveToParitionCommand extends Command {

	private final ModelPartition targetPartition;

	private final RefObject refObjectToMove;

	/**
	 * Creates {@link MoveToParitionCommand}.
	 * 
	 * @param refObjectToMove
	 * @param target
	 */
	public MoveToParitionCommand(RefObject refObjectToMove, ModelPartition target) {

		super(refObjectToMove.get___Connection(), "Move to Parition"); //$NON-NLS-1$
		Assert.isNotNull(refObjectToMove);
		Assert.isNotNull(target);
		this.targetPartition = target;
		this.refObjectToMove = refObjectToMove;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#doExecute()
	 */
	@Override
	public void doExecute() {

		this.targetPartition.assignElementIncludingChildren(this.refObjectToMove);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#getAffectedPartitions()
	 */
	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {

		final ArrayList<PartitionOperation> result = new ArrayList<PartitionOperation>(2);
		result.add(new PartitionOperation(Operation.EDIT, this.refObjectToMove.get___Partition().getPri()));
		result.add(new PartitionOperation(Operation.EDIT, this.targetPartition.getPri()));
		return result;
	}

}
