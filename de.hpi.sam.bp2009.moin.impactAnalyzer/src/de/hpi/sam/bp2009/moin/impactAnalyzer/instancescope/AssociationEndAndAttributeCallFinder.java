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
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

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
    private final Map<EReference, Set<PropertyCallExp>> associationEndCallExpressions = new HashMap<EReference, Set<PropertyCallExp>>();
    private final Set<OCLExpression<EClassifier>> visitedExpressions = new HashSet<OCLExpression<EClassifier>>();
    private final Map<EClassifier, Set<OperationCallExp>> allInstancesCalls = new HashMap<EClassifier, Set<OperationCallExp>>();

    public AssociationEndAndAttributeCallFinder() {
        super();
    }

    @Override
    protected EPackage handlePropertyCallExp(
            org.eclipse.ocl.expressions.PropertyCallExp<EClassifier, EStructuralFeature> callExp,
            EPackage sourceResult,
            List<EPackage> qualifierResults) {
        // check whether the referred property is an attribute or reference
        
        if (callExp.getReferredProperty() instanceof EAttribute){
            EAttribute refAttr = (EAttribute)callExp.getReferredProperty();
            Set<PropertyCallExp> set = attributeCallExpressions.get(refAttr);
            if (set==null) {
                set = new HashSet<PropertyCallExp>();
                attributeCallExpressions.put(refAttr, set);
            }
            set.add((PropertyCallExp) callExp);
            
        } else if (callExp.getReferredProperty() instanceof EReference){
            EReference refRef = (EReference) callExp.getNavigationSource();
            Set<PropertyCallExp> set = associationEndCallExpressions.get(refRef);
            if (set==null) {
                set = new HashSet<PropertyCallExp>();
                associationEndCallExpressions.put(refRef, set);
            }
            set.add((PropertyCallExp) callExp);
        } else {
            throw new RuntimeException("Unhandled subclass of EStructuralFeature. Revisit AssociationEndAndAttributeCallFinder to implement specific behaviour.");
        }
        return result;
    }
    
    @Override
    protected EPackage handleOperationCallExp(
            org.eclipse.ocl.expressions.OperationCallExp<EClassifier, EOperation> callExp,
            EPackage sourceResult,
            List<EPackage> argumentResults) {
        
        EOperation referredOperation = ((OperationCallExp) callExp).getReferredOperation();
        OCLExpression<EClassifier> bodyExpr = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser().getExpressionFromAnnotationsOf(referredOperation, "body");
        if (bodyExpr != null) {
            walk(bodyExpr);
        } else if (referredOperation.getName().equals(PredefinedType.ALL_INSTANCES_NAME)) {
            EClassifier classifier = ((TypeExp)callExp.getSource()).getReferredType();
            for (EClassifier specialization : getAllSpecializationsIncludingSelf(classifier)) {
                Set<OperationCallExp> set = allInstancesCalls.get(specialization);
                if (set == null) {
                    set = new HashSet<OperationCallExp>();
                    allInstancesCalls.put(specialization, set);
                }
                set.add((OperationCallExp) callExp);
            }
        }
        return result;
    }

    
    /**
     * If an operation is defined by an OCL body, walk that body too and collect all attribute
     * and association end calls from it recursively.
     */
    protected void upOperationCallExp(OperationCallExp oce) {
        
    }

    private Set<EClassifier> getAllSpecializationsIncludingSelf(EClassifier classifier) {
        Set<EClassifier> result = new HashSet<EClassifier>();
        if (classifier instanceof EClass){
            result.addAll(EcoreHelper.getInstance().getAllSubclasses((EClass)classifier));
            result.add((EClass)classifier);            
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
    public Set<PropertyCallExp> getAssociationEndCallExpressions(EReference a) {
        Set<PropertyCallExp> result;
        Set<PropertyCallExp> lookup = associationEndCallExpressions.get(a);
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
            if (super.safeVisit(expression) != null)
                visitedExpressions.add(expression);
            else
                throw new RuntimeException("The given OCLExpression is not visitable: " + expression);
        }
    }
}
