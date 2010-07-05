package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.MicroMeasurement;

public class SimpleBenchmarkResult implements BenchmarkResult {
    private final ArrayList<Long> executionTimeList = new ArrayList<Long>();
    private String oclString;

    private Map<String, ArrayList<MicroMeasurement>> microMeasurementList = new HashMap<String,  ArrayList<MicroMeasurement>>();

    public void addExecutionTime(long executionTime) {
	executionTimeList.add(executionTime);
    }

    public ArrayList<Long> getExecutionTimeList() {
	return executionTimeList;
    }

    public void setOclString(String oclString) {
	this.oclString = oclString;
    }

    public String getOclString() {
	return oclString;
    }

    @Override
    public String toCsvString() {
	StringBuffer result = new StringBuffer();

	for(long executionTime : executionTimeList){
	    result.append(executionTime);
	    result.append(";");
	}

	result.append(oclString);
	result.append(";");


	for(String point : getMicroMeasurementList().keySet()){
	    result.append(point + ":");
	    result.append(";");
	    for(MicroMeasurement measurement : getMicroMeasurementList().get(point)){
		    result.append(measurement.getResult());
		    result.append(";");
	    }
	}

	return result.toString();
    }

    public Map<String, ArrayList<MicroMeasurement>> getMicroMeasurementList() {
	return microMeasurementList;
    }

    public void setMicroMeasurementList(Map<String, ArrayList<MicroMeasurement>> microMeasurementList) {
	this.microMeasurementList = microMeasurementList;
    }

}
