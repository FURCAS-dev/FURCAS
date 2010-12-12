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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

/** It is not necessary that a all instance evaluation is measured multiple times for one single model size
 * Therefore different benchmark jobs for one model size share the same all instance evaluation measurement.
 *
 * @author
 */
@SuppressWarnings("restriction")
public class AllInstanceEvaluationMeasurement {

    // Model for which a all instance call is measured
    private final Resource model;
    private final LinkedHashMap<String, String> additionalInformation = new LinkedHashMap<String, String>();
    private final OppositeEndFinder oppositeEndFinder;

    private Collection<EObject> allInstances = null;
    private boolean hasBeenMeasuredAlready = false;

    private final OCL ocl;
    private final OCLExpressionWithContext expression;

    public AllInstanceEvaluationMeasurement(OppositeEndFinder oppositeEndFinder, Resource model, OCLExpressionWithContext expression) {
	this.oppositeEndFinder = oppositeEndFinder;
	this.model = model;
	this.expression = expression;
	this.ocl = com.sap.emf.ocl.util.OCL.newInstance(oppositeEndFinder);
    }

    public LinkedHashMap<String, String> getAdditionalInformation(){
	assert hasBeenMeasuredAlready == true;

	return additionalInformation;
    }

    public void measureAllInstances() {
	assert hasBeenMeasuredAlready == false;

	//Prerun to be sure that index is initialized
	oppositeEndFinder.getAllInstancesSeenBy(expression.getContext(), model);

	long beforeAllInstances = System.nanoTime();
	allInstances = oppositeEndFinder.getAllInstancesSeenBy(expression.getContext(), model);
	long afterAllInstances = System.nanoTime();

	additionalInformation.put("allInstanceExecTime", String.valueOf(afterAllInstances - beforeAllInstances));
	additionalInformation.put("noAllInstances", String.valueOf(allInstances.size()));

	//Only do this when activating. More runs are far too expensive.
	Collection<Object> allInstancesEvaluationResult = new LinkedList<Object>();

	((AllInstanceCallCountingOppositeEndFinder)oppositeEndFinder).resetAll();
	long timeToEvaluate = 0;
	long timeToEvaluateWithoutInvalidResults = 0;
	for(EObject affectedElement : allInstances){
	    //Prerun in order to eliminate caching effects
	    ocl.evaluate(affectedElement, expression.getExpression());

	    long before = System.nanoTime();
	    Object result = ocl.evaluate(affectedElement, expression.getExpression());
	    long after = System.nanoTime();
	    allInstancesEvaluationResult.add(result);
	    timeToEvaluate = timeToEvaluate + (after - before);
	    if(result == null || !result.equals(OCLStandardLibraryImpl.INSTANCE.getInvalid())){
		timeToEvaluateWithoutInvalidResults = timeToEvaluateWithoutInvalidResults + (after - before);
	    }
	}
	int allInstancesCalls = ((AllInstanceCallCountingOppositeEndFinder)oppositeEndFinder).getAllInstancesCalled();
	additionalInformation.put("noAllInstanceEvalAllInstanceCalls", String.valueOf(allInstancesCalls));

	int findOppositeEndsCalls = ((AllInstanceCallCountingOppositeEndFinder)oppositeEndFinder).getFindOppositeEndsCalled();
	additionalInformation.put("noAllInstanceFindOppositeEndsCalls", String.valueOf(findOppositeEndsCalls));

	int getAllOppositeEndsCalls = ((AllInstanceCallCountingOppositeEndFinder)oppositeEndFinder).getGetAllOppositeEndsCalled();
	additionalInformation.put("noAllInstanceGetAllOppositeEndsCalls", String.valueOf(getAllOppositeEndsCalls));
	((AllInstanceCallCountingOppositeEndFinder)oppositeEndFinder).resetAll();


	additionalInformation.put("allInstanceEvalTime", String.valueOf(new Long(timeToEvaluate)));
	additionalInformation.put("allInstanceEvalTimeWoInvalid", String.valueOf(new Long(timeToEvaluateWithoutInvalidResults)));

	additionalInformation.put("allInstanceNoInvalidEvals", String.valueOf(getNoOfInvalidEvaluations(allInstancesEvaluationResult)));

	hasBeenMeasuredAlready = true;
    }

    public void setHasBeenMeasuredAlready(boolean hasBeenMeasuredAlready) {
	this.hasBeenMeasuredAlready = hasBeenMeasuredAlready;
    }

    public boolean isHasBeenMeasuredAlready() {
	return hasBeenMeasuredAlready;
    }

    public int getNoOfInvalidEvaluations(Collection<Object> evaluationResult) {
	int invalidEvaluationCounter = 0;
	for(Object result : evaluationResult){
	    if(result != null && result.equals(OCLStandardLibraryImpl.INSTANCE.getInvalid())){
		invalidEvaluationCounter++;
	    }
	}
	return invalidEvaluationCounter;
    }
}
