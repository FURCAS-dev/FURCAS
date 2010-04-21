package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

	public RefImmediateCompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
		super(sourceType, targetType, debugInfo);
	}

	@Override
	protected Set<EObject> navigate(EObject fromObject, Map<Map<NavigationStep, EObject>, Set<EObject>> cache) {
		Set<EObject> result = Collections.singleton(fromObject.eContainer());
		return result;
	}

}
