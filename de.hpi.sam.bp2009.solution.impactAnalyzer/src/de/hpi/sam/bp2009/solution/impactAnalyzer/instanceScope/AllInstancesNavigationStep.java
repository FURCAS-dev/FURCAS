package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.ocl.oppositefinder.query2.QueryContextProvider;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class AllInstancesNavigationStep extends AbstractNavigationStep {
	private final boolean absolute;

	/**
	 * Constructs an {@link NavigationStep#isAbsolute() absolute} navigation step that
	 * without consideration of the <tt>fromObject</tt>'s type always computes all
	 * instances of the {@link NavigationStep#getTargetType() target type} and all
	 * its direct and indirect subtypes.
	 * @param debugInfo
	 */
	public AllInstancesNavigationStep(EClass targetType, OCLExpression debugInfo) {
		super(null, targetType, debugInfo);
		absolute = true;
	}

	/**
	 * Constructs a non-{@link NavigationStep#isAbsolute() absolute} navigation step that
	 * computes all instances of <tt>targetType</tt> and all its direct and indirect subtypes,
	 * if the <tt>fromObject</tt> passed to {@link #navigate(Set, Map)}
	 * conforms to the <tt>sourceType</tt>. Otherwise, an empty set is returned. The
	 * consideration of the <tt>fromObject</tt> is the reason why if constructed with this
	 * constructor an object of this class is not absolute.
	 * @param debugInfo
	 */
	public AllInstancesNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
		super(sourceType, targetType, debugInfo);
		absolute = false;
	}

	@Override
	public boolean isAbsolute() {
		return absolute;
	}

	@Override
	protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
	        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
	        // FIXME not only search in one resource but use a QueryScopeProvider
	        QueryContextProvider queryContextProvider;
	        for (EObject roi : InstanceScopeAnalysis.getAllPossibleContextInstances(fromObject.eResource(), getTargetType())) {
	            result.add(annotateEObject(fromObject, roi));
	        }
	        return result;
	}

	@Override
	public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
		return "allInstances("+getTargetType().getName()+")";
	}
}
