package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.TypeExp;

public class TypeExpTracer extends AbstractTracer<TypeExp> {
	public TypeExpTracer(TypeExp expression, Stack<String> tuplePartNames) {
		super(expression, tuplePartNames);
	}

}
