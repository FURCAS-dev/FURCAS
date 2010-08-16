package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

/**
 * A navigation step that branches in several paths and combines the results into one. As hashCode and equals
 * depend on the subordinate steps, steps of this class register as {@link HashCodeChangeListener} on each
 * contained step and propagate the event correspondingly. The hash code combination for the subordinate
 * steps, once computed, is cached and updated when subordinate steps send hash code change events.
 */
public abstract class CompositeNavigationStep extends AbstractNavigationStep implements HashCodeChangeListener {
    private final NavigationStep[] steps;
    private int cachedXorOfStepHashCodes;
    private final SemanticIdentity semanticIdentity;

    public CompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo, NavigationStep... steps) {
	super(sourceType, targetType, debugInfo);
	this.steps = steps;
	for (NavigationStep step : steps) {
	    cachedXorOfStepHashCodes ^= step.hashCode();
	    step.addHashCodeChangeListener(this);
	}
	semanticIdentity = new CompositeNavigationStepIdentity();
    }

    private class CompositeNavigationStepIdentity extends SemanticIdentity {
	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || hashCode() != o.hashCode()) {
		return false;
	    }
	    if(o instanceof CompositeNavigationStep){
		NavigationStep[] otherSteps = ((CompositeNavigationStepIdentity) o).getNavigationStep().getSteps();

		if(otherSteps.length != steps.length){
		    return false;
		}

		for(int i = 0; i < steps.length; i++){
		    SemanticIdentity thisSubStepIdentity = steps[i].getSemanticIdentity();
		    SemanticIdentity otherSubStepIdentity = otherSteps[i].getSemanticIdentity();
		    if(!thisSubStepIdentity.equals(otherSubStepIdentity)){
			return false;
		    }
		}

		return true;
	    }else{
		return false;
	    }
	}

	@Override
	public int calculateHashCode() {
	    int hashCode = getSemanticIdentityOfSuper().hashCode();
	    hashCode = hashCode ^ cachedXorOfStepHashCodes;
	    return hashCode;
	}

	public CompositeNavigationStep getNavigationStep() {
	    return CompositeNavigationStep.this;
	}

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }

    private SemanticIdentity getSemanticIdentityOfSuper(){
	return super.getSemanticIdentity();
    }

    protected  SemanticIdentity getSemanticIdentityOfAbstractNavigationStep(){
	return super.getSemanticIdentity();
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

    @Override
    protected int distinctSize(Set<SemanticIdentity> visited) {
	int result = 0;
	if (!visited.contains(this.getSemanticIdentity())) {
	    visited.add(this.getSemanticIdentity());
	    result++;
	    for (NavigationStep step : steps) {
		result += ((AbstractNavigationStep) step).distinctSize(visited);
	    }
	}
	return result;
    }

    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}