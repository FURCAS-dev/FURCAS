/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-04-14 09:00:22 +0200 (Mi, 14 Apr 2010) $
 * Revision: $Revision: 9646 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import antlr.Token;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.TextLocation;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.context.AmbiguousLookupException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * separate class for lenghty algorithmic methods involved with setting references after the parsing process.
 * 
 * @author C5107456
 */
public class DelayedReferencesHelper {

    /** The injector. */
    ModelInjector injector;

    /**
     * Instantiates a new injector helper.
     * 
     * @param injector
     *            the injector
     */
    public DelayedReferencesHelper(IModelInjector injector) {
        super();
        this.injector = (ModelInjector) injector;
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
    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter, ContextManager contextManager,
            ObservableInjectingParser parser) throws ModelAdapterException, ModelElementCreationException {
        Object contextElement = reference.getContextElement();

        if (contextElement instanceof IModelElementProxy) {
            IModelElementProxy proxyContext = (IModelElementProxy) contextElement;
            contextElement = proxyContext.getRealObject();
        }

        if (reference.getType() == DelayedReference.ReferenceType.TYPE_SEMANTIC_PREDICATE) {
            return setDelayedReferenceWithPredicate(reference, modelAdapter, contextManager, contextElement, parser);
        } else if (reference.getType() == DelayedReference.ReferenceType.SEMANTIC_DISAMBIGUATE) {
            return setDelayedReferenceWithSemanticDisambiguate(reference, modelAdapter, contextManager, contextElement, parser);
        }
        if (reference.getOclQuery() != null && reference.getType() != DelayedReference.ReferenceType.CONTEXT_LOOKUP) {
            return setDelayedReferenceWithQuery(reference, modelAdapter, contextManager, contextElement);
        } else {
            return setDelayedReferenceWithLookup(reference, modelAdapter, contextManager, contextElement);
        }
    }

    private boolean setDelayedReferenceWithPredicate(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement, ObservableInjectingParser parser) throws ModelAdapterException {
        try {
            contextElement = getNavigatedContextElementFromReference(reference, modelAdapter, contextManager, contextElement);

            // when the element is a Proxy resolve it first
            resolveModelElementProxy(reference, modelAdapter);
            if (reference.getOclQuery() == null) {
                reportProblem("You must specify an OCL query.", reference.getToken());
                return false;
            }
            Collection<?> result = evaluateForeachOcl((EObject) reference.getModelElement(), reference, modelAdapter, contextElement);
            if (result.isEmpty()) {
                // we need to delete all elements created for this foreach
                if (reference.getTextBlock() != null) {
                    for (ForEachContext fec : new ArrayList<ForEachContext>(
                            ((TextBlock) reference.getTextBlock()).getForEachContext())) {
                        if (fec.getForeachPedicatePropertyInit() != null
                                && fec.getForeachPedicatePropertyInit().equals(reference.getQueryElement())
                                && reference.getModelElement().equals(fec.getSourceModelElement())) {
                            // delete element and fec
                            EcoreUtil.delete(fec.getResultModelElement(), true);
                            EcoreUtil.delete(fec, true);
                        }
                    }
                }
                return false;
            } else {
                HashMap<EObject, EObject> reusableElementsByForeachElement = new HashMap<EObject, EObject>();
                List<ModelElementProxy> producedResults = new ArrayList<ModelElementProxy>();
                // loop over the results to handle them one by one,
                // delete all elements that were created by this foreach but are
                // not valid anymore
                for (Object singleForeachResult : result) {
                    if (!(singleForeachResult instanceof Boolean) || ((Boolean) singleForeachResult).booleanValue()) {
                        // look if there are possible when/as constructs
                        PredicateSemantic activePredicateSemantic = getActivePredicateFromWhenAsClauses(reference,
                                modelAdapter, contextElement, singleForeachResult);
                        Template tmpl = getTemplateFromPredicateSemantic(activePredicateSemantic, reference);
                        ModelElementProxy foreachTargetElement = produceForOneForeachResult(reference, modelAdapter,
                                contextElement, parser, reusableElementsByForeachElement, singleForeachResult, activePredicateSemantic, tmpl);
                        updateForeachContexts(reference, reusableElementsByForeachElement, singleForeachResult, tmpl);
                        if (foreachTargetElement != null) {
                            producedResults.add(foreachTargetElement);
                            setReference(reference, singleForeachResult, modelAdapter,
                                    reusableElementsByForeachElement.get(singleForeachResult), foreachTargetElement);
                        }
                    }
                }
            }
        } catch (Exception e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        }
        return true;
    }

    /**
     * Determines the production rule for the <code>singleForeachResult</code> by
     * {@link #getActivePredicateFromWhenAsClauses(DelayedReference, IModelAdapter, Object, Object) scanning} for
     * the applicable predicate semantic. If found, the parser is used to execute the production rule.
     * The result is assigned to the feature as defined by the <code>reference</code> using
     * {@link #setReference(ObservableInjectingParser, DelayedReference, Object, String, IModelAdapter, EObject)}.<p>
     * @param singleForeachResult
     *            the current foreach-expression's result to produce an element for
     * @param activePredicateSemantic TODO
     * @param tmpl TODO
     * 
     * @return <code>false</code> in case the foreach-result to be handled is not properly typed or doesn't match any
     *         existing predicate semantics so that no production rule can be identified; <code>true</code> in case of
     *         successful production.
     */
    private ModelElementProxy produceForOneForeachResult(DelayedReference reference, IModelAdapter modelAdapter,
            Object contextElement, ObservableInjectingParser parser,
            HashMap<EObject, EObject> reusableElementsByForeachElement, Object singleForeachResult, PredicateSemantic activePredicateSemantic, Template tmpl) throws ModelAdapterException,
            SyntaxElementException, NoSuchMethodException, UnknownProductionRuleException, IllegalAccessException,
            InvocationTargetException, ModelElementCreationException {
        ModelElementProxy foreachTargetElement = null;
        if (!(singleForeachResult instanceof Boolean) || ((Boolean) singleForeachResult).booleanValue()) {
            // look if there are possible when/as constructs
            String ruleName = null;
            if (activePredicateSemantic == null) {
                // no matching when/as combination; perform default handling:
                if (singleForeachResult instanceof EObject) {
                    EClass foreachElementType = ((EObject) singleForeachResult).eClass();
                    // get the template
                    tmpl = TcsUtil.findTemplate(foreachElementType, reference.getMode(), parser.getInjector().getModelAdapter()
                            .getPRIPartitions(foreachElementType.eResource().getResourceSet(), parser.getLanguageId()));
                    // get the rule name from the template
                    ruleName = reference.getRuleNameFinder().getRuleName(tmpl, reference.getMode());
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
            if (ruleName == null) {
                throw new UnknownProductionRuleException("At least one as parameter is needed in that case.");
            }
            foreachTargetElement = produceSingleForeachUsingParserRule(parser, reference, singleForeachResult, ruleName);
        }
        return foreachTargetElement;
    }

    private void updateForeachContexts(DelayedReference reference,
            HashMap<EObject, EObject> reusableElementsByForeachElement, Object singleForeachResult, Template tmpl) {
        if (reference.getTextBlock() != null) {
            for (ForEachContext fec : new ArrayList<ForEachContext>(
                    ((TextBlock) reference.getTextBlock()).getForEachContext())) {
                if (fec.getForeachPedicatePropertyInit().equals(reference.getQueryElement())
                        && reference.getModelElement().equals(fec.getSourceModelElement())) {
                    // FIXME !!! If multiple results, this deletes the previously created element !!!
                    if (fec.getContextElement() != singleForeachResult) {
                        // element was responsible for creating this result but
                        // is not in the foreach anymore thus delete element and fec
                        EcoreUtil.delete(fec.getResultModelElement(), true);
                        EcoreUtil.delete(fec, true);
                    } else {
                        EObject ce = fec.getContextElement();
                        if (ce.equals(singleForeachResult)) {
                            // the current FEC was created for this object
                            // thus we need to check if the type fits
                            if (fec.getResultModelElement() == null) {
                                EcoreUtil.delete(fec, true);
                            } else {
                                if (fec.getResultModelElement().eClass().equals(tmpl.getMetaReference())) {
                                    // we can reuse the element as the type fits
                                    // TODO check how we can incrementally decide which attributes
                                    // of the element should be set or if we need to reset all the
                                    // attributes in order to let them be set new
                                    reusableElementsByForeachElement.put((EObject) singleForeachResult,
                                            fec.getResultModelElement());
                                } else {
                                    EcoreUtil.delete(fec.getResultModelElement(), true);
                                    EcoreUtil.delete(fec, true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Collection<?> evaluateForeachOcl(EObject sourceElement, DelayedReference reference, IModelAdapter modelAdapter,
            Object contextElement) throws ModelAdapterException {
        String flattenOCL = appendFlattenToOclQuery(reference.getOclQuery());
        // evaluate the predicate by OCL, return value is a list of objects
        Collection<?> result = modelAdapter.evaluateOCLQuery(sourceElement, reference.getKeyValue(),
                flattenOCL, contextElement);
        return result;
    }
    
    private void setReferenceForSemanticDisambiguatedRule(
    					ObservableInjectingParser parser, DelayedReference reference,
    					String ruleName, IModelAdapter modelAdapter)
    					throws SecurityException, UnknownProductionRuleException,
    					NoSuchMethodException, IllegalArgumentException,
    					IllegalAccessException, InvocationTargetException,
    					ModelElementCreationException, ModelAdapterException {
    			// invoke the parser to execute the template
    			Method methodToCall = parser.getClass().getMethod(ruleName, String.class, Object.class, Token.class);
    			if (!Modifier.isFinal(methodToCall.getModifiers())) {
    			    throw new UnknownProductionRuleException(ruleName
    				    + " is not a production rule in generated Parser.");
    			}
    			boolean originalResolveProxiesValue = parser.isResolveProxies();
    			parser.setResolveProxies(false);
    			parser.reset();

    			IModelElementProxy proxyForContextElement = null;
    			if (reference.getContextElement() instanceof IModelElementProxy) {
    			    proxyForContextElement = (IModelElementProxy) reference.getContextElement();
    			} else {
    			    proxyForContextElement = new ResolvedModelElementProxy(reference.getContextElement());
    			}

    			if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
    		            parser.addContext(proxyForContextElement);
    		            if(proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof EObject) {
    		                parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement,  reference.getContextElement(),   /*
    		                         * no creation context element needs to be provided here because the proxy has just been created and has
    		                         * not been added to any other context
    		                         */null);
    		            }
    		        } else {
    		            parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created elsewhere
    		        }
    			try {
    				parser.getTokenStream().seek(reference.getFirstToken().getTokenIndex());
    				Object parseReturn;
    			    if(reference.isSemanticDisambiguatedOperatorRule()) {
                        parseReturn = methodToCall.invoke(parser,
    			    			reference.getPropertyName(),
    			    			reference.getOpTemplateLefthand(),
    			    			reference.getFirstToken());
                    } else {
                        parseReturn = methodToCall.invoke(parser);
                    }
    			    // add the parsed part to the object
    			    parser.setResolveProxies(originalResolveProxiesValue);
    			    reference.setRealValue(injector.createOrResolve((ModelElementProxy) parseReturn, null, null));
    			    // by default use partition of reference.getModelElement
    			    if (reference.getModelElement() instanceof EObject
    				    && reference.getRealValue() instanceof EObject) {
    				((EObject) reference.getContextElement()).eResource()
    					.getContents().add((EObject) reference.getRealValue());
    			    }
    			    
    			    ModelElementProxy oldModelElement = ((ModelElementProxy)reference.getModelElement());
    			    oldModelElement.setRealObject(reference.getRealValue());
    			    Object parentProxy = oldModelElement.getParent();
    			    Object parentElement = ((ModelElementProxy)parentProxy).getRealObject();
    			    String parentPropertyName = oldModelElement.getParentPropertyName();
    			    modelAdapter.set(parentElement, parentPropertyName, reference
    			    	    		    .getRealValue());
    			} finally {
    			    if (reference.hasContext()) {
    				parser.leaveContext();
    			    }
    			    parser.getCurrentContextStack().pop();
    			}
    }

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

    private void setReference(DelayedReference reference, Object singleForeachResult, IModelAdapter modelAdapter,
            EObject reusableResultElement, ModelElementProxy foreachTargetElement) throws ModelElementCreationException,
            ModelAdapterException {
        // add the parsed part to the object
        // first try to resolve if there is a model element that already
        // exists and can be reused
        // EObject candidate = findCandidateFromProxy((EObject)
        // reference.getModelElement(),
        // reference.getPropertyName(), parseReturn, (EObject)
        // reference.getElementForSelf(),//(EObject) next,
        // (ForeachPredicatePropertyInit) reference.getQueryElement(),
        // (TextBlock) reference.getTextBlock());
        if (reusableResultElement != null) {
            // element already exists so we can reuse it
            reference.setRealValue(reusableResultElement);
            foreachTargetElement.setRealObject(reusableResultElement);
            return;
        } else {
            reference.setRealValue(injector.createOrResolve(foreachTargetElement, null, null));
            // by default use partition of reference.getModelElement
            if (reference.getModelElement() instanceof EObject && reference.getRealValue() instanceof EObject) {
                ((EObject) reference.getModelElement()).eResource().getContents()
                        .add((EObject) reference.getRealValue());
            }
            modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), reference.getRealValue());
            if (reference.getTextBlock() != null) {
                addForEachContext((TextBlock) reference.getTextBlock(), (EObject) reference.getModelElement(),
                        (EObject) singleForeachResult, (ForeachPredicatePropertyInit) reference.getQueryElement(),
                        (EObject) reference.getRealValue());
            }
        }
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

    private static void addForEachContext(TextBlock contextBlock, EObject sourceModelElement, EObject currentForEachElement,
            ForeachPredicatePropertyInit sequenceElement, EObject resultElement) {
        boolean forEachContextExists = false;

        // FIXME: The contextBlock may be null if there was a foreach that was
        // created by another foreach
        // then the textblock is never set. Find out when and where this could
        // be done

        for (ForEachContext forEachContext : contextBlock.getForEachContext()) {
            if (forEachContext.getForeachPedicatePropertyInit().equals(sequenceElement)) {
                if (forEachContext.getSourceModelElement().equals(sourceModelElement)) {
                    if (forEachContext.getContextElement() != currentForEachElement) {
                        forEachContext.setContextElement(currentForEachElement);
                        forEachContext.setResultModelElement(resultElement);
                    }
                    forEachContextExists = true;
                }
            }
        }
        if (!forEachContextExists) {
            ForEachContext newContext = TextblocksFactory.eINSTANCE.createForEachContext();
            newContext.setForeachPedicatePropertyInit(sequenceElement);
            newContext.setSourceModelElement(sourceModelElement);
            newContext.setContextElement(currentForEachElement);
            newContext.setResultModelElement(resultElement);
            contextBlock.getForEachContext().add(newContext);
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

    private String appendFlattenToOclQuery(String ocl) {
     	String flattenOCL = "";
     	if (ocl.startsWith("OCL:")) {
     	    flattenOCL = "OCL:(" + ocl.substring(4) + ")->asSequence()->flatten()";
     	} else {
     	    flattenOCL = "OCL:(" + ocl + ")->asSequence()->flatten()";
     	}
     	return flattenOCL;
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

    private boolean setDelayedReferenceWithQuery(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement) throws ModelAdapterException {
        // TODO validate no obsolete property args are set
        try {
            contextElement = getNavigatedContextElementFromReference(reference, modelAdapter, contextManager, contextElement);
            if (reference.getModelElement() instanceof ModelElementProxy) {
                ModelElementProxy proxy = (ModelElementProxy) reference.getModelElement();
                if (proxy.getRealObject() == null) {
                    Object result;
                    result = modelAdapter.createOrResolveElement(proxy.getType(), proxy.getAttributeMap(), null, null, false,
                            true);
                    if (result instanceof EObject) {
                        reference.setModelElement(result);
                    }
                } else {
                    reference.setModelElement(proxy.getRealObject());
                }
            }
            Object result = modelAdapter.setReferenceWithOCLQuery(reference.getModelElement(), reference.getPropertyName(),
                    reference.getKeyValue(), reference.getOclQuery(), contextElement, reference.getCurrentForeachElement());
            if (result == null) {
                String message = "Referenced ModelElement for query '" + reference.getOclQuery()
                        + "' was not found for property '" + reference.getPropertyName() + "' of "
                        + reference.getModelElement().getClass().getName() + " with key value: " + reference.getKeyValue();
                reportProblem(message, reference.getToken());
                return false;
            } else {
                reference.setRealValue(result);
                return true;
            }
        } catch (ReferenceSettingException rse) {
            reportProblem(rse.getMessage(), reference.getToken());
            return false;
        } catch (LookupPathNavigationException lpne) {
            reportProblem(lpne.getMessage(), reference.getToken());
            return false;
        } catch (ModelElementCreationException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        }

    }

    private static Object getNavigatedContextElementFromReference(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement) throws ModelAdapterException, LookupPathNavigationException {
        // check if something like "#context(..)" is contained in the query
        Matcher match = ContextAndForeachHelper.contextPattern.matcher(reference.getOclQuery());
        if (match.find()) {
            String occurence = match.group();
            if (match.groupCount() >= 2) {
                // check whether all occurences refer to the
                // same context element
                while (match.find()) {
                    if (!match.group().equals(occurence)) {
                        throw new ModelAdapterException(
                                "Within a query only references to the same context element are supported. Found at least on other usage then the first:"
                                        + occurence + " != " + match.group(1));
                    }
                }
            }

            String[] path = new String[] { occurence };
            // navigate to an object, to later use that objects
            // context as query context
            Object navigatedObject = navigateLookIn(contextElement, reference.getModelElement(), path, true, modelAdapter,
                    reference.getToken(), contextManager);
            if (navigatedObject instanceof IModelElementProxy) {
                contextElement = contextManager.getContextForElement(navigatedObject);
            } else {
                contextElement = contextManager.getContextForElement(new ResolvedModelElementProxy(navigatedObject));
            }

        }
        return contextElement;
    }

    /**
     * default way of setting references, instead of using MQL query
     * 
     * @param reference
     * @param modelAdapter
     * @param referenceContext
     * @param contextByElement
     * @throws ModelAdapterException
     * @throws ModelElementCreationException
     */
    private boolean setDelayedReferenceWithLookup(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object referenceContext) throws ModelAdapterException, ModelElementCreationException {
        boolean referenceSuccessfullySet = false;

        boolean problemReported = false;

        if ("always".equals(reference.getAutoCreate())) {
            create(reference, modelAdapter, contextManager, referenceContext); // may throw exception
            referenceSuccessfullySet = true;
        } else { // autocreate = "ifMissing" or "never"
            try {
                if ("#all".equals(reference.getLookIn())) {
                    Object val = setReferenceUsingModelAdapter(reference, modelAdapter);
                    if (val != null) {
                        reference.setRealValue(val);
                        referenceSuccessfullySet = true;
                    }

                    // original TCS code
                    // Object val = null;
                    // // Search for model element in modelhandler of type
                    // valueTypeName which has keyProperty keyname = keyValue
                    // for(Iterator<Object> i =
                    // modelHandler.setReference(reference.getValueTypeName(),
                    // null, null, null).iterator() ; i.hasNext() && (val ==
                    // null) ; ) {
                    // Object ame = i.next();

                    // Object toCompare = modelHandler.get(ame,
                    // reference.getKeyName());
                    // if (toCompare.equals(reference.getKeyValue())) {
                    // val = ame;
                    // break;
                    // }
                    // }

                    // if (val != null) {
                    // reference.setRealValue(val);
                    // modelHandler.set(reference.getObject(),
                    // reference.getPropertyName(), val);
                    // done = true;
                    // }
                } else if ((reference.getLookIn() != null)) { // lookIn is
                    // neither #all
                    // nor null
                    try {
                        String[] path = reference.getLookIn().split("\\.");
                        // navigate to an object, to later use that objects
                        // context as lookup context
                        Object navigatedObject = navigateLookIn(referenceContext, reference.getModelElement(), path, true,
                                modelAdapter, reference.getToken(), contextManager);
                        Object navigatedContext = contextManager.getContextForElement(navigatedObject);
                        if (contextManager.hasInTextContext(navigatedContext)) {
                            // context object is represented in contextManager,
                            // as it has a representation in the document
                            referenceSuccessfullySet = setReferenceInContext(reference, modelAdapter, navigatedContext,
                                    contextManager);
                        }
                        if (referenceSuccessfullySet == false) {
                            Object sourceElement = reference.getModelElement();
                            // we found an element, but this element is not in
                            // the context of the parsed file
                            // this means only the modelAdapter may be able to
                            // set the reference
                            Object result = modelAdapter.setReferenceWithContextLookup(sourceElement, reference.getPropertyName(),
                                    reference.getValueTypeName(), reference.getKeyName(), reference.getKeyValue(),
                                    navigatedObject);
                            if (result != null) {
                                if (!(result instanceof Collection<?>) || (((Collection<?>) result).size() == 0)) {
                                    reference.setRealValue(result);
                                    referenceSuccessfullySet = true;
                                } else {
                                    problemReported = true;
                                    reportProblem("No instance of " + asModelName(reference.getValueTypeName())
                                            + " in context path " + reference.getLookIn() + "=" + navigatedObject + " with '"
                                            + reference.getKeyName() + "' = '" + reference.getKeyValue() + "'",
                                            reference.getToken());
                                }
                            } else {
                                reportProblem("No instance of " + asModelName(reference.getValueTypeName()) + " in context path "
                                        + reference.getLookIn() + "=" + navigatedObject + " with '" + reference.getKeyName()
                                        + "' = '" + reference.getKeyValue() + "'", reference.getToken());
                            }
                        }
                    } catch (LookupPathNavigationException e) {
                        problemReported = true;
                        reportProblem(e.getMessage(), e.getToken());
                    }
                } else { // lookIn is null
                    // try it for current context and all super contexts thereof
                    Object contextElement = referenceContext;
                    referenceSuccessfullySet = setReferenceInContext(reference, modelAdapter, contextElement, contextManager);
                }

            } catch (AmbiguousLookupException e) {
                problemReported = true;
                reportProblem("Found several instances suitable as reference: " + reference /*
                                                                                             * + ":" + e.getOriginal() + " and " +
                                                                                             * e.getDuplicate() +
                                                                                             * " in context of " + e.getContext()
                                                                                             */, reference.getToken());
            }
        } // end if autoCreate = ifmissing or never

        if (!referenceSuccessfullySet) {
            if (!problemReported) {
                if (!"never".equals(reference.getAutoCreate())) {
                    create(reference, modelAdapter, contextManager, referenceContext);
                    referenceSuccessfullySet = true;
                } else {
                    Object result = setReferenceUsingModelAdapter(reference, modelAdapter);
                    if (result == null) {
                        String message = "Referenced " + asModelName(reference.getValueTypeName()) + " with '"
                                + reference.getKeyName() + "' = '" + reference.getKeyValue() + "' was not found for property '"
                                + reference.getPropertyName() + "' of " + reference.getModelElement().getClass().getName()
                                + " with key value: " + reference.getKeyValue();
                        ;
                        reportProblem(message, reference.getToken());
                        referenceSuccessfullySet = false;
                    } else {
                        referenceSuccessfullySet = true;
                    }
                }
            }

        }

        // real value might have been set during the cause of setting the
        // reference (Same as success?)
        if (reference.getRealValue() != null) {
            if (reference.isImportContext()) {
                contextManager.setContextImport(reference.getModelElement(), reference.getRealValue());
            }
        }
        return referenceSuccessfullySet;
    }

    /**
     * @param reference
     * @param modelAdapter
     * @return
     * @throws ModelAdapterException
     * @throws ReferenceSettingException
     */
    private Object setReferenceUsingModelAdapter(DelayedReference reference, IModelAdapter modelAdapter)
            throws ModelAdapterException, ReferenceSettingException {

        // attempt to let adapter resolve reference outside parsing context
        Object result = modelAdapter.setReferenceWithLookup(reference.getModelElement(), reference.getPropertyName(),
                reference.getValueTypeName(), reference.getKeyName(), reference.getKeyValue());
        return result;
    }
    
    private boolean setDelayedReferenceWithSemanticDisambiguate(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement, ObservableInjectingParser parser) {
        try {
            Iterator<SemanticDisambRuleData> dataIt = reference.getSemRulData().iterator();
            boolean resultFound = false;
            while (dataIt.hasNext()) {
                SemanticDisambRuleData nextRuleData = dataIt.next();
                int beginRef = nextRuleData.getOcl().indexOf("${");
                String flattenOCL = appendFlattenToOclQuery(nextRuleData.getOcl());
                if (beginRef >= 0) {
                    String semReference = nextRuleData.getOcl().substring(beginRef,
                            nextRuleData.getOcl().indexOf('}', beginRef + 1) + 1);
                    String replacedBy;
                    // TODO support other types than string
                    if (isBasicType(reference.getSemanticObject())) {
                        replacedBy = "'" + reference.getSemanticObject().toString() + "'";
                    } else {
                        replacedBy = "?";
                    }
                    String replacedOCL = nextRuleData.getOcl().replaceAll(Pattern.quote(semReference), replacedBy);
                    if (replacedOCL.contains("#source")) {
                        replacedOCL = replacedOCL.replace("#source", "self");
                    }
                    flattenOCL = appendFlattenToOclQuery(replacedOCL);
                }

                // evaluate the predicate by OCL, return value is a list of
                // objects
                Object currentContextElement;
                if (nextRuleData.getOcl().contains("#source") && reference.isSemanticDisambiguatedOperatorRule()) {
                    if (reference.getOpTemplateLefthand() instanceof ModelElementProxy) {
                        currentContextElement = ((ModelElementProxy) reference.getOpTemplateLefthand()).getRealObject();
                    } else {
                        currentContextElement = reference.getOpTemplateLefthand();
                    }
                } else {
                    currentContextElement = contextElement;
                }
                Collection<?> result = modelAdapter.evaluateOCLQuery(currentContextElement, null, flattenOCL,
                        currentContextElement);
                // if there is no result it will be null
                if (result.isEmpty()) {
                    resultFound = false;
                } else {
                    Iterator<?> resultIt = result.iterator();
                    // loop over the results to handle them one by one
                    boolean ruleFound = false;
                    while (resultIt.hasNext()) {
                        Object nextResult = resultIt.next();
                        if (nextResult instanceof Boolean) {
                            if (((Boolean) nextResult).booleanValue()) {
                                if (ruleFound) {
                                    reportProblem("The semantic disambiguate matches more than one rule",
                                            reference.getToken());
                                    return false;
                                }
                                ruleFound = true;
                                resultFound = true;
                                setReferenceForSemanticDisambiguatedRule(parser, reference, nextRuleData.getRule(),
                                        modelAdapter);
                            }
                        } else {
                            reportProblem("The rule " + nextRuleData.getRule()
                                    + " has a semantic disambiguate which does not evaluate to a bool value",
                                    reference.getToken());
                            return false;
                        }
                    }
                }
            }
            if (!resultFound) {
                reportProblem("The semantic disambiguate did not match any rule", reference.getToken());
                return false;
            }
        } catch (IllegalAccessException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (SecurityException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (IllegalArgumentException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (UnknownProductionRuleException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (NoSuchMethodException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (InvocationTargetException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (ModelElementCreationException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        } catch (ModelAdapterException e) {
            reportProblem(e.getMessage(), reference.getToken());
            return false;
        }
        return true;
    }

	// TODO support the other basic types as well
	private boolean isBasicType(Object ref) {
		if (ref instanceof String) {
            return true;
        }
		return false;
	}
    // /**
    // * reports a problem with a reference.
    // *
    // * @param message the string
    // */
    // private void reportProblem(String message, int line, int position) {
    // // TODO carry the token of reference to give the location of the error.
    // injector.addError(new ParsingError(message, line, position, line,
    // position));
    // }
    //
    /**
     * reports a problem with a reference.
     * 
     * @param string
     *            the string
     */
    private void reportProblem(String string, ANTLR3LocationToken token) {
        injector.addError(new ParsingError(string, token));
    }

    /**
     * check elements within context for one element that could be the right referred element (correct type, keyfield = keyvalue).
     * 
     * @param reference
     *            the reference
     * @param modelAdapter
     *            the model handler
     * @param contextElement
     *            the context
     * @param contextManager
     * 
     * @return true, if do it for context
     * 
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws AmbiguousLookupException
     */
    private boolean setReferenceInContext(DelayedReference reference, IModelAdapter modelAdapter, Object contextElement,
            ContextManager contextManager) throws ModelAdapterException, AmbiguousLookupException {
        // System.out.println("Setting delayed reference " + reference);
        // Candidate for being set as referred object

        List<String> valueTypeName = reference.getValueTypeName();
        Object keyValue = reference.getKeyValue();
        String keyName = reference.getKeyName();

        Object candidate = null;

        if (reference.getType() == DelayedReference.ReferenceType.CONTEXT_LOOKUP) {
            candidate = modelAdapter.setReferenceWithOCLQuery(contextElement, reference.getPropertyName(), reference.getKeyValue(),
                    reference.getOclQuery().replaceAll("self.", "#context"), reference.getTextBlock(),
                    reference.getCurrentForeachElement());
        } else {
            candidate = contextManager.findCandidatesInContext(modelAdapter, contextElement, valueTypeName, keyName, keyValue);
        }

        if (candidate != null) {
            reference.setRealValue(candidate);
            modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), candidate);
            return true;
        } else {
            // recursion upwards, try parent context
            // Context parentContext = context.parent();
            if (hasCyclicContextParents(contextManager, contextElement)) {
                throw new RuntimeException("For some reason " + contextElement + " has a cycle in its parent context hierarchy");
            }
            Object parentContext = contextManager.getContextParent(contextElement);
            if (parentContext != null) {
                return setReferenceInContext(reference, modelAdapter, parentContext, contextManager);
            }
        }

        return false;
    }

    private boolean hasCyclicContextParents(ContextManager contextManager, Object contextElement) {
        Set<Object> parents = new HashSet<Object>();
        Set<Object> newParents = new HashSet<Object>();
        newParents.add(contextElement);
        while (newParents.size() > 0) {
            Set<Object> newParentsParents = new HashSet<Object>();
            for (Object parent : newParents) {
                if (parents.contains(parent)) {
                    return true;
                } else {
                    parents.add(parent);
                    Object newParent = contextManager.getContextParent(parent);
                    if (newParent != null) {
                        newParentsParents.add(newParent);
                    }
                }
            }
            newParents = newParentsParents;
        }
        return false;
    }

    /**
     * Creates the referred element, sets the key value, and sets it as reference target for the original reference
     * 
     * @param reference
     *            the reference
     * @param modelAdapter
     *            the model handler
     * @param contextManager
     * @param referenceContext
     * 
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws ModelElementCreationException
     */
    private void create(DelayedReference reference, IModelAdapter modelAdapter, ContextManager contextManager,
            Object referenceContext) throws ModelAdapterException, ModelElementCreationException {
        // create
        Object ro = null;
        if (reference.getCreateAs() != null) {
            ro = injector.doCreate(reference.getCreateAs(), reference.getKeyName(), reference.getKeyValue());
        } else {
            ro = injector.doCreate(reference.getValueTypeName(), reference.getKeyName(), reference.getKeyValue());
        }
        reference.setRealValue(ro);

        // set reference
        Object modelElement = reference.getModelElement();
        modelAdapter.set(modelElement, reference.getPropertyName(), ro);
        try {
            TextLocation location = new TextLocation(reference.getToken());
            injector.setLocation(ro, location);
        } catch (Exception e) {
        }

        if (reference.getCreateIn() != null) {
            try {
                String[] path = reference.getCreateIn().split("\\.");
                Object containingObject = navigateLookIn(referenceContext, reference.getModelElement(), path, false,
                        modelAdapter, reference.getToken(), contextManager);
                modelAdapter.set(containingObject, path[path.length - 1], ro);
                contextManager.addToContext(referenceContext, ro);
            } catch (LookupPathNavigationException e) {
                reportProblem("Path could not be resolved " + reference.getCreateIn() + " : " + e.getMessage(),
                        reference.getToken());
            }
        }

        else if ((reference.getLookIn() != null) && !reference.getLookIn().equals("#all")) {
            try {
                String[] path = reference.getLookIn().split("\\.");
                Object e = navigateLookIn(referenceContext, reference.getModelElement(), path, false, modelAdapter,
                        reference.getToken(), contextManager);
                modelAdapter.set(e, path[path.length - 1], ro);
                contextManager.addToContext(referenceContext, ro);
            } catch (LookupPathNavigationException e) {
                // reportProblem(e.getMessage(), e.getToken());
                reportProblem("Path could not be resolved " + reference.getLookIn() + " : " + e.getMessage(),
                        reference.getToken());
            }
        }
    }

    /**
     * Returns an element in the context tree according to path notation.
     * 
     * @param object
     * @param object
     * 
     * @param path
     *            the path
     * @param includingLastPathElement
     *            whether to consider the last element of the path
     * @param token
     * @param contextManager
     * 
     * @return the object
     * @throws ModelAdapterException
     * @throws LookupPathNavigationException
     */
    private static Object navigateLookIn(Object contextElement, Object modelElement, String[] path,
            boolean includingLastPathElement, IModelAdapter modelAdapter, ANTLR3LocationToken token, ContextManager contextManager)
            throws ModelAdapterException, LookupPathNavigationException {

        Object returnModelElement = modelElement;

        if (path == null || path.length == 0) {
            return returnModelElement;
        }

        int startIndex = 0;
        if (path[0].startsWith("#context")) { // do not start path navigation at
            // current model element, but
            // rather at context
            String optionalTag = getTag(path[0].substring("#context".length()), token);
            if (optionalTag != null) {
                modelElement = contextManager.getTaggedContext(contextElement, optionalTag);

            } else {
                modelElement = contextElement;
            }
            if (modelElement == null) {
                throw new LookupPathNavigationException("Lookup path context is null for " + path[0], token);
            }
            startIndex = 1; // jump over this in loop
        } else {
            if (modelElement == null) {
                throw new LookupPathNavigationException("Lookup path starting point is null", token);
            }
        }

        for (int i = startIndex; (i < path.length - (includingLastPathElement ? 0 : 1)); i++) {
            String nextPathStep = path[i];
            if (nextPathStep.equals("#context")) {
                throw new LookupPathNavigationException("'#context' keyword may only be used as root of path: "
                        + Arrays.toString(path), token);
            } else if (nextPathStep.equals("#all")) {
                throw new LookupPathNavigationException("'#all' keyword can't be used with more path elements "
                        + Arrays.toString(path), token);
            } else {
                // need to continue along path
                Object v = modelAdapter.get(modelElement, nextPathStep);
                if (v != null) { // && modelAdapter.isAModelElement(v)) { // let
                    // this cause an error later
                    modelElement = v;
                } else { // can't continue on path
                    throw new LookupPathNavigationException("Model element feature " + modelElement + "." + nextPathStep
                            + " is null for path " + Arrays.toString(path), token);
                }
            }
        }
        return modelElement;
    }

    /**
     * expects a String like "(helloWorld )" and returns "helloWorld" or an empty String. else throws Exception
     * 
     * @param substring
     * @param token
     * @return
     */
    private static String getTag(String substring, ANTLR3LocationToken token) throws LookupPathNavigationException {
        if (substring == null || substring.trim().length() == 0) {
            return null;
        }
        String trimString = substring.trim();
        if (trimString.startsWith("(") && trimString.endsWith(")")) {
            String result = trimString.substring(1, trimString.length() - 1).trim();
            if (result == null || result.length() == 0) {
                return null;
            }
            return result;
        } else {
            throw new LookupPathNavigationException("Illegasuuffix after '#context'", token);
        }

    }

    private static String asModelName(List<String> names) {
        if (names == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            builder.append(name);
            if (iterator.hasNext()) {
                builder.append("::");
            }
        }
        return builder.toString();

    }
}
