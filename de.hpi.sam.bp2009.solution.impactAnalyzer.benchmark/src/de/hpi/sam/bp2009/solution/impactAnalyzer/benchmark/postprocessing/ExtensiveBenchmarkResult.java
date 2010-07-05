package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import bb.util.Benchmark;

public class ExtensiveBenchmarkResult implements BenchmarkResult{
    private Benchmark benchmark;

    public ExtensiveBenchmarkResult(Benchmark benchmark) {
	this.benchmark = benchmark;
    }
    
    public void setBenchmark(Benchmark benchmark) {
	this.benchmark = benchmark;
    }

    public Benchmark getBenchmark() {
	return benchmark;
    }
    
    public String toString(){
	return benchmark.toString();
    }

    @Override
    public String toCsvString() {
	return benchmark.toString();
    }
}
