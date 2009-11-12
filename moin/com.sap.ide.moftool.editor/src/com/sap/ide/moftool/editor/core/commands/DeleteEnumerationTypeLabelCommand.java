package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteEnumerationTypeLabelCommand extends Command {
	
	private EnumerationType mType = null;
	private String mValue = null;
	
	public DeleteEnumerationTypeLabelCommand(EnumerationType type, String value, 
			Connection connection) {
		super(connection, LocalizationMessages.DeleteEnumerationTypeLabelCommand_0_XMIT);
		mType = type;
		mValue = value;
		
	}


	@Override
	public boolean canExecute() {
		return mType != null && mValue != null;

	}

	@Override
	public void doExecute() {
		mType.getLabels().remove(mValue);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mType);

	}

}
