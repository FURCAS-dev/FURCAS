package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class OppositePropertyNavigationStep extends AbstractNavigationStep {

    private final EStructuralFeature property;
    private final OppositeEndFinder oppositeEndFinder;

    public OppositePropertyNavigationStep(EClass sourceType, EClass targetType, EStructuralFeature property,
            OCLExpression debugInfo2, OppositeEndFinder oppositeEndFinder) {
        super(sourceType, targetType, debugInfo2);
        this.property = property;
	this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
        Collection<EObject> result = new HashSet<EObject>();
        Set<AnnotatedEObject> returnValue = new HashSet<AnnotatedEObject>();
        if (property instanceof EReference) {
            //EcoreHelper.getInstance().reverseNavigate(fromObject.getAnnotatedObject(), (EReference) property, scope, result);
            Object navigationResult = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(property, fromObject.getAnnotatedObject());
            if (navigationResult instanceof Collection<?>) {
                @SuppressWarnings("unchecked")
                Collection<? extends EObject> eObjectCollectionNavigationResult = (Collection<? extends EObject>) navigationResult;
                result.addAll(eObjectCollectionNavigationResult);
            } else {
                if (navigationResult != null) {
                    result.add((EObject) navigationResult);
                }
            }
        }
        for (EObject o : result) {
            returnValue.add(annotateEObject(fromObject, o));
        }
        return returnValue;
    }
}
