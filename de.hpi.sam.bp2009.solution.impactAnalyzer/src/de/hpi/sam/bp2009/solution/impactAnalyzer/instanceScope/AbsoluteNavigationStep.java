package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.OCLExpression;

public abstract class AbsoluteNavigationStep extends AbstractNavigationStep {

	public AbsoluteNavigationStep(EClass targetType, OCLExpression<EClassifier> debugInfo) {
		super(null, targetType, debugInfo);
	}

	@Override
	public boolean isAbsolute() {
		return true;
	}

}
