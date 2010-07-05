package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.ArrayList;
import java.util.Collection;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultContainer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class BenchmarkExecutionProcessor {

    public static BenchmarkResultContainer processExtensiveBenchmarks(Collection<BenchmarkTask> taskList) {
	ArrayList<BenchmarkExecutor> executorList = new ArrayList<BenchmarkExecutor>();

	for (BenchmarkTask task : taskList) {
	    executorList.add(new ExtensiveBenchmarkExecutor(task));
	}

	return BenchmarkExecutionProcessor.processAll(executorList);
    }

    public static BenchmarkResultContainer processSimpleBenchmarks(Collection<BenchmarkTask> taskList) {
	ArrayList<BenchmarkExecutor> executorList = new ArrayList<BenchmarkExecutor>();

	for (BenchmarkTask task : taskList) {
	    executorList.add(new SimpleBenchmarkExecutor(task));
	}

	return BenchmarkExecutionProcessor.processAll(executorList);
    }

    public static BenchmarkResultContainer processAll(Collection<BenchmarkExecutor> executorList) {
	System.out.println("Start Processing");
	BenchmarkResultContainer result = new BenchmarkResultContainer();

	System.out.println("");
	for (BenchmarkExecutor executor : executorList) {
	    result.addResult(executor.execute());
	    System.out.print("|");
	}

	System.out.println("Processing finished with " + result.size() + " results");

	return result;
    }
}
