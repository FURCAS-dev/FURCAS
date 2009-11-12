package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteTagValueCommand extends Command {
	
	private Tag mTag = null;
	private String mValue = null;
	
	public DeleteTagValueCommand(Tag tag, String value, 
			Connection connection) {
		super(connection, LocalizationMessages.DeleteTagValueCommand_0_XMIT);
		mTag = tag;
		mValue = value;
		
	}

	@Override
	public boolean canExecute() {
		return mTag != null && mValue != null;

	}

	@Override
	public void doExecute() {
		mTag.getValues().remove(mValue);		

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mTag);

	}

}
