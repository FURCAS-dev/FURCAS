package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class RemoveSuperclassCommand extends Command {
	
	private MofClass mSubClass = null;
	private MofClass mSuperClass = null;

	public RemoveSuperclassCommand(MofClass subClass, MofClass superClass,
			Connection connection) {
		super(connection, LocalizationMessages.RemoveSuperclassCommand_0_XMIT);
		mSubClass = subClass;
		mSuperClass = superClass;
	}

	@Override
	public boolean canExecute() {
		return mSubClass.getSupertypes().contains(mSuperClass);
	}

	@Override
	public void doExecute() {
        // Add the superclass to the generalizes list
        mSubClass.getSupertypes().remove(mSuperClass);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForChangingReference((Partitionable)mSubClass,
				mSuperClass.getClass());
	}
}
