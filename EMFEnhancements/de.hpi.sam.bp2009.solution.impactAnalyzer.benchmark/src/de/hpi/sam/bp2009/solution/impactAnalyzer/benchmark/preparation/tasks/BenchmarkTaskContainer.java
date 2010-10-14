package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.concurrent.ConcurrentLinkedQueue;


public abstract class BenchmarkTaskContainer extends ConcurrentLinkedQueue<BenchmarkTask> {
	private static final long serialVersionUID = 1L;

	public abstract void beforeBenchmark();
	public abstract void afterBenchmark();	
}
