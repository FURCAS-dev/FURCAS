package com.sap.ide.refactoring.core.execution;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.commands.CommandHandle;

/**
 * Glue coding to fit the undo/redo based refactoring preview generation into 
 * the Eclipse refacotoring workflow.
 * 
 * @author Stephan Erb (d049157)
 *
 */
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
    }

    @Override
    public Object getModifiedElement() {
	return facade.getDecoratedDomainRootObject();
    }

    @Override
    public void initializeValidationData(IProgressMonitor pm) {

    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws OperationCanceledException {
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getEditorConnection());
	if (helper.peekRedoStack() != null && helper.peekRedoStack().equals(refactoringCommandHandle)) {
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
	// Finally, re-apply the desired changes.
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getEditorConnection());
	try {
	    // as isValid was checked. This is supposed to pass in any case.
	    helper.redoRefactoring(dependentCommandHandle, pm);
	} catch (RefactoringCoreException e) {
	    throw new CoreException(e.asEclipseStatus(RefactoringSeverity.FATAL));
	}
	return new NullChange();
    }

    @Override
    public String getName() {
	return refactoringCommandHandle.getDescription();
    }


}
