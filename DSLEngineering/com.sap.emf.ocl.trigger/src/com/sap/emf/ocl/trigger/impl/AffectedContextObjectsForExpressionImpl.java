package com.sap.emf.ocl.trigger.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.trigger.AffectedContextObjectsForExpression;

public class AffectedContextObjectsForExpressionImpl implements AffectedContextObjectsForExpression {
    private final OCLExpression expression;
    private final Collection<EObject> affectedObjects;
    
    AffectedContextObjectsForExpressionImpl(OCLExpression expression, Collection<EObject> affectedObjects) {
        super();
        this.expression = expression;
        this.affectedObjects = affectedObjects;
    }

    @Override
    public OCLExpression getExpression() {
        return expression;
    }

    @Override
    public Collection<EObject> getAffectedObjects() {
        return Collections.unmodifiableCollection(affectedObjects);
    }

}
