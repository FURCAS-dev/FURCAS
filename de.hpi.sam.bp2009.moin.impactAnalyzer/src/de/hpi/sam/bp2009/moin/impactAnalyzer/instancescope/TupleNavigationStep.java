package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.util.AnnotatedEObject;

public class TupleNavigationStep extends AbstractNavigationStep {

    public TupleNavigationStep(EClass sourceType, EClass targetType, OCLExpression<EClassifier> debugInfo) {
        super(sourceType, targetType, debugInfo);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        // TODO Auto-generated method stub
        return null;
    }
}
