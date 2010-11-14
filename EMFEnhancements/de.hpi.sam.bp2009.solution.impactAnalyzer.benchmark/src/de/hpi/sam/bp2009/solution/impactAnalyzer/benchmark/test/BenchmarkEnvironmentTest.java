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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCL;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.PathOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.ProcessingOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RealWorldReplayNotificationProducer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.EnvironmentFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class BenchmarkEnvironmentTest extends TestCase {

    @Test
	public void testWithEmptyTask(){
		LinkedList<BenchmarkTask> benchmarkTasks = new LinkedList<BenchmarkTask>();
		PathOptions.setOutputPath("/tmp/testWithEmptyTask.data");
		ProcessingOptions.setNumberOfJobs(6);
		ProcessingOptions.setNumberOfMeasures(100);
		ProcessingOptions.setNumberOfWarmUps(1000);

		for(int i = 0; i < 10000; i++){
			benchmarkTasks.add(new BenchmarkTaskMock());
		}

		//BenchmarkExecutionProcessor.processBenchmarks(benchmarkTasks);
	}




    @Test
    public void testRealWorldReplayNotificationProducer(){
	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll(
	        /* oclId */ null /* meaning ALL OCL expressions */);

	Resource fullSizeModel = NotificationResourceLoader.loadModel("NgpmModel.xmi");


	EPackage pkgList[] = {data.classes.ClassesPackage.eINSTANCE,
	data.constraints.ConstraintsPackage.eINSTANCE, data.documents.DocumentsPackage.eINSTANCE,
	data.generics.GenericsPackage.eINSTANCE, data.quantitystructure.QuantitystructurePackage.eINSTANCE,
	data.timedependency.TimedependencyPackage.eINSTANCE, data.tuples.TuplesPackage.eINSTANCE,

	dataaccess.analytics.AnalyticsPackage.eINSTANCE, dataaccess.expressions.ExpressionsPackage.eINSTANCE,
	dataaccess.expressions.fp.FpPackage.eINSTANCE, dataaccess.expressions.literals.LiteralsPackage.eINSTANCE,
	dataaccess.query.QueryPackage.eINSTANCE,

	behavioral.actions.ActionsPackage.eINSTANCE, behavioral.bpdm.BpdmPackage.eINSTANCE,
	behavioral.businesstasks.BusinesstasksPackage.eINSTANCE, behavioral.events.EventsPackage.eINSTANCE,
	behavioral.rules.RulesPackage.eINSTANCE,

	persistence.actions.ActionsPackage.eINSTANCE, persistence.expressions.ExpressionsPackage.eINSTANCE};

	for(EPackage pkg : pkgList){
	    fullSizeModel.getResourceSet().getResources().add(pkg.eResource());
	}

	ArrayList<RawNotification> notiList = (ArrayList<RawNotification>)new RealWorldReplayNotificationProducer().produce("modifyElementaryTypesEventTrace.trace");

	for (OCLExpressionWithContext expression : expressionList) {
	    fullSizeModel.getResourceSet().getResources().add(expression.getExpression().eResource());

	    for (RawNotification rawNoti : notiList) {
		if(rawNoti.isSplitCandidate()){
		    evaluate(fullSizeModel, expression, rawNoti.split().get(0));
		    evaluate(fullSizeModel, expression, rawNoti.split().get(1));
		}else{
		    evaluate(fullSizeModel, expression, rawNoti);
		}
	    }
	}
    }

    private void evaluate(Resource fullSizeModel, OCLExpressionWithContext expression, RawNotification rawNoti) {
	OCL ocl = OCL.newInstance();
	ocl = OCL.newInstance(new EnvironmentFactory().createPackageContext(ocl.getEnvironment(),
	        expression.getOclWithPackage().getPackage()));

	EClass context = expression.getContext();
	TreeIterator<EObject> iterator = fullSizeModel.getAllContents();

	while(iterator.hasNext()){
	    EObject obj = iterator.next();
	    if(context.isInstance(obj)){System.out.println(expression.getExpression());
		System.out.println(ocl.evaluate(obj, expression.getExpression()));
	    }
	}
    }


	@SuppressWarnings("unused")
	private class BenchmarkTaskMock implements BenchmarkTask{
	private final int callCounter = 0;

	@Override
	public Collection<EObject> call() throws Exception {
		//Thread.sleep(0, 10);

		return null;
	}

	public int getCallCounter(){
	    return callCounter;
	}

	@Override
	public Map<String, String> getAdditionalInformation() {
	    return Collections.emptyMap();
	}

	@Override
	public void beforeCall() {
	    // TODO Auto-generated method stub

	}

	@Override
	public void afterCall() {
	    // TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> getAdditionalMeasurementInformation() {
	    return new LinkedHashMap<String, String>();
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getResult() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public void callEvaluation() {
	    // TODO Auto-generated method stub

	}

	@Override
	public boolean deactivate() {
	    // TODO Auto-generated method stub
	    return false;
	}
    }
}
