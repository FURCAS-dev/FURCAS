package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A navigation step that branches in several paths and combines the results into one. As hashCode and equals
 * depend on the subordinate steps, steps of this class register as {@link HashCodeChangeListener} on each
 * contained step and propagate the event correspondingly. The hash code combination for the subordinate
 * steps, once computed, is cached and updated when subordinate steps send hash code change events.
 */
public abstract class CompositeNavigationStep extends AbstractNavigationStep implements HashCodeChangeListener {
    private final NavigationStep[] steps;
    private int cachedXorOfStepHashCodes;

    public CompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo, NavigationStep... steps) {
	super(sourceType, targetType, debugInfo);
	this.steps = steps;
	for (NavigationStep step : steps) {
	    cachedXorOfStepHashCodes ^= step.hashCode();
	    step.addHashCodeChangeListener(this);
	}
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || hashCode() != o.hashCode()) {
            return false;
        }
        return super.equals(o) && Arrays.equals(steps, ((CompositeNavigationStep) o).steps);
    }
    
    protected boolean abstractNavigationStepEquals(Object o) {
        return super.equals(o);
    }
    
    public int hashCode() {
        return super.hashCode() ^ cachedXorOfStepHashCodes;
    }
    
    public NavigationStep[] getSteps() {
	return steps;
    }
    
    @Override
    public void beforeHashCodeChange(NavigationStep step, int token) {
        fireBeforeHashCodeChange(token);
        cachedXorOfStepHashCodes ^= step.hashCode();
    }
    
    @Override
    public void afterHashCodeChange(NavigationStep step, int token) {
        cachedXorOfStepHashCodes ^= step.hashCode();
        fireAfterHashCodeChange(token);
    }
    
    /**
     * The default size in particular for atomic navigation steps is <tt>1</tt>.
     */
    @Override
    protected int size(Set<NavigationStep> visited) {
	int result = 0;
	if (!visited.contains(this)) {
	    visited.add(this);
	    result++;
	    for (NavigationStep step : steps) {
		result += ((AbstractNavigationStep) step).size(visited);
	    }
	}
	return result;
    }
}