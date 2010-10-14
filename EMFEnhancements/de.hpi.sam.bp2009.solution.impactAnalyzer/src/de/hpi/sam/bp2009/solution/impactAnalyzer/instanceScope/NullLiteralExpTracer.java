package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.NullLiteralExp;

public class NullLiteralExpTracer extends AbstractTracer<NullLiteralExp> {
	public NullLiteralExpTracer(NullLiteralExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}
}
