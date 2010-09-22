package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.InvalidLiteralExp;

public class InvalidlLiteralExpTracer extends AbstractTracer<InvalidLiteralExp> {
	public InvalidlLiteralExpTracer(InvalidLiteralExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}
}
