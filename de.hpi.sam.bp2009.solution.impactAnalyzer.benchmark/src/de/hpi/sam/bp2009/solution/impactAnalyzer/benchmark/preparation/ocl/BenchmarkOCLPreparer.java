package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;

public class BenchmarkOCLPreparer {
    public static ArrayList<OCLExpressionWithContext> prepareAll() {
	ArrayList<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();

	result.addAll(new OCLExpressionFromClassTcsPicker().pickUpExpressions());
	result.addAll(new OCLExpressionFromModelPicker().pickUpExpressions());

	return result;
    }
}
