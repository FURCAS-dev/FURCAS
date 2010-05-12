package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.Visitable;

class ResourceChanger extends AbstractVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
    private static final String OCL_PSEUDO_RESOURCE_URI = "ocl:///oclenv.ecore";
    private HashSet<EObject> set;
    public ResourceChanger() {
        this.set = new HashSet<EObject>();
    }
    /**
     * @return the set of all object which have no resource or are in the ocl pseudo resource
     */
    public HashSet<EObject> getSet() {
        return set;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#visitVariableExp(org.eclipse.ocl.expressions.VariableExp)
     */
    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        Variable<EClassifier, EParameter> var = handle(v.getReferredVariable());
        if(var!=null){
            set.add(var);
            v.setReferredVariable(var);
        }
        v.getReferredVariable().accept(this);
        return super.visitVariableExp(v);

    }
    /**
     * Checks whether the given object has a resource or is in the pseudo resource
     * @param <T> the typ of the given object
     * @param typ the given object
     * @return null, if the object is in a valid resource, a copy of the object otherwise @see {@link EcoreUtil#copy(EObject)}
     */
    private <T extends EObject> T handle( T typ) {
        if(typ!=null && (typ.eResource()==null || typ.eResource().getURI()!=null)){
            /*
             * get URI if any there
             */
            URI uri= typ.eResource()==null?null:typ.eResource().getURI();
            if( uri==null ||uri.equals(URI.createURI(OCL_PSEUDO_RESOURCE_URI))){
                return EcoreUtil.copy(typ);
            }
        }
        return null;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleAssociationClassCallExp(org.eclipse.ocl.expressions.AssociationClassCallExp, java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleAssociationClassCallExp(
            AssociationClassCallExp<EClassifier, EStructuralFeature> callExp,
            EPackage sourceResult, List<EPackage> qualifierResults) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);

            callExp.setType(newType);
        }
        return super.handleAssociationClassCallExp(callExp, sourceResult,
                qualifierResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionItem(org.eclipse.ocl.expressions.CollectionItem, java.lang.Object)
     */
    @Override
    protected EPackage handleCollectionItem(
            CollectionItem<EClassifier> item, EPackage itemResult) {
        EClassifier newType = handle(item.getType());
        if(newType!=null){
            set.add(newType);

            item.setType(newType);
        }
        return super.handleCollectionItem(item, itemResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionLiteralExp(org.eclipse.ocl.expressions.CollectionLiteralExp, java.util.List)
     */
    @Override
    protected EPackage handleCollectionLiteralExp(
            CollectionLiteralExp<EClassifier> literalExp,
            List<EPackage> partResults) {
        EClassifier newType = handle(literalExp.getType());
        if(newType!=null){
            set.add(newType);

            literalExp.setType(newType);
        }
        return super.handleCollectionLiteralExp(literalExp, partResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionRange(org.eclipse.ocl.expressions.CollectionRange, java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleCollectionRange(
            CollectionRange<EClassifier> range, EPackage firstResult,
            EPackage lastResult) {
        EClassifier newType = handle(range.getType());
        if(newType!=null){
            set.add(newType);

            range.setType(newType);
        }
        return super.handleCollectionRange(range, firstResult, lastResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIfExp(org.eclipse.ocl.expressions.IfExp, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleIfExp(IfExp<EClassifier> ifExp,
            EPackage conditionResult, EPackage thenResult,
            EPackage elseResult) {
        EClassifier newType = handle(ifExp.getType());
        if(newType!=null){
            set.add(newType);

            ifExp.setType(newType);
        }
        return super.handleIfExp(ifExp, conditionResult, thenResult, elseResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIterateExp(org.eclipse.ocl.expressions.IterateExp, java.lang.Object, java.util.List, java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleIterateExp(
            IterateExp<EClassifier, EParameter> callExp,
            EPackage sourceResult, List<EPackage> variableResults,
            EPackage resultResult, EPackage bodyResult) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);

            callExp.setType(newType);
        }
        return super.handleIterateExp(callExp, sourceResult, variableResults,
                resultResult, bodyResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIteratorExp(org.eclipse.ocl.expressions.IteratorExp, java.lang.Object, java.util.List, java.lang.Object)
     */
    @Override
    protected EPackage handleIteratorExp(
            IteratorExp<EClassifier, EParameter> callExp,
            EPackage sourceResult, List<EPackage> variableResults,
            EPackage bodyResult) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);

            callExp.setType(newType);
        }
        return super.handleIteratorExp(callExp, sourceResult, variableResults,
                bodyResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleLetExp(org.eclipse.ocl.expressions.LetExp, java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleLetExp(LetExp<EClassifier, EParameter> letExp,
            EPackage variableResult, EPackage inResult) {
        EClassifier newType = handle(letExp.getType());
        if(newType!=null){
            set.add(newType);

            letExp.setType(newType);
        }
        return super.handleLetExp(letExp, variableResult, inResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleMessageExp(org.eclipse.ocl.expressions.MessageExp, java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleMessageExp(
            MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp,
            EPackage targetResult, List<EPackage> argumentResults) {
        EClassifier newType = handle(messageExp.getType());
        if(newType!=null){
            set.add(newType);

            messageExp.setType(newType);
        }
        return super.handleMessageExp(messageExp, targetResult, argumentResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp, java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleOperationCallExp(
            OperationCallExp<EClassifier, EOperation> callExp,
            EPackage sourceResult, List<EPackage> argumentResults) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);

            callExp.setType(newType);
        }
        return super.handleOperationCallExp(callExp, sourceResult, argumentResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleOppositePropertyCallExp(org.eclipse.ocl.expressions.OppositePropertyCallExp, java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleOppositePropertyCallExp(
            OppositePropertyCallExp<EClassifier, EStructuralFeature> callExp,
            EPackage sourceResult, List<EPackage> qualifierResults) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);

            callExp.setType(newType);
        }
        return super.handleOppositePropertyCallExp(callExp, sourceResult,
                qualifierResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handlePropertyCallExp(org.eclipse.ocl.expressions.PropertyCallExp, java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handlePropertyCallExp(
            PropertyCallExp<EClassifier, EStructuralFeature> callExp,
            EPackage sourceResult, List<EPackage> qualifierResults) {
        EClassifier newType = handle(callExp.getType());
        if(newType!=null){
            set.add(newType);
            callExp.setType(newType);
        }
        return super.handlePropertyCallExp(callExp, sourceResult, qualifierResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralExp(org.eclipse.ocl.expressions.TupleLiteralExp, java.util.List)
     */
    @Override
    protected EPackage handleTupleLiteralExp(
            TupleLiteralExp<EClassifier, EStructuralFeature> literalExp,
            List<EPackage> partResults) {
        EClassifier newType = handle(literalExp.getType());
        if(newType!=null){
            set.add(newType);

            literalExp.setType(newType);
        }
        return super.handleTupleLiteralExp(literalExp, partResults);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralPart(org.eclipse.ocl.expressions.TupleLiteralPart, java.lang.Object)
     */
    @Override
    protected EPackage handleTupleLiteralPart(
            TupleLiteralPart<EClassifier, EStructuralFeature> part,
            EPackage valueResult) {
        EClassifier newType = handle(part.getType());
        if(newType!=null){
            set.add(newType);

            part.setType(newType);
        }
        return super.handleTupleLiteralPart(part, valueResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleVariable(org.eclipse.ocl.expressions.Variable, java.lang.Object)
     */
    @Override
    protected EPackage handleVariable(
            Variable<EClassifier, EParameter> variable, EPackage initResult) {
        EClassifier newType = handle(variable.getType());
        if(newType!=null){
            set.add(newType);

            variable.setType(newType);
        }
        /*
         * varaible
         */
        return super.handleVariable(variable, initResult);

    }
    /* (non-Javadoc)
     * @see org.eclipse.ocl.utilities.AbstractVisitor#safeVisit(org.eclipse.ocl.utilities.Visitable)
     */
    @Override
    protected EPackage safeVisit(Visitable v) {
        return super.safeVisit(v);
    }

}