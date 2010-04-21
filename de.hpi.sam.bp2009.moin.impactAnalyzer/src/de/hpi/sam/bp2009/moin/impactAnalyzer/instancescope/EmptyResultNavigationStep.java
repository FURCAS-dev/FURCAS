package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.OCLExpression;

public class EmptyResultNavigationStep extends AbsoluteNavigationStep {

	public EmptyResultNavigationStep(OCLExpression<EClassifier> debugInfo) {
		super(null, debugInfo);
		setAlwaysEmpty();
	}

	@Override
	protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
		return "<empty>";
	}

	@Override
	protected Set<EObject> navigate(EObject fromObject,
			Map<Map<NavigationStep, EObject>, Set<EObject>> cache) {
		return Collections.emptySet();
	}
}
