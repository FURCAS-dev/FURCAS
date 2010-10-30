/**
 * 
 */
package com.sap.furcas.parsergenerator.emf.tcs.inject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.modeladaptation.emf.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;

/**
 * Specialized EMF Adapter for TCS Syntaxes
 */
public class TCSSpecificEMFModelAdapter implements IBareModelAdapter {

    private final EMFModelAdapter adapter;

    /**
     * @param referenceScope
     * 
     */
    public TCSSpecificEMFModelAdapter(ResourceSet resourceSet, Set<URI> referenceScope) {
        Set<URI> adapterReferenceScopeURIs = new HashSet<URI>(referenceScope);
        adapterReferenceScopeURIs.add(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"));

        adapter = new EMFModelAdapter(FURCASPackage.eINSTANCE, resourceSet, adapterReferenceScopeURIs);
    }

    public void close() {
        // connection.close();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#createElement(java.lang.String)
     */
    @Override
    public Object createElement(List<String> typeName) throws ModelAdapterException {
        Object element = adapter.createElement(typeName);
        return element;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.lang. String, java.lang.String)
     */
    @Override
    public Object createEnumLiteral(List<String> enumName, String name) throws ModelAdapterException {
        Object createdLiteral = adapter.createEnumLiteral(enumName, name);
        return createdLiteral;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#get(java.lang.Object, java.lang.String)
     */
    @Override
    public Object get(Object modelElement, String propertyName) throws ModelAdapterException {
        Object element = adapter.get(modelElement, propertyName);
        return element;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
     */
    @Override
    public boolean hasDeferredActions() {
        return adapter.hasDeferredActions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#instanceOf(java.lang.Object, java.lang.String)
     */
    @Override
    public boolean instanceOf(Object instance, Object typeName) throws ModelAdapterException {
        return adapter.instanceOf(instance, typeName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
     */
    @Override
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {

        Map<Object, Object> map = adapter.performAllDeferredActions();
        return map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object, java.lang.String, java.lang.Object)
     */
    @Override
    public void set(Object modelElement, String prop, Object value) throws ModelAdapterException {
        adapter.set(modelElement, prop, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object, java.lang.String, java.lang.Object, int)
     */
    @Override
    public void set(Object modelElement, String prop, Object value, int index) throws ModelAdapterException {
        adapter.set(modelElement, prop, value, index);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.Object)
     */
    @Override
    public Object setReference(Object sourceModelElement, String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue) throws ModelAdapterException, ReferenceSettingException {
        Object reference = adapter.setReference(sourceModelElement, referencePropertyName, targetType, targetKeyName,
                targetKeyValue);
        return reference;
    }

    /**
     * @param string
     * @return
     */
    public Set<Object> getElementsByType(String string) {
        Object[] array = adapter.getElementsOfType(string);
        Set<Object> set = null;
        if (array != null) {
            set = new HashSet<Object>(Arrays.asList(array));
        }
        return set;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setOclReference(java.lang.Object , java.lang.String, java.lang.String)
     */
    @Override
    public Object setOclReference(Object modelElement, String propertyName, Object keyValue, String oclQuery,
            Object contextObject, Object currentForeachElement) throws ModelAdapterException {
        Object result = adapter.setOclReference(modelElement, propertyName, keyValue, oclQuery, contextObject,
                currentForeachElement);
        return result;
    }

    @Override
    public Collection<?> getPredicateOclReference(Object modelElement, String propertyName, Object keyValue, String oclQuery,
            Object contextElement) throws ModelAdapterException {
        throw new NotImplementedException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#getMetaType(java.util.List)
     */
    @Override
    public Object getMetaType(List<String> typeName) throws ModelAdapterException {
        return adapter.getMetaType(typeName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java. lang.Object, java.lang.String, java.util.List,
     * java.lang.String, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setWithinContextObject(Object modelElement, String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException {
        return adapter.setWithinContextObject(modelElement, propertyName, valueTypeName, keyName, keyValue, contextObject);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#queryElement(java.util.List, java.util.Map)
     */
    @Override
    public Collection<Object> queryElement(List<String> type, Map<String, List<Object>> attributes) throws ModelAdapterException {
        return adapter.queryElement(type, attributes);
    }

    @Override
    public void unset(Object modelElement, String prop, Object value) throws ModelAdapterException {
        adapter.unset(modelElement, prop, value);
    }

}
