package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.OutputOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements.Measurement;

public class BenchmarkResultWriter extends Writer {
	private boolean withHeadline = true;
	private int lineOffset = 1;

	public BenchmarkResultWriter() {
		super(OutputOptions.getOutputPath(), false);
	}

    public synchronized void writeDataSet(Map<String, String> additionalInformation, ArrayList<Long> executionTimeList,  ArrayList<Long> evaluationTimeList, ArrayList<Map<String, String>> additionalMeasurementInformationList, HashMap<String, ArrayList<Measurement>>microMeasurementList){
   	 try {

	final String TAB = "\t";

	if(withHeadline){

			writer.write(" ");


	    for(String label : additionalInformation.keySet()){
		writer.write(TAB + label);
	    }
	    for(String label : additionalMeasurementInformationList.get(0).keySet()){
		writer.write(TAB + label);
	    }


	    writer.write(TAB + "executionIndex" + TAB + "executionTime" + TAB + "evaluationTime" + BREAK);
	    withHeadline = false;
	}

	int executionIndex = 1;
	for(Long executionTime : executionTimeList){

		StringBuffer row = new StringBuffer();
		row.append(lineOffset++);

		for(String information : additionalInformation.values()){
		    row.append(TAB + information);
		}
		for(String information : additionalMeasurementInformationList.get(executionIndex - 1).values()){
		    row.append(TAB + information);
		}

		row.append(TAB + executionIndex);
		row.append(TAB + executionTime);
		row.append(TAB + evaluationTimeList.get(executionIndex - 1));
		row.append(BREAK);
		writer.write(row.toString());

		executionIndex++;
	}
 		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



}
