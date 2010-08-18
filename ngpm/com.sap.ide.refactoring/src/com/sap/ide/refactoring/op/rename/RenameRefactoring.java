package com.sap.ide.refactoring.op.rename;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.RefactoringResult;
import com.sap.ide.refactoring.core.TextBlockAwareRefactoringCommandExecutor;
import com.sap.ide.refactoring.core.model.rename.NamedElement;
import com.sap.ide.refactoring.core.model.util.RefactoringModelUtil;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;

public class RenameRefactoring extends Refactoring {


    private EObject target;
    private NamedElement targetAsNamedElement;
    private String newName;

    private final RefactoringEditorFacade facade;
    private RefactoringResult refactoringResult;


    public RenameRefactoring(RefactoringEditorFacade facade) {
	this.facade = facade;
    }

// #### Preparation and initial check (before the GUI is shown) ####

    void setRenameTarget(EObject target) {
	this.target = target;
    }

    @Override
    public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	if (this.target == null) {
	    return RefactoringStatus.createFatalErrorStatus("Exactly one element must be selected for renaming.");
	}

	targetAsNamedElement = RefactoringModelUtil.adaptObject(target, NamedElement.class);
	if (targetAsNamedElement == null) {
	    return RefactoringStatus.createFatalErrorStatus("Selected Element does not support to be renamed.");
	}
	return new RefactoringStatus();
    }

// #### Further Validation and Execution ####

    RefactoringStatus setNewModelElementName(String newName) {
	this.newName = newName;
	return new RefactoringStatus();
    }

    String getOldModelElementName() {
	return targetAsNamedElement.getName();
    }

    @Override
    public RefactoringStatus checkFinalConditions(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
	assert targetAsNamedElement != null : "LTK must have called checkInitialConditions atleast once.";

	if (refactoringResult == null) {
	    final RenameCommand cmd = new RenameCommand(facade, targetAsNamedElement, newName);
	    TextBlockAwareRefactoringCommandExecutor executor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);
	    refactoringResult = executor.runRefactoring();
	}
	return refactoringResult.status;
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	assert refactoringResult != null : "LTK must have called checkFinalConditions atleast once.";
	return refactoringResult.change;
    }

    @Override
    public String getName() {
	return "Rename";
    }

}
