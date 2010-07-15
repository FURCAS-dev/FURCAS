package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.Queue;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

/**
 * The {@link BenchmarkExecutionProcessor} processes a list of {@link BenchmarkTasks} subsequently.
 * Therefore it provides several methods for different kind of benchmarks.
 *
 * Each {@link BenchmarkTask} is wrapped in a {@link BenchmarkExecutor} which is then executed.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkExecutionProcessor {

    public static void processExtensiveBenchmarks(Queue<BenchmarkTask> taskList) {
    	BenchmarkExecutionProcessor.processAll(new ExtensiveBenchmarkExecutor(), taskList);
    }

    public static void  processBenchmarks(Queue<BenchmarkTask> taskList){
    	BenchmarkExecutionProcessor.processAll(new StandardBenchmarkExecutor(), taskList);
    }

    public static void processAll(BenchmarkExecutor executor, Queue<BenchmarkTask> taskList) {
	BenchmarkResultWriter writer = new BenchmarkResultWriter();	
	
	System.out.println("");
	int i=0;
	int all = taskList.size();
	
	System.out.println("Start Processing");
	
	while(!taskList.isEmpty()){
		BenchmarkTask task = taskList.remove();
		
	    executor.execute(task, writer);
	    
	    if(i % 500 == 0){
	      System.out.print("\r" + i + "/" + all);
	    }
	    i++;
	}System.out.print("\n");

	writer.close();
		System.out.println("Processing finished");
    }
}
