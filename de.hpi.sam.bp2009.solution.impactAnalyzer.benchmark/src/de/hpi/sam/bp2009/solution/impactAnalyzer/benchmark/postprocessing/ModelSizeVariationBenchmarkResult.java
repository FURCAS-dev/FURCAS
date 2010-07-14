package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.Measurement;

@XStreamAlias("SimpleBenchmarkResult")
public class ModelSizeVariationBenchmarkResult implements BenchmarkResult {
    // model key maps to execution time List
    private final LinkedHashMap<String, ArrayList<Long>> executionTimeList = new LinkedHashMap<String, ArrayList<Long>>();
    private String oclString;

    private final LinkedHashMap<String, Map<String, ArrayList<Measurement>>> microMeasurementList = new LinkedHashMap<String, Map<String, ArrayList<Measurement>>>();
    private final LinkedHashMap<String, Resource> modelResource = new LinkedHashMap<String, Resource>();

    private final ArrayList<Integer> sumPointList = new ArrayList<Integer>();

    public void addExecutionTime(String modelKey, long executionTime){
	ArrayList<Long> targetList = executionTimeList.get(modelKey);
	if (targetList == null) {
	    targetList = new ArrayList<Long>();
	}

	targetList.add(executionTime);

	executionTimeList.put(modelKey, targetList);
    }

    public HashMap<String, ArrayList<Long>> getExecutionTimeList() {
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

	int columnNumber = 0;

	result.append(oclString);
	result.append(";"); columnNumber++;

	result.append("||;"); columnNumber++;

	for (String key : executionTimeList.keySet()) {

	    result.append(modelResource.get(key).getURI().toString());
	    result.append("||;"); columnNumber++;

	    for (long executionTime : executionTimeList.get(key)) {
		result.append(executionTime);
		result.append(";"); columnNumber++;
	    }

	    result.append("|;");columnNumber++;



	    long sumOfTimesExceptFirst = 0;
	    int i = 0;
	    for(long executionTime : executionTimeList.get(key)) {
		if(i > 0) {
		    sumOfTimesExceptFirst = sumOfTimesExceptFirst + executionTime;
		}
		i++;
	    }
	    result.append((new Double(sumOfTimesExceptFirst) / new Double(executionTimeList.get(key).size() - 1)) + ";");
	    sumPointList.add(columnNumber);

	    result.append("|;");columnNumber++;

	    for (String point : getMeasurementList().get(key).keySet()) {
		result.append(point + ":");
		result.append(";");columnNumber++;
		    for (Measurement measurement : getMeasurementList().get(key).get(point)) {
			result.append(measurement.getResult());
			result.append(";");columnNumber++;
		    }
	    }

	    result.append("||;");columnNumber++;
	}

	return result.toString();
    }

    public ArrayList<Integer> sumPoints(){
	return sumPointList;
    }

    public Map<String, Map<String, ArrayList<Measurement>>> getMeasurementList() {
	return microMeasurementList;
    }

    public void setMeasurementList(String modelKey, Map<String, ArrayList<Measurement>> microMeasurementList) {
	this.microMeasurementList.put(modelKey, microMeasurementList);
    }

    public void setModel(String modelKey, Resource resource) {
	modelResource.put(modelKey, resource);
    }

}
