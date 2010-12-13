/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark.execution.measurements;

import java.util.ArrayList;
import java.util.HashMap;

public class BenchmarkMeasurements {
	static int aggregateCounter = 0;

    private static HashMap<String, ArrayList<Measurement>> measurementList = new HashMap<String, ArrayList<Measurement>>();

    public static Measurement createNewMeasurement(String measurePointId) {
	Measurement measure = new MicroMeasurement();

	if (getMeasurementList().containsKey(measurePointId)) {
	    getMeasurementList().get(measurePointId).add(measure);
	} else {
	    getMeasurementList().put(measurePointId, new ArrayList<Measurement>());
	    getMeasurementList().get(measurePointId).add(measure);
	}

	return measure;
    }

    public static Measurement createNewAdditiveMeasurement(String measurePointId) {
    	Measurement measure = new AdditiveMeasurement();

    	if (getMeasurementList().containsKey(measurePointId)) {
    	    getMeasurementList().get(measurePointId).add(measure);
    	} else {
    	    getMeasurementList().put(measurePointId, new ArrayList<Measurement>());
    	    getMeasurementList().get(measurePointId).add(measure);
    	}

    	return measure;
    }

    public static Measurement createSubMeasurement(String id, String subId){
	MicroMeasurement measure = new MicroMeasurement();

	ArrayList<Measurement> allMeasuresForId = getMeasurementList().get(id);
	Measurement parent = allMeasuresForId.get(allMeasuresForId.size() - 1);
	parent.addSubMeasurement(subId, measure);

	return measure;
    }

    public static HashMap<String, ArrayList<Measurement>> getMeasurementList() {
	return measurementList;
    }

    public static void reset(){
	measurementList = new HashMap<String, ArrayList<Measurement>>();
	aggregateCounter = 0;
    }

    public static void aggregate(){

    	for(String key : measurementList.keySet()){
    		ArrayList<Measurement> value = measurementList.get(key);
    		ArrayList<Measurement> newValue = new ArrayList<Measurement>();

    		if(value.size() > (aggregateCounter + 1)){
    			for(int i = 0; i < aggregateCounter; i++){
    				newValue.add(value.get(i));
    			}

    			AdditiveMeasurement additiveMeasure = new AdditiveMeasurement();
    			for(int i = aggregateCounter; i < value.size(); i++){
    				additiveMeasure.addMeasurement(value.get(i));
    			}

    			newValue.add(additiveMeasure);
    		}

    		measurementList.put(key, newValue);
    	}

    	aggregateCounter++;
    }
}
