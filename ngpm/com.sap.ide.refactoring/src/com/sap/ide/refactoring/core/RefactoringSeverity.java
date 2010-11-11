package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

public enum RefactoringSeverity {
    
    FATAL(RefactoringStatus.FATAL, Status.ERROR),
    ERROR(RefactoringStatus.ERROR, Status.ERROR),
    WARNING(RefactoringStatus.WARNING, Status.WARNING),
    INFO(RefactoringStatus.INFO, Status.INFO);
    
    private final int eclipseRefactoringSeverity;
    private final int eclipseSeverity;

    private RefactoringSeverity(int i, int j) {
        this.eclipseRefactoringSeverity = i;
        this.eclipseSeverity = j;
    }
    
    public int asEclipseRefactoringSeverity() {
	return eclipseRefactoringSeverity;
    }
    
    public int asEclipseStatusSeverity() {
	return eclipseSeverity;
    }
    
    public static RefactoringSeverity getForMoinSeverity(OclRegistrationSeverity severity) {
	switch (severity) {
	case Error:
	    return ERROR;
	case Info:
	    return INFO;
	case Warning:
	    return WARNING;
	}
	throw new IllegalArgumentException("Unkonw severity " + severity);
    }
}