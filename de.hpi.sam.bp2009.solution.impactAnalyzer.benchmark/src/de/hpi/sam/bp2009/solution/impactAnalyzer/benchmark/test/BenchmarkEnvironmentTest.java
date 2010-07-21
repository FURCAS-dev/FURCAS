package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.OutputOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.ProcessingOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromModelPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class BenchmarkEnvironmentTest extends TestCase {

    @Test
	public void testWithEmptyTask(){
		LinkedList<BenchmarkTask> benchmarkTasks = new LinkedList<BenchmarkTask>();
		OutputOptions.setOutputPath("/tmp/testWithEmptyTask.data");
		ProcessingOptions.setNumberOfJobs(6);
		ProcessingOptions.setNumberOfMeasures(100);
		ProcessingOptions.setNumberOfWarmUps(1000);
		
		for(int i = 0; i < 10000; i++){
			benchmarkTasks.add(new BenchmarkTaskMock());
		}
		
		BenchmarkExecutionProcessor.processBenchmarks(benchmarkTasks);
	}

	
    @Test
    public void testOCLExpressionFromClassTcsPicker(){
	int numberOfUnparsedExpressions = OCLTestExpressionContainer.getExpressionList().size();
	int numberOfParsedExpressions = new OCLExpressionFromClassTcsPicker().pickUpExpressions().size();

	assertTrue(numberOfUnparsedExpressions == numberOfParsedExpressions);
    }

    @Test
    public void testOCLExpressionFromModelPicker(){
	assertTrue(new OCLExpressionFromModelPicker().pickUpExpressions(company.CompanyPackage.eINSTANCE).size() >= 20);
    }

    @Test
    public void testRealWorldReplayNotificationProducer(){
	//
    }
    

	@SuppressWarnings("unused")
	private class BenchmarkTaskMock implements BenchmarkTask{
	private int callCounter = 0;

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
    }
}