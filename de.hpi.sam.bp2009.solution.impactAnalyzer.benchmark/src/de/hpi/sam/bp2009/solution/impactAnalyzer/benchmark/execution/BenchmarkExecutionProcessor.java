package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.core.runtime.jobs.Job;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskContainer;

/**
 * The {@link BenchmarkExecutionProcessor} processes a list of {@link BenchmarkTasks} subsequently.
 * Therefore it provides several methods for different kind of benchmarks.
 *
 * Each {@link BenchmarkTask} is wrapped in a {@link BenchmarkExecutor} which is then executed.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkExecutionProcessor {

    public static void processExtensiveBenchmarks(Queue<BenchmarkTaskContainer> containerList) {
    	BenchmarkExecutionProcessor.processAll(new ExtensiveBenchmarkExecutor(), containerList);
    }

    public static void  processBenchmarks(Queue<BenchmarkTaskContainer> containerList){
    	BenchmarkExecutionProcessor.processAll(new StandardBenchmarkExecutor(), containerList);
    }

    public static void processAll(BenchmarkExecutor executor, Queue<BenchmarkTaskContainer> containerList) {
	BenchmarkResultWriter writer = new BenchmarkResultWriter();	
	
	System.out.println("");
	int i=0;
	int all = containerList.size();
	
	System.out.println("Start Processing");
	
	while(!containerList.isEmpty()){
		BenchmarkTaskContainer container = containerList.remove();
		
		container.beforeBenchmark();
		while(!container.isEmpty()){
			executor.execute(container.remove(), writer);
		}
	    container.afterBenchmark();
	    
	    if(i % 50 == 0){
	      System.out.print("\r" + i + "/" + all);
	    }
	    i++;
	}System.out.print("\n");

	writer.close();
		System.out.println("Processing finished");
		
    	System.out.println(((StandardBenchmarkExecutor)executor).getNotExecutedDueToException().size() + " tasks ended with exceptions");
    }
    
    public static void  processBenchmarksInParallel(Queue<BenchmarkTaskContainer> containerList, int numberOfParallelJobs){
    	BenchmarkExecutionProcessor.processAllInParallel(new StandardBenchmarkExecutor(), containerList, numberOfParallelJobs);
    }
    
    public static void processAllInParallel(BenchmarkExecutor executor, Queue<BenchmarkTaskContainer> containerList, int numberOfParallelJobs){
    	BenchmarkResultWriter writer = new BenchmarkResultWriter();	
    	  	
    	ArrayList<Job> jobList = new ArrayList<Job>();
    	
    	ConcurrentLinkedQueue<BenchmarkTaskContainer> concurrentContainerList = new ConcurrentLinkedQueue<BenchmarkTaskContainer>();
    	concurrentContainerList.addAll(containerList);
    	
    	System.out.println("Start Processing");
    	System.out.println("Create and schedule jobs");
    	for(int i = 0; i < numberOfParallelJobs; i++){     		
    		jobList.add(new BenchmarkExecutionJob("BenchmarkJobNo" + i, executor, concurrentContainerList, writer));
    	}
    	
    	for(Job jobToSchedule : jobList){
    		jobToSchedule.schedule();
    	}
    	System.out.println("Wait for jobs");
    	for(Job jobToJoin : jobList){
    		try {
				jobToJoin.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	writer.close();
    	System.out.println("Processing finished");
    	
    	System.out.println(((StandardBenchmarkExecutor)executor).getNotExecutedDueToException().size() + " tasks ended with exceptions");
    }
}
