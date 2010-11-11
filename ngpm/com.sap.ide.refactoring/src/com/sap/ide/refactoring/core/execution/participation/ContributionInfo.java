package com.sap.ide.refactoring.core.execution.participation;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class ContributionInfo {
    
    public final Change change;
    public final RefactoringStatus status;
    
    public ContributionInfo(Change change, RefactoringStatus status) {
	this.change = change;
	this.status = status;
    }
    
    public ContributionInfo(RefactoringStatus status) {
	this(new NullChange(), status);
    }
    
    

}
