package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.util.HashMap;

public abstract class DefaultMeasurement implements Measurement{
    private final HashMap<String, Measurement> subMeasurements = new HashMap<String, Measurement>();
    private Measurement parent = null;
        
	public void addSubMeasurement(String measureSubPointId, Measurement subMeasurement) {
	subMeasurement.setParent(this);
	subMeasurements.put(measureSubPointId, subMeasurement);
	}
	
	public HashMap<String, Measurement> getSubMeasurements() {
	return subMeasurements;
	}
	
	public Measurement getParent() {
	return parent;
	}
	
	public void setParent(Measurement parent) {
	this.parent = parent;
	}
}
