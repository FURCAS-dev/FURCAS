package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.BooleanLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class BooleanLiteralExpTracer extends AbstractTracer<BooleanLiteralExp> {
	public BooleanLiteralExpTracer(BooleanLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}

}
