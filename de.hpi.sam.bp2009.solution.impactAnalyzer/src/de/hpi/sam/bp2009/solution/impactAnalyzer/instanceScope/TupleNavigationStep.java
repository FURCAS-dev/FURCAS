package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class TupleNavigationStep extends AbstractNavigationStep {

    private String tupleLiteralPartName = "";

    public TupleNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo, String referredAttributeName) {
        super(sourceType, targetType, debugInfo);
        this.tupleLiteralPartName  = referredAttributeName;        
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        
        HashSet<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        fromObject.pushTupleIdentifier(tupleLiteralPartName);
        result.add(fromObject);
        return result;
    }
}
