/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: TupleTypeImpl.java,v 1.6 2008/03/28 20:33:40 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.types.operations.TupleTypeOperations;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleTypeImpl#isSerializable <em>Serializable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleTypeImpl extends EClassImpl implements TupleType {
    /**
     * The default value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSerializable()
     * @generated
     * @ordered
     */
    protected static final boolean SERIALIZABLE_EDEFAULT = true;
    /**
     * The cached value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSerializable()
     * @generated
     * @ordered
     */
    protected boolean serializable = SERIALIZABLE_EDEFAULT;
    private EList<EOperation> operations;
    private EList<EStructuralFeature> properties;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected TupleTypeImpl() {
        super();
        
        instanceClass = Tuple.class;
        instanceClassName = instanceClass.getName();
        instanceTypeName = instanceClass.getName();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.TUPLE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSerializable() {
        return serializable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSerializable(boolean newSerializable) {
        boolean oldSerializable = serializable;
        serializable = newSerializable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.TUPLE_TYPE__SERIALIZABLE, oldSerializable, serializable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean checkTupleTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkTupleTypeName(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean checkPartNamesUnique(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkPartNamesUnique(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean checkFeaturesOnlyProperties(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkFeaturesOnlyProperties(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EStructuralFeature> oclProperties() {
        if (properties == null) {
            properties = new DelegatingEList<EStructuralFeature>() {
                private static final long serialVersionUID = -4098965170992199523L;

                @Override
                protected List<EStructuralFeature> delegateList() {
                    return getEStructuralFeatures();
                }};
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EOperation> oclOperations() {
        if (operations == null) {
            operations = ((AnyType) OCLStandardLibraryImpl.INSTANCE.getOclAny())
                .oclOperations();
        }
        
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcorePackage.TUPLE_TYPE__SERIALIZABLE:
                return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EcorePackage.TUPLE_TYPE__SERIALIZABLE:
                setSerializable(((Boolean)newValue).booleanValue());
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
            case EcorePackage.TUPLE_TYPE__SERIALIZABLE:
                setSerializable(SERIALIZABLE_EDEFAULT);
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
            case EcorePackage.TUPLE_TYPE__SERIALIZABLE:
                return serializable != SERIALIZABLE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == EDataType.class) {
            switch (derivedFeatureID) {
                case EcorePackage.TUPLE_TYPE__SERIALIZABLE: return org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__SERIALIZABLE;
                default: return -1;
            }
        }
        if (baseClass == PredefinedType.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TupleType.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == EDataType.class) {
            switch (baseFeatureID) {
                case org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__SERIALIZABLE: return EcorePackage.TUPLE_TYPE__SERIALIZABLE;
                default: return -1;
            }
        }
        if (baseClass == PredefinedType.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TupleType.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (serializable: "); //$NON-NLS-1$
        result.append(serializable);
        result.append(')');
        return result.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getName() {
        if (name == null) {
            StringBuffer myName = new StringBuffer();
            myName.append(SINGLETON_NAME).append('(');
            
            for (Iterator<EStructuralFeature> iter = oclProperties().iterator(); iter.hasNext();) {
                EStructuralFeature next = iter.next();
                
                myName.append(next.getName());
                
                EClassifier type = next.getEType();
                if (type != null) {
                    myName.append(" : "); //$NON-NLS-1$
                    myName.append(type.getName());
                }
                
                if (iter.hasNext()) {
                    myName.append(", "); //$NON-NLS-1$
                }
            }
            
            myName.append(')');
            name = myName.toString();
        }
        
        return name;
    }

} //TupleTypeImpl
