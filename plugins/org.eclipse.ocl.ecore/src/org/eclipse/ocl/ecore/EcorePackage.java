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
 * $Id: EcorePackage.java,v 1.2 2007/02/14 13:42:03 cdamus Exp $
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
     * The number of structural features of the '<em>Tuple Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE_FEATURE_COUNT = org.eclipse.emf.ecore.EcorePackage.ECLASS_FEATURE_COUNT + 0;

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

    }

} //EcorePackage
