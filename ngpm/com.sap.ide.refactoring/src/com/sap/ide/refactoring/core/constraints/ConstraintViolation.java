package com.sap.ide.refactoring.core.constraints;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.ui.ConstraintViolationStatusContext;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;

public class ConstraintViolation {

    public final OclMetaModelConstraintRegistration registration;
    public final RefObject elementInError;

    public ConstraintViolation(RefObject elementInError, OclMetaModelConstraintRegistration registration) {
	this.elementInError = elementInError;
	this.registration = registration;
    }
    
    /**
     * Short
     */
    public String getMessage() {
	return "Invalid constraint " + registration.getName() + " for " + RefactoringModelUtil.getModelElementNameAndType(elementInError);
    }
    
    /**
     * Detailed
     */
    public String getDescription() {
	return registration.getName() + ":\n\n" + registration.getOclExpression();
    }
    
    public RefactoringStatus asRefactoringStatus() {
	RefactoringStatusContext context = new ConstraintViolationStatusContext(this);
	int severity = getSeverity().asEclipseRefactoringSeverity();
	return RefactoringStatus.createStatus(severity, getMessage(), context, Activator.PLUGIN_ID, RefactoringStatusEntry.NO_CODE, null);
    }
    
    public RefactoringSeverity getSeverity() {
	return RefactoringSeverity.getForMoinSeverity(registration.getSeverity());
    }

}
