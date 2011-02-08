package com.sap.furcas.runtime.referenceresolving;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.utilities.AbstractVisitor;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
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
    private OCLExpression lookupScopeExp;
    
    /**
     * The OCLK expression extracted from the {@link ReferenceByPArg} attached to the {@link #property}
     */
    private OCLExpression referenceByExp;
    
    /**
     * The OCL expression synthesized by constructing a "collect" iterator expression whose source is a copy
     * of the {@link #lookupScopeExpression} and whose body expression is a copy of the
     * {@link #referenceByExpression}
     */
    private IteratorExp collectExp;

    /**
     * the prefix to be prepended to the identifier provided by a token before the concatenated string
     * is compared to the result of the {@link #referenceByExp} evaluated on the elements returned by
     * the {@link #lookupScopeExp}.
     */
    private String prefix;

    /**
     * the postfix to be appended to the identifier provided by a token before the concatenated string
     * is compared to the result of the {@link #referenceByExp} evaluated on the elements returned by
     * the {@link #lookupScopeExp}.
     */
    private String postfix;
    
    /**
     * The visitor returns the first "self" variable found referenced by the expression. If no such variable
     * is found, <code>null</code> is returned by the visitor. All {@link VariableExp} expressions
     * referencing any variable named "self" will have their {@link VariableExp#getReferredVariable() variable}
     * set to the first "self" variable found.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    private class SelfRenamingVisitor extends AbstractVisitor<Variable> implements VisitorExtension<Variable> {
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
            OppositeEndFinder oppositeEndFinder) throws ParserException {
        super(property.getPropertyReference().getStrucfeature(), metamodelPackageRegistry, oppositeEndFinder,
                null, // triggerExpressionsWithContext are computed in getTriggerExpressionsWithContext
                /* notifyNewContextElements */true,
                determineSelfKind(getExpressionString(property)), ContextAndForeachHelper
                        .getContextTag(getExpressionString(property)));
        this.property = property;
        PrefixPArg prefixPArg = PropertyArgumentUtil.getPrefixPArg(property);
        if (prefixPArg != null) {
            prefix = prefixPArg.getPrefix();
        }
        PostfixPArg postfixPArg = PropertyArgumentUtil.getPostfixPArg(property);
        if (postfixPArg != null) {
            this.postfix = postfixPArg.getPostfix();
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
            String lookupScopeAsString = ContextAndForeachHelper.prepareOclQuery(unpreparedLookupScopeQuery);
            Helper oclHelper = createOCLHelper(unpreparedLookupScopeQuery, property.getParentTemplate(), getOppositeEndFinder());
            lookupScopeExp = oclHelper.createQuery(lookupScopeAsString);
            OCLExpression collectSource = oclHelper.createQuery(lookupScopeAsString);
            oclHelper.setContext(((CollectionType) lookupScopeExp.getType()).getElementType());
            String referenceByAsString = PropertyArgumentUtil.getReferenceByAsOCL(PropertyArgumentUtil
                    .getReferenceByPArg(property));
            // The following is an OCL expression where "self" refers to an element produced by
            // the lookupScope expression. Therefore, its type is goverend by the lookupScope expression's
            // result type.
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
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder, Notification change) {
        for (EObject eo : affectedContextObjects) {
            for (LexedToken token : getTokens(eo)) {
                if (!isResolved(eo)) {
                    resolve(eo, token);
                } else {
                    if (expression == lookupScopeExp) {
                        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder);
                        Object newValue = ocl.evaluate(eo, lookupScopeExp);
                        // only assign if result was not "invalid"
                        if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() != newValue) {
                            Collection<?> newValueAsCol = (Collection<?>) newValue;
                            try {
                                for (EObject elementToUpdate : getElementsToUpdate(eo)) {
                                    Object oldValue = elementToUpdate.eGet(getPropertyToUpdate());
                                    if (oldValue instanceof Collection<?>) {
                                        // figure out the position based on where the property occurs in the
                                        // mapping's sequence
                                        oldValue = ((List<?>) oldValue).get(getPosition());
                                    }
                                    if (newValueAsCol.contains(oldValue)) {
                                        // resolved element still in scope; update token if desired
                                        String newTokenValue = getNewTokenValue(ocl, (EObject) oldValue);
                                        if (token != null
                                                && shallUpdateReferencingTokenInTextBlockModel(token, newTokenValue)) {
                                            token.setValue(newTokenValue);
                                        }
                                    } else {
                                        // element to which identifier resolved so far is no longer in scope;
                                        // resolve again, now based on modified scope
                                        resolve(eo, token);
                                    }
                                }
                            } catch (ParserException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            // TODO decide what to do: lookupScopeExp evaluates to invalid; break resolved ref?
                        }
                    }
                }
            }
        }
    }

    /**
     * From the <code>element</code> and the {@link #property} find out the token that represents
     * the identifier with which the element references the other element stored in the {@link #property}.
     * If <code>element</code> doesn't contain such an identifier, e.g., because it was not parsed/produced
     * by the sequence element containing {@link #property}, <code>null</code> is returned.
     */
    private Collection<LexedToken> getTokens(EObject element) {
        Collection<EObject> textBlockDocumentingExecutionOfQuery = getOppositeEndFinder()
        .navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getDocumentNode_SequenceElement(), property);
        Collection<LexedToken> result = new HashSet<LexedToken>();
        if (textBlockDocumentingExecutionOfQuery != null) {
            for (EObject eo : textBlockDocumentingExecutionOfQuery) {
                if (eo instanceof LexedToken) {
                    result.add((LexedToken) eo);
                }
            }
        }
        return result;
    }

    /**
     * Computes the identifier by which the element needs to be referenced by the {@link #property}.
     * This identifier is computed by removing the prefix and postfix from the result of evaluating
     * the {@link #referenceByExp} expression on <code>element</code>.
     * 
     * @param element expected to conform to the element type of the {@link #lookupScopeExp} expression's
     * result type which is assumed to be a collection type
     */
    private String getNewTokenValue(OCL ocl, EObject element) {
        String newToken = (String) ocl.evaluate(element, referenceByExp);
        if (prefix != null) {
            if (!newToken.startsWith(prefix)) {
                throw new RuntimeException("New identifier \""+
                        newToken+"\" to be used for referencing doesn't start with prefix \""+prefix+"\"");
            }
            newToken = newToken.substring(0, prefix.length());
        }
        if (postfix != null) {
            if (!newToken.endsWith(postfix)) {
                throw new RuntimeException("New identifier \""+
                        newToken+"\" to be used for referencing doesn't end with prefix \""+postfix+"\"");
            }
            newToken = newToken.substring(0, newToken.length()-postfix.length());
        }
        return newToken;
    }
    
    /**
     * If the {@link #property} refers to a multi-valued property, it has to be an ordered
     * property. The position at which {@link #property} will set an element in the property
     * collection is determined by this method. Usually, this will be 0. However, if the
     * same multi-valued property is referred to by several property inits or property
     * declarations, the position depends on these elements' ordering in the mapping.
     */
    private int getPosition() {
        // TODO implement OCLQueryPropertyUpdater.getPosition
        return 0;
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
    private void resolve(EObject eo, LexedToken token) {
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        Object newValue = ocl.evaluate(eo, lookupScopeExp);
        if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() != newValue) {
            String tokenValue = token.getValue();
            String prefixed = prefix == null ? tokenValue : prefix + tokenValue;
            String prepostfixed = postfix == null ? prefixed : prefixed + postfix;
            for (Object o : (Collection<?>) newValue) {
                String referenceBy = (String) ocl.evaluate(o, referenceByExp);
                if (prepostfixed.equals(referenceBy)) {
                    eo.eSet(getPropertyToUpdate(), o);
                    break;
                }
            }
        }
    }

    /**
     * Tells if the property to be updated by this updater is currently resolved.
     */
    private boolean isResolved(EObject element) {
        return getPropertyToUpdate().isMany() && element.eGet(getPropertyToUpdate()) != null
                && ((List<?>) element.eGet(getPropertyToUpdate())).get(getPosition()) != null
                || element.eGet(getPropertyToUpdate()) != null;
    }
    
    /**
     * Determines if the <code>token</code> shall be updated with the <code>newValue</code>.
     * This can be decided, e.g., based on user preferences regarding whether other text block
     * models shall become dirty just because of such an update. Dirty state of the token's
     * resource may be one aspect influencing the decision. The update is not performed here.
     * The caller is responsible to perform it if this method returns <code>true</code>.
     */
    private boolean shallUpdateReferencingTokenInTextBlockModel(LexedToken token, String newValue) {
        return token.eResource().isModified();
    }

    private Variable renameAllSelf(OCLExpression collectBody, String newNameForSelf) {
        return new SelfRenamingVisitor(newNameForSelf).visit(collectBody);
    }

    @Override
    protected SequenceElement getSequenceElement() {
        return property;
    }

}