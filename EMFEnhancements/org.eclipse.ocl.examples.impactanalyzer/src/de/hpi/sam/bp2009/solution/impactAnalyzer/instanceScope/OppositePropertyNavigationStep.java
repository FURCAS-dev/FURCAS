/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

public class OppositePropertyNavigationStep extends AbstractNavigationStep {

    private final EStructuralFeature property;
    private final OppositeEndFinder oppositeEndFinder;
    private final SemanticIdentity semanticIdentity;

    public OppositePropertyNavigationStep(EClass sourceType, EClass targetType, EStructuralFeature property,
            OCLExpression debugInfo2, OppositeEndFinder oppositeEndFinder) {
        super(sourceType, targetType, debugInfo2);
        this.property = property;
	this.oppositeEndFinder = oppositeEndFinder;
	this.semanticIdentity = new OppositePropertyNavigationStepIdentity();
    }

    private class OppositePropertyNavigationStepIdentity extends SemanticIdentity {
	public OppositePropertyNavigationStep getNavigationStep() {
	    return OppositePropertyNavigationStep.this;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || hashCode() != o.hashCode()) {
		return false;
	    }
	    return getSemanticIdentityOfSuper().equals(o)
		    && property.equals(((OppositePropertyNavigationStepIdentity) o).getNavigationStep().property);
	}

	@Override
	public int calculateHashCode() {
	    return getSemanticIdentityOfSuper().hashCode() ^ property.hashCode();
	}

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }

    public SemanticIdentity getSemanticIdentityOfSuper() {
	return super.getSemanticIdentity();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache,
	    Notification changeEvent) {
	Collection<EObject> result = new HashSet<EObject>();
	Set<AnnotatedEObject> returnValue = new HashSet<AnnotatedEObject>();
	if (property instanceof EReference) {
	    // EcoreHelper.getInstance().reverseNavigate(fromObject.getAnnotatedObject(),
	    // (EReference) property, scope, result);
	    Object navigationResult = oppositeEndFinder.navigateOppositePropertyWithBackwardScope((EReference) property,
		    fromObject.getAnnotatedObject());
	    if (navigationResult instanceof Collection<?>) {
		@SuppressWarnings("unchecked")
		Collection<? extends EObject> eObjectCollectionNavigationResult = (Collection<? extends EObject>) navigationResult;
		result.addAll(eObjectCollectionNavigationResult);
	    } else {
		if (navigationResult != null) {
		    result.add((EObject) navigationResult);
		}
	    }
	}
	for (EObject o : result) {
	    returnValue.add(annotateEObject(fromObject, o));
	}
	return returnValue;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return "opposite of "+property.getName();
    }

    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}
