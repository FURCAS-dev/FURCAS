package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

/**
 * In order to be able to create many more BenchmarkTasks they must be created step by step
 * before executing.
 * 
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkTaskStepwiseBuilder implements Iterator<Queue<BenchmarkTaskContainer>>{
	private final Collection<OCLExpressionWithContext> expressionList;
	private final Collection<NotificationForModelList> notificationForModelList;
	private final Collection<ActivationOption> activiationOptionList;
	
	private Iterator<OCLExpressionWithContext> expressionIterator;
	private Iterator<ActivationOption> activationOptionIterator;
	
	private final BuilderIdentifiers ids = new BuilderIdentifiers();
	
	private ActivationOption currentActivationOption;
	private OCLExpressionWithContext currentExpression;

		
	public BenchmarkTaskStepwiseBuilder(Collection<OCLExpressionWithContext> expressionList, Collection<NotificationForModelList> notificationForModelList, Collection<ActivationOption> activiationOptionList){
		this.expressionList = expressionList;
		this.notificationForModelList = notificationForModelList;
		this.activiationOptionList = activiationOptionList;
		
		expressionIterator = this.expressionList.iterator();

		activationOptionIterator = this.activiationOptionList.iterator();
		
		currentActivationOption = activationOptionIterator.next();
		
		ids.resetContainer();
    	ids.resetBenchmarkTask();
    	ids.resetOption();
	}	
	
	synchronized public boolean hasNext(){
		return expressionIterator.hasNext() || activationOptionIterator.hasNext();
	}
	
	synchronized private void iterate(){		
		if(expressionIterator.hasNext()){
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
	
	synchronized public Queue<BenchmarkTaskContainer> next(){
		Queue<BenchmarkTaskContainer> result = new LinkedList<BenchmarkTaskContainer>();
		
		iterate();
		
		ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(currentExpression.getExpression(), currentExpression.getContext());

	    for(NotificationForModelList notificationList : notificationForModelList){
	    	
	    
	    	BenchmarkTaskContainer container = buildBenchmarkContainer(currentActivationOption, currentExpression, ia, notificationList);

	    	result.add(container);
    	}
		
		return result;
	}

	synchronized public Queue<BenchmarkTaskContainer> buildAll(){
		Queue<BenchmarkTaskContainer> result = new LinkedList<BenchmarkTaskContainer>();
		
		ids.resetContainer();
    	ids.resetBenchmarkTask();
    	ids.resetOption();
		
		//int max = expressionList.size();
    	for(ActivationOption option : activiationOptionList){
    		ids.incrementOption();
    		ids.resetOcl();
    		
	      	for (OCLExpressionWithContext expression : expressionList) {
	    		ids.incrementOcl();
	    		
	    		//if((oclId % 100) == 0)
	    		//	System.out.println(oclId + "/" + max);

	    		ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression.getExpression(), expression.getContext());

	    	    for(NotificationForModelList notificationList : notificationForModelList){
	    	    	BenchmarkTaskContainer container = buildBenchmarkContainer(option, expression, ia, notificationList);

	    	    	result.add(container);
		    	}
	    	}
    	}
   	
    	System.out.println("\t\t " + result.size() + " successfully prepared");
    	
    	return result;
	}
	
	synchronized private BenchmarkTaskContainer buildBenchmarkContainer(
			ActivationOption option, OCLExpressionWithContext expression,
			ImpactAnalyzer ia, NotificationForModelList notificationList) {
		
		Resource model = notificationList.getModel();
		BenchmarkTaskContainer container = new ModelSizeVariationBenchmarkTaskContainer(model, option, String.valueOf(ids.getContainerId()));
		ids.incrementContainer();
		ids.resetNotification();
		
		for(RawNotification notification : notificationList.getNotificationList()){
			// Must check if notification has to be spitted e.g. because MOINs bidirectional link change events
			// may produce two events in EMF for each unidirectional reference
			if(notification.isSplitCandidate()){
			    for(RawNotification split : notification.split()){
				ids.incrementBenchmarkTask();
				ids.incrementNotification();
				
		    	container.add(new ModelSizeVariationBenchmarkTask(expression.getExpression(), expression.getContext(), split, ia, String.valueOf(ids.getOclId()), String.valueOf(ids.getNotificationId()), String.valueOf(ids.getBenchmarkTaskId()), String.valueOf(ids.getOptionId())));
			    }
			}else{
			    ids.incrementBenchmarkTask();
			    ids.incrementNotification();
			    
			    container.add(new ModelSizeVariationBenchmarkTask(expression.getExpression(), expression.getContext(), notification, ia, String.valueOf(ids.getOclId()), String.valueOf(ids.getNotificationId()), String.valueOf(ids.getBenchmarkTaskId()), String.valueOf(ids.getOptionId())));
			}
		}
		return container;
	}
	
	
	private class BuilderIdentifiers{
		private int containerId = 0;
		private int benchmarkTaskId = 0;
		private int oclId = 0;
		private int notificationId = 0;
		private int optionId = 0;
		
		public void incrementOption(){
			optionId++;
		}
		
		public void incrementContainer(){
			containerId++;
		}
		
		public void incrementBenchmarkTask(){
			benchmarkTaskId++;
		}
		
		public void incrementOcl(){
			oclId++;
		}
		
		public void incrementNotification(){
			notificationId++;
		}
		
		public void resetOption(){
			optionId = 0;
		}
		
		public void resetContainer(){
			containerId = 0;
		}
		
		public void resetBenchmarkTask(){
			benchmarkTaskId = 0;
		}
		
		public void resetOcl(){
			oclId = 0;
		}
		
		public void resetNotification(){
			notificationId = 0;
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
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
