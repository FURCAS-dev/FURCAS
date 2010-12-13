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

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.postprocessing.ResultDescriptionWriter;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationForModelList;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.RawNotification;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;


/**
 * In order to be able to create many more BenchmarkTasks they must be created
 * step by step before executing.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkTaskStepwiseBuilder implements Queue<BenchmarkTaskContainer> {
    private final Collection<OCLExpressionWithContext> expressionList;
    private final Collection<NotificationForModelList> notificationForModelList;
    private final Collection<ActivationOption> activiationOptionList;

    private Iterator<OCLExpressionWithContext> expressionIterator;
    private final Iterator<ActivationOption> activationOptionIterator;
    private Iterator<NotificationForModelList> modelIterator;

    private final BuilderIdentifiers ids = new BuilderIdentifiers();

    private ActivationOption currentActivationOption;
    private OCLExpressionWithContext currentExpression;
    private NotificationForModelList currentModel;

    private int iterations = 0;

    public BenchmarkTaskStepwiseBuilder(Collection<OCLExpressionWithContext> expressionList,
	    Collection<NotificationForModelList> notificationForModelList, Collection<ActivationOption> activiationOptionList) {
	this.expressionList = expressionList;
	this.notificationForModelList = notificationForModelList;
	this.activiationOptionList = activiationOptionList;

	expressionIterator = this.expressionList.iterator();
	activationOptionIterator = this.activiationOptionList.iterator();
	modelIterator = this.notificationForModelList.iterator();

	currentExpression = expressionIterator.next();
        ids.incrementOcl();
	currentActivationOption = activationOptionIterator.next();
        ids.incrementOption();

	ids.resetContainer();
	ids.resetBenchmarkTask();
	ids.resetOption();
    }

    synchronized public boolean hasNext() {
	return modelIterator.hasNext() || expressionIterator.hasNext() || activationOptionIterator.hasNext();
    }

    synchronized private void iterate() {
	iterations++;

	if (modelIterator.hasNext()) {
	    currentModel = modelIterator.next();
	    ids.incrementModel();
	    return;
	}

	modelIterator = notificationForModelList.iterator();
	ids.resetModel();
	currentModel = modelIterator.next();
	ids.incrementModel();

	if (expressionIterator.hasNext()) {
	    currentExpression = expressionIterator.next();
	    ids.incrementOcl();
	    return;
	}

	expressionIterator = expressionList.iterator();
	ids.resetOcl();
	currentExpression = expressionIterator.next();
	ids.incrementOcl();

	// Do not reset outer iterator
	currentActivationOption = activationOptionIterator.next();
	ids.incrementOption();
    }

    synchronized public BenchmarkTaskContainer next() {
	iterate();

	return buildBenchmarkContainer(currentActivationOption, currentExpression, currentModel);
    }

    synchronized public Queue<BenchmarkTaskContainer> buildAll() {
	Queue<BenchmarkTaskContainer> result = new LinkedList<BenchmarkTaskContainer>();

	ids.resetContainer();
	ids.resetBenchmarkTask();
	ids.resetOption();

	// int max = expressionList.size();
	for (ActivationOption option : activiationOptionList) {
	    ids.incrementOption();
	    ids.resetOcl();

	    for (OCLExpressionWithContext expression : expressionList) {
		ids.incrementOcl();

		// if((oclId % 100) == 0)
		// System.out.println(oclId + "/" + max);

		for (NotificationForModelList notificationList : notificationForModelList) {
		    BenchmarkTaskContainer container = buildBenchmarkContainer(option, expression, notificationList);

		    result.add(container);
		}
	    }
	}

	System.out.println("\t\t " + result.size() + " successfully prepared");

	return result;
    }

    /**
     * TODO: extract print description files into its own class
     * @throws IOException
     */
    public void printDescriptionFiles() throws IOException{
	System.out.println("Write description files...");
	writeExpressionDescription();
	writeOptionDescription();
	writeNotificationAndModelDescription();
	System.out.println("Finished writing description files...");
    }

    private void writeExpressionDescription() throws IOException {
	ResultDescriptionWriter writer = new ResultDescriptionWriter("oclDescription.data");

	int oclId = 0;
	for(OCLExpressionWithContext expression : expressionList){
	    oclId++;
	    HashMap<String, Object> descriptionMap = new HashMap<String, Object>();
	    descriptionMap.put("id", oclId);
	    descriptionMap.put("expression", expression.getExpression().toString());
	    descriptionMap.put("context", expression.getContext().toString());
	    writer.writeDescriptionLine(descriptionMap);
	}
	writer.close();
    }

    private void writeOptionDescription() throws IOException{
	ResultDescriptionWriter writer = new ResultDescriptionWriter("optionDescription.data");

	int optionId = 0;
	for(ActivationOption option : activiationOptionList){
	    HashMap<String, Object> descriptionMap = new HashMap<String, Object>();
	    descriptionMap.put("id", optionId);
	    descriptionMap.put("description", option.getOptionDescription());

	    writer.writeDescriptionLine(descriptionMap);
	    optionId++;
	}

	writer.close();
    }

    private void writeNotificationAndModelDescription() throws IOException{
	ResultDescriptionWriter writer = new ResultDescriptionWriter("modelDescription.data");

	boolean firstIteration = true;
	int modelId = 0;
	for(NotificationForModelList notification : notificationForModelList){
	    modelId++;
	    //Resource model = notification.getModel();

	    HashMap<String, Object> descriptionMap = new HashMap<String, Object>();
	    descriptionMap.put("id", modelId);
	    writer.writeDescriptionLine(descriptionMap);

	    if(firstIteration){
		writeNotificationDescription(notification);
		firstIteration = false;
	    }
	}

	writer.close();
    }

    private void writeNotificationDescription(NotificationForModelList notification) throws IOException {
	ResultDescriptionWriter writer = new ResultDescriptionWriter("notificationDescription.data");

	int notificationId = 0;
	for(RawNotification rawNotification : notification.getNotificationList()){
	    if(rawNotification.isSplitCandidate()){
		for(RawNotification splits : rawNotification.split()){
		    notificationId++;

		    writeNotificationInformation(writer, notificationId, splits);
		}
	    }else{
		notificationId++;

		writeNotificationInformation(writer, notificationId, rawNotification);
	    }
	}

	writer.close();
    }

    private void writeNotificationInformation(ResultDescriptionWriter writer, int notificationId, RawNotification splits) {
	HashMap<String, Object> descriptionMap = new HashMap<String, Object>();
	descriptionMap.put("id", notificationId);
	descriptionMap.put("eventType", splits.getEventType());
	for (Map.Entry<String, String> entry : splits.getAttributeMap().entrySet()) {
	    descriptionMap.put(entry.getKey(), entry.getKey()+"="+entry.getValue());
	}
	descriptionMap.put("splitNumber", "splitNumber="+splits.getSplitNumber());
	writer.writeDescriptionLine(descriptionMap);
    }

    synchronized private BenchmarkTaskContainer buildBenchmarkContainer(ActivationOption option,
	    OCLExpressionWithContext expression, NotificationForModelList notificationList) {

	OppositeEndFinder oppositeEndFinder = new AllInstanceCallCountingOppositeEndFinder();
	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression.getExpression(),
		expression.getContext(), /* notifyOnNewContextElements */ false, oppositeEndFinder, option,
		OCLFactory.INSTANCE);

	Resource model = notificationList.getModel();
	BenchmarkTaskContainer container = new ModelSizeVariationBenchmarkTaskContainer(model, option, String.valueOf(ids
		.getContainerId()));
	ids.incrementContainer();
	ids.resetNotification();

	for (RawNotification notification : notificationList.getNotificationList()) {
	    // Must check if notification has to be spitted e.g. because MOINs
	    // bidirectional link change events
	    // may produce two events in EMF for each unidirectional reference
	    if (notification.isSplitCandidate()) {
		for (RawNotification split : notification.split()) {
		    ids.incrementBenchmarkTask();
		    ids.incrementNotification();

		    container.add(new ModelSizeVariationBenchmarkTask(expression, split, ia, String.valueOf(ids.getOclId()),
			    String.valueOf(ids.getNotificationId()), String.valueOf(ids.getBenchmarkTaskId()), String.valueOf(ids
				    .getOptionId()), String.valueOf(ids.getModelId()), oppositeEndFinder));
		}
	    } else {
		ids.incrementBenchmarkTask();
		ids.incrementNotification();

		container.add(new ModelSizeVariationBenchmarkTask(expression, notification, ia, String.valueOf(ids.getOclId()),
			String.valueOf(ids.getNotificationId()), String.valueOf(ids.getBenchmarkTaskId()), String.valueOf(ids
				.getOptionId()), String.valueOf(ids.getModelId()), oppositeEndFinder));
	    }
	}
	return container;
    }

    private class BuilderIdentifiers {
	private int containerId = 0;
	private int benchmarkTaskId = 0;
	private int oclId = 0;
	private int notificationId = 0;
	private int optionId = 0;
	private int modelId = 0;

	public void incrementModel() {
	    modelId++;
	}

	public void incrementOption() {
	    optionId++;
	}

	public void incrementContainer() {
	    containerId++;
	}

	public void incrementBenchmarkTask() {
	    benchmarkTaskId++;
	}

	public void incrementOcl() {
	    oclId++;
	}

	public void incrementNotification() {
	    notificationId++;
	}

	public void resetOption() {
	    optionId = 0;
	}

	public void resetContainer() {
	    containerId = 0;
	}

	public void resetBenchmarkTask() {
	    benchmarkTaskId = 0;
	}

	public void resetOcl() {
	    oclId = 0;
	}

	public void resetNotification() {
	    notificationId = 0;
	}

	public void resetModel() {
	    modelId = 0;
	}

	public int getModelId() {
	    return modelId;
	}

	public int getContainerId() {
	    return containerId;
	}

	public int getBenchmarkTaskId() {
	    return benchmarkTaskId;
	}

	public int getOclId() {
	    return oclId;
	}

	public int getNotificationId() {
	    return notificationId;
	}

	public int getOptionId() {
	    return optionId;
	}
    }

    @Override
    public synchronized int size() {
	return (expressionList.size() * notificationForModelList.size() * activiationOptionList.size()) - iterations;
    }

    @Override
    public synchronized boolean isEmpty() {
	return !hasNext();
    }

    @Override
    public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Iterator<BenchmarkTaskContainer> iterator() {
	return null;
    }

    @Override
    public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean addAll(Collection<? extends BenchmarkTaskContainer> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean add(BenchmarkTaskContainer e) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean offer(BenchmarkTaskContainer e) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public synchronized BenchmarkTaskContainer remove() {
	return next();
    }

    @Override
    public BenchmarkTaskContainer poll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public BenchmarkTaskContainer element() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public BenchmarkTaskContainer peek() {
	// TODO Auto-generated method stub
	return null;
    }

}
