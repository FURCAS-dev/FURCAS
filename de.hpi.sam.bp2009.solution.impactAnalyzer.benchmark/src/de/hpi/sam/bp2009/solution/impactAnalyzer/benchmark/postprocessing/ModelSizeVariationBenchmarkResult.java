package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
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

	result.append(oclString.replace(";", ",."));
	result.append(";"); columnNumber++;

	result.append("||;"); columnNumber++;

	for (String key : executionTimeList.keySet()) {

	    result.append(modelResource.get(key).getURI().toString());
	    result.append("||;"); columnNumber++;

	    for (long executionTime : executionTimeList.get(key)) {
		result.append(executionTime);
		result.append(";"); columnNumber++;
	    }

	    result.append("|||;");columnNumber++;

	    long sumOfTimesExceptFirst = 0;
	    int i = 0;
	    for(long executionTime : executionTimeList.get(key)) {
		if(i > 0) {
		    sumOfTimesExceptFirst = sumOfTimesExceptFirst + executionTime;
		}
		i++;
	    }
	    result.append((new Double(sumOfTimesExceptFirst) / new Double(executionTimeList.get(key).size() - 1)) + ";");

	    result.append("|||;");columnNumber++;

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

    public Map<String, Map<String, ArrayList<Measurement>>> getMeasurementList() {
	return microMeasurementList;
    }

    public void setMeasurementList(String modelKey, Map<String, ArrayList<Measurement>> microMeasurementList) {
	this.microMeasurementList.put(modelKey, microMeasurementList);
    }

    public void setModel(String modelKey, Resource resource) {
	modelResource.put(modelKey, resource);
    }

    @Override
    public int writeDataSet(OutputStream os, boolean withHeadline, int lineOffset) throws IOException{
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

	final String TAB = "\t";
	final String BREAK = "\n";

	if(withHeadline){
	    writer.write(" " + TAB + "oclString" + TAB + "resourceUri" + TAB + "modelKey" + TAB + "modelSize" + TAB + "executionIndex" + TAB + "executionTime" + BREAK);
	}

	for(String modelKey : executionTimeList.keySet()){
	    int executionIndex = 1;
	    for(Long executionTime : executionTimeList.get(modelKey)){
		StringBuffer row = new StringBuffer();
		row.append(lineOffset++);
		row.append(TAB + oclString.hashCode());

		row.append(TAB + modelResource.get(modelKey).getURI().toString());
		row.append(TAB + modelKey);
		row.append(TAB + getModelSize(modelResource.get(modelKey)));

		row.append(TAB + executionIndex);
		row.append(TAB + executionTime);
		row.append(BREAK);
		writer.write(row.toString());
	    }
	}

	return lineOffset;
    }

    private int getModelSize(Resource resource){
	int resourceSize = 0;
	TreeIterator<EObject> iterator = resource.getAllContents();
	while(iterator.hasNext()){
	    iterator.next();
	    resourceSize++;
	}
	return resourceSize;
    }
}
