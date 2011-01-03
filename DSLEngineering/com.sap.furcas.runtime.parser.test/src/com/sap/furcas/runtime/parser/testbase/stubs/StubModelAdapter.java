package com.sap.furcas.runtime.parser.testbase.stubs;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;

public class StubModelAdapter implements IModelAdapter, IBareModelAdapter {

    protected StubModel model = new StubModel();
    public String stringLiteralType = "FURCAS::TCS::Literal";
    public Map<String, List<String>> supertypes = new HashMap<String, List<String>>();
    public Object queryResult;

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#createOrResolveElement(java. util.List, java.util.Map,
     * com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken, com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken, boolean,
     * boolean)
     */
    @Override
    public Object createOrResolveElement(List<String> typeName, Map<String, List<Object>> attributes,
            ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken, boolean resolveOnly, boolean createOnly) {
        Object ro = createElement(typeName);
        for (String key : attributes.keySet()) {
            List<Object> values = attributes.get(key);
            for (Object value : values) {
                set(ro, key, value);
            }
        }
        return ro;
    }

    @Override
    public Object createElement(List<String> typeName) {
        return model.create(QualifiedNamesHelper.getQualifiedString(typeName));
    }

    @Override
    public Object get(Object ame_, String propertyName) {
        return ((StubModelElement) ame_).get(propertyName);
    }
    
    @Override
    public Collection<Object> getElementsOfType(List<String> list) throws ModelAdapterException {
        StringBuilder buf = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String part = iterator.next();
            buf.append(part);
            if (iterator.hasNext()) {
                buf.append("::");
            }
        }
        return new ArrayList<Object>(getElementsOfType(buf.toString()));
    }

    public Collection<StubModelElement> getElementsOfType(String type) {
        return model.getElementsOfType(type);
    }

    public String getString(Object ame, String propName) {
        return get(ame, propName).toString();
    }

    @Override
    public void set(Object ame, String prop, Object value) {
        if (prop == null) {
            fail("Invalid call to set using null property.");
        }
        // if (value == null && prop.equals("name")) {
        // fail("Invalid call to set name using null value for " +
        // ((StubModelElement)ame).type + "." + prop );
        // }
        ((StubModelElement) ame).set(prop, value);
    }

    @Override
    public void set(Object ame, String prop, Object value, int index) {
        if (prop == null) {
            fail("Invalid call to set using null property.");
        }
        // if (value == null && prop.equals("name")) {
        // fail("Invalid call to set name using null value for " +
        // ((StubModelElement)ame).type + "." + prop );
        // }
        ((StubModelElement) ame).set(prop, value);
    }

    @Override
    public Object createEnumLiteral(List<String> names, String name) {
        return model.create(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#getMetaType(java.util.List)
     */
    @Override
    public Object getMetaType(List<String> typeNameList) {
        // typename is merely the string with the name of the meta type
        String typeName = QualifiedNamesHelper.getQualifiedString(typeNameList);
        return typeName;
    }

    @Override
    public boolean instanceOf(Object instance, Object typeName) {

        if (instance instanceof StubModelElement) {
            StubModelElement modelElement = (StubModelElement) instance;
            if (modelElement.type != null) {
                if (modelElement.type.equals(typeName)) {
                    return true;
                }
                List<String> superList = supertypes.get(modelElement.type);
                if (superList != null) {
                    for (String superType : superList) {
                        if (superType.equals(typeName)) {
                            return true;
                        }
                    }
                }
            }
            // System.out.println(modelElement.type + " not instanceOf " +
            // typeName);
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.Object)
     */
    @Override
    public Object setReferenceWithLookup(Object sourceModelElement, String referencePropertyName, List<String> targetTypeList,
            String targetKeyName, Object targetKeyValue) throws ModelAdapterException {
        Object val = null;
        String targetType = QualifiedNamesHelper.getQualifiedString(targetTypeList);
        Collection<StubModelElement> list = model.getElementsOfType(targetType);
        if (list != null) {
            for (Object object : list) {
                StubModelElement element = (StubModelElement) object;
                Object key = element.get(targetKeyName);
                if (key != null && key.equals(targetKeyValue)) {
                    if (((StubModelElement) sourceModelElement).get(referencePropertyName) != null) {
                        throw new ReferenceSettingException("Ambiguous reference for " + sourceModelElement + "."
                                + referencePropertyName);
                    }
                    ((StubModelElement) sourceModelElement).set(referencePropertyName, element);
                    val = element;
                }
            }
        } else {
            return null;
            // throw new
            // ModelAdapterException("StubModelAdapter has no element of type: "
            // + targetType + " while trying to set feature " +
            // ((StubModelElement)sourceModelElement).type + "." +
            // referencePropertyName);
        }
        return val;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
     */
    @Override
    public boolean hasDeferredActions() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
     */
    @Override
    public Map<Object, Object> performAllDeferredActions() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setMQLReference(java.lang.Object , java.lang.String, java.lang.String)
     */
    @Override
    public Object setReferenceWithOCLQuery(Object modelElement, String propertyName, Object keyValue, String oclQuery,
            Object contextObject, Object currentForeachElement) {
        ((StubModelElement) modelElement).set(propertyName, queryResult);
        return queryResult;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java. lang.Object, java.lang.String, java.util.List,
     * java.lang.String, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setReferenceWithContextLookup(Object modelElement, String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException {
        Object val = null;
        String targetType = QualifiedNamesHelper.getQualifiedString(valueTypeName);
        StubModelElement contextModelElement = (StubModelElement) contextObject;
        Collection<StubModelElement> list = model.getElementsOfType(targetType);
        if (list != null) {
            for (Object object : list) {
                StubModelElement element = (StubModelElement) object;
                // Object key = element.get(keyName);
                // if (key != null && key.equals(keyValue)) {
                if (contextModelElement != null && contextModelElement.equals(element)) {
                    if (((StubModelElement) modelElement).get(propertyName) != null) {
                        throw new ReferenceSettingException("Ambiguous reference for " + modelElement + "." + propertyName);
                    }
                    ((StubModelElement) modelElement).set(propertyName, element);
                    val = element;
                }
            }
        } else {
            return null;
            // throw new
            // ModelAdapterException("StubModelAdapter has no element of type: "
            // + targetType + " while trying to set feature " +
            // ((StubModelElement)sourceModelElement).type + "." +
            // referencePropertyName);
        }
        return val;
    }

    @Override
    public Collection<Object> queryElement(List<String> type, Map<String, List<Object>> attributes) {
        fail("not implemented yet.");
        return null;
    }

    @Override
    public void unset(Object modelElement, String prop, Object value) {
        fail("not implemented yet");
    }

    @Override
    public Collection<?> evaluateOCLQuery(Object modelElement, Object keyValue, String oclQuery, Object contextElement) {
        fail("not implemented yet");
        return null;
    }

    @Override
    public Collection<URI> getPRIPartitions(ResourceSet conn, String languageId) {
        fail("not implemented yet");
        return null;
    }

}
