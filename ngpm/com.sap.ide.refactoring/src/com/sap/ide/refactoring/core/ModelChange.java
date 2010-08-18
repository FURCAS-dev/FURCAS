package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;

public class ModelChange extends Change {

    private final RefactoringEditorFacade facade;
    private final RefactoringStatus status;

    /**
     * The executed refactoring.
     */
    private final CommandHandle refactoringCommandHandle;

    /**
     * The newest command directly or inderictly triggered by the command
     * (e.g. reference re-evaluations)
     */
    private final CommandHandle dependentCommandHandle;



    public ModelChange(RefactoringEditorFacade facade, RefactoringStatus status, CommandHandle refactoringCommandHandle, CommandHandle dependentCommandHandle) {
	this.facade = facade;
	this.status = status;
	this.refactoringCommandHandle = refactoringCommandHandle;
	this.dependentCommandHandle = dependentCommandHandle;
	refactoringCommandHandle = dependentCommandHandle;
    }

    @Override
    public Object getModifiedElement() {
	return facade.getDecoratedDomainRootObject();
    }

    @Override
    public void initializeValidationData(IProgressMonitor pm) {

    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	if (helper.peekRedoStack().equals(refactoringCommandHandle)) {
	    return status;
	} else {
	    return RefactoringStatus.createFatalErrorStatus("Subsequent commands have been executed.  The Refactoring is no longer valid." +
	    	" It can no longer be applied.");
	}
    }

    /**
     * User has accepted the change and desires that the refactoring is applied to his workspace.
     */
    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
	pm.beginTask("Applying Refactoring: " + refactoringCommandHandle.getDescription(), 2);

	// Finally, re-apply the desired changes.
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	helper.redoRefactoring(dependentCommandHandle);
	pm.worked(1);

	facade.refreshUI();
	pm.done();
	return new NullChange();
    }

    @Override
    public String getName() {
	return refactoringCommandHandle.getDescription();
    }


// ######## Provider change as a textual representation for the compare viewer  ########




}
