package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.IOException;
import java.io.OutputStream;

import bb.util.Benchmark;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ExtensiveBenchmarkResult")
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

    @Override
    public String toString(){
	return benchmark.toString();
    }

    @Override
    public String toCsvString() {
	return benchmark.toString();
    }

    @Override
    public int writeDataSet(OutputStream os, boolean withHeadline, int lineOffset) throws IOException {
	// TODO Auto-generated method stub
	throw new RuntimeException("Method not implemented");
    }
}
