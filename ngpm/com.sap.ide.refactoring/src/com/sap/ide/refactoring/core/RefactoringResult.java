package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class RefactoringResult {

    public final Change change;
    public final RefactoringStatus status;

    /**
     * The executed refactoring.
     */
    /*package*/ final CommandHandle refactoringCommandHandle;

    /**
     * Result describing a successful refactoring.
     *
     * @param refactoringCmdHandle
     * @param change
     * @param status
     */
    public RefactoringResult(CommandHandle refactoringCmdHandle, Change change, RefactoringStatus status) {
	this.refactoringCommandHandle = refactoringCmdHandle;
	this.change = change;
	this.status = status;
    }

    /**
     * Result describing a refactoring that could not be applied.
     *
     * @param asRefactoringStatus
     */
    public RefactoringResult(final RefactoringStatus status) {
	this(null, new NullChange() {
	    @Override
	    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
	       return status;
	    }
	}, status);
	assert !status.isOK() : "Severity must not be ok... this is supposed to be a crash!";

    }

}
