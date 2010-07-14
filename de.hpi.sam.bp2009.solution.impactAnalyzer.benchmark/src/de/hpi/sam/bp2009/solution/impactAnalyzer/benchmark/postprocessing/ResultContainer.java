package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.File;

public interface ResultContainer {
    public void printCsv(File f);
    public int size();
    public void addResult(BenchmarkResult benchResult);
}
