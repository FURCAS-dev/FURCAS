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
package com.sap.furcas.modeladaptation.emf.lookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.modeladaptation.emf.adaptation.MessageUtil;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;

/**
 * Abstract implementation of {@link IMetaModelLookup} allowing clients to inspect ecore metamodels.
 * 
 * Subclasses must implement mechanisms to search for EClassifiers by a given qualified or
 * unqualified name.
 */
public abstract class AbstractEcoreMetaModelLookup implements IMetaModelLookup<EObject> {

    private final Map<List<String>, ResolvedNameAndReferenceBean<EObject>> metaLookupCache = new WeakHashMap<List<String>, ResolvedNameAndReferenceBean<EObject>>();

    /**
     * Returns an {@link OppositeEndFinder} that can be used to used to find
     * opposite ends within the target metamodel.
     */
    protected abstract OppositeEndFinder getOppositeEndFinder();
        
    /**
     * Look up the type by its name
     */
    protected final EClassifier findClassifier(ResolvedNameAndReferenceBean<EObject> reference) throws MetaModelLookupException {
        if (reference != null) {
            if (reference.getReference() instanceof EClassifier) {
                EClassifier classi = (EClassifier) reference.getReference();
                return classi;
            }
            return findClassifiersByQualifiedName(reference.getNames());
        }
        return null;
    }

    protected abstract EClassifier findClassifiersByQualifiedName(List<String> names) throws MetaModelLookupException;
    
    protected abstract List<EClassifier> findClassifiersByUnqualifiedName(String typeName) throws MetaModelLookupException;

    @Override
    public boolean isAbstract(ResolvedNameAndReferenceBean<EObject> referedElement) throws MetaModelLookupException {
        EClassifier classi = findClassifier(referedElement);
        if (classi instanceof EClass) {
            return ((EClass) classi).isAbstract();
        } else {
            return false;
        }
    }

    @Override
    public ResolvedNameAndReferenceBean<EObject> getFeatureClassReference(ResolvedNameAndReferenceBean<EObject> reference,
            String featureName) throws MetaModelLookupException {

        EClassifier resultType = null;
        if (reference != null) {
            EStructuralFeature feat = getEStructuralFeature(reference, featureName);
            if(feat == null) {
            	//could be hidden opposite
            	feat = getHiddenOpposite(reference, featureName);
            }
            if (feat != null) {
                if(feat.getEGenericType() != null) {
                    resultType = getEType(reference.getReference(), feat);
                } else {
                    EClassifier eType = feat.getEType();
                    if (eType != null && eType.eIsProxy()) {
                        EClassifier resolved = (EClassifier) EcoreUtil.resolve(eType, feat);
                        if (resolved == eType) {
                            throw new MetaModelLookupException("Could not resolve proxy for classifier: " + eType);
                        }
                        resultType = resolved;
                    } else {
                        resultType = eType;
                    }
                }
                if (resultType == null) {
                    throw new MetaModelLookupException("Inconsistent metamodel: No type specified for for " + MessageUtil.asModelName(reference.getNames())+ "." + featureName);
                }
            }
        }
        return createBean(resultType);

    }
    
    /**
     * Return the specialised value of feature.getEType() resolving any type parameters
     * from the specialised type of the sourceObject of the feature.
     * 
     * @param sourceObject
     * @param feature
     * @return
     */
    public static EClassifier getEType(EObject sourceObject, EStructuralFeature feature) {
            EGenericType targetGenericType = feature.getEGenericType();
            ETypeParameter targetTypeParameter = targetGenericType.getETypeParameter();
            if ((targetTypeParameter != null) && (sourceObject != null)) {
                    EClass sourceGenericType = feature.getEContainingClass();
                    EObject typeParameterContainer = targetTypeParameter.eContainer();
                    EClass sourceClass = (EClass) sourceObject;
                    EList<EGenericType> allSourceGenericSuperTypes = sourceClass.getEAllGenericSuperTypes();
                    for (EGenericType sourceGenericSuperType : allSourceGenericSuperTypes) {
                            if (sourceGenericSuperType.getERawType() == typeParameterContainer) {
                                    EList<EGenericType> sourceTypeArguments = sourceGenericSuperType.getETypeArguments();
                                    int i = sourceGenericType.getETypeParameters().indexOf(targetTypeParameter);
                                    if ((0 <= i) && (i < sourceTypeArguments.size())) {
                                            EGenericType sourceTypeArgument = sourceTypeArguments.get(i);
                                            return sourceTypeArgument.getERawType();
                                    }
                            }
                    }
            } 
            return targetGenericType.getERawType();
    }

    private EStructuralFeature getHiddenOpposite(ResolvedNameAndReferenceBean<EObject> reference, String featureName) throws MetaModelLookupException {
    	List<EReference> ends = new ArrayList<EReference>();
    	getOppositeEndFinder().findOppositeEnds((EClassifier) reference.getReference(), featureName, ends);
    	if(ends.size() > 1) {
    		throw new MetaModelLookupException("More than one oppositeEnd found for: " + reference.getNames() + ":" + featureName);
    	} else if(ends.size() == 0) {
    		return null;
    	} else {
    		return ends.iterator().next();
    	}
	}

	private EStructuralFeature getEStructuralFeature(ResolvedNameAndReferenceBean<EObject> reference, String featureName) throws MetaModelLookupException {
        EStructuralFeature returnFeature = null;
        
        EClassifier typeClass = findClassifier(reference);
        if (typeClass != null && typeClass instanceof EClass) {
            returnFeature = ((EClass) typeClass).getEStructuralFeature(featureName);
        }     
        return returnFeature;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(java.lang.String, java.lang.String)
     */
    @Override
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean<EObject> referedElement, String featureName)
            throws MetaModelLookupException {
        String[] path = featureName.split("\\.");
        ResolvedNameAndReferenceBean<EObject> referedElementPart = referedElement;
        MultiplicityBean bean = null;
        for (String featureNamePart : path) {
            EStructuralFeature feature = getEStructuralFeature(referedElementPart, featureNamePart);
            if (feature != null) {
                    bean = new MultiplicityBean();
                    bean.setLowerBound(feature.getLowerBound());
                    bean.setUpperBound(feature.getUpperBound());              
                    referedElementPart = createBean(feature.getEType());
            }
        }
        return bean;
    }

    @Override
    public List<ResolvedNameAndReferenceBean<EObject>> qualifyName(String typeName) throws MetaModelLookupException {
        // Find all Classifiers of this name
        // return all qualified names for these Classifiers
        List<ResolvedNameAndReferenceBean<EObject>> names = new ArrayList<ResolvedNameAndReferenceBean<EObject>>();
        List<EClassifier> classifiers = findClassifiersByUnqualifiedName(typeName);
        for (EClassifier classifier : classifiers) {
            names.add(createBean(classifier));
        }
        return names;
    }

    protected ResolvedNameAndReferenceBean<EObject> createBean(EClassifier metaClass) {
        if (metaClass == null) {
            return null;
        } else {
            return new ResolvedNameAndReferenceBean<EObject>(EcoreHelper.getQualifiedName(metaClass), metaClass);
        }
    }

    @Override
    public List<String> getEnumLiterals(ResolvedNameAndReferenceBean<EObject> reference) throws MetaModelLookupException {
        EClassifier classifier = findClassifier(reference);
        if (!(classifier instanceof EEnum)) {
            throw new MetaModelLookupException("The given name (" + reference.getNames() + ") does not resolve to an EnumerationType");
        }
        EEnum enumeration = (EEnum) classifier;
        List<String> literals = new ArrayList<String>(enumeration.getELiterals().size());
        for (EEnumLiteral literal : enumeration.getELiterals()) {
            literals.add(literal.getLiteral());
        }
        return literals;
    }

    @Override
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean<EObject> subType, ResolvedNameAndReferenceBean<EObject> superType) throws MetaModelLookupException {
        EClassifier supertypeClass = findClassifier(superType);
        EClassifier subtypeClass = findClassifier(subType);

        if (supertypeClass == null || subtypeClass == null) {
            return false;
        }
        if (subtypeClass.equals(supertypeClass)) {
            return true;
        }

        List<EClass> superList = ((EClass) subtypeClass).getEAllSuperTypes();
        for (EClass generalizableElement : superList) {
            if (generalizableElement.equals(supertypeClass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ResolvedNameAndReferenceBean<EObject> resolveReference(List<String> names) throws MetaModelLookupException {
        ResolvedNameAndReferenceBean<EObject> result = metaLookupCache.get(names);
        if(result == null) {
            result = createBean(findClassifiersByQualifiedName(names));
            metaLookupCache.put(names, result);
        }
        return result;
    }

    @Override
    public ResolvedNameAndReferenceBean<EObject> resolveReferenceName(EObject reference) {
        if (reference instanceof EClassifier) {
            return createBean((EClassifier) reference);
        } else {
            throw new IllegalArgumentException("Expected Classifier, not " + reference.getClass());
        }
    }

}
