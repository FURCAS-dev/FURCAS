package com.sap.ide.refactoring.core.validation;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public abstract class AbstractValidationCommand extends Command {

    protected RefactoringStatus status = new RefactoringStatus();

    protected AbstractValidationCommand(Connection connection, String description) {
	super(connection, description);
    }
    
    @Override
    public boolean canExecute() {
	return true;
    }
    
    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	return Collections.emptyList();
    }
    
    public RefactoringStatus getResultAsStatus() {
	return status;
    }

}
