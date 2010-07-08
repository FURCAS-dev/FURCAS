package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * A {@link BenchmarkExecutor} contains the logic for executing a single {@link BenchmarkTask}.
 * After executing the task a {@link BenchmarkResult} is returned by this class.
 *
 * For create a new {@link BenchmarkExecutor} it is recommended to extend from {@link DefaultBenchmarkExecutor}
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkExecutor {
    public void setTask(BenchmarkTask task);

    /**
     * Executes the setted @{link {@link BenchmarkTask} and benchmarks its execution.
     *
     * @throws An RuntimeException if the task was not set on the BenchmarkExecutor
     * @return A BenchmarkResult for the given {@link BenchmarkTask}
     */
    public BenchmarkResult execute();

    /**
     * @return returns the value of the {@link BenchmarkTask.call()} method of a {@link BenchmarkTask}
     */
    public Object getReturnValue();

    public BenchmarkTask getTask();
}
