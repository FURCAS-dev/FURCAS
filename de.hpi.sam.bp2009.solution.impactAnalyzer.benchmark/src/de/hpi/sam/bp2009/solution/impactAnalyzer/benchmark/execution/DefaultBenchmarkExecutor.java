package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public abstract class DefaultBenchmarkExecutor implements BenchmarkExecutor {

    protected BenchmarkTask task;
    protected Object returnValue;

    @Override
    public void setTask(BenchmarkTask task) {
	this.task = task;
    }

    @Override
    public BenchmarkTask getTask() {
	return task;
    }

    public BenchmarkResult execute() {
	if (task == null)
	    throw new RuntimeException("Execution not possible because task was not set");

	return performBenchmark();
    }

    protected abstract BenchmarkResult performBenchmark();

    @Override
    public Object getReturnValue() {
	return returnValue;
    }

}
