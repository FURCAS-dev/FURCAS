package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.util.ArrayList;
import java.util.HashMap;

public class BenchmarkMeasurements {
    private static HashMap<String, ArrayList<MicroMeasurement>> measurementList = new HashMap<String, ArrayList<MicroMeasurement>>();

    public static MicroMeasurement createNewMeasurement(String measurePointId) {
	MicroMeasurement measure = new MicroMeasurement();

	if (getMeasurementList().containsKey(measurePointId)) {
	    getMeasurementList().get(measurePointId).add(measure);
	} else {
	    getMeasurementList().put(measurePointId, new ArrayList<MicroMeasurement>());
	    getMeasurementList().get(measurePointId).add(measure);
	}

	return measure;
    }

    public static MicroMeasurement createSubMeasurement(String id, String subId){
	MicroMeasurement measure = new MicroMeasurement();

	ArrayList<MicroMeasurement> allMeasuresForId = getMeasurementList().get(id);
	MicroMeasurement parent = allMeasuresForId.get(allMeasuresForId.size() - 1);
	parent.addSubMeasurement(subId, measure);

	return measure;
    }

    public static HashMap<String, ArrayList<MicroMeasurement>> getMeasurementList() {
	return measurementList;
    }

    public static void reset(){
	measurementList = new HashMap<String, ArrayList<MicroMeasurement>>();
    }
}
