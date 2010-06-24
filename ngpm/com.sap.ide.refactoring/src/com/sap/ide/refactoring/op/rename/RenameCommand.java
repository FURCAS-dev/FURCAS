package com.sap.ide.refactoring.op.rename;

import java.util.Collection;
import java.util.Collections;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.model.rename.NamedElement;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;

public class RenameCommand extends AbstractRefactoringCommand {

    private final NamedElement target;
    private final String newName;

    public RenameCommand(RefactoringEditorFacade facade, NamedElement target, String newName) {
	super(facade.getConnection(), "Rename ModelElement");

	this.target = target;
	this.newName = newName;
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	PRI pri = target.getWrappedModelElement().get___Partition().getPri();
	return Collections.singleton(new PartitionOperation(Operation.EDIT, pri));
    }

    @Override
    protected void performRefactoring() {
	target.setName(newName);
    }

}
