package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.OCLExpression;


import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class AllInstancesNavigationStep extends AbstractNavigationStep {
    private final OppositeEndFinder oppositeEndFinder;

    /**
     * Constructs a non-{@link NavigationStep#isAbsolute() absolute} navigation step that computes all instances of
     * <tt>targetType</tt> and all its direct and indirect subtypes, if the <tt>fromObject</tt> passed to
     * {@link #navigate(Set, TracebackCache, Notification)} conforms to the <tt>sourceType</tt>. Otherwise, an empty set is returned. The consideration of
     * the <tt>fromObject</tt> is the reason why if constructed with this constructor an object of this class is not absolute.
     * 
     * @param debugInfo
     * @param oppositeEndFinder
     *            used during partial evaluation and for metamodel queries, e.g., finding opposite role names, or finding all
     *            subclasses of a class; as well as for obtaining all instances of a type while performing an
     *            {@link AllInstancesNavigationStep}. It is handed to the {@link PathCache} object from where {@link Tracer}s can
     *            retrieve it using {@link PathCache#getOppositeEndFinder()}.
     */
    public AllInstancesNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo,
            OppositeEndFinder oppositeEndFinder) {
        super(sourceType, targetType, debugInfo);
        this.oppositeEndFinder = oppositeEndFinder;
    }

    
    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (EObject roi : InstanceScopeAnalysis.getAllPossibleContextInstances((Notifier) changeEvent.getNotifier(), getTargetType(),
                oppositeEndFinder)) {
            result.add(annotateEObject(fromObject, roi));
        }
        return result;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return "allInstances(" + getTargetType().getName() + ")";
    }

    /**
     * Always returns <code>false</code>. See
     * {@link #AllInstancesNavigationStep(EClass, EClass, OCLExpression, OppositeEndFinder)}
     */
    @Override
    public boolean isAbsolute() {
        return false;
    }
}
