package com.sap.emf.ocl.attributegrammar;

import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

public class RuleTypeConformanceException extends Exception {
    private static final long serialVersionUID = -4640586353971746482L;
    
    private Map<EStructuralFeature, OCLExpression> nonConformingRules;

    public Map<EStructuralFeature, OCLExpression> getNonConformingRules() {
        return nonConformingRules;
    }

    public RuleTypeConformanceException(Map<EStructuralFeature, OCLExpression> nonConformingRules) {
        this.nonConformingRules = nonConformingRules;
    }
    
    @Override
    public String getMessage() {
        StringBuilder result = new StringBuilder("Attribute grammar rules with non-conforming types detected:\n");
        for (Map.Entry<EStructuralFeature, OCLExpression> entry : getNonConformingRules().entrySet()) {
            result.append("  expression's type ");
            result.append(entry.getValue().getType());
            result.append(" does not conform to the type of feature ");
            result.append(entry.getKey());
            result.append('\n');
        }
        return result.toString();
    }
}
