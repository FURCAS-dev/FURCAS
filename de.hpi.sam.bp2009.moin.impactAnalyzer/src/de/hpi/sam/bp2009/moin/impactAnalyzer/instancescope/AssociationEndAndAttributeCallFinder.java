package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

/**
 * A tree walker that finds and remembers all expressions of type {@link AttributeCallExp} and
 * {@link AssociationEndCallExp}. Those are the ones for which later we must be able to find them quickly based on the
 * association/attribute and model element for which a corresponding change event was sent.<p>
 * 
 * TODO Turn this into a cache where a client can free the results of walking a top-level expression after using it
 * 
 * @author Axel Uhl D043530
 * 
 */
public class AssociationEndAndAttributeCallFinder extends AbstractVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
    private final Map<EAttribute, Set<PropertyCallExp>> attributeCallExpressions = new HashMap<EAttribute, Set<PropertyCallExp>>();
    private final Map<EReference, Set<NavigationCallExp>> associationEndCallExpressions = new HashMap<EReference, Set<NavigationCallExp>>();
    private final Set<OCLExpression<EClassifier>> visitedExpressions = new HashSet<OCLExpression<EClassifier>>();
    private final Map<EClassifier, Set<OperationCallExp>> allInstancesCalls = new HashMap<EClassifier, Set<OperationCallExp>>();
    private final ClassScopeAnalyzer classScopeAnalyzer;

    public AssociationEndAndAttributeCallFinder(ClassScopeAnalyzer classScopeAnalyzer) {
        super();
        this.classScopeAnalyzer = classScopeAnalyzer;
    }

    @Override
    protected EPackage handlePropertyCallExp(
            org.eclipse.ocl.expressions.PropertyCallExp<EClassifier, EStructuralFeature> callExp, EPackage sourceResult,
            List<EPackage> qualifierResults) {
        // TODO Auto-generated method stub
        return super.handlePropertyCallExp(callExp, sourceResult, qualifierResults);
    }
    
    @Override
    protected void upAttributeCallExp(PropertyCallExp ace) {
        Set<PropertyCallExp> set = attributeCallExpressions.get(ace.getReferredProperty());
        if (set==null) {
            set = new HashSet<PropertyCallExp>();
            attributeCallExpressions.put((EAttribute) ace.getReferredProperty(), set);
        }
        set.add(ace);
    }

    @Override
    protected void upAssociationEndCallExp(NavigationCallExp ace) {
        Set<NavigationCallExp> set = associationEndCallExpressions.get((EReference) ace.getNavigationSource());
        if (set==null) {
            set = new HashSet<NavigationCallExp>();
            associationEndCallExpressions.put((EReference) ace.getNavigationSource(), set);
        }
        set.add(ace);
    }
    
    @Override
    /**
     * If an operation is defined by an OCL body, walk that body too and collect all attribute
     * and association end calls from it recursively.
     */
    protected void upOperationCallExp(OperationCallExp oce) {
        EOperation referredOperation = ((OperationCallExpImpl) oce).getReferredOperation();
        OCLExpression<EClassifier> bodyExpr = classScopeAnalyzer.getOperationBody(referredOperation);
        if (bodyExpr != null) {
            walk(bodyExpr);
        } else if (referredOperation.getName().equals(PredefinedType.ALL_INSTANCES_NAME)) {
            EClassifier classifier = ((TypeExp)oce.getSource()).getReferredType();
            for (EClassifierImpl specialization : getAllSpecializationsIncludingSelf((EClassifierImpl) classifier)) {
                Set<OperationCallExp> set = allInstancesCalls.get(specialization);
                if (set == null) {
                    set = new HashSet<OperationCallExp>();
                    allInstancesCalls.put(specialization, set);
                }
                set.add(oce);
            }
        }
    }

    private Set<EClassifierImpl> getAllSpecializationsIncludingSelf(EClassifierImpl classifier) {
        Set<EClassifierImpl> result = new HashSet<EClassifierImpl>();
        if (classifier instanceof EClass){
            EClass cls = (EClass) classifier;
            for (EClassifier anotherCls : cls.getEPackage().getEClassifiers()){
                //FIXME: if the class hierarchy spans over more than one Package this won't work
                if (anotherCls instanceof EClass && cls.isSuperTypeOf((EClass) anotherCls)){
                    result.add((EClassifierImpl)anotherCls);
                }
            }
            result.add(classifier);
        } else {
            //classifier is a datatype
            result.add((EClassifierImpl)classifier);
        }
        return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<PropertyCallExp> getAttributeCallExpressions(EAttribute a) {
        Set<PropertyCallExp> result;
        Set<PropertyCallExp> lookup = attributeCallExpressions.get(a);
        if (lookup == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableSet(attributeCallExpressions.get(a));
        }
        return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<NavigationCallExp> getAssociationEndCallExpressions(EReference a) {
        Set<NavigationCallExp> result;
        Set<NavigationCallExp> lookup = associationEndCallExpressions.get(a);
        if (lookup == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableSet(associationEndCallExpressions.get(a));
        }
        return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set. Finds all occurrences of an <tt>allInstances</tt> call on a type
     * expression for the classifier <tt>c</tt> or its generalizations in the expression analyzed by this visitor.
     */
    public Set<OperationCallExp> getAllInstancesCallsFor(EClassifier c) {
        Set<OperationCallExp> result = allInstancesCalls.get(c);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }

    public void walk(OCLExpression<EClassifier> expression) {
        if (!visitedExpressions.contains(expression)) {
            visitedExpressions.add(expression);
            super.safeVisit(expression);
        }
    }
}
