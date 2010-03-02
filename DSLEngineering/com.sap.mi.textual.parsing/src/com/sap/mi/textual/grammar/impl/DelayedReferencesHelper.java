/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-02-26 15:24:24 +0100 (Fr, 26 Feb 2010) $
 * Revision: $Revision: 9496 $
 * Author: $Author: d043530 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import tcs.Template;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.implementation.ResolvedModelElementProxy;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.context.AmbiguousLookupException;
import com.sap.mi.textual.grammar.impl.context.ContextManager;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

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
    public DelayedReferencesHelper(ModelInjector injector) {
	super();
	this.injector = injector;
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
    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter,
	    ContextManager contextManager, ObservableInjectingParser parser) throws ModelAdapterException,
	    ModelElementCreationException {
	Object contextElement = reference.getContextElement();

	if (contextElement instanceof IModelElementProxy) {
	    IModelElementProxy proxyContext = (IModelElementProxy) contextElement;
	    contextElement = proxyContext.getRealObject();
	}

	if (reference.getType() == DelayedReference.SEMANTIC_PREDICATE) {
	    return setDelayedReferenceWithPredicate(reference, modelAdapter, contextManager, contextElement, parser);
	}
	if (reference.getOclQuery() != null && reference.getType() != DelayedReference.CONTEXT_LOOKUP) {
	    return setDelayedReferenceWithQuery(reference, modelAdapter, contextManager, contextElement);
	} else {
	    return setDelayedReferenceWithLookup(reference, modelAdapter, contextManager, contextElement);
	}
    }

    private boolean setDelayedReferenceWithPredicate(DelayedReference reference, IModelAdapter modelAdapter,
	    ContextManager contextManager, Object contextElement, ObservableInjectingParser parser)
	    throws ModelAdapterException {
	try {
	    contextElement = getNavigatedContextElementFromReference(reference, modelAdapter, contextManager,
		    contextElement);

	    // when the element is a Proxy resolve it first
	    resolveModelElementProxy(reference, modelAdapter);
	    if (reference.getOclQuery() == null) {
		reportProblem("You must specify an OCL query.", reference.getToken());
		return false;
	    }
	    String flattenOCL = appendFlattenToOclQuery(reference);
	    // evaluate the predicate by OCL, return value is a list of objects
	    Collection<?> result = modelAdapter.getPredicateOclReference(reference.getModelElement(), reference
		    .getPropertyName(), reference.getKeyValue(), flattenOCL, contextElement);
	    // if there is no result it will be null
	    if (result == null) {
		return false;
	    } else {
		Iterator<?> resultIt = result.iterator();
		// loop over the results to handle them one by one
		while (resultIt.hasNext()) {
		    Object next = resultIt.next();
		    if (!(next instanceof Boolean) || ((Boolean) next).booleanValue()) {
			// look if there are possible when/as constructs
			String ruleName = getRuleNameFromWhenAsClauses(reference, modelAdapter, contextElement);
			if (ruleName == null) {
			    // no matching when/as combination; perform default handling:
			    if (next instanceof RefObject) {
				MofClass myResultObj = (MofClass) ((RefObject) next).refMetaObject();
				// get the template
				Template tmpl = findTemplate(myResultObj, reference.getMode(), parser.getInjector()
					.getModelAdapter().getPRIPartitions(myResultObj.get___Connection(),
						parser.getLanguageId()));
				// get the rule name from the template
				ruleName = reference.getRuleNameFinder().getRuleName(tmpl, reference.getMode());
			    } else {
				// handle the base types
				if (!(next instanceof String) || !(next instanceof Number)) {
				    reportProblem("The OCL element " + next + " cannot be used.", reference.getToken());
				    return false;
				}
			    }
			}
			if (ruleName == null) {
			    reportProblem("At least one as parameter is needet in that case.", reference.getToken());
			    return false;
			}
			setReference(parser, reference, next, ruleName, modelAdapter);
		    }
		}
	    }
	} catch (LookupPathNavigationException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (SecurityException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (NoSuchMethodException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (UnknownProductionRuleException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (IllegalArgumentException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (IllegalAccessException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (InvocationTargetException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	} catch (ModelElementCreationException e) {
	    reportProblem(e.getMessage(), reference.getToken());
	    return false;
	}
	return true;
    }
	
    private void setReference(ObservableInjectingParser parser, DelayedReference reference, Object next,
	    String ruleName, IModelAdapter modelAdapter) throws ModelAdapterException, SecurityException,
	    NoSuchMethodException, UnknownProductionRuleException, IllegalArgumentException, IllegalAccessException,
	    InvocationTargetException, ModelElementCreationException {
	// invoke the parser to execute the template
	Method methodToCall = parser.getClass().getMethod(ruleName);
	//parser.reset();
	if (!Modifier.isFinal(methodToCall.getModifiers())) {
	    throw new UnknownProductionRuleException(ruleName
		    + " is not a production rule in generated Parser.");
	}
	boolean originalResolveProxiesValue = parser.isResolveProxies();
	parser.setResolveProxies(false);
	
	IModelElementProxy proxyForContextElement = null;
	if (reference.getContextElement() instanceof IModelElementProxy) {
	    proxyForContextElement = (IModelElementProxy) reference.getContextElement();
	} else {
	    proxyForContextElement = new ResolvedModelElementProxy(reference.getContextElement());
	}
	
	parser.setCurrentForeachElement(next);
	if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
            parser.addContext(proxyForContextElement);
            if(proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof RefObject) {
                parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement,  reference.getContextElement(),   /*
                         * no creation context element needs to be provided here because the proxy has just been created and has
                         * not been added to any other context
                         */null);
            }
            
        } else {
            parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created elsewhere
        }
	
	
	if (reference.hasContext() && next instanceof RefObject) {
	    ResolvedModelElementProxy proxyForNext = new ResolvedModelElementProxy(next);
	    if (parser.getContextManager().getContextForElement(next) == null) {
		parser.addContext(proxyForNext);
		parser.getContextManager().notifyProxyResolvedWith(proxyForNext, next,
		/*
		 * no creation context element needs to be provided here because the proxy has just been created and has
		 * not been added to any other context
		 */null);
	    } else {
		parser.getCurrentContextStack().push(proxyForNext); // the Context object was already created elsewhere
	    }
	}
	try {
	    Object parseReturn = methodToCall.invoke(parser);
	    // add the parsed part to the object
	    parser.setResolveProxies(originalResolveProxiesValue);
	    reference.setRealValue(injector.createOrResolve(parseReturn, null, null));
	    // by default use partition of reference.getModelElement
	    if (reference.getModelElement() instanceof RefObject
		    && reference.getRealValue() instanceof Partitionable) {
		((RefObject) reference.getModelElement()).get___Partition()
			.assignElementIncludingChildren((Partitionable) reference.getRealValue());
	    }
	    modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), reference
		    .getRealValue());
	} finally {
	    if (reference.hasContext() && next instanceof RefObject) {
		parser.leaveContext();
	    }
	    parser.getCurrentContextStack().pop();
	}
    }

    private String getRuleNameFromWhenAsClauses(DelayedReference reference, IModelAdapter modelAdapter,
	    Object contextElement) throws ModelAdapterException {
	for (PredicateSemantic nextPred : reference.getPredicateActionList()) {
	    if (nextPred.getWhen() != null) {
		Collection<?> resultBool = modelAdapter.getPredicateOclReference(reference.getModelElement(), reference
			.getPropertyName(), reference.getKeyValue(), nextPred.getWhen(), contextElement);
		if (resultBool.size() == 1) {
		    Iterator<?> resIt = resultBool.iterator();
		    Object nextBool = resIt.next();
		    if (nextBool instanceof Boolean && (Boolean) nextBool) {
			return nextPred.getAs();
		    }
		}
	    } else {
		return nextPred.getAs(); // no when-clause means "handle always"
	    }
	}
	return null;
    }

    private String appendFlattenToOclQuery(DelayedReference reference) {
	String flattenOCL = "";
	if (reference.getOclQuery().startsWith("OCL:")) {
	    flattenOCL = "OCL:(" + reference.getOclQuery().substring(4) + ")->asSequence()->flatten()";
	} else {
	    flattenOCL = "(" + reference.getOclQuery() + ")->asSequence()->flatten()";
	}
	return flattenOCL;
    }

    /**
     * If the <tt>reference</tt>'s {@link DelayedReference#getModelElement() model element} is a proxy, resolve it
     * first.
     */
    private void resolveModelElementProxy(DelayedReference reference, IModelAdapter modelAdapter)
	    throws ModelAdapterException, ModelElementCreationException {
	if (reference.getModelElement() instanceof ModelElementProxy) {
	    ModelElementProxy proxy = (ModelElementProxy) reference.getModelElement();
	    if (proxy.getRealObject() == null) {
		Object result;
		result = modelAdapter.createOrResolveElement(proxy.getType(), proxy.getAttributeMap(), null, null,
			false, true);
		if (result instanceof RefObject) {
		    reference.setModelElement(result);
		}
	    } else {
		reference.setModelElement(proxy.getRealObject());
	    }
	}
    }

    private Template findTemplate(MofClass modelElement, String mode, Collection<PRI> partitionScope) {

	// TODO query fully qualified name!
	MQLResultSet result;
	RefObject[] refObjects;
	Classifier clazz = modelElement;
	Connection connection = modelElement.get___Connection();

	// TODO search only in the mapping partition!
	Template template = null;
	if (clazz != null) {
	    String query = "select template \n" + "from \"demo.sap.com/tcsmeta\"#"
		    + "TCS::ClassTemplate as template, \n" + "\"" + ((Partitionable) clazz).get___Mri()
		    + "\" as class " + " where template.metaReference = class where template.mode = ";
	    if (mode != null) {
		query += "'" + mode + "'";
	    } else {
		query += "null";
	    }
	    if (true /* template == null */) { // TODO
		QueryScopeProvider metamodelContainerQueryScope = connection.getMQLProcessor()
			.getInclusiveQueryScopeProvider(null,
				new CRI[] { ModelAdapter.getInstance().getContainer(modelElement) });
		QueryScopeProvider mappingQueryScope = connection.getMQLProcessor().getInclusiveQueryScopeProvider(
			partitionScope.toArray(new PRI[] {}), metamodelContainerQueryScope.getContainerScope());
		result = connection.getMQLProcessor().execute(query, mappingQueryScope);
		refObjects = result.getRefObjects("template");
		if (refObjects.length > 1) {
		    template = (Template) refObjects[1];
		} else if (refObjects.length == 1) {
		    template = (Template) refObjects[0];
		}
		if (template == null) {
		    // maybe operatorTemplate?
		    query = "select template \n" + "from \"demo.sap.com/tcsmeta\"#"
			    + "TCS::OperatorTemplate as template, \n" + "\"" + ((Partitionable) clazz).get___Mri()
			    + "\" as class " + " where template.metaReference = class";

		    result = connection.getMQLProcessor().execute(query);
		    refObjects = result.getRefObjects("template");

		    if (refObjects.length > 1) {
			// throw new
			// RuntimeException("Ambigous templates found for: " +
			// createdElement + " mode=" + mode);
			template = (Template) refObjects[1];
		    } else if (refObjects.length == 1) {
			template = (Template) refObjects[0];
		    }
		}

	    }
	}

	return template;
    }

    private boolean setDelayedReferenceWithQuery(DelayedReference reference, IModelAdapter modelAdapter,
	    ContextManager contextManager, Object contextElement) throws ModelAdapterException {
	// TODO validate no obsolete property args are set
	try {
	    contextElement = getNavigatedContextElementFromReference(reference, modelAdapter, contextManager,
		    contextElement);
	    if (reference.getModelElement() instanceof ModelElementProxy) {
		ModelElementProxy proxy = (ModelElementProxy) reference.getModelElement();
		if (proxy.getRealObject() == null) {
		    Object result;
		    result = modelAdapter.createOrResolveElement(proxy.getType(), proxy.getAttributeMap(), null, null,
			    false, true);
		    if (result instanceof RefObject)
			reference.setModelElement(result);
		} else {
		    reference.setModelElement(proxy.getRealObject());
		}
	    }
	    Object result = modelAdapter.setOclReference(reference.getModelElement(), reference.getPropertyName(),
		    reference.getKeyValue(), reference.getOclQuery(), contextElement, reference.getCurrentForeachElement());
	    if (result == null) {
		String message = "Referenced ModelElement for query '" + reference.getOclQuery()
			+ "' was not found for property '" + reference.getPropertyName() + "' of "
			+ reference.getModelElement().getClass().getName() + " with key value: "
			+ reference.getKeyValue();
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

    private static Object getNavigatedContextElementFromReference(DelayedReference reference,
	    IModelAdapter modelAdapter, ContextManager contextManager, Object contextElement)
	    throws ModelAdapterException, LookupPathNavigationException {
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
	    Object navigatedObject = navigateLookIn(contextElement, reference.getModelElement(), path, true,
		    modelAdapter, reference.getToken(), contextManager);
	    if(navigatedObject instanceof IModelElementProxy) {
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
	    ContextManager contextManager, Object referenceContext) throws ModelAdapterException,
	    ModelElementCreationException {
	boolean referenceSuccessfullySet = false;

	boolean problemReported = false;

	if ("always".equals(reference.getAutoCreate())) {
	    create(reference, modelAdapter, contextManager, referenceContext); // may
	    // throw
	    // exception
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
			Object navigatedObject = navigateLookIn(referenceContext, reference.getModelElement(), path,
				true, modelAdapter, reference.getToken(), contextManager);
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
			    Object result = modelAdapter.setWithinContextObject(sourceElement, reference
				    .getPropertyName(), reference.getValueTypeName(), reference.getKeyName(), reference
				    .getKeyValue(), navigatedObject);
			    if (result != null) {
				if (!(result instanceof Collection<?>) || (((Collection<?>) result).size() == 0)) {
				    reference.setRealValue(result);
				    referenceSuccessfullySet = true;
				} else {
				    problemReported = true;
				    reportProblem("No instance of " + asModelName(reference.getValueTypeName())
					    + " in context path " + reference.getLookIn() + "=" + navigatedObject
					    + " with '" + reference.getKeyName() + "' = '" + reference.getKeyValue()
					    + "'", reference.getToken());
				}
			    } else {
				reportProblem("No instance of " + asModelName(reference.getValueTypeName())
					+ " in context path " + reference.getLookIn() + "=" + navigatedObject
					+ " with '" + reference.getKeyName() + "' = '" + reference.getKeyValue() + "'",
					reference.getToken());
			    }
			}
		    } catch (LookupPathNavigationException e) {
			problemReported = true;
			reportProblem(e.getMessage(), e.getToken());
		    }
		} else { // lookIn is null
		    // try it for current context and all super contexts thereof
		    Object contextElement = referenceContext;
		    referenceSuccessfullySet = setReferenceInContext(reference, modelAdapter, contextElement,
			    contextManager);
		}

	    } catch (AmbiguousLookupException e) {
		problemReported = true;
		reportProblem("Found several instances suitable as reference: " + reference /*
											     * + ":" + e.getOriginal() +
											     * " and " +
											     * e.getDuplicate() +
											     * " in context of " +
											     * e.getContext()
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
				+ reference.getKeyName() + "' = '" + reference.getKeyValue()
				+ "' was not found for property '" + reference.getPropertyName() + "' of "
				+ reference.getModelElement().getClass().getName() + " with key value: "
				+ reference.getKeyValue();
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
	Object result = modelAdapter.setReference(reference.getModelElement(), reference.getPropertyName(), reference
		.getValueTypeName(), reference.getKeyName(), reference.getKeyValue());
	return result;
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
     * check elements within context for one element that could be the right referred element (correct type, keyfield =
     * keyvalue).
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
    private boolean setReferenceInContext(DelayedReference reference, IModelAdapter modelAdapter,
	    Object contextElement, ContextManager contextManager) throws ModelAdapterException,
	    AmbiguousLookupException {
	// System.out.println("Setting delayed reference " + reference);
	// Candidate for being set as referred object

	List<String> valueTypeName = reference.getValueTypeName();
	Object keyValue = reference.getKeyValue();
	String keyName = reference.getKeyName();
	
	

	Object candidate = null;

	if(reference.getType() == DelayedReference.CONTEXT_LOOKUP) {
	    candidate = modelAdapter.setOclReference(reference.getTextBlock(), reference.getPropertyName(),
                    reference.getKeyValue(), reference.getOclQuery(), contextElement, reference.getCurrentForeachElement());
	} else {
	candidate = contextManager.findCandidatesInContext(modelAdapter, contextElement, valueTypeName, keyName,
		keyValue);
	}

	if (candidate != null) {
	    reference.setRealValue(candidate);
	    modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), candidate);
	    return true;
	} else {
	    // recursion upwards, try parent context
	    // Context parentContext = context.parent();
	    if (hasCyclicContextParents(contextManager, contextElement)) {
		throw new RuntimeException("For some reason " + contextElement
			+ " has a cycle in its parent context hierarchy");
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
		reportProblem("Path could not be resolved " + reference.getLookIn() + " : " + e.getMessage(), reference
			.getToken());
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
	    boolean includingLastPathElement, IModelAdapter modelAdapter, ANTLR3LocationToken token,
	    ContextManager contextManager) throws ModelAdapterException, LookupPathNavigationException {

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
		    throw new LookupPathNavigationException("Model element feature " + modelElement + "."
			    + nextPathStep + " is null for path " + Arrays.toString(path), token);
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
