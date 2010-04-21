package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * A navigation step that branches in several paths and combines the results into one.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public abstract class CompositeNavigationStep extends AbstractNavigationStep {
    private final NavigationStep[] steps;

    public CompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression<EClassifier> debugInfo, NavigationStep... steps) {
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