package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.Collection;


/**
 * A {@link OCLExpressionPicker} provides a bunch of parsed OCL expressions
 * which can be used for benchmarking or testing.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface OCLExpressionPicker {
    public Collection<OCLExpressionWithContext> pickUpExpressions();
}
