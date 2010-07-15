package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkMeasurements;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.ModelSizeVariationBenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.MultipleNotificationInstanceScopeAnalysisTask;

/**
 * The {@link ModelSizeVariationBenchmarkExecutor} benchmarks {@link BenchmarkTasks} by measuring
 * per System.nanoTime() before and after executing the task.
 *
 * It executes a {@link BenchmarkTask} several times in order to see effects of
 * caching and initalization. However, it does not respect other well-known
 * rules for micro-benchmarking Java code.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class ModelSizeVariationBenchmarkExecutor extends DefaultBenchmarkExecutor {

    public ModelSizeVariationBenchmarkExecutor(BenchmarkTask task) {
	this.task = task;
    }

    @Override
    protected BenchmarkResult performBenchmark() {
	ModelSizeVariationBenchmarkResult result = new ModelSizeVariationBenchmarkResult();

	try {
	    result.setOclString(task.toString());

	    int notificationCounter = 0;
	    while(((MultipleNotificationInstanceScopeAnalysisTask)task).hasNextNotification()){
		    ((MultipleNotificationInstanceScopeAnalysisTask)task).nextNotification();

		    //Warmup
		    for (int i = 0; i < 2; i++) {
			task.call();
		    }

        	    for (int i = 0; i < 5; i++) {
        	    	measureExecutionTime(notificationCounter, result);
        		BenchmarkMeasurements.aggregate();
        	    }

        	    result.setMeasurementList(new Integer(notificationCounter).toString(), BenchmarkMeasurements.getMeasurementList());
        	    result.setModel(new Integer(notificationCounter).toString(),((MultipleNotificationInstanceScopeAnalysisTask)task).getRecentModel());
        	    BenchmarkMeasurements.reset();
        	    notificationCounter++;
	    }


	} catch (Exception e) {
	    System.out.println("Task ended with exception: " + task.toString());
	    e.printStackTrace();
	}

	return result;
    }

    private void measureExecutionTime(int notificationCounter, ModelSizeVariationBenchmarkResult result) throws Exception {
	long timeBefore = System.nanoTime();
	returnValue = task.call();
	long timeAfter = System.nanoTime();
	result.addExecutionTime(new Integer(notificationCounter).toString(), (timeAfter - timeBefore));
    }
}
