package com.sap.ide.refactoring.op.rename;



import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

import com.sap.ide.refactoring.core.AbstractRefactoringAction;
import com.sap.ide.refactoring.core.textual.SourcePositionModelLocator;

public class RenameAction extends AbstractRefactoringAction {

    @Override
    protected void runAction(IAction action) {
        SourcePositionModelLocator modelLocator = new SourcePositionModelLocator(facade);
        Collection<EObject> selectedModelElements = modelLocator.findSelectedReferencedModelElements();
        if (selectedModelElements.isEmpty()) {
            selectedModelElements = modelLocator.findSelectedCorrespondingModelElements();
        }
        RenameRefactoring refactoring = new RenameRefactoring(facade);
        if (selectedModelElements.size() == 1) {
            refactoring.setRenameTarget(selectedModelElements.iterator().next());
        }
        startRefactoringWizard(new RenameWizard(refactoring), "Rename");
    }



}
