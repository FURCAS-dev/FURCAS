package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

	public RefImmediateCompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
		super(sourceType, targetType, debugInfo);
	}

	@Override
	protected Set<EObject> navigate(EObject fromObject, Map<List<Object>, Set<EObject>> cache, Stack<EStructuralFeature> tuplePartIdentifierStack) {
		Set<EObject> result = Collections.singleton(fromObject.eContainer());
		return result;
	}

}
