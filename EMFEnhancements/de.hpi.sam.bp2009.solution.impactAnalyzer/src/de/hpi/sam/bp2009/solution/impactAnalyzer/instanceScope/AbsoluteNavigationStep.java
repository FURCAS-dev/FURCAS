package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;


public abstract class AbsoluteNavigationStep extends AbstractNavigationStep {

	public AbsoluteNavigationStep(EClass targetType, OCLExpression debugInfo) {
		super(null, targetType, debugInfo);
	}

	@Override
	public boolean isAbsolute() {
		return true;
	}

}
