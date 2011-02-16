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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.ValueNotFoundException;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.SemanticIdentity;
import org.eclipse.ocl.utilities.PredefinedType;



/**
 * Evaluates an OCL expression that is expected to be the {@link IteratorExp#getBody() body} expression of an iterator expression.
 * Before the evaluation is triggered, the single iterator variable obtained from {@link LoopExp#getIterators()} is set to the
 * {@link RefObject} passed to {@link #navigate(CoreConnection, AnnotatedRefObjectImpl, Map, Set)} in the <tt>fromObject</tt>
 * parameter. Depending on the particular type of iterator (<tt>select</tt>, <tt>reject</tt> or <tt>any</tt>), the object is
 * passed on if and only if the OCL expression evaluates to <tt>true</tt>/<tt>false</tt>/<tt>true</tt>, respectively. For any
 * iterators other than <tt>select</tt>, <tt>reject</tt> or <tt>any</tt> the object is passed through right away because the
 * semantics of the iterator are not known.
 *
 * @author Axel Uhl D043530
 *
 */
public class PredicateCheckNavigationStep extends AbstractNavigationStep {
    private final String contentAsString;
    private final SemanticIdentity semanticIdentity;
    private final PartialEvaluatorFactory partialEvaluatorFactory;

    /**
     * Tells if the OCL predicate of the {@link #getIteratorExp() iterator expression} needs to be <tt>true</tt> so that the
     * element can pass through. This is the case for <tt>select</tt> and <tt>any</tt> iterators. For <tt>reject</tt> it's
     * <tt>false</tt>.
     */
    private final boolean positive;

    private final IteratorExp iteratorExp;

    /**
     * The opposite end finder is required for partial evaluation which shall use this finder to navigate
     * hidden opposites.
     */
    private final OppositeEndFinder oppositeEndFinder;
    
    private final OCLFactory oclFactory;

    public PredicateCheckNavigationStep(EClass sourceType, EClass targetType, IteratorExp iteratorExp, PathCache pathCache, OCLFactory oclFactory) {
        super(sourceType, targetType, (OCLExpression)iteratorExp);
        this.iteratorExp = iteratorExp;
        this.oclFactory = oclFactory;
        if (!haveIntersectingSubclassTree(sourceType, targetType)) {
            setAlwaysEmpty();
        }
        if (iteratorExp.getName().equals(PredefinedType.SELECT_NAME) || iteratorExp.getName().equals(PredefinedType.ANY_NAME)) {
            positive = true;
        } else {
            positive = false;
        }
        this.oppositeEndFinder = pathCache.getOppositeEndFinder();
        contentAsString = "checkPredicate[" + iteratorExp.getBody().toString() + "]";
        semanticIdentity = new PredicateCheckNavigationStepIdentity();
        partialEvaluatorFactory = pathCache.getInstanceScopeAnalysis().getPartialEvaluatorFactory();
    }

    private class PredicateCheckNavigationStepIdentity extends SemanticIdentity{
	public PredicateCheckNavigationStep getNavigationStep(){
	    return PredicateCheckNavigationStep.this;
	}

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || hashCode() != o.hashCode()) {
                return false;
            }
            return getSemanticIdentityOfSuper().equals(o) && PredicateCheckNavigationStep.this.positive == ((PredicateCheckNavigationStepIdentity)o).getNavigationStep().positive &&
                            PredicateCheckNavigationStep.this.iteratorExp.equals(((PredicateCheckNavigationStepIdentity)o).getNavigationStep().iteratorExp);
        }

        @Override
        public int calculateHashCode() {
            return getSemanticIdentityOfSuper().hashCode() ^ (positive ? 123 : 0) ^ iteratorExp.hashCode();
        }

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }

    public SemanticIdentity getSemanticIdentityOfSuper(){
	return super.getSemanticIdentity();
    }

    private IteratorExp getIteratorExp() {
        return iteratorExp;
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache,
            Notification atPre) {
        Set<AnnotatedEObject> result = new LinkedHashSet<AnnotatedEObject>(1);
        Set<EObject> sourceValue = new LinkedHashSet<EObject>(1);
        sourceValue.add(fromObject.getAnnotatedObject());
        boolean passedPredicate = evaluate((OCLExpression) getIteratorExp(), sourceValue, atPre);
        if (passedPredicate) {
            result.add(fromObject);
        }
        return result;
    }

    private Boolean evaluate(OCLExpression exp, Collection<EObject> sourceObjects, Notification atPre) {
        // evaluate whether the source object would have passed the iterator's body before the change

        Boolean resultPre = positive;
        if (atPre != null) {
            PartialEvaluatorImpl evalPre = partialEvaluatorFactory.createPartialEvaluator(atPre, oppositeEndFinder, oclFactory);
            try {
                Object result = evalPre.evaluate(null, (CallExp) exp, sourceObjects);
                resultPre = sourceObjects.contains(result);
            } catch (ValueNotFoundException vnfe) {
                // be conservative about undefined situations
                resultPre = positive;
            } catch (ClassCastException cce) {
                throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
            }
        }
        // evaluate whether the source object passes the iterator's body after the change

        PartialEvaluatorImpl evalPost = partialEvaluatorFactory.createPartialEvaluator(oppositeEndFinder, oclFactory);
        Boolean resultPost = positive;
		if (atPre == null || resultPre != positive) {
			try {
				Object result = evalPost.evaluate(null, (CallExp) exp,
						sourceObjects);
				if (result instanceof Collection<?>) {
					if (((Collection<?>) result).isEmpty()) {
						resultPost = false;
					} else {
						resultPost = sourceObjects
								.contains(((Collection<?>) result).iterator()
										.next());
					}
				} else {
					resultPost = sourceObjects.contains(result);
				}
			} catch (ValueNotFoundException vnfe) {
				// be conservative about undefined situations
				resultPost = positive;
			} catch (ClassCastException cce) {
				throw new RuntimeException(
						"The result of the iterator expression's body is not of type Boolean.");
			}
		}
        // if the source object fulfills the condition before or after the change event
        // or accesses an undefined variable before or after the change event
        // it passes this navigation step
        return (atPre != null && resultPre == positive) || resultPost == positive;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return contentAsString;
    }

    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}
