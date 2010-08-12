package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.execution.participation.ContributionMap;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

/**
 * Base class for commands used to refactor the domain model.
 * 
 * Commands only need to be concerned about changing the domain model. Everything
 * else is taken care of by the framework automatically (e.g. text updates,
 * constraint checking, binding checking)  
 *
 * @author Stephan Erb (d049157)
 *
 */
public abstract class AbstractRefactoringCommand extends Command {

    private IProgressMonitor progressMonitor;

    protected AbstractRefactoringCommand(Connection connection, String description) {
	super(connection, description);
    }
    
    /**
     * Can be implemented by subclasses.
     * @param pm 
     */
    public RefactoringStatus preValidate(IProgressMonitor pm) {
	pm.done();
	return new RefactoringStatus();
    }
    
    /**
     * Do everything that is needed to transform the domain.  This is run within the command context.
     */
    protected abstract void performRefactoring(IProgressMonitor pm);

    /**
     * Can be implemented by subclasses.
     * 
     * @param contributions A live list of contributions. If contributions are removed
     * 		those will not be shown to the user.
     * @param pm 
     */
    public RefactoringStatus postValidate(ContributionMap contributions, IProgressMonitor pm) {
	pm.done();
	return new RefactoringStatus();
    }

    @Override
    public void doExecute() {
	performRefactoring(progressMonitor == null ? new NullProgressMonitor() : progressMonitor);
    }
    
    /**
     * Called by the command execution framework. Subclasses do not need to care.
     * 
     * @param pm
     */
    public final void setExecutionProgressMonitor(IProgressMonitor pm) {
	this.progressMonitor = pm;
    }
    
    @Override
    public boolean canExecute() {
	return true;
    }

}
