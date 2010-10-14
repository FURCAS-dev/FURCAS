package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Performs a trivial "identity" navigation, returning the <tt>fromObject</tt> again. This is useful when only the type
 * checking that is performed by {@link AbstractNavigationStep#navigate(Set, TracebackCache, Notification)} shall be
 * employed, such as for an <tt>oclAsType</tt> method call.<p>
 * 
 * When the source and target type have no common elements in the reflexive subclass inheritance trees,
 * this means that the step will always return an empty set. This property is analyzed during the construction
 * of this step object and cached in the {@link #alwaysEmpty} field. If <tt>true</tt>, this makes this
 * step {@link #isAbsolute() absolute}, and {@link #isAlwaysEmpty()} will return <tt>true</tt>.
 * 
 */
public class IdentityNavigationStep extends AbstractNavigationStep {
	public IdentityNavigationStep(EClass sourceType, EClass targetType, OCLExpression oclExpression) {
		super(sourceType, targetType, oclExpression);
		if (!AbstractNavigationStep.haveIntersectingSubclassTree(sourceType, targetType)) {
			setAlwaysEmpty();
		}
	}

	@Override
	protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
		Set<AnnotatedEObject> result = new LinkedHashSet<AnnotatedEObject>(1);
		result.add(fromObject);
		return result;
	}

	@Override
	public boolean isAbsolute() {
		return isAlwaysEmpty();
	}

	@Override
	public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
		return "this";
	}
}
