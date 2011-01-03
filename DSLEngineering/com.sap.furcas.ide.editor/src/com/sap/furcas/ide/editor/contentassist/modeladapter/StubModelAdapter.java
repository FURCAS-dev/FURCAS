package com.sap.furcas.ide.editor.contentassist.modeladapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;

public class StubModelAdapter implements IBareModelAdapter {

    protected StubModel model = new StubModel();
    public String stringLiteralType = "TCS::Literal";
    public Map<String, List<String>> supertypes = new HashMap<String, List<String>>();
    public String mqlQuery;
    public Object queryResult;

    @Override
    public Object createElement(List<String> typeName) {
        // System.out.println("Created" + typeName);
        return model.create(QualifiedNamesHelper.getQualifiedString(typeName));
    }

    @Override
    public Object get(Object ame_, String propertyName) {
        return ((StubModelElement) ame_).get(propertyName);
    }

    public Set<StubModelElement> getElementsbyType(String type) {
        return model.getElementsByType(type);
    }

    public String getString(Object ame, String propName) {
        return get(ame, propName).toString();
    }

    @Override
    public void set(Object ame, String prop, Object value) {
        if (prop == null) {
            System.err.println("Invalid call to set using null property.");
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
     * @see
     * com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.Object)
     */
    public Object setReference(Object sourceModelElement,
            String referencePropertyName, List<String> targetTypeList,
            String targetKeyName, Object targetKeyValue)
            throws ModelAdapterException {
        Object val = null;
        String targetType = QualifiedNamesHelper
                .getQualifiedString(targetTypeList);
        Set<StubModelElement> list = model.getElementsByType(targetType);
        if (list != null) {
            for (Object object : list) {
                StubModelElement element = (StubModelElement) object;
                Object key = element.get(targetKeyName);
                if (key != null && key.equals(targetKeyValue)) {
                    if (((StubModelElement) sourceModelElement)
                            .get(referencePropertyName) != null) {
                        throw new ReferenceSettingException(
                                "Ambiguous reference for " + sourceModelElement
                                        + "." + referencePropertyName);
                    }
                    ((StubModelElement) sourceModelElement).set(
                            referencePropertyName, element);
                    val = element;
                }
            }
        } else {
            return null;
            // throw new ModelAdapterException("StubModelAdapter has no element
            // of type: " + targetType + " while trying to set feature " +
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
     * @see
     * com.sap.mi.textual.grammar.IModelAdapter#setMQLReference(java.lang.Object
     * , java.lang.String, java.lang.String)
     */
    @Override
    public Object setReferenceWithOCLQuery(Object modelElement,
            String propertyName, Object keyValue, String mqlQuery,
            Object contextElement, Object currentForeachElement) {
        this.mqlQuery = mqlQuery;
        ((StubModelElement) modelElement).set(propertyName, queryResult);
        return queryResult;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java.
     * lang.Object, java.lang.String, java.util.List, java.lang.String,
     * java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setReferenceWithContextLookup(Object modelElement,
            String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject)
            throws ModelAdapterException, ReferenceSettingException {
        if (contextObject instanceof StubModelElement) {
            String targetType = QualifiedNamesHelper
                    .getQualifiedString(valueTypeName);
            StubModelElement context = (StubModelElement) contextObject;
            // in this object,look for an object of the given type having given
            // attribute with given value.
            Collection<Object> contents = context.getAllContained();
            for (Iterator<Object> iterator = contents.iterator(); iterator
                    .hasNext();) {
                Object object = iterator.next();
                if (object instanceof StubModelElement) {
                    StubModelElement contentElement = (StubModelElement) object;
                    if (contentElement.type.equals(targetType)) {
                        Object candidateKeyValue = contentElement.get(keyName);
                        if (candidateKeyValue != null
                                && candidateKeyValue.equals(keyValue)) {
                            ((StubModelElement) modelElement).set(propertyName,
                                    contentElement);
                            return contentElement;
                        }
                    }
                }
            }
        }

        throw new ReferenceSettingException(
                "StubModelAdapter could not set reference.");

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.IModelAdapter#queryElement(java.util.List,
     * java.util.Map)
     */
    @Override
    public Collection<Object> queryElement(List<String> type,
            Map<String, List<Object>> attributes) {
        Set<StubModelElement> allOfType = model
                .getElementsByType(QualifiedNamesHelper
                        .getQualifiedString(type));
        if (allOfType == null) {
            return null;
        }

        Collection<Object> results = new ArrayList<Object>();
        for (StubModelElement e : allOfType) {
            boolean conforms = true;
            for (String key : attributes.keySet()) {
                if (!e.get(key).equals(attributes.get(key).get(0))) {
                    conforms = false;
                }
            }
            if (conforms) {
                results.add(e);
            }
        }

        return results;
    }

    @Override
    public void set(Object modelElement, String prop, Object value, int index) {
        if (prop == null) {
            System.err.println("Invalid call to set using null property.");
        }
        // if (value == null && prop.equals("name")) {
        // fail("Invalid call to set name using null value for " +
        // ((StubModelElement)ame).type + "." + prop );
        // }
        ((StubModelElement) modelElement).set(prop, value);
    }

    @Override
    public void unset(Object modelElement, String prop, Object value) {
        if (prop == null) {
            System.err.println("Invalid call to set using null property.");
        }
        // if (value == null && prop.equals("name")) {
        // fail("Invalid call to set name using null value for " +
        // ((StubModelElement)ame).type + "." + prop );
        // }
        ((StubModelElement) modelElement).set(prop, null);
    }

    @Override
    public Object setReferenceWithLookup(Object sourceModelElement,
            String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue)
            throws ModelAdapterException, ReferenceSettingException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<?> evaluateOCLQuery(Object modelElement, Object keyValue,
            String oclQuery, Object contextElement)
            throws ModelAdapterException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Object> getElementsOfType(List<String> list) throws ModelAdapterException {
        // TODO Auto-generated method stub
        return null;
    }

}
