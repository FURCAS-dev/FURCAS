package com.sap.ide.refactoring.core.reference;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.ui.ReEvaluationStatusContext;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ReEvaluationInfo {
    
    public final DelayedReference ref;
    public final RefObject modelElement;
    public final Object originalValue;
    public final Object currentValue;
    public final ReEvaluationType type;
    private RefactoringSeverity severity = RefactoringSeverity.WARNING; // default severity

    public ReEvaluationInfo(DelayedReference ref, RefObject modelElement, Object originalValue, Object currentValue, ReEvaluationType type) {
	this.ref = ref;
	this.modelElement = modelElement;
	this.originalValue = originalValue;
	this.currentValue = currentValue;
	this.type = type;
    }

    public String getMessage() {
        return type + ": " + ref.getPropertyName() + " on " + RefactoringModelUtil.getModelElementNameAndType(modelElement) + " from " + getNameFor(originalValue) + " to " + getNameFor(currentValue) + " (via " +  ref.getOclQuery() +")";
    }
    
    private String getNameFor(Object value) {
	if (originalValue instanceof RefObject) {
	    return RefactoringModelUtil.getModelElementNameAndType((RefObject) value);
	} else {
	    return value.toString();
	}
    }

    public RefactoringStatus asRefactoringStatus() {
	ReEvaluationStatusContext context = new ReEvaluationStatusContext(this);
	int severity = getSeverity().asEclipseRefactoringSeverity();
	return RefactoringStatus.createStatus(severity, getMessage(), context, Activator.PLUGIN_ID, RefactoringStatusEntry.NO_CODE, null);
    }
    
    public RefactoringSeverity getSeverity() {
	return severity;
    }
    
    /**
     * Allows refactorings to set a new severity within their postValidation step.
     * @param severity
     */
    public void setSeverity(RefactoringSeverity severity) {
	this.severity  = severity;
    }
}
