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
 * $Id: OCLinEcoreCSTPackage.java,v 1.10 2011/03/01 08:46:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
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
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory
 * @model kind="package"
 * @generated
 */
public interface OCLinEcoreCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclinEcoreCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/OCLinEcoreCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclinEcoreCST";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.xtext.oclinecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreConstraintCS()
	 * @generated
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS = 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__OWNED_ANNOTATION = BaseCSTPackage.CONSTRAINT_CS__OWNED_ANNOTATION;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS <em>OC Lin Ecore Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS
	 * @generated
	 */
	EClass getOCLinEcoreConstraintCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreSpecificationCS <em>OC Lin Ecore Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Specification CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreSpecificationCS
	 * @generated
	 */
	EClass getOCLinEcoreSpecificationCS();

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__PIVOT = BaseCSTPackage.CONSTRAINT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__MONIKER = BaseCSTPackage.CONSTRAINT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__NAME = BaseCSTPackage.CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__STEREOTYPE = BaseCSTPackage.CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__SPECIFICATION = BaseCSTPackage.CONSTRAINT_CS__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Message Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__MESSAGE_SPECIFICATION = BaseCSTPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS_FEATURE_COUNT = BaseCSTPackage.CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreSpecificationCSImpl <em>OC Lin Ecore Specification CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreSpecificationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreSpecificationCS()
	 * @generated
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS = 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__PIVOT = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__MONIKER = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__EXPR_STRING = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__EXPR_STRING;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS__OWNED_EXPRESSION = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS__OWNED_EXPRESSION;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Specification CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_SPECIFICATION_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_SPECIFICATION_CS_FEATURE_COUNT + 0;

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLinEcoreCSTFactory getOCLinEcoreCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreConstraintCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_CONSTRAINT_CS = eINSTANCE.getOCLinEcoreConstraintCS();
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreSpecificationCSImpl <em>OC Lin Ecore Specification CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreSpecificationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreSpecificationCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_SPECIFICATION_CS = eINSTANCE.getOCLinEcoreSpecificationCS();

	}

} //OCLinEcoreCSTPackage
