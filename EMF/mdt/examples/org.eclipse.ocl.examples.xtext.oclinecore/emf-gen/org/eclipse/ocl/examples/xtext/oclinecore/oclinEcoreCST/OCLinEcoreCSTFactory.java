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
 * $Id: OCLinEcoreCSTFactory.java,v 1.4 2010/05/09 09:48:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage
 * @generated
 */
public interface OCLinEcoreCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation CS</em>'.
	 * @generated
	 */
	AnnotationCS createAnnotationCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Attribute CS</em>'.
	 * @generated
	 */
	OCLinEcoreAttributeCS createOCLinEcoreAttributeCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Class CS</em>'.
	 * @generated
	 */
	OCLinEcoreClassCS createOCLinEcoreClassCS();

	/**
	 * Returns a new object of class '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation CS</em>'.
	 * @generated
	 */
	DocumentationCS createDocumentationCS();

	/**
	 * Returns a new object of class '<em>Enum CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum CS</em>'.
	 * @generated
	 */
	EnumCS createEnumCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Document CS</em>'.
	 * @generated
	 */
	OCLinEcoreDocumentCS createOCLinEcoreDocumentCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Operation CS</em>'.
	 * @generated
	 */
	OCLinEcoreOperationCS createOCLinEcoreOperationCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Package CS</em>'.
	 * @generated
	 */
	OCLinEcorePackageCS createOCLinEcorePackageCS();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Reference CS</em>'.
	 * @generated
	 */
	OCLinEcoreReferenceCS createOCLinEcoreReferenceCS();

	/**
	 * Returns a new object of class '<em>Postcondition CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postcondition CS</em>'.
	 * @generated
	 */
	PostconditionCS createPostconditionCS();

	/**
	 * Returns a new object of class '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint CS</em>'.
	 * @generated
	 */
	ConstraintCS createConstraintCS();

	/**
	 * Returns a new object of class '<em>Data Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type CS</em>'.
	 * @generated
	 */
	DataTypeCS createDataTypeCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLinEcoreCSTPackage getOCLinEcoreCSTPackage();

} //OCLinEcoreCSTFactory
