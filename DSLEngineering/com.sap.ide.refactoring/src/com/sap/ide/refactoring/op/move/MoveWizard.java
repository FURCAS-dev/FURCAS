package com.sap.ide.refactoring.op.move;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

public class MoveWizard extends RefactoringWizard {

    public MoveWizard(Refactoring refactoring) {
	super(refactoring, DIALOG_BASED_USER_INTERFACE | PREVIEW_EXPAND_FIRST_NODE);
    }

    @Override
    protected void addUserInputPages() {
	addPage(new MoveInputPage("Select Moving Target"));
    }

}
