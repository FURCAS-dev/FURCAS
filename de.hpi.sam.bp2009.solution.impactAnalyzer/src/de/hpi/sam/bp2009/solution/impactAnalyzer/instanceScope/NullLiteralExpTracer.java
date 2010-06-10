package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.ocl.ecore.NullLiteralExp;

public class NullLiteralExpTracer extends AbstractTracer<NullLiteralExp> {
	public NullLiteralExpTracer(NullLiteralExp expression, String[] tuplePartNames) {
		super(expression, tuplePartNames);
	}
}
