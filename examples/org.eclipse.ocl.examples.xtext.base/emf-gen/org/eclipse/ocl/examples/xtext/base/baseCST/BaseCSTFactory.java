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
 * $Id: BaseCSTFactory.java,v 1.4 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage
 * @generated
 */
public interface BaseCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTFactoryImpl.init();

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
	 * Returns a new object of class '<em>Bound Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Document CS</em>'.
	 * @generated
	 */
	BoundDocumentCS createBoundDocumentCS();

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
	 * Returns a new object of class '<em>Collection Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type Ref CS</em>'.
	 * @generated
	 */
	CollectionTypeRefCS createCollectionTypeRefCS();

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
	 * Returns a new object of class '<em>Detail CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detail CS</em>'.
	 * @generated
	 */
	DetailCS createDetailCS();

	/**
	 * Returns a new object of class '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation CS</em>'.
	 * @generated
	 */
	DocumentationCS createDocumentationCS();

	/**
	 * Returns a new object of class '<em>Enumeration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration CS</em>'.
	 * @generated
	 */
	EnumerationCS createEnumerationCS();

	/**
	 * Returns a new object of class '<em>Enumeration Literal CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal CS</em>'.
	 * @generated
	 */
	EnumerationLiteralCS createEnumerationLiteralCS();

	/**
	 * Returns a new object of class '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import CS</em>'.
	 * @generated
	 */
	ImportCS createImportCS();

	/**
	 * Returns a new object of class '<em>Library CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library CS</em>'.
	 * @generated
	 */
	LibraryCS createLibraryCS();

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
	 * Returns a new object of class '<em>Primitive Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Ref CS</em>'.
	 * @generated
	 */
	PrimitiveTypeRefCS createPrimitiveTypeRefCS();

	/**
	 * Returns a new object of class '<em>Qualified Classifier Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Classifier Ref CS</em>'.
	 * @generated
	 */
	QualifiedClassifierRefCS createQualifiedClassifierRefCS();

	/**
	 * Returns a new object of class '<em>Qualified Operation Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Operation Ref CS</em>'.
	 * @generated
	 */
	QualifiedOperationRefCS createQualifiedOperationRefCS();

	/**
	 * Returns a new object of class '<em>Qualified Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Package Ref CS</em>'.
	 * @generated
	 */
	QualifiedPackageRefCS createQualifiedPackageRefCS();

	/**
	 * Returns a new object of class '<em>Qualified Structural Feature Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Structural Feature Ref CS</em>'.
	 * @generated
	 */
	QualifiedStructuralFeatureRefCS createQualifiedStructuralFeatureRefCS();

	/**
	 * Returns a new object of class '<em>Qualified Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Type Ref CS</em>'.
	 * @generated
	 */
	QualifiedTypeRefCS createQualifiedTypeRefCS();

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
	 * Returns a new object of class '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Package CS</em>'.
	 * @generated
	 */
	RootPackageCS createRootPackageCS();

	/**
	 * Returns a new object of class '<em>Simple Classifier Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Classifier Ref CS</em>'.
	 * @generated
	 */
	SimpleClassifierRefCS createSimpleClassifierRefCS();

	/**
	 * Returns a new object of class '<em>Simple Operation Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Operation Ref CS</em>'.
	 * @generated
	 */
	SimpleOperationRefCS createSimpleOperationRefCS();

	/**
	 * Returns a new object of class '<em>Simple Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Package Ref CS</em>'.
	 * @generated
	 */
	SimplePackageRefCS createSimplePackageRefCS();

	/**
	 * Returns a new object of class '<em>Simple Structural Feature Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Structural Feature Ref CS</em>'.
	 * @generated
	 */
	SimpleStructuralFeatureRefCS createSimpleStructuralFeatureRefCS();

	/**
	 * Returns a new object of class '<em>Template Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Binding CS</em>'.
	 * @generated
	 */
	TemplateBindingCS createTemplateBindingCS();

	/**
	 * Returns a new object of class '<em>Template Parameter Substitution CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Substitution CS</em>'.
	 * @generated
	 */
	TemplateParameterSubstitutionCS createTemplateParameterSubstitutionCS();

	/**
	 * Returns a new object of class '<em>Template Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Signature CS</em>'.
	 * @generated
	 */
	TemplateSignatureCS createTemplateSignatureCS();

	/**
	 * Returns a new object of class '<em>Tuple Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Part CS</em>'.
	 * @generated
	 */
	TuplePartCS createTuplePartCS();

	/**
	 * Returns a new object of class '<em>Tuple Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type CS</em>'.
	 * @generated
	 */
	TupleTypeCS createTupleTypeCS();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BaseCSTPackage getBaseCSTPackage();

} //BaseCSTFactory
