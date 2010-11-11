package com.sap.ide.refactoring.op.move;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.model.move.MovableElement;
import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;

public class MoveCommand extends AbstractRefactoringCommand {

    private final MovableElement elementToMove;
    private final MovableElementTarget target;

    protected MoveCommand(RefactoringEditorFacade facade, MovableElement elementToMove, MovableElementTarget target) {
	super(facade.getEditorConnection(), "Move ModelElement");
	this.elementToMove = elementToMove;
	this.target = target;
    }

    @Override
    protected void performRefactoring(IProgressMonitor pm) {
	pm.beginTask("Moving... (including reference re-evaluations)", 1);
	try {
	    target.movetoHere();
	} finally {
	    pm.done();
	}
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	PRI targetPri = target.getWrappedModelElement().get___Partition().getPri();
	PRI sourcePri = elementToMove.getWrappedModelElement().get___Partition().getPri();

	return Arrays.asList(new PartitionOperation(Operation.EDIT, targetPri), new PartitionOperation(Operation.EDIT, sourcePri));
    }
}
