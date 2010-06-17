package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import org.eclipse.ocl.ecore.OCLExpression;

public abstract class DeltaPropagationStrategyWithTargetExpression implements DeltaPropagationStrategy {
    private final OCLExpression propagatesTo;

    protected DeltaPropagationStrategyWithTargetExpression(OCLExpression propagatesTo) {
        this.propagatesTo = propagatesTo;
    }
    
    protected OCLExpression getPropagatesTo() {
        return propagatesTo;
    }

}
