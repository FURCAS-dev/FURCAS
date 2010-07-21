package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.ProcessingOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements.BenchmarkMeasurements;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
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
public class StandardBenchmarkExecutor implements BenchmarkExecutor {

    HashMap<String, Throwable> notExecutedDueToException = new LinkedHashMap<String, Throwable>();

    
    @Override
    public void execute(BenchmarkTask task, BenchmarkResultWriter writer) {
	try {
	    // Warmup
	    for (int i = 0; i <= ProcessingOptions.getNumberOfWarmUps(); i++) {
		task.beforeCall();
		task.call();
		task.afterCall();
	    }

	    ArrayList<Long> executionTimeList = new ArrayList<Long>();
	    ArrayList<Map<String, String>> additionalMeasurementInformationList = new ArrayList<Map<String, String>>();

	    for (int i = 0; i <= ProcessingOptions.getNumberOfMeasures(); i++) {
		measureExecutionTime(task, executionTimeList, additionalMeasurementInformationList);
		BenchmarkMeasurements.aggregate();
	    }

	    writer.writeDataSet(task.getAdditionalInformation(), executionTimeList, additionalMeasurementInformationList, BenchmarkMeasurements.getMeasurementList());

	    BenchmarkMeasurements.reset();
	} catch (Exception e) {
	    notExecutedDueToException.put(task.toString(), e);
	} catch (StackOverflowError e){
	    notExecutedDueToException.put(task.toString(), e);
	}
    }

    private void measureExecutionTime(BenchmarkTask task, ArrayList<Long> executionTimeList, ArrayList<Map<String, String>> additionalMeasurementInformationList) throws Exception {
	// Perform measurement
	long timeBefore = System.nanoTime();
	task.call();
	long timeAfter = System.nanoTime();

	executionTimeList.add(new Long(timeAfter - timeBefore));
	additionalMeasurementInformationList.add(task.getAdditionalMeasurementInformation());
    }
}
