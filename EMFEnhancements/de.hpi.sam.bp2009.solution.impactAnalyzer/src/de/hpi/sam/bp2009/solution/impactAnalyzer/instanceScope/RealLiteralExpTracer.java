package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.RealLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class RealLiteralExpTracer extends AbstractTracer<RealLiteralExp> {
	public RealLiteralExpTracer(RealLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}

}
