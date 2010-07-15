package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import bb.util.Benchmark;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.ExtensiveBenchmarkResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * The {@link ExtensiveBenchmarkExecutor} utilizes the bb.util.Benchmark library
 * in order to generate reliable benchmark results.
 *
 * @see http://ellipticgroup.com/html/benchmarkingArticle.html
 *
 * @author Manuel Holzleitner (D049667)
 */
public class ExtensiveBenchmarkExecutor extends AbstractBenchmarkExecutor {

    public ExtensiveBenchmarkExecutor(BenchmarkTask task) {
	this.task = task;
    }

    @Override
    protected BenchmarkResult performBenchmark() {
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
    		returnValue = bench.getCallResult();
	}

	return new ExtensiveBenchmarkResult(bench);
    }

}
