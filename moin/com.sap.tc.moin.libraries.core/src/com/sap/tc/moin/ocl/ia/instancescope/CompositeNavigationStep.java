package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * A navigation step that branches in several paths and combines the results into one.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public abstract class CompositeNavigationStep extends AbstractNavigationStep {
    private final NavigationStep[] steps;

    public CompositeNavigationStep(MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo, NavigationStep... steps) {
	super(sourceType, targetType, debugInfo);
	this.steps = steps;
    }
    
    public NavigationStep[] getSteps() {
	return steps;
    }

    /**
     * The default size in particular for atomic navigation steps is <tt>1</tt>.
     */
    @Override
    protected int size(Set<NavigationStep> visited) {
	int result = 0;
	if (!visited.contains(this)) {
	    visited.add(this);
	    for (NavigationStep step : steps) {
		result += ((AbstractNavigationStep) step).size(visited);
	    }
	}
	return result;
    }
}