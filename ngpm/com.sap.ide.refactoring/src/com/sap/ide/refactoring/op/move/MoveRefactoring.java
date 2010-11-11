package com.sap.ide.refactoring.op.move;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.AbstractModelRefactoring;
import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.model.move.MovableElement;
import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class MoveRefactoring extends AbstractModelRefactoring {

    private RefObject elementToMove;
    private MovableElement elementToMoveAsMovableElement;
    private MovableElementTarget target;

    public MoveRefactoring(RefactoringEditorFacade facade) {
	super(facade);
    }
    
    @Override
    public String getName() {
	return "Move";
    }
    
 // #### Preparation and initial check (before the GUI is shown) ####

    public void setElementToMove(RefObject elementToMove) {
	this.elementToMove = elementToMove;
    }
    
    public MovableElement getElementToMove() {
	return this.elementToMoveAsMovableElement;
    }
    
    public void setTarget(MovableElementTarget target) {
	this.target = target;
    }

    @Override
    public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws OperationCanceledException {
	if (elementToMove == null) {
	    return RefactoringStatus.createFatalErrorStatus("Exactly one element must be selected to be moved.");
	}
	elementToMoveAsMovableElement = RefactoringModelUtil.adaptObject(elementToMove, MovableElement.class);
	if (elementToMoveAsMovableElement == null) {
	    return RefactoringStatus.createFatalErrorStatus("Selected Element does not support moving");
	}
	return new RefactoringStatus();
    }
    
    @Override
    protected AbstractRefactoringCommand createExecutableRefactoringCommand() {
	return new MoveCommand(facade, elementToMoveAsMovableElement, target);
    }

}
