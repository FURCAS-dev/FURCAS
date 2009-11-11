package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class AddTagValueCommand extends Command {
	
	private Tag mTag = null;	
	private String mNewValue = null;

	public AddTagValueCommand(Tag tag, 
			String newValue, Connection connection) {
		super(connection, LocalizationMessages.AddTagValueCommand_0_XMIT);
		mTag = tag;		
		mNewValue = newValue;
	}

	@Override
	public boolean canExecute() {
		return mTag != null && mNewValue != null;
	}

	@Override
	public void doExecute() {
		mTag.getValues().add(mNewValue);


	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mTag);
	}

}
