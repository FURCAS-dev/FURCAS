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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritanceFactory
 * @model kind="package"
 * @generated
 */
public interface InheritancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "inheritance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case008/inheritance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case008inheritance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InheritancePackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl <em>Super Structure1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSuperStructure1()
	 * @generated
	 */
	int SUPER_STRUCTURE1 = 0;

	/**
	 * The feature id for the '<em><b>Super Field1 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_STRUCTURE1__SUPER_FIELD1_FROM1 = 0;

	/**
	 * The feature id for the '<em><b>Super Field2 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_STRUCTURE1__SUPER_FIELD2_FROM1 = 1;

	/**
	 * The number of structural features of the '<em>Super Structure1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_STRUCTURE1_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure1Impl <em>Sub Structure1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructure1()
	 * @generated
	 */
	int SUB_STRUCTURE1 = 1;

	/**
	 * The feature id for the '<em><b>Super Field1 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE1__SUPER_FIELD1_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD1_FROM1;

	/**
	 * The feature id for the '<em><b>Super Field2 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE1__SUPER_FIELD2_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD2_FROM1;

	/**
	 * The feature id for the '<em><b>Sub Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE1__SUB_FIELD1 = SUPER_STRUCTURE1_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Structure1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE1_FEATURE_COUNT = SUPER_STRUCTURE1_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl <em>Sub Structure2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructure2()
	 * @generated
	 */
	int SUB_STRUCTURE2 = 2;

	/**
	 * The feature id for the '<em><b>Super Field1 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUPER_FIELD1_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD1_FROM1;

	/**
	 * The feature id for the '<em><b>Super Field2 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUPER_FIELD2_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD2_FROM1;

	/**
	 * The feature id for the '<em><b>Super Field1 From2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUPER_FIELD1_FROM2 = SUPER_STRUCTURE1_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUB_FIELD1 = SUPER_STRUCTURE1_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUB_FIELD2 = SUPER_STRUCTURE1_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Field3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUB_FIELD3 = SUPER_STRUCTURE1_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub Field4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUB_FIELD4 = SUPER_STRUCTURE1_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Field5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2__SUB_FIELD5 = SUPER_STRUCTURE1_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Sub Structure2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE2_FEATURE_COUNT = SUPER_STRUCTURE1_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure2Impl <em>Super Structure2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSuperStructure2()
	 * @generated
	 */
	int SUPER_STRUCTURE2 = 3;

	/**
	 * The feature id for the '<em><b>Super Field1 From2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_STRUCTURE2__SUPER_FIELD1_FROM2 = 0;

	/**
	 * The number of structural features of the '<em>Super Structure2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_STRUCTURE2_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructureWithoutFieldsImpl <em>Sub Structure Without Fields</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructureWithoutFieldsImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructureWithoutFields()
	 * @generated
	 */
	int SUB_STRUCTURE_WITHOUT_FIELDS = 4;

	/**
	 * The feature id for the '<em><b>Super Field1 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE_WITHOUT_FIELDS__SUPER_FIELD1_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD1_FROM1;

	/**
	 * The feature id for the '<em><b>Super Field2 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE_WITHOUT_FIELDS__SUPER_FIELD2_FROM1 = SUPER_STRUCTURE1__SUPER_FIELD2_FROM1;

	/**
	 * The number of structural features of the '<em>Sub Structure Without Fields</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_STRUCTURE_WITHOUT_FIELDS_FEATURE_COUNT = SUPER_STRUCTURE1_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl <em>A8 Inheritance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getA8Inheritance()
	 * @generated
	 */
	int A8_INHERITANCE = 5;

	/**
	 * The feature id for the '<em><b>Many Super Structure1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE__MANY_SUPER_STRUCTURE1 = 0;

	/**
	 * The feature id for the '<em><b>One Super Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE__ONE_SUPER_STRUCTURE1 = 1;

	/**
	 * The feature id for the '<em><b>One Super Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE__ONE_SUPER_STRUCTURE2 = 2;

	/**
	 * The feature id for the '<em><b>One Sub Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE__ONE_SUB_STRUCTURE1 = 3;

	/**
	 * The feature id for the '<em><b>One Sub Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE__ONE_SUB_STRUCTURE2 = 4;

	/**
	 * The number of structural features of the '<em>A8 Inheritance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_INHERITANCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.B8InheritanceImpl <em>B8 Inheritance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.B8InheritanceImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getB8Inheritance()
	 * @generated
	 */
	int B8_INHERITANCE = 6;

	/**
	 * The feature id for the '<em><b>Many Super Structure1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE__MANY_SUPER_STRUCTURE1 = A8_INHERITANCE__MANY_SUPER_STRUCTURE1;

	/**
	 * The feature id for the '<em><b>One Super Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE__ONE_SUPER_STRUCTURE1 = A8_INHERITANCE__ONE_SUPER_STRUCTURE1;

	/**
	 * The feature id for the '<em><b>One Super Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE__ONE_SUPER_STRUCTURE2 = A8_INHERITANCE__ONE_SUPER_STRUCTURE2;

	/**
	 * The feature id for the '<em><b>One Sub Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE__ONE_SUB_STRUCTURE1 = A8_INHERITANCE__ONE_SUB_STRUCTURE1;

	/**
	 * The feature id for the '<em><b>One Sub Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE__ONE_SUB_STRUCTURE2 = A8_INHERITANCE__ONE_SUB_STRUCTURE2;

	/**
	 * The number of structural features of the '<em>B8 Inheritance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_INHERITANCE_FEATURE_COUNT = A8_INHERITANCE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1 <em>Super Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1
	 * @generated
	 */
	EClass getSuperStructure1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField1From1 <em>Super Field1 From1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Field1 From1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField1From1()
	 * @see #getSuperStructure1()
	 * @generated
	 */
	EAttribute getSuperStructure1_SuperField1From1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField2From1 <em>Super Field2 From1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Field2 From1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField2From1()
	 * @see #getSuperStructure1()
	 * @generated
	 */
	EAttribute getSuperStructure1_SuperField2From1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1 <em>Sub Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1
	 * @generated
	 */
	EClass getSubStructure1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1#getSubField1 <em>Sub Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1#getSubField1()
	 * @see #getSubStructure1()
	 * @generated
	 */
	EAttribute getSubStructure1_SubField1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2 <em>Sub Structure2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Structure2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2
	 * @generated
	 */
	EClass getSubStructure2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField1 <em>Sub Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField1()
	 * @see #getSubStructure2()
	 * @generated
	 */
	EAttribute getSubStructure2_SubField1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField2 <em>Sub Field2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField2()
	 * @see #getSubStructure2()
	 * @generated
	 */
	EAttribute getSubStructure2_SubField2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField3 <em>Sub Field3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField3()
	 * @see #getSubStructure2()
	 * @generated
	 */
	EAttribute getSubStructure2_SubField3();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField4 <em>Sub Field4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField4()
	 * @see #getSubStructure2()
	 * @generated
	 */
	EAttribute getSubStructure2_SubField4();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField5 <em>Sub Field5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Field5</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure2#getSubField5()
	 * @see #getSubStructure2()
	 * @generated
	 */
	EAttribute getSubStructure2_SubField5();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2 <em>Super Structure2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Structure2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2
	 * @generated
	 */
	EClass getSuperStructure2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2#getSuperField1From2 <em>Super Field1 From2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Field1 From2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2#getSuperField1From2()
	 * @see #getSuperStructure2()
	 * @generated
	 */
	EAttribute getSuperStructure2_SuperField1From2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructureWithoutFields <em>Sub Structure Without Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Structure Without Fields</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructureWithoutFields
	 * @generated
	 */
	EClass getSubStructureWithoutFields();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance <em>A8 Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A8 Inheritance</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance
	 * @generated
	 */
	EClass getA8Inheritance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getManySuperStructure1 <em>Many Super Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Super Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getManySuperStructure1()
	 * @see #getA8Inheritance()
	 * @generated
	 */
	EReference getA8Inheritance_ManySuperStructure1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure1 <em>One Super Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Super Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure1()
	 * @see #getA8Inheritance()
	 * @generated
	 */
	EReference getA8Inheritance_OneSuperStructure1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure2 <em>One Super Structure2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Super Structure2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure2()
	 * @see #getA8Inheritance()
	 * @generated
	 */
	EReference getA8Inheritance_OneSuperStructure2();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure1 <em>One Sub Structure1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Sub Structure1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure1()
	 * @see #getA8Inheritance()
	 * @generated
	 */
	EReference getA8Inheritance_OneSubStructure1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure2 <em>One Sub Structure2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Sub Structure2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure2()
	 * @see #getA8Inheritance()
	 * @generated
	 */
	EReference getA8Inheritance_OneSubStructure2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.B8Inheritance <em>B8 Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B8 Inheritance</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.B8Inheritance
	 * @generated
	 */
	EClass getB8Inheritance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InheritanceFactory getInheritanceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl <em>Super Structure1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSuperStructure1()
		 * @generated
		 */
		EClass SUPER_STRUCTURE1 = eINSTANCE.getSuperStructure1();

		/**
		 * The meta object literal for the '<em><b>Super Field1 From1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_STRUCTURE1__SUPER_FIELD1_FROM1 = eINSTANCE.getSuperStructure1_SuperField1From1();

		/**
		 * The meta object literal for the '<em><b>Super Field2 From1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_STRUCTURE1__SUPER_FIELD2_FROM1 = eINSTANCE.getSuperStructure1_SuperField2From1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure1Impl <em>Sub Structure1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructure1()
		 * @generated
		 */
		EClass SUB_STRUCTURE1 = eINSTANCE.getSubStructure1();

		/**
		 * The meta object literal for the '<em><b>Sub Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE1__SUB_FIELD1 = eINSTANCE.getSubStructure1_SubField1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl <em>Sub Structure2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructure2()
		 * @generated
		 */
		EClass SUB_STRUCTURE2 = eINSTANCE.getSubStructure2();

		/**
		 * The meta object literal for the '<em><b>Sub Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE2__SUB_FIELD1 = eINSTANCE.getSubStructure2_SubField1();

		/**
		 * The meta object literal for the '<em><b>Sub Field2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE2__SUB_FIELD2 = eINSTANCE.getSubStructure2_SubField2();

		/**
		 * The meta object literal for the '<em><b>Sub Field3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE2__SUB_FIELD3 = eINSTANCE.getSubStructure2_SubField3();

		/**
		 * The meta object literal for the '<em><b>Sub Field4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE2__SUB_FIELD4 = eINSTANCE.getSubStructure2_SubField4();

		/**
		 * The meta object literal for the '<em><b>Sub Field5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_STRUCTURE2__SUB_FIELD5 = eINSTANCE.getSubStructure2_SubField5();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure2Impl <em>Super Structure2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSuperStructure2()
		 * @generated
		 */
		EClass SUPER_STRUCTURE2 = eINSTANCE.getSuperStructure2();

		/**
		 * The meta object literal for the '<em><b>Super Field1 From2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_STRUCTURE2__SUPER_FIELD1_FROM2 = eINSTANCE.getSuperStructure2_SuperField1From2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructureWithoutFieldsImpl <em>Sub Structure Without Fields</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructureWithoutFieldsImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getSubStructureWithoutFields()
		 * @generated
		 */
		EClass SUB_STRUCTURE_WITHOUT_FIELDS = eINSTANCE.getSubStructureWithoutFields();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl <em>A8 Inheritance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.A8InheritanceImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getA8Inheritance()
		 * @generated
		 */
		EClass A8_INHERITANCE = eINSTANCE.getA8Inheritance();

		/**
		 * The meta object literal for the '<em><b>Many Super Structure1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8_INHERITANCE__MANY_SUPER_STRUCTURE1 = eINSTANCE.getA8Inheritance_ManySuperStructure1();

		/**
		 * The meta object literal for the '<em><b>One Super Structure1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8_INHERITANCE__ONE_SUPER_STRUCTURE1 = eINSTANCE.getA8Inheritance_OneSuperStructure1();

		/**
		 * The meta object literal for the '<em><b>One Super Structure2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8_INHERITANCE__ONE_SUPER_STRUCTURE2 = eINSTANCE.getA8Inheritance_OneSuperStructure2();

		/**
		 * The meta object literal for the '<em><b>One Sub Structure1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8_INHERITANCE__ONE_SUB_STRUCTURE1 = eINSTANCE.getA8Inheritance_OneSubStructure1();

		/**
		 * The meta object literal for the '<em><b>One Sub Structure2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A8_INHERITANCE__ONE_SUB_STRUCTURE2 = eINSTANCE.getA8Inheritance_OneSubStructure2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.B8InheritanceImpl <em>B8 Inheritance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.B8InheritanceImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl#getB8Inheritance()
		 * @generated
		 */
		EClass B8_INHERITANCE = eINSTANCE.getB8Inheritance();

	}

} //InheritancePackage
