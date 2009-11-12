package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class RemoveElementFromTagCommand extends Command {
	
	private Tag mTag = null;
	private ModelElement mElement = null;

	public RemoveElementFromTagCommand(Tag tag, ModelElement element,
			Connection connection) {
		super(connection, LocalizationMessages.RemoveElementFromTagCommand_0_XMIT);
		mTag = tag;
		mElement = element;
	}

	@Override
	public boolean canExecute() {
		return mTag.getElements().contains(mElement);
	}

	@Override
	public void doExecute() {
        // Remove the element form the elements list
        mTag.getElements().remove(mElement);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForChangingReference((Partitionable)mTag,
				mElement.getClass());
	}
}
