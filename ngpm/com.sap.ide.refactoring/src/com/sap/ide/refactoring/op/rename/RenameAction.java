package com.sap.ide.refactoring.op.rename;



import java.util.Collection;

import org.eclipse.jface.action.IAction;

import com.sap.ide.refactoring.core.AbstractRefactoringAction;
import com.sap.ide.refactoring.core.textual.SourcePositionModelLocator;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RenameAction extends AbstractRefactoringAction {

    @Override
    protected void runAction(IAction action) {
        SourcePositionModelLocator modelLocator = new SourcePositionModelLocator(facade);
        Collection<RefObject> selectedModelElements = modelLocator.findSelectedReferencedModelElements();
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
