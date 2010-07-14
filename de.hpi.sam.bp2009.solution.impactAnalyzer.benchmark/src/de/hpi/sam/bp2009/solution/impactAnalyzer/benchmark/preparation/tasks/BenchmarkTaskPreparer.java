package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

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

    public static ArrayList<BenchmarkTask> prepareMultipleNotificationBenchmarkTasks(){
    	ArrayList<BenchmarkTask> result = new ArrayList<BenchmarkTask>();

    	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<Notification> notificationList = BenchmarkNotificationPreparer.prepareRealWorldReplayNotification();
    	System.out.println("\t\t " + notificationList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");
    	for (OCLExpressionWithContext expression : expressionList) {
    		 //result.add(new MultipleNotificationInstanceScopeAnalysisTask(expression.getExpression(), expression.getContext(), notificationList));
    	}
    	System.out.println("\t\t " + result.size() + " successfully prepared");

    	return result;
    }

    public static ArrayList<BenchmarkTask> prepareModelSizeVariationBenchmarkTasks(){
    	ArrayList<BenchmarkTask> result = new ArrayList<BenchmarkTask>();

    	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<NotificationForModelList> notificationForModelList = BenchmarkNotificationPreparer.prepareModelSizeVariationNotification();
    	System.out.println("\t\t " + notificationForModelList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");

    	for (OCLExpressionWithContext expression : expressionList) {
    	    result.add(new MultipleNotificationInstanceScopeAnalysisTask(expression.getExpression(), expression.getContext(), notificationForModelList));
    	}
    	System.out.println("\t\t " + result.size() + " successfully prepared");

    	return result;
    }
}
