package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.StringLiteralExp;

public class StringLiteralExpTracer extends AbstractTracer<StringLiteralExp> {
	public StringLiteralExpTracer(StringLiteralExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}

}
