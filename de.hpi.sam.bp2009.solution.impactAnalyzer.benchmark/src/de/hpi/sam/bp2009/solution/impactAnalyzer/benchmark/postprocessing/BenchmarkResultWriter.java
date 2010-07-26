package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.OutputOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements.Measurement;

public class BenchmarkResultWriter {

	private Writer writer;
	private boolean withHeadline = true;
	private int lineOffset = 1;

	private static final String BREAK = System.getProperty("line.separator");

	public BenchmarkResultWriter() {
		File f = new File(OutputOptions.getOutputPath());
		createFileIfNeeded(f);
		OutputStream os = null;

		try {
			os = new FileOutputStream(f);
			writer = new BufferedWriter(new OutputStreamWriter(os), 81920);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void close(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public synchronized void writeDataSet(Map<String, String> additionalInformation, ArrayList<Long> executionTimeList, ArrayList<Map<String, String>> additionalMeasurementInformationList, HashMap<String, ArrayList<Measurement>>microMeasurementList){
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
	    

	    writer.write(TAB + "executionIndex" + TAB + "executionTime" + BREAK);
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
		row.append(BREAK);
		writer.write(row.toString());

		executionIndex++;
	}
 		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void createFileIfNeeded(File f) {
    	if(!f.exists()){
    	    try {
    		f.getParentFile().mkdirs();
    	    	f.createNewFile();
    	    } catch (IOException e) {
    		e.printStackTrace();
    	    }
    	}
        }

}
