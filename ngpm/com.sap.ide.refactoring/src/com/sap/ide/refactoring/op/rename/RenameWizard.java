package com.sap.ide.refactoring.op.rename;

import org.eclipse.ltk.ui.refactoring.RefactoringWizard;


public class RenameWizard extends RefactoringWizard {
    
    public RenameWizard(RenameRefactoring refactoring) {
	super(refactoring, DIALOG_BASED_USER_INTERFACE | PREVIEW_EXPAND_FIRST_NODE);
    }
    
    @Override
    protected void addUserInputPages() {
	addPage(new RenameInputPage("Choose Name"));
    }

}
