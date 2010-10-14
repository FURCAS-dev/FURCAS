package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import org.eclipse.ocl.ecore.OCLExpression;

public abstract class DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator extends
        DeltaPropagationStrategyWithTargetExpression {
    private final PartialEvaluator evaluator;

    protected DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator(OCLExpression propagatesTo, PartialEvaluator evaluator) {
        super(propagatesTo);
        this.evaluator = evaluator;
    }
    
    protected PartialEvaluator getEvaluator() {
        return evaluator;
    }

}
