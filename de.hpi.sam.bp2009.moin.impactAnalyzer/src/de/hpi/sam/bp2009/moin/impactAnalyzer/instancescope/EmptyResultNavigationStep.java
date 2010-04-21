package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
			Map<List<Object>, Set<EObject>> cache, Stack<EStructuralFeature> tuplePartIdentifierStack) {
		return Collections.emptySet();
	}
}
