package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.TypeExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class TypeExpTracer extends AbstractTracer<TypeExp> {
	public TypeExpTracer(TypeExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}

}
