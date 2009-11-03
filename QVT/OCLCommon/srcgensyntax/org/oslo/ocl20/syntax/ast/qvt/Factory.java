/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.qvt.Package
 * @generated
 */
public interface Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Factory eINSTANCE = org.oslo.ocl20.syntax.ast.qvt.impl.FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Collection Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Template AS</em>'.
	 * @generated
	 */
	CollectionTemplateAS createCollectionTemplateAS();

	/**
	 * Returns a new object of class '<em>Domain AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain AS</em>'.
	 * @generated
	 */
	DomainAS createDomainAS();

	/**
	 * Returns a new object of class '<em>Key Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Declaration AS</em>'.
	 * @generated
	 */
	KeyDeclarationAS createKeyDeclarationAS();

	/**
	 * Returns a new object of class '<em>Member Selection Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member Selection Expression AS</em>'.
	 * @generated
	 */
	MemberSelectionExpressionAS createMemberSelectionExpressionAS();

	/**
	 * Returns a new object of class '<em>Model Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Declaration AS</em>'.
	 * @generated
	 */
	ModelDeclarationAS createModelDeclarationAS();

	/**
	 * Returns a new object of class '<em>Object Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Template AS</em>'.
	 * @generated
	 */
	ObjectTemplateAS createObjectTemplateAS();

	/**
	 * Returns a new object of class '<em>Parameter Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Declaration AS</em>'.
	 * @generated
	 */
	ParameterDeclarationAS createParameterDeclarationAS();

	/**
	 * Returns a new object of class '<em>Primitive Domain AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Domain AS</em>'.
	 * @generated
	 */
	PrimitiveDomainAS createPrimitiveDomainAS();

	/**
	 * Returns a new object of class '<em>Property Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Template AS</em>'.
	 * @generated
	 */
	PropertyTemplateAS createPropertyTemplateAS();

	/**
	 * Returns a new object of class '<em>Query AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query AS</em>'.
	 * @generated
	 */
	QueryAS createQueryAS();

	/**
	 * Returns a new object of class '<em>Relation AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation AS</em>'.
	 * @generated
	 */
	RelationAS createRelationAS();

	/**
	 * Returns a new object of class '<em>Set Comprehension Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Comprehension Expression AS</em>'.
	 * @generated
	 */
	SetComprehensionExpressionAS createSetComprehensionExpressionAS();

	/**
	 * Returns a new object of class '<em>Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template AS</em>'.
	 * @generated
	 */
	TemplateAS createTemplateAS();

	/**
	 * Returns a new object of class '<em>Top Level AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level AS</em>'.
	 * @generated
	 */
	TopLevelAS createTopLevelAS();

	/**
	 * Returns a new object of class '<em>Transformation AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation AS</em>'.
	 * @generated
	 */
	TransformationAS createTransformationAS();

	/**
	 * Returns a new object of class '<em>Variable Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration AS</em>'.
	 * @generated
	 */
	VariableDeclarationAS createVariableDeclarationAS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Package getPackage();

} //Factory
