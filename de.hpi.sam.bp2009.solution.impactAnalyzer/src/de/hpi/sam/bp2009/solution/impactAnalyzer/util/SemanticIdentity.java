package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;

public abstract class SemanticIdentity {
    private boolean currentlyEvaluatingHashCode = false;

    @Override
    public abstract boolean equals(Object arg0);

    @Override
    public synchronized int hashCode() {
	int result = 0;
	if (!currentlyEvaluatingHashCode) {
	    currentlyEvaluatingHashCode = true;
	    result = calculateHashCode();
	}
	currentlyEvaluatingHashCode = false;
	return result;
    }

    protected abstract int calculateHashCode();

    public abstract NavigationStep getStep();
}
