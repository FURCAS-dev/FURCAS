/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AnyTypeImpl.java,v 1.3 2007/02/14 13:42:07 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.internal.impl.ClassifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.AnyTypeImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class AnyTypeImpl extends ClassifierImpl implements AnyType {
    private EList<Operation> operations;
    
    /**
     * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedOperations()
     * @generated
     * @ordered
     */
    protected EList<Operation> ownedOperations = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AnyTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UMLPackage.Literals.ANY_TYPE;
    }

    /**
     * @generated NOT
     */
    public EList<Operation> oclOperations() {
        if (operations == null) {
            AnyType prototype = (AnyType) OCLStandardLibraryImpl.INSTANCE.getOclAny();
            
            if (prototype == this) {
                // I *am* the standard library type!
                operations = getOperations();
            } else {
                // the prototype defines my operations for me
                operations = prototype.oclOperations();
            }
        }
        return operations;
    }
    
    /**
     * @generated NOT
     */
    public String getName() {
        if (name == null) {
            name = SINGLETON_NAME;
        }
        
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operation> getOwnedOperations() {
        if (ownedOperations == null) {
            ownedOperations = new EObjectContainmentEList<Operation>(Operation.class, this, UMLPackage.ANY_TYPE__OWNED_OPERATIONS);
        }
        return ownedOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<Feature> getFeatures() {
//TODO: Remove the "NOT"
        CacheAdapter cache = getCacheAdapter();
        if (cache != null) {
            Resource eResource = eResource();
            @SuppressWarnings("unchecked")
            EList<Feature> features = (EList<Feature>) cache.get(eResource,
                this, org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE);
            if (features == null) {
                cache.put(eResource, this,
                    org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE,
                    features = new DerivedUnionEObjectEList<Feature>(
                        Feature.class, this, UMLPackage.ANY_TYPE__FEATURE,
                        FEATURE_ESUBSETS));
            }
            return features;
        }
        return new DerivedUnionEObjectEList<Feature>(Feature.class, this,
                UMLPackage.ANY_TYPE__FEATURE, FEATURE_ESUBSETS);
    }

    /**
     * The array of subset feature identifiers for the '{@link #getFeatures() <em>Feature</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatures()
     * @generated NOT
     * @ordered
     */
    @SuppressWarnings("hiding")
    protected static final int[] FEATURE_ESUBSETS = new int[]{
//TODO: Remove the "NOT"
        UMLPackage.ANY_TYPE__ATTRIBUTE, UMLPackage.ANY_TYPE__OWNED_OPERATIONS};

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UMLPackage.ANY_TYPE__OWNED_OPERATIONS:
                return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UMLPackage.ANY_TYPE__OWNED_OPERATIONS:
                return getOwnedOperations();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UMLPackage.ANY_TYPE__OWNED_OPERATIONS:
                getOwnedOperations().clear();
                getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UMLPackage.ANY_TYPE__OWNED_OPERATIONS:
                getOwnedOperations().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UMLPackage.ANY_TYPE__OWNED_OPERATIONS:
                return ownedOperations != null && !ownedOperations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //AnyTypeImpl
