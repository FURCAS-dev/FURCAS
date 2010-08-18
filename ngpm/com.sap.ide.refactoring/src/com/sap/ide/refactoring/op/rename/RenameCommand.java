package com.sap.ide.refactoring.op.rename;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.model.rename.NamedElement;
import com.sap.ide.refactoring.core.model.validation.AbstractValidationCommand;
import com.sap.ide.refactoring.core.model.validation.CheckBlockIsParsableCommand;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;



public class RenameCommand extends AbstractRefactoringCommand {

    private final NamedElement target;
    private final String newName;
    private final RefactoringEditorFacade facade;

    public RenameCommand(RefactoringEditorFacade facade, NamedElement target, String newName) {
	super(facade.getConnection(), "Rename ModelElement");

	this.facade = facade;
	this.target = target;
	this.newName = newName;
    }

    @Override
    public Collection<EOperation> getAffectedPartitions() {
	URI pri = target.getWrappedModelElement().get___Partition().getPri();
	return Collections.singleton(new EOperation(Operation.EDIT, pri));
    }

    @Override
    protected void performRefactoring() {
	target.setName(newName);
    }

    @Override
    public RefactoringStatus postValidate() {
	RefactoringStatus status = new RefactoringStatus();

	AbstractValidationCommand cmd = new CheckBlockIsParsableCommand(facade, facade.getTextBlocksModel().getRoot());
	cmd.execute();
	status.merge(cmd.getResultAsStatus());

	return status;
    }

}
