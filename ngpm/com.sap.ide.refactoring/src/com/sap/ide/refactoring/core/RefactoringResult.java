package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class RefactoringResult {
    
    public final Change change;
    public final RefactoringStatus status;
    
    public RefactoringResult(Change change, RefactoringStatus status) {
	this.change = change;
	this.status = status;
    }
}
