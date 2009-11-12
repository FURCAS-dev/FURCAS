package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class RemoveElementFromConstraintCommand extends Command {

		private Constraint mConstraint = null;
	private ModelElement mElement = null;

	public RemoveElementFromConstraintCommand(Constraint constraint, ModelElement element,
			Connection connection) {
		super(connection, LocalizationMessages.RemoveElementFromConstraintCommand_0_XMIT);
		mConstraint = constraint;
		mElement = element;
	}
	
	@Override
	public boolean canExecute() {
		return mConstraint.getConstrainedElements().contains(mElement);
	}

	@Override
	public void doExecute() {
        mConstraint.getConstrainedElements().remove(mElement);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForChangingReference((Partitionable)mConstraint,
				mElement.getClass());
	}


}
