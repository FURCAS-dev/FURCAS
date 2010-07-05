package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public interface BenchmarkExecutor {
    public void setTask(BenchmarkTask task);

    public BenchmarkResult execute();

    public Object getReturnValue();

    public BenchmarkTask getTask();
}
