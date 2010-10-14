package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.IntegerLiteralExp;

public class IntegerLiteralExpTracer extends AbstractTracer<IntegerLiteralExp> {
	public IntegerLiteralExpTracer(IntegerLiteralExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}

}
