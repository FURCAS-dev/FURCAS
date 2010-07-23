package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

/**
 * The {@link BenchmarkTaskPreparer} provides methods for creating a collection of
 * specific {@link BenchmarkTask}s.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkTaskPreparer {
     public static Queue<BenchmarkTaskContainer> prepareModelSizeVariationBenchmarkTasks(){
    	Queue<BenchmarkTaskContainer> result = new LinkedList<BenchmarkTaskContainer>();

    	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<NotificationForModelList> notificationForModelList = BenchmarkNotificationPreparer.prepareModelSizeVariationNotification();
    	System.out.println("\t\t " + notificationForModelList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");


    	int containerId = 0;
    	int benchmarkTaskId = 0;
    	int max = expressionList.size();

    	int optionId = 0;
    	ActivationOption[] options = { new ActivationOption(true, true), new ActivationOption(true, false) };
    	for(ActivationOption option : options){
    		int oclId = 0;
	      	for (OCLExpressionWithContext expression : expressionList) {
	    		oclId++;
	    		System.out.println(oclId + "/" + max);

	    		ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression.getExpression(), expression.getContext());


	    	    for(NotificationForModelList notificationList : notificationForModelList){
	    	    	Resource model = notificationList.getModel();
		    	    BenchmarkTaskContainer container = new ModelSizeVariationBenchmarkTaskContainer(model, option, String.valueOf(containerId));
		    	    containerId++;

				    int notificationId = 0;
				    for(RawNotification notification : notificationList.getNotificationList()){
				    	// Must check if notification has to be spitted e.g. because MOINs bidirectional link change events
				    	// may produce two events in EMF for each unidirectional reference
				    	if(notification.isSplitCandidate()){
				    	    for(RawNotification split : notification.split()){
				    		benchmarkTaskId++;
					    	notificationId++;
					  	container.add(new ModelSizeVariationBenchmarkTask(expression.getExpression(), expression.getContext(), split, ia, String.valueOf(oclId), String.valueOf(notificationId), String.valueOf(benchmarkTaskId), String.valueOf(optionId)));
				    	    }
				    	}else{
				    	    benchmarkTaskId++;
				    	    notificationId++;
				    	    container.add(new ModelSizeVariationBenchmarkTask(expression.getExpression(), expression.getContext(), notification, ia, String.valueOf(oclId), String.valueOf(notificationId), String.valueOf(benchmarkTaskId), String.valueOf(optionId)));
				    	}
				   }

				    result.add(container);
		    	}
	    	}
    	}
    	System.out.println("\t\t " + result.size() + " successfully prepared");

    	return result;
    }
}
