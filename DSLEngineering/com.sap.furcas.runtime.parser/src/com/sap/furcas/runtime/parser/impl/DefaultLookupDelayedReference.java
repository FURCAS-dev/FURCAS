package com.sap.furcas.runtime.parser.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.TextLocation;
import com.sap.furcas.runtime.parser.impl.context.AmbiguousLookupException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

public class DefaultLookupDelayedReference extends DelayedReference {

    public DefaultLookupDelayedReference(IModelElementProxy currentContextElement, Object currentForeachElement,
            Object modelElement, String propertyName, List<String> valueTypeName, String keyName, Object keyValue,
            String lookIn, String autoCreate, List<String> createAs, boolean importContext, String createIn, boolean b,
            ANTLR3LocationToken lastToken) {
        super(currentContextElement, currentForeachElement, modelElement, propertyName, valueTypeName, keyName,
                keyValue, lookIn, autoCreate, createAs, importContext, createIn, b, lastToken);
    }

    public DefaultLookupDelayedReference(IModelElementProxy currentContextElement, Object currentForeachElement,
            Object object, String propertyName, String keyName, Object keyValue, String query, boolean optional,
            ANTLR3LocationToken lastToken) {
        super(currentContextElement, currentForeachElement, object, propertyName, keyName, keyValue, query, optional,
                lastToken);
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
    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, ObservableInjectingParser parser) throws ModelAdapterException,
            ModelElementCreationException {
        Object referenceContext = reference.getContextElement();
        if (referenceContext instanceof IModelElementProxy) {
            IModelElementProxy proxyContext = (IModelElementProxy) referenceContext;
            referenceContext = proxyContext.getRealObject();
        }

        boolean referenceSuccessfullySet = false;

        boolean problemReported = false;

        if ("always".equals(reference.getAutoCreate())) {
            create(reference, modelAdapter, contextManager, parser, referenceContext); // may throw exception
            referenceSuccessfullySet = true;
        } else { // autocreate = "ifMissing" or "never"
            try {
                if ("#all".equals(reference.getLookIn())) {
                    Object val = setReferenceUsingModelAdapter(reference, modelAdapter);
                    if (val != null) {
                        reference.setRealValue(val);
                        referenceSuccessfullySet = true;
                    }
                } else if ((reference.getLookIn() != null)) { // lookIn is
                    // neither #all
                    // nor null
                    try {
                        String[] path = reference.getLookIn().split("\\.");
                        // navigate to an object, to later use that objects
                        // context as lookup context
                        Object navigatedObject = DelayedReferencesHelper.navigateLookIn(referenceContext, reference.getModelElement(), path,
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
                            Object result = modelAdapter.setReferenceWithContextLookup(sourceElement,
                                    reference.getPropertyName(), reference.getValueTypeName(), reference.getKeyName(),
                                    reference.getKeyValue(), navigatedObject);
                            if (result != null) {
                                if (!(result instanceof Collection<?>) || (((Collection<?>) result).size() == 0)) {
                                    reference.setRealValue(result);
                                    referenceSuccessfullySet = true;
                                } else {
                                    problemReported = true;
                                    parser.getInjector().addError(new ParsingError("No instance of " + asModelName(reference.getValueTypeName())
                                            + " in context path " + reference.getLookIn() + "=" + navigatedObject
                                            + " with '" + reference.getKeyName() + "' = '" + reference.getKeyValue()
                                            + "'", reference.getToken()));
                                }
                            } else {
                                parser.getInjector().addError(new ParsingError("No instance of " + asModelName(reference.getValueTypeName())
                                        + " in context path " + reference.getLookIn() + "=" + navigatedObject
                                        + " with '" + reference.getKeyName() + "' = '" + reference.getKeyValue() + "'",
                                        reference.getToken()));
                            }
                        }
                    } catch (LookupPathNavigationException e) {
                        problemReported = true;
                        parser.getInjector().addError(new ParsingError(e.getMessage(), e.getToken()));
                    }
                } else { // lookIn is null
                    // try it for current context and all super contexts thereof
                    Object contextElement = referenceContext;
                    referenceSuccessfullySet = setReferenceInContext(reference, modelAdapter, contextElement,
                            contextManager);
                }

            } catch (AmbiguousLookupException e) {
                problemReported = true;
                parser.getInjector().addError(new ParsingError("Found several instances suitable as reference: " + reference /*
                                                                                             * + ":" + e.getOriginal() +
                                                                                             * " and " +
                                                                                             * e.getDuplicate() +
                                                                                             * " in context of " +
                                                                                             * e.getContext()
                                                                                             */, reference.getToken()));
            }
        } // end if autoCreate = ifmissing or never

        if (!referenceSuccessfullySet) {
            if (!problemReported) {
                if (!"never".equals(reference.getAutoCreate())) {
                    create(reference, modelAdapter, contextManager, parser, referenceContext);
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
                        parser.getInjector().addError(new ParsingError(message, reference.getToken()));
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

        candidate = contextManager.findCandidatesInContext(modelAdapter, contextElement, valueTypeName, keyName,
                keyValue);

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

    /**
     * Creates the referred element, sets the key value, and sets it as reference target for the original reference
     * 
     * @param reference
     *            the reference
     * @param modelAdapter
     *            the model handler
     * @param contextManager
     * @param parser TODO
     * @param referenceContext
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws ModelElementCreationException
     */
    private void create(DelayedReference reference, IModelAdapter modelAdapter, ContextManager contextManager,
            ObservableInjectingParser parser, Object referenceContext) throws ModelAdapterException, ModelElementCreationException {
        // create
        Object ro = null;
        if (reference.getCreateAs() != null) {
            ro = ((ModelInjector) parser.getInjector()).doCreate(reference.getCreateAs(), reference.getKeyName(), reference.getKeyValue());
        } else {
            ro = ((ModelInjector) parser.getInjector()).doCreate(reference.getValueTypeName(), reference.getKeyName(), reference.getKeyValue());
        }
        reference.setRealValue(ro);

        // set reference
        Object modelElement = reference.getModelElement();
        modelAdapter.set(modelElement, reference.getPropertyName(), ro);
        try {
            TextLocation location = new TextLocation(reference.getToken());
            parser.getInjector().setLocation(ro, location);
        } catch (Exception e) {
        }

        if (reference.getCreateIn() != null) {
            try {
                String[] path = reference.getCreateIn().split("\\.");
                Object containingObject = DelayedReferencesHelper.navigateLookIn(referenceContext, reference.getModelElement(), path, false,
                        modelAdapter, reference.getToken(), contextManager);
                modelAdapter.set(containingObject, path[path.length - 1], ro);
                contextManager.addToContext(referenceContext, ro);
            } catch (LookupPathNavigationException e) {
                parser.getInjector().addError(new ParsingError("Path could not be resolved " + reference.getCreateIn() + " : " + e.getMessage(),
                        reference.getToken()));
            }
        }

        else if ((reference.getLookIn() != null) && !reference.getLookIn().equals("#all")) {
            try {
                String[] path = reference.getLookIn().split("\\.");
                Object e = DelayedReferencesHelper.navigateLookIn(referenceContext, reference.getModelElement(), path, false, modelAdapter,
                        reference.getToken(), contextManager);
                modelAdapter.set(e, path[path.length - 1], ro);
                contextManager.addToContext(referenceContext, ro);
            } catch (LookupPathNavigationException e) {
                // parser.getInjector().addError(new ParsingError(e.getMessage(), e.getToken());
                parser.getInjector().addError(new ParsingError("Path could not be resolved " + reference.getLookIn() + " : " + e.getMessage(),
                        reference.getToken()));
            }
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

}
