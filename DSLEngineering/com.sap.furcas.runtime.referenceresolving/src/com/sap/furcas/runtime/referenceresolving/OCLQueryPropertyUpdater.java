package com.sap.furcas.runtime.referenceresolving;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.utilities.AbstractVisitor;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrefixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;

/**
 * Represents an OCL "query" used to find an existing element in the model to assign to a property. The query is based on a
 * parameter whose value is taken from a token in the text blocks model.
 * <p>
 * 
 * The tricky part about this type of updater, from the perspective of the OCL Impact Analysis, is that its parameterized OCL
 * expression must contain some subexpression for the parameter usage. This must not be a literal expression because then the
 * impact analysis may be able to evaluate it and cut short the impact analysis process. For example, were the parameter
 * expression represented as a string literal <code>'???'</code> in an expression <code>...-&gt;select(i.x = '???')</code> then
 * the impact analysis may try a partial evaluation of <code>i.x = '???'</code> for the pre-change and post-change models. If both
 * values of <code>i.x</code> are not equal to <code>'???'</code> (which is of course very likely) then the impact analysis would
 * infer that no change to the overall expression's value has happened. However, this may not be true depending on the actual
 * value used for the parameter at the time of evaluation.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class OCLQueryPropertyUpdater extends AbstractFurcasOCLBasedModelUpdater {
    private final Property property;

    /**
     * The OCL expression compiled from the {@link LookupScopePArg} attached to the {@link #property}
     */
    private final OCLExpression lookupScopeExp;
    
    /**
     * The OCLK expression extracted from the {@link ReferenceByPArg} attached to the {@link #property}
     */
    private final OCLExpression referenceByExp;
    
    /**
     * The OCL expression synthesized by constructing a "collect" iterator expression whose source is a copy
     * of the {@link #lookupScopeExpression} and whose body expression is a copy of the
     * {@link #referenceByExpression}
     */
    private final IteratorExp collectExp;

    /**
     * the prefix to be prepended to the identifier provided by a token before the concatenated string
     * is compared to the result of the {@link #referenceByExp} evaluated on the elements returned by
     * the {@link #lookupScopeExp}.
     */
    private final PrefixPArg prefix;

    /**
     * the postfix to be appended to the identifier provided by a token before the concatenated string
     * is compared to the result of the {@link #referenceByExp} evaluated on the elements returned by
     * the {@link #lookupScopeExp}.
     */
    private final PostfixPArg postfix;
    
    /**
     * The {@link Activator} to notify when a token is changed. The syntax registry will, in turn,
     * notify the {@link TokenChanger}s registered with it.
     */
    private final TokenChanger tokenChanger;
    
    /**
     * The visitor returns the first "self" variable found referenced by the expression. If no such variable
     * is found, <code>null</code> is returned by the visitor. All {@link VariableExp} expressions
     * referencing any variable named "self" will have their {@link VariableExp#getReferredVariable() variable}
     * set to the first "self" variable found.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    private class SelfRenamingVisitor extends AbstractVisitor<Variable> {
        private final String newNameForSelf;

        public SelfRenamingVisitor(String newNameForSelf) {
            this.newNameForSelf = newNameForSelf;
        }

        @Override
        protected Variable handleVariable(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable,
                Variable initResult) {
            if (variable.getName().equals(Environment.SELF_VARIABLE_NAME)) {
                variable.setName(newNameForSelf);
                if (result == null) {
                    result = (Variable) variable;
                }
            }
            return result;
        }

        @Override
        public Variable visitVariableExp(org.eclipse.ocl.expressions.VariableExp<EClassifier, EParameter> v) {
            if (result != null && v.getReferredVariable().getName().equals(Environment.SELF_VARIABLE_NAME)) {
                v.setReferredVariable(result);
            }
            return visitVariable(v.getReferredVariable());
        }

        public Variable visit(OCLExpression exp) {
            return safeVisit(exp);
        }

    }

    protected OCLQueryPropertyUpdater(Property property, EPackage.Registry metamodelPackageRegistry,
            OppositeEndFinder oppositeEndFinder, TokenChanger tokenChanger) throws ParserException {
        super(property.getPropertyReference().getStrucfeature(), metamodelPackageRegistry, oppositeEndFinder,
                null, // triggerExpressionsWithContext are computed in getTriggerExpressionsWithContext
                /* notifyNewContextElements */true,
                determineSelfKind(getExpressionString(property)), ContextAndForeachHelper
                        .getContextTag(getExpressionString(property)));
        this.property = property;
        this.prefix = PropertyArgumentUtil.getPrefixPArg(property);
        this.postfix = PropertyArgumentUtil.getPostfixPArg(property);
        
        String unpreparedLookupScopeQuery = getExpressionString(property);
        String lookupScopeAsString = ContextAndForeachHelper.prepareOclQuery(unpreparedLookupScopeQuery);
        Helper oclHelper = createOCLHelper(unpreparedLookupScopeQuery, property.getParentTemplate(), getOppositeEndFinder());
        lookupScopeExp = oclHelper.createQuery(lookupScopeAsString);
        OCLExpression collectSource = oclHelper.createQuery(lookupScopeAsString);
        
        // The following is an OCL expression where "self" refers to an element produced by
        // the lookupScope expression. Therefore, its type is goverend by the lookupScope expression's
        // result type.
        String referenceByAsString = PropertyArgumentUtil.getReferenceByAsOCL(PropertyArgumentUtil.getReferenceByPArg(property));
        oclHelper.setContext(((CollectionType) lookupScopeExp.getType()).getElementType());
        referenceByExp = oclHelper.createQuery(referenceByAsString);
        // Now modify a copy of referenceByExp such that all "self" expressions have their variable
        // renamed to a unique iterator variable name which will then be used in a "collect"
        // LoopExp expression of which the referenceByExp is the body and the
        // lookupScopeExp is the source
        OCLExpression collectBody = oclHelper.createQuery(referenceByAsString);
        Variable firstSelf = renameAllSelf(collectBody, "i___84923___");
        collectExp = EcoreFactory.eINSTANCE.createIteratorExp();
        collectExp.setName(PredefinedType.COLLECT_NAME);
        collectExp.setSource(collectSource);
        collectExp.setBody(collectBody);
        collectExp.getIterator().add(firstSelf);
        collectExp.setType(getCollectType(collectExp, (EcoreEnvironment) oclHelper.getEnvironment()));
        this.tokenChanger = tokenChanger;
    }
    
    private static EClassifier getCollectType(IteratorExp collectExp, EcoreEnvironment env) {
        EClassifier elementType = collectExp.getBody().getType();
        if (elementType instanceof CollectionType) {
                CollectionType ct = (CollectionType) elementType;
                elementType = CollectionUtil.getFlattenedElementType(ct);
        }
        if (collectExp.getSource().getType() instanceof SequenceType
                || collectExp.getSource().getType() instanceof OrderedSetType<?, ?>) {
                return TypeUtil.resolveSequenceType(env, elementType);
        } else {
            return TypeUtil.resolveBagType(env, elementType);
        }
    }

    private static String getExpressionString(Property property) {
        LookupScopePArg qarg = PropertyArgumentUtil.getLookupScopePArg(property);
        if (qarg == null) {
            throw new RuntimeException("Didn't find a query argument in rule for property "+property.getPropertyReference().getStrucfeature());
        }
        return qarg.getQuery();
    }

    @Override
    public Collection<ExpressionWithContext> getTriggerExpressionsWithContext() {
        Collection<ExpressionWithContext> result = new ArrayList<ExpressionWithContext>();
        try {
            String unpreparedLookupScopeQuery = getExpressionString(property);
            EClass parsingContextForLookupScope = (EClass) ContextAndForeachHelper.getParsingContext(
                    unpreparedLookupScopeQuery, property.getParentTemplate());
            ExpressionWithContext lookupScopeExpWithContext = new ExpressionWithContext(lookupScopeExp,
                    parsingContextForLookupScope);
            ExpressionWithContext collectExpWithContext = new ExpressionWithContext(collectExp,
                    parsingContextForLookupScope);
            result.add(lookupScopeExpWithContext);
            result.add(collectExpWithContext);
        } catch (ParserException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * This model updater is registered for changes coming from one of the two expressions {@link #collectExp} and
     * {@link #lookupScopeExp}. If the {@link #collectExp} has changed its value for a context element, this means that
     * the list of string literals available for performing the query for setting the property on that context element
     * may have changed. If the property to be updated by the query {@link #isResolved is yet unresolved}, resolving is
     * attempted now.
     * <p>
     * 
     * If the {@link #lookupScopeExp} may have changed its value then this may also mean that the query now resolves to
     * a different element. If the property is not currently resolved, resolving is attempted now. If the property is
     * currently {@link #isResolved(EObject) resolved} and the element to which it is resolved is still in the candidate
     * list, only the token in the text blocks model may need to be updated, based on user preferences, dirty state,
     * etc.
     * <p>
     * 
     * If the property is currently resolved and the {@link #lookupScopeExp} expression's value may have changed but the
     * element to which the property is currently bound does no longer occur in the scope, a new lookup is performed. If
     * successful, the property is bound to the new lookup result.
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder, Notification change) {
        for (EObject eo : affectedContextObjects) {
            for (EObject elementToUpdate : getElementsToUpdate(eo)) {
                for (LexedToken token : getTokens(elementToUpdate)) {
                    
                    if (!isResolved(elementToUpdate, token)) {
                        resolve(elementToUpdate, token);
                        
                    } else if (expression == lookupScopeExp) {
                        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder);
                        Object elementsInScope = ocl.evaluate(eo, lookupScopeExp);

                        if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() == elementsInScope) {
                            continue; // only assign if result was not "invalid"
                        }
                        Object oldValue = getResolvedElement(token);
                        if (((Collection<?>) elementsInScope).contains(oldValue)) {
                            // resolved element still in scope; update token to reflect name change
                            tokenChanger.requestTokenValueChange(token, token.getValue(),
                                    getNewTokenValue(ocl, oldValue));
                        } else {
                            // element to which identifier resolved so far is no
                            // longer in scope; resolve again, now based on modified scope
                            resolve(elementToUpdate, token);
                        }
                    }
                }
            }
        }
    }

    /**
     * From the <code>elementToUpdate</code> and the {@link #property} find out the tokens that were parsed by the
     * {@link #property} rule and that were produced within the execution of the template that led to
     * <code>element</code>'s creation. If no such token is found, e.g., because the {@link #property} rule didn't fire
     * for <code>element</code>, <code>null</code> is returned.
     */
    private Collection<LexedToken> getTokens(EObject elementToUpdate) {
        // TODO there may be multiple versions of such tokens; decide which version to return
        Collection<EObject> documentNodeDocumentingExecutionOfQuery = getOppositeEndFinder()
        .navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getDocumentNode_SequenceElement(), property);
        Collection<LexedToken> result = new HashSet<LexedToken>();
        if (documentNodeDocumentingExecutionOfQuery != null) {
            for (EObject eo : documentNodeDocumentingExecutionOfQuery) {
                if (eo instanceof LexedToken && eo.eResource() != null) {
                    LexedToken lt = (LexedToken) eo;
                    for (EObject correspondingModelElement : lt.getParent().getCorrespondingModelElements()) {
                        if (correspondingModelElement == elementToUpdate) {
                            result.add(lt);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Computes the identifier by which the element needs to be referenced by the {@link #property}.
     * 
     * @param element expected to conform to the element type of the {@link #lookupScopeExp} expression's
     * result type which is assumed to be a collection type
     */
    private String getNewTokenValue(OCL ocl, Object element) {
        String newToken = (String) ocl.evaluate(element, referenceByExp);
        return PropertyArgumentUtil.stripPrefixPostfix(newToken, prefix, postfix);
    }
    
    /**
     * Based on the <code>token</code> from which the identifier is obtained, prefixed with {@link #prefix} and
     * postfixed with {@link #postfix}, a lookup is performed by computing {@link #lookupScopeExp} for <code>eo</code>,
     * then computing the {@link #referenceByExp} strings for each of the resulting scope elements and comparing them to
     * the prefixed/postfixed token value. The first match is assigned to <code>eo</code>'s
     * {@link #getPropertyToUpdate() property}.<p>
     * 
     * If the {@link #lookupScopeExp} evaluates to <code>invalid</code>, resolution fails; the property
     * is not updated.
     */
    private void resolve(EObject elementToUpdate, LexedToken token) {
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        Object elementsInScope = ocl.evaluate(elementToUpdate, lookupScopeExp);

        if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() == elementsInScope) {
            return;
        }
        EObject currentlyResolved = getResolvedElement(token);
        token.getReferencedElements().clear(); // Break the reference
        
        for (Object o : (Collection<?>) elementsInScope) {
            EObject candidate = (EObject) o;
            
            if (token.getValue().equals(getNewTokenValue(ocl, candidate))) {
                if (getPropertyToUpdate().isMany()) {
                    @SuppressWarnings("unchecked")
                    EList<EObject> list = (EList<EObject>) elementToUpdate.eGet(getPropertyToUpdate());
                    int i = list.indexOf(currentlyResolved);
                    if (i < 0) {
                        list.add(candidate);
                    } else {
                        list.remove(i);
                        list.add(i, candidate);
                    }
                } else {
                    elementToUpdate.eSet(getPropertyToUpdate(), candidate);
                }
                token.getReferencedElements().add(candidate);
                break;
            }
        }
    }

    /**
     * Tells if the property to be updated by this updater is currently resolved.
     */
    private boolean isResolved(EObject element, LexedToken token) {
        EObject resolved = getResolvedElement(token);
        if (resolved == null) {
            return false;
        } else if (getPropertyToUpdate().isMany()) {
            List<?> list = (List<?>) element.eGet(getPropertyToUpdate());
            return list.contains(resolved);
        }
        return true;
        
    }

    private EObject getResolvedElement(LexedToken token) {
        if (token.getReferencedElements().isEmpty()) {
            return null;
        }
        return token.getReferencedElements().get(0);
    }


    private Variable renameAllSelf(OCLExpression collectBody, String newNameForSelf) {
        return new SelfRenamingVisitor(newNameForSelf).visit(collectBody);
    }

    @Override
    protected SequenceElement getSequenceElement() {
        return property;
    }

}