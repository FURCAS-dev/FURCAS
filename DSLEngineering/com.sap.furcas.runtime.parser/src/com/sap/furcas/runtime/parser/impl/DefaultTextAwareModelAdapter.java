/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * simple implementation using a simple resolution strategy and a
 * IBareModelAdapter else.
 */
public class DefaultTextAwareModelAdapter implements IModelAdapter {

    private final IBareModelAdapter modelAdapter;

    /**
     * @param modelAdapter
     */
    public DefaultTextAwareModelAdapter(IBareModelAdapter modelAdapter) {
        super();
        if (modelAdapter == null) {
            throw new IllegalArgumentException();
        }
        this.modelAdapter = modelAdapter;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.ITextAwareModelAdapter#createOrResolveElement(java.util.List,
     *      java.util.Map,
     *      com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken,
     *      com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken)
     */
    @Override
    public Object createOrResolveElement(List<String> typeName, Map<String, List<Object>> attributes,
            ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken, boolean resolveOnly, boolean createOnly)
            throws ModelAdapterException, ModelElementCreationException {

        // ModelElementProxy proxy = (ModelElementProxy) proxyObject;
        // If referenceOnly, merely resolve it, don't create it
        if (resolveOnly) {

            try {
                Collection<Object> resultSet = modelAdapter.queryElement(typeName, attributes);

                if (resultSet != null && resultSet.size() >= 1) {
                    if (resultSet.size() == 1) {
                        return resultSet.iterator().next();
                    } else {
                        throw new ModelElementCreationException("Reference " + typeName + " with attributes " + attributes
                                + " is ambiguous.");
                    }
                } else {
                    throw new ModelElementCreationException("Reference " + typeName + " with attributes " + attributes
                            + " could not be resolved.");
                }
            } catch (ModelAdapterException e) {
                // TODO move this to getModelAdapter() and
                // delete ModelElement on errors (?)
                throw new ModelElementCreationException("BUG: Exception resolving type " + typeName + " with attributes "
                        + attributes + " : " + e.getMessage(), e);
            }
        } else { // create new object and set its attributes,
                 // this is the default behavior
            Object createdObject = modelAdapter.createElement(typeName);

            Set<String> features = attributes.keySet();
            for (String prop : features) {
                List<Object> valueList = attributes.get(prop);
                for (Object value : valueList) {
                    if (value instanceof ModelElementProxy) {
                        ModelElementProxy valueProxy = (ModelElementProxy) value;
                        value = valueProxy.getRealObject();
                        if (value == null) {
                            throw new RuntimeException("Bug: proxy value for '" + prop + "' of type " + valueProxy.getType()
                                    + " had not been resolved.");
                        }
                    }
                    try {
                        set(createdObject, prop, value);
                    } catch (ModelAdapterException e) {
                        // TODO move this to
                        // getModelAdapter() and delete
                        // ModelElement on errors (?)
                        throw new ModelElementCreationException("Exception setting feature " + prop + " for object "
                                + createdObject + " to " + value + ": " + e.getMessage(), e);
                    }
                }
            }
            return createdObject;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.util.List,
     *      java.lang.String)
     */
    @Override
    public Object createEnumLiteral(List<String> enumName, String name) throws ModelAdapterException {
        return modelAdapter.createEnumLiteral(enumName, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
     */
    @Override
    public boolean hasDeferredActions() {
        return modelAdapter.hasDeferredActions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
     */
    @Override
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {
        return modelAdapter.performAllDeferredActions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object,
     *      java.lang.String, java.lang.Object)
     */
    @Override
    public void set(Object modelElement, String prop, Object value) throws ModelAdapterException {
        modelAdapter.set(modelElement, prop, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object,
     *      java.lang.String, java.lang.Object, int)
     */
    @Override
    public void set(Object modelElement, String prop, Object value, int index) throws ModelAdapterException {
        modelAdapter.set(modelElement, prop, value, index);
    }

    @Override
    public void unset(Object modelElement, String prop, Object value) throws ModelAdapterException {
        modelAdapter.unset(modelElement, prop, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setOclReference(java.lang.Object,
     *      java.lang.String, java.lang.Object, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public Object setReferenceWithOCLQuery(Object modelElement, String propertyName, Object keyValue, String oclQuery,
            Object contextElement, Object currentForeachElement) throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter
                .setReferenceWithOCLQuery(modelElement, propertyName, keyValue, oclQuery, contextElement, currentForeachElement);
    }

    @Override
    public Collection<?> evaluateOCLQuery(Object modelElement, Object keyValue, String oclQuery, Object contextElement) throws ModelAdapterException {
        return modelAdapter.evaluateOCLQuery(modelElement, keyValue, oclQuery, contextElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object,
     *      java.lang.String, java.util.List, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public Object setReferenceWithLookup(Object sourceModelElement, String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue) throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter.setReferenceWithLookup(sourceModelElement, referencePropertyName, targetType, targetKeyName, targetKeyValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java.lang.Object,
     *      java.lang.String, java.util.List, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setReferenceWithContextLookup(Object modelElement, String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter.setReferenceWithContextLookup(modelElement, propertyName, valueTypeName, keyName, keyValue, contextObject);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#get(java.lang.Object,
     *      java.lang.String)
     */
    @Override
    public Object get(Object modelElement, String propertyName) throws ModelAdapterException {
        return modelAdapter.get(modelElement, propertyName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#getMetaType(java.util.List)
     */
    @Override
    public Object getMetaType(List<String> typeName) throws ModelAdapterException {
        return modelAdapter.getMetaType(typeName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#instanceOf(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public boolean instanceOf(Object instance, Object metaType) throws ModelAdapterException {
        return modelAdapter.instanceOf(instance, metaType);
    }

    @Override
    public Collection<URI> getPRIPartitions(ResourceSet conn, String languageId) {
        return TcsUtil.getSyntaxPartitions(conn, languageId);
    }

}
