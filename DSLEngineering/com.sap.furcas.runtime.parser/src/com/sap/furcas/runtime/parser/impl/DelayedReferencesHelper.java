/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-04-14 09:00:22 +0200 (Mi, 14 Apr 2010) $
 * Revision: $Revision: 9646 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

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
    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, ObservableInjectingParser parser) throws ModelAdapterException,
            ModelElementCreationException {
        if (reference instanceof ForeachDelayedReference) {
            return ((ForeachDelayedReference) reference).setDelayedReference(reference, modelAdapter, contextManager, parser);
        } else if (reference instanceof SemanticDisambiguateDelayedReference) {
            return ((SemanticDisambiguateDelayedReference) reference).setDelayedReference(reference, modelAdapter, contextManager, parser);
        } else {
            return ((DefaultLookupDelayedReference) reference).setDelayedReference(reference, modelAdapter, contextManager, parser);
        }
    }

    public static Collection<?> evaluateForeachOcl(EObject sourceElement, DelayedReference reference,
            IModelAdapter modelAdapter, Object contextElement) throws ModelAdapterException {
        String flattenOCL = appendFlattenToOclQuery(reference.getOclQuery());
        // evaluate the predicate by OCL, return value is a list of objects
        Collection<?> result = modelAdapter.evaluateOCLQuery(sourceElement, reference.getKeyValue(), flattenOCL,
                contextElement);
        return result;
    }

    static String appendFlattenToOclQuery(String ocl) {
        String flattenOCL = "";
        if (ocl.startsWith("OCL:")) {
            flattenOCL = "OCL:(" + ocl.substring(4) + ")->asSequence()->flatten()";
        } else {
            flattenOCL = "OCL:(" + ocl + ")->asSequence()->flatten()";
        }
        return flattenOCL;
    }

    static Object getNavigatedContextElementFromReference(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, Object contextElement) throws ModelAdapterException,
            LookupPathNavigationException {
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
            if (navigatedObject instanceof IModelElementProxy) {
                contextElement = contextManager.getContextForElement(navigatedObject);
            } else {
                contextElement = contextManager.getContextForElement(new ResolvedModelElementProxy(navigatedObject));
            }

        }
        return contextElement;
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
    static Object navigateLookIn(Object contextElement, Object modelElement, String[] path,
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

}
