package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.EnumLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class EnumLiteralExpTracer extends AbstractTracer<EnumLiteralExp> {
    public EnumLiteralExpTracer(EnumLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
	super(expression, tuplePartNames, oclFactory);
    }

}
