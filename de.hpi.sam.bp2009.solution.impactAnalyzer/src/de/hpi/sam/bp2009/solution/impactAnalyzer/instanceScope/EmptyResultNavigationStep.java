package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class EmptyResultNavigationStep extends AbsoluteNavigationStep {

	public EmptyResultNavigationStep(OCLExpression debugInfo) {
		super(null, debugInfo);
		setAlwaysEmpty();
	}

	@Override
	public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
		return "<empty>";
	}

	@Override
	protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject,
			Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
		return Collections.emptySet();
	}
}
