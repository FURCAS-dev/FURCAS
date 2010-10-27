package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing.BenchmarkResultWriter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskContainer;

public class BenchmarkExecutionJob extends Job {

    private final BenchmarkExecutor executor;
    private final BenchmarkResultWriter writer;
    private final Queue<BenchmarkTaskContainer> containerList;

    private final int containerSizeFull;

    public BenchmarkExecutionJob(String name, BenchmarkExecutor executor, Queue<BenchmarkTaskContainer> containerList,
	    BenchmarkResultWriter writer) {
	super(name);

	this.executor = executor;
	this.containerList = containerList;
	this.writer = writer;

	this.containerSizeFull = containerList.size();
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
	int i = 11;
	while (!containerList.isEmpty()) {
	    if (i++ > 10) {
		printProgress(containerSizeFull, containerList.size());

		i = 0;
	    }

	    BenchmarkTaskContainer container = containerList.remove();

	    container.beforeBenchmark();
	    while (!container.isEmpty()) {
		executor.execute(container.remove(), writer);
	    }
	    container.afterBenchmark();
	}

	return Status.OK_STATUS;
    }

    private void printProgress(int fullSize, int currentSize){
	double percent = ((double)currentSize) / ((double)fullSize);
	int progressBarWidth = 60;

	StringBuffer strBuff = new StringBuffer();
	DecimalFormat f = new DecimalFormat("##0.00");

	strBuff.append("\r");
	strBuff.append(f.format(((1.0 - percent) * 100.0)));
	strBuff.append("% ");
	strBuff.append("[");

	int currentState = progressBarWidth - (int)(percent * progressBarWidth);

	for(int i = 0; i < currentState; i++){
	    strBuff.append("=");
	}
	strBuff.append(">");
	for(int i = 0; i < progressBarWidth - currentState; i++){
	    strBuff.append(" ");
	}

	strBuff.append("]");

	strBuff.append("(");
	strBuff.append(currentSize);
	strBuff.append("/");
	strBuff.append(fullSize);
	strBuff.append(")");

        try {
	    System.out.write(strBuff.toString().getBytes());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
