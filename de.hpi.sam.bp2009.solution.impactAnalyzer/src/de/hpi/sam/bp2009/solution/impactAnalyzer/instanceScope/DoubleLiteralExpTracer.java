package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.ocl.ecore.IntegerLiteralExp;

public class DoubleLiteralExpTracer extends AbstractTracer<IntegerLiteralExp> {
    public DoubleLiteralExpTracer(IntegerLiteralExp expression, String[] tuplePartNames) {
	super(expression, tuplePartNames);
    }
}
