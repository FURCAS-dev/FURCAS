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

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * A {@link BenchmarkExecutor} contains the logic for executing a single {@link BenchmarkTask}.
 * After executing the task a {@link BenchmarkResult} is returned by this class.
 *
 * For create a new {@link BenchmarkExecutor} it is recommended to extend from {@link AbstractBenchmarkExecutor}
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkExecutor {
   
    /**
     * Executes the setted @{link {@link BenchmarkTask} and benchmarks its execution.
     *
     * @throws An RuntimeException if the task was not set on the BenchmarkExecutor
     * @return A BenchmarkResult for the given {@link BenchmarkTask}
     */
    public void execute(BenchmarkTask task, BenchmarkResultWriter result);

}
