/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.modeladaptation.emf.adaptation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereString;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;

/**
 * A helper class allowing to search a given reference scope for model elements.
 * Model elements are search per type and (optionally) a give set of known attribute values. 
 * 
 * This class is used by the {@link EMFModelAdapterDelegate} to search for existing model
 * elements, including the ones that have just been created by the delegate.
 * Finding such model elements is important when resolving non-ocl based references.
 * 
 * @author Stephan Erb (d049157)
 */
public class EcoreModelElementFinder {
    
    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;
    private final IMetaModelLookup<EObject> metamodelLookup;

    private final QueryProcessor queryProcessor;
    private static final String MQL_ALIAS_INSTANCE = "instance";
    

    public EcoreModelElementFinder(ResourceSet resourceSet, Set<URI> explicitReferenceScope, IMetaModelLookup<EObject> metamodelLookup) {
        this.resourceSet = resourceSet;
        this.metamodelLookup = metamodelLookup;
        this.referenceScope = explicitReferenceScope;

        queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
    }

    /**
     * Returns all known instances of the given type. If nothing is found, an empty collection is returned.
     */
    public Collection<EObject> findEObjectsOfType(List<String> targetType) throws ModelAdapterException {
        URI qName = EcoreUtil.getURI(findMetaClassOfType(targetType));

        SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
        FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, /*withoutSubtypes*/ false);
        Query mq = new Query(new SelectEntry[] { se }, new FromEntry[] { fe });
        ResultSet resultSet = executeQuery(mq);

        Collection<EObject> resultObjects = new ArrayList<EObject>();
        for (URI uri : resultSet.getUris(MQL_ALIAS_INSTANCE)) {
            resultObjects.add(resourceSet.getEObject(uri, true));
        }
        return resultObjects;
    }
       
    /**
     *  Returns the model element uniquely identified by the combination of type, property name and
     *  corresponding property value. Will return null if nothing is found. If more than one element is found, this
     *  method will throw a ModelAdapterException.
     */
    public EObject findEObjectOfTypeWithProperty(List<String> targetType, String targetKeyName, Object targetKeyValue) throws ModelAdapterException {
        URI qName = EcoreUtil.getURI(findMetaClassOfType(targetType));

        SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
        FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, false);
        WhereClause clause = new WhereString(targetKeyName, Operation.EQUAL, String.valueOf(targetKeyValue));
        WhereEntry we = new LocalWhereEntry(MQL_ALIAS_INSTANCE, clause);
        Query mq = new Query(new SelectEntry[] { se }, new FromEntry[] { fe }, new WhereEntry[] { we });

        ResultSet resultSet = null;
        try {
            QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, referenceScope);
            resultSet = queryProcessor.execute(mq, scopeProvider); // ,
        } catch (IllegalArgumentException e) {
            // trying to access an non-existent property is an illegal argument for query2
            throw new ModelAdapterException("Cannot find element of type " + MessageUtil.asModelName(targetType)
                    + " where " + targetKeyName + " is " + targetKeyValue, e);
        }
        if (resultSet.getSize() == 0) {
            return null; 
        } else if (resultSet.getSize() == 1) {
            URI[] uris = resultSet.getUris(MQL_ALIAS_INSTANCE);
            return resourceSet.getEObject(uris[0], true);
        } else {
            throw new ReferenceSettingException("Expected to find 1 result for search after "
                    + MessageUtil.asModelName(targetType) + " with " + targetKeyName + " = " + targetKeyValue
                    + " but found " + resultSet.getSize());
        }
    }
    
    /**
     * Returns all instances of the given type, which have the attribute/references values
     * as specified by the given maps.
     */
    public Collection<Object> findEObjectsOfTypeWithProperties(List<String> typeName,
            Map<String, EObject> partitionableReferenceValuedAttributesMap,
            Map<String, Object> singleAttributesMap) throws ModelAdapterException {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select instance \n").append("from [");
        URI uriEClass = EcoreUtil.getURI(findMetaClassOfType(typeName));
        queryBuilder.append(uriEClass);
        queryBuilder.append("] as instance");

        Set<String> singleValueFeatureNames = singleAttributesMap.keySet();
        int index = 0;
        for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator.hasNext(); index++) {
            String featureName = iterator.next();
            Object value = singleAttributesMap.get(featureName);
            if (value != null) {
                String featureValueInQuery = getFeatureValueAlias(index);
                if (value instanceof IModelElementProxy && ((IModelElementProxy) value).getRealObject() != null) {
                    queryBuilder.append(", \"").append(EcoreUtil.getURI((EObject) ((IModelElementProxy) value).getRealObject()))
                            .append("\" as ").append(featureValueInQuery);
                } else if (value instanceof EObject) {
                    queryBuilder.append(", \"").append(EcoreUtil.getURI(((EObject) value))).append("\" as ")
                            .append(featureValueInQuery);
                }
            }
        }

        Set<String> partitionableFeatureNames = partitionableReferenceValuedAttributesMap.keySet();
        for (String featureName : partitionableFeatureNames) {
            EObject value = partitionableReferenceValuedAttributesMap.get(featureName);
            queryBuilder.append(",\n [").append(EcoreUtil.getURI(value.eClass())).append("] as ").append(featureName).append("_alias")
                    .append(" in elements {[").append(EcoreUtil.getURI(value)).append("]}").append("\n");
        }
        for (String featureName : partitionableFeatureNames) {
            queryBuilder.append(" where instance.").append(featureName).append(" = ").append(featureName).append("_alias")
                    .append("\n");
        }

        index = 0;
        for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator.hasNext(); index++) {
            String featureName = iterator.next();
            Object value = singleAttributesMap.get(featureName);

            queryBuilder.append(" where instance.").append(featureName);
            if (value != null) {
                if (value instanceof IModelElementProxy && ((IModelElementProxy) value).getRealObject() != null) {
                    String featureValueInQuery = getFeatureValueAlias(index);
                    queryBuilder.append(" = ").append(featureValueInQuery).append("\n");
                } else if (value instanceof EObject) {
                    String featureValueInQuery = getFeatureValueAlias(index);
                    queryBuilder.append(" = ").append(featureValueInQuery).append("\n");
                } else {
                    String valueString = String.valueOf(value);
                    queryBuilder.append(" = '").append(valueString).append("'\n");
                }
            } else {
                queryBuilder.append(" = null\n");
            }

        }

        ResultSet resultSet = executeQuery(queryBuilder.toString());
        
        List<Object> result = new ArrayList<Object>(resultSet.getSize());
        for (URI uri : resultSet.getUris("instance")) {
            EObject object = resourceSet.getEObject(uri, true);
            // TODO filter using multi-valued attributes
            result.add(object);
        }
        return result;
    }
    
    private String getFeatureValueAlias(int index) {
        return "feat" + index;
    }

    private EClassifier findMetaClassOfType(List<String> qualifiedTypeName) throws ModelAdapterException {
        try {
            ResolvedNameAndReferenceBean<EObject> result = metamodelLookup.resolveReference(qualifiedTypeName);
            if (result != null) {
                return (EClass) result.getReference();
            } else {
              throw new ModelAdapterException("Could not resolve any EClassifier for " + qualifiedTypeName);
            }
        } catch (MetaModelLookupException e) {
           throw new ModelAdapterException("Failed to resolve the EClassifier for " + qualifiedTypeName, e);
        }
    }
    
    private ResultSet executeQuery(String query) {
        QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, referenceScope);
        return queryProcessor.execute(query, scopeProvider);
    }
    
    private ResultSet executeQuery(Query query) {
        QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, referenceScope);
        return queryProcessor.execute(query, scopeProvider);
    }

}
