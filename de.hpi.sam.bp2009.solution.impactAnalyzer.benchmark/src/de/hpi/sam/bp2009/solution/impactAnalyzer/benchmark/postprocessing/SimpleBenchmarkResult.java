package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.Measurement;


@XStreamAlias("SimpleBenchmarkResult")
public class SimpleBenchmarkResult implements BenchmarkResult {
    private final ArrayList<Long> executionTimeList = new ArrayList<Long>();
    private String oclString;

    private Map<String, ArrayList<Measurement>> microMeasurementList = new HashMap<String,  ArrayList<Measurement>>();

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


	for(String point : getMeasurementList().keySet()){
	    result.append(point + ":");
	    result.append(";");
	    for(Measurement measurement : getMeasurementList().get(point)){
		    result.append(measurement.getResult());
		    result.append(";");
	    }
	}

	return result.toString();
    }

    public Map<String, ArrayList<Measurement>> getMeasurementList() {
	return microMeasurementList;
    }

    public void setMeasurementList(Map<String, ArrayList<Measurement>> microMeasurementList) {
	this.microMeasurementList = microMeasurementList;
    }

    @Override
    public int writeDataSet(OutputStream os, boolean withHeadline, int lineOffset) {
	// TODO Auto-generated method stub
	throw new RuntimeException("Not implemented");
    }

}
