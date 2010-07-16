package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;

/**
 * The {@link BenchmarkTaskPreparer} provides methods for creating a collection of
 * specific {@link BenchmarkTask}s.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkTaskPreparer {
    public static ArrayList<BenchmarkTask> prepareSingleNotificationBenchmarkTasks() {
	ArrayList<BenchmarkTask> result = new ArrayList<BenchmarkTask>();

	System.out.println("Start Preparation");
	System.out.println("\t Prepare OCL Expressions");
	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

	System.out.println("\t Prepare Notifications");
	Collection<Notification> notificationList = BenchmarkNotificationPreparer.prepareRealWorldReplayNotification();
	System.out.println("\t\t " + notificationList.size() + " successfully prepared");

	System.out.println("\t Prepare Benchmark Tasks");
	for (OCLExpressionWithContext expression : expressionList) {
	    for (Notification notification : notificationList) {
		 result.add(new SingleNotificationInstanceScopeAnalysisTask(expression.getExpression(), notification, expression.getContext()));
	    }
	}
	System.out.println("\t\t " + result.size() + " successfully prepared");

	return result;
    }

     public static Queue<BenchmarkTask> prepareModelSizeVariationBenchmarkTasks(){
    	Queue<BenchmarkTask> result = new LinkedList<BenchmarkTask>();

    	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<NotificationForModelList> notificationForModelList = BenchmarkNotificationPreparer.prepareModelSizeVariationNotification();
    	System.out.println("\t\t " + notificationForModelList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");

       	
    	int oclId = 0;
    	int benchmarkTaskId = 0;
      	for (OCLExpressionWithContext expression : expressionList) {
    		oclId++;
    		ImpactAnalyzer ia = new ImpactAnalyzerImpl(expression.getExpression(), expression.getContext());
    		
    	    for(NotificationForModelList notificationList : notificationForModelList){
    		Resource model = notificationList.getModel();
    		
    		int notificationId = 0;
    		for(Notification notification : notificationList.getNotificationList()){
    			notificationId++;
    			benchmarkTaskId++;
    			result.add(new ModelSizeVariationBenchmarkTask(expression.getExpression(), expression.getContext(), model, notification, ia, String.valueOf(oclId), String.valueOf(notificationId), String.valueOf(benchmarkTaskId)));
    		}
    	    }
    	}
    	System.out.println("\t\t " + result.size() + " successfully prepared");

    	return result;
    }
}
