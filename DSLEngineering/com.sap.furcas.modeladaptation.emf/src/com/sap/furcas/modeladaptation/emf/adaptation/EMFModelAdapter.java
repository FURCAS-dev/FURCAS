/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.modeladaptation.emf.adaptation;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;

/**
 * Facade for the creation of EMF model elements. 
 * 
 * This class merely checks for invalid arguments and then delegates functionality (for readability)
 * to {@link EMFModelAdapterDelegate}. 
 */
public class EMFModelAdapter implements IBareModelAdapter {

    private final EMFModelAdapterDelegate delegate;

    public static final String OCL_QUERY_PREFIX = "OCL:";
    private static Set<String> javaLangPrimitiveClassnames = new HashSet<String>();
    static {
        javaLangPrimitiveClassnames.add("Boolean");
        javaLangPrimitiveClassnames.add("Integer");
        javaLangPrimitiveClassnames.add("Long");
        javaLangPrimitiveClassnames.add("Double");
        javaLangPrimitiveClassnames.add("Float");
        javaLangPrimitiveClassnames.add("String");
    }

    /**
     * Creates a new ModelAdapter which creates EMF model elements.
     * 
     * @param rootPackage Metamodel root package. The root package must contain all the classes that
     *          this adapter shall be used with. The adapter cannot create elements which are not part
     *          of the rootPackage. If two metamodels shall be used/combined, it is required to define a
     *          root package that contains those two.
     * @param resourceSet the transient resource for element creation will be created in this resource set
     * @param referenceScope List of (additional) resources that shall be looked at when references are
     *          resolved. The referenceScope by default already includes the URI of the root element
     *          and the visible URIs of the give resource set. In most cases the scope can therefore remain
     *          empty.
     */
    public EMFModelAdapter(EPackage rootPackage, ResourceSet resourceSet, Set<URI> referenceScope) {
        delegate = new EMFModelAdapterDelegate(rootPackage, resourceSet, referenceScope);
    }

    @Override
    public Object createElement(List<String> typeName) throws ModelAdapterException {
        assertIsValidTypeName(typeName);
        try {
            return delegate.createElement(typeName);
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while creating Element of type " + typeName, re);
        }
    }

    @Override
    public Object createEnumLiteral(List<String> enumName, String name) throws ModelAdapterException {
        assertIsValidTypeName(enumName);
        try {
            return (delegate.createEnumLiteral(enumName, name)).getInstance();
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while creating Enum Literal of type " + name, re);
        }
    }

    @Override
    public Object get(Object modelElementOrProxy, String propertyName) throws ModelAdapterException {
        assertArgumentsAreNotNull(modelElementOrProxy, propertyName);
        EObject modelElement = unwrapModelElementProxyIfAny(modelElementOrProxy);
        try {
            if (propertyName.contains(".")) {
                // path notation prop1.prop2.prop3
                Object value = null;
                for (String part : propertyName.split("\\.")) {
                    value = delegate.get(modelElement, part);
                    if (value == null || !(value instanceof EObject)) {
                        break;
                    } else {
                        modelElement = (EObject) value;
                    }
                }
                return value;
            } else {
                return delegate.get(modelElement, propertyName);
            }
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while getting property " + getCutToString(modelElement) + "." + propertyName, re);
        }
    }

    @Override
    public void set(Object modelElement, String propertyName, Object value) throws ModelAdapterException {
        assertArgumentsAreNotNull(modelElement, propertyName);
        if (value == null) {
            // don't need to call set to set to null, as this is for injection only
            return;
        }
        if (modelElement instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) modelElement;
            mock.setField(propertyName, value);
        } else {
            EObject eObject = unwrapModelElementProxyIfAny(modelElement);
            try {
                delegate.set(eObject, propertyName, value);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while setting " + eObject.getClass() + "." + propertyName + " to "
                        + getCutToString(value) + " : " + re.getMessage(), re);
            }
        }
    }
    
    @Override
    public void set(Object sourceModelElementOrProxy, String propertyName, Object value, int index) throws ModelAdapterException {
        assertArgumentsAreNotNull(sourceModelElementOrProxy, propertyName);
        if (value == null) {
            // don't need to call set to set to null, as this is for injection only
            return;
        }
        if (sourceModelElementOrProxy instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) sourceModelElementOrProxy;
            mock.setField(propertyName, value);
        } else {
            EObject modelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);
            try {
                delegate.set(modelElement, propertyName, value, index);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while setting " + modelElement.getClass() + "." + propertyName + " to "
                        + getCutToString(value) + " : " + re.getMessage(), re);
            }
        }
    }

    @Override
    public void unset(Object sourceModelElementOrProxy, String propertyName, Object value) throws ModelAdapterException {
        assertArgumentsAreNotNull(sourceModelElementOrProxy, propertyName);
        if (sourceModelElementOrProxy instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) sourceModelElementOrProxy;
            mock.unsetField(propertyName);
        } else {
            EObject modelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);
            try {
                delegate.unset(modelElement, propertyName, value);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while unsetting " + modelElement.getClass() + "." + propertyName + " to "
                        + getCutToString(value) + " : " + re.getMessage(), re);
            }
        }
    }

    @Override
    public Object setReferenceWithLookup(Object sourceModelElementOrProxy, String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue) throws ModelAdapterException, ReferenceSettingException {
        assertArgumentsAreNotNull(sourceModelElementOrProxy, referencePropertyName, targetType, targetKeyName);
        EObject modelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);
        try {
            return delegate.setReferenceWithLookup(modelElement, referencePropertyName, targetType, targetKeyName, targetKeyValue, null);
        } catch (RuntimeException re) {
            throw new RuntimeException("RuntimeException while setting Reference " + sourceModelElementOrProxy + "."
                    + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "="
                    + targetKeyValue, re);
        }
    }
    
    @Override
    public Object setReferenceWithContextLookup(Object sourceModelElementOrProxy, String referencePropertyName, List<String> targetType, String targetKeyName, Object targetKeyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException {
        assertArgumentsAreNotNull(sourceModelElementOrProxy, referencePropertyName, targetType);
        EObject sourceModelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);

        if (contextObject instanceof IModelElementProxy) {
            contextObject = ((IModelElementProxy) contextObject).getRealObject();
        }
        if (!((contextObject instanceof EObject) || contextObject instanceof Collection<?> || isPrimitive(contextObject))) {
            throw new IllegalArgumentException("Illegal Model Element type " + contextObject.getClass() + ", EObject required");
        }

        try {
            return delegate.setReferenceWithLookup(sourceModelElement, referencePropertyName, targetType, targetKeyName, targetKeyValue, contextObject);
        } catch (RuntimeException re) {
            throw new RuntimeException("RuntimeException while setting Reference " + sourceModelElement + "."
                    + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "="
                    + targetKeyValue, re);
        }
    }

    /**
     * Checks if <tt>o</tt>'s Java type qualifies as a primitive type in MOF. In particular, those types are {@link Boolean},
     * {@link String}, {@link Float}, {@link Long}, {@link Integer} and {@link Double}.
     */
    private boolean isPrimitive(Object o) {
        return (o.getClass().getPackage().getName().equals("java.lang") && 
                javaLangPrimitiveClassnames.contains(o.getClass().getSimpleName()));
    }

    @Override
    public Object setReferenceWithOCLQuery(Object sourceModelElementOrProxy, String referencePropertyName, Object keyValue, String oclQuery, Object contextObjectOrProxy, Object currentForeachElementOrProxy) throws ModelAdapterException, ReferenceSettingException {
        assertArgumentsAreNotNull(sourceModelElementOrProxy, referencePropertyName, oclQuery);
        EObject sourceModelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);
        oclQuery = verifyOCLQuery(oclQuery, keyValue);
        EObject contextObject = contextObjectOrProxy == null ? null : unwrapModelElementProxyIfAny(contextObjectOrProxy);
        EObject currentForeachElement = currentForeachElementOrProxy == null ? null : unwrapModelElementProxyIfAny(currentForeachElementOrProxy);
        
        try {
            return delegate.setReferenceWithOCLQuery(sourceModelElement, referencePropertyName, keyValue, oclQuery, contextObject, currentForeachElement);
        } catch (RuntimeException re) {
            throw new RuntimeException("RuntimeException while setting Reference " + sourceModelElementOrProxy + "."
                    + referencePropertyName + " via via OCL "
                    + oclQuery + " with ? as " + keyValue, re);
        }
    }

    @Override
    public Collection<?> evaluateOCLQuery(Object sourceModelElementOrProxy, Object keyValue, String oclQuery, Object contextObjectOrProxy) throws ModelAdapterException {
        assertArgumentsAreNotNull(oclQuery);
        EObject sourceModelElement = unwrapModelElementProxyIfAny(sourceModelElementOrProxy);
        oclQuery = verifyOCLQuery(oclQuery, keyValue);
        EObject contextObject = contextObjectOrProxy == null ? null : unwrapModelElementProxyIfAny(contextObjectOrProxy);

        try {
            return delegate.evaluateOCLQuery(sourceModelElement, keyValue, oclQuery, contextObject);
        } catch (RuntimeException re) {
            throw new RuntimeException("RuntimeException while evaluation OCL " + oclQuery + " with ? as " + keyValue, re);
        }
    }
    
    @Override
    public Collection<Object> queryElement(List<String> typeName, Map<String, List<Object>> attributes) throws ModelAdapterException {
        assertIsValidTypeName(typeName);
        try {
            return delegate.queryElement(typeName, attributes);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to query element with name " + typeName, e);
        }
    }
    
    @Override
    public Collection<Object> getElementsOfType(List<String> list) throws ModelAdapterException {
        assertIsValidTypeName(list);
        try {
            return delegate.getElementsOfType(list);
        } catch (RuntimeException re) {
            throw new RuntimeException("JmiException while getting elements of type" + list, re);
        }
    }
    
    @Override
    public boolean instanceOf(Object modelElement, Object metaType) throws ModelAdapterException {
        assertArgumentsAreNotNull(modelElement, metaType);
        if (!(modelElement instanceof EObject)) {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElement.getClass());
        }
        if (!(metaType instanceof EClassifier)) {
            throw new IllegalArgumentException("Unknown meta type " + metaType.getClass());
        }
        try {
            return delegate.instanceOf((EObject) modelElement, (EClassifier) metaType);
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while checking " + modelElement + " instanceOf " + metaType, re);
        }
    }

    @Override
    public Object getMetaType(List<String> typeName) throws ModelAdapterException {
        assertIsValidTypeName(typeName);
        return delegate.getMetaType(typeName);
    }
    
    @Override
    public boolean hasDeferredActions() {
        return delegate.hasDeferredActions();
    }

    @Override
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {
        return delegate.performAllDeferredActions();
    }
    
    private static EObject unwrapModelElementProxyIfAny(Object modelElementOrProxy) throws IllegalArgumentException {
        if (modelElementOrProxy instanceof EObject) {
            return (EObject) modelElementOrProxy;
        } else if (modelElementOrProxy instanceof IModelElementProxy) {
            return (EObject) ((IModelElementProxy) modelElementOrProxy).getRealObject();
        } else {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElementOrProxy.getClass());
        }
    }
    
    private static void assertIsValidTypeName(List<String> enumName) {
        if (enumName == null || enumName.size() == 0) {
            throw new IllegalArgumentException("typeName was null or empty: " + enumName);
        } else {
            for (String namePart : enumName) {
                if (namePart == null || namePart.trim().equals("")) {
                    throw new IllegalArgumentException("typeName part was null or empty: " + enumName);
                }
            }
        }
    }
    
    private static void assertArgumentsAreNotNull(Object... arguments) throws IllegalArgumentException {
        for (Object arg : arguments) {
            if (arg == null) {
                throw new IllegalArgumentException("A given argument was null");
            }
        }
    }
    
    private String verifyOCLQuery(String oclQuery, Object keyValue) throws ReferenceSettingException {
        if (keyValue instanceof EObject || keyValue instanceof StructureTypeMockObject) {
            throw new ReferenceSettingException("Queries by non-primitive References not possible: " + oclQuery);
        }
        if (oclQuery.startsWith(OCL_QUERY_PREFIX)) {
            return oclQuery.substring(OCL_QUERY_PREFIX.length());
        } else {
            throw new ReferenceSettingException("Query needs to be prefixed with '" + OCL_QUERY_PREFIX + "'");
        }
    }
    
    private static String getCutToString(Object object) {
        if (object == null) {
            return null;
        }
        String toString = object.toString();
        String[] tokens = toString.split("\\s");
        return tokens[0];
    }
}
