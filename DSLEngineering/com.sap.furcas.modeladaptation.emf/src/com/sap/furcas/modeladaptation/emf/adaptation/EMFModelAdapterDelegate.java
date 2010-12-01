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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.DeferredModelElementCreationException;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;


/**
 * Functionality delegate for {@link EMFModelAdapter}, implementing the actual functionality.
 * 
 * It assumes all input validations have already been performed by the model adapter.
 */
public class EMFModelAdapterDelegate {

    private final Collection<StructureTypeMockObject> structureTypeMocks = new ArrayList<StructureTypeMockObject>();
    private final Map<Object, Object> mock2ModelElementMap = new HashMap<Object, Object>();

    private final EPackage rootPackage;
    private final Resource transientResource;
    
    private final EcoreModelElementFinder modelLookup;
    private final QueryBasedEcoreMetaModelLookUp metamodelLookup;

    private final TCSSpecificOCLEvaluator oclEvaluator;

    private final Query2OppositeEndFinder oppositeEndFinder;

    /**
     * @param rootPackage metamodel root package used for metamodel lookups
     * @param resourceSet
     *            the {@link #createTransientParsingResource(ResourceSet) transient resource} will be created in this
     *            resource set. New elements, in turn, end up in that resource and therefore in this
     *            <code>resourceSet</code>.
     * @param referenceScope
     */
    public EMFModelAdapterDelegate(EPackage rootPackage, ResourceSet resourceSet, Set<URI> referenceScope) {
        this.rootPackage = rootPackage;

        // The metamodel lookup needs to know about our metamodel.  To be able to search for metaclasses within
        // our metamodel, it furthermore needs to know their metamodel. In our case this is ecore.
        // FIXME: it does not make much sense to pass the explicitly given referenceScope to the metamodeLookup class
        // This is hack is required atm, because we have testcases that use several distinct
        // ecore files without a unifying super-package.
        Set<URI> referenceScopeIncludingMetamodels = new HashSet<URI>(referenceScope);
        referenceScopeIncludingMetamodels.add(URI.createURI(rootPackage.getNsURI()));
        referenceScopeIncludingMetamodels.add(URI.createURI(rootPackage.eClass().getEPackage().getNsURI()));
        metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet, referenceScopeIncludingMetamodels);
        
        // The model lookup needs to know about the element created by this delegate
        transientResource = createTransientParsingResource(resourceSet);
        Set<URI> referenceScopeIncludingCreatedElements = new HashSet<URI>(referenceScope);
        referenceScopeIncludingCreatedElements.add(transientResource.getURI());
        modelLookup = new EcoreModelElementFinder(resourceSet, referenceScopeIncludingCreatedElements, metamodelLookup);
        
        // TODO: use the given resourceSet/reference scope instead of the project dependent query context.
        QueryContextProvider queryContext = new ProjectDependencyQueryContextProvider(getAdditionalScopeSeeds(
                resourceSet, referenceScope));
        this.oclEvaluator = new TCSSpecificOCLEvaluator(queryContext);
        this.oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
    }
    
    private Notifier[] getAdditionalScopeSeeds(ResourceSet resourceSet, Set<URI> referenceScope) {
        Notifier[] result = new Notifier[referenceScope.size()+1];
        int i=0;
        for (URI uri : referenceScope) {
            result[i++] = resourceSet.getResource(uri, /* loadOnDemand */ false);
        }
        result[i] = resourceSet;
        return result;
    }

    /**
     * Create a resource to holds all element created by this ModelAdapter. Otherwise query2 cannot find them.
     */
    private Resource createTransientParsingResource(ResourceSet resourceSet) {
        Resource resource = resourceSet.createResource(URI.createURI(
                rootPackage.getNsURI() + "/transientParsingResource" + EcoreUtil.generateUUID()));
        return resource;
    }
    
    private void assignToTransientResource(EObject eObject) {
        transientResource.getContents().add(eObject);
    }
    
    // FIXME need to find a place when and where to call this. Until then we might
    // suffer from memory leaks. 
    private void clearTransientParsingResource() {
        try {
            transientResource.delete(/*options*/ null);
        } catch (IOException e) {
            throw new RuntimeException("Failed to clear the transient parsing resource", e);
        }
    }

    public Object createElement(List<String> qualifiedTypeName) throws ModelAdapterException {
        EModelElement modelElement = EcoreHelper.findClassifierByName(qualifiedTypeName, rootPackage);
        if (modelElement == null) {
            throw new ModelAdapterException("No modelElement found for qualifiedName "
                    + MessageUtil.asModelName(qualifiedTypeName) + " in package " + rootPackage);
        }
        if (modelElement instanceof EClass) {
            EClass metaClass = (EClass) modelElement;
            if (metaClass.isAbstract()) {
                throw new ModelAdapterException("Cannot instantiate EClass " + MessageUtil.asModelName(qualifiedTypeName)
                        + " as it is abstract.");
            }
            EObject created = EcoreUtil.create(metaClass);
            assignToTransientResource(created);
            return created;
        } else if (modelElement instanceof EDataType) {
            EDataType structype = (EDataType) modelElement;
            StructureTypeMockObject mock = new StructureTypeMockObject(structype);
            structureTypeMocks.add(mock); // save deferred action for later 
            return mock;
        } else {
            throw new ModelAdapterException("Unsupported model element type. Cannot instantiate EModelElement "
                    + MessageUtil.asModelName(qualifiedTypeName));
        }
    }
    
    public EEnumLiteral createEnumLiteral(List<String> qualifiedEnumTypeName, String enumLiteralName) throws ModelAdapterException {
        EModelElement modelElement = EcoreHelper.findClassifierByName(qualifiedEnumTypeName, rootPackage);
        if (modelElement instanceof EEnum) {
            EEnumLiteral enumLiteral = ((EEnum) modelElement).getEEnumLiteral(enumLiteralName);;
            if (enumLiteral == null) {
                throw new ModelAdapterException(MessageUtil.asModelName(qualifiedEnumTypeName) + " does not have a liter named " + enumLiteralName);
            }
            return enumLiteral;
        } else {
            throw new ModelAdapterException(MessageUtil.asModelName(qualifiedEnumTypeName) + " is not an EnumerationType in Metamodel");
        }
    }

    public Object get(EObject modelElement, String propertyName) throws ModelAdapterException {
        try {
            EStructuralFeature feature = getFeatureByName(modelElement.eClass(), propertyName);
            return modelElement.eGet(feature);
        } catch (ModelAdapterException e) {
            // look for hidden opposite
            EStructuralFeature hiddenOpposite = getHiddenOppositeFeatureByName(modelElement.eClass(), propertyName);
            return oppositeEndFinder.navigateOppositePropertyWithBackwardScope((EReference) hiddenOpposite, modelElement);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void set(EObject modelElement, String propertyName, Object value, int index) throws ModelAdapterException {
        if (value instanceof StructureTypeMockObject) {
            value = getOrCreateRealObjectForMock((StructureTypeMockObject) value);
        }

        EStructuralFeature feat = getFeatureByName(modelElement.eClass(), propertyName);
        if (feat.getUpperBound() == 1 || !feat.isOrdered()) {
            // single value or unordered means we don't care about the index
            set(modelElement, propertyName, value);
        } else {
            List<Object> multiProperty = (List<Object>) modelElement.eGet(feat);
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

    @SuppressWarnings("unchecked")
    public void set(EObject modelElement, String propertyName, Object value) throws ModelAdapterException {
        if (value instanceof StructureTypeMockObject) {
            value = getOrCreateRealObjectForMock((StructureTypeMockObject) value);
        }

        EStructuralFeature feat = getFeatureByName(modelElement.eClass(), propertyName);
        if (feat.getUpperBound() == 1) {
            if (value instanceof Collection) {
                if (((Collection<?>) value).size() != 1) {
                    throw new ModelAdapterException("Upper bound for feature " + propertyName + " of " + modelElement.eClass() + " is 1. " +
                    		"Unable to set " + ((Collection<?>) value).size() + " elements.");
                }
                value = ((Collection<?>) value).iterator().next();
            }
            Object originalValue = modelElement.eGet(feat);
            if (valueHasChanged(value, originalValue)) {
                modelElement.eSet(feat, value);
            }
        } else {
            Collection<Object> multiProperty = (Collection<Object>) modelElement.eGet(feat);
            if (feat.getUpperBound() < 0 || multiProperty.size() < feat.getUpperBound()) {
                if (value instanceof Collection) {
                    multiProperty.addAll((Collection<Object>) value);
                } else {
                    multiProperty.add(value);
                }
            } else {
                throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of "
                        + feat.getUpperBound());
            }
        }
    }

    private boolean valueHasChanged(Object value, Object originalValue) {
        return (value == null && originalValue != null) || (value != null && originalValue == null) || !originalValue.equals(value);
    }

    @SuppressWarnings("unchecked")
    public void unset(EObject modelElement, String propertyName, Object value) throws ModelAdapterException {
        EStructuralFeature feat = getFeatureByName(modelElement.eClass(), propertyName);
        if (feat.getUpperBound() == 1) {
            modelElement.eUnset(feat);
        } else {
            Collection<Object> multiProperty = (Collection<Object>) modelElement.eGet(feat);
            if (multiProperty.size() > feat.getLowerBound()) {
                if (value instanceof Collection) {
                    multiProperty.removeAll((Collection<? extends Object>) value);
                } else {
                    multiProperty.remove(value);
                }
            } else {
                throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an lower multiplicity of "
                        + feat.getLowerBound());
            }
        }
    }
    
    public Collection<?> evaluateOCLQuery(EObject sourceModelElement, Object keyValue,
            String oclQuery, EObject contextObject) throws ModelAdapterException, ReferenceSettingException {
        return oclEvaluator.findElementsWithOCLQuery(sourceModelElement, keyValue, oclQuery, contextObject);
    }
    
    public Object setReferenceWithOCLQuery(EObject sourceModelElement, String referencePropertyName, Object keyValue, String oclQuery,
            EObject contextObject, EObject foreachObject) throws ModelAdapterException, ReferenceSettingException {
        Collection<?> result = oclEvaluator.findElementsWithOCLQuery(sourceModelElement, keyValue, oclQuery, contextObject, foreachObject);
        if (result.size() > 0) {
            set(sourceModelElement, referencePropertyName, result);
            return result;
        } else {
            // we return null instead of the empty collection to be consistent with the other setReference methods
            return null;
        }
    }
    
    /**
     * @param contextObject might also be a collection of contextObjects!
     */
    public Object setReferenceWithLookup(EObject sourceModelElement, String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue, Object contextObject) throws ModelAdapterException,
            ReferenceSettingException {
        Object result = null;

        if (contextObject == null) {
            // find target class with given property, assumes it is unique with
            // that key and value
            result = modelLookup.findEObjectOfTypeWithProperty(targetType, targetKeyName, targetKeyValue);
        } else if (targetKeyName == null) {
            // this is the case where the lookIn is actually the searched model
            // element and no further element
            // needs to be resolved. This occurs e.g. in LookupProperty
            result = contextObject;
        } else {
            // need to investigate contextObject more.
            EClassifier referenceType = getMetaType(targetType);

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

            for (EObject loopCandidateModelElement : contents) {
                if (instanceOf(loopCandidateModelElement, referenceType)) {
                    Object candidateFeatureValue = loopCandidateModelElement.eGet(
                            getFeatureByName(loopCandidateModelElement.eClass(), targetKeyName));

                    if (candidateFeatureValue != null && candidateFeatureValue.equals(targetKeyValue)) {
                        if (result == null) {
                            // TODO what if there is more than one result? maybe use collection and add all results
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
        if (result != null) {
            set(sourceModelElement, referencePropertyName, result);
        }
        return result;
    }

    private List<EObject> getContainedElements(EObject contextObject) {
        // TODO here all composite contents of the given contextobject have to be resolved somehow.
        // maybe this can be done using an mql query?
        // TODO this needs to be extended by those associations that do not have
        // a reference but are also defined as composite associations
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

    private List<EModelElement> getContentsIncludingInherited(EModelElement contextObject) {
        List<EModelElement> result = null;
        if (contextObject instanceof EClass) {
            result = new ArrayList<EModelElement>(((EClass) contextObject).getEAllStructuralFeatures());
        } else if (contextObject instanceof EPackage) {
            result = new ArrayList<EModelElement>(((EPackage) contextObject).getEClassifiers());
        }

        return result;
    }

 
    public Collection<Object> getElementsOfType(List<String> list) throws ModelAdapterException {
        return new ArrayList<Object>(modelLookup.findEObjectsOfType(list));
    }
    
    public Collection<Object> queryElement(List<String> typeName, Map<String, List<Object>> attributes) throws ModelAdapterException {
        Map<String, Object> singleValuedAttributesMap = new HashMap<String, Object>();
        Map<String, EObject> partitionableReferenceValuedAttributesMap = new HashMap<String, EObject>();
        Set<String> featureNames = attributes.keySet();
        for (String featureName : featureNames) {
            List<Object> value = attributes.get(featureName);
            if (value != null && value.size() > 0) {
                if (value.size() > 1) {
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
        return modelLookup.findEObjectsOfTypeWithProperties(typeName, partitionableReferenceValuedAttributesMap, singleValuedAttributesMap);
    }
    
    private EStructuralFeature getFeatureByName(EClass eClass, String propertyName) throws ModelAdapterException {
        EStructuralFeature feature = eClass.getEStructuralFeature(propertyName);
        if (feature == null) {
            throw new ModelAdapterException("No such feature \"" + propertyName + "\" defined for  " + eClass);
        }
        return feature;
    }

    private EReference getHiddenOppositeFeatureByName(EClass eClass, String propertyName) throws ModelAdapterException {
        ArrayList<EStructuralFeature> hiddenOppositeEnds = new ArrayList<EStructuralFeature>();
        // no need to fiddle with query2-based opposite end finder; we're only searching metamodels here
        DefaultOppositeEndFinder.getInstance().findOppositeEnds(eClass, propertyName, hiddenOppositeEnds);
        if (hiddenOppositeEnds.size() == 1) {
            return (EReference) hiddenOppositeEnds.iterator().next();
        } else if (hiddenOppositeEnds.size() > 1) {
            throw new ModelAdapterException("Ambigous hidden opposite ends named " + propertyName + " for " + eClass);
        } else {
            return null; // no hidden opposite end found;
        }
    }
    
    public boolean hasDeferredActions() {
        return (structureTypeMocks != null && structureTypeMocks.size() > 0);
    }

    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {
        List<DeferredModelElementCreationException> exceptions = new ArrayList<DeferredModelElementCreationException>();
        for (StructureTypeMockObject mock : structureTypeMocks) {
            if (mock2ModelElementMap.containsKey(mock)) {
                continue; // mock already resolved earlier, e.g. in set()
            }
            try {
                Object realModelElement = createStructureTypeFromMock(mock);
                mock2ModelElementMap.put(mock, realModelElement);
            } catch (ModelAdapterException e) {
                exceptions.add(new DeferredModelElementCreationException("Unable to create structure type from mock " + mock, e));
            }
        }
        if (exceptions.size() > 0) {
            throw new DeferredActionResolvingException(exceptions.size() + " deferred actions failed", exceptions);
        }
        return mock2ModelElementMap;
    }
    
    /**
     * Finally performs the delayed instantiation of the structured type, using the
     * values cached in the given mock object. 
     * 
     * @throws ModelAdapterException  if e.g. required fields are not set.
     */
    private Object createStructureTypeFromMock(StructureTypeMockObject mock) throws ModelAdapterException {
        // TODO: when implementing, do not forget to assign the created structure type to
        // the transient parsing resource so that it can be found by query2
        throw new NotImplementedException();
    }
    
    private Object getOrCreateRealObjectForMock(StructureTypeMockObject mock) throws ModelAdapterException {
        Object value = null;
        // set value to the real object
        if (mock2ModelElementMap.containsKey(mock)) {
            value = mock2ModelElementMap.get(mock);
        } else {
            value = createStructureTypeFromMock(mock);
        }
        mock2ModelElementMap.put(mock, value);
        return value;
    }
    
    public boolean instanceOf(EObject modelElement, EClassifier metaType) {
        return metaType.isInstance(modelElement);
    }

    public EClass getMetaType(List<String> typeName) throws ModelAdapterException {
        try {
            ResolvedNameAndReferenceBean<EObject> result = metamodelLookup.resolveReference(typeName);
            if (result != null && result.getReference() instanceof EClass) {
                return (EClass) result.getReference();
            } else {
              throw new ModelAdapterException("Could not resolve any EClass for " + typeName);
            }
        } catch (MetaModelLookupException e) {
           throw new ModelAdapterException("Failed to resolve the EClass for " + typeName, e);
        }
    }  

}
