package com.sap.furcas.runtime.parser.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class ForeachDelayedReference extends DelayedReference {
    /**
     * Used by
     * {@link ObservableInjectingParser#setPredicateRef(Object, String, String, String, List, IRuleName, boolean, String, ModelUpdaterRegistry)}
     */
    public ForeachDelayedReference(Object referenceContextObject,
            Object modelElement, String propertyName, String oclQuery,
            String mode, List<PredicateSemantic> list,
            IRuleName ruleNameFinder, ANTLR3LocationToken token,
            boolean hasContext, boolean isOptional) {
        super(referenceContextObject, DelayedReference.ReferenceType.TYPE_FOREACH_PREDICATE, modelElement,
                propertyName, oclQuery, mode, list, ruleNameFinder, token, hasContext, isOptional);
    }

    /**
     * Sets the delayed reference.
     * 
     * @param reference
     *            the reference
     * @param modelAdapter
     *            the model handler
     * @param contextByElement
     *            the context by element
     * @return <code>true</code> if the reference was resolved successfully, <code>false</code> else.
     * 
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws ModelElementCreationException
     */
    @Override
    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter, ContextManager contextManager,
            ObservableInjectingParser parser) throws ModelAdapterException, ModelElementCreationException {
        Object contextElement = reference.getContextElement();
        if (contextElement instanceof IModelElementProxy) {
            IModelElementProxy proxyContext = (IModelElementProxy) contextElement;
            contextElement = proxyContext.getRealObject();
        }
        return setDelayedReferenceWithPredicate(reference, modelAdapter, contextManager, contextElement, parser);
    }

    /**
     * If the <tt>reference</tt>'s {@link DelayedReference#getModelElement() model element} is a proxy, resolve it first.
     */
    private void resolveModelElementProxy(DelayedReference reference, IModelAdapter modelAdapter) throws ModelAdapterException,
            ModelElementCreationException {
        if (reference.getModelElement() instanceof ModelElementProxy) {
            ModelElementProxy proxy = (ModelElementProxy) reference.getModelElement();
            if (proxy.getRealObject() == null) {
                Object result;
                result = modelAdapter.createOrResolveElement(proxy.getType(), proxy.getAttributeMap(), null, null, false, true);
                if (result instanceof EObject) {
                    reference.setModelElement(result);
                }
            } else {
                reference.setModelElement(proxy.getRealObject());
            }
        }
    }

    private boolean setDelayedReferenceWithPredicate(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement, ObservableInjectingParser parser) throws ModelAdapterException {
        try {
            contextElement = DelayedReferencesHelper.getNavigatedContextElementFromReference(reference, modelAdapter, contextManager, contextElement);

            // when the element is a Proxy resolve it first
            resolveModelElementProxy(reference, modelAdapter);
            if (reference.getOclQuery() == null) {
                parser.getInjector().addError(new ParsingError("You must specify an OCL query.", reference.getToken()));
                return false;
            }
            Collection<?> result = DelayedReferencesHelper.evaluateForeachOcl((EObject) reference.getModelElement(), reference, modelAdapter,
                    contextElement);
            List<ForeachProductionResult> producedResults = new ArrayList<ForeachProductionResult>();
            // loop over the results to handle them one by one,
            // delete all elements that were created by this foreach but are
            // not valid anymore
            String mode = reference.getMode();
            IRuleName ruleNameFinder = reference.getRuleNameFinder();
            for (Object singleForeachResult : result) {
                if (!(singleForeachResult instanceof Boolean) || ((Boolean) singleForeachResult).booleanValue()) {
                    // look if there are possible when/as constructs
                    PredicateSemantic activePredicateSemantic = getActivePredicateFromWhenAsClauses(reference,
                            modelAdapter, contextElement, singleForeachResult);
                    Template templateUsedForProduction = getTemplateFromPredicateSemantic(activePredicateSemantic, reference);
                    // TODO it would be nice to compute the rule name from the template; however, if no textblocks are being produced, the reference doesn't have the link to the ForeachPropertyInit set, so the template can't be determined and isn't passed in by the parser run; only the rule name is passed
                    String parserRuleNameToUseForProduction = computeRuleName(parser, singleForeachResult, activePredicateSemantic, mode, ruleNameFinder);
                    if (parserRuleNameToUseForProduction == null) {
                        throw new UnknownProductionRuleException("At least one as parameter is needed in that case.");
                    }
                    ModelElementProxy foreachTargetElement = produceForOneForeachResult(reference, modelAdapter,
                            contextElement, parser, singleForeachResult, activePredicateSemantic, parserRuleNameToUseForProduction);
                    ForeachProductionResult resultObject = new ForeachProductionResult(foreachTargetElement, templateUsedForProduction,
                            singleForeachResult);
                    producedResults.add(resultObject);
                }
            }
            setReferenceAndUpdateForeachContexts(reference, modelAdapter, parser.getInjector(), producedResults);
        } catch (Exception e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        }
        return true;
    }

    private static class ForeachProductionResult {
        private final ModelElementProxy producedProxy;
        private final Template templateUsedForProduction;
        private final Object foreachExpressionResultForWhichProduced;
        public ForeachProductionResult(ModelElementProxy producedProxy, Template templateUsedForProduction,
                Object foreachExpressionResultForWhichProduced) {
            super();
            this.producedProxy = producedProxy;
            this.templateUsedForProduction = templateUsedForProduction;
            this.foreachExpressionResultForWhichProduced = foreachExpressionResultForWhichProduced;
        }
        public ModelElementProxy getProducedProxy() {
            return producedProxy;
        }
        public Template getTemplateUsedForProduction() {
            return templateUsedForProduction;
        }
        public Object getForeachExpressionResultForWhichProduced() {
            return foreachExpressionResultForWhichProduced;
        }
    }
    
    /**
     * A <code>foreach</code> expression was (re-)evaluated, and for each result, based on any <code>when</code>/
     * <code>as</code> {@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic} elements, the corresponding
     * template's production rule was executed by the parser. This produced a {@link ModelElementProxy} which has not
     * yet been turned into a real {@link EObject} yet nor has it been entered into the target feature.
     * <p>
     * 
     * Prior executions of the same <code>foreach</code> predicate on the same source model element may have happened.
     * In this case, there will be {@link ForEachExecution} records documenting this. If no such records are found, all
     * proxies produced will be materialized as {@link EObject}s and
     * {@link #setReference(DelayedReference, Object, IModelAdapter, ModelElementProxy, IModelInjector, int) added/set} to/into the target
     * feature described by the <code>reference</code>.
     * <p>
     * 
     * If {@link ForEachExecution} objects are found for the source element and <code>foreach</code> predicate, their
     * {@link ForEachExecution#getResultModelElement() result elements} are obtained and compared to the new
     * {@link ForeachProductionResult production instructions} which also contain the {@link Template} used to produce
     * the target element. The template is used to compare the element types in order to try to re-use already existing
     * elements.
     * <p>
     * 
     * In case a target object from a prior evaluation can be re-used, it is set as the proxy's
     * {@link ModelElementProxy#setRealObject(Object) real object}, and no new target object is created for this
     * <code>foreach</code> result. Otherwise, a new target object is created. The re-used or created object is then
     * used to replace (single multiplicity) or to add to (many-multiplicity) the target feature.
     * <p>
     * 
     * As to the re-use strategy, we distinguish between re-using the {@link ForEachExecution} hull only and the
     * {@link ForEachExecution#getResultModelElement() result element} that was produced in an earlier run. Two element
     * collections are compared, namely those listed as {@link ForEachExecution#getResultModelElement() result elements}
     * of earlier evaluations on the <code>reference</code>'s {@link DelayedReference#getTextBlock() text block} for the
     * same <code>foreach</code> predicate; and those described by <code>producedResults</code> which contains proxies
     * and the templates telling the types and modes with which they were created. The two collections are iterated in
     * parallel. If the {@link ForEachExecution}'s template matches that in the current <code>producedResults</code>
     * element, the {@link ForEachExecution#getResultModelElement() old result element} is re-used by
     * {@link ModelElementProxy#setRealObject(Object) setting} it on the proxy. Otherwise, a new element is produced
     * using {@link ModelInjector#createOrResolve(ModelElementProxy, ANTLR3LocationToken, ANTLR3LocationToken)} and the
     * existing {@link ForEachExecution} is updated for the new result element, template, etc. If the collection of
     * {@link ForEachExecution} elements is shorter than that of the <code>producedResults</code>, additional
     * {@link ForEachExecution} elements are added to the <code>reference</code>'s {@link TextBlock#getForEachExecutions()
     * textblock's foreach context list}. Extraneous elements are deleted from it.
     * <p>
     * 
     * It's obvious that there may be more sophisticated re-use strategies based on longest sequence etc., but those may
     * be added later.
     * @param injector TODO
     * @param producedResults the {@link ForeachProductionResult#getTemplateUsedForProduction() templates} need to be
     * set only if text blocks are being produced by the parser run
     */
    private void setReferenceAndUpdateForeachContexts(DelayedReference reference, IModelAdapter modelAdapter,
            IModelInjector injector, List<ForeachProductionResult> producedResults)
            throws ModelElementCreationException, ModelAdapterException {
        Iterator<ForEachExecution> foreachContextIterator = null;
        ForEachExecution nextOldForeachContext = null;
        if (reference.getTextBlock() != null) {
            foreachContextIterator = ((TextBlock) reference.getTextBlock()).getForEachExecutions().iterator();
            nextOldForeachContext = getNextForeachContext(foreachContextIterator, reference);
        }
        int i=0;
        for (ForeachProductionResult producedResult : producedResults) {
            // check for a re-usable target element of ForEachContext with its result element
            if (nextOldForeachContext != null && isTargetElementReusable(nextOldForeachContext, producedResult)) {
                // re-use the target object referenced by the ForEachContext and the ForEachContext itself
                producedResult.getProducedProxy().setRealObject(nextOldForeachContext.getResultModelElement());
                if (producedResult.getForeachExpressionResultForWhichProduced() instanceof EObject) {
                    nextOldForeachContext.setContextElement((EObject) producedResult.getForeachExpressionResultForWhichProduced());
                } else if (producedResult.getForeachExpressionResultForWhichProduced() instanceof EObject) {
                    nextOldForeachContext.setContextString((String) producedResult.getForeachExpressionResultForWhichProduced());
                }
                reference.setRealValue(nextOldForeachContext.getResultModelElement());
            } else {
                // target element is not re-usable, a new one needs to be produced
                setReference(reference, producedResult.getForeachExpressionResultForWhichProduced(), modelAdapter,
                        producedResult.getProducedProxy(), injector, i);
                if (reference.getTextBlock() != null && producedResult.getTemplateUsedForProduction() != null) {
                    // if we have a ForEachContext element for the current source element and foreach predicate,
                    // re-use and update it:
                    if (nextOldForeachContext == null) {
                        // no ForEachContext element; produce a new one and append
                        ForEachExecution newContext = produceNewForEachContext(reference, producedResult);
                        ((TextBlock) reference.getTextBlock()).getForEachExecutions().add(newContext);
                    } else {
                        // ForEachContext names a template/element that can't be re-used; update it correspondingly
                        Object result = producedResult.getForeachExpressionResultForWhichProduced();
                        if (result instanceof EObject) {
                            nextOldForeachContext.setContextElement((EObject) producedResult
                                    .getForeachExpressionResultForWhichProduced());
                        } else if (result instanceof String) {
                            nextOldForeachContext.setContextString((String) producedResult
                                    .getForeachExpressionResultForWhichProduced());
                        }
                        nextOldForeachContext.setTemplateUsedForProduction(producedResult.getTemplateUsedForProduction());
                        nextOldForeachContext.setResultModelElement((EObject) producedResult.getProducedProxy()
                                .getRealObject());
                    }
                }
            }
            if (nextOldForeachContext != null && foreachContextIterator != null && foreachContextIterator.hasNext()) {
                nextOldForeachContext = foreachContextIterator.next();
            } else {
                nextOldForeachContext = null;
            }
            i++;
        }
        // delete remaining old ForEachContext entries from reference's textblock
        while (nextOldForeachContext != null) {
            foreachContextIterator.remove();
            nextOldForeachContext = getNextForeachContext(foreachContextIterator, reference);
        }
    }

    private ForEachExecution produceNewForEachContext(DelayedReference reference, ForeachProductionResult producedResult) {
        ForEachExecution newContext = TextblocksFactory.eINSTANCE.createForEachExecution();
        newContext.setForeachPedicatePropertyInit((ForeachPredicatePropertyInit) reference.getQueryElement());
        newContext.setSourceModelElement((EObject) reference.getModelElement());
        newContext.setContextElement((EObject) producedResult.getForeachExpressionResultForWhichProduced());
        newContext.setTemplateUsedForProduction(producedResult.getTemplateUsedForProduction());
        newContext.setResultModelElement((EObject) reference.getRealValue());
        return newContext;
    }

    /**
     * For a {@link ForEachExecution} that is known to be for the same source element and <code>foreach</code>
     * clause as <code>producedResult</code>, checks if the template used by the previous execution as
     * documented by <code>nextOldForeachContext</code> is the same as that used in <code>producedResult</code>.
     */
    private boolean isTargetElementReusable(ForEachExecution nextOldForeachContext, ForeachProductionResult producedResult) {
        return nextOldForeachContext.getTemplateUsedForProduction() == producedResult.getTemplateUsedForProduction();
    }

    /**
     * Finds the next {@link ForEachExecution} in the collection iterated by <code>foreachContextIterator</code>
     * that is for the same {@link DelayedReference#getQueryElement() property init} as the <code>reference</code>
     * and that is for the same {@link ForEachExecution#getSourceModelElement() source element} as the
     * <code>reference</code>. If no such element is found, <code>null</code> is returned
     * 
     * Postcondition: if a non-<code>null</code> result is returned, the <code>foreachContextIterator</code>
     * is at that element so that calling {@link Iterator#remove()} removes the element just returned
     * 
     * @param foreachContextIterator must not be <code>null</code>
     */
    private ForEachExecution getNextForeachContext(Iterator<ForEachExecution> foreachContextIterator,
            DelayedReference reference) {
        ForEachExecution result = null;
        while (foreachContextIterator.hasNext() && result == null) {
            ForEachExecution fec = foreachContextIterator.next();
            if (fec.getForeachPedicatePropertyInit().equals(reference.getQueryElement())
                && reference.getModelElement().equals(fec.getSourceModelElement())) {
                result = fec;
            }
        }
        return result;
    }

    /**
     * Determines the production rule for the <code>singleForeachResult</code> by
     * {@link #getActivePredicateFromWhenAsClauses(DelayedReference, IModelAdapter, Object, Object) scanning} for the
     * applicable predicate semantic. If found, the parser is used to execute the production rule. The result is
     * assigned to the feature as defined by the <code>reference</code> using
     * {@link #setReference(ObservableInjectingParser, DelayedReference, Object, String, IModelAdapter, EObject)}. If no
     * applicable production rule is found, a {@link UnknownProductionRuleException} is thrown.
     * <p>
     * @param singleForeachResult
     *            the current foreach-expression's result to produce an element for
     * @param parserRuleName TODO
     * @return the element proxy describing the element to produce
     */
    private ModelElementProxy produceForOneForeachResult(DelayedReference reference, IModelAdapter modelAdapter,
            Object contextElement, ObservableInjectingParser parser,
            Object singleForeachResult, PredicateSemantic activePredicateSemantic, String parserRuleName) throws ModelAdapterException,
            SyntaxElementException, NoSuchMethodException, UnknownProductionRuleException, IllegalAccessException,
            InvocationTargetException, ModelElementCreationException {
        ModelElementProxy foreachTargetElement = null;
        // look if there are possible when/as constructs
        foreachTargetElement = produceSingleForeachUsingParserRule(parser, reference, singleForeachResult, parserRuleName);
        return foreachTargetElement;
    }

    private String computeRuleName(ObservableInjectingParser parser, Object singleForeachResult,
            PredicateSemantic activePredicateSemantic, String mode, IRuleName ruleNameFinder)
            throws SyntaxElementException {
        String ruleName = null;
        if (activePredicateSemantic == null) {
            // no matching when/as combination; perform default handling:
            if (singleForeachResult instanceof EObject) {
                EClass foreachElementType = ((EObject) singleForeachResult).eClass();
                // get the template
                
                Template tmpl = TcsUtil.findTemplate(foreachElementType, mode, Collections.singletonList(URI.createURI(
                        parser.getSyntaxUUID())));
                // get the rule name from the template
                ruleName = ruleNameFinder.getRuleName(tmpl, mode);
            } else {
                // handle the base types
                if (!(singleForeachResult instanceof String) || !(singleForeachResult instanceof Number)) {
                    throw new IllegalArgumentException("The OCL element " + singleForeachResult
                            + " cannot be used, as it is neither of type String nor a Number");
                }
            }
        } else {
            ruleName = activePredicateSemantic.getAs();
        }
        return ruleName;
    }

    private void setReference(DelayedReference reference, Object singleForeachResult, IModelAdapter modelAdapter,
            ModelElementProxy foreachTargetElement, IModelInjector injector, int position) throws ModelElementCreationException,
            ModelAdapterException {
        // add the parsed part to the object first try to resolve if there is a model element that already
        // exists and can be reused
        reference.setRealValue(injector.createOrResolve(foreachTargetElement, null, null));
        // by default use partition of reference.getModelElement
        if (reference.getModelElement() instanceof EObject && reference.getRealValue() instanceof EObject) {
            ((EObject) reference.getModelElement()).eResource().getContents().add((EObject) reference.getRealValue());
        }
        modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), reference.getRealValue(), position);
    }

    private ModelElementProxy produceSingleForeachUsingParserRule(ObservableInjectingParser parser, DelayedReference reference,
            Object next, String ruleName) throws NoSuchMethodException, UnknownProductionRuleException,
            IllegalAccessException, InvocationTargetException, ModelElementCreationException {
        // invoke the parser to execute the template
        Method methodToCall = parser.getClass().getMethod(ruleName);
        // parser.reset();
        if (!Modifier.isFinal(methodToCall.getModifiers())) {
            throw new UnknownProductionRuleException(ruleName + " is not a production rule in generated Parser.");
        }
        boolean originalResolveProxiesValue = parser.isResolveProxies();
        parser.setResolveProxies(false);
        DelegationParsingObserver delegator = new DelegationParsingObserver();
        IParsingObserver originalObserver = parser.getObserver();
        if (originalObserver != null) {
            delegator.addParsingObserver(originalObserver);
        }
        delegator.addParsingObserver(new ForeachParsingObserver((TextBlock) reference.getTextBlock()));
        parser.setObserver(delegator);

        IModelElementProxy proxyForContextElement = null;
        if (reference.getContextElement() instanceof IModelElementProxy) {
            proxyForContextElement = (IModelElementProxy) reference.getContextElement();
        } else {
            proxyForContextElement = new ResolvedModelElementProxy(reference.getContextElement());
        }
        parser.setCurrentForeachElement(next);
        if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
            parser.addContext(proxyForContextElement);
            if (proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof EObject) {
                parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement, reference.getContextElement(),
                /*
                 * no creation context element needs to be provided here because the proxy has just been created and has not been
                 * added to any other context
                 */
                null);
            }
        } else {
            parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created elsewhere
        }
        try {
            ModelElementProxy parseReturn = (ModelElementProxy) methodToCall.invoke(parser);
            if (parseReturn == null) {
                throw new ModelElementCreationException("Unable to create model element using parse rule " + ruleName
                        + ". Parse errors: " + parser.getInjector().getErrorList());
            }
            return parseReturn;
        } finally {
            parser.getCurrentContextStack().pop();
            parser.setObserver(originalObserver);
            parser.setResolveProxies(originalResolveProxiesValue);
        }
    }

    private PredicateSemantic getActivePredicateFromWhenAsClauses(DelayedReference reference, IModelAdapter modelAdapter,
            Object contextElement, Object currentForeachElement) throws ModelAdapterException {
        for (PredicateSemantic nextPred : reference.getPredicateActionList()) {
            if (nextPred.getWhen() != null) {
                Collection<?> resultBool = modelAdapter.evaluateOCLQuery(currentForeachElement,
                        reference.getKeyValue(), nextPred.getWhen(), contextElement);
                if (resultBool.size() == 1) {
                    Iterator<?> resIt = resultBool.iterator();
                    Object nextBool = resIt.next();
                    if (nextBool instanceof Boolean && (Boolean) nextBool) {
                        return nextPred;
                    }
                }
            } else {
                return nextPred; // no when-clause means "handle always"
            }
        }
        return null;
    }

    /**
     * Tries to find a {@link DelayedReference#getQueryElement() foreach property init} on the delayed reference <code>ref</code>.
     * Assuming that <code>ref</code> is a {@link DelayedReference.ReferenceType#TYPE_FOREACH_PREDICATE} reference,
     * its {@link DelayedReference#getPredicateActionList() predicate list} (the list of when/as/mode clauses}
     * is used to find the position/index of <code>activePredicateSemantic</code>. At this position,
     * the {@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getAs() template} to be used for production
     * is looked up.<p>
     * 
     * If either the reference doesn't have the property init set in its {@link DelayedReference#getQueryElement()},
     * <code>null</code> is returned. This will in particular be the case if the parser is not configured to produce
     * text blocks.
     */
    private Template getTemplateFromPredicateSemantic(PredicateSemantic activePredicateSemantic, DelayedReference ref) {
        int index = ref.getPredicateActionList().indexOf(activePredicateSemantic);
        if (index >= 0 && ((ForeachPredicatePropertyInit) ref.getQueryElement()) != null) {
            int i = 0;

            for (com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic predSem : ((ForeachPredicatePropertyInit) ref
                    .getQueryElement()).getPredicateSemantic()) {
                if (i++ == index) {
                    return predSem.getAs();
                }
            }
            return null;
        } else {
            return null;
        }
    }

}
