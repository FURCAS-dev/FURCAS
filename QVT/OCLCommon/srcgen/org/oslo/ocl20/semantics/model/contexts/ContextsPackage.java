/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsFactory
 * @model kind="package"
 * @generated
 */
public interface ContextsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "contexts";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semantics.model.contexts.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semantics.model.contexts";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ContextsPackage eINSTANCE = org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl
	 * <em>Context Declaration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getContextDeclaration()
	 * @generated
	 */
	int CONTEXT_DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECLARATION__REFERRED_NAMESPACE = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECLARATION__CONSTRAINT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Context Declaration</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECLARATION_FEATURE_COUNT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ClassifierContextDeclImpl
	 * <em>Classifier Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ClassifierContextDeclImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getClassifierContextDecl()
	 * @generated
	 */
	int CLASSIFIER_CONTEXT_DECL = 0;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL__REFERRED_NAMESPACE = CONTEXT_DECLARATION__REFERRED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL__CONSTRAINT = CONTEXT_DECLARATION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Referred Classifier</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER = CONTEXT_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Classifier Context Decl</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl <em>Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__KIND = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Def Property</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DEF_PROPERTY = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Def Operation</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DEF_OPERATION = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONTEXT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__BODY_EXPRESSION = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.DefinedOperationImpl
	 * <em>Defined Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.DefinedOperationImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getDefinedOperation()
	 * @generated
	 */
	int DEFINED_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__TAG = BridgePackage.OPERATION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__NAME = BridgePackage.OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__OWNED_PARAMETER = BridgePackage.OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__RETURN_TYPE = BridgePackage.OPERATION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__DEFINITION = BridgePackage.OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Operation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION_FEATURE_COUNT = BridgePackage.OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.DefinedPropertyImpl
	 * <em>Defined Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.DefinedPropertyImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getDefinedProperty()
	 * @generated
	 */
	int DEFINED_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PROPERTY__TAG = BridgePackage.PROPERTY__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PROPERTY__NAME = BridgePackage.PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PROPERTY__TYPE = BridgePackage.PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PROPERTY__DEFINITION = BridgePackage.PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Property</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PROPERTY_FEATURE_COUNT = BridgePackage.PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.OperationContextDeclImpl
	 * <em>Operation Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.OperationContextDeclImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getOperationContextDecl()
	 * @generated
	 */
	int OPERATION_CONTEXT_DECL = 5;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL__REFERRED_NAMESPACE = CONTEXT_DECLARATION__REFERRED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL__CONSTRAINT = CONTEXT_DECLARATION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL__REFERRED_OPERATION = CONTEXT_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Context Decl</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.impl.PropertyContextDeclImpl
	 * <em>Property Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.PropertyContextDeclImpl
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getPropertyContextDecl()
	 * @generated
	 */
	int PROPERTY_CONTEXT_DECL = 6;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL__REFERRED_NAMESPACE = CONTEXT_DECLARATION__REFERRED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL__CONSTRAINT = CONTEXT_DECLARATION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL__REFERRED_PROPERTY = CONTEXT_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Context Decl</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_FEATURE_COUNT = CONTEXT_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.contexts.ConstraintKind
	 * <em>Constraint Kind</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.contexts.ConstraintKind
	 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getConstraintKind()
	 * @generated
	 */
	int CONSTRAINT_KIND = 7;

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl
	 * <em>Classifier Context Decl</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Classifier Context Decl</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl
	 * @generated
	 */
	EClass getClassifierContextDecl();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl#getReferredClassifier
	 * <em>Referred Classifier</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Classifier</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl#getReferredClassifier()
	 * @see #getClassifierContextDecl()
	 * @generated
	 */
	EReference getClassifierContextDecl_ReferredClassifier();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.contexts.Constraint
	 * <em>Constraint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getKind <em>Kind</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getKind()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Kind();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefProperty
	 * <em>Def Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Def Property</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getDefProperty()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_DefProperty();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefOperation
	 * <em>Def Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Def Operation</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getDefOperation()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_DefOperation();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getContext <em>Context</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Context();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getBodyExpression
	 * <em>Body Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getBodyExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_BodyExpression();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration
	 * <em>Context Declaration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Context Declaration</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextDeclaration
	 * @generated
	 */
	EClass getContextDeclaration();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getReferredNamespace
	 * <em>Referred Namespace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Namespace</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getReferredNamespace()
	 * @see #getContextDeclaration()
	 * @generated
	 */
	EReference getContextDeclaration_ReferredNamespace();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getConstraint
	 * <em>Constraint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getConstraint()
	 * @see #getContextDeclaration()
	 * @generated
	 */
	EReference getContextDeclaration_Constraint();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedOperation <em>Defined Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Defined Operation</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedOperation
	 * @generated
	 */
	EClass getDefinedOperation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedOperation#getDefinition
	 * <em>Definition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedOperation#getDefinition()
	 * @see #getDefinedOperation()
	 * @generated
	 */
	EReference getDefinedOperation_Definition();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedProperty <em>Defined Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Defined Property</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedProperty
	 * @generated
	 */
	EClass getDefinedProperty();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedProperty#getDefinition
	 * <em>Definition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedProperty#getDefinition()
	 * @see #getDefinedProperty()
	 * @generated
	 */
	EReference getDefinedProperty_Definition();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.OperationContextDecl
	 * <em>Operation Context Decl</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation Context Decl</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.OperationContextDecl
	 * @generated
	 */
	EClass getOperationContextDecl();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.OperationContextDecl#getReferredOperation
	 * <em>Referred Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.OperationContextDecl#getReferredOperation()
	 * @see #getOperationContextDecl()
	 * @generated
	 */
	EReference getOperationContextDecl_ReferredOperation();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl
	 * <em>Property Context Decl</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property Context Decl</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl
	 * @generated
	 */
	EClass getPropertyContextDecl();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl#getReferredProperty
	 * <em>Referred Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl#getReferredProperty()
	 * @see #getPropertyContextDecl()
	 * @generated
	 */
	EReference getPropertyContextDecl_ReferredProperty();

	/**
	 * Returns the meta object for enum '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ConstraintKind <em>Constraint Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Constraint Kind</em>'.
	 * @see org.oslo.ocl20.semantics.model.contexts.ConstraintKind
	 * @generated
	 */
	EEnum getConstraintKind();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContextsFactory getContextsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ClassifierContextDeclImpl
		 * <em>Classifier Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ClassifierContextDeclImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getClassifierContextDecl()
		 * @generated
		 */
		EClass CLASSIFIER_CONTEXT_DECL = eINSTANCE.getClassifierContextDecl();

		/**
		 * The meta object literal for the '<em><b>Referred Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER = eINSTANCE
		        .getClassifierContextDecl_ReferredClassifier();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl <em>Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONSTRAINT__KIND = eINSTANCE.getConstraint_Kind();

		/**
		 * The meta object literal for the '<em><b>Def Property</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__DEF_PROPERTY = eINSTANCE.getConstraint_DefProperty();

		/**
		 * The meta object literal for the '<em><b>Def Operation</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__DEF_OPERATION = eINSTANCE.getConstraint_DefOperation();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__CONTEXT = eINSTANCE.getConstraint_Context();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__BODY_EXPRESSION = eINSTANCE.getConstraint_BodyExpression();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl
		 * <em>Context Declaration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getContextDeclaration()
		 * @generated
		 */
		EClass CONTEXT_DECLARATION = eINSTANCE.getContextDeclaration();

		/**
		 * The meta object literal for the '<em><b>Referred Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTEXT_DECLARATION__REFERRED_NAMESPACE = eINSTANCE.getContextDeclaration_ReferredNamespace();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTEXT_DECLARATION__CONSTRAINT = eINSTANCE.getContextDeclaration_Constraint();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.DefinedOperationImpl
		 * <em>Defined Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.DefinedOperationImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getDefinedOperation()
		 * @generated
		 */
		EClass DEFINED_OPERATION = eINSTANCE.getDefinedOperation();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_OPERATION__DEFINITION = eINSTANCE.getDefinedOperation_Definition();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.DefinedPropertyImpl
		 * <em>Defined Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.DefinedPropertyImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getDefinedProperty()
		 * @generated
		 */
		EClass DEFINED_PROPERTY = eINSTANCE.getDefinedProperty();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_PROPERTY__DEFINITION = eINSTANCE.getDefinedProperty_Definition();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.OperationContextDeclImpl
		 * <em>Operation Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.OperationContextDeclImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getOperationContextDecl()
		 * @generated
		 */
		EClass OPERATION_CONTEXT_DECL = eINSTANCE.getOperationContextDecl();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL__REFERRED_OPERATION = eINSTANCE.getOperationContextDecl_ReferredOperation();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.impl.PropertyContextDeclImpl
		 * <em>Property Context Decl</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.PropertyContextDeclImpl
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getPropertyContextDecl()
		 * @generated
		 */
		EClass PROPERTY_CONTEXT_DECL = eINSTANCE.getPropertyContextDecl();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL__REFERRED_PROPERTY = eINSTANCE.getPropertyContextDecl_ReferredProperty();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.contexts.ConstraintKind <em>Constraint Kind</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.contexts.ConstraintKind
		 * @see org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl#getConstraintKind()
		 * @generated
		 */
		EEnum CONSTRAINT_KIND = eINSTANCE.getConstraintKind();

	}

} // ContextsPackage
