package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

	public RefImmediateCompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
		super(sourceType, targetType, debugInfo);
	}

	@Override
	protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
		Set<AnnotatedEObject> result = Collections.singleton(annotateEObject(fromObject, 
		        fromObject.eContainer()));
		return result;
	}
}
