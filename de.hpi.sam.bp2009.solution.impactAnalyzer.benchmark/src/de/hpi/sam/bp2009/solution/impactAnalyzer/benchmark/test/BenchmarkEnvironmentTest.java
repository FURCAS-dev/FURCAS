package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

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



    @SuppressWarnings("unused")
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

	@Override
	public Map<String, String> getAdditionalInformation() {
	    // TODO Auto-generated method stub
	    return null;
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
