package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;


public class RealWorldFailingTest extends TestCase {

    // TODO Test case needs a meaningful name
	
	// Test is temporary ignored because at the moment the BenchmarkNotificationPreparer produces invalid models
    @Ignore
    public void testDeltaPropagationEndsInEndlessRecursion(){
	//OCLExpressionWithContext ocl = new OCLExpressionFromClassTcsPicker().pickUpExpression(5);
	//System.out.println(ocl.getExpression());
	//Notification notification =((ArrayList<Notification>)BenchmarkNotificationPreparer.prepareRealWorldReplayNotification()).get(2);
	//System.out.println(notification);

    //    ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(ocl.getExpression(), ocl.getContext())
    //            .getContextObjects(notification);
    }

    // TODO Test case needs a meaningful name
    @Test
    public void testInstanceScopeAnalysisEndsInEndlessRecursion(){
	//OCLExpressionWithContext ocl = new OCLExpressionFromClassTcsPicker().pickUpExpression(42);
	//System.out.println(ocl.getExpression());
	//Notification notification =((ArrayList<Notification>)BenchmarkNotificationPreparer.prepareRealWorldReplayNotification()).get(1);
	//System.out.println(notification);

    //    ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(ocl.getExpression(), ocl.getContext())
    //            .getContextObjects(notification);
    }
}
