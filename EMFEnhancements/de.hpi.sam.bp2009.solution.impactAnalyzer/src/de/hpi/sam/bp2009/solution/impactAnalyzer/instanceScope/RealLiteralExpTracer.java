package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.RealLiteralExp;

public class RealLiteralExpTracer extends AbstractTracer<RealLiteralExp> {
	public RealLiteralExpTracer(RealLiteralExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}

}
