package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;


public interface ResultContainer {
    public int size();
    public void addResult(BenchmarkResult benchResult);
}
