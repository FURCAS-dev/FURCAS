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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements;

import java.util.ArrayList;

public class AdditiveMeasurement extends DefaultMeasurement {
	ArrayList<Measurement> measurementList = new ArrayList<Measurement>();
	MicroMeasurement lastMeasure = null;

	@Override
	public long getResult() {
		long result = 0;

		for(Measurement measure : measurementList){
			result = result + measure.getResult();
		}

		return result;
	}

	@Override
	public void before() {
		MicroMeasurement newMeasure = new MicroMeasurement();
		measurementList.add(newMeasure);
		lastMeasure = newMeasure;

		newMeasure.before();
	}

	@Override
	public void after() {
		if(lastMeasure != null){
			lastMeasure.after();
		} else
		    throw new RuntimeException("before() was not called before after()");
	}

	public void addMeasurement(Measurement measure){
		measurementList.add(measure);
	}
}
