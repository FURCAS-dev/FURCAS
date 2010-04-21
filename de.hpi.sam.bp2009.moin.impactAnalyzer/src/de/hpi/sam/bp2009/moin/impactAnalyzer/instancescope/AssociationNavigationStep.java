package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.expressions.OCLExpression;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final EReference toEnd;

    public AssociationNavigationStep(EClass sourceType, EClass targetType, EReference toEnd, OCLExpression<EClassifier> debugInfo) {
	super(sourceType, targetType, debugInfo);
	this.toEnd = toEnd;
    }

    @Override
    protected Set<EObject> navigate(EObject fromObject, Map<List<Object>, Set<EObject>> cache, Stack<EStructuralFeature> tuplePartIdentifierStack) {
	Set<EObject> result;
	if (toEnd.isMany()){
	    //eGet(toEnd) will return a list of EObjects
	    Object ref = fromObject.eGet(toEnd);
	    if (ref instanceof EList<?>){
	        Iterator<?> it = ((EList<?>) ref).iterator();
	        while (it.hasNext()){
	            Object elem = it.next();
	            if (elem instanceof EObject){
	                
	            }
	        }
	    }
	}else{
	    
	}

//	Association assoc = (Association) ((AssociationEndInternal) toEnd).getContainer();
//	RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation(assoc);
//	EList<EObject> objectOrCollection = (EList<EObject>) refAssoc.refQuery(((AssociationEndInternal) toEnd).otherEnd(), fromObject);
//	result = new LinkedHashSet<EObject>(objectOrCollection.size());
//	for (Iterator<EObject> i = objectOrCollection.iterator(); i.hasNext();) {
//	    result.add((EObject) i.next());
//	}
	return result;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return toEnd.getName();
    }
}
