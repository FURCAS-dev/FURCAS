/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case008;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Factory
 * @model kind="package"
 * @generated
 */
public interface Case008Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case008"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case008"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case008"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case008Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.S8Impl <em>S8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.S8Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getS8()
	 * @generated
	 */
	int S8 = 0;

	/**
	 * The feature id for the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S8__FIELD1 = 0;

	/**
	 * The feature id for the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S8__FIELD2 = 1;

	/**
	 * The feature id for the '<em><b>Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S8__STRUCTURE1 = 2;

	/**
	 * The number of structural features of the '<em>S8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S8_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.T8Impl <em>T8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.T8Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getT8()
	 * @generated
	 */
	int T8 = 1;

	/**
	 * The feature id for the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int T8__FIELD1 = 0;

	/**
	 * The feature id for the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int T8__FIELD2 = 1;

	/**
	 * The number of structural features of the '<em>T8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int T8_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.A8Impl <em>A8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.A8Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getA8()
	 * @generated
	 */
	int A8 = 2;

	/**
	 * The feature id for the '<em><b>One Enumeration E</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__ONE_ENUMERATION_E = 0;

	/**
	 * The feature id for the '<em><b>One Structure S</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__ONE_STRUCTURE_S = 1;

	/**
	 * The feature id for the '<em><b>One Structure T</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__ONE_STRUCTURE_T = 2;

	/**
	 * The feature id for the '<em><b>One Structure V</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__ONE_STRUCTURE_V = 3;

	/**
	 * The feature id for the '<em><b>Many Enumeration E</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__MANY_ENUMERATION_E = 4;

	/**
	 * The feature id for the '<em><b>Many Structure S</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__MANY_STRUCTURE_S = 5;

	/**
	 * The number of structural features of the '<em>A8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.U8Impl <em>U8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.U8Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getU8()
	 * @generated
	 */
	int U8 = 3;

	/**
	 * The feature id for the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int U8__FIELD1 = T8__FIELD1;

	/**
	 * The feature id for the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int U8__FIELD2 = T8__FIELD2;

	/**
	 * The feature id for the '<em><b>Sub Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int U8__SUB_FIELD1 = T8_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>U8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int U8_FEATURE_COUNT = T8_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.V8Impl <em>V8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.V8Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getV8()
	 * @generated
	 */
	int V8 = 4;

	/**
	 * The feature id for the '<em><b>Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int V8__STRUCTURE1 = 0;

	/**
	 * The number of structural features of the '<em>V8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int V8_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.E8 <em>E8</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getE8()
	 * @generated
	 */
	int E8 = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.S8 <em>S8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>S8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.S8
	 * @generated
	 */
	EClass getS8();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.S8#getField1 <em>Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.S8#getField1()
	 * @see #getS8()
	 * @generated
	 */
	EAttribute getS8_Field1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.S8#getField2 <em>Field2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.S8#getField2()
	 * @see #getS8()
	 * @generated
	 */
	EAttribute getS8_Field2();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.S8#getStructure1 <em>Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.S8#getStructure1()
	 * @see #getS8()
	 * @generated
	 */
	EReference getS8_Structure1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8 <em>T8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>T8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.T8
	 * @generated
	 */
	EClass getT8();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField1 <em>Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField1()
	 * @see #getT8()
	 * @generated
	 */
	EAttribute getT8_Field1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField2 <em>Field2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField2()
	 * @see #getT8()
	 * @generated
	 */
	EAttribute getT8_Field2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8 <em>A8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8
	 * @generated
	 */
	EClass getA8();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneEnumerationE <em>One Enumeration E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Enumeration E</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneEnumerationE()
	 * @see #getA8()
	 * @generated
	 */
	EAttribute getA8_OneEnumerationE();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureS <em>One Structure S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Structure S</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureS()
	 * @see #getA8()
	 * @generated
	 */
	EReference getA8_OneStructureS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureT <em>One Structure T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Structure T</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureT()
	 * @see #getA8()
	 * @generated
	 */
	EReference getA8_OneStructureT();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureV <em>One Structure V</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Structure V</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureV()
	 * @see #getA8()
	 * @generated
	 */
	EReference getA8_OneStructureV();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyEnumerationE <em>Many Enumeration E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Enumeration E</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyEnumerationE()
	 * @see #getA8()
	 * @generated
	 */
	EAttribute getA8_ManyEnumerationE();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyStructureS <em>Many Structure S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Structure S</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyStructureS()
	 * @see #getA8()
	 * @generated
	 */
	EReference getA8_ManyStructureS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.U8 <em>U8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>U8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.U8
	 * @generated
	 */
	EClass getU8();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.U8#isSubField1 <em>Sub Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.U8#isSubField1()
	 * @see #getU8()
	 * @generated
	 */
	EAttribute getU8_SubField1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.V8 <em>V8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>V8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.V8
	 * @generated
	 */
	EClass getV8();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.V8#getStructure1 <em>Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.V8#getStructure1()
	 * @see #getV8()
	 * @generated
	 */
	EReference getV8_Structure1();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.query2.test.mm.testcases.case008.E8 <em>E8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>E8</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
	 * @generated
	 */
	EEnum getE8();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case008Factory getCase008Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.S8Impl <em>S8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.S8Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getS8()
		 * @generated
		 */
		EClass S8 = eINSTANCE.getS8();

		/**
		 * The meta object literal for the '<em><b>Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute S8__FIELD1 = eINSTANCE.getS8_Field1();

		/**
		 * The meta object literal for the '<em><b>Field2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute S8__FIELD2 = eINSTANCE.getS8_Field2();

		/**
		 * The meta object literal for the '<em><b>Structure1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference S8__STRUCTURE1 = eINSTANCE.getS8_Structure1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.T8Impl <em>T8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.T8Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getT8()
		 * @generated
		 */
		EClass T8 = eINSTANCE.getT8();

		/**
		 * The meta object literal for the '<em><b>Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute T8__FIELD1 = eINSTANCE.getT8_Field1();

		/**
		 * The meta object literal for the '<em><b>Field2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute T8__FIELD2 = eINSTANCE.getT8_Field2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.A8Impl <em>A8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.A8Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getA8()
		 * @generated
		 */
		EClass A8 = eINSTANCE.getA8();

		/**
		 * The meta object literal for the '<em><b>One Enumeration E</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A8__ONE_ENUMERATION_E = eINSTANCE.getA8_OneEnumerationE();

		/**
		 * The meta object literal for the '<em><b>One Structure S</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8__ONE_STRUCTURE_S = eINSTANCE.getA8_OneStructureS();

		/**
		 * The meta object literal for the '<em><b>One Structure T</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8__ONE_STRUCTURE_T = eINSTANCE.getA8_OneStructureT();

		/**
		 * The meta object literal for the '<em><b>One Structure V</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8__ONE_STRUCTURE_V = eINSTANCE.getA8_OneStructureV();

		/**
		 * The meta object literal for the '<em><b>Many Enumeration E</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A8__MANY_ENUMERATION_E = eINSTANCE.getA8_ManyEnumerationE();

		/**
		 * The meta object literal for the '<em><b>Many Structure S</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8__MANY_STRUCTURE_S = eINSTANCE.getA8_ManyStructureS();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.U8Impl <em>U8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.U8Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getU8()
		 * @generated
		 */
		EClass U8 = eINSTANCE.getU8();

		/**
		 * The meta object literal for the '<em><b>Sub Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute U8__SUB_FIELD1 = eINSTANCE.getU8_SubField1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.V8Impl <em>V8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.V8Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getV8()
		 * @generated
		 */
		EClass V8 = eINSTANCE.getV8();

		/**
		 * The meta object literal for the '<em><b>Structure1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference V8__STRUCTURE1 = eINSTANCE.getV8_Structure1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.E8 <em>E8</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl#getE8()
		 * @generated
		 */
		EEnum E8 = eINSTANCE.getE8();

	}

} //Case008Package
