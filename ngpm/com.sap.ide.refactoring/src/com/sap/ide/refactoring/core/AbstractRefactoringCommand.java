package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

/**
 * Base class for Refactorings  of the domain model.
 *
 * (No need to care about TextBlock updates here)
 *
 * @author D049157
 *
 */
public abstract class AbstractRefactoringCommand extends Command {

    protected AbstractRefactoringCommand(Connection connection,  String description) {
	super(connection, description);
    }

    @Override
    public boolean canExecute() {
	return true;
    }

    @Override
    public void doExecute() {
	performRefactoring();
    }

    /**
     * Do everything that is needed to transform the domain and the textblocks model.
     * This is run within the command context.
     */
    protected abstract void performRefactoring();

    /**
     * Can be implemented by subclasses.
     */
    public RefactoringStatus postValidate() {
	return new RefactoringStatus();
    }

    /**
     * Can be implemented by subclasses.
     */
    public RefactoringStatus preValidate() {
	return new RefactoringStatus();
    }

}
