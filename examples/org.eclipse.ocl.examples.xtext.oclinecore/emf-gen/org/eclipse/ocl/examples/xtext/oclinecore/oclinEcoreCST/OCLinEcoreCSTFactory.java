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
 * $Id: OCLinEcoreCSTFactory.java,v 1.2 2010/04/16 18:05:31 ewillink Exp $
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
	 * Returns a new object of class '<em>Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute CS</em>'.
	 * @generated
	 */
	AttributeCS createAttributeCS();

	/**
	 * Returns a new object of class '<em>Attribute CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute CS Ref</em>'.
	 * @generated
	 */
	AttributeCSRef createAttributeCSRef();

	/**
	 * Returns a new object of class '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS</em>'.
	 * @generated
	 */
	ClassCS createClassCS();

	/**
	 * Returns a new object of class '<em>Class CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS Ref</em>'.
	 * @generated
	 */
	ClassCSRef createClassCSRef();

	/**
	 * Returns a new object of class '<em>Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document CS</em>'.
	 * @generated
	 */
	DocumentCS createDocumentCS();

	/**
	 * Returns a new object of class '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation CS</em>'.
	 * @generated
	 */
	DocumentationCS createDocumentationCS();

	/**
	 * Returns a new object of class '<em>EAttribute Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAttribute Ref</em>'.
	 * @generated
	 */
	EAttributeRef createEAttributeRef();

	/**
	 * Returns a new object of class '<em>EClass Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Ref</em>'.
	 * @generated
	 */
	EClassRef createEClassRef();

	/**
	 * Returns a new object of class '<em>EClassifier CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClassifier CS Ref</em>'.
	 * @generated
	 */
	EClassifierCSRef createEClassifierCSRef();

	/**
	 * Returns a new object of class '<em>EClassifier Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClassifier Ref</em>'.
	 * @generated
	 */
	EClassifierRef createEClassifierRef();

	/**
	 * Returns a new object of class '<em>EData Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EData Type Ref</em>'.
	 * @generated
	 */
	EDataTypeRef createEDataTypeRef();

	/**
	 * Returns a new object of class '<em>EObject Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Ref</em>'.
	 * @generated
	 */
	EObjectRef createEObjectRef();

	/**
	 * Returns a new object of class '<em>EReference Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Ref</em>'.
	 * @generated
	 */
	EReferenceRef createEReferenceRef();

	/**
	 * Returns a new object of class '<em>Enum CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum CS</em>'.
	 * @generated
	 */
	EnumCS createEnumCS();

	/**
	 * Returns a new object of class '<em>Enum Literal CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal CS</em>'.
	 * @generated
	 */
	EnumLiteralCS createEnumLiteralCS();

	/**
	 * Returns a new object of class '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import CS</em>'.
	 * @generated
	 */
	ImportCS createImportCS();

	/**
	 * Returns a new object of class '<em>Model Element CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element CS Ref</em>'.
	 * @generated
	 */
	ModelElementCSRef createModelElementCSRef();

	/**
	 * Returns a new object of class '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation CS</em>'.
	 * @generated
	 */
	OperationCS createOperationCS();

	/**
	 * Returns a new object of class '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS</em>'.
	 * @generated
	 */
	PackageCS createPackageCS();

	/**
	 * Returns a new object of class '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter CS</em>'.
	 * @generated
	 */
	ParameterCS createParameterCS();

	/**
	 * Returns a new object of class '<em>Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference CS</em>'.
	 * @generated
	 */
	ReferenceCS createReferenceCS();

	/**
	 * Returns a new object of class '<em>Reference CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference CS Ref</em>'.
	 * @generated
	 */
	ReferenceCSRef createReferenceCSRef();

	/**
	 * Returns a new object of class '<em>Type CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type CS Ref</em>'.
	 * @generated
	 */
	TypeCSRef createTypeCSRef();

	/**
	 * Returns a new object of class '<em>Type Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Parameter CS</em>'.
	 * @generated
	 */
	TypeParameterCS createTypeParameterCS();

	/**
	 * Returns a new object of class '<em>Typed Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Type Ref CS</em>'.
	 * @generated
	 */
	TypedTypeRefCS createTypedTypeRefCS();

	/**
	 * Returns a new object of class '<em>Wildcard Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Type Ref CS</em>'.
	 * @generated
	 */
	WildcardTypeRefCS createWildcardTypeRefCS();

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
	 * Returns a new object of class '<em>Data Type CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type CS Ref</em>'.
	 * @generated
	 */
	DataTypeCSRef createDataTypeCSRef();

	/**
	 * Returns a new object of class '<em>Detail CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detail CS</em>'.
	 * @generated
	 */
	DetailCS createDetailCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLinEcoreCSTPackage getOCLinEcoreCSTPackage();

} //OCLinEcoreCSTFactory
