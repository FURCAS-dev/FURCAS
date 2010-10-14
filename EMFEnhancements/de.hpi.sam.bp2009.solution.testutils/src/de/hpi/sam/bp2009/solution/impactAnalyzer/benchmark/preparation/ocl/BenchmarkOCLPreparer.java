package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkOCLPreparer {
    /**
     * @param oclId starting with 1 to match with output in oclDescription.data
     */
    public static List<OCLExpressionWithContext> prepareAll(Integer oclId) {
	ArrayList<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();
        List<OCLExpressionWithContext> tcsExpressions = new OCLExpressionFromClassTcsPicker().pickUpExpressions();
        List<OCLExpressionWithContext> modelExpressions = new OCLExpressionFromModelPicker().pickUpExpressions();

	if (oclId == null) {
            result.addAll(tcsExpressions);
            result.addAll(modelExpressions);
        } else {
	    if (oclId <= tcsExpressions.size()) {
	        result.add(tcsExpressions.get(oclId-1));
	    } else if (oclId <= tcsExpressions.size()+modelExpressions.size()) {
	        result.add(modelExpressions.get(oclId-1-tcsExpressions.size()));
	    } else {
	        throw new RuntimeException("Error: OCL expression with ID "+oclId+" not found. Possible IDs: 1.."+
	                tcsExpressions.size()+modelExpressions.size());
	    }
	}
	return result;
    }
}
