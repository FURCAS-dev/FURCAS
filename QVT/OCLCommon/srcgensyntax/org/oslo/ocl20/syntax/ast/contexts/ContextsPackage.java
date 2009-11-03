/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.syntax.ast.AstPackage;

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
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsFactory
 * @model kind="package"
 * @generated
 */
public interface ContextsPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "contexts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:ast.contexts.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ast.contexts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContextsPackage eINSTANCE = org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ContextDeclarationASImpl <em>Context Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getContextDeclarationAS()
	 * @generated
	 */
	int CONTEXT_DECLARATION_AS = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECLARATION_AS__CONSTRAINTS = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl <em>Classifier Context Decl AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getClassifierContextDeclAS()
	 * @generated
	 */
	int CLASSIFIER_CONTEXT_DECL_AS = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_AS__CONSTRAINTS = CONTEXT_DECLARATION_AS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_AS__TYPE = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier Context Decl AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_AS_FEATURE_COUNT = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl <em>Constraint AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getConstraintAS()
	 * @generated
	 */
	int CONSTRAINT_AS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS__KIND = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Def Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS__DEF_OPERATION = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS__BODY_EXPRESSION = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Def Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS__DEF_VARIABLE = AstPackage.VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Constraint AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.OperationASImpl <em>Operation AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.OperationASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getOperationAS()
	 * @generated
	 */
	int OPERATION_AS = 3;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_AS__PATH_NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_AS__PARAMETERS = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.OperationContextDeclASImpl <em>Operation Context Decl AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.OperationContextDeclASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getOperationContextDeclAS()
	 * @generated
	 */
	int OPERATION_CONTEXT_DECL_AS = 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_AS__CONSTRAINTS = CONTEXT_DECLARATION_AS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_AS__OPERATION = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Context Decl AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_AS_FEATURE_COUNT = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl <em>Package Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getPackageDeclarationAS()
	 * @generated
	 */
	int PACKAGE_DECLARATION_AS = 5;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_AS__PATH_NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Decls</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_AS__CONTEXT_DECLS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.PropertyContextDeclASImpl <em>Property Context Decl AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.PropertyContextDeclASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getPropertyContextDeclAS()
	 * @generated
	 */
	int PROPERTY_CONTEXT_DECL_AS = 6;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_AS__CONSTRAINTS = CONTEXT_DECLARATION_AS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_AS__PATH_NAME = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_AS__NAME = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_AS__TYPE = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Context Decl AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_AS_FEATURE_COUNT = CONTEXT_DECLARATION_AS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.VariableDeclarationASImpl <em>Variable Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.VariableDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getVariableDeclarationAS()
	 * @generated
	 */
	int VARIABLE_DECLARATION_AS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS__INIT_EXP = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS <em>Constraint Kind AS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS
	 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getConstraintKindAS()
	 * @generated
	 */
	int CONSTRAINT_KIND_AS = 8;


	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS <em>Classifier Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Context Decl AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS
	 * @generated
	 */
	EClass getClassifierContextDeclAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS#getPathName()
	 * @see #getClassifierContextDeclAS()
	 * @generated
	 */
	EAttribute getClassifierContextDeclAS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS#getType()
	 * @see #getClassifierContextDeclAS()
	 * @generated
	 */
	EReference getClassifierContextDeclAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS <em>Constraint AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS
	 * @generated
	 */
	EClass getConstraintAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getName()
	 * @see #getConstraintAS()
	 * @generated
	 */
	EAttribute getConstraintAS_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getKind()
	 * @see #getConstraintAS()
	 * @generated
	 */
	EAttribute getConstraintAS_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getBodyExpression()
	 * @see #getConstraintAS()
	 * @generated
	 */
	EReference getConstraintAS_BodyExpression();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefOperation <em>Def Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Def Operation</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefOperation()
	 * @see #getConstraintAS()
	 * @generated
	 */
	EReference getConstraintAS_DefOperation();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefVariable <em>Def Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Def Variable</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefVariable()
	 * @see #getConstraintAS()
	 * @generated
	 */
	EReference getConstraintAS_DefVariable();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS <em>Context Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS
	 * @generated
	 */
	EClass getContextDeclarationAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS#getConstraints()
	 * @see #getContextDeclarationAS()
	 * @generated
	 */
	EReference getContextDeclarationAS_Constraints();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS <em>Operation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS
	 * @generated
	 */
	EClass getOperationAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS#getPathName()
	 * @see #getOperationAS()
	 * @generated
	 */
	EAttribute getOperationAS_PathName();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS#getName()
	 * @see #getOperationAS()
	 * @generated
	 */
	EAttribute getOperationAS_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS#getParameters()
	 * @see #getOperationAS()
	 * @generated
	 */
	EReference getOperationAS_Parameters();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS#getType()
	 * @see #getOperationAS()
	 * @generated
	 */
	EReference getOperationAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS <em>Operation Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Context Decl AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS
	 * @generated
	 */
	EClass getOperationContextDeclAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS#getOperation()
	 * @see #getOperationContextDeclAS()
	 * @generated
	 */
	EReference getOperationContextDeclAS_Operation();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS <em>Package Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS
	 * @generated
	 */
	EClass getPackageDeclarationAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS#getPathName()
	 * @see #getPackageDeclarationAS()
	 * @generated
	 */
	EAttribute getPackageDeclarationAS_PathName();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS#getContextDecls <em>Context Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Context Decls</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS#getContextDecls()
	 * @see #getPackageDeclarationAS()
	 * @generated
	 */
	EReference getPackageDeclarationAS_ContextDecls();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS <em>Property Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Context Decl AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS
	 * @generated
	 */
	EClass getPropertyContextDeclAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getPathName()
	 * @see #getPropertyContextDeclAS()
	 * @generated
	 */
	EAttribute getPropertyContextDeclAS_PathName();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getName()
	 * @see #getPropertyContextDeclAS()
	 * @generated
	 */
	EAttribute getPropertyContextDeclAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS#getType()
	 * @see #getPropertyContextDeclAS()
	 * @generated
	 */
	EReference getPropertyContextDeclAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS <em>Variable Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS
	 * @generated
	 */
	EClass getVariableDeclarationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getName()
	 * @see #getVariableDeclarationAS()
	 * @generated
	 */
	EAttribute getVariableDeclarationAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getInitExp <em>Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Init Exp</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getInitExp()
	 * @see #getVariableDeclarationAS()
	 * @generated
	 */
	EReference getVariableDeclarationAS_InitExp();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS#getType()
	 * @see #getVariableDeclarationAS()
	 * @generated
	 */
	EReference getVariableDeclarationAS_Type();

	/**
	 * Returns the meta object for enum '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS <em>Constraint Kind AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Constraint Kind AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS
	 * @generated
	 */
	EEnum getConstraintKindAS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContextsFactory getContextsFactory();

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
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl <em>Classifier Context Decl AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getClassifierContextDeclAS()
		 * @generated
		 */
		EClass CLASSIFIER_CONTEXT_DECL_AS = eINSTANCE.getClassifierContextDeclAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME = eINSTANCE.getClassifierContextDeclAS_PathName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_AS__TYPE = eINSTANCE.getClassifierContextDeclAS_Type();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl <em>Constraint AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getConstraintAS()
		 * @generated
		 */
		EClass CONSTRAINT_AS = eINSTANCE.getConstraintAS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_AS__NAME = eINSTANCE.getConstraintAS_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_AS__KIND = eINSTANCE.getConstraintAS_Kind();

		/**
		 * The meta object literal for the '<em><b>Def Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_AS__DEF_OPERATION = eINSTANCE.getConstraintAS_DefOperation();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_AS__BODY_EXPRESSION = eINSTANCE.getConstraintAS_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Def Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_AS__DEF_VARIABLE = eINSTANCE.getConstraintAS_DefVariable();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.ContextDeclarationASImpl <em>Context Declaration AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextDeclarationASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getContextDeclarationAS()
		 * @generated
		 */
		EClass CONTEXT_DECLARATION_AS = eINSTANCE.getContextDeclarationAS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_DECLARATION_AS__CONSTRAINTS = eINSTANCE.getContextDeclarationAS_Constraints();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.OperationASImpl <em>Operation AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.OperationASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getOperationAS()
		 * @generated
		 */
		EClass OPERATION_AS = eINSTANCE.getOperationAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_AS__PATH_NAME = eINSTANCE.getOperationAS_PathName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_AS__NAME = eINSTANCE.getOperationAS_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_AS__PARAMETERS = eINSTANCE.getOperationAS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_AS__TYPE = eINSTANCE.getOperationAS_Type();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.OperationContextDeclASImpl <em>Operation Context Decl AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.OperationContextDeclASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getOperationContextDeclAS()
		 * @generated
		 */
		EClass OPERATION_CONTEXT_DECL_AS = eINSTANCE.getOperationContextDeclAS();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_AS__OPERATION = eINSTANCE.getOperationContextDeclAS_Operation();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl <em>Package Declaration AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getPackageDeclarationAS()
		 * @generated
		 */
		EClass PACKAGE_DECLARATION_AS = eINSTANCE.getPackageDeclarationAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_DECLARATION_AS__PATH_NAME = eINSTANCE.getPackageDeclarationAS_PathName();

		/**
		 * The meta object literal for the '<em><b>Context Decls</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_AS__CONTEXT_DECLS = eINSTANCE.getPackageDeclarationAS_ContextDecls();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.PropertyContextDeclASImpl <em>Property Context Decl AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.PropertyContextDeclASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getPropertyContextDeclAS()
		 * @generated
		 */
		EClass PROPERTY_CONTEXT_DECL_AS = eINSTANCE.getPropertyContextDeclAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_CONTEXT_DECL_AS__PATH_NAME = eINSTANCE.getPropertyContextDeclAS_PathName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_CONTEXT_DECL_AS__NAME = eINSTANCE.getPropertyContextDeclAS_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_AS__TYPE = eINSTANCE.getPropertyContextDeclAS_Type();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.impl.VariableDeclarationASImpl <em>Variable Declaration AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.VariableDeclarationASImpl
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getVariableDeclarationAS()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION_AS = eINSTANCE.getVariableDeclarationAS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION_AS__NAME = eINSTANCE.getVariableDeclarationAS_Name();

		/**
		 * The meta object literal for the '<em><b>Init Exp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_AS__INIT_EXP = eINSTANCE.getVariableDeclarationAS_InitExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_AS__TYPE = eINSTANCE.getVariableDeclarationAS_Type();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS <em>Constraint Kind AS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS
		 * @see org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl#getConstraintKindAS()
		 * @generated
		 */
		EEnum CONSTRAINT_KIND_AS = eINSTANCE.getConstraintKindAS();

	}

} //ContextsPackage
