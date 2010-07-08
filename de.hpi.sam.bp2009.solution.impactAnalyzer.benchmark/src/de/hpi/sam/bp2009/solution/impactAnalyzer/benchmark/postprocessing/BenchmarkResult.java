package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * A {@link BenchmarkResult} contains the information which was extracted by
 * benchmarking a single {@link BenchmarkTask}.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkResult {

    public String toCsvString();

}
