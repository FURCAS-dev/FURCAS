package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.Measurement;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class DefaultBenchmarkResult implements BenchmarkResult{
    private final BenchmarkTask task;
    private final ArrayList<Long> executionTimeList;
    private final HashMap<String, ArrayList<Measurement>> microMeasurementList;

    public DefaultBenchmarkResult(BenchmarkTask task, ArrayList<Long> executionTimeList, HashMap<String, ArrayList<Measurement>>microMeasurementList) {
	this.task = task;
	this.executionTimeList = executionTimeList;
	this.microMeasurementList = microMeasurementList;
    }

    @Override
    public int writeDataSet(OutputStream os, boolean withHeadline, int lineOffset) throws IOException {
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

	final String TAB = "\t";
	final String BREAK = "\n";

	if(withHeadline){
	    writer.write(" ");

	    for(String label : getTask().getAdditionalInformation().keySet()){
		writer.write(TAB + label);
	    }

	    writer.write(TAB + "executionIndex" + TAB + "executionTime" + BREAK);
	}

        int executionIndex = 1;
	for(Long executionTime : getExecutionTimeList()){

		StringBuffer row = new StringBuffer();
		row.append(lineOffset++);

		for(String information : getTask().getAdditionalInformation().values()){
		    row.append(TAB + information);
		}

		row.append(TAB + executionIndex);
		row.append(TAB + executionTime);
		row.append(BREAK);
		writer.write(row.toString());
	}

	writer.flush();

	return lineOffset;
    }

    public BenchmarkTask getTask() {
	return task;
    }

    public ArrayList<Long> getExecutionTimeList() {
	return executionTimeList;
    }

    public HashMap<String, ArrayList<Measurement>> getMicroMeasurementList() {
	return microMeasurementList;
    }
}
