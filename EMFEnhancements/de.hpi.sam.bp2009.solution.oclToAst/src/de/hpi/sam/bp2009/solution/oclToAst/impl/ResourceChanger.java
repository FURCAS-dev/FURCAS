package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.CallOperationAction;
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
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.Visitable;

import com.sap.emf.ocl.hiddenopposites.AbstractVisitorWithHiddenOpposites;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

/**
 * This class is used to visit a OclExpression and extract all referred Object, which has no resource or are located in the OclEnviroment pseudo resource
 * after visiting an expression, all found object are returned by {@link ResourceChanger#getSet()}
 * @author Philipp
 *
 */
class ResourceChanger
        extends
        AbstractVisitorWithHiddenOpposites<EPackage> {
    private static final String OCL_PSEUDO_RESOURCE_URI = "ocl:///oclenv.ecore";
    private Map<EObject, EObject> orgToCopy;

    public ResourceChanger() {
        orgToCopy = new HashMap<EObject, EObject>();
    }

    /**
     * @return the set of all object which have no resource or are in the ocl pseudo resource
     */
    public Collection<EObject> getSet() {
        return orgToCopy.values();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#visitVariableExp(org.eclipse.ocl.expressions.VariableExp)
     */
    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        Variable<EClassifier, EParameter> var = handle(v.getReferredVariable());
        if (var != null) {
            orgToCopy.put(v.getReferredVariable(), var);
            v.setReferredVariable(var);
        }
        EClassifier newType = handle(v.getType());
        if (newType != null) {
            orgToCopy.put(v.getType(), newType);
            v.setType(newType);
        }
        v.getReferredVariable().accept(this);
        return super.visitVariableExp(v);

    }

    @Override
    public EPackage visitTypeExp(TypeExp<EClassifier> t) {
        EClassifier newType = handle(t.getType());
        if (newType != null) {
            orgToCopy.put(t.getType(), newType);
            t.setType(newType);
        }
        return super.visitTypeExp(t);
    }

    /**
     * Checks whether the given object has a resource or is in the pseudo resource
     * 
     * @param <T>
     *            the typ of the given object
     * @param typ
     *            the given object
     * @return null, if the object is in a valid resource, a copy of the object otherwise @see {@link EcoreUtil#copy(EObject)}
     */
    @SuppressWarnings("unchecked")
    private <T extends EObject> T handle(T typ) {
        if(typ!=null && orgToCopy.containsKey(typ)){
            return (T) orgToCopy.get(typ);
        }
        if (typ != null && (typ.eResource() == null || typ.eResource().getURI() != null)) {
            /*
             * get URI if any there
             */
            URI uri = typ.eResource() == null ? null : typ.eResource().getURI();

            if (uri == null || uri.equals(URI.createURI(OCL_PSEUDO_RESOURCE_URI))) {

                return EcoreUtil.copy(typ);
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ocl.utilities.AbstractVisitor#handleAssociationClassCallExp(org.eclipse.ocl.expressions.AssociationClassCallExp
     * , java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> callExp,
            EPackage sourceResult, List<EPackage> qualifierResults) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);
            callExp.setType(newType);
        }
        return super.handleAssociationClassCallExp(callExp, sourceResult, qualifierResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionItem(org.eclipse.ocl.expressions.CollectionItem,
     * java.lang.Object)
     */
    @Override
    protected EPackage handleCollectionItem(CollectionItem<EClassifier> item, EPackage itemResult) {
        EClassifier newType = handle(item.getType());
        if (newType != null) {
            orgToCopy.put(item.getType(), newType);

            item.setType(newType);
        }
        return super.handleCollectionItem(item, itemResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionLiteralExp(org.eclipse.ocl.expressions.CollectionLiteralExp,
     * java.util.List)
     */
    @Override
    protected EPackage handleCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp, List<EPackage> partResults) {
        EClassifier newType = handle(literalExp.getType());
        if (newType != null) {
            orgToCopy.put(literalExp.getType(), newType);
            literalExp.setType(newType);
        }
        return super.handleCollectionLiteralExp(literalExp, partResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionRange(org.eclipse.ocl.expressions.CollectionRange,
     * java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleCollectionRange(CollectionRange<EClassifier> range, EPackage firstResult, EPackage lastResult) {
        EClassifier newType = handle(range.getType());
        if (newType != null) {
            orgToCopy.put(range.getType(), newType);
            range.setType(newType);
        }
        return super.handleCollectionRange(range, firstResult, lastResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIfExp(org.eclipse.ocl.expressions.IfExp, java.lang.Object,
     * java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleIfExp(IfExp<EClassifier> ifExp, EPackage conditionResult, EPackage thenResult, EPackage elseResult) {
        EClassifier newType = handle(ifExp.getType());
        if (newType != null) {
            orgToCopy.put(ifExp.getType(), newType);
            ifExp.setType(newType);
        }
        return super.handleIfExp(ifExp, conditionResult, thenResult, elseResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIterateExp(org.eclipse.ocl.expressions.IterateExp, java.lang.Object,
     * java.util.List, java.lang.Object, java.lang.Object)
     */
    @Override
    protected EPackage handleIterateExp(IterateExp<EClassifier, EParameter> callExp, EPackage sourceResult,
            List<EPackage> variableResults, EPackage resultResult, EPackage bodyResult) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);

            callExp.setType(newType);
        }
        return super.handleIterateExp(callExp, sourceResult, variableResults, resultResult, bodyResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIteratorExp(org.eclipse.ocl.expressions.IteratorExp, java.lang.Object,
     * java.util.List, java.lang.Object)
     */
    @Override
    protected EPackage handleIteratorExp(IteratorExp<EClassifier, EParameter> callExp, EPackage sourceResult,
            List<EPackage> variableResults, EPackage bodyResult) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);
            callExp.setType(newType);
        }
        return super.handleIteratorExp(callExp, sourceResult, variableResults, bodyResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleLetExp(org.eclipse.ocl.expressions.LetExp, java.lang.Object,
     * java.lang.Object)
     */
    @Override
    protected EPackage handleLetExp(LetExp<EClassifier, EParameter> letExp, EPackage variableResult, EPackage inResult) {
        EClassifier newType = handle(letExp.getType());
        if (newType != null) {
            orgToCopy.put(letExp.getType(), newType);
            letExp.setType(newType);
        }
        return super.handleLetExp(letExp, variableResult, inResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleMessageExp(org.eclipse.ocl.expressions.MessageExp, java.lang.Object,
     * java.util.List)
     */
    @Override
    protected EPackage handleMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp,
            EPackage targetResult, List<EPackage> argumentResults) {
        EClassifier newType = handle(messageExp.getType());
        if (newType != null) {
            orgToCopy.put(messageExp.getType(), newType);
            messageExp.setType(newType);
        }
        return super.handleMessageExp(messageExp, targetResult, argumentResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp,
     * java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp, EPackage sourceResult,
            List<EPackage> argumentResults) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);
            callExp.setType(newType);
        }
        return super.handleOperationCallExp(callExp, sourceResult, argumentResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ocl.utilities.AbstractVisitor#handleOppositePropertyCallExp(org.eclipse.ocl.expressions.OppositePropertyCallExp
     * , java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handleOppositePropertyCallExp(OppositePropertyCallExp callExp,
            EPackage sourceResult) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);
            callExp.setType(newType);
        }
        return super.handleOppositePropertyCallExp(callExp, sourceResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handlePropertyCallExp(org.eclipse.ocl.expressions.PropertyCallExp,
     * java.lang.Object, java.util.List)
     */
    @Override
    protected EPackage handlePropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp, EPackage sourceResult,
            List<EPackage> qualifierResults) {
        EClassifier newType = handle(callExp.getType());
        if (newType != null) {
            orgToCopy.put(callExp.getType(), newType);
            callExp.setType(newType);
        }
        if (callExp.getReferredProperty() != null) {
            EStructuralFeature newFeature = handle(callExp.getReferredProperty());
            if(newFeature!=null){
                callExp.setReferredProperty(newFeature);
            }
            EClassifier newType1 = handle(callExp.getReferredProperty().getEType());
            if (newType1 != null) {
                orgToCopy.put(callExp.getReferredProperty().getEType(), newType);
                callExp.getReferredProperty().setEType(newType1);
            }
        }
        return super.handlePropertyCallExp(callExp, sourceResult, qualifierResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralExp(org.eclipse.ocl.expressions.TupleLiteralExp,
     * java.util.List)
     */
    @Override
    protected EPackage handleTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp,
            List<EPackage> partResults) {
        EClassifier newType = handle(literalExp.getType());
        if (newType != null) {
            orgToCopy.put(literalExp.getType(), newType);

            literalExp.setType(newType);
        }
        return super.handleTupleLiteralExp(literalExp, partResults);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralPart(org.eclipse.ocl.expressions.TupleLiteralPart,
     * java.lang.Object)
     */
    @Override
    protected EPackage handleTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part, EPackage valueResult) {
        EClassifier newType = handle(part.getType());
        if (newType != null) {
            orgToCopy.put(part.getType(), newType);
            part.setType(newType);
        }
        if (part.getAttribute() != null) {
            EStructuralFeature newAtt = handle(part.getAttribute());
            if (newAtt != null) {
                orgToCopy.put(part.getAttribute(), newAtt);
                part.setAttribute(newAtt);
            }
            EClassifier attType = handle(part.getAttribute().getEType());
            if (attType != null) {
                orgToCopy.put(part.getAttribute().getEType(), attType);
                part.getAttribute().setEType(attType);
            }
            EGenericType genType = handle(part.getAttribute().getEGenericType());
            if (genType != null) {
                orgToCopy.put(part.getAttribute().getEGenericType(), genType);
                part.getAttribute().setEGenericType(genType);
            }
        }
        return super.handleTupleLiteralPart(part, valueResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#handleVariable(org.eclipse.ocl.expressions.Variable, java.lang.Object)
     */
    @Override
    protected EPackage handleVariable(Variable<EClassifier, EParameter> variable, EPackage initResult) {
        EClassifier newType = handle(variable.getType());
        if (newType != null) {
            orgToCopy.put(variable.getType(), newType);
            variable.setType(newType);
        }
        /*
         * variable
         */
        return super.handleVariable(variable, initResult);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ocl.utilities.AbstractVisitor#safeVisit(org.eclipse.ocl.utilities.Visitable)
     */
    @Override
    protected EPackage safeVisit(Visitable v) {
        return super.safeVisit(v);
    }

}