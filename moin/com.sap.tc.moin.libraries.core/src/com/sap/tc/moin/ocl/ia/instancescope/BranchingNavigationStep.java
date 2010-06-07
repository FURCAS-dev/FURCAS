package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * A navigation step that branches in several paths and combines the results into one.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public class BranchingNavigationStep extends CompositeNavigationStep {
    /**
     * Marks steps that because of source or target type mismatches don't need to be evaluated in the scope of this
     * branching step. This step tracks initially unknown source/target types so that additional steps may be marked as
     * empty in this step's context.
     */
    private Set<NavigationStep> stepsAlwaysEmptyInThisStepsContext;
    
    public BranchingNavigationStep(final CoreConnection conn, MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo, final PathCache pathCache, NavigationStep... parallelSteps) {
	// TODO be smart about allInstances steps that subsume other steps with same or specialized targetType
	// TODO be smart and recognize alwaysEmpty in case of a single GOTO that goes immediately to this
	// TODO be smart and combine steps where one is just an indirection for another
	// TODO if parallelSteps contains a BranchingNavigationStep, pull its branches up into this step
	super(sourceType, targetType, debugInfo, parallelSteps);
	stepsAlwaysEmptyInThisStepsContext = new HashSet<NavigationStep>();
	if (areAllStepsAlwaysEmpty()) {
	    setAlwaysEmpty();
	} else {
	    for (NavigationStep step : getSteps()) {
		if (step.isAlwaysEmpty()) {
		    stepsAlwaysEmptyInThisStepsContext.add(step);
		} else {
		    step.addAlwaysEmptyChangeListener(new AlwaysEmptyChangeListener() {
			@Override
			public void alwaysEmptyChanged(NavigationStep stepForWhichAlwaysEmptyChanged) {
			    stepsAlwaysEmptyInThisStepsContext.add(stepForWhichAlwaysEmptyChanged);
			    if (stepsAlwaysEmptyInThisStepsContext.size() == getSteps().length) {
				setAlwaysEmpty();
			    }
			}
		    });
		    if (step.getSourceType() == null) {
			step.addASourceTypeChangeListener(new SourceTypeChangeListener() {
			    @Override
			    public void sourceTypeChanged(NavigationStep stepForWhichSourceTypeChanged) {
				// if source type is set where it was previously not set, check if that step
				// can be removed
				if (!pathCache.haveIntersectingSubclassTree(conn, stepForWhichSourceTypeChanged.getSourceType(), getSourceType())) {
				    stepsAlwaysEmptyInThisStepsContext.add(stepForWhichSourceTypeChanged);
				    if (stepsAlwaysEmptyInThisStepsContext.size() == getSteps().length) {
					setAlwaysEmpty();
				    }
				}
			    }
			});
		    } else {
			if (!pathCache.haveIntersectingSubclassTree(conn, step.getSourceType(), getSourceType())) {
			    stepsAlwaysEmptyInThisStepsContext.add(step);
			}
		    }
		    if (step.getTargetType() == null) {
			step.addTargetTypeChangeListener(new TargetTypeChangeListener() {
			    @Override
			    public void targetTypeChanged(NavigationStep stepForWhichTargetTypeChanged) {
				// if source type is set where it was previously not set, check if that step
				// can be removed
				if (!pathCache.haveIntersectingSubclassTree(conn, stepForWhichTargetTypeChanged.getTargetType(), getTargetType())) {
				    stepsAlwaysEmptyInThisStepsContext.add(stepForWhichTargetTypeChanged);
				    if (stepsAlwaysEmptyInThisStepsContext.size() == getSteps().length) {
					setAlwaysEmpty();
				    }
				}
			    }
			});
		    } else {
			if (!pathCache.haveIntersectingSubclassTree(conn, step.getSourceType(), getTargetType())) {
			    stepsAlwaysEmptyInThisStepsContext.add(step);
			}
		    }
		}
	    }
	}
    }

    private boolean areAllStepsAlwaysEmpty() {
	boolean result = true;
	for (int i=0; result && i<getSteps().length; i++) {
	    result = getSteps()[i].isAlwaysEmpty();
	}
	return result;
    }
    
    /**
     * If there are no branches, the step always returns an empty result and therefore is
     * absolute, regardless its inputs.
     */
    @Override
    public boolean isAbsolute() {
	return isAlwaysEmpty();
    }
    
    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	Set<AnnotatedRefObjectImpl> result = new HashSet<AnnotatedRefObjectImpl>();
	for (NavigationStep singleStep : getSteps()) {
	    Set<AnnotatedRefObjectImpl> fromSet = Collections.singleton(fromObject);
	    result.addAll(singleStep.navigate(conn, fromSet, cache, throwExceptionWhenVisiting));
	}
	return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	StringBuilder sb = new StringBuilder();
	boolean first = true;
	sb.append("{\n");
	for (NavigationStep step : getSteps()) {
	    addIndent(indent+2, sb);
	    if (!first) {
		sb.append("| ");
	    } else {
		first = false;
	    }
	    if (step instanceof AbstractNavigationStep) {
		sb.append(((AbstractNavigationStep) step).toString(visited, indent+2));
	    } else {
		sb.append(step);
	    }
	    sb.append('\n');
	}
	addIndent(indent, sb);
	sb.append('}');
	return sb.toString();
    }

    private void addIndent(int indent, StringBuilder sb) {
	for (int i=0; i<indent; i++) {
	    sb.append(' ');
	}
    }
}
