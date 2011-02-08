/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotPackage.java,v 1.5 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.pivot.PivotFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface PivotPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pivot"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/Pivot"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pivot"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.pivot"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PivotPackage eINSTANCE = org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OclExpressionImpl <em>Ocl Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OclExpressionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOclExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl <em>Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallExp()
	 * @generated
	 */
	int CALL_EXP = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeatureCallExp()
	 * @generated
	 */
	int FEATURE_CALL_EXP = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNavigationCallExp()
	 * @generated
	 */
	int NAVIGATION_CALL_EXP = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClassCallExp()
	 * @generated
	 */
	int ASSOCIATION_CLASS_CALL_EXP = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveLiteralExp()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP = 64;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallOperationAction()
	 * @generated
	 */
	int CALL_OPERATION_ACTION = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralPart()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl <em>Collection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionItem()
	 * @generated
	 */
	int COLLECTION_ITEM = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionRange()
	 * @generated
	 */
	int COLLECTION_RANGE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl <em>Complete Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteEnvironment()
	 * @generated
	 */
	int COMPLETE_ENVIRONMENT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteOperationImpl <em>Complete Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteOperationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteOperation()
	 * @generated
	 */
	int COMPLETE_OPERATION = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl <em>Complete Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompletePackage()
	 * @generated
	 */
	int COMPLETE_PACKAGE = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl <em>Complete Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteProperty()
	 * @generated
	 */
	int COMPLETE_PROPERTY = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl <em>Opaque Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOpaqueExpression()
	 * @generated
	 */
	int OPAQUE_EXPRESSION = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl <em>Expression In Ocl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getExpressionInOcl()
	 * @generated
	 */
	int EXPRESSION_IN_OCL = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 94;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl <em>If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIfExp()
	 * @generated
	 */
	int IF_EXP = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidLiteralExp()
	 * @generated
	 */
	int INVALID_LITERAL_EXP = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidType()
	 * @generated
	 */
	int INVALID_TYPE = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl <em>Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLoopExp()
	 * @generated
	 */
	int LOOP_EXP = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl <em>Message Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageExp()
	 * @generated
	 */
	int MESSAGE_EXP = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSendSignalAction()
	 * @generated
	 */
	int SEND_SIGNAL_ACTION = 69;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 72;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl <em>Message Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNullLiteralExp()
	 * @generated
	 */
	int NULL_LITERAL_EXP = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 55;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackageableElement()
	 * @generated
	 */
	int PACKAGEABLE_ELEMENT = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 65;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 67;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 68;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 70;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 71;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getState()
	 * @generated
	 */
	int STATE = 73;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl <em>State Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateExp()
	 * @generated
	 */
	int STATE_EXP = 74;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 75;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterType()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_TYPE = 79;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralExp()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP = 82;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralPart()
	 * @generated
	 */
	int TUPLE_LITERAL_PART = 83;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 84;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl <em>Type Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExp()
	 * @generated
	 */
	int TYPE_EXP = 86;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP = 90;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedValueExp()
	 * @generated
	 */
	int UNSPECIFIED_VALUE_EXP = 92;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 96;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 99;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPivotable()
	 * @generated
	 */
	int PIVOTABLE = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Visitable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 97;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl <em>Monikered Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMonikeredElement()
	 * @generated
	 */
	int MONIKERED_ELEMENT = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 85;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl <em>Templateable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateableElement()
	 * @generated
	 */
	int TEMPLATEABLE_ELEMENT = 81;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateBinding()
	 * @generated
	 */
	int TEMPLATE_BINDING = 76;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl <em>Template Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateSignature()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE = 80;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameter()
	 * @generated
	 */
	int TEMPLATE_PARAMETER = 77;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameterableElement()
	 * @generated
	 */
	int PARAMETERABLE_ELEMENT = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl <em>Template Parameter Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterSubstitution()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION = 78;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl <em>Precedence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrecedence()
	 * @generated
	 */
	int PRECEDENCE = 63;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl <em>Type Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeTemplateParameter()
	 * @generated
	 */
	int TYPE_TEMPLATE_PARAMETER = 87;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MultiplicityElementImpl <em>Multiplicity Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MultiplicityElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMultiplicityElement()
	 * @generated
	 */
	int MULTIPLICITY_ELEMENT = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl <em>Typed Multiplicity Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedMultiplicityElement()
	 * @generated
	 */
	int TYPED_MULTIPLICITY_ELEMENT = 89;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 66;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 88;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl <em>Association Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClass()
	 * @generated
	 */
	int ASSOCIATION_CLASS = 2;

	/**
	 * The meta object id for the '<em>Callable Implementation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallableImplementation()
	 * @generated
	 */
	int CALLABLE_IMPLEMENTATION = 103;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 95;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl <em>Operation Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationTemplateParameter()
	 * @generated
	 */
	int OPERATION_TEMPLATE_PARAMETER = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getValueSpecification()
	 * @generated
	 */
	int VALUE_SPECIFICATION = 93;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Nameable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl <em>Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDetail()
	 * @generated
	 */
	int DETAIL = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIterateExp()
	 * @generated
	 */
	int ITERATE_EXP = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteratorExp()
	 * @generated
	 */
	int ITERATOR_EXP = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 39;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNED_COMMENT = VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT__MONIKER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Monikered Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT___HAS_MONIKER = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Monikered Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_COMMENT = MONIKERED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MONIKER = MONIKERED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MONIKERED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_RULE = MONIKERED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__IS_STATIC = MONIKERED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_ANNOTATION = MONIKERED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MONIKERED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT___HAS_MONIKER = MONIKERED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MONIKERED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_DETAIL = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNING_TEMPLATE_PARAMETER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TEMPLATE_PARAMETER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TEMPLATE_BINDING = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_TEMPLATE_SIGNATURE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__INSTANCE_CLASS_NAME = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_TEMPLATE_PARAMETER = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___PARAMETERABLE_ELEMENTS = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_TEMPLATE = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MONIKER = TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_RULE = TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_ATTRIBUTE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_OPERATION = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPER_CLASS = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_INTERFACE = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUB_CLASS = TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___HAS_MONIKER = TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The number of structural features of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Unowned Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IMPLICIT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__REFERRED_FEATURE = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__MONIKER = CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_RULE = CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IS_STATIC = CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_ANNOTATION = CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IMPLICIT = CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__REFERRED_FEATURE = CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IS_PRE = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP___HAS_MONIKER = CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Feature Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__MONIKER = FEATURE_CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_RULE = FEATURE_CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IS_STATIC = FEATURE_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_ANNOTATION = FEATURE_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IMPLICIT = FEATURE_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__REFERRED_FEATURE = FEATURE_CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IS_PRE = FEATURE_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP___HAS_MONIKER = FEATURE_CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_OPERATION_COUNT = FEATURE_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__MONIKER = NAVIGATION_CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_RULE = NAVIGATION_CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IS_STATIC = NAVIGATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION = NAVIGATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IMPLICIT = NAVIGATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_FEATURE = NAVIGATION_CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IS_PRE = NAVIGATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP___HAS_MONIKER = NAVIGATION_CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_OPERATION_COUNT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_SERIALIZABLE = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__MONIKER = DATA_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SUB_CLASS = DATA_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___HAS_MONIKER = DATA_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__MONIKER = COLLECTION_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SUB_CLASS = COLLECTION_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___HAS_MONIKER = COLLECTION_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__MONIKER = LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_RULE = LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP___HAS_MONIKER = LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__MONIKER = PRIMITIVE_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_RULE = PRIMITIVE_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP___HAS_MONIKER = PRIMITIVE_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OPERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Operation Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Call Operation Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__MONIKER = COLLECTION_LITERAL_PART__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_RULE = COLLECTION_LITERAL_PART__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__IS_STATIC = COLLECTION_LITERAL_PART__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_ANNOTATION = COLLECTION_LITERAL_PART__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM___HAS_MONIKER = COLLECTION_LITERAL_PART___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_OPERATION_COUNT = COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__MONIKER = LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_RULE = LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___HAS_MONIKER = LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__MONIKER = COLLECTION_LITERAL_PART__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_RULE = COLLECTION_LITERAL_PART__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__IS_STATIC = COLLECTION_LITERAL_PART__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_ANNOTATION = COLLECTION_LITERAL_PART__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE___HAS_MONIKER = COLLECTION_LITERAL_PART___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_OPERATION_COUNT = COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BODY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__ANNOTATED_ELEMENT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__MONIKER = NAMESPACE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_RULE = NAMESPACE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__IS_STATIC = NAMESPACE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_ANNOTATION = NAMESPACE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__TEMPLATE_BINDING = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_TEMPLATE_SIGNATURE = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NESTED_PACKAGE = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NESTING_PACKAGE = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NS_PREFIX = NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NS_URI = NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_PRECEDENCE = NAMESPACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_TYPE = NAMESPACE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___HAS_MONIKER = NAMESPACE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___PARAMETERABLE_ELEMENTS = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___IS_TEMPLATE = NAMESPACE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_COMMENT = PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__MONIKER = PACKAGE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__NAME = PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_RULE = PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__IS_STATIC = PACKAGE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_ANNOTATION = PACKAGE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__TEMPLATE_BINDING = PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_TEMPLATE_SIGNATURE = PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__NESTED_PACKAGE = PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__NESTING_PACKAGE = PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__NS_PREFIX = PACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__NS_URI = PACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_PRECEDENCE = PACKAGE__OWNED_PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT__OWNED_TYPE = PACKAGE__OWNED_TYPE;

	/**
	 * The number of structural features of the '<em>Complete Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___HAS_MONIKER = PACKAGE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___PARAMETERABLE_ELEMENTS = PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___IS_TEMPLATE = PACKAGE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Get Complete Iteration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___GET_COMPLETE_ITERATION__ITERATION = PACKAGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Complete Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___GET_COMPLETE_OPERATION__OPERATION = PACKAGE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Complete Package</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___GET_COMPLETE_PACKAGE__PACKAGE = PACKAGE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Complete Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___GET_COMPLETE_PROPERTY__PROPERTY = PACKAGE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Complete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT___GET_COMPLETE_TYPE__TYPE = PACKAGE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Complete Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ENVIRONMENT_OPERATION_COUNT = PACKAGE_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_ORDERED = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_UNIQUE = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__LOWER = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__UPPER = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IMPLEMENTATION_CLASS = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IMPLEMENTATION = TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNING_TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TEMPLATE_BINDING = TYPED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_TEMPLATE_SIGNATURE = TYPED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RAISED_EXCEPTION = TYPED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PRECEDENCE = TYPED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CLASS = TYPED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___LOWER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___UPPER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_MULTIVALUED = TYPED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___INCLUDES_CARDINALITY__BIGINTEGER = TYPED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_TEMPLATE_PARAMETER = TYPED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___PARAMETERABLE_ELEMENTS = TYPED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_TEMPLATE = TYPED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Validate Test Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl <em>Complete Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteType()
	 * @generated
	 */
	int COMPLETE_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_COMMENT = OPERATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__MONIKER = OPERATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_RULE = OPERATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_STATIC = OPERATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ANNOTATION = OPERATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TYPE = OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_ORDERED = OPERATION__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_UNIQUE = OPERATION__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__LOWER = OPERATION__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__UPPER = OPERATION__UPPER;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IMPLEMENTATION_CLASS = OPERATION__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IMPLEMENTATION = OPERATION__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNING_TEMPLATE_PARAMETER = OPERATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TEMPLATE_PARAMETER = OPERATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TEMPLATE_BINDING = OPERATION__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_TEMPLATE_SIGNATURE = OPERATION__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__RAISED_EXCEPTION = OPERATION__RAISED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_PARAMETER = OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__PRECEDENCE = OPERATION__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__CLASS = OPERATION__CLASS;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ITERATOR = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ACCUMULATOR = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___HAS_MONIKER = OPERATION___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___LOWER_BOUND = OPERATION___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___UPPER_BOUND = OPERATION___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_MULTIVALUED = OPERATION___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___INCLUDES_CARDINALITY__BIGINTEGER = OPERATION___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = OPERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_TEMPLATE_PARAMETER = OPERATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___PARAMETERABLE_ELEMENTS = OPERATION___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_TEMPLATE = OPERATION___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Validate Test Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl <em>Complete Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteIteration()
	 * @generated
	 */
	int COMPLETE_ITERATION = 16;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_COMMENT = ITERATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__MONIKER = ITERATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__NAME = ITERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_RULE = ITERATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__IS_STATIC = ITERATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_ANNOTATION = ITERATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__TYPE = ITERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__IS_ORDERED = ITERATION__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__IS_UNIQUE = ITERATION__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__LOWER = ITERATION__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__UPPER = ITERATION__UPPER;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__IMPLEMENTATION_CLASS = ITERATION__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__IMPLEMENTATION = ITERATION__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNING_TEMPLATE_PARAMETER = ITERATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__TEMPLATE_PARAMETER = ITERATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__TEMPLATE_BINDING = ITERATION__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_TEMPLATE_SIGNATURE = ITERATION__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__RAISED_EXCEPTION = ITERATION__RAISED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_PARAMETER = ITERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__PRECEDENCE = ITERATION__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__CLASS = ITERATION__CLASS;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_ITERATOR = ITERATION__OWNED_ITERATOR;

	/**
	 * The feature id for the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__OWNED_ACCUMULATOR = ITERATION__OWNED_ACCUMULATOR;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__MODEL = ITERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__COMPLETE_ENVIRONMENT = ITERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete Iterator</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__COMPLETE_ITERATOR = ITERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Complete Accumulator</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__COMPLETE_ACCUMULATOR = ITERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Complete Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION__COMPLETE_PARAMETER = ITERATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Complete Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION_FEATURE_COUNT = ITERATION_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___HAS_MONIKER = ITERATION___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = ITERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = ITERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___LOWER_BOUND = ITERATION___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___UPPER_BOUND = ITERATION___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___IS_MULTIVALUED = ITERATION___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___INCLUDES_CARDINALITY__BIGINTEGER = ITERATION___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = ITERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___IS_TEMPLATE_PARAMETER = ITERATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___PARAMETERABLE_ELEMENTS = ITERATION___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___IS_TEMPLATE = ITERATION___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Validate Test Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP = ITERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Complete Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_ITERATION_OPERATION_COUNT = ITERATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNED_COMMENT = OPERATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__MONIKER = OPERATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNED_RULE = OPERATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__IS_STATIC = OPERATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNED_ANNOTATION = OPERATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__TYPE = OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__IS_ORDERED = OPERATION__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__IS_UNIQUE = OPERATION__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__LOWER = OPERATION__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__UPPER = OPERATION__UPPER;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__IMPLEMENTATION_CLASS = OPERATION__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__IMPLEMENTATION = OPERATION__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNING_TEMPLATE_PARAMETER = OPERATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__TEMPLATE_PARAMETER = OPERATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__TEMPLATE_BINDING = OPERATION__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNED_TEMPLATE_SIGNATURE = OPERATION__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__RAISED_EXCEPTION = OPERATION__RAISED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__OWNED_PARAMETER = OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__PRECEDENCE = OPERATION__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__CLASS = OPERATION__CLASS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__MODEL = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__COMPLETE_ENVIRONMENT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION__COMPLETE_PARAMETER = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complete Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___HAS_MONIKER = OPERATION___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___LOWER_BOUND = OPERATION___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___UPPER_BOUND = OPERATION___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___IS_MULTIVALUED = OPERATION___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___INCLUDES_CARDINALITY__BIGINTEGER = OPERATION___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = OPERATION___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___IS_TEMPLATE_PARAMETER = OPERATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___PARAMETERABLE_ELEMENTS = OPERATION___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___IS_TEMPLATE = OPERATION___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Validate Test Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Complete Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OPERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_COMMENT = PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__MONIKER = PACKAGE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__NAME = PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_RULE = PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__IS_STATIC = PACKAGE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_ANNOTATION = PACKAGE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__TEMPLATE_BINDING = PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_TEMPLATE_SIGNATURE = PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__NESTED_PACKAGE = PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__NESTING_PACKAGE = PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__NS_PREFIX = PACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__NS_URI = PACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_PRECEDENCE = PACKAGE__OWNED_PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__OWNED_TYPE = PACKAGE__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__MODEL = PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT = PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__COMPLETE_TYPE = PACKAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Complete Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE__COMPLETE_PACKAGE = PACKAGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE___HAS_MONIKER = PACKAGE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE___PARAMETERABLE_ELEMENTS = PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE___IS_TEMPLATE = PACKAGE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PACKAGE_OPERATION_COUNT = PACKAGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_ORDERED = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_UNIQUE = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLEMENTATION_CLASS = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLEMENTATION = TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNING_TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_READ_ONLY = TYPED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT = TYPED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_COMPOSITE = TYPED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DERIVED = TYPED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OPPOSITE = TYPED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ASSOCIATION = TYPED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLICIT = TYPED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Is ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_ID = TYPED_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEYS = TYPED_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_RESOLVE_PROXIES = TYPED_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_TRANSIENT = TYPED_ELEMENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Is Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_UNSETTABLE = TYPED_ELEMENT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Is Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_VOLATILE = TYPED_ELEMENT_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CLASS = TYPED_ELEMENT_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 22;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___LOWER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___UPPER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_MULTIVALUED = TYPED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___INCLUDES_CARDINALITY__BIGINTEGER = TYPED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_TEMPLATE_PARAMETER = TYPED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Validate Binding To Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___VALIDATE_BINDING_TO_ATTRIBUTE__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__OWNED_COMMENT = PROPERTY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__MONIKER = PROPERTY__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__OWNED_RULE = PROPERTY__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_STATIC = PROPERTY__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__OWNED_ANNOTATION = PROPERTY__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__TYPE = PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_ORDERED = PROPERTY__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_UNIQUE = PROPERTY__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__LOWER = PROPERTY__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__UPPER = PROPERTY__UPPER;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IMPLEMENTATION_CLASS = PROPERTY__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IMPLEMENTATION = PROPERTY__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__OWNING_TEMPLATE_PARAMETER = PROPERTY__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__TEMPLATE_PARAMETER = PROPERTY__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Is Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_READ_ONLY = PROPERTY__IS_READ_ONLY;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__DEFAULT = PROPERTY__DEFAULT;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_COMPOSITE = PROPERTY__IS_COMPOSITE;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_DERIVED = PROPERTY__IS_DERIVED;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__OPPOSITE = PROPERTY__OPPOSITE;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__ASSOCIATION = PROPERTY__ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IMPLICIT = PROPERTY__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Is ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_ID = PROPERTY__IS_ID;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__KEYS = PROPERTY__KEYS;

	/**
	 * The feature id for the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_RESOLVE_PROXIES = PROPERTY__IS_RESOLVE_PROXIES;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_TRANSIENT = PROPERTY__IS_TRANSIENT;

	/**
	 * The feature id for the '<em><b>Is Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_UNSETTABLE = PROPERTY__IS_UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Is Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__IS_VOLATILE = PROPERTY__IS_VOLATILE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__CLASS = PROPERTY__CLASS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__MODEL = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complete Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___HAS_MONIKER = PROPERTY___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = PROPERTY___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = PROPERTY___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___LOWER_BOUND = PROPERTY___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___UPPER_BOUND = PROPERTY___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___IS_MULTIVALUED = PROPERTY___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___INCLUDES_CARDINALITY__BIGINTEGER = PROPERTY___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = PROPERTY___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___IS_TEMPLATE_PARAMETER = PROPERTY___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Binding To Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY___VALIDATE_BINDING_TO_ATTRIBUTE__DIAGNOSTICCHAIN_MAP = PROPERTY___VALIDATE_BINDING_TO_ATTRIBUTE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Complete Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__MODEL = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__COMPLETE_ENVIRONMENT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__COMPLETE_OPERATION = CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Complete Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__COMPLETE_PROPERTY = CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Complete Super Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE__COMPLETE_SUPER_TYPE = CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Complete Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Conforms To</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___CONFORMS_TO__COMPLETETYPE = CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Dynamic Iteration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___GET_DYNAMIC_ITERATION__COMPLETEITERATION = CLASS_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Dynamic Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___GET_DYNAMIC_OPERATION__COMPLETEOPERATION = CLASS_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Complete Iterations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___GET_COMPLETE_ITERATIONS__STRING = CLASS_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Complete Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE___GET_COMPLETE_OPERATIONS__STRING = CLASS_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Complete Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Constrained Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINED_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SPECIFICATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Not Apply To Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___VALIDATE_NOT_APPLY_TO_SELF__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Value Specification Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___VALIDATE_VALUE_SPECIFICATION_BOOLEAN__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__MONIKER = LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_RULE = LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP___HAS_MONIKER = LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__MONIKER = DATA_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__SUB_CLASS = DATA_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_LITERAL = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___HAS_MONIKER = DATA_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ENUMERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNING_TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_TEMPLATE_PARAMETER = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_COMPUTABLE = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___INTEGER_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___BOOLEAN_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___STRING_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___UNLIMITED_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_NULL = TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNED_COMMENT = VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__MONIKER = VALUE_SPECIFICATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__NAME = VALUE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNED_RULE = VALUE_SPECIFICATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__IS_STATIC = VALUE_SPECIFICATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNED_ANNOTATION = VALUE_SPECIFICATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER = VALUE_SPECIFICATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__TEMPLATE_PARAMETER = VALUE_SPECIFICATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__BODY = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__LANGUAGE = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Opaque Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___HAS_MONIKER = VALUE_SPECIFICATION___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_TEMPLATE_PARAMETER = VALUE_SPECIFICATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_COMPUTABLE = VALUE_SPECIFICATION___IS_COMPUTABLE;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___INTEGER_VALUE = VALUE_SPECIFICATION___INTEGER_VALUE;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___BOOLEAN_VALUE = VALUE_SPECIFICATION___BOOLEAN_VALUE;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___STRING_VALUE = VALUE_SPECIFICATION___STRING_VALUE;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___UNLIMITED_VALUE = VALUE_SPECIFICATION___UNLIMITED_VALUE;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_NULL = VALUE_SPECIFICATION___IS_NULL;

	/**
	 * The operation id for the '<em>Validate Language Body Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___VALIDATE_LANGUAGE_BODY_SIZE__DIAGNOSTICCHAIN_MAP = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Opaque Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_COMMENT = OPAQUE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__MONIKER = OPAQUE_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__NAME = OPAQUE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_RULE = OPAQUE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__IS_STATIC = OPAQUE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_ANNOTATION = OPAQUE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TYPE = OPAQUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER = OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TEMPLATE_PARAMETER = OPAQUE_EXPRESSION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY = OPAQUE_EXPRESSION__BODY;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__LANGUAGE = OPAQUE_EXPRESSION__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY_EXPRESSION = OPAQUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__RESULT_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expression In Ocl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_FEATURE_COUNT = OPAQUE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___HAS_MONIKER = OPAQUE_EXPRESSION___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_TEMPLATE_PARAMETER = OPAQUE_EXPRESSION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_COMPUTABLE = OPAQUE_EXPRESSION___IS_COMPUTABLE;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___INTEGER_VALUE = OPAQUE_EXPRESSION___INTEGER_VALUE;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___BOOLEAN_VALUE = OPAQUE_EXPRESSION___BOOLEAN_VALUE;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___STRING_VALUE = OPAQUE_EXPRESSION___STRING_VALUE;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___UNLIMITED_VALUE = OPAQUE_EXPRESSION___UNLIMITED_VALUE;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_NULL = OPAQUE_EXPRESSION___IS_NULL;

	/**
	 * The operation id for the '<em>Validate Language Body Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___VALIDATE_LANGUAGE_BODY_SIZE__DIAGNOSTICCHAIN_MAP = OPAQUE_EXPRESSION___VALIDATE_LANGUAGE_BODY_SIZE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Expression In Ocl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_OPERATION_COUNT = OPAQUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__LOWER = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__UPPER = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Typed Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___LOWER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___UPPER_BOUND = TYPED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___IS_MULTIVALUED = TYPED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER = TYPED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Typed Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_COMMENT = TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__MONIKER = TYPED_MULTIPLICITY_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = TYPED_MULTIPLICITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_RULE = TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_STATIC = TYPED_MULTIPLICITY_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_ANNOTATION = TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = TYPED_MULTIPLICITY_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_ORDERED = TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_UNIQUE = TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__LOWER = TYPED_MULTIPLICITY_ELEMENT__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__UPPER = TYPED_MULTIPLICITY_ELEMENT__UPPER;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IMPLEMENTATION_CLASS = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IMPLEMENTATION = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___HAS_MONIKER = TYPED_MULTIPLICITY_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = TYPED_MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = TYPED_MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___LOWER_BOUND = TYPED_MULTIPLICITY_ELEMENT___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___UPPER_BOUND = TYPED_MULTIPLICITY_ELEMENT___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___IS_MULTIVALUED = TYPED_MULTIPLICITY_ELEMENT___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___INCLUDES_CARDINALITY__BIGINTEGER = TYPED_MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = TYPED_MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__MONIKER = PRIMITIVE_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_RULE = PRIMITIVE_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP___HAS_MONIKER = PRIMITIVE_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__MONIKER = NUMERIC_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_RULE = NUMERIC_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP___HAS_MONIKER = NUMERIC_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__MONIKER = LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_RULE = LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OBJECT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__EXPRESSION = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__REASON = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Throwable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__THROWABLE = LITERAL_EXP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP___HAS_MONIKER = LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Invalid Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The number of structural features of the '<em>Invalid Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Invalid Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__MONIKER = CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_RULE = CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IS_STATIC = CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_ANNOTATION = CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IMPLICIT = CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__REFERRED_FEATURE = CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__ITERATOR = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__REFERRED_ITERATION = CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP___HAS_MONIKER = CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__MONIKER = LOOP_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_RULE = LOOP_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IS_STATIC = LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_ANNOTATION = LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IMPLICIT = LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__REFERRED_FEATURE = LOOP_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__REFERRED_ITERATION = LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___HAS_MONIKER = LOOP_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_OPERATION_COUNT = LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__MONIKER = LOOP_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_RULE = LOOP_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IS_STATIC = LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_ANNOTATION = LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IMPLICIT = LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__REFERRED_FEATURE = LOOP_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__REFERRED_ITERATION = LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The number of structural features of the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___HAS_MONIKER = LOOP_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_OPERATION_COUNT = LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_COMMENT = PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MONIKER = PACKAGE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_RULE = PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IS_STATIC = PACKAGE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_ANNOTATION = PACKAGE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TEMPLATE_BINDING = PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_TEMPLATE_SIGNATURE = PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NESTED_PACKAGE = PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NESTING_PACKAGE = PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_PREFIX = PACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_URI = PACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_PRECEDENCE = PACKAGE__OWNED_PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_TYPE = PACKAGE__OWNED_TYPE;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___HAS_MONIKER = PACKAGE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___PARAMETERABLE_ELEMENTS = PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___IS_TEMPLATE = PACKAGE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = PACKAGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__MONIKER = TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_RULE = TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_SIGNAL = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_OPERATION = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___HAS_MONIKER = TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__OWNED_COMMENT = MONIKERED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__MONIKER = MONIKERED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__IS_ORDERED = MONIKERED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__IS_UNIQUE = MONIKERED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__LOWER = MONIKERED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT__UPPER = MONIKERED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT_FEATURE_COUNT = MONIKERED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___HAS_MONIKER = MONIKERED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = MONIKERED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = MONIKERED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___LOWER_BOUND = MONIKERED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___UPPER_BOUND = MONIKERED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___IS_MULTIVALUED = MONIKERED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER = MONIKERED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = MONIKERED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_ELEMENT_OPERATION_COUNT = MONIKERED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__MONIKER = PRIMITIVE_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_RULE = PRIMITIVE_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Null Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP___HAS_MONIKER = PRIMITIVE_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Null Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__MONIKER = FEATURE_CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_RULE = FEATURE_CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_STATIC = FEATURE_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_ANNOTATION = FEATURE_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IMPLICIT = FEATURE_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_FEATURE = FEATURE_CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_PRE = FEATURE_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___HAS_MONIKER = FEATURE_CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_OPERATION_COUNT = FEATURE_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__SIGNATURE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__DEFAULT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_DEFAULT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Must Be Compatible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_COMMENT = TEMPLATE_PARAMETER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__SIGNATURE = TEMPLATE_PARAMETER__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__DEFAULT = TEMPLATE_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_DEFAULT = TEMPLATE_PARAMETER__OWNED_DEFAULT;

	/**
	 * The number of structural features of the '<em>Operation Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER_FEATURE_COUNT = TEMPLATE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Must Be Compatible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Operation Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER_OPERATION_COUNT = TEMPLATE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__MONIKER = COLLECTION_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SUB_CLASS = COLLECTION_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___HAS_MONIKER = COLLECTION_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__OWNED_COMMENT = MONIKERED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__MONIKER = MONIKERED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = MONIKERED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER = MONIKERED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameterable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_FEATURE_COUNT = MONIKERED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___HAS_MONIKER = MONIKERED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER = MONIKERED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameterable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_OPERATION_COUNT = MONIKERED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__OWNED_COMMENT = PARAMETERABLE_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__MONIKER = PARAMETERABLE_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER;

	/**
	 * The number of structural features of the '<em>Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT_FEATURE_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___HAS_MONIKER = PARAMETERABLE_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___IS_TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER;

	/**
	 * The number of operations of the '<em>Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT_OPERATION_COUNT = PARAMETERABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNED_COMMENT = TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MONIKER = TYPED_MULTIPLICITY_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = TYPED_MULTIPLICITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNED_RULE = TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_STATIC = TYPED_MULTIPLICITY_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNED_ANNOTATION = TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = TYPED_MULTIPLICITY_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_ORDERED = TYPED_MULTIPLICITY_ELEMENT__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_UNIQUE = TYPED_MULTIPLICITY_ELEMENT__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LOWER = TYPED_MULTIPLICITY_ELEMENT__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__UPPER = TYPED_MULTIPLICITY_ELEMENT__UPPER;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPERATION = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___HAS_MONIKER = TYPED_MULTIPLICITY_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Lower Ge0</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = TYPED_MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Upper Ge Lower</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = TYPED_MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Lower Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___LOWER_BOUND = TYPED_MULTIPLICITY_ELEMENT___LOWER_BOUND;

	/**
	 * The operation id for the '<em>Upper Bound</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___UPPER_BOUND = TYPED_MULTIPLICITY_ELEMENT___UPPER_BOUND;

	/**
	 * The operation id for the '<em>Is Multivalued</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___IS_MULTIVALUED = TYPED_MULTIPLICITY_ELEMENT___IS_MULTIVALUED;

	/**
	 * The operation id for the '<em>Includes Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___INCLUDES_CARDINALITY__BIGINTEGER = TYPED_MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER;

	/**
	 * The operation id for the '<em>Includes Multiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = TYPED_MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Associativity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__ASSOCIATIVITY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__ORDER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__MONIKER = DATA_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SUB_CLASS = DATA_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___HAS_MONIKER = DATA_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__MONIKER = NAVIGATION_CALL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_RULE = NAVIGATION_CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_STATIC = NAVIGATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_ANNOTATION = NAVIGATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IMPLICIT = NAVIGATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Referred Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_FEATURE = NAVIGATION_CALL_EXP__REFERRED_FEATURE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_PRE = NAVIGATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___HAS_MONIKER = NAVIGATION_CALL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_OPERATION_COUNT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__MONIKER = NUMERIC_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_RULE = NUMERIC_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP___HAS_MONIKER = NUMERIC_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__SIGNAL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Send Signal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Send Signal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__MONIKER = COLLECTION_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SUB_CLASS = COLLECTION_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___HAS_MONIKER = COLLECTION_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__MONIKER = COLLECTION_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SUB_CLASS = COLLECTION_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___HAS_MONIKER = COLLECTION_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The number of structural features of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__MONIKER = NAMED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_RULE = NAMED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___HAS_MONIKER = NAMED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>State Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__MONIKER = PRIMITIVE_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_RULE = PRIMITIVE_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP___HAS_MONIKER = PRIMITIVE_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__SIGNATURE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__PARAMETER_SUBSTITUTION = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__BOUND_ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Parameter Substitution Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING___VALIDATE_PARAMETER_SUBSTITUTION_FORMAL__DIAGNOSTICCHAIN_MAP = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate One Parameter Substitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING___VALIDATE_ONE_PARAMETER_SUBSTITUTION__DIAGNOSTICCHAIN_MAP = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Formal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Actual</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Template Parameter Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Must Be Compatible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Template Parameter Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__MONIKER = TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_RULE = TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__SPECIFICATION = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___HAS_MONIKER = TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__OWNED_COMMENT = MONIKERED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__MONIKER = MONIKERED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__PARAMETER = MONIKERED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__OWNED_PARAMETER = MONIKERED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__TEMPLATE = MONIKERED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_FEATURE_COUNT = MONIKERED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE___HAS_MONIKER = MONIKERED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Validate Own Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE___VALIDATE_OWN_ELEMENTS__DIAGNOSTICCHAIN_MAP = MONIKERED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_OPERATION_COUNT = MONIKERED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__OWNED_COMMENT = MONIKERED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__MONIKER = MONIKERED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING = MONIKERED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE = MONIKERED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Templateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_FEATURE_COUNT = MONIKERED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___HAS_MONIKER = MONIKERED_ELEMENT___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___PARAMETERABLE_ELEMENTS = MONIKERED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___IS_TEMPLATE = MONIKERED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Templateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_OPERATION_COUNT = MONIKERED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__MONIKER = LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_RULE = LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP___HAS_MONIKER = LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__MONIKER = TYPED_ELEMENT__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__OWNED_RULE = TYPED_ELEMENT__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION___HAS_MONIKER = TYPED_ELEMENT___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_COMMENT = VARIABLE_DECLARATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__MONIKER = VARIABLE_DECLARATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_RULE = VARIABLE_DECLARATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__IS_STATIC = VARIABLE_DECLARATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_ANNOTATION = VARIABLE_DECLARATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__INIT_EXPRESSION = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART___HAS_MONIKER = VARIABLE_DECLARATION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__MONIKER = DATA_TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__SUB_CLASS = DATA_TYPE__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___HAS_MONIKER = DATA_TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT = TEMPLATE_PARAMETER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__SIGNATURE = TEMPLATE_PARAMETER__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__DEFAULT = TEMPLATE_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT = TEMPLATE_PARAMETER__OWNED_DEFAULT;

	/**
	 * The feature id for the '<em><b>Allow Substitutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE = TEMPLATE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraining Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE = TEMPLATE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER_FEATURE_COUNT = TEMPLATE_PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Must Be Compatible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Has Constraining Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER___VALIDATE_HAS_CONSTRAINING_TYPE__DIAGNOSTICCHAIN_MAP = TEMPLATE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER_OPERATION_COUNT = TEMPLATE_PARAMETER_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__MONIKER = NUMERIC_LITERAL_EXP__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_RULE = NUMERIC_LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Unlimited Natural Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP___HAS_MONIKER = NUMERIC_LITERAL_EXP___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Unlimited Natural Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl <em>Unspecified Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedType()
	 * @generated
	 */
	int UNSPECIFIED_TYPE = 91;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__MONIKER = TYPE__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_RULE = TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__LOWER_BOUND = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__UPPER_BOUND = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unspecified Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___HAS_MONIKER = TYPE___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Unspecified Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_COMMENT = VARIABLE_DECLARATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MONIKER = VARIABLE_DECLARATION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_RULE = VARIABLE_DECLARATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IS_STATIC = VARIABLE_DECLARATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_ANNOTATION = VARIABLE_DECLARATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INIT_EXPRESSION = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REPRESENTED_PARAMETER = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IMPLICIT = VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___HAS_MONIKER = VARIABLE_DECLARATION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__MONIKER = OCL_EXPRESSION__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_RULE = OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IMPLICIT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP___HAS_MONIKER = OCL_EXPRESSION___HAS_MONIKER;

	/**
	 * The number of operations of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Visitor
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 98;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__MONIKER = CLASS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__SUB_CLASS = CLASS__SUB_CLASS;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Has Moniker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___HAS_MONIKER = CLASS___HAS_MONIKER;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The number of operations of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociativityKind()
	 * @generated
	 */
	int ASSOCIATIVITY_KIND = 100;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionKind()
	 * @generated
	 */
	int COLLECTION_KIND = 101;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 102;

	/**
	 * The meta object id for the '<em>Int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInt()
	 * @generated
	 */
	int INT = 104;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigInteger
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 105;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 106;

	/**
	 * The meta object id for the '<em>Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReal()
	 * @generated
	 */
	int REAL = 107;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getString()
	 * @generated
	 */
	int STRING = 108;

	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 109;

	/**
	 * The meta object id for the '<em>Unlimited Natural</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigInteger
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNatural()
	 * @generated
	 */
	int UNLIMITED_NATURAL = 110;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedContents <em>Owned Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Content</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getOwnedContents()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedContent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetails <em>Owned Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Detail</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetails()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedDetail();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getReferences <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getReferences()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Reference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.NamedElement#getOwnedRules <em>Owned Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rule</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#getOwnedRules()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_OwnedRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.NamedElement#isStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#isStatic()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_IsStatic();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.NamedElement#getOwnedAnnotations <em>Owned Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#getOwnedAnnotations()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_OwnedAnnotation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Element#getOwnedComments <em>Owned Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Comment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element#getOwnedComments()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedComment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OclExpression
	 * @generated
	 */
	EClass getOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CollectionType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.DataType#isSerializable <em>Is Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Serializable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DataType#isSerializable()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_IsSerializable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp
	 * @generated
	 */
	EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CallOperationAction <em>Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Operation Action</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallOperationAction
	 * @generated
	 */
	EClass getCallOperationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CallOperationAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallOperationAction#getOperation()
	 * @see #getCallOperationAction()
	 * @generated
	 */
	EReference getCallOperationAction_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionItem#getItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
	EReference getCollectionItem_Item();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getParts <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getParts()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange#getFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_First();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange#getLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_Last();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment
	 * @generated
	 */
	EClass getCompleteEnvironment();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteIteration(org.eclipse.ocl.examples.pivot.Iteration) <em>Get Complete Iteration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Iteration</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteIteration(org.eclipse.ocl.examples.pivot.Iteration)
	 * @generated
	 */
	EOperation getCompleteEnvironment__GetCompleteIteration__Iteration();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteOperation(org.eclipse.ocl.examples.pivot.Operation) <em>Get Complete Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Operation</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteOperation(org.eclipse.ocl.examples.pivot.Operation)
	 * @generated
	 */
	EOperation getCompleteEnvironment__GetCompleteOperation__Operation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompletePackage(org.eclipse.ocl.examples.pivot.Package) <em>Get Complete Package</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Package</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompletePackage(org.eclipse.ocl.examples.pivot.Package)
	 * @generated
	 */
	EOperation getCompleteEnvironment__GetCompletePackage__Package();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteProperty(org.eclipse.ocl.examples.pivot.Property) <em>Get Complete Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Property</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteProperty(org.eclipse.ocl.examples.pivot.Property)
	 * @generated
	 */
	EOperation getCompleteEnvironment__GetCompleteProperty__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteType(org.eclipse.ocl.examples.pivot.Type) <em>Get Complete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteEnvironment#getCompleteType(org.eclipse.ocl.examples.pivot.Type)
	 * @generated
	 */
	EOperation getCompleteEnvironment__GetCompleteType__Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompleteIteration <em>Complete Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration
	 * @generated
	 */
	EClass getCompleteIteration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration#getModel()
	 * @see #getCompleteIteration()
	 * @generated
	 */
	EReference getCompleteIteration_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteEnvironment()
	 * @see #getCompleteIteration()
	 * @generated
	 */
	EReference getCompleteIteration_CompleteEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteIterators <em>Complete Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Iterator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteIterators()
	 * @see #getCompleteIteration()
	 * @generated
	 */
	EReference getCompleteIteration_CompleteIterator();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteAccumulators <em>Complete Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Accumulator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteAccumulators()
	 * @see #getCompleteIteration()
	 * @generated
	 */
	EReference getCompleteIteration_CompleteAccumulator();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteParameters <em>Complete Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteParameters()
	 * @see #getCompleteIteration()
	 * @generated
	 */
	EReference getCompleteIteration_CompleteParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompleteOperation <em>Complete Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteOperation
	 * @generated
	 */
	EClass getCompleteOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteOperation#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteOperation#getModel()
	 * @see #getCompleteOperation()
	 * @generated
	 */
	EReference getCompleteOperation_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteOperation#getCompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteOperation#getCompleteEnvironment()
	 * @see #getCompleteOperation()
	 * @generated
	 */
	EReference getCompleteOperation_CompleteEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteOperation#getCompleteParameters <em>Complete Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteOperation#getCompleteParameters()
	 * @see #getCompleteOperation()
	 * @generated
	 */
	EReference getCompleteOperation_CompleteParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompletePackage <em>Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage
	 * @generated
	 */
	EClass getCompletePackage();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getModel()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteEnvironment()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_CompleteEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteTypes <em>Complete Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteTypes()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_CompleteType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompletePackages <em>Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getCompletePackages()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_CompletePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompleteProperty <em>Complete Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteProperty
	 * @generated
	 */
	EClass getCompleteProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteProperty#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteProperty#getModel()
	 * @see #getCompleteProperty()
	 * @generated
	 */
	EReference getCompleteProperty_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteProperty#getCompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteProperty#getCompleteEnvironment()
	 * @see #getCompleteProperty()
	 * @generated
	 */
	EReference getCompleteProperty_CompleteEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CompleteType <em>Complete Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType
	 * @generated
	 */
	EClass getCompleteType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteType#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getModel()
	 * @see #getCompleteType()
	 * @generated
	 */
	EReference getCompleteType_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteEnvironment()
	 * @see #getCompleteType()
	 * @generated
	 */
	EReference getCompleteType_CompleteEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteOperations <em>Complete Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteOperations()
	 * @see #getCompleteType()
	 * @generated
	 */
	EReference getCompleteType_CompleteOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteProperties <em>Complete Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteProperties()
	 * @see #getCompleteType()
	 * @generated
	 */
	EReference getCompleteType_CompleteProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteSuperTypes <em>Complete Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Super Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteSuperTypes()
	 * @see #getCompleteType()
	 * @generated
	 */
	EReference getCompleteType_CompleteSuperType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteType#conformsTo(org.eclipse.ocl.examples.pivot.CompleteType) <em>Conforms To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conforms To</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#conformsTo(org.eclipse.ocl.examples.pivot.CompleteType)
	 * @generated
	 */
	EOperation getCompleteType__ConformsTo__CompleteType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteType#getDynamicIteration(org.eclipse.ocl.examples.pivot.CompleteIteration) <em>Get Dynamic Iteration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dynamic Iteration</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getDynamicIteration(org.eclipse.ocl.examples.pivot.CompleteIteration)
	 * @generated
	 */
	EOperation getCompleteType__GetDynamicIteration__CompleteIteration();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteType#getDynamicOperation(org.eclipse.ocl.examples.pivot.CompleteOperation) <em>Get Dynamic Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dynamic Operation</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getDynamicOperation(org.eclipse.ocl.examples.pivot.CompleteOperation)
	 * @generated
	 */
	EOperation getCompleteType__GetDynamicOperation__CompleteOperation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteIterations(java.lang.String) <em>Get Complete Iterations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Iterations</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteIterations(java.lang.String)
	 * @generated
	 */
	EOperation getCompleteType__GetCompleteIterations__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteOperations(java.lang.String) <em>Get Complete Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Complete Operations</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CompleteType#getCompleteOperations(java.lang.String)
	 * @generated
	 */
	EOperation getCompleteType__GetCompleteOperations__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Enum Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumLiteralExp#getReferredEnumLiteral()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_ReferredEnumLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_Enumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiterals <em>Owned Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_OwnedLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl <em>Expression In Ocl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In Ocl</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOcl
	 * @generated
	 */
	EClass getExpressionInOcl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOcl#getBodyExpression()
	 * @see #getExpressionInOcl()
	 * @generated
	 */
	EReference getExpressionInOcl_BodyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getContextVariable <em>Context Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOcl#getContextVariable()
	 * @see #getExpressionInOcl()
	 * @generated
	 */
	EReference getExpressionInOcl_ContextVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getResultVariable <em>Result Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOcl#getResultVariable()
	 * @see #getExpressionInOcl()
	 * @generated
	 */
	EReference getExpressionInOcl_ResultVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getParameterVariables <em>Parameter Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOcl#getParameterVariables()
	 * @see #getExpressionInOcl()
	 * @generated
	 */
	EReference getExpressionInOcl_ParameterVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Feature#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature#getImplementationClass()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ImplementationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Feature#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature#getImplementation()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression <em>Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression
	 * @generated
	 */
	EClass getOpaqueExpression();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getBodies <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#getBodies()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EAttribute getOpaqueExpression_Body();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguages <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Language</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguages()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EAttribute getOpaqueExpression_Language();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#validateLanguageBodySize(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Language Body Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Language Body Size</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#validateLanguageBodySize(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOpaqueExpression__ValidateLanguageBodySize__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#getInitExpression()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_InitExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_RepresentedParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#isImplicit()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp
	 * @generated
	 */
	EClass getIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getCondition()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getThenExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getElseExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp
	 * @generated
	 */
	EClass getInvalidLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getObject()
	 * @see #getInvalidLiteralExp()
	 * @generated
	 */
	EAttribute getInvalidLiteralExp_Object();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getExpression()
	 * @see #getInvalidLiteralExp()
	 * @generated
	 */
	EReference getInvalidLiteralExp_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getReason()
	 * @see #getInvalidLiteralExp()
	 * @generated
	 */
	EAttribute getInvalidLiteralExp_Reason();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getThrowable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throwable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getThrowable()
	 * @see #getInvalidLiteralExp()
	 * @generated
	 */
	EAttribute getInvalidLiteralExp_Throwable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidType
	 * @generated
	 */
	EClass getInvalidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IterateExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp#getResult()
	 * @see #getIterateExp()
	 * @generated
	 */
	EReference getIterateExp_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Iteration#getOwnedIterators <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration#getOwnedIterators()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedIterator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Iteration#getOwnedAccumulators <em>Owned Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration#getOwnedAccumulators()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedAccumulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LetExp#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp#getIn()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp#getVariable()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LoopExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getBody()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.LoopExp#getIterators <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getIterators()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Iterator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.LoopExp#getReferredIteration <em>Referred Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getReferredIteration()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_ReferredIteration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp
	 * @generated
	 */
	EClass getMessageExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getTarget()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.MessageExp#getArguments <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getArguments()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_Argument();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Called Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_CalledOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sent Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_SentSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SendSignalAction <em>Send Signal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Signal Action</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SendSignalAction
	 * @generated
	 */
	EClass getSendSignalAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.SendSignalAction#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SendSignalAction#getSignal()
	 * @see #getSendSignalAction()
	 * @generated
	 */
	EReference getSendSignalAction_Signal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredSignal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NullLiteralExp
	 * @generated
	 */
	EClass getNullLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#getArguments <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#getArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PackageableElement <em>Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packageable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PackageableElement
	 * @generated
	 */
	EClass getPackageableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateExp
	 * @generated
	 */
	EClass getStateExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.StateExp#getReferredState <em>Referred State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateExp#getReferredState()
	 * @see #getStateExp()
	 * @generated
	 */
	EReference getStateExp_ReferredState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterType
	 * @generated
	 */
	EClass getTemplateParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TemplateParameterType#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterType#getSpecification()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EAttribute getTemplateParameterType_Specification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralExp
	 * @generated
	 */
	EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TupleLiteralExp#getParts <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralExp#getParts()
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	EReference getTupleLiteralExp_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralPart
	 * @generated
	 */
	EClass getTupleLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TupleLiteralPart#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralPart#getInitExpression()
	 * @see #getTupleLiteralPart()
	 * @generated
	 */
	EReference getTupleLiteralPart_InitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExp
	 * @generated
	 */
	EClass getTypeExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TypeExp#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExp#getReferredType()
	 * @see #getTypeExp()
	 * @generated
	 */
	EReference getTypeExp_ReferredType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unlimited Natural Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol()
	 * @see #getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	EAttribute getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType <em>Unspecified Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType
	 * @generated
	 */
	EClass getUnspecifiedType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType#getLowerBound()
	 * @see #getUnspecifiedType()
	 * @generated
	 */
	EReference getUnspecifiedType_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType#getUpperBound()
	 * @see #getUnspecifiedType()
	 * @generated
	 */
	EReference getUnspecifiedType_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedValueExp
	 * @generated
	 */
	EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.VariableExp#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp#isImplicit()
	 * @see #getVariableExp()
	 * @generated
	 */
	EAttribute getVariableExp_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pivotable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.util.Pivotable"
	 * @generated
	 */
	EClass getPivotable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Visitable
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.util.Visitable"
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#isAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Class#getOwnedAttributes <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attribute</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getOwnedAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedAttribute();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Class#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Class#getSuperClasses <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getSuperClasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SuperClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Interface</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#isInterface()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsInterface();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Class#getSubClasses <em>Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getSubClasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SubClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getPackage()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Type#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getInstanceClassName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_InstanceClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateableElement <em>Templateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement
	 * @generated
	 */
	EClass getTemplateableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getTemplateBindings <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getTemplateBindings()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_TemplateBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_OwnedTemplateSignature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#parameterableElements() <em>Parameterable Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parameterable Elements</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#parameterableElements()
	 * @generated
	 */
	EOperation getTemplateableElement__ParameterableElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#isTemplate() <em>Is Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Template</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#isTemplate()
	 * @generated
	 */
	EOperation getTemplateableElement__IsTemplate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MonikeredElement <em>Monikered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monikered Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MonikeredElement
	 * @generated
	 */
	EClass getMonikeredElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.MonikeredElement#getMoniker <em>Moniker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Moniker</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MonikeredElement#getMoniker()
	 * @see #getMonikeredElement()
	 * @generated
	 */
	EAttribute getMonikeredElement_Moniker();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MonikeredElement#hasMoniker() <em>Has Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Moniker</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MonikeredElement#hasMoniker()
	 * @generated
	 */
	EOperation getMonikeredElement__HasMoniker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding
	 * @generated
	 */
	EClass getTemplateBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getSignature()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getParameterSubstitutions <em>Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getParameterSubstitutions()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_ParameterSubstitution();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement <em>Bound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bound Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_BoundElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#validateParameterSubstitutionFormal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parameter Substitution Formal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parameter Substitution Formal</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#validateParameterSubstitutionFormal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateBinding__ValidateParameterSubstitutionFormal__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#validateOneParameterSubstitution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Parameter Substitution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Parameter Substitution</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#validateOneParameterSubstitution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateBinding__ValidateOneParameterSubstitution__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature
	 * @generated
	 */
	EClass getTemplateSignature();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getParameters <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getParameters()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedParameters <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedParameters()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_OwnedParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Template</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_Template();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#validateOwnElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Own Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Own Elements</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#validateOwnElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateSignature__ValidateOwnElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter
	 * @generated
	 */
	EClass getTemplateParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_Signature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement <em>Parametered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parametered Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_ParameteredElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement <em>Owned Parametered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Parametered Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_OwnedParameteredElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getDefault()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_Default();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedDefault <em>Owned Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedDefault()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_OwnedDefault();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#validateMustBeCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Must Be Compatible</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Must Be Compatible</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#validateMustBeCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateParameter__ValidateMustBeCompatible__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement
	 * @generated
	 */
	EClass getParameterableElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter <em>Owning Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_OwningTemplateParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_TemplateParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#isTemplateParameter() <em>Is Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Template Parameter</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#isTemplateParameter()
	 * @generated
	 */
	EOperation getParameterableElement__IsTemplateParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution <em>Template Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution
	 * @generated
	 */
	EClass getTemplateParameterSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getFormal()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Formal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getActual()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Actual();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getOwnedActual <em>Owned Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Actual</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getOwnedActual()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_OwnedActual();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getTemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getTemplateBinding()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_TemplateBinding();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#validateMustBeCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Must Be Compatible</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Must Be Compatible</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#validateMustBeCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateParameterSubstitution__ValidateMustBeCompatible__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackages <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestedPackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_NestedPackage();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Nesting Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestingPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_NestingPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNsPrefix()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNsURI()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedPrecedences <em>Owned Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedPrecedences()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedPrecedence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedTypes <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedTypes()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Precedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence
	 * @generated
	 */
	EClass getPrecedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Precedence#getAssociativity <em>Associativity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Associativity</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence#getAssociativity()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Associativity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Precedence#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence#getOrder()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Order();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter <em>Type Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter
	 * @generated
	 */
	EClass getTypeTemplateParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#isAllowSubstitutable <em>Allow Substitutable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Substitutable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter#isAllowSubstitutable()
	 * @see #getTypeTemplateParameter()
	 * @generated
	 */
	EAttribute getTypeTemplateParameter_AllowSubstitutable();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#getConstrainingTypes <em>Constraining Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraining Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter#getConstrainingTypes()
	 * @see #getTypeTemplateParameter()
	 * @generated
	 */
	EReference getTypeTemplateParameter_ConstrainingType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#validateHasConstrainingType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has Constraining Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Has Constraining Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter#validateHasConstrainingType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTypeTemplateParameter__ValidateHasConstrainingType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Read Only</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isReadOnly()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getDefault()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isComposite()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isDerived()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDerived();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getOpposite()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Opposite();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getAssociation()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Association();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isImplicit()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Implicit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is ID</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isID()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsID();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Property#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getKeys()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Keys();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Resolve Proxies</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isResolveProxies()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsResolveProxies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isTransient()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unsettable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isUnsettable()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsUnsettable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Volatile</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isVolatile()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsVolatile();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Property#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getClass_()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Class();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Property#validateBindingToAttribute(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Binding To Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Binding To Attribute</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Property#validateBindingToAttribute(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getProperty__ValidateBindingToAttribute__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement <em>Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement
	 * @generated
	 */
	EClass getMultiplicityElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#isOrdered()
	 * @see #getMultiplicityElement()
	 * @generated
	 */
	EAttribute getMultiplicityElement_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#isUnique()
	 * @see #getMultiplicityElement()
	 * @generated
	 */
	EAttribute getMultiplicityElement_IsUnique();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#getLower()
	 * @see #getMultiplicityElement()
	 * @generated
	 */
	EAttribute getMultiplicityElement_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#getUpper()
	 * @see #getMultiplicityElement()
	 * @generated
	 */
	EAttribute getMultiplicityElement_Upper();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Ge0</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Lower Ge0</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMultiplicityElement__ValidateLowerGe0__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Ge Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Upper Ge Lower</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMultiplicityElement__ValidateUpperGeLower__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#lowerBound() <em>Lower Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lower Bound</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#lowerBound()
	 * @generated
	 */
	EOperation getMultiplicityElement__LowerBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#upperBound() <em>Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Upper Bound</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#upperBound()
	 * @generated
	 */
	EOperation getMultiplicityElement__UpperBound();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isMultivalued() <em>Is Multivalued</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Multivalued</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#isMultivalued()
	 * @generated
	 */
	EOperation getMultiplicityElement__IsMultivalued();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#includesCardinality(java.math.BigInteger) <em>Includes Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Includes Cardinality</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#includesCardinality(java.math.BigInteger)
	 * @generated
	 */
	EOperation getMultiplicityElement__IncludesCardinality__BigInteger();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#includesMultiplicity(org.eclipse.ocl.examples.pivot.MultiplicityElement) <em>Includes Multiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Includes Multiplicity</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MultiplicityElement#includesMultiplicity(org.eclipse.ocl.examples.pivot.MultiplicityElement)
	 * @generated
	 */
	EOperation getMultiplicityElement__IncludesMultiplicity__MultiplicityElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement <em>Typed Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Multiplicity Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedMultiplicityElement
	 * @generated
	 */
	EClass getTypedMultiplicityElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass
	 * @generated
	 */
	EClass getAssociationClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unowned Attribute</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttributes()
	 * @see #getAssociationClass()
	 * @generated
	 */
	EReference getAssociationClass_UnownedAttribute();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation <em>Callable Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Callable Implementation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation"
	 * @generated
	 */
	EDataType getCallableImplementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getRaisedExceptions <em>Raised Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raised Exception</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getRaisedExceptions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_RaisedException();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getOwnedParameters <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwnedParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getPrecedence()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Precedence();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Operation#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getClass_()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Class();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Operation#validateTestConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Test Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Test Constraint</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Operation#validateTestConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateTestConstraint__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Parameter#getOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OperationTemplateParameter <em>Operation Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationTemplateParameter
	 * @generated
	 */
	EClass getOperationTemplateParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Comment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment#getBody()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Body();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Comment#getAnnotatedElements <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotated Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment#getAnnotatedElements()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_AnnotatedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Constraint#getConstrainedElements <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constrained Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getConstrainedElements()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_ConstrainedElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getSpecification()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Specification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Constraint#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getStereotype()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Stereotype();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Constraint#validateNotApplyToSelf(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Not Apply To Self</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Not Apply To Self</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#validateNotApplyToSelf(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateNotApplyToSelf__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Constraint#validateValueSpecificationBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Value Specification Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Value Specification Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#validateValueSpecificationBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateValueSpecificationBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isComputable() <em>Is Computable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Computable</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#isComputable()
	 * @generated
	 */
	EOperation getValueSpecification__IsComputable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#integerValue() <em>Integer Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Integer Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#integerValue()
	 * @generated
	 */
	EOperation getValueSpecification__IntegerValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#booleanValue() <em>Boolean Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Boolean Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#booleanValue()
	 * @generated
	 */
	EOperation getValueSpecification__BooleanValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#stringValue()
	 * @generated
	 */
	EOperation getValueSpecification__StringValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#unlimitedValue() <em>Unlimited Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unlimited Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#unlimitedValue()
	 * @generated
	 */
	EOperation getValueSpecification__UnlimitedValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Null</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#isNull()
	 * @generated
	 */
	EOperation getValueSpecification__IsNull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Nameable
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.util.Nameable"
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Detail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Detail
	 * @generated
	 */
	EClass getDetail();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.Detail#getValues <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Detail#getValues()
	 * @see #getDetail()
	 * @generated
	 */
	EAttribute getDetail_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClassCallExp
	 * @generated
	 */
	EClass getAssociationClassCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClassCallExp#getReferredAssociationClass()
	 * @see #getAssociationClassCallExp()
	 * @generated
	 */
	EReference getAssociationClassCallExp_ReferredAssociationClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp
	 * @generated
	 */
	EClass getNavigationCallExp();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getQualifiers <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp#getQualifiers()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_Qualifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Navigation Source</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_NavigationSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.FeatureCallExp
	 * @generated
	 */
	EClass getFeatureCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.FeatureCallExp#isPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.eclipse.ocl.examples.pivot.FeatureCallExp#isPre()
	 * @see #getFeatureCallExp()
	 * @generated
	 */
	EAttribute getFeatureCallExp_IsPre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp#getSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CallExp#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp#isImplicit()
	 * @see #getCallExp()
	 * @generated
	 */
	EAttribute getCallExp_Implicit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CallExp#getReferredFeature <em>Referred Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Feature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp#getReferredFeature()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_ReferredFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Visitor
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.util.Visitor" typeParameters="R C"
	 * @generated
	 */
	EClass getVisitor();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Associativity Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @generated
	 */
	EEnum getAssociativityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the meta object for data type '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @model instanceClass="boolean"
	 * @generated
	 */
	EDataType getBoolean();

	/**
	 * Returns the meta object for data type '<em>Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getInt();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.math.BigInteger
	 * @model instanceClass="java.math.BigInteger"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 * @generated
	 */
	EDataType getReal();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unlimited Natural</em>'.
	 * @see java.math.BigInteger
	 * @model instanceClass="java.math.BigInteger"
	 * @generated
	 */
	EDataType getUnlimitedNatural();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PivotFactory getPivotFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Owned Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_CONTENT = eINSTANCE.getAnnotation_OwnedContent();

		/**
		 * The meta object literal for the '<em><b>Owned Detail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_DETAIL = eINSTANCE.getAnnotation_OwnedDetail();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__REFERENCE = eINSTANCE.getAnnotation_Reference();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__OWNED_RULE = eINSTANCE.getNamedElement_OwnedRule();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__IS_STATIC = eINSTANCE.getNamedElement_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Owned Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__OWNED_ANNOTATION = eINSTANCE.getNamedElement_OwnedAnnotation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Owned Comment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_COMMENT = eINSTANCE.getElement_OwnedComment();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OclExpressionImpl <em>Ocl Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OclExpressionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOclExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Is Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__IS_SERIALIZABLE = eINSTANCE.getDataType_IsSerializable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveLiteralExp()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallOperationAction()
		 * @generated
		 */
		EClass CALL_OPERATION_ACTION = eINSTANCE.getCallOperationAction();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_OPERATION_ACTION__OPERATION = eINSTANCE.getCallOperationAction_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl <em>Collection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITEM__ITEM = eINSTANCE.getCollectionItem_Item();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__PART = eINSTANCE.getCollectionLiteralExp_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__FIRST = eINSTANCE.getCollectionRange_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__LAST = eINSTANCE.getCollectionRange_Last();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl <em>Complete Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteEnvironment()
		 * @generated
		 */
		EClass COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Get Complete Iteration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_ENVIRONMENT___GET_COMPLETE_ITERATION__ITERATION = eINSTANCE.getCompleteEnvironment__GetCompleteIteration__Iteration();

		/**
		 * The meta object literal for the '<em><b>Get Complete Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_ENVIRONMENT___GET_COMPLETE_OPERATION__OPERATION = eINSTANCE.getCompleteEnvironment__GetCompleteOperation__Operation();

		/**
		 * The meta object literal for the '<em><b>Get Complete Package</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_ENVIRONMENT___GET_COMPLETE_PACKAGE__PACKAGE = eINSTANCE.getCompleteEnvironment__GetCompletePackage__Package();

		/**
		 * The meta object literal for the '<em><b>Get Complete Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_ENVIRONMENT___GET_COMPLETE_PROPERTY__PROPERTY = eINSTANCE.getCompleteEnvironment__GetCompleteProperty__Property();

		/**
		 * The meta object literal for the '<em><b>Get Complete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_ENVIRONMENT___GET_COMPLETE_TYPE__TYPE = eINSTANCE.getCompleteEnvironment__GetCompleteType__Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl <em>Complete Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteIteration()
		 * @generated
		 */
		EClass COMPLETE_ITERATION = eINSTANCE.getCompleteIteration();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ITERATION__MODEL = eINSTANCE.getCompleteIteration_Model();

		/**
		 * The meta object literal for the '<em><b>Complete Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ITERATION__COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteIteration_CompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Complete Iterator</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ITERATION__COMPLETE_ITERATOR = eINSTANCE.getCompleteIteration_CompleteIterator();

		/**
		 * The meta object literal for the '<em><b>Complete Accumulator</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ITERATION__COMPLETE_ACCUMULATOR = eINSTANCE.getCompleteIteration_CompleteAccumulator();

		/**
		 * The meta object literal for the '<em><b>Complete Parameter</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ITERATION__COMPLETE_PARAMETER = eINSTANCE.getCompleteIteration_CompleteParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteOperationImpl <em>Complete Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteOperationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteOperation()
		 * @generated
		 */
		EClass COMPLETE_OPERATION = eINSTANCE.getCompleteOperation();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OPERATION__MODEL = eINSTANCE.getCompleteOperation_Model();

		/**
		 * The meta object literal for the '<em><b>Complete Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OPERATION__COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteOperation_CompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Complete Parameter</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OPERATION__COMPLETE_PARAMETER = eINSTANCE.getCompleteOperation_CompleteParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl <em>Complete Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompletePackage()
		 * @generated
		 */
		EClass COMPLETE_PACKAGE = eINSTANCE.getCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__MODEL = eINSTANCE.getCompletePackage_Model();

		/**
		 * The meta object literal for the '<em><b>Complete Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT = eINSTANCE.getCompletePackage_CompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Complete Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__COMPLETE_TYPE = eINSTANCE.getCompletePackage_CompleteType();

		/**
		 * The meta object literal for the '<em><b>Complete Package</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__COMPLETE_PACKAGE = eINSTANCE.getCompletePackage_CompletePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl <em>Complete Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteProperty()
		 * @generated
		 */
		EClass COMPLETE_PROPERTY = eINSTANCE.getCompleteProperty();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PROPERTY__MODEL = eINSTANCE.getCompleteProperty_Model();

		/**
		 * The meta object literal for the '<em><b>Complete Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteProperty_CompleteEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl <em>Complete Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCompleteType()
		 * @generated
		 */
		EClass COMPLETE_TYPE = eINSTANCE.getCompleteType();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TYPE__MODEL = eINSTANCE.getCompleteType_Model();

		/**
		 * The meta object literal for the '<em><b>Complete Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TYPE__COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteType_CompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Complete Operation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TYPE__COMPLETE_OPERATION = eINSTANCE.getCompleteType_CompleteOperation();

		/**
		 * The meta object literal for the '<em><b>Complete Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TYPE__COMPLETE_PROPERTY = eINSTANCE.getCompleteType_CompleteProperty();

		/**
		 * The meta object literal for the '<em><b>Complete Super Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TYPE__COMPLETE_SUPER_TYPE = eINSTANCE.getCompleteType_CompleteSuperType();

		/**
		 * The meta object literal for the '<em><b>Conforms To</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_TYPE___CONFORMS_TO__COMPLETETYPE = eINSTANCE.getCompleteType__ConformsTo__CompleteType();

		/**
		 * The meta object literal for the '<em><b>Get Dynamic Iteration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_TYPE___GET_DYNAMIC_ITERATION__COMPLETEITERATION = eINSTANCE.getCompleteType__GetDynamicIteration__CompleteIteration();

		/**
		 * The meta object literal for the '<em><b>Get Dynamic Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_TYPE___GET_DYNAMIC_OPERATION__COMPLETEOPERATION = eINSTANCE.getCompleteType__GetDynamicOperation__CompleteOperation();

		/**
		 * The meta object literal for the '<em><b>Get Complete Iterations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_TYPE___GET_COMPLETE_ITERATIONS__STRING = eINSTANCE.getCompleteType__GetCompleteIterations__String();

		/**
		 * The meta object literal for the '<em><b>Get Complete Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_TYPE___GET_COMPLETE_OPERATIONS__STRING = eINSTANCE.getCompleteType__GetCompleteOperations__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Referred Enum Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = eINSTANCE.getEnumLiteralExp_ReferredEnumLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__ENUMERATION = eINSTANCE.getEnumerationLiteral_Enumeration();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__VALUE = eINSTANCE.getEnumerationLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__OWNED_LITERAL = eINSTANCE.getEnumeration_OwnedLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl <em>Expression In Ocl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getExpressionInOcl()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOcl();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__BODY_EXPRESSION = eINSTANCE.getExpressionInOcl_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Context Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__CONTEXT_VARIABLE = eINSTANCE.getExpressionInOcl_ContextVariable();

		/**
		 * The meta object literal for the '<em><b>Result Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__RESULT_VARIABLE = eINSTANCE.getExpressionInOcl_ResultVariable();

		/**
		 * The meta object literal for the '<em><b>Parameter Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__PARAMETER_VARIABLE = eINSTANCE.getExpressionInOcl_ParameterVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION_CLASS = eINSTANCE.getFeature_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION = eINSTANCE.getFeature_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl <em>Opaque Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOpaqueExpression()
		 * @generated
		 */
		EClass OPAQUE_EXPRESSION = eINSTANCE.getOpaqueExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_EXPRESSION__BODY = eINSTANCE.getOpaqueExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_EXPRESSION__LANGUAGE = eINSTANCE.getOpaqueExpression_Language();

		/**
		 * The meta object literal for the '<em><b>Validate Language Body Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPAQUE_EXPRESSION___VALIDATE_LANGUAGE_BODY_SIZE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOpaqueExpression__ValidateLanguageBodySize__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INIT_EXPRESSION = eINSTANCE.getVariable_InitExpression();

		/**
		 * The meta object literal for the '<em><b>Represented Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__REPRESENTED_PARAMETER = eINSTANCE.getVariable_RepresentedParameter();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__IMPLICIT = eINSTANCE.getVariable_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl <em>If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIfExp()
		 * @generated
		 */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__CONDITION = eINSTANCE.getIfExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__THEN_EXPRESSION = eINSTANCE.getIfExp_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__ELSE_EXPRESSION = eINSTANCE.getIfExp_ElseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidLiteralExp()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVALID_LITERAL_EXP__OBJECT = eINSTANCE.getInvalidLiteralExp_Object();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVALID_LITERAL_EXP__EXPRESSION = eINSTANCE.getInvalidLiteralExp_Expression();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVALID_LITERAL_EXP__REASON = eINSTANCE.getInvalidLiteralExp_Reason();

		/**
		 * The meta object literal for the '<em><b>Throwable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVALID_LITERAL_EXP__THROWABLE = eINSTANCE.getInvalidLiteralExp_Throwable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidType()
		 * @generated
		 */
		EClass INVALID_TYPE = eINSTANCE.getInvalidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_EXP__RESULT = eINSTANCE.getIterateExp_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ITERATOR = eINSTANCE.getIteration_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ACCUMULATOR = eINSTANCE.getIteration_OwnedAccumulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__IN = eINSTANCE.getLetExp_In();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__VARIABLE = eINSTANCE.getLetExp_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl <em>Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__BODY = eINSTANCE.getLoopExp_Body();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__ITERATOR = eINSTANCE.getLoopExp_Iterator();

		/**
		 * The meta object literal for the '<em><b>Referred Iteration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__REFERRED_ITERATION = eINSTANCE.getLoopExp_ReferredIteration();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl <em>Message Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageExp()
		 * @generated
		 */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__TARGET = eINSTANCE.getMessageExp_Target();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__ARGUMENT = eINSTANCE.getMessageExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Called Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__CALLED_OPERATION = eINSTANCE.getMessageExp_CalledOperation();

		/**
		 * The meta object literal for the '<em><b>Sent Signal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__SENT_SIGNAL = eINSTANCE.getMessageExp_SentSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSendSignalAction()
		 * @generated
		 */
		EClass SEND_SIGNAL_ACTION = eINSTANCE.getSendSignalAction();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_SIGNAL_ACTION__SIGNAL = eINSTANCE.getSendSignalAction_Signal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl <em>Message Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageType()
		 * @generated
		 */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
		 * The meta object literal for the '<em><b>Referred Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_SIGNAL = eINSTANCE.getMessageType_ReferredSignal();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_OPERATION = eINSTANCE.getMessageType_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNullLiteralExp()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__ARGUMENT = eINSTANCE.getOperationCallExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackageableElement()
		 * @generated
		 */
		EClass PACKAGEABLE_ELEMENT = eINSTANCE.getPackageableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl <em>State Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateExp()
		 * @generated
		 */
		EClass STATE_EXP = eINSTANCE.getStateExp();

		/**
		 * The meta object literal for the '<em><b>Referred State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_EXP__REFERRED_STATE = eINSTANCE.getStateExp_ReferredState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterType()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_TYPE = eINSTANCE.getTemplateParameterType();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PARAMETER_TYPE__SPECIFICATION = eINSTANCE.getTemplateParameterType_Specification();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralExp()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP__PART = eINSTANCE.getTupleLiteralExp_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralPart()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_PART__INIT_EXPRESSION = eINSTANCE.getTupleLiteralPart_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl <em>Type Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExp()
		 * @generated
		 */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_EXP__REFERRED_TYPE = eINSTANCE.getTypeExp_ReferredType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNaturalLiteralExp()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Unlimited Natural Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL = eINSTANCE.getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl <em>Unspecified Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedType()
		 * @generated
		 */
		EClass UNSPECIFIED_TYPE = eINSTANCE.getUnspecifiedType();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSPECIFIED_TYPE__LOWER_BOUND = eINSTANCE.getUnspecifiedType_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSPECIFIED_TYPE__UPPER_BOUND = eINSTANCE.getUnspecifiedType_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedValueExp()
		 * @generated
		 */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXP__IMPLICIT = eINSTANCE.getVariableExp_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPivotable()
		 * @generated
		 */
		EClass PIVOTABLE = eINSTANCE.getPivotable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Visitable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Owned Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_ATTRIBUTE = eINSTANCE.getClass_OwnedAttribute();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_OPERATION = eINSTANCE.getClass_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER_CLASS = eINSTANCE.getClass_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Is Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_INTERFACE = eINSTANCE.getClass_IsInterface();

		/**
		 * The meta object literal for the '<em><b>Sub Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUB_CLASS = eINSTANCE.getClass_SubClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__PACKAGE = eINSTANCE.getType_Package();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__INSTANCE_CLASS_NAME = eINSTANCE.getType_InstanceClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl <em>Templateable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateableElement()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT = eINSTANCE.getTemplateableElement();

		/**
		 * The meta object literal for the '<em><b>Template Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING = eINSTANCE.getTemplateableElement_TemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Template Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateableElement_OwnedTemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Parameterable Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATEABLE_ELEMENT___PARAMETERABLE_ELEMENTS = eINSTANCE.getTemplateableElement__ParameterableElements();

		/**
		 * The meta object literal for the '<em><b>Is Template</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATEABLE_ELEMENT___IS_TEMPLATE = eINSTANCE.getTemplateableElement__IsTemplate();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl <em>Monikered Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMonikeredElement()
		 * @generated
		 */
		EClass MONIKERED_ELEMENT = eINSTANCE.getMonikeredElement();

		/**
		 * The meta object literal for the '<em><b>Moniker</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONIKERED_ELEMENT__MONIKER = eINSTANCE.getMonikeredElement_Moniker();

		/**
		 * The meta object literal for the '<em><b>Has Moniker</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MONIKERED_ELEMENT___HAS_MONIKER = eINSTANCE.getMonikeredElement__HasMoniker();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateBinding()
		 * @generated
		 */
		EClass TEMPLATE_BINDING = eINSTANCE.getTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__SIGNATURE = eINSTANCE.getTemplateBinding_Signature();

		/**
		 * The meta object literal for the '<em><b>Parameter Substitution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateBinding_ParameterSubstitution();

		/**
		 * The meta object literal for the '<em><b>Bound Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__BOUND_ELEMENT = eINSTANCE.getTemplateBinding_BoundElement();

		/**
		 * The meta object literal for the '<em><b>Validate Parameter Substitution Formal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_BINDING___VALIDATE_PARAMETER_SUBSTITUTION_FORMAL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateBinding__ValidateParameterSubstitutionFormal__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Parameter Substitution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_BINDING___VALIDATE_ONE_PARAMETER_SUBSTITUTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateBinding__ValidateOneParameterSubstitution__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl <em>Template Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateSignature()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE = eINSTANCE.getTemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__PARAMETER = eINSTANCE.getTemplateSignature_Parameter();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__OWNED_PARAMETER = eINSTANCE.getTemplateSignature_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__TEMPLATE = eINSTANCE.getTemplateSignature_Template();

		/**
		 * The meta object literal for the '<em><b>Validate Own Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_SIGNATURE___VALIDATE_OWN_ELEMENTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateSignature__ValidateOwnElements__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameter()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER = eINSTANCE.getTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__SIGNATURE = eINSTANCE.getTemplateParameter_Signature();

		/**
		 * The meta object literal for the '<em><b>Parametered Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = eINSTANCE.getTemplateParameter_ParameteredElement();

		/**
		 * The meta object literal for the '<em><b>Owned Parametered Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = eINSTANCE.getTemplateParameter_OwnedParameteredElement();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__DEFAULT = eINSTANCE.getTemplateParameter_Default();

		/**
		 * The meta object literal for the '<em><b>Owned Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__OWNED_DEFAULT = eINSTANCE.getTemplateParameter_OwnedDefault();

		/**
		 * The meta object literal for the '<em><b>Validate Must Be Compatible</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateParameter__ValidateMustBeCompatible__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameterableElement()
		 * @generated
		 */
		EClass PARAMETERABLE_ELEMENT = eINSTANCE.getParameterableElement();

		/**
		 * The meta object literal for the '<em><b>Owning Template Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement_OwningTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Template Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement_TemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Is Template Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement__IsTemplateParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl <em>Template Parameter Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterSubstitution()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateParameterSubstitution();

		/**
		 * The meta object literal for the '<em><b>Formal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL = eINSTANCE.getTemplateParameterSubstitution_Formal();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL = eINSTANCE.getTemplateParameterSubstitution_Actual();

		/**
		 * The meta object literal for the '<em><b>Owned Actual</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL = eINSTANCE.getTemplateParameterSubstitution_OwnedActual();

		/**
		 * The meta object literal for the '<em><b>Template Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING = eINSTANCE.getTemplateParameterSubstitution_TemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Validate Must Be Compatible</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_PARAMETER_SUBSTITUTION___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateParameterSubstitution__ValidateMustBeCompatible__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__NESTED_PACKAGE = eINSTANCE.getPackage_NestedPackage();

		/**
		 * The meta object literal for the '<em><b>Nesting Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__NESTING_PACKAGE = eINSTANCE.getPackage_NestingPackage();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_PREFIX = eINSTANCE.getPackage_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_URI = eINSTANCE.getPackage_NsURI();

		/**
		 * The meta object literal for the '<em><b>Owned Precedence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_PRECEDENCE = eINSTANCE.getPackage_OwnedPrecedence();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_TYPE = eINSTANCE.getPackage_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl <em>Precedence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrecedence()
		 * @generated
		 */
		EClass PRECEDENCE = eINSTANCE.getPrecedence();

		/**
		 * The meta object literal for the '<em><b>Associativity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ASSOCIATIVITY = eINSTANCE.getPrecedence_Associativity();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ORDER = eINSTANCE.getPrecedence_Order();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl <em>Type Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeTemplateParameter()
		 * @generated
		 */
		EClass TYPE_TEMPLATE_PARAMETER = eINSTANCE.getTypeTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Allow Substitutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE = eINSTANCE.getTypeTemplateParameter_AllowSubstitutable();

		/**
		 * The meta object literal for the '<em><b>Constraining Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE = eINSTANCE.getTypeTemplateParameter_ConstrainingType();

		/**
		 * The meta object literal for the '<em><b>Validate Has Constraining Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_TEMPLATE_PARAMETER___VALIDATE_HAS_CONSTRAINING_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTypeTemplateParameter__ValidateHasConstrainingType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Is Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_READ_ONLY = eINSTANCE.getProperty_IsReadOnly();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DEFAULT = eINSTANCE.getProperty_Default();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_COMPOSITE = eINSTANCE.getProperty_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DERIVED = eINSTANCE.getProperty_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OPPOSITE = eINSTANCE.getProperty_Opposite();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__ASSOCIATION = eINSTANCE.getProperty_Association();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IMPLICIT = eINSTANCE.getProperty_Implicit();

		/**
		 * The meta object literal for the '<em><b>Is ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_ID = eINSTANCE.getProperty_IsID();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__KEYS = eINSTANCE.getProperty_Keys();

		/**
		 * The meta object literal for the '<em><b>Is Resolve Proxies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_RESOLVE_PROXIES = eINSTANCE.getProperty_IsResolveProxies();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_TRANSIENT = eINSTANCE.getProperty_IsTransient();

		/**
		 * The meta object literal for the '<em><b>Is Unsettable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_UNSETTABLE = eINSTANCE.getProperty_IsUnsettable();

		/**
		 * The meta object literal for the '<em><b>Is Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_VOLATILE = eINSTANCE.getProperty_IsVolatile();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__CLASS = eINSTANCE.getProperty_Class();

		/**
		 * The meta object literal for the '<em><b>Validate Binding To Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___VALIDATE_BINDING_TO_ATTRIBUTE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getProperty__ValidateBindingToAttribute__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MultiplicityElementImpl <em>Multiplicity Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MultiplicityElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMultiplicityElement()
		 * @generated
		 */
		EClass MULTIPLICITY_ELEMENT = eINSTANCE.getMultiplicityElement();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_ELEMENT__IS_ORDERED = eINSTANCE.getMultiplicityElement_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_ELEMENT__IS_UNIQUE = eINSTANCE.getMultiplicityElement_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_ELEMENT__LOWER = eINSTANCE.getMultiplicityElement_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_ELEMENT__UPPER = eINSTANCE.getMultiplicityElement_Upper();

		/**
		 * The meta object literal for the '<em><b>Validate Lower Ge0</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMultiplicityElement__ValidateLowerGe0__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Upper Ge Lower</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMultiplicityElement__ValidateUpperGeLower__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___LOWER_BOUND = eINSTANCE.getMultiplicityElement__LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___UPPER_BOUND = eINSTANCE.getMultiplicityElement__UpperBound();

		/**
		 * The meta object literal for the '<em><b>Is Multivalued</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___IS_MULTIVALUED = eINSTANCE.getMultiplicityElement__IsMultivalued();

		/**
		 * The meta object literal for the '<em><b>Includes Cardinality</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER = eINSTANCE.getMultiplicityElement__IncludesCardinality__BigInteger();

		/**
		 * The meta object literal for the '<em><b>Includes Multiplicity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT = eINSTANCE.getMultiplicityElement__IncludesMultiplicity__MultiplicityElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl <em>Typed Multiplicity Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedMultiplicityElement()
		 * @generated
		 */
		EClass TYPED_MULTIPLICITY_ELEMENT = eINSTANCE.getTypedMultiplicityElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl <em>Association Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClass()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS = eINSTANCE.getAssociationClass();

		/**
		 * The meta object literal for the '<em><b>Unowned Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE = eINSTANCE.getAssociationClass_UnownedAttribute();

		/**
		 * The meta object literal for the '<em>Callable Implementation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallableImplementation()
		 * @generated
		 */
		EDataType CALLABLE_IMPLEMENTATION = eINSTANCE.getCallableImplementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Raised Exception</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__RAISED_EXCEPTION = eINSTANCE.getOperation_RaisedException();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETER = eINSTANCE.getOperation_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PRECEDENCE = eINSTANCE.getOperation_Precedence();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__CLASS = eINSTANCE.getOperation_Class();

		/**
		 * The meta object literal for the '<em><b>Validate Test Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_TEST_CONSTRAINT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateTestConstraint__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OPERATION = eINSTANCE.getParameter_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl <em>Operation Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationTemplateParameter()
		 * @generated
		 */
		EClass OPERATION_TEMPLATE_PARAMETER = eINSTANCE.getOperationTemplateParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__BODY = eINSTANCE.getComment_Body();

		/**
		 * The meta object literal for the '<em><b>Annotated Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__ANNOTATED_ELEMENT = eINSTANCE.getComment_AnnotatedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Constrained Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONSTRAINED_ELEMENT = eINSTANCE.getConstraint_ConstrainedElement();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__SPECIFICATION = eINSTANCE.getConstraint_Specification();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONTEXT = eINSTANCE.getConstraint_Context();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__STEREOTYPE = eINSTANCE.getConstraint_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Validate Not Apply To Self</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_NOT_APPLY_TO_SELF__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateNotApplyToSelf__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Value Specification Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_VALUE_SPECIFICATION_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateValueSpecificationBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getValueSpecification()
		 * @generated
		 */
		EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Is Computable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_COMPUTABLE = eINSTANCE.getValueSpecification__IsComputable();

		/**
		 * The meta object literal for the '<em><b>Integer Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___INTEGER_VALUE = eINSTANCE.getValueSpecification__IntegerValue();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___BOOLEAN_VALUE = eINSTANCE.getValueSpecification__BooleanValue();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___STRING_VALUE = eINSTANCE.getValueSpecification__StringValue();

		/**
		 * The meta object literal for the '<em><b>Unlimited Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___UNLIMITED_VALUE = eINSTANCE.getValueSpecification__UnlimitedValue();

		/**
		 * The meta object literal for the '<em><b>Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_NULL = eINSTANCE.getValueSpecification__IsNull();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Nameable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl <em>Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDetail()
		 * @generated
		 */
		EClass DETAIL = eINSTANCE.getDetail();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL__VALUE = eINSTANCE.getDetail_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClassCallExp()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE.getAssociationClassCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = eINSTANCE.getAssociationClassCallExp_ReferredAssociationClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNavigationCallExp()
		 * @generated
		 */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__QUALIFIER = eINSTANCE.getNavigationCallExp_Qualifier();

		/**
		 * The meta object literal for the '<em><b>Navigation Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = eINSTANCE.getNavigationCallExp_NavigationSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeatureCallExp()
		 * @generated
		 */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CALL_EXP__IS_PRE = eINSTANCE.getFeatureCallExp_IsPre();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__SOURCE = eINSTANCE.getCallExp_Source();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_EXP__IMPLICIT = eINSTANCE.getCallExp_Implicit();

		/**
		 * The meta object literal for the '<em><b>Referred Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__REFERRED_FEATURE = eINSTANCE.getCallExp_ReferredFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Visitor
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitor()
		 * @generated
		 */
		EClass VISITOR = eINSTANCE.getVisitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociativityKind()
		 * @generated
		 */
		EEnum ASSOCIATIVITY_KIND = eINSTANCE.getAssociativityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.CollectionKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em>Int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInt()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getInt();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReal()
		 * @generated
		 */
		EDataType REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em>Unlimited Natural</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNatural()
		 * @generated
		 */
		EDataType UNLIMITED_NATURAL = eINSTANCE.getUnlimitedNatural();

	}

} //PivotPackage
