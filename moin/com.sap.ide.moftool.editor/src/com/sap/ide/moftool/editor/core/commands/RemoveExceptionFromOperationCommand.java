package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Operation;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class RemoveExceptionFromOperationCommand extends Command {

	private Operation mOperation = null;
	private MofException mException = null;

	public RemoveExceptionFromOperationCommand(Operation operation, MofException exception,
			Connection connection) {
		super(connection, LocalizationMessages.RemoveExceptionFromOperationCommand_0_XMIT);
		mOperation = operation;
		mException = exception;
	}
		
	@Override
	public boolean canExecute() {		
		return mOperation.getExceptions().contains(mException);
	}

	@Override
	public void doExecute() {		
		 mOperation.getExceptions().remove(mException);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {		
		return MofPartitionService.getAffectedDefaultPartitionsForChangingReference((Partitionable)mOperation,
				mException.getClass());
	}

}
