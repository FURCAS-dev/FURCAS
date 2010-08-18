package com.sap.ide.refactoring.core.model.validation;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;


public abstract class AbstractValidationCommand extends Command {

    protected RefactoringStatus status = new RefactoringStatus();

    protected AbstractValidationCommand(ResourceSet connection, String description) {
	super(connection, description);
    }
    
    @Override
    public boolean canExecute() {
	return true;
    }
    
    @Override
    public Collection<EOperation> getAffectedPartitions() {
	return Collections.emptyList();
    }
    
    public RefactoringStatus getResultAsStatus() {
	return status;
    }

}
