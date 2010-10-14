package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements;

public interface Measurement {
	public void before();
	public void after();

	public long getResult();
	public void addSubMeasurement(String measureSubPointId, Measurement subMeasurement);
	public void setParent(Measurement parent);
}
