package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.IOException;
import java.io.OutputStream;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * A {@link BenchmarkResult} contains the information which was extracted by
 * benchmarking a single {@link BenchmarkTask}.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkResult {

    public String toCsvString();
    public int writeDataSet(OutputStream os, boolean withHeadline, int lineOffset) throws IOException;

}
