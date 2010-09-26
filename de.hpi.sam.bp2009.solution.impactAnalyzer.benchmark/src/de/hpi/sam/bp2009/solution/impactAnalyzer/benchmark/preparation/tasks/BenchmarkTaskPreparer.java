package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;


import java.util.ArrayList;
import java.util.Collection;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.PathOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationForModelList;
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
     public static BenchmarkTaskStepwiseBuilder createBenchmarkBuilder(){
     	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll();
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<NotificationForModelList> notificationForModelList = BenchmarkNotificationPreparer.prepareModelSizeVariationNotification(
    	        PathOptions.getEventTraceFixturePath(), PathOptions.getModelFixturePath());
    	System.out.println("\t\t " + notificationForModelList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");

    	Collection<ActivationOption> optionList = new ArrayList<ActivationOption>();
    	optionList.add(new ActivationOption(true, true, true, "All optimizations activated, TracebackSteps"));
    	optionList.add(new ActivationOption(false, true, true, "Without delta propagation, TracebackSteps"));
        optionList.add(new ActivationOption(true, false, true, "Without unused checks, TracebackSteps"));
        optionList.add(new ActivationOption(true, false, false, "Without unused checks, NavigationSteps"));

    	return new BenchmarkTaskStepwiseBuilder(expressionList, notificationForModelList, optionList);
     }
}
