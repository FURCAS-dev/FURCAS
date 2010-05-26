package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

public class OppositePropertyNavigationStep extends AbstractNavigationStep {

    private final EStructuralFeature property;

    public OppositePropertyNavigationStep(EClass sourceType, EClass targetType, EStructuralFeature property,
            OCLExpression debugInfo2) {
        super(sourceType, targetType, debugInfo2);
        this.property = property;
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        QueryContext scope = new ProjectBasedScopeProviderImpl(fromObject).getBackwardScopeAsQueryContext();
        Collection<EObject> result = new HashSet<EObject>();
        Set<AnnotatedEObject> returnValue = new HashSet<AnnotatedEObject>();
        if (property instanceof EReference) {
            EcoreHelper.getInstance().reverseNavigate(fromObject.getAnnotatedObject(), (EReference) property, scope, result);
        }
        for (EObject o : result) {
            returnValue.add(new AnnotatedEObject(o));
        }
        return returnValue;
    }
}
