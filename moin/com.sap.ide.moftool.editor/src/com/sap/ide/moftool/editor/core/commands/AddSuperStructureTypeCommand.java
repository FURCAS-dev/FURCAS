package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class AddSuperStructureTypeCommand extends Command {

	private StructureType subStructureType = null;
	private StructureType superStructureType = null;

	public AddSuperStructureTypeCommand(StructureType subStructureType, StructureType superStructureType,
			Connection connection) {
		super(connection, LocalizationMessages.AddSuperStructureTypeCommand_0_XMIT);
		this.subStructureType = subStructureType;
		this.superStructureType = superStructureType;
	}
	
	@Override
	public boolean canExecute() {
		return !subStructureType.getSupertypes().contains(superStructureType);
	}

	@Override
	public void doExecute() {
        subStructureType.getSupertypes().add(superStructureType);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForChangingReference((Partitionable) subStructureType,
				superStructureType.getClass());
	}

    public Generalizes getGeneralizes(){
        return MofService.getModelPackage(getConnection()).getGeneralizes();
    }
}
