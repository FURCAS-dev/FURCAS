package com.sap.tc.moin.ocl.ia.instancescope;

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
    
    protected NavigationStep[] getSteps() {
	return steps;
    }

}
