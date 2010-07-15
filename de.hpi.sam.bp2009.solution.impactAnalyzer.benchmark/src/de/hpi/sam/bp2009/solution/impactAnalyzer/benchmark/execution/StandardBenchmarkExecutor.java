package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.ArrayList;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkMeasurements;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.DefaultBenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * The {@link StandardBenchmarkExecutor} benchmarks {@link BenchmarkTasks} by measuring
 * per System.nanoTime() before and after executing the task.
 *
 * It executes a {@link BenchmarkTask} several times in order to see effects of
 * caching and initalization. However, it does not respect other well-known
 * rules for micro-benchmarking Java code.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class StandardBenchmarkExecutor extends AbstractBenchmarkExecutor {

    public StandardBenchmarkExecutor(BenchmarkTask task) {
	this.task = task;
    }

    @Override
    protected BenchmarkResult performBenchmark() {
	BenchmarkResult result = null;
	try {
	    for (int i = 0; i < 2; i++) {
		task.call();
	    }

	    ArrayList<Long> executionTimeList = new ArrayList<Long>();
	    for (int i = 0; i < 1; i++) {
		measureExecutionTime(executionTimeList);
		BenchmarkMeasurements.aggregate();
	    }

	    result = new DefaultBenchmarkResult(task, executionTimeList, BenchmarkMeasurements.getMeasurementList());

	    BenchmarkMeasurements.reset();
	} catch (Exception e) {
	    System.out.println("Task ended with exception: " + task.toString());
	    e.printStackTrace();
	}

	return result;
    }

    private void measureExecutionTime(ArrayList<Long> executionTimeList) throws Exception {
	long timeBefore = System.nanoTime();
	returnValue = task.call();
	long timeAfter = System.nanoTime();
	executionTimeList.add(new Long(timeAfter - timeBefore));
    }
}
