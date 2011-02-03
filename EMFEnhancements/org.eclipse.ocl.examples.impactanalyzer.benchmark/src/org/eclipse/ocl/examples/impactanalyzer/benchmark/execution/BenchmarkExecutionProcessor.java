/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark.execution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.PathOptions;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.ProcessingOptions;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.postprocessing.ExceptionDumpWriter;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTask;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTaskContainer;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTaskStepwiseBuilder;


/**
 * The {@link BenchmarkExecutionProcessor} processes a list of {@link BenchmarkTasks} subsequently.
 * Therefore it provides several methods for different kind of benchmarks.
 *
 * Each {@link BenchmarkTask} is wrapped in a {@link BenchmarkExecutor} which is then executed.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkExecutionProcessor {

    public static void processBenchmarks(BenchmarkTaskStepwiseBuilder builder, boolean stepwise) throws IOException {
	BenchmarkExecutionProcessor.processAll(new StandardBenchmarkExecutor(), builder, stepwise);
    }

    public static void processAll(BenchmarkExecutor executor, BenchmarkTaskStepwiseBuilder builder, boolean stepwise) throws IOException {
	BenchmarkResultWriter writer = new BenchmarkResultWriter();

	System.out.println("");
	System.out.println("Start Processing");

	if (stepwise) {
	    while (builder.hasNext()) {
		performBenchmarks(executor, writer, builder);
	    }
	} else {
	    Queue<BenchmarkTaskContainer> containerList = builder.buildAll();
	    performBenchmarks(executor, writer, containerList);
	}

	writer.close();
	System.out.println("Processing finished");
	dumpExceptions(executor);
    }

    private static void performBenchmarks(BenchmarkExecutor executor, BenchmarkResultWriter writer, Queue<BenchmarkTaskContainer> containerList) {
	int i = 0;
	int all = containerList.size();
	while (!containerList.isEmpty()) {
	    BenchmarkTaskContainer container = containerList.remove();

	    container.beforeBenchmark();
	    while (!container.isEmpty()) {
		executor.execute(container.remove(), writer);
	    }
	    container.afterBenchmark();

	    if (i % 50 == 0) {
		if (ProcessingOptions.isVerbose()) {
		    System.out.println("\r" + i + "/" + all);
		}
	    }
	    i++;
	}
	System.out.print("\n");
    }

    public static void processBenchmarksInParallel(BenchmarkTaskStepwiseBuilder builder, boolean stepwise, int numberOfParallelJobs) throws IOException {
	BenchmarkExecutionProcessor.processAllInParallel(new StandardBenchmarkExecutor(), builder, stepwise, numberOfParallelJobs);
    }

    public static void processAllInParallel(BenchmarkExecutor executor, BenchmarkTaskStepwiseBuilder builder, boolean stepwise, int numberOfParallelJobs) throws IOException {
	System.out.println("Start Processing");

	BenchmarkResultWriter writer = new BenchmarkResultWriter();

	if (stepwise) {
	    performParallelBenchmarks(executor, numberOfParallelJobs, builder, writer);

	} else {
	    ConcurrentLinkedQueue<BenchmarkTaskContainer> concurrentContainerList = new ConcurrentLinkedQueue<BenchmarkTaskContainer>();
	    concurrentContainerList.addAll(builder.buildAll());

	    performParallelBenchmarks(executor, numberOfParallelJobs, concurrentContainerList, writer);
	}

	writer.close();
	System.out.println("Processing finished");
	dumpExceptions(executor);
    }

    private static void performParallelBenchmarks(BenchmarkExecutor executor, int numberOfParallelJobs,
	    Queue<BenchmarkTaskContainer> containerList, BenchmarkResultWriter writer) {

	ArrayList<Job> jobList = new ArrayList<Job>();

	for (int i = 0; i < numberOfParallelJobs; i++) {
	    jobList.add(new BenchmarkExecutionJob("BenchmarkJobNo" + i, executor, containerList, writer));
	}
	for (Job jobToSchedule : jobList) {
	    jobToSchedule.schedule();
	}
	for (Job jobToJoin : jobList) {
	    try {
		jobToJoin.join();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    private static void dumpExceptions(BenchmarkExecutor executor) throws IOException {
	System.out.println(((StandardBenchmarkExecutor) executor).getExceptionCount()
		+ " tasks ended with exceptions");
	if (PathOptions.isExceptionDumpFilePathDefined()) {
	    if (((StandardBenchmarkExecutor) executor).getExceptionCount() < 200) {
		ExceptionDumpWriter writer = new ExceptionDumpWriter();
		writer.writeDump(((StandardBenchmarkExecutor) executor).getNotExecutedDueToException());
		((StandardBenchmarkExecutor) executor).clearExceptions();
		writer.close();
		System.out.println("Exception dump file was written to " + PathOptions.getExceptionDumpFilePath());
	    } else {
		System.out.println("Prohibited to write exception dump file because there are to many exceptions");
	    }
	}

    }

}
