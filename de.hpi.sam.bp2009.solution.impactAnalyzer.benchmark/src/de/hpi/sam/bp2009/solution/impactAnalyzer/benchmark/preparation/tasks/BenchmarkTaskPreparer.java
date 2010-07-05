package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

public class BenchmarkTaskPreparer {
    public static ArrayList<BenchmarkTask> prepareInstanceScopeBenchmarkTasks() {
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
		//result.add(new InstanceScopeAnalysisTask(expression.getExpression(), notification, ia, expression.getContext()));
	    }
	}
	System.out.println("\t\t " + result.size() + " successfully prepared");

	return result;
    }
}
