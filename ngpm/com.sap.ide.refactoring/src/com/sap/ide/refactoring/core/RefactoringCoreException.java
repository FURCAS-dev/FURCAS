package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.ui.ExceptionStatusContext;

public class RefactoringCoreException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public RefactoringCoreException(String message) {
	super(message);
    }

    public RefactoringCoreException(Throwable cause) {
	super(cause);
    }

    public RefactoringCoreException(String message, Throwable cause) {
	super(message, cause);
    }

    public RefactoringStatus asRefactoringStatus(RefactoringSeverity severity) {
	ExceptionStatusContext context = new ExceptionStatusContext(getCause() == null ? this : getCause());
	return RefactoringStatus.createStatus(severity.asEclipseRefactoringSeverity(), "An exception occured: " + this.getMessage(),
		context, Activator.PLUGIN_ID, 0, null);
    }
    
    public IStatus asEclipseStatus(RefactoringSeverity severity) {
	return new Status(severity.asEclipseStatusSeverity(), Activator.PLUGIN_ID, "An exception occured: " + this.getMessage(), getCause());
	
    }
}
