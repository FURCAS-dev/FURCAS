/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

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
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplateFactory
 * @model kind="package"
 * @generated
 */
public interface QvtTemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvttemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:semanticsQvt.model.qvttemplate.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "semanticsQvt.model.qvttemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtTemplatePackage eINSTANCE = de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl <em>Template Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getTemplateExp()
	 * @generated
	 */
	int TEMPLATE_EXP = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__TAG = ExpressionsPackage.LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__NAME = ExpressionsPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__IS_MARKED_PRE = ExpressionsPackage.LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__LOOP_EXP = ExpressionsPackage.LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__OPERATION_CALL_EXP = ExpressionsPackage.LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__PROPERTY_CALL_EXP = ExpressionsPackage.LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__TYPE = ExpressionsPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__APPLIED_PROPERTY = ExpressionsPackage.LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__INITIALISED_VARIABLE = ExpressionsPackage.LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__BINDS_TO = ExpressionsPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP__WHERE = ExpressionsPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_EXP_FEATURE_COUNT = ExpressionsPackage.LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl <em>Colletion Template Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getColletionTemplateExp()
	 * @generated
	 */
	int COLLETION_TEMPLATE_EXP = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__TAG = TEMPLATE_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__NAME = TEMPLATE_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__IS_MARKED_PRE = TEMPLATE_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__LOOP_EXP = TEMPLATE_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__OPERATION_CALL_EXP = TEMPLATE_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__PROPERTY_CALL_EXP = TEMPLATE_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__TYPE = TEMPLATE_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__APPLIED_PROPERTY = TEMPLATE_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__INITIALISED_VARIABLE = TEMPLATE_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__BINDS_TO = TEMPLATE_EXP__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__WHERE = TEMPLATE_EXP__WHERE;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__MATCH = TEMPLATE_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__PART = TEMPLATE_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reffered Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE = TEMPLATE_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Colletion Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLETION_TEMPLATE_EXP_FEATURE_COUNT = TEMPLATE_EXP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl <em>Object Template Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getObjectTemplateExp()
	 * @generated
	 */
	int OBJECT_TEMPLATE_EXP = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__TAG = TEMPLATE_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__NAME = TEMPLATE_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__IS_MARKED_PRE = TEMPLATE_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__LOOP_EXP = TEMPLATE_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__OPERATION_CALL_EXP = TEMPLATE_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__PROPERTY_CALL_EXP = TEMPLATE_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__TYPE = TEMPLATE_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__APPLIED_PROPERTY = TEMPLATE_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__INITIALISED_VARIABLE = TEMPLATE_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__BINDS_TO = TEMPLATE_EXP__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__WHERE = TEMPLATE_EXP__WHERE;

	/**
	 * The feature id for the '<em><b>Reffered Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__REFFERED_CLASS = TEMPLATE_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP__PART = TEMPLATE_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_EXP_FEATURE_COUNT = TEMPLATE_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.PropertyTemplateItemImpl <em>Property Template Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.PropertyTemplateItemImpl
	 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getPropertyTemplateItem()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_ITEM__TAG = BridgePackage.ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_ITEM__VALUE = BridgePackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY = BridgePackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Obj Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER = BridgePackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Template Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_ITEM_FEATURE_COUNT = BridgePackage.ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp <em>Colletion Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colletion Template Exp</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp
	 * @generated
	 */
	EClass getColletionTemplateExp();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Match</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getMatch()
	 * @see #getColletionTemplateExp()
	 * @generated
	 */
	EReference getColletionTemplateExp_Match();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getPart()
	 * @see #getColletionTemplateExp()
	 * @generated
	 */
	EReference getColletionTemplateExp_Part();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getRefferedCollectionType <em>Reffered Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reffered Collection Type</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getRefferedCollectionType()
	 * @see #getColletionTemplateExp()
	 * @generated
	 */
	EReference getColletionTemplateExp_RefferedCollectionType();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp <em>Object Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template Exp</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp
	 * @generated
	 */
	EClass getObjectTemplateExp();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getRefferedClass <em>Reffered Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reffered Class</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getRefferedClass()
	 * @see #getObjectTemplateExp()
	 * @generated
	 */
	EReference getObjectTemplateExp_RefferedClass();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp#getPart()
	 * @see #getObjectTemplateExp()
	 * @generated
	 */
	EReference getObjectTemplateExp_Part();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem <em>Property Template Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template Item</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem
	 * @generated
	 */
	EClass getPropertyTemplateItem();

	/**
	 * Returns the meta object for the containment reference '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getValue()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_Value();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getReferredProperty()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_ReferredProperty();

	/**
	 * Returns the meta object for the container reference '{@link de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Obj Container</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem#getObjContainer()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_ObjContainer();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp <em>Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Exp</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.TemplateExp
	 * @generated
	 */
	EClass getTemplateExp();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binds To</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getBindsTo()
	 * @see #getTemplateExp()
	 * @generated
	 */
	EReference getTemplateExp_BindsTo();

	/**
	 * Returns the meta object for the containment reference '{@link de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see de.ikv.medini.qvt.model.qvttemplate.TemplateExp#getWhere()
	 * @see #getTemplateExp()
	 * @generated
	 */
	EReference getTemplateExp_Where();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QvtTemplateFactory getQvtTemplateFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl <em>Colletion Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getColletionTemplateExp()
		 * @generated
		 */
		EClass COLLETION_TEMPLATE_EXP = eINSTANCE.getColletionTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLETION_TEMPLATE_EXP__MATCH = eINSTANCE.getColletionTemplateExp_Match();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLETION_TEMPLATE_EXP__PART = eINSTANCE.getColletionTemplateExp_Part();

		/**
		 * The meta object literal for the '<em><b>Reffered Collection Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE = eINSTANCE.getColletionTemplateExp_RefferedCollectionType();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl <em>Object Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getObjectTemplateExp()
		 * @generated
		 */
		EClass OBJECT_TEMPLATE_EXP = eINSTANCE.getObjectTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Reffered Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_EXP__REFFERED_CLASS = eINSTANCE.getObjectTemplateExp_RefferedClass();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_EXP__PART = eINSTANCE.getObjectTemplateExp_Part();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.PropertyTemplateItemImpl <em>Property Template Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.PropertyTemplateItemImpl
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getPropertyTemplateItem()
		 * @generated
		 */
		EClass PROPERTY_TEMPLATE_ITEM = eINSTANCE.getPropertyTemplateItem();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__VALUE = eINSTANCE.getPropertyTemplateItem_Value();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY = eINSTANCE.getPropertyTemplateItem_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Obj Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER = eINSTANCE.getPropertyTemplateItem_ObjContainer();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl <em>Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl
		 * @see de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl#getTemplateExp()
		 * @generated
		 */
		EClass TEMPLATE_EXP = eINSTANCE.getTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Binds To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_EXP__BINDS_TO = eINSTANCE.getTemplateExp_BindsTo();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_EXP__WHERE = eINSTANCE.getTemplateExp_Where();

	}

} //QvtTemplatePackage
