package com.sap.ide.refactoring.core.execution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.tc.moin.repository.commands.CommandHandle;

public class RefactoringResult {

    public final Change change;
    public final RefactoringStatus status;

    /**
     * The executed refactoring command.
     */
    /*package*/ final CommandHandle refactoringCommandHandle;


    private RefactoringResult(CommandHandle refactoringCmdHandle, Change change, RefactoringStatus status) {
	this.refactoringCommandHandle = refactoringCmdHandle;
	this.change = change;
	this.status = status;
    }
    
    /**
     * Result describing a successful refactoring.
     *
     * @param refactoringCmdHandle
     * @param change
     * @param status
     */
    public static RefactoringResult createResult(CommandHandle refactoringCmdHandle, Change change, RefactoringStatus status) {
	return new RefactoringResult(refactoringCmdHandle, change, status);
    }
    
    public static RefactoringResult createFailingResult(final RefactoringStatus status) {
	RefactoringResult result = new RefactoringResult(null, new NullChange() {
	    @Override
	    public RefactoringStatus isValid(IProgressMonitor pm) {
	       return status;
	    }
	}, status);
	assert !status.isOK() : "Severity must not be ok... this is supposed to be a crash!";
	return result;
    }
    
}
