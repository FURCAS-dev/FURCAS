package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.OutputOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements.Measurement;

public class BenchmarkResultWriter {

	private OutputStream os;
	private boolean withHeadline = true;
	private int lineOffset = 1;

	public BenchmarkResultWriter() {
		File f = new File(OutputOptions.getOutputPath());
		createFileIfNeeded(f);

		try {
			os = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(){
		try {
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void writeDataSet(Map<String, String> additionalInformation, ArrayList<Long> executionTimeList, ArrayList<Map<String, String>> additionalMeasurementInformationList, HashMap<String, ArrayList<Measurement>>microMeasurementList){
    	 try {

    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

	final String TAB = "\t";
	final String BREAK = "\n";

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

	writer.flush();
	os.flush();
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
