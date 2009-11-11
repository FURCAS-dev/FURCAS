package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class AddEnumerationTypeLabelCommand extends Command {
	
	private EnumerationType mType = null;	
	private String mNewValue = null;

	public AddEnumerationTypeLabelCommand(EnumerationType type, 
			String newValue, Connection connection) {
		super(connection, LocalizationMessages.AddEnumerationTypeLabelCommand_0_XMIT);
		mType = type;		
		mNewValue = newValue;
	}

	@Override
	public boolean canExecute() {		
		return mType != null && mNewValue != null;
	}

	@Override
	public void doExecute() {
		mType.getLabels().add(mNewValue);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mType);
	}

}
