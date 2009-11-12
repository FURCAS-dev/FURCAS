package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteModelElementCommand extends Command {
	
	private RefObject me = null;

	public DeleteModelElementCommand(RefObject modelElement, Connection connection) {
		super(connection, LocalizationMessages.DeleteModelElement_0_XMIT);
		me = modelElement;
	}

	@Override
	public boolean canExecute() {
		return me != null;
	}

	@Override
	public void doExecute() {
        // Delete the tag
		if (me.is___Alive()) {
			me.refDelete();
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable)me);
	}
}
 