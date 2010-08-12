package com.sap.ide.refactoring.op.rename;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.AbstractModelRefactoring;
import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil;
import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.model.rename.NamedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RenameRefactoring extends AbstractModelRefactoring {


    private RefObject target;
    private NamedElement targetAsNamedElement;
    private String newName;
 
    public RenameRefactoring(RefactoringEditorFacade facade) {
	super(facade);
    }

// #### Preparation and initial check (before the GUI is shown) ####

    void setRenameTarget(RefObject target) {
	this.target = target;
    }

    @Override
    public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws OperationCanceledException {
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
	return TextBlockRefactoringUtil.isValidIdentifier(newName, facade);
    }

    String getOldModelElementName() {
	return targetAsNamedElement.getName();
    }

    @Override
    protected AbstractRefactoringCommand createExecutableRefactoringCommand() {
	return new RenameCommand(facade, targetAsNamedElement, newName);
    }

    @Override
    public String getName() {
	return "Rename";
    }

}
