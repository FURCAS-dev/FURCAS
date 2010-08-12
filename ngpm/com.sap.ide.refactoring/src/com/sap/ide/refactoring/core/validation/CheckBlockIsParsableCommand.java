package com.sap.ide.refactoring.core.validation;

import java.util.Collection;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import textblocks.TextBlock;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.grammar.impl.ParsingError;

public class CheckBlockIsParsableCommand extends AbstractValidationCommand {

    private final RefactoringEditorFacade facade;
    private final TextBlock rootBlock;

    public CheckBlockIsParsableCommand(RefactoringEditorFacade facade, TextBlock rootBlock) {
	super(facade.getEditorConnection(), "Assert that block remains parsable");
	
	this.facade = facade;
	this.rootBlock = rootBlock;
    }

    @Override
    public void doExecute() {
	Collection<ParsingError> errors = facade.checkAndGetSyntacticalErrors(rootBlock);
	for (ParsingError error : errors) {
	    String msg = "Syntax error present";
	    status.merge(RefactoringStatus.createWarningStatus(msg + ": " + error.getMessage()));
	}
    }



}
