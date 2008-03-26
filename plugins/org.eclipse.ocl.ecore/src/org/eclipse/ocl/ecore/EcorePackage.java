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
 * $Id: EcorePackage.java,v 1.5 2008/03/26 21:17:50 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.ecore.EcoreFactory
 * @model kind="package"
 * @generated
 */
public interface EcorePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "ecore"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/ocl/1.1.0/Ecore"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "ocl.ecore"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EcorePackage eINSTANCE = org.eclipse.ocl.ecore.impl.EcorePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.AnyTypeImpl <em>Any Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.AnyTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getAnyType()
     * @generated
     */
    int ANY_TYPE = 0;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The number of structural features of the '<em>Any Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CollectionTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionType()
     * @generated
     */
    int COLLECTION_TYPE = 2;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__SERIALIZABLE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__SERIALIZABLE;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__START_POSITION = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__END_POSITION = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_START_POSITION = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_END_POSITION = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ELEMENT_TYPE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__KIND = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Collection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.BagTypeImpl <em>Bag Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.BagTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getBagType()
     * @generated
     */
    int BAG_TYPE = 1;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Bag Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.ElementTypeImpl <em>Element Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.ElementTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getElementType()
     * @generated
     */
    int ELEMENT_TYPE = 3;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASS__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASS__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ABSTRACT = org.eclipse.emf.ecore.EcorePackage.ECLASS__ABSTRACT;

    /**
     * The feature id for the '<em><b>Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__INTERFACE = org.eclipse.emf.ecore.EcorePackage.ECLASS__INTERFACE;

    /**
     * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ESUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESUPER_TYPES;

    /**
     * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EOPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EOPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_ATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll References</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_REFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_REFERENCES;

    /**
     * The feature id for the '<em><b>EReferences</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EREFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EREFERENCES;

    /**
     * The feature id for the '<em><b>EAttributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_CONTAINMENTS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_CONTAINMENTS;

    /**
     * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_OPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_OPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_STRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EID Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EID_ATTRIBUTE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EID_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ESTRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EGENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EALL_GENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

    /**
     * The number of structural features of the '<em>Element Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.InvalidTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getInvalidType()
     * @generated
     */
    int INVALID_TYPE = 4;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The number of structural features of the '<em>Invalid Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.MessageTypeImpl <em>Message Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.MessageTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getMessageType()
     * @generated
     */
    int MESSAGE_TYPE = 5;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASS__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASS__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ABSTRACT = org.eclipse.emf.ecore.EcorePackage.ECLASS__ABSTRACT;

    /**
     * The feature id for the '<em><b>Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INTERFACE = org.eclipse.emf.ecore.EcorePackage.ECLASS__INTERFACE;

    /**
     * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ESUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESUPER_TYPES;

    /**
     * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EOPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EOPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_ATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll References</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_REFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_REFERENCES;

    /**
     * The feature id for the '<em><b>EReferences</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EREFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EREFERENCES;

    /**
     * The feature id for the '<em><b>EAttributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_CONTAINMENTS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_CONTAINMENTS;

    /**
     * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_OPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_OPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_STRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EID Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EID_ATTRIBUTE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EID_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ESTRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EGENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_GENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_OPERATION = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Referred Signal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_SIGNAL = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Message Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.OrderedSetTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOrderedSetType()
     * @generated
     */
    int ORDERED_SET_TYPE = 6;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Ordered Set Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.PrimitiveTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPrimitiveType()
     * @generated
     */
    int PRIMITIVE_TYPE = 7;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__SERIALIZABLE = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE__SERIALIZABLE;

    /**
     * The number of structural features of the '<em>Primitive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.SequenceTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSequenceType()
     * @generated
     */
    int SEQUENCE_TYPE = 8;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Sequence Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.SetTypeImpl <em>Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.SetTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSetType()
     * @generated
     */
    int SET_TYPE = 9;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Set Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.TupleTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleType()
     * @generated
     */
    int TUPLE_TYPE = 10;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASS__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASS__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ABSTRACT = org.eclipse.emf.ecore.EcorePackage.ECLASS__ABSTRACT;

    /**
     * The feature id for the '<em><b>Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INTERFACE = org.eclipse.emf.ecore.EcorePackage.ECLASS__INTERFACE;

    /**
     * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ESUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESUPER_TYPES;

    /**
     * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EOPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EOPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_ATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll References</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_REFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_REFERENCES;

    /**
     * The feature id for the '<em><b>EReferences</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EREFERENCES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EREFERENCES;

    /**
     * The feature id for the '<em><b>EAttributes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EATTRIBUTES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_CONTAINMENTS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_CONTAINMENTS;

    /**
     * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_OPERATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_OPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_STRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EID Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EID_ATTRIBUTE = org.eclipse.emf.ecore.EcorePackage.ECLASS__EID_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ESTRUCTURAL_FEATURES = org.eclipse.emf.ecore.EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EGENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_GENERIC_SUPER_TYPES = org.eclipse.emf.ecore.EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__SERIALIZABLE = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Tuple Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.TypeTypeImpl <em>Type Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.TypeTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTypeType()
     * @generated
     */
    int TYPE_TYPE = 11;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REFERRED_TYPE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.VoidTypeImpl <em>Void Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.VoidTypeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVoidType()
     * @generated
     */
    int VOID_TYPE = 12;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__INSTANCE_CLASS_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__INSTANCE_CLASS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__DEFAULT_VALUE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__INSTANCE_TYPE_NAME = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__EPACKAGE = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__ETYPE_PARAMETERS = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The number of structural features of the '<em>Void Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CallOperationActionImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCallOperationAction()
     * @generated
     */
    int CALL_OPERATION_ACTION = 13;

    /**
     * The feature id for the '<em><b>Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_OPERATION_ACTION__OPERATION = 0;

    /**
     * The number of structural features of the '<em>Call Operation Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_OPERATION_ACTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.ConstraintImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getConstraint()
     * @generated
     */
    int CONSTRAINT = 14;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__NAME = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Specification</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__SPECIFICATION = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Constrained Elements</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__CONSTRAINED_ELEMENTS = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__STEREOTYPE = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Constraint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.SendSignalActionImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSendSignalAction()
     * @generated
     */
    int SEND_SIGNAL_ACTION = 15;

    /**
     * The feature id for the '<em><b>Signal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_SIGNAL_ACTION__SIGNAL = 0;

    /**
     * The number of structural features of the '<em>Send Signal Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_SIGNAL_ACTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getExpressionInOCL()
     * @generated
     */
    int EXPRESSION_IN_OCL = 16;

    /**
     * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__BODY_EXPRESSION = UtilitiesPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION;

    /**
     * The feature id for the '<em><b>Context Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;

    /**
     * The feature id for the '<em><b>Result Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__RESULT_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE;

    /**
     * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE;

    /**
     * The number of structural features of the '<em>Expression In OCL</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL_FEATURE_COUNT = UtilitiesPackage.EXPRESSION_IN_OCL_FEATURE_COUNT + 0;


    /**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.OCLExpressionImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOCLExpression()
     * @generated
     */
	int OCL_EXPRESSION = 39;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__NAME = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__ORDERED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__UNIQUE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__LOWER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__UPPER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__MANY = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__REQUIRED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__ETYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__EGENERIC_TYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__START_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION__END_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>OCL Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CallExpImpl <em>Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCallExp()
     * @generated
     */
	int CALL_EXP = 19;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.FeatureCallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getFeatureCallExp()
     * @generated
     */
	int FEATURE_CALL_EXP = 25;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__EANNOTATIONS = CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__NAME = CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__ORDERED = CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__UNIQUE = CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__LOWER_BOUND = CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__UPPER_BOUND = CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__MANY = CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__REQUIRED = CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__ETYPE = CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__EGENERIC_TYPE = CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__START_POSITION = CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__END_POSITION = CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP__MARKED_PRE = CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Feature Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.NavigationCallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNavigationCallExp()
     * @generated
     */
	int NAVIGATION_CALL_EXP = 36;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__EANNOTATIONS = FEATURE_CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__ORDERED = FEATURE_CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__UNIQUE = FEATURE_CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__LOWER_BOUND = FEATURE_CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__UPPER_BOUND = FEATURE_CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__MANY = FEATURE_CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__REQUIRED = FEATURE_CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__ETYPE = FEATURE_CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__EGENERIC_TYPE = FEATURE_CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

				/**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Navigation Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.AssociationClassCallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getAssociationClassCallExp()
     * @generated
     */
	int ASSOCIATION_CLASS_CALL_EXP = 17;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__ORDERED = NAVIGATION_CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__UNIQUE = NAVIGATION_CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__LOWER_BOUND = NAVIGATION_CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__UPPER_BOUND = NAVIGATION_CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__MANY = NAVIGATION_CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__REQUIRED = NAVIGATION_CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__ETYPE = NAVIGATION_CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__EGENERIC_TYPE = NAVIGATION_CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

				/**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

				/**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

				/**
     * The feature id for the '<em><b>Referred Association Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Association Class Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.LiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLiteralExp()
     * @generated
     */
	int LITERAL_EXP = 33;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The number of structural features of the '<em>Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.PrimitiveLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPrimitiveLiteralExp()
     * @generated
     */
	int PRIMITIVE_LITERAL_EXP = 41;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.BooleanLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getBooleanLiteralExp()
     * @generated
     */
	int BOOLEAN_LITERAL_EXP = 18;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__ORDERED = PRIMITIVE_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__UNIQUE = PRIMITIVE_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__LOWER_BOUND = PRIMITIVE_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__UPPER_BOUND = PRIMITIVE_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__MANY = PRIMITIVE_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__REQUIRED = PRIMITIVE_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__ETYPE = PRIMITIVE_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__EGENERIC_TYPE = PRIMITIVE_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CollectionLiteralPartImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionLiteralPart()
     * @generated
     */
	int COLLECTION_LITERAL_PART = 22;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__NAME = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__ORDERED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__UNIQUE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__LOWER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__UPPER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__MANY = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__REQUIRED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__ETYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART__EGENERIC_TYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

				/**
     * The number of structural features of the '<em>Collection Literal Part</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CollectionItemImpl <em>Collection Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CollectionItemImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionItem()
     * @generated
     */
	int COLLECTION_ITEM = 20;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__NAME = COLLECTION_LITERAL_PART__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__ORDERED = COLLECTION_LITERAL_PART__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__UNIQUE = COLLECTION_LITERAL_PART__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__LOWER_BOUND = COLLECTION_LITERAL_PART__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__UPPER_BOUND = COLLECTION_LITERAL_PART__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__MANY = COLLECTION_LITERAL_PART__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__REQUIRED = COLLECTION_LITERAL_PART__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__ETYPE = COLLECTION_LITERAL_PART__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__EGENERIC_TYPE = COLLECTION_LITERAL_PART__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Collection Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CollectionLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionLiteralExp()
     * @generated
     */
	int COLLECTION_LITERAL_EXP = 21;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Part</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Simple Range</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP__SIMPLE_RANGE = LITERAL_EXP_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>Collection Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.CollectionRangeImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionRange()
     * @generated
     */
	int COLLECTION_RANGE = 23;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__NAME = COLLECTION_LITERAL_PART__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__ORDERED = COLLECTION_LITERAL_PART__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__UNIQUE = COLLECTION_LITERAL_PART__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__LOWER_BOUND = COLLECTION_LITERAL_PART__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__UPPER_BOUND = COLLECTION_LITERAL_PART__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__MANY = COLLECTION_LITERAL_PART__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__REQUIRED = COLLECTION_LITERAL_PART__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__ETYPE = COLLECTION_LITERAL_PART__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__EGENERIC_TYPE = COLLECTION_LITERAL_PART__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>First</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Last</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Collection Range</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.EnumLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getEnumLiteralExp()
     * @generated
     */
	int ENUM_LITERAL_EXP = 24;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Enum Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.IfExpImpl <em>If Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.IfExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIfExp()
     * @generated
     */
	int IF_EXP = 26;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>If Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.NumericLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNumericLiteralExp()
     * @generated
     */
	int NUMERIC_LITERAL_EXP = 38;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__ORDERED = PRIMITIVE_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__UNIQUE = PRIMITIVE_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__LOWER_BOUND = PRIMITIVE_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__UPPER_BOUND = PRIMITIVE_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__MANY = PRIMITIVE_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__REQUIRED = PRIMITIVE_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__ETYPE = PRIMITIVE_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__EGENERIC_TYPE = PRIMITIVE_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

				/**
     * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.IntegerLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIntegerLiteralExp()
     * @generated
     */
	int INTEGER_LITERAL_EXP = 27;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__ORDERED = NUMERIC_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__UNIQUE = NUMERIC_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__LOWER_BOUND = NUMERIC_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__UPPER_BOUND = NUMERIC_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__MANY = NUMERIC_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__REQUIRED = NUMERIC_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__ETYPE = NUMERIC_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__EGENERIC_TYPE = NUMERIC_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Integer Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.UnlimitedNaturalLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getUnlimitedNaturalLiteralExp()
     * @generated
     */
	int UNLIMITED_NATURAL_LITERAL_EXP = 28;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__ORDERED = NUMERIC_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__UNIQUE = NUMERIC_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__LOWER_BOUND = NUMERIC_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__UPPER_BOUND = NUMERIC_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__MANY = NUMERIC_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__REQUIRED = NUMERIC_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__ETYPE = NUMERIC_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__EGENERIC_TYPE = NUMERIC_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Unlimited</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.InvalidLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getInvalidLiteralExp()
     * @generated
     */
	int INVALID_LITERAL_EXP = 29;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.LoopExpImpl <em>Loop Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.LoopExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLoopExp()
     * @generated
     */
	int LOOP_EXP = 34;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__EANNOTATIONS = CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__NAME = CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__ORDERED = CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__UNIQUE = CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__LOWER_BOUND = CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__UPPER_BOUND = CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__MANY = CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__REQUIRED = CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__ETYPE = CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__EGENERIC_TYPE = CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__START_POSITION = CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__END_POSITION = CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP__ITERATOR = CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Loop Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.IterateExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIterateExp()
     * @generated
     */
	int ITERATE_EXP = 30;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__ORDERED = LOOP_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__UNIQUE = LOOP_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__LOWER_BOUND = LOOP_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__UPPER_BOUND = LOOP_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__MANY = LOOP_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__REQUIRED = LOOP_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__ETYPE = LOOP_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__EGENERIC_TYPE = LOOP_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__START_POSITION = LOOP_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__END_POSITION = LOOP_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

				/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

				/**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Iterate Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.IteratorExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIteratorExp()
     * @generated
     */
	int ITERATOR_EXP = 31;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__ORDERED = LOOP_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__UNIQUE = LOOP_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__LOWER_BOUND = LOOP_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__UPPER_BOUND = LOOP_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__MANY = LOOP_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__REQUIRED = LOOP_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__ETYPE = LOOP_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__EGENERIC_TYPE = LOOP_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__START_POSITION = LOOP_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__END_POSITION = LOOP_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

				/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

				/**
     * The number of structural features of the '<em>Iterator Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.LetExpImpl <em>Let Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.LetExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLetExp()
     * @generated
     */
	int LET_EXP = 32;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>In</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Let Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.MessageExpImpl <em>Message Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.MessageExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getMessageExp()
     * @generated
     */
	int MESSAGE_EXP = 35;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 2;

				/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Called Operation</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 4;

				/**
     * The feature id for the '<em><b>Sent Signal</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 5;

				/**
     * The number of structural features of the '<em>Message Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 6;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.NullLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNullLiteralExp()
     * @generated
     */
	int NULL_LITERAL_EXP = 37;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The number of structural features of the '<em>Null Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.OperationCallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOperationCallExp()
     * @generated
     */
	int OPERATION_CALL_EXP = 40;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__EANNOTATIONS = FEATURE_CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__ORDERED = FEATURE_CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__UNIQUE = FEATURE_CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__LOWER_BOUND = FEATURE_CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__UPPER_BOUND = FEATURE_CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__MANY = FEATURE_CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__REQUIRED = FEATURE_CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__ETYPE = FEATURE_CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__EGENERIC_TYPE = FEATURE_CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

				/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Operation Code</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP__OPERATION_CODE = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>Operation Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.PropertyCallExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPropertyCallExp()
     * @generated
     */
	int PROPERTY_CALL_EXP = 42;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__ORDERED = NAVIGATION_CALL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__UNIQUE = NAVIGATION_CALL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__LOWER_BOUND = NAVIGATION_CALL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__UPPER_BOUND = NAVIGATION_CALL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__MANY = NAVIGATION_CALL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__REQUIRED = NAVIGATION_CALL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__ETYPE = NAVIGATION_CALL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__EGENERIC_TYPE = NAVIGATION_CALL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

				/**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

				/**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

				/**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

				/**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

				/**
     * The feature id for the '<em><b>Referred Property</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Property Call Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.RealLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getRealLiteralExp()
     * @generated
     */
	int REAL_LITERAL_EXP = 43;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__ORDERED = NUMERIC_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__UNIQUE = NUMERIC_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__LOWER_BOUND = NUMERIC_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__UPPER_BOUND = NUMERIC_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__MANY = NUMERIC_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__REQUIRED = NUMERIC_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__ETYPE = NUMERIC_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__EGENERIC_TYPE = NUMERIC_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Real Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.StateExpImpl <em>State Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.StateExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getStateExp()
     * @generated
     */
	int STATE_EXP = 44;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Referred State</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>State Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.StringLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getStringLiteralExp()
     * @generated
     */
	int STRING_LITERAL_EXP = 45;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__ORDERED = PRIMITIVE_LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__UNIQUE = PRIMITIVE_LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__LOWER_BOUND = PRIMITIVE_LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__UPPER_BOUND = PRIMITIVE_LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__MANY = PRIMITIVE_LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__REQUIRED = PRIMITIVE_LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__ETYPE = PRIMITIVE_LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__EGENERIC_TYPE = PRIMITIVE_LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>String Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>String Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.TupleLiteralExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleLiteralExp()
     * @generated
     */
	int TUPLE_LITERAL_EXP = 46;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__ORDERED = LITERAL_EXP__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__UNIQUE = LITERAL_EXP__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__LOWER_BOUND = LITERAL_EXP__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__UPPER_BOUND = LITERAL_EXP__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__MANY = LITERAL_EXP__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__REQUIRED = LITERAL_EXP__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__ETYPE = LITERAL_EXP__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__EGENERIC_TYPE = LITERAL_EXP__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

				/**
     * The feature id for the '<em><b>Part</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleLiteralPart()
     * @generated
     */
	int TUPLE_LITERAL_PART = 47;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__NAME = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__ORDERED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__UNIQUE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__LOWER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__UPPER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__MANY = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__REQUIRED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__ETYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__EGENERIC_TYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__START_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__END_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__TYPE_START_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

				/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__TYPE_END_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__VALUE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 4;

				/**
     * The feature id for the '<em><b>Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART__ATTRIBUTE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 5;

				/**
     * The number of structural features of the '<em>Tuple Literal Part</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_PART_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 6;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.TypeExpImpl <em>Type Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.TypeExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTypeExp()
     * @generated
     */
	int TYPE_EXP = 48;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Type Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.UnspecifiedValueExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getUnspecifiedValueExp()
     * @generated
     */
	int UNSPECIFIED_VALUE_EXP = 49;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.VariableImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVariable()
     * @generated
     */
	int VARIABLE = 50;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__EANNOTATIONS = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__NAME = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__ORDERED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__UNIQUE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__LOWER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__UPPER_BOUND = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__MANY = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__REQUIRED = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__ETYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__EGENERIC_TYPE = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__START_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__END_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__TYPE_START_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

				/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__TYPE_END_POSITION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__INIT_EXPRESSION = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 4;

				/**
     * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__REPRESENTED_PARAMETER = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 5;

				/**
     * The number of structural features of the '<em>Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 6;

				/**
     * The meta object id for the '{@link org.eclipse.ocl.ecore.impl.VariableExpImpl <em>Variable Exp</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.ecore.impl.VariableExpImpl
     * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVariableExp()
     * @generated
     */
	int VARIABLE_EXP = 51;

				/**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

				/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__ORDERED = OCL_EXPRESSION__ORDERED;

				/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__UNIQUE = OCL_EXPRESSION__UNIQUE;

				/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__LOWER_BOUND = OCL_EXPRESSION__LOWER_BOUND;

				/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__UPPER_BOUND = OCL_EXPRESSION__UPPER_BOUND;

				/**
     * The feature id for the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__MANY = OCL_EXPRESSION__MANY;

				/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__REQUIRED = OCL_EXPRESSION__REQUIRED;

				/**
     * The feature id for the '<em><b>EType</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__ETYPE = OCL_EXPRESSION__ETYPE;

				/**
     * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__EGENERIC_TYPE = OCL_EXPRESSION__EGENERIC_TYPE;

				/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

				/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

				/**
     * The feature id for the '<em><b>Referred Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Variable Exp</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;


				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.AnyType <em>Any Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Any Type</em>'.
     * @see org.eclipse.ocl.ecore.AnyType
     * @generated
     */
    EClass getAnyType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.BagType <em>Bag Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Bag Type</em>'.
     * @see org.eclipse.ocl.ecore.BagType
     * @generated
     */
    EClass getBagType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Type</em>'.
     * @see org.eclipse.ocl.ecore.CollectionType
     * @generated
     */
    EClass getCollectionType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.ElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Type</em>'.
     * @see org.eclipse.ocl.ecore.ElementType
     * @generated
     */
    EClass getElementType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.InvalidType <em>Invalid Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Invalid Type</em>'.
     * @see org.eclipse.ocl.ecore.InvalidType
     * @generated
     */
    EClass getInvalidType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.MessageType <em>Message Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Type</em>'.
     * @see org.eclipse.ocl.ecore.MessageType
     * @generated
     */
    EClass getMessageType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.OrderedSetType <em>Ordered Set Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ordered Set Type</em>'.
     * @see org.eclipse.ocl.ecore.OrderedSetType
     * @generated
     */
    EClass getOrderedSetType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Type</em>'.
     * @see org.eclipse.ocl.ecore.PrimitiveType
     * @generated
     */
    EClass getPrimitiveType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.SequenceType <em>Sequence Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence Type</em>'.
     * @see org.eclipse.ocl.ecore.SequenceType
     * @generated
     */
    EClass getSequenceType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.SetType <em>Set Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Set Type</em>'.
     * @see org.eclipse.ocl.ecore.SetType
     * @generated
     */
    EClass getSetType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.TupleType <em>Tuple Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Type</em>'.
     * @see org.eclipse.ocl.ecore.TupleType
     * @generated
     */
    EClass getTupleType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.TypeType <em>Type Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Type</em>'.
     * @see org.eclipse.ocl.ecore.TypeType
     * @generated
     */
    EClass getTypeType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.VoidType <em>Void Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Void Type</em>'.
     * @see org.eclipse.ocl.ecore.VoidType
     * @generated
     */
    EClass getVoidType();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CallOperationAction <em>Call Operation Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Operation Action</em>'.
     * @see org.eclipse.ocl.ecore.CallOperationAction
     * @generated
     */
    EClass getCallOperationAction();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.ecore.CallOperationAction#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Operation</em>'.
     * @see org.eclipse.ocl.ecore.CallOperationAction#getOperation()
     * @see #getCallOperationAction()
     * @generated
     */
    EReference getCallOperationAction_Operation();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constraint</em>'.
     * @see org.eclipse.ocl.ecore.Constraint
     * @generated
     */
    EClass getConstraint();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.ecore.Constraint#getSpecification <em>Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Specification</em>'.
     * @see org.eclipse.ocl.ecore.Constraint#getSpecification()
     * @see #getConstraint()
     * @generated
     */
    EReference getConstraint_Specification();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.ocl.ecore.Constraint#getConstrainedElements <em>Constrained Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Constrained Elements</em>'.
     * @see org.eclipse.ocl.ecore.Constraint#getConstrainedElements()
     * @see #getConstraint()
     * @generated
     */
    EReference getConstraint_ConstrainedElements();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.ecore.Constraint#getStereotype <em>Stereotype</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stereotype</em>'.
     * @see org.eclipse.ocl.ecore.Constraint#getStereotype()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Stereotype();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.SendSignalAction <em>Send Signal Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Send Signal Action</em>'.
     * @see org.eclipse.ocl.ecore.SendSignalAction
     * @generated
     */
    EClass getSendSignalAction();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.ecore.SendSignalAction#getSignal <em>Signal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Signal</em>'.
     * @see org.eclipse.ocl.ecore.SendSignalAction#getSignal()
     * @see #getSendSignalAction()
     * @generated
     */
    EReference getSendSignalAction_Signal();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.ExpressionInOCL <em>Expression In OCL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression In OCL</em>'.
     * @see org.eclipse.ocl.ecore.ExpressionInOCL
     * @generated
     */
    EClass getExpressionInOCL();

    /**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association Class Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.AssociationClassCallExp
     * @generated
     */
	EClass getAssociationClassCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.BooleanLiteralExp
     * @generated
     */
	EClass getBooleanLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CallExp <em>Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.CallExp
     * @generated
     */
	EClass getCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CollectionItem <em>Collection Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Item</em>'.
     * @see org.eclipse.ocl.ecore.CollectionItem
     * @generated
     */
	EClass getCollectionItem();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.CollectionLiteralExp
     * @generated
     */
	EClass getCollectionLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CollectionLiteralPart <em>Collection Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Part</em>'.
     * @see org.eclipse.ocl.ecore.CollectionLiteralPart
     * @generated
     */
	EClass getCollectionLiteralPart();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.CollectionRange <em>Collection Range</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Range</em>'.
     * @see org.eclipse.ocl.ecore.CollectionRange
     * @generated
     */
	EClass getCollectionRange();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.EnumLiteralExp <em>Enum Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.EnumLiteralExp
     * @generated
     */
	EClass getEnumLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.FeatureCallExp <em>Feature Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.FeatureCallExp
     * @generated
     */
	EClass getFeatureCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.IfExp <em>If Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>If Exp</em>'.
     * @see org.eclipse.ocl.ecore.IfExp
     * @generated
     */
	EClass getIfExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.IntegerLiteralExp
     * @generated
     */
	EClass getIntegerLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp
     * @generated
     */
	EClass getUnlimitedNaturalLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Invalid Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.InvalidLiteralExp
     * @generated
     */
	EClass getInvalidLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.IterateExp <em>Iterate Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterate Exp</em>'.
     * @see org.eclipse.ocl.ecore.IterateExp
     * @generated
     */
	EClass getIterateExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.IteratorExp <em>Iterator Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterator Exp</em>'.
     * @see org.eclipse.ocl.ecore.IteratorExp
     * @generated
     */
	EClass getIteratorExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.LetExp <em>Let Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Let Exp</em>'.
     * @see org.eclipse.ocl.ecore.LetExp
     * @generated
     */
	EClass getLetExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.LiteralExp
     * @generated
     */
	EClass getLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.LoopExp <em>Loop Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Loop Exp</em>'.
     * @see org.eclipse.ocl.ecore.LoopExp
     * @generated
     */
	EClass getLoopExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.MessageExp <em>Message Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Exp</em>'.
     * @see org.eclipse.ocl.ecore.MessageExp
     * @generated
     */
	EClass getMessageExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.NavigationCallExp <em>Navigation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Navigation Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.NavigationCallExp
     * @generated
     */
	EClass getNavigationCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.NullLiteralExp <em>Null Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Null Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.NullLiteralExp
     * @generated
     */
	EClass getNullLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Numeric Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.NumericLiteralExp
     * @generated
     */
	EClass getNumericLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.OCLExpression <em>OCL Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>OCL Expression</em>'.
     * @see org.eclipse.ocl.ecore.OCLExpression
     * @generated
     */
	EClass getOCLExpression();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.OperationCallExp <em>Operation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.OperationCallExp
     * @generated
     */
	EClass getOperationCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.PrimitiveLiteralExp
     * @generated
     */
	EClass getPrimitiveLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.PropertyCallExp <em>Property Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Call Exp</em>'.
     * @see org.eclipse.ocl.ecore.PropertyCallExp
     * @generated
     */
	EClass getPropertyCallExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.RealLiteralExp <em>Real Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Real Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.RealLiteralExp
     * @generated
     */
	EClass getRealLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.StateExp <em>State Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>State Exp</em>'.
     * @see org.eclipse.ocl.ecore.StateExp
     * @generated
     */
	EClass getStateExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.StringLiteralExp <em>String Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.StringLiteralExp
     * @generated
     */
	EClass getStringLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Literal Exp</em>'.
     * @see org.eclipse.ocl.ecore.TupleLiteralExp
     * @generated
     */
	EClass getTupleLiteralExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.TupleLiteralPart <em>Tuple Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Literal Part</em>'.
     * @see org.eclipse.ocl.ecore.TupleLiteralPart
     * @generated
     */
	EClass getTupleLiteralPart();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.TypeExp <em>Type Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Exp</em>'.
     * @see org.eclipse.ocl.ecore.TypeExp
     * @generated
     */
	EClass getTypeExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unspecified Value Exp</em>'.
     * @see org.eclipse.ocl.ecore.UnspecifiedValueExp
     * @generated
     */
	EClass getUnspecifiedValueExp();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable</em>'.
     * @see org.eclipse.ocl.ecore.Variable
     * @generated
     */
	EClass getVariable();

				/**
     * Returns the meta object for class '{@link org.eclipse.ocl.ecore.VariableExp <em>Variable Exp</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable Exp</em>'.
     * @see org.eclipse.ocl.ecore.VariableExp
     * @generated
     */
	EClass getVariableExp();

				/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EcoreFactory getEcoreFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.AnyTypeImpl <em>Any Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.AnyTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getAnyType()
         * @generated
         */
        EClass ANY_TYPE = eINSTANCE.getAnyType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.BagTypeImpl <em>Bag Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.BagTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getBagType()
         * @generated
         */
        EClass BAG_TYPE = eINSTANCE.getBagType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CollectionTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionType()
         * @generated
         */
        EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.ElementTypeImpl <em>Element Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.ElementTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getElementType()
         * @generated
         */
        EClass ELEMENT_TYPE = eINSTANCE.getElementType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.InvalidTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getInvalidType()
         * @generated
         */
        EClass INVALID_TYPE = eINSTANCE.getInvalidType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.MessageTypeImpl <em>Message Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.MessageTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getMessageType()
         * @generated
         */
        EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.OrderedSetTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOrderedSetType()
         * @generated
         */
        EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.PrimitiveTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPrimitiveType()
         * @generated
         */
        EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.SequenceTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSequenceType()
         * @generated
         */
        EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.SetTypeImpl <em>Set Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.SetTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSetType()
         * @generated
         */
        EClass SET_TYPE = eINSTANCE.getSetType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.TupleTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleType()
         * @generated
         */
        EClass TUPLE_TYPE = eINSTANCE.getTupleType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.TypeTypeImpl <em>Type Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.TypeTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTypeType()
         * @generated
         */
        EClass TYPE_TYPE = eINSTANCE.getTypeType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.VoidTypeImpl <em>Void Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.VoidTypeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVoidType()
         * @generated
         */
        EClass VOID_TYPE = eINSTANCE.getVoidType();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CallOperationActionImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCallOperationAction()
         * @generated
         */
        EClass CALL_OPERATION_ACTION = eINSTANCE.getCallOperationAction();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALL_OPERATION_ACTION__OPERATION = eINSTANCE.getCallOperationAction_Operation();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.ConstraintImpl <em>Constraint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.ConstraintImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getConstraint()
         * @generated
         */
        EClass CONSTRAINT = eINSTANCE.getConstraint();

        /**
         * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONSTRAINT__SPECIFICATION = eINSTANCE.getConstraint_Specification();

        /**
         * The meta object literal for the '<em><b>Constrained Elements</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONSTRAINT__CONSTRAINED_ELEMENTS = eINSTANCE.getConstraint_ConstrainedElements();

        /**
         * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTRAINT__STEREOTYPE = eINSTANCE.getConstraint_Stereotype();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.SendSignalActionImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getSendSignalAction()
         * @generated
         */
        EClass SEND_SIGNAL_ACTION = eINSTANCE.getSendSignalAction();

        /**
         * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SEND_SIGNAL_ACTION__SIGNAL = eINSTANCE.getSendSignalAction_Signal();

        /**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getExpressionInOCL()
         * @generated
         */
        EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.AssociationClassCallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getAssociationClassCallExp()
         * @generated
         */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE.getAssociationClassCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.BooleanLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getBooleanLiteralExp()
         * @generated
         */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CallExpImpl <em>Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCallExp()
         * @generated
         */
		EClass CALL_EXP = eINSTANCE.getCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CollectionItemImpl <em>Collection Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CollectionItemImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionItem()
         * @generated
         */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CollectionLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionLiteralExp()
         * @generated
         */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CollectionLiteralPartImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionLiteralPart()
         * @generated
         */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.CollectionRangeImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getCollectionRange()
         * @generated
         */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.EnumLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getEnumLiteralExp()
         * @generated
         */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.FeatureCallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getFeatureCallExp()
         * @generated
         */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.IfExpImpl <em>If Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.IfExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIfExp()
         * @generated
         */
		EClass IF_EXP = eINSTANCE.getIfExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.IntegerLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIntegerLiteralExp()
         * @generated
         */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.UnlimitedNaturalLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getUnlimitedNaturalLiteralExp()
         * @generated
         */
		EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.InvalidLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getInvalidLiteralExp()
         * @generated
         */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.IterateExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIterateExp()
         * @generated
         */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.IteratorExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getIteratorExp()
         * @generated
         */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.LetExpImpl <em>Let Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.LetExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLetExp()
         * @generated
         */
		EClass LET_EXP = eINSTANCE.getLetExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.LiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLiteralExp()
         * @generated
         */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.LoopExpImpl <em>Loop Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.LoopExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getLoopExp()
         * @generated
         */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.MessageExpImpl <em>Message Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.MessageExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getMessageExp()
         * @generated
         */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.NavigationCallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNavigationCallExp()
         * @generated
         */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.NullLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNullLiteralExp()
         * @generated
         */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.NumericLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getNumericLiteralExp()
         * @generated
         */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.OCLExpressionImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOCLExpression()
         * @generated
         */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.OperationCallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getOperationCallExp()
         * @generated
         */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.PrimitiveLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPrimitiveLiteralExp()
         * @generated
         */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.PropertyCallExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getPropertyCallExp()
         * @generated
         */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.RealLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getRealLiteralExp()
         * @generated
         */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.StateExpImpl <em>State Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.StateExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getStateExp()
         * @generated
         */
		EClass STATE_EXP = eINSTANCE.getStateExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.StringLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getStringLiteralExp()
         * @generated
         */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.TupleLiteralExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleLiteralExp()
         * @generated
         */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTupleLiteralPart()
         * @generated
         */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.TypeExpImpl <em>Type Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.TypeExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getTypeExp()
         * @generated
         */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.UnspecifiedValueExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getUnspecifiedValueExp()
         * @generated
         */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.VariableImpl <em>Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.VariableImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVariable()
         * @generated
         */
		EClass VARIABLE = eINSTANCE.getVariable();

								/**
         * The meta object literal for the '{@link org.eclipse.ocl.ecore.impl.VariableExpImpl <em>Variable Exp</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.ecore.impl.VariableExpImpl
         * @see org.eclipse.ocl.ecore.impl.EcorePackageImpl#getVariableExp()
         * @generated
         */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

    }

} //EcorePackage
