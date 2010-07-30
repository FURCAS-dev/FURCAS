package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.ProcessingOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskContainer;

public class BenchmarkExecutionJob extends Job {

    private final BenchmarkExecutor executor;
    private final BenchmarkResultWriter writer;
    private final Queue<BenchmarkTaskContainer> containerList;

    public BenchmarkExecutionJob(String name, BenchmarkExecutor executor, Queue<BenchmarkTaskContainer> containerList,
	    BenchmarkResultWriter writer) {
	super(name);

	this.executor = executor;
	this.containerList = containerList;
	this.writer = writer;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
	int i = 0;
	while (!containerList.isEmpty()) {
	    BenchmarkTaskContainer container = containerList.remove();

	    container.beforeBenchmark();
	    while (!container.isEmpty()) {
		executor.execute(container.remove(), writer);
	    }
	    container.afterBenchmark();

	    if (i++ > 200) {
		if (ProcessingOptions.isVerbose()) {
		    System.out.println("Job[" + this.getName() + "]:" + containerList.size());
		}
		i = 0;
	    }
	}

	return Status.OK_STATUS;
    }

}
