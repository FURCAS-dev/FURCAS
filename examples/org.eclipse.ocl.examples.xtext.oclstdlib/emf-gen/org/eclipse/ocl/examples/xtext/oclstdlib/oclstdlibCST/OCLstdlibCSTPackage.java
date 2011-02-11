/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLstdlibCSTPackage.java,v 1.7 2011/02/11 20:59:24 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

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
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface OCLstdlibCSTPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclstdlibCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/OCLstdlibCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclstdlibCST";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibAccumulatorCSImpl <em>Lib Accumulator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibAccumulatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibAccumulatorCS()
	 * @generated
	 */
	int LIB_ACCUMULATOR_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibConstraintCS()
	 * @generated
	 */
	int LIB_CONSTRAINT_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIterationCS()
	 * @generated
	 */
	int LIB_ITERATION_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIteratorCSImpl <em>Lib Iterator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIteratorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIteratorCS()
	 * @generated
	 */
	int LIB_ITERATOR_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibOperationCS()
	 * @generated
	 */
	int LIB_OPERATION_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPropertyCS()
	 * @generated
	 */
	int LIB_PROPERTY_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibRootPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibRootPackageCS()
	 * @generated
	 */
	int LIB_ROOT_PACKAGE_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS <em>Java Implementation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getJavaImplementationCS()
	 * @generated
	 */
	int JAVA_IMPLEMENTATION_CS = 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = 0;

	/**
	 * The number of structural features of the '<em>Java Implementation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPLEMENTATION_CS_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__OWNED_ANNOTATION = BaseCSTPackage.PARAMETER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__PIVOT = BaseCSTPackage.PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__ORIGINAL_XMI_ID = BaseCSTPackage.PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__MONIKER = BaseCSTPackage.PARAMETER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__NAME = BaseCSTPackage.PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__LOWER = BaseCSTPackage.PARAMETER_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__MULTIPLICITY = BaseCSTPackage.PARAMETER_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__OWNED_TYPE = BaseCSTPackage.PARAMETER_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__UPPER = BaseCSTPackage.PARAMETER_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__OWNED_CONSTRAINT = BaseCSTPackage.PARAMETER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__QUALIFIER = BaseCSTPackage.PARAMETER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS__OWNER = BaseCSTPackage.PARAMETER_CS__OWNER;

	/**
	 * The number of structural features of the '<em>Lib Accumulator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ACCUMULATOR_CS_FEATURE_COUNT = BaseCSTPackage.PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassCS()
	 * @generated
	 */
	int LIB_CLASS_CS = 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_ANNOTATION = BaseCSTPackage.CLASS_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__PIVOT = BaseCSTPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__MONIKER = BaseCSTPackage.CLASS_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__NAME = BaseCSTPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSTPackage.CLASS_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNER = BaseCSTPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__INSTANCE_CLASS_NAME = BaseCSTPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_CONSTRAINT = BaseCSTPackage.CLASS_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__QUALIFIER = BaseCSTPackage.CLASS_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_SUPER_TYPE = BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_OPERATION = BaseCSTPackage.CLASS_CS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_PROPERTY = BaseCSTPackage.CLASS_CS__OWNED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_META_TYPE = BaseCSTPackage.CLASS_CS__OWNED_META_TYPE;

	/**
	 * The feature id for the '<em><b>Meta Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__META_TYPE_NAME = BaseCSTPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS_FEATURE_COUNT = BaseCSTPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__PIVOT = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__MONIKER = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__NAME = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__STEREOTYPE = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__EXPR_STRING = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__EXPR_STRING;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__OWNED_EXPRESSION = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__OWNED_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Owned Reason</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__OWNED_REASON = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS__OWNED_REASON;

	/**
	 * The number of structural features of the '<em>Lib Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ANNOTATION = BaseCSTPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__PIVOT = BaseCSTPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__MONIKER = BaseCSTPackage.OPERATION_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__NAME = BaseCSTPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__LOWER = BaseCSTPackage.OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__MULTIPLICITY = BaseCSTPackage.OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_TYPE = BaseCSTPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__UPPER = BaseCSTPackage.OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_CONSTRAINT = BaseCSTPackage.OPERATION_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__QUALIFIER = BaseCSTPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSTPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNING_CLASS = BaseCSTPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_PARAMETER = BaseCSTPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_EXCEPTION = BaseCSTPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__IMPLEMENTATION = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ITERATOR = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ACCUMULATOR = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lib Iteration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS_FEATURE_COUNT = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__OWNED_ANNOTATION = BaseCSTPackage.PARAMETER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__PIVOT = BaseCSTPackage.PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__ORIGINAL_XMI_ID = BaseCSTPackage.PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__MONIKER = BaseCSTPackage.PARAMETER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__NAME = BaseCSTPackage.PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__LOWER = BaseCSTPackage.PARAMETER_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__MULTIPLICITY = BaseCSTPackage.PARAMETER_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__OWNED_TYPE = BaseCSTPackage.PARAMETER_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__UPPER = BaseCSTPackage.PARAMETER_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__OWNED_CONSTRAINT = BaseCSTPackage.PARAMETER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__QUALIFIER = BaseCSTPackage.PARAMETER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS__OWNER = BaseCSTPackage.PARAMETER_CS__OWNER;

	/**
	 * The number of structural features of the '<em>Lib Iterator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATOR_CS_FEATURE_COUNT = BaseCSTPackage.PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_ANNOTATION = BaseCSTPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__PIVOT = BaseCSTPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__MONIKER = BaseCSTPackage.OPERATION_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__NAME = BaseCSTPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__LOWER = BaseCSTPackage.OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__MULTIPLICITY = BaseCSTPackage.OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_TYPE = BaseCSTPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__UPPER = BaseCSTPackage.OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_CONSTRAINT = BaseCSTPackage.OPERATION_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__QUALIFIER = BaseCSTPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSTPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNING_CLASS = BaseCSTPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_PARAMETER = BaseCSTPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_EXCEPTION = BaseCSTPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__IMPLEMENTATION = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__PRECEDENCE = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__STATIC = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lib Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS_FEATURE_COUNT = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_ANNOTATION = BaseCSTPackage.ATTRIBUTE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__PIVOT = BaseCSTPackage.ATTRIBUTE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ATTRIBUTE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__MONIKER = BaseCSTPackage.ATTRIBUTE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__NAME = BaseCSTPackage.ATTRIBUTE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__LOWER = BaseCSTPackage.ATTRIBUTE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__MULTIPLICITY = BaseCSTPackage.ATTRIBUTE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_TYPE = BaseCSTPackage.ATTRIBUTE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__UPPER = BaseCSTPackage.ATTRIBUTE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_CONSTRAINT = BaseCSTPackage.ATTRIBUTE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__QUALIFIER = BaseCSTPackage.ATTRIBUTE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNER = BaseCSTPackage.ATTRIBUTE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__DEFAULT = BaseCSTPackage.ATTRIBUTE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__IMPLEMENTATION = BaseCSTPackage.ATTRIBUTE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__STATIC = BaseCSTPackage.ATTRIBUTE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lib Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS_FEATURE_COUNT = BaseCSTPackage.ATTRIBUTE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_ANNOTATION = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__PIVOT = BaseCSTPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__MONIKER = BaseCSTPackage.ROOT_PACKAGE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__NAME = BaseCSTPackage.ROOT_PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_TYPE = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__NS_PREFIX = BaseCSTPackage.ROOT_PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__NS_URI = BaseCSTPackage.ROOT_PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_IMPORT = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_LIBRARY = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_PRECEDENCE = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Root Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS_FEATURE_COUNT = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.PrecedenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getPrecedenceCS()
	 * @generated
	 */
	int PRECEDENCE_CS = 9;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__MONIKER = BaseCSTPackage.NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Right Associative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__RIGHT_ASSOCIATIVE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Precedence CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibAccumulatorCS <em>Lib Accumulator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Accumulator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibAccumulatorCS
	 * @generated
	 */
	EClass getLibAccumulatorCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS <em>Lib Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS
	 * @generated
	 */
	EClass getLibClassCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getMetaTypeName <em>Meta Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Type Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getMetaTypeName()
	 * @see #getLibClassCS()
	 * @generated
	 */
	EAttribute getLibClassCS_MetaTypeName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS <em>Lib Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS
	 * @generated
	 */
	EClass getLibConstraintCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS <em>Lib Iteration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Iteration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS
	 * @generated
	 */
	EClass getLibIterationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedIterator <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedIterator()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedIterator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedAccumulator <em>Owned Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedAccumulator()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedAccumulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIteratorCS <em>Lib Iterator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Iterator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIteratorCS
	 * @generated
	 */
	EClass getLibIteratorCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS <em>Lib Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS
	 * @generated
	 */
	EClass getLibOperationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#getPrecedence()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EReference getLibOperationCS_Precedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#isStatic()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_Static();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS <em>Lib Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Property CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS
	 * @generated
	 */
	EClass getLibPropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS#isStatic()
	 * @see #getLibPropertyCS()
	 * @generated
	 */
	EAttribute getLibPropertyCS_Static();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS <em>Lib Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Root Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS
	 * @generated
	 */
	EClass getLibRootPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS#getOwnedPrecedence <em>Owned Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedence</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS#getOwnedPrecedence()
	 * @see #getLibRootPackageCS()
	 * @generated
	 */
	EReference getLibRootPackageCS_OwnedPrecedence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS <em>Java Implementation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Implementation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS
	 * @generated
	 */
	EClass getJavaImplementationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS#getImplementation()
	 * @see #getJavaImplementationCS()
	 * @generated
	 */
	EReference getJavaImplementationCS_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS <em>Precedence CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS
	 * @generated
	 */
	EClass getPrecedenceCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS#isRightAssociative <em>Right Associative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Associative</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS#isRightAssociative()
	 * @see #getPrecedenceCS()
	 * @generated
	 */
	EAttribute getPrecedenceCS_RightAssociative();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLstdlibCSTFactory getOCLstdlibCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibAccumulatorCSImpl <em>Lib Accumulator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibAccumulatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibAccumulatorCS()
		 * @generated
		 */
		EClass LIB_ACCUMULATOR_CS = eINSTANCE.getLibAccumulatorCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassCS()
		 * @generated
		 */
		EClass LIB_CLASS_CS = eINSTANCE.getLibClassCS();

		/**
		 * The meta object literal for the '<em><b>Meta Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_CLASS_CS__META_TYPE_NAME = eINSTANCE.getLibClassCS_MetaTypeName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibConstraintCS()
		 * @generated
		 */
		EClass LIB_CONSTRAINT_CS = eINSTANCE.getLibConstraintCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIterationCS()
		 * @generated
		 */
		EClass LIB_ITERATION_CS = eINSTANCE.getLibIterationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ITERATOR = eINSTANCE.getLibIterationCS_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ACCUMULATOR = eINSTANCE.getLibIterationCS_OwnedAccumulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIteratorCSImpl <em>Lib Iterator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIteratorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIteratorCS()
		 * @generated
		 */
		EClass LIB_ITERATOR_CS = eINSTANCE.getLibIteratorCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibOperationCS()
		 * @generated
		 */
		EClass LIB_OPERATION_CS = eINSTANCE.getLibOperationCS();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_OPERATION_CS__PRECEDENCE = eINSTANCE.getLibOperationCS_Precedence();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__STATIC = eINSTANCE.getLibOperationCS_Static();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPropertyCS()
		 * @generated
		 */
		EClass LIB_PROPERTY_CS = eINSTANCE.getLibPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_PROPERTY_CS__STATIC = eINSTANCE.getLibPropertyCS_Static();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibRootPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibRootPackageCS()
		 * @generated
		 */
		EClass LIB_ROOT_PACKAGE_CS = eINSTANCE.getLibRootPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Precedence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ROOT_PACKAGE_CS__OWNED_PRECEDENCE = eINSTANCE.getLibRootPackageCS_OwnedPrecedence();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS <em>Java Implementation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getJavaImplementationCS()
		 * @generated
		 */
		EClass JAVA_IMPLEMENTATION_CS = eINSTANCE.getJavaImplementationCS();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = eINSTANCE.getJavaImplementationCS_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.PrecedenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getPrecedenceCS()
		 * @generated
		 */
		EClass PRECEDENCE_CS = eINSTANCE.getPrecedenceCS();

		/**
		 * The meta object literal for the '<em><b>Right Associative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE_CS__RIGHT_ASSOCIATIVE = eINSTANCE.getPrecedenceCS_RightAssociative();

	}

} //OCLstdlibCSTPackage
