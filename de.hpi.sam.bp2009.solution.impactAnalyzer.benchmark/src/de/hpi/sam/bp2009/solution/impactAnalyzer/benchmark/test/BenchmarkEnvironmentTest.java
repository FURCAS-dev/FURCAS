package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromModelPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;

public class BenchmarkEnvironmentTest extends TestCase {

    @Test
    public void testOCLExpressionFromClassTcsPicker(){
	int numberOfUnparsedExpressions = OCLTestExpressionContainer.getExpressionList().size();
	int numberOfParsedExpressions = new OCLExpressionFromClassTcsPicker().pickUpExpressions().size();

	assertTrue(numberOfUnparsedExpressions == numberOfParsedExpressions);
    }

    @Test
    public void testOCLExpressionFromModelPicker(){
	//TODO: Change static number of Expressions to something dynamic
	assertTrue(new OCLExpressionFromModelPicker().pickUpExpressions(company.CompanyPackage.eINSTANCE).size() >= 20);
    }

    @Test
    public void testRealWorldReplayNotificationProducer(){
	//FIXME: Implement test
    }

    @Test
    public void testProcessingSimpleBenchmarks(){
	ArrayList<BenchmarkTask> mockList = new ArrayList<BenchmarkTask>();

	for(int i = 0; i < 10; i++){
	    mockList.add(new BenchmarkTaskMock());
	}

	BenchmarkExecutionProcessor.processSimpleBenchmarks(mockList);

	for(int i = 0; i < 10; i++){
	    assertTrue(((BenchmarkTaskMock)mockList.get(i)).getCallCounter() > 0);
	}
    }

    @Test
    public void testProcessingExtensiveBenchmarks(){
	ArrayList<BenchmarkTask> mockList = new ArrayList<BenchmarkTask>();

	for(int i = 0; i < 3; i++){
	    mockList.add(new BenchmarkTaskMock());
	}

	BenchmarkExecutionProcessor.processExtensiveBenchmarks(mockList);

	for(int i = 0; i < 3; i++){
	    assertTrue(((BenchmarkTaskMock)mockList.get(i)).getCallCounter() > 0);
	}
    }

    private class BenchmarkTaskMock implements BenchmarkTask{
	private int callCounter = 0;

	@Override
	public Collection<EObject> call() throws Exception {
	    callCounter++;
	    return null;
	}

	public int getCallCounter(){
	    return callCounter;
	}
    }
}
