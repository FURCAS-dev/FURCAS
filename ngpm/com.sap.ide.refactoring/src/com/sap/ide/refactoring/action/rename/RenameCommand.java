package com.sap.ide.refactoring.action.rename;

import java.util.Collection;
import java.util.Collections;

import com.sap.ide.refactoring.core.TextBlockAwareRefactoringCommand;
import com.sap.ide.refactoring.core.model.NamedElement;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;

public class RenameCommand extends TextBlockAwareRefactoringCommand {

    private final NamedElement target;
    private final String newName;
    private final RefactoringEditorFacade facade;

    public RenameCommand(RefactoringEditorFacade facade, NamedElement target, String newName) {
	super(facade, "Rename ModelElement");
	
	this.facade = facade;
	this.target = target;
	this.newName = newName;
    }

    @Override
    public boolean canExecute() {
	return true;
    }
    
    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	PRI pri = target.getOriginalElement().get___Partition().getPri();
	return Collections.singleton(new PartitionOperation(Operation.EDIT, pri));
    }

    @Override
    protected void performRefactoring() {
	target.setName(newName);
	facade.prettyPrintShort(facade.getTextBlocksModel());
    }

}
