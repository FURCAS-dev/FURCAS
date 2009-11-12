package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class EditEnumerationTypeLabelCommand extends Command {
	
	private EnumerationType mType = null;
	private int mIndex = -1;
	private String mNewValue = null;

	public EditEnumerationTypeLabelCommand(EnumerationType type, int index, 
			String newValue, Connection connection) {
		super(connection, LocalizationMessages.EditEnumerationTypeLabelCommand_0_XMIT);
		mType = type;
		mIndex = index;
		mNewValue = newValue;
	}

	@Override
	public boolean canExecute() {
		return mType != null && mIndex != -1 && mNewValue != null;
	}

	@Override
	public void doExecute() {
		mType.getLabels().set(mIndex, mNewValue);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mType);
	}

}
