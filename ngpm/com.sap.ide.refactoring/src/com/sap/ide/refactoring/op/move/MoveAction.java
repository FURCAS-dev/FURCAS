package com.sap.ide.refactoring.op.move;

import java.util.Collection;

import org.eclipse.jface.action.IAction;

import com.sap.ide.refactoring.core.AbstractRefactoringAction;
import com.sap.ide.refactoring.core.textual.SourcePositionModelLocator;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class MoveAction extends AbstractRefactoringAction {

    @Override
    protected void runAction(IAction action) {
	SourcePositionModelLocator modelLocator = new SourcePositionModelLocator(facade);
	Collection<RefObject> selectedModelElements = modelLocator.findSelectedCorrespondingModelElements();
	MoveRefactoring refactoring = new MoveRefactoring(facade);
	if (selectedModelElements.size() == 1) {
	    refactoring.setElementToMove(selectedModelElements.iterator().next());
	}
	startRefactoringWizard(new MoveWizard(refactoring), "Move");
    }

}
