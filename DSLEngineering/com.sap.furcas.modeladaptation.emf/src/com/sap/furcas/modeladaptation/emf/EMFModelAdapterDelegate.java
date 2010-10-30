/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:50 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 859 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.modeladaptation.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.DeferredModelElementCreationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.EcoreHelper;

/**
 * Functionality Delegate for MOINModelAdapter. This class contains the core AdapterFunctionality, while it delegates repeated and
 * tedious JMI tasks to a helper class.
 */
public class EMFModelAdapterDelegate {

    private final AdapterJMIHelper jmiHelperDelegate;
    private final Collection<StructureTypeMockObject> structureTypeMocks = new ArrayList<StructureTypeMockObject>();
    private final Map<Object, Object> mock2ModelElementMap = new HashMap<Object, Object>();

    public EMFModelAdapterDelegate(EPackage root, final ResourceSet resourceSet, Set<URI> referenceScope) {
        this.jmiHelperDelegate = new AdapterJMIHelper(root, resourceSet, referenceScope);
    }

    /**
     * Constructor meant for testing only
     * 
     * @param adapterHelper
     * @param jmiHelper
     * @deprecated use public constructor instead
     */
    @Deprecated
    EMFModelAdapterDelegate(AdapterJMIHelper adapterHelper) {
        this.jmiHelperDelegate = adapterHelper;
    }

    public Object createElement(List<String> typeName) throws ModelAdapterException {
        Object clazz = jmiHelperDelegate.createObject(typeName);
        if (clazz instanceof StructureTypeMockObject) { // save deferred action
            // for later
            StructureTypeMockObject mock = (StructureTypeMockObject) clazz;
            structureTypeMocks.add(mock);
        }
        return clazz;
    }

    /**
     * @param enumName
     * @param name
     * @return
     * @throws ModelAdapterException
     */
    public Object getEnumLiteral(List<String> enumName, String name) throws ModelAdapterException {
        EEnumLiteral enumLiteral = jmiHelperDelegate.getEnumLiteral(enumName, name);
        return enumLiteral;
    }

    public Object get(EObject refObject, String propertyName) {
        Object value = null;

        EClass mofClass = refObject.eClass();

        EStructuralFeature strucFeat = mofClass.getEStructuralFeature(propertyName);
        if (strucFeat != null) {
            value = refObject.eGet(strucFeat);
        } else {
            // TODO look for hidden opposite

        } // end if is attribute else try reference
        return value;
    }

    public String getString(EObject refObject, String propertyName) {
        return String.valueOf(refObject.eGet(refObject.eClass().getEStructuralFeature(propertyName)));
    }

    public boolean instanceOf(EObject refObject, EObject metaType) {
        return EcoreHelper.isInstanceOf(refObject, metaType, true);
    }

    /**
     * <tt>value</tt> can be a collection of objects which then will all be set at once for a multi-valued feature
     * <tt>propertyName</tt>
     */
    @SuppressWarnings("unchecked")
    public void set(EObject refAObject, String propertyName, Object value) throws ModelAdapterException {

        // if value is a mock, set to real object instead, may require creating
        // the real object from the mock first
        if (value instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) value;
            // set value to the real object
            if (mock2ModelElementMap.containsKey(mock)) {
                value = mock2ModelElementMap.get(mock);
            } else {
                value = jmiHelperDelegate.actualCreateFromMock(mock);
            }

            mock2ModelElementMap.put(mock, value);
        }

        EClass mofClass = refAObject.eClass();

        EStructuralFeature feat = (EStructuralFeature) EcoreHelper.lookupElementExtended(mofClass, propertyName);
        if (feat != null) {
            if (feat.getUpperBound() == 1) {
                if (value instanceof Collection) {
                    value = ((Collection<? extends Object>) value).iterator().next();
                }
                // only set if value really changed
                Object originalValue = refAObject.eGet(feat);
                if ((value == null && originalValue != null) || (value != null && originalValue == null)
                        || !originalValue.equals(value)) {
                    refAObject.eSet(feat, value);
                }
            } else {
                Collection<Object> multiProperty = (Collection<Object>) refAObject.eGet(feat);
                if (feat.getUpperBound() < 0 || multiProperty.size() < feat.getUpperBound()) {
                    if (value instanceof Collection) {
                        multiProperty.addAll((Collection<? extends Object>) value);
                    } else {
                        multiProperty.add(value);
                    }
                } else {
                    throw new ModelAdapterException("Cannot add value, property " + propertyName
                            + " has an upper multiplicity of " + feat.getUpperBound());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void set(EObject refAObject, String propertyName, Object value, int index) throws ModelAdapterException {

        // if value is a mock, set to real object instead, may require creating
        // the real object from the mock first
        if (value instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) value;
            // set value to the real object
            if (mock2ModelElementMap.containsKey(mock)) {
                value = mock2ModelElementMap.get(mock);
            } else {
                value = jmiHelperDelegate.actualCreateFromMock(mock);
            }

            mock2ModelElementMap.put(mock, value);
        }

        EClass mofClass = refAObject.eClass();

        // property may either be an attribute or a reference. First checking
        // EAttribute, if not then check reference.
        EStructuralFeature feat = (EStructuralFeature) EcoreHelper.lookupElementExtended(mofClass, propertyName);
        if (feat != null) {
            if (feat.getUpperBound() == 1) {
                refAObject.eSet(feat, value);
            } else {
                // unordered means don't care about the index
                if (!feat.isOrdered()) {
                    Collection<Object> multiProperty = (Collection<Object>) refAObject.eGet(feat);
                    if (feat.getUpperBound() < 0 || multiProperty.size() < feat.getUpperBound()) {
                        if (value instanceof Collection) {
                            multiProperty.addAll((Collection<? extends Object>) value);
                        } else {
                            multiProperty.add(value);
                        }
                    } else {
                        throw new ModelAdapterException("Cannot add value, property " + propertyName
                                + " has an upper multiplicity of " + feat.getUpperBound());
                    }
                } else {
                    List<Object> multiProperty = (List<Object>) refAObject.eGet(feat);
                    if (index <= multiProperty.size() && index >= 0) {
                        if (feat.getUpperBound() < 0 || multiProperty.size() < feat.getUpperBound()) {
                            if (value instanceof Collection) {
                                multiProperty.addAll(index, (Collection<? extends Object>) value);
                            } else {
                                multiProperty.add(index, value);
                            }
                        } else {
                            throw new ModelAdapterException("Cannot add value, property " + propertyName
                                    + " has an upper multiplicity of " + feat.getUpperBound());
                        }
                    } else {
                        throw new ModelAdapterException("Cannot add value to property " + propertyName + " with index " + index
                                + ", when the property has " + multiProperty.size() + " elements.");
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void unset(EObject refAObject, String propertyName, Object value) throws ModelAdapterException {
        EClass mofClass = refAObject.eClass();

        EStructuralFeature feat = (EStructuralFeature) EcoreHelper.lookupElementExtended(mofClass, propertyName);
        if (feat != null) {
            if (feat.getUpperBound() == 1) {
                refAObject.eSet(feat, null);
            } else {
                if (!feat.isOrdered()) {
                    Collection<Object> multiProperty = (Collection<Object>) refAObject.eGet(feat);
                    if (feat.getUpperBound() < 0 || multiProperty.size() < feat.getUpperBound()) {
                        if (value instanceof Collection) {
                            multiProperty.removeAll((Collection<? extends Object>) value);
                        } else {
                            multiProperty.remove(value);
                        }
                    } else {
                        throw new ModelAdapterException("Cannot add value, property " + propertyName
                                + " has an upper multiplicity of " + feat.getUpperBound());
                    }
                }
            }
        }
    }

    /**
     * 
     * @param sourceModelElement
     * @param referencePropertyName
     * @param targetType
     * @param targetKeyName
     * @param targetKeyValue
     * @param contextObject
     *            - this might also be a collection of contextObjects!
     * @return
     * @throws ModelAdapterException
     * @throws ReferenceSettingException
     */
    public Object setReference(EObject sourceModelElement, String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue, Object contextObject) throws ModelAdapterException,
            ReferenceSettingException {
        Object result = null;

        if (contextObject == null) {
            // find target class with given property, assumes it is unique with
            // that key and value
            result = jmiHelperDelegate.findEObjectOfType(targetType, targetKeyName, targetKeyValue);
        } else if (targetKeyName == null) {
            // this is the case where the lookIn is actually the searched model
            // element and no further element
            // needs to be resolved. This occurs e.g. in LookupProperty
            result = contextObject;
        } else {
            // need to investigate contextObject more.
            EObject referenceType = getMetaType(targetType);

            List<EObject> contents = null;
            // look into immediate contents of context and look for appropriate
            // object, and make sure it is unique
            if (contextObject instanceof Collection<?>) {
                for (Object obj : ((Collection<?>) contextObject)) {
                    if (obj instanceof EObject) {
                        contents = getContainedElements((EObject) obj);
                    } else {
                        throw new ReferenceSettingException("Expected context objext either to be of type "
                                + "Collection<EObject>or EObject but got:" + obj.getClass());
                    }
                }
            } else if (contextObject instanceof EObject) {
                contents = getContainedElements((EObject) contextObject);
            } else {
                throw new ReferenceSettingException("Expected context objext either to be of type "
                        + "Collection<EObject>or EObject but got:" + contextObject.getClass());
            }
            // old and buggy:
            // contents = getContentsIncludingInherited((Namespace)
            // contextObject);

            for (EObject loopCandidateModelElement : contents) {
                if (instanceOf(loopCandidateModelElement, referenceType)) {
                    Object candidateFeatureValue = loopCandidateModelElement.eGet(loopCandidateModelElement.eClass()
                            .getEStructuralFeature(targetKeyName));

                    if (candidateFeatureValue != null && candidateFeatureValue.equals(targetKeyValue)) {
                        if (result == null) {
                            // TODO what if there is more than one result?
                            // maybe use collection and add all results
                            result = loopCandidateModelElement;
                        } else {
                            throw new ReferenceSettingException("More than one candidate found within " + contextObject
                                    + " of type " + MessageUtil.asModelName(targetType) + " with feature " + targetKeyName
                                    + " equals " + targetKeyValue);
                        }
                    }
                }
            }
        }
        // }
        // create link
        if (result != null) {
            set(sourceModelElement, referencePropertyName, result);
        }

        return result;
    }

    /**
     * @param contextObject
     * @return
     */
    private List<EObject> getContainedElements(EObject contextObject) {
        // TODO here all composite contents of the given contextobject have to
        // be resolved somehow.
        // maybe this can be done using an mql query?
        // TODO this needs to be extended by those associations that do not have
        // a reference
        // but are also defined as composite associations
        List<EObject> allContents = new ArrayList<EObject>();
        for (EModelElement element : getContentsIncludingInherited(contextObject.eClass())) {
            if (element instanceof EReference && ((EReference) element).isContainment()) {
                Object result = contextObject.eGet((EStructuralFeature) element);
                if (result instanceof Collection<?>) {
                    for (Object o : (Collection<?>) result) {
                        allContents.add((EObject) o);
                    }
                } else {
                    allContents.add((EObject) result);
                }
            }
        }

        return allContents;
    }

    /**
     * @param contextObject
     * @return
     */
    private List<EModelElement> getContentsIncludingInherited(EModelElement contextObject) {
        List<EModelElement> result = null;

        if (contextObject instanceof EClass) {
            result = new ArrayList<EModelElement>(((EClass) contextObject).getEAllStructuralFeatures());
        } else if (contextObject instanceof EPackage) {
            result = new ArrayList<EModelElement>(((EPackage) contextObject).getEClassifiers());
        }

        return result;
    }

    /**
     * @param type
     * @return
     */
    public EObject[] getElementsOfType(String type) {
        return jmiHelperDelegate.getElementsOfType(type);
    }

    /**
     * @throws ModelAdapterException
     * 
     */
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {

        List<DeferredModelElementCreationException> exceptions = new ArrayList<DeferredModelElementCreationException>();
        for (StructureTypeMockObject mock : structureTypeMocks) {
            if (mock2ModelElementMap.containsKey(mock)) {
                continue; // mock already resolved earlier, e.g. in set()
            }
            Object realModelElement = jmiHelperDelegate.actualCreateFromMock(mock);
            mock2ModelElementMap.put(mock, realModelElement);
            if (exceptions.size() > 0) {
                DeferredActionResolvingException exception = new DeferredActionResolvingException(exceptions.size()
                        + " deferred actions failed", exceptions);
                throw exception;
            }
        }
        return mock2ModelElementMap;
    }

    /**
     * @return
     */
    public boolean hasDeferredActions() {
        return (structureTypeMocks != null && structureTypeMocks.size() > 0);
    }

    public static final String OCL_QUERY_PREFIX = "OCL:";

    /**
     * @param referencePropertyName
     * @param keyValue
     * @param oclQuery
     * @param contextObject
     * @param foreachObject
     *            TODO
     * @param refObject
     * @return
     * @throws ModelAdapterException
     */
    public Object setQueriedReference(EObject sourceModelElement, String referencePropertyName, Object keyValue, String oclQuery,
            Object contextObject, Object foreachObject) throws ModelAdapterException, ReferenceSettingException {

        if (keyValue instanceof EObject || keyValue instanceof StructureTypeMockObject) {
            // TODO what if the property is not a string??
            throw new ReferenceSettingException("Queries by non-primitive References not possible: " + oclQuery);
        }

        Object refObject = null;
        if (oclQuery.startsWith(OCL_QUERY_PREFIX)) {
            refObject = jmiHelperDelegate.findElementWithOCLQuery(sourceModelElement, keyValue,
                    oclQuery.substring(OCL_QUERY_PREFIX.length()), contextObject, foreachObject);
        } else {
            refObject = jmiHelperDelegate.findElementWithOCLQuery(sourceModelElement, keyValue, oclQuery, contextObject,
                    foreachObject);
        }

        // create link
        if (refObject != null) {
            set(sourceModelElement, referencePropertyName, refObject);
        }

        return refObject;
    }

    public Collection<?> getOclEvaluation(EObject sourceModelElement, @SuppressWarnings("unused") String referencePropertyName, Object keyValue,
            String oclQuery, Object contextObject) throws ModelAdapterException, ReferenceSettingException {

        if (keyValue instanceof EObject || keyValue instanceof StructureTypeMockObject) {
            // TODO what if the property is not a string??
            throw new ReferenceSettingException("Queries by non-primitive References not possible: " + oclQuery);
        }

        Collection<?> refObject = null;
        if (oclQuery.startsWith(OCL_QUERY_PREFIX)) {
            refObject = jmiHelperDelegate.findElementsWithOCLQuery(sourceModelElement, keyValue,
                    oclQuery.substring(OCL_QUERY_PREFIX.length()), contextObject);
        } else {
            throw new ReferenceSettingException("Query needs to be prefixed with '" + OCL_QUERY_PREFIX + "'");
        }

        return refObject;
    }

    /**
     * @param typeName
     * @return
     * @throws ModelAdapterException
     */
    public EClass getMetaType(List<String> typeName) throws ModelAdapterException {
        EClass mofClass = jmiHelperDelegate.getEClass(typeName);
        return mofClass;
    }

    /**
     * @param typeName
     * @param attributes
     * @return
     */
    public Collection<Object> queryElement(List<String> typeName, Map<String, List<Object>> attributes) {

        // Map<String, Collection<?>> multiValuedAttributesMap = new
        // HashMap<String, Collection<?>>();
        Map<String, Object> singleValuedAttributesMap = new HashMap<String, Object>();
        Map<String, EObject> partitionableReferenceValuedAttributesMap = new HashMap<String, EObject>();
        Set<String> featureNames = attributes.keySet();
        for (String featureName : featureNames) {
            List<Object> value = attributes.get(featureName);
            if (value != null && value.size() > 0) {
                if (value.size() > 1) {
                    // TODO (maybe merely discard for now?)
                    throw new RuntimeException("Resolution by multi-valued attributes not possible.");
                    // multiValuedAttributesMap.put(featureName, value);
                } else {
                    Object valueitem = value.get(0);
                    if (valueitem instanceof IModelElementProxy) {
                        valueitem = ((IModelElementProxy) valueitem).getRealObject();
                    }
                    if (valueitem instanceof EObject) {
                        partitionableReferenceValuedAttributesMap.put(featureName, (EObject) valueitem);
                    } else {
                        // TODO validate attributes map (primitives or list of
                        // primitives of suitable type in map)
                        singleValuedAttributesMap.put(featureName, valueitem);
                    }
                }
            }
        }
        return jmiHelperDelegate.queryElement(typeName, partitionableReferenceValuedAttributesMap, singleValuedAttributesMap/*
                                                                                                                             * ,
                                                                                                                             * multiValuedAttributesMap
                                                                                                                             */);
    }

}
