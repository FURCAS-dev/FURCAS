package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteClassCommand extends Command {
	
	private MofClass mClass = null;

	public DeleteClassCommand(MofClass clazz, Connection connection) {
		super(connection, LocalizationMessages.DeleteClassCommand_0_XMIT);
		mClass = clazz;
	}

	@Override
	public boolean canExecute() {
		return mClass != null;
	}

	@Override
	public void doExecute() {
		// if class is not alive any more: do nothing
		if (!((Partitionable)mClass).is___Alive()) {
			return;
		}
        // delete associations
        List<Association> assocs = ClassService.getAllAssociations(mClass);
        for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();){
            Association assoc = (Association) iter.next();
			DeleteAssociationCommand command = new DeleteAssociationCommand(assoc, getConnection());
	        command.execute();
        }
        // Delete the class
		if (((Partitionable)mClass).is___Alive()) {
			mClass.refDelete();
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable)mClass);
	}
}
