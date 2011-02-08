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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;


/**
 * Performs a sequence of navigation steps where the subsequent step uses as its input
 * the output of the previous step. When this navigation reaches an empty set, the result
 * of the entire navigation step sequence is defined to be empty, even if further navigation
 * steps follow. The rationale behind this is this: the navigation steps each compute
 * the set of objects that, when used as context for the root OCL expression, let the
 * subexpression for which the navigation step is responsible evaluate to a given element.
 * This means that when a navigation step produces an empty result, then for no element
 * does the subexpression produce the result sought. Therefore, the further ascend towards
 * the root expression's context can be aborted at that point.
 *
 */
public class NavigationStepSequence extends CompositeNavigationStep {

    /**
     * Because some {@link NavigationStep}s such as {@link IndirectingStep} may change
     * their source/target type as they get lazily initialized, this constructor passes
     * on <tt>null</tt> as source/target type. Instead, this class redefined
     * {@link #getSourceType()} and {@link #getTargetType()} and dynamically fetches them
     * from the underlying step sequence.
     */
    public NavigationStepSequence(OCLExpression debugInfo, NavigationStep... steps) {
	super(/* sourceType */ null, /* targetType */ null, debugInfo, compactSteps(steps, debugInfo));
	setSourceType(getSteps()[0].getSourceType());
	getSteps()[0].addSourceTypeChangeListener(new SourceTypeChangeListener() {
	    public void sourceTypeChanged(NavigationStep stepForWhichSourceTypeChanged) {
		assert stepForWhichSourceTypeChanged == getSteps()[0];
		setSourceType(stepForWhichSourceTypeChanged.getSourceType());
	    }
	});
	setTargetType(getSteps()[getSteps().length-1].getTargetType());
	getSteps()[getSteps().length-1].addTargetTypeChangeListener(new TargetTypeChangeListener() {
	    public void targetTypeChanged(NavigationStep stepForWhichTargetTypeChanged) {
		assert stepForWhichTargetTypeChanged == getSteps()[getSteps().length-1];
		setTargetType(stepForWhichTargetTypeChanged.getTargetType());
	    }
	});
	if (isOneStepAlwaysEmpty()) {
	    setAlwaysEmpty();
	}
	for (int i=0; i<getSteps().length; i++) {
	    final NavigationStep step = getSteps()[i];
	    if (!isAlwaysEmpty()) {
		step.addAlwaysEmptyChangeListener(new AlwaysEmptyChangeListener() {
		    public void alwaysEmptyChanged(NavigationStep stepForWhichAlwaysEmptyChanged) {
			setAlwaysEmpty();
		    }
		});
	    }
	    if (step.getSourceType() == null && i>0) {
		final int pos = i;
		step.addSourceTypeChangeListener(new SourceTypeChangeListener() {
		    public void sourceTypeChanged(NavigationStep stepForWhichSourceTypeChanged) {
			assert stepForWhichSourceTypeChanged == step;
			if (!AbstractNavigationStep.haveIntersectingSubclassTree(getSteps()[pos-1].getTargetType(), step.getSourceType())) {
			    setAlwaysEmpty();
			}
		    }
		});
	    }
	    if (step.getTargetType() == null && i<getSteps().length-1) {
		final int pos = i;
		step.addTargetTypeChangeListener(new TargetTypeChangeListener() {
		    public void targetTypeChanged(NavigationStep stepForWhichTargetTypeChanged) {
			assert stepForWhichTargetTypeChanged == step;
			if (!AbstractNavigationStep.haveIntersectingSubclassTree(getSteps()[pos-1].getTargetType(), step.getTargetType())) {
			    setAlwaysEmpty();
			}
		    }
		});
	    }
	}
    }
    
    private boolean isOneStepAlwaysEmpty() {
	for (NavigationStep step : getSteps()) {
	    if (step.isAlwaysEmpty()) {
		return true;
	    }
	}
	return false;
    }

    private static boolean conformsTo(EClass sub, EClass sup) {
	return (sub.equals(sup) || sub.getEAllSuperTypes().contains(sup));
    }

    /**
     * We don't pull up {@link NavigationStep#isAbsolute() absolute} steps immediately because they may be expensive
     * <tt>allInstances</tt> steps that may be avoided if along the path there are type filters that lead to an empty
     * set already before the <tt>allInstances</tt> step is reached. However, if the last step is
     * {@link NavigationStep#isAlwaysEmpty() always empty}, this can be made the one single step of this sequence, and
     * the entire sequence can then be considered to always return the empty set.
     * 
     * @param debugInfo
     *            used in case a simplifying {@link EmptyResultNavigationStep} is created for the sequence
     */
    private static NavigationStep[] compactSteps(NavigationStep[] steps, OCLExpression debugInfo) {
	if (steps.length==0) {
	    throw new RuntimeException("NavigationStepSequence must at least have one element");
	}
	List<NavigationStep> result = new ArrayList<NavigationStep>();
	if (steps[steps.length-1].isAlwaysEmpty()) {
	    result.add(steps[steps.length-1]);
	} else {
	    // if a previous step's target type has no subclass tree intersection with the next step's
	    // source type, the sequence will always evaluate to an empty set and can therefore be
	    // cut short.
	    boolean alwaysEmptyBecauseOfTypeMismatch = false;
	    NavigationStep firstRedundantIdentityNavigationStep = null;
	    for (int i=0; i<steps.length && !alwaysEmptyBecauseOfTypeMismatch; i++) {
		if (i>0 && !AbstractNavigationStep.haveIntersectingSubclassTree(steps[i-1].getTargetType(), steps[i].getSourceType())) {
		    alwaysEmptyBecauseOfTypeMismatch = true;
		} else {
		    // eliminiate unnecessary IdentityNavigationSteps where the type constraints don't further constrain
		    if (!(steps[i] instanceof IdentityNavigationStep)
			    || (i == 0 || !conformsTo(steps[i - 1].getTargetType(), steps[i].getSourceType()))
			    && (i == steps.length - 1 || !conformsTo(steps[i].getTargetType(), steps[i + 1]
				    .getSourceType()))) {
			result.add(steps[i]);
		    } else if (firstRedundantIdentityNavigationStep == null) {
			// remember first redundant IdentityNavigationStep in case there are only such steps
			firstRedundantIdentityNavigationStep = steps[i];
		    }
		}
	    }
	    if (alwaysEmptyBecauseOfTypeMismatch) {
		result.clear();
		result.add(new EmptyResultNavigationStep(debugInfo));
	    } else if (result.size() == 0) { // means that all steps were redundant IdentityNavigationSteps; keep first
		result.add(firstRedundantIdentityNavigationStep);
	    }
	}
	return result.toArray(new NavigationStep[0]);
    }

    /**
     * The sequence is considered absolute if its last step is always empty. This is equivalent to
     * {@link #isAlwaysEmpty()}.
     */
    @Override
    public boolean isAbsolute() {
	return isAlwaysEmpty();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
	Set<AnnotatedEObject> result = Collections.singleton(fromObject);
	if (isAlwaysEmpty()) {
	    result = Collections.emptySet();
	} else {
	    // If the navigation along the sequence produces an empty set, we can abort
	    // the navigation.
	    for (int i=0; !result.isEmpty() && i<getSteps().length; i++) {
		result = getSteps()[i].navigate(result, cache, changeEvent);
	    }
	}
	return result;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	StringBuilder sb = new StringBuilder();
	boolean first = true;
	for (NavigationStep step : getSteps()) {
	    if (!first) {
		sb.append('.');
	    } else {
		first = false;
	    }
	    if (step instanceof AbstractNavigationStep) {
		sb.append(((AbstractNavigationStep) step).toString(visited, indent));
	    } else {
		sb.append(step);
	    }
	}
	return sb.toString();
    }
}
