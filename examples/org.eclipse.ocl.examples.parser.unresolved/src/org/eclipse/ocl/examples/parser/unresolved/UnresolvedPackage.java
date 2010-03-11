/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnresolvedPackage.java,v 1.1 2010/03/11 11:54:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unresolved;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedFactory
 * @model kind="package"
 * @generated
 */
public interface UnresolvedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "unresolved";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0/Unresolved";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "unresolved";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UnresolvedPackage eINSTANCE = org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedClass()
	 * @generated
	 */
	int UNRESOLVED_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Unresolved Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Unresolved Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CLASS__UNRESOLVED_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Unresolved Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CLASS__UNRESOLVED_PROPERTY = 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CLASS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassifierImpl
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedClassifier()
	 * @generated
	 */
	int UNRESOLVED_CLASSIFIER = 1;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CLASSIFIER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum <em>Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedEnum()
	 * @generated
	 */
	int UNRESOLVED_ENUM = 2;

	/**
	 * The meta object id for the '<em>Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedDataType()
	 * @generated
	 */
	int UNRESOLVED_DATA_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass
	 * @generated
	 */
	EClass getUnresolvedClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedAttribute <em>Unresolved Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unresolved Attribute</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedAttribute()
	 * @see #getUnresolvedClass()
	 * @generated
	 */
	EAttribute getUnresolvedClass_UnresolvedAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedReference <em>Unresolved Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unresolved Reference</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedReference()
	 * @see #getUnresolvedClass()
	 * @generated
	 */
	EReference getUnresolvedClass_UnresolvedReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedProperty <em>Unresolved Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unresolved Property</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedProperty()
	 * @see #getUnresolvedClass()
	 * @generated
	 */
	EReference getUnresolvedClass_UnresolvedProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedClassifier
	 * @generated
	 */
	EClass getUnresolvedClassifier();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum</em>'.
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum
	 * @generated
	 */
	EEnum getUnresolvedEnum();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Data Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUnresolvedDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UnresolvedFactory getUnresolvedFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedClass()
		 * @generated
		 */
		EClass UNRESOLVED_CLASS = eINSTANCE.getUnresolvedClass();

		/**
		 * The meta object literal for the '<em><b>Unresolved Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE = eINSTANCE.getUnresolvedClass_UnresolvedAttribute();

		/**
		 * The meta object literal for the '<em><b>Unresolved Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_CLASS__UNRESOLVED_REFERENCE = eINSTANCE.getUnresolvedClass_UnresolvedReference();

		/**
		 * The meta object literal for the '<em><b>Unresolved Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_CLASS__UNRESOLVED_PROPERTY = eINSTANCE.getUnresolvedClass_UnresolvedProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassifierImpl
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedClassifier()
		 * @generated
		 */
		EClass UNRESOLVED_CLASSIFIER = eINSTANCE.getUnresolvedClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum <em>Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedEnum()
		 * @generated
		 */
		EEnum UNRESOLVED_ENUM = eINSTANCE.getUnresolvedEnum();

		/**
		 * The meta object literal for the '<em>Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedPackageImpl#getUnresolvedDataType()
		 * @generated
		 */
		EDataType UNRESOLVED_DATA_TYPE = eINSTANCE.getUnresolvedDataType();

	}

} //UnresolvedPackage
