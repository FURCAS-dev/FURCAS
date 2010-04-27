package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.util.AnnotatedEObject;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

	public RefImmediateCompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
		super(sourceType, targetType, debugInfo);
	}

	@Override
	protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
		Set<AnnotatedEObject> result = Collections.singleton(new AnnotatedEObject(
		        fromObject.eContainer(), 
		        getDebugInfo().toString(), 
		        fromObject.getTupleIdentifierStack()));
		return result;
	}
}
