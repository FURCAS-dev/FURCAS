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

    private HashMap<String, Throwable> notExecutedDueToException = new LinkedHashMap<String, Throwable>();

    @Override
    public void execute(BenchmarkTask task, BenchmarkResultWriter writer) {
	try {
	    if (task.activate()) {
		// Warmup
		for (int i = 0; i < ProcessingOptions.getNumberOfWarmUps(); i++) {
		    task.beforeCall();
		    task.call();
		    task.callEvaluation();
		    task.afterCall();
		    task.getAdditionalMeasurementInformation();
		}

		ArrayList<Long> executionTimeList = new ArrayList<Long>();
		ArrayList<Long> evaluationTimeList = new ArrayList<Long>();
		ArrayList<Map<String, String>> additionalMeasurementInformationList = new ArrayList<Map<String, String>>();

		for (int i = 0; i < ProcessingOptions.getNumberOfMeasures(); i++) {
		    measureExecutionTime(task, executionTimeList, evaluationTimeList, additionalMeasurementInformationList);
		    BenchmarkMeasurements.aggregate();
		}

		task.deactivate();

		writer.writeDataSet(task.getAdditionalInformation(), executionTimeList, evaluationTimeList,
			additionalMeasurementInformationList, BenchmarkMeasurements.getMeasurementList());

		BenchmarkMeasurements.reset();
	    }
	} catch (Exception e) {
	    getNotExecutedDueToException().put(task.toString(), e);
	    if (ProcessingOptions.isVerbose()) {
		e.printStackTrace();
	    }
	} catch (StackOverflowError e) {
	    getNotExecutedDueToException().put(task.toString(), e);
	    if (ProcessingOptions.isVerbose()) {
		e.printStackTrace();
	    }
	}
    }

    private void measureExecutionTime(BenchmarkTask task, ArrayList<Long> executionTimeList, ArrayList<Long> evaluationTimeList,
	    ArrayList<Map<String, String>> additionalMeasurementInformationList) throws Exception {
	// Perform measurement
	task.beforeCall();
	long timeBefore = System.nanoTime();
	task.call();
	long timeAfter = System.nanoTime();
	long timeBeforeEvaluation = System.nanoTime();
	task.callEvaluation();
	long timeAfterEvaluation = System.nanoTime();
	task.afterCall();

	executionTimeList.add(new Long(timeAfter - timeBefore));
	evaluationTimeList.add(new Long(timeAfterEvaluation - timeBeforeEvaluation));

	additionalMeasurementInformationList.add(task.getAdditionalMeasurementInformation());
    }

    public void setNotExecutedDueToException(HashMap<String, Throwable> notExecutedDueToException) {
	this.notExecutedDueToException = notExecutedDueToException;
    }

    public HashMap<String, Throwable> getNotExecutedDueToException() {
	return notExecutedDueToException;
    }
}
