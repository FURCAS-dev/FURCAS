package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteDiagramCommand extends Command {
	
	private Diagram mDiagram = null;

	public DeleteDiagramCommand(Diagram diagram, Connection connection) {
		super(connection, LocalizationMessages.DeleteDiagramCommand_0_XMIT);
		mDiagram = diagram;
	}

	@Override
	public boolean canExecute() {
		return mDiagram != null;
	}

	@Override
	public void doExecute() {
		// if diagram is not alive any more: do nothing
		if (!((Partitionable)mDiagram).is___Alive()) {
			return;
		}
		
		ModelPartition partition = ((Partitionable)mDiagram).get___Partition();

		// Delete the diagram
        mDiagram.refDelete();
        
        // Delete the rest (e.g. diagram link)
        partition.deleteElements();
        
        // Delete the partition file
        partition.delete();
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable)mDiagram);
	}
}
