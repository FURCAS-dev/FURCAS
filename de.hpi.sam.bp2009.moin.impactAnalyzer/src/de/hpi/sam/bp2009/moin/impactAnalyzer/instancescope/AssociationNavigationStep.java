package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.emf.query2.EcoreHelper;

import de.hpi.sam.bp2009.moin.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;
import org.eclipse.emf.query2.QueryContext;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final EReference toEnd;

    public AssociationNavigationStep(EClass sourceType, EClass targetType, EReference toEnd, OCLExpression<EClassifier> debugInfo) {
        super(sourceType, targetType, debugInfo);
        this.toEnd = toEnd;
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        //check if we can satisfy the request from the cache
        List<Object> cacheLookup = new BasicEList<Object>();
        cacheLookup.add(this);
        cacheLookup.add(fromObject);
        if (cache.containsKey(cacheLookup))
            return cache.get(cacheLookup);

        //cache lookup was unsuccessful -> perform the navigation
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        if (toEnd.eContainer() instanceof EClass){
            //we have a "normal" EReference
            Object ref = fromObject.eGet(toEnd);
            if (toEnd.isMany()){
                //eGet(toEnd) will return a list of EObjects
                if (ref instanceof EList<?>){
                    Iterator<?> it = ((EList<?>) ref).iterator();
                    while (it.hasNext()){
                        Object elem = it.next();
                        if (elem instanceof EObject){
                            result.add(new AnnotatedEObject((EObject)elem, "", fromObject.getTupleIdentifierStack()));
                        }
                    }
                }
            }else{
                //eGet(toEnd) will return an EObject
                result.add(new AnnotatedEObject((EObject)ref, "", fromObject.getTupleIdentifierStack()));
            }
        }else{
            //we have a "hidden" EReference (-> contained in another EReference)
            ProjectBasedScopeProvider scopeProvider = new ProjectBasedScopeProviderImpl(fromObject);
            QueryContext scope = scopeProvider.getBackwardScopeAsQueryContext();
            Collection<EObject> resultSet = new HashSet<EObject>();
            EcoreHelper.getInstance().reverseNavigate(fromObject.getAnnotatedObject(), toEnd, scope, resultSet);
            Iterator<EObject> it = resultSet.iterator();
            while (it.hasNext()){
                result.add(new AnnotatedEObject(it.next(), "", fromObject.getTupleIdentifierStack()));
            }
        }
        //update the cache
        cache.put(cacheLookup, result);
        return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return toEnd.getName();
    }
}
