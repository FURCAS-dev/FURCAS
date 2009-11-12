package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class EditTagValueCommand extends Command {
	
	private Tag mTag = null;
	private int mIndex = -1;
	private String mNewValue = null;

	public EditTagValueCommand(Tag tag, int index, 
			String newValue, Connection connection) {
		super(connection, LocalizationMessages.EditTagValueCommand_0_XMIT);
		mTag = tag;
		mIndex = index;
		mNewValue = newValue;
	}

	@Override
	public boolean canExecute() {
		return mTag != null && mIndex != -1 && mNewValue != null;
	}

	@Override
	public void doExecute() {
		mTag.getValues().set(mIndex, mNewValue);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mTag);

	}

}
