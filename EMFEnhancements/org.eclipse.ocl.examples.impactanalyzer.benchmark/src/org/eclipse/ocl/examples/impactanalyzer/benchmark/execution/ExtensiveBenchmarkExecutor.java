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

import org.eclipse.ocl.examples.impactanalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTask;

import bb.util.Benchmark;

/**
 * The {@link ExtensiveBenchmarkExecutor} utilizes the bb.util.Benchmark library
 * in order to generate reliable benchmark results.
 *
 * @see http://ellipticgroup.com/html/benchmarkingArticle.html
 *
 * @author Manuel Holzleitner (D049667)
 */
public class ExtensiveBenchmarkExecutor implements BenchmarkExecutor{

    @Override
    public void execute(BenchmarkTask task, BenchmarkResultWriter writer) {
	
    Benchmark bench = null;

	try {
	    bench = new Benchmark(task, true, 10);
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalStateException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	if(bench != null){
    		System.out.println(bench.toString());
	}
    }

}
