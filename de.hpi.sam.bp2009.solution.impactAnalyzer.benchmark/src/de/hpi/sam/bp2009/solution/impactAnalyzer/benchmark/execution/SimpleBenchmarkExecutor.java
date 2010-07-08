package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkMeasurements;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.SimpleBenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * The {@link SimpleBenchmarkExecutor} benchmarks {@link BenchmarkTasks} by measuring
 * per System.nanoTime() before and after executing the task.
 *
 * It executes a {@link BenchmarkTask} several times in order to see effects of
 * caching and initalization. However, it does not respect other well-known
 * rules for micro-benchmarking Java code.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class SimpleBenchmarkExecutor extends DefaultBenchmarkExecutor {

    public SimpleBenchmarkExecutor(BenchmarkTask task) {
	this.task = task;
    }

    @Override
    protected BenchmarkResult performBenchmark() {
	SimpleBenchmarkResult result = new SimpleBenchmarkResult();

	try {
	    for (int i = 0; i < 2; i++) {
	    	measureExecutionTime(result);
		BenchmarkMeasurements.aggregate();
	    }

	    result.setMeasurementList(BenchmarkMeasurements.getMeasurementList());
	    BenchmarkMeasurements.reset();

	    result.setOclString(task.toString());

	} catch (Exception e) {
	    System.out.println("Task ended with exception: " + task.toString());
	    e.printStackTrace();
	}
	return result;
    }

    private void measureExecutionTime(SimpleBenchmarkResult result) throws Exception {
	long timeBefore = System.nanoTime();
	returnValue = task.call();
	long timeAfter = System.nanoTime();
	result.addExecutionTime((timeAfter - timeBefore));
    }
}
