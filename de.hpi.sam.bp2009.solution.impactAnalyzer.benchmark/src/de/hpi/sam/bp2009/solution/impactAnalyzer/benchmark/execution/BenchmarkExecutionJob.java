package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class BenchmarkExecutionJob extends Job{

	private final BenchmarkExecutor executor;
	private final BenchmarkResultWriter writer;
	private final Queue<BenchmarkTask> taskList;

	public BenchmarkExecutionJob(String name, BenchmarkExecutor executor, Queue<BenchmarkTask> taskList, BenchmarkResultWriter writer) {
		super(name);
		// TODO Auto-generated constructor stub

		this.executor = executor;
		this.taskList = taskList;
		this.writer = writer;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int all = taskList.size();
		
		while(!taskList.isEmpty()){
			BenchmarkTask task = taskList.remove();
			
		    executor.execute(task, writer);
		    
		    if(taskList.size() % 500 == 0){
			      System.out.print("\r Job["+ this.getName() +"]:" + taskList.size() + "/" + all);
			}
		    
		} 
		
		
		return Status.OK_STATUS;
	}

}
