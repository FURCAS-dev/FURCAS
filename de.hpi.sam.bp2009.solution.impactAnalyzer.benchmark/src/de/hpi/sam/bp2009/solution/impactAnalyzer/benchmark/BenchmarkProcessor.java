package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.util.Queue;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskPreparer;

/**
 * The {@link BenchmarkProcessor}s main purpose is to analyze the overall
 * performance of the instance scope analysis. However, the BenchmarkProcessor
 * could also be used for a broad range of micro-benchmarks.
 *
 * The BenchmarkProcessor is able to perform benchmarks in a simple and fast way
 * by measuring System.nanoTime without respecting e.g. hot spot compiling or
 * class loading. Additionally, extensive and robust benchmarks can be performed
 * by using the bb.util.Benchmark library [1]
 *
 * In order to implement a new benchmark a new class which implements the
 * {@link BenchmarkTask} interface shall be created.
 *
 * @see http://ellipticgroup.com/html/benchmarkingArticle.html
 *
 * @author Manuel Holzleitner (D049667)
 */

public class BenchmarkProcessor {
    //FIXME: Implement code for starting benchmark program
    public static void main(String[] args) {
    	start(args[args.length - 1]);
    }

	public static void start(String resultFile) {
		// Preparing
		Queue<BenchmarkTask> taskQueue = BenchmarkTaskPreparer.prepareModelSizeVariationBenchmarkTasks();

		// Processing
		BenchmarkExecutionProcessor.processBenchmarks(taskQueue);
	}
}