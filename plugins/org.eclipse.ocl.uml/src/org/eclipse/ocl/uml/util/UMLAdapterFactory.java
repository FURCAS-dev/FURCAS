/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: UMLAdapterFactory.java,v 1.10 2010/05/03 09:32:42 ewillink Exp $
 */
package org.eclipse.ocl.uml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.uml.*;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.Visitable;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.uml.UMLPackage
 * @generated
 */
public class UMLAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UMLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLSwitch<Adapter> modelSwitch = new UMLSwitch<Adapter>() {

		@Override
		public Adapter caseAnyType(AnyType object) {
			return createAnyTypeAdapter();
		}

		@Override
		public Adapter caseVoidType(VoidType object) {
			return createVoidTypeAdapter();
		}

		@Override
		public Adapter caseInvalidType(InvalidType object) {
			return createInvalidTypeAdapter();
		}

		@Override
		public Adapter caseElementType(ElementType object) {
			return createElementTypeAdapter();
		}

		@Override
		public Adapter caseTypeType(TypeType object) {
			return createTypeTypeAdapter();
		}

		@Override
		public Adapter caseMessageType(MessageType object) {
			return createMessageTypeAdapter();
		}

		@Override
		public Adapter casePrimitiveType(PrimitiveType object) {
			return createPrimitiveTypeAdapter();
		}

		@Override
		public Adapter caseCollectionType(CollectionType object) {
			return createCollectionTypeAdapter();
		}

		@Override
		public Adapter caseTupleType(TupleType object) {
			return createTupleTypeAdapter();
		}

		@Override
		public Adapter caseBagType(BagType object) {
			return createBagTypeAdapter();
		}

		@Override
		public Adapter caseSetType(SetType object) {
			return createSetTypeAdapter();
		}

		@Override
		public Adapter caseOrderedSetType(OrderedSetType object) {
			return createOrderedSetTypeAdapter();
		}

		@Override
		public Adapter caseSequenceType(SequenceType object) {
			return createSequenceTypeAdapter();
		}

		@Override
		public Adapter caseExpressionInOCL(ExpressionInOCL object) {
			return createExpressionInOCLAdapter();
		}

		@Override
		public Adapter caseAssociationClassCallExp(
				AssociationClassCallExp object) {
			return createAssociationClassCallExpAdapter();
		}

		@Override
		public Adapter caseNavigationCallExp(NavigationCallExp object) {
			return createNavigationCallExpAdapter();
		}

		@Override
		public Adapter caseFeatureCallExp(FeatureCallExp object) {
			return createFeatureCallExpAdapter();
		}

		@Override
		public Adapter caseCallExp(CallExp object) {
			return createCallExpAdapter();
		}

		@Override
		public Adapter caseOCLExpression(OCLExpression object) {
			return createOCLExpressionAdapter();
		}

		@Override
		public Adapter caseBooleanLiteralExp(BooleanLiteralExp object) {
			return createBooleanLiteralExpAdapter();
		}

		@Override
		public Adapter casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
			return createPrimitiveLiteralExpAdapter();
		}

		@Override
		public Adapter caseLiteralExp(LiteralExp object) {
			return createLiteralExpAdapter();
		}

		@Override
		public Adapter caseCollectionItem(CollectionItem object) {
			return createCollectionItemAdapter();
		}

		@Override
		public Adapter caseCollectionLiteralPart(CollectionLiteralPart object) {
			return createCollectionLiteralPartAdapter();
		}

		@Override
		public Adapter caseCollectionLiteralExp(CollectionLiteralExp object) {
			return createCollectionLiteralExpAdapter();
		}

		@Override
		public Adapter caseCollectionRange(CollectionRange object) {
			return createCollectionRangeAdapter();
		}

		@Override
		public Adapter caseEnumLiteralExp(EnumLiteralExp object) {
			return createEnumLiteralExpAdapter();
		}

		@Override
		public Adapter caseIfExp(IfExp object) {
			return createIfExpAdapter();
		}

		@Override
		public Adapter caseIntegerLiteralExp(IntegerLiteralExp object) {
			return createIntegerLiteralExpAdapter();
		}

		@Override
		public Adapter caseNumericLiteralExp(NumericLiteralExp object) {
			return createNumericLiteralExpAdapter();
		}

		@Override
		public Adapter caseUnlimitedNaturalLiteralExp(
				UnlimitedNaturalLiteralExp object) {
			return createUnlimitedNaturalLiteralExpAdapter();
		}

		@Override
		public Adapter caseInvalidLiteralExp(InvalidLiteralExp object) {
			return createInvalidLiteralExpAdapter();
		}

		@Override
		public Adapter caseIterateExp(IterateExp object) {
			return createIterateExpAdapter();
		}

		@Override
		public Adapter caseLoopExp(LoopExp object) {
			return createLoopExpAdapter();
		}

		@Override
		public Adapter caseIteratorExp(IteratorExp object) {
			return createIteratorExpAdapter();
		}

		@Override
		public Adapter caseLetExp(LetExp object) {
			return createLetExpAdapter();
		}

		@Override
		public Adapter caseMessageExp(MessageExp object) {
			return createMessageExpAdapter();
		}

		@Override
		public Adapter caseNullLiteralExp(NullLiteralExp object) {
			return createNullLiteralExpAdapter();
		}

		@Override
		public Adapter caseOperationCallExp(OperationCallExp object) {
			return createOperationCallExpAdapter();
		}

		@Override
		public Adapter casePropertyCallExp(PropertyCallExp object) {
			return createPropertyCallExpAdapter();
		}

		@Override
		public Adapter caseRealLiteralExp(RealLiteralExp object) {
			return createRealLiteralExpAdapter();
		}

		@Override
		public Adapter caseStateExp(StateExp object) {
			return createStateExpAdapter();
		}

		@Override
		public Adapter caseStringLiteralExp(StringLiteralExp object) {
			return createStringLiteralExpAdapter();
		}

		@Override
		public Adapter caseTupleLiteralExp(TupleLiteralExp object) {
			return createTupleLiteralExpAdapter();
		}

		@Override
		public Adapter caseTupleLiteralPart(TupleLiteralPart object) {
			return createTupleLiteralPartAdapter();
		}

		@Override
		public Adapter caseTypeExp(TypeExp object) {
			return createTypeExpAdapter();
		}

		@Override
		public Adapter caseUnspecifiedValueExp(UnspecifiedValueExp object) {
			return createUnspecifiedValueExpAdapter();
		}

		@Override
		public Adapter caseVariable(Variable object) {
			return createVariableAdapter();
		}

		@Override
		public Adapter caseVariableExp(VariableExp object) {
			return createVariableExpAdapter();
		}

		@Override
		public Adapter caseTemplateParameterType(TemplateParameterType object) {
			return createTemplateParameterTypeAdapter();
		}

		@Override
		public Adapter caseEModelElement(EModelElement object) {
			return createEModelElementAdapter();
		}

		@Override
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseNamespace(Namespace object) {
			return createNamespaceAdapter();
		}

		@Override
		public Adapter caseRedefinableElement(RedefinableElement object) {
			return createRedefinableElementAdapter();
		}

		@Override
		public Adapter caseParameterableElement(ParameterableElement object) {
			return createParameterableElementAdapter();
		}

		@Override
		public Adapter casePackageableElement(PackageableElement object) {
			return createPackageableElementAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter caseTemplateableElement(TemplateableElement object) {
			return createTemplateableElementAdapter();
		}

		@Override
		public Adapter caseClassifier(Classifier object) {
			return createClassifierAdapter();
		}

		@Override
		public <O> Adapter casePredefinedType(PredefinedType<O> object) {
			return createPredefinedTypeAdapter();
		}

		@Override
		public <O> Adapter caseTypes_AnyType(
				org.eclipse.ocl.types.AnyType<O> object) {
			return createTypes_AnyTypeAdapter();
		}

		@Override
		public <O> Adapter caseTypes_VoidType(
				org.eclipse.ocl.types.VoidType<O> object) {
			return createTypes_VoidTypeAdapter();
		}

		@Override
		public <O> Adapter caseTypes_InvalidType(
				org.eclipse.ocl.types.InvalidType<O> object) {
			return createTypes_InvalidTypeAdapter();
		}

		@Override
		public Adapter caseTypes_ElementType(
				org.eclipse.ocl.types.ElementType object) {
			return createTypes_ElementTypeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_TypeType(
				org.eclipse.ocl.types.TypeType<C, O> object) {
			return createTypes_TypeTypeAdapter();
		}

		@Override
		public <C, O, P> Adapter caseTypes_MessageType(
				org.eclipse.ocl.types.MessageType<C, O, P> object) {
			return createTypes_MessageTypeAdapter();
		}

		@Override
		public Adapter caseDataType(DataType object) {
			return createDataTypeAdapter();
		}

		@Override
		public Adapter caseUML_PrimitiveType(
				org.eclipse.uml2.uml.PrimitiveType object) {
			return createUML_PrimitiveTypeAdapter();
		}

		@Override
		public <O> Adapter caseTypes_PrimitiveType(
				org.eclipse.ocl.types.PrimitiveType<O> object) {
			return createTypes_PrimitiveTypeAdapter();
		}

		@Override
		public Adapter caseASTNode(ASTNode object) {
			return createASTNodeAdapter();
		}

		@Override
		public Adapter caseTypedASTNode(TypedASTNode object) {
			return createTypedASTNodeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_CollectionType(
				org.eclipse.ocl.types.CollectionType<C, O> object) {
			return createTypes_CollectionTypeAdapter();
		}

		@Override
		public <O, P> Adapter caseTypes_TupleType(
				org.eclipse.ocl.types.TupleType<O, P> object) {
			return createTypes_TupleTypeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_BagType(
				org.eclipse.ocl.types.BagType<C, O> object) {
			return createTypes_BagTypeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_SetType(
				org.eclipse.ocl.types.SetType<C, O> object) {
			return createTypes_SetTypeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_OrderedSetType(
				org.eclipse.ocl.types.OrderedSetType<C, O> object) {
			return createTypes_OrderedSetTypeAdapter();
		}

		@Override
		public <C, O> Adapter caseTypes_SequenceType(
				org.eclipse.ocl.types.SequenceType<C, O> object) {
			return createTypes_SequenceTypeAdapter();
		}

		@Override
		public Adapter caseTypedElement(TypedElement object) {
			return createTypedElementAdapter();
		}

		@Override
		public Adapter caseValueSpecification(ValueSpecification object) {
			return createValueSpecificationAdapter();
		}

		@Override
		public Adapter caseOpaqueExpression(OpaqueExpression object) {
			return createOpaqueExpressionAdapter();
		}

		@Override
		public Adapter caseVisitable(Visitable object) {
			return createVisitableAdapter();
		}

		@Override
		public <C, PM> Adapter caseUtilities_ExpressionInOCL(
				org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object) {
			return createUtilities_ExpressionInOCLAdapter();
		}

		@Override
		public <C> Adapter caseUtilities_TypedElement(
				org.eclipse.ocl.utilities.TypedElement<C> object) {
			return createUtilities_TypedElementAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_OCLExpression(
				org.eclipse.ocl.expressions.OCLExpression<C> object) {
			return createExpressions_OCLExpressionAdapter();
		}

		@Override
		public Adapter caseCallingASTNode(CallingASTNode object) {
			return createCallingASTNodeAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_CallExp(
				org.eclipse.ocl.expressions.CallExp<C> object) {
			return createExpressions_CallExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_FeatureCallExp(
				org.eclipse.ocl.expressions.FeatureCallExp<C> object) {
			return createExpressions_FeatureCallExpAdapter();
		}

		@Override
		public <C, P> Adapter caseExpressions_NavigationCallExp(
				org.eclipse.ocl.expressions.NavigationCallExp<C, P> object) {
			return createExpressions_NavigationCallExpAdapter();
		}

		@Override
		public <C, P> Adapter caseExpressions_AssociationClassCallExp(
				org.eclipse.ocl.expressions.AssociationClassCallExp<C, P> object) {
			return createExpressions_AssociationClassCallExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_LiteralExp(
				org.eclipse.ocl.expressions.LiteralExp<C> object) {
			return createExpressions_LiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_PrimitiveLiteralExp(
				org.eclipse.ocl.expressions.PrimitiveLiteralExp<C> object) {
			return createExpressions_PrimitiveLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_BooleanLiteralExp(
				org.eclipse.ocl.expressions.BooleanLiteralExp<C> object) {
			return createExpressions_BooleanLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_CollectionLiteralPart(
				org.eclipse.ocl.expressions.CollectionLiteralPart<C> object) {
			return createExpressions_CollectionLiteralPartAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_CollectionItem(
				org.eclipse.ocl.expressions.CollectionItem<C> object) {
			return createExpressions_CollectionItemAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_CollectionLiteralExp(
				org.eclipse.ocl.expressions.CollectionLiteralExp<C> object) {
			return createExpressions_CollectionLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_CollectionRange(
				org.eclipse.ocl.expressions.CollectionRange<C> object) {
			return createExpressions_CollectionRangeAdapter();
		}

		@Override
		public <C, EL> Adapter caseExpressions_EnumLiteralExp(
				org.eclipse.ocl.expressions.EnumLiteralExp<C, EL> object) {
			return createExpressions_EnumLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_IfExp(
				org.eclipse.ocl.expressions.IfExp<C> object) {
			return createExpressions_IfExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_NumericLiteralExp(
				org.eclipse.ocl.expressions.NumericLiteralExp<C> object) {
			return createExpressions_NumericLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_IntegerLiteralExp(
				org.eclipse.ocl.expressions.IntegerLiteralExp<C> object) {
			return createExpressions_IntegerLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_UnlimitedNaturalLiteralExp(
				org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp<C> object) {
			return createExpressions_UnlimitedNaturalLiteralExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_InvalidLiteralExp(
				org.eclipse.ocl.expressions.InvalidLiteralExp<C> object) {
			return createExpressions_InvalidLiteralExpAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_LoopExp(
				org.eclipse.ocl.expressions.LoopExp<C, PM> object) {
			return createExpressions_LoopExpAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_IterateExp(
				org.eclipse.ocl.expressions.IterateExp<C, PM> object) {
			return createExpressions_IterateExpAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_IteratorExp(
				org.eclipse.ocl.expressions.IteratorExp<C, PM> object) {
			return createExpressions_IteratorExpAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_LetExp(
				org.eclipse.ocl.expressions.LetExp<C, PM> object) {
			return createExpressions_LetExpAdapter();
		}

		@Override
		public <C, COA, SSA> Adapter caseExpressions_MessageExp(
				org.eclipse.ocl.expressions.MessageExp<C, COA, SSA> object) {
			return createExpressions_MessageExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_NullLiteralExp(
				org.eclipse.ocl.expressions.NullLiteralExp<C> object) {
			return createExpressions_NullLiteralExpAdapter();
		}

		@Override
		public <C, O> Adapter caseExpressions_OperationCallExp(
				org.eclipse.ocl.expressions.OperationCallExp<C, O> object) {
			return createExpressions_OperationCallExpAdapter();
		}

		@Override
		public <C, P> Adapter caseExpressions_PropertyCallExp(
				org.eclipse.ocl.expressions.PropertyCallExp<C, P> object) {
			return createExpressions_PropertyCallExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_RealLiteralExp(
				org.eclipse.ocl.expressions.RealLiteralExp<C> object) {
			return createExpressions_RealLiteralExpAdapter();
		}

		@Override
		public <C, S> Adapter caseExpressions_StateExp(
				org.eclipse.ocl.expressions.StateExp<C, S> object) {
			return createExpressions_StateExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_StringLiteralExp(
				org.eclipse.ocl.expressions.StringLiteralExp<C> object) {
			return createExpressions_StringLiteralExpAdapter();
		}

		@Override
		public <C, P> Adapter caseExpressions_TupleLiteralExp(
				org.eclipse.ocl.expressions.TupleLiteralExp<C, P> object) {
			return createExpressions_TupleLiteralExpAdapter();
		}

		@Override
		public <C, P> Adapter caseExpressions_TupleLiteralPart(
				org.eclipse.ocl.expressions.TupleLiteralPart<C, P> object) {
			return createExpressions_TupleLiteralPartAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_TypeExp(
				org.eclipse.ocl.expressions.TypeExp<C> object) {
			return createExpressions_TypeExpAdapter();
		}

		@Override
		public <C> Adapter caseExpressions_UnspecifiedValueExp(
				org.eclipse.ocl.expressions.UnspecifiedValueExp<C> object) {
			return createExpressions_UnspecifiedValueExpAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_Variable(
				org.eclipse.ocl.expressions.Variable<C, PM> object) {
			return createExpressions_VariableAdapter();
		}

		@Override
		public <C, PM> Adapter caseExpressions_VariableExp(
				org.eclipse.ocl.expressions.VariableExp<C, PM> object) {
			return createExpressions_VariableExpAdapter();
		}

		@Override
		public <O> Adapter caseTypes_TemplateParameterType(
				org.eclipse.ocl.types.TemplateParameterType<O> object) {
			return createTypes_TemplateParameterTypeAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.AnyType
	 * @generated
	 */
	public Adapter createAnyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.VoidType
	 * @generated
	 */
	public Adapter createVoidTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.InvalidType
	 * @generated
	 */
	public Adapter createInvalidTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.ElementType
	 * @generated
	 */
	public Adapter createElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TypeType
	 * @generated
	 */
	public Adapter createTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.MessageType
	 * @generated
	 */
	public Adapter createMessageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CollectionType
	 * @generated
	 */
	public Adapter createCollectionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TupleType
	 * @generated
	 */
	public Adapter createTupleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.BagType
	 * @generated
	 */
	public Adapter createBagTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.SetType
	 * @generated
	 */
	public Adapter createSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.OrderedSetType
	 * @generated
	 */
	public Adapter createOrderedSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.SequenceType
	 * @generated
	 */
	public Adapter createSequenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.ExpressionInOCL
	 * @generated
	 */
	public Adapter createExpressionInOCLAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.AssociationClassCallExp
	 * @generated
	 */
	public Adapter createAssociationClassCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.NavigationCallExp
	 * @generated
	 */
	public Adapter createNavigationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.FeatureCallExp
	 * @generated
	 */
	public Adapter createFeatureCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CallExp
	 * @generated
	 */
	public Adapter createCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.OCLExpression
	 * @generated
	 */
	public Adapter createOCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.BooleanLiteralExp
	 * @generated
	 */
	public Adapter createBooleanLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.PrimitiveLiteralExp
	 * @generated
	 */
	public Adapter createPrimitiveLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.LiteralExp
	 * @generated
	 */
	public Adapter createLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CollectionItem
	 * @generated
	 */
	public Adapter createCollectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CollectionLiteralPart
	 * @generated
	 */
	public Adapter createCollectionLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CollectionLiteralExp
	 * @generated
	 */
	public Adapter createCollectionLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.CollectionRange
	 * @generated
	 */
	public Adapter createCollectionRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.EnumLiteralExp
	 * @generated
	 */
	public Adapter createEnumLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.IfExp
	 * @generated
	 */
	public Adapter createIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.IntegerLiteralExp
	 * @generated
	 */
	public Adapter createIntegerLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.NumericLiteralExp
	 * @generated
	 */
	public Adapter createNumericLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	public Adapter createUnlimitedNaturalLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.InvalidLiteralExp
	 * @generated
	 */
	public Adapter createInvalidLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.IterateExp
	 * @generated
	 */
	public Adapter createIterateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.LoopExp
	 * @generated
	 */
	public Adapter createLoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.IteratorExp
	 * @generated
	 */
	public Adapter createIteratorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.LetExp
	 * @generated
	 */
	public Adapter createLetExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.MessageExp
	 * @generated
	 */
	public Adapter createMessageExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.NullLiteralExp
	 * @generated
	 */
	public Adapter createNullLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.OperationCallExp
	 * @generated
	 */
	public Adapter createOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.PropertyCallExp
	 * @generated
	 */
	public Adapter createPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.RealLiteralExp
	 * @generated
	 */
	public Adapter createRealLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.StateExp
	 * @generated
	 */
	public Adapter createStateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.StringLiteralExp
	 * @generated
	 */
	public Adapter createStringLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TupleLiteralExp
	 * @generated
	 */
	public Adapter createTupleLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TupleLiteralPart
	 * @generated
	 */
	public Adapter createTupleLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TypeExp
	 * @generated
	 */
	public Adapter createTypeExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.UnspecifiedValueExp
	 * @generated
	 */
	public Adapter createUnspecifiedValueExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.VariableExp
	 * @generated
	 */
	public Adapter createVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.uml.TemplateParameterType
	 * @generated
	 */
	public Adapter createTemplateParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.RedefinableElement <em>Redefinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.RedefinableElement
	 * @generated
	 */
	public Adapter createRedefinableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.ParameterableElement
	 * @generated
	 */
	public Adapter createParameterableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.PackageableElement <em>Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.PackageableElement
	 * @generated
	 */
	public Adapter createPackageableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.TemplateableElement <em>Templateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.TemplateableElement
	 * @generated
	 */
	public Adapter createTemplateableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.PredefinedType <em>Predefined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.PredefinedType
	 * @generated
	 */
	public Adapter createPredefinedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.AnyType
	 * @generated
	 */
	public Adapter createTypes_AnyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.VoidType
	 * @generated
	 */
	public Adapter createTypes_VoidTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.InvalidType
	 * @generated
	 */
	public Adapter createTypes_InvalidTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.ElementType
	 * @generated
	 */
	public Adapter createTypes_ElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.TypeType
	 * @generated
	 */
	public Adapter createTypes_TypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.MessageType
	 * @generated
	 */
	public Adapter createTypes_MessageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.PrimitiveType
	 * @generated
	 */
	public Adapter createUML_PrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.PrimitiveType
	 * @generated
	 */
	public Adapter createTypes_PrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.ASTNode
	 * @generated
	 */
	public Adapter createASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.TypedASTNode
	 * @generated
	 */
	public Adapter createTypedASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.CollectionType
	 * @generated
	 */
	public Adapter createTypes_CollectionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.TupleType
	 * @generated
	 */
	public Adapter createTypes_TupleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.BagType
	 * @generated
	 */
	public Adapter createTypes_BagTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.SetType
	 * @generated
	 */
	public Adapter createTypes_SetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.OrderedSetType
	 * @generated
	 */
	public Adapter createTypes_OrderedSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.SequenceType
	 * @generated
	 */
	public Adapter createTypes_SequenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.ValueSpecification
	 * @generated
	 */
	public Adapter createValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.OpaqueExpression <em>Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.uml2.uml.OpaqueExpression
	 * @generated
	 */
	public Adapter createOpaqueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.ExpressionInOCL
	 * @generated
	 */
	public Adapter createUtilities_ExpressionInOCLAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.TypedElement
	 * @generated
	 */
	public Adapter createUtilities_TypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.OCLExpression
	 * @generated
	 */
	public Adapter createExpressions_OCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.utilities.CallingASTNode
	 * @generated
	 */
	public Adapter createCallingASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.CallExp
	 * @generated
	 */
	public Adapter createExpressions_CallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.FeatureCallExp
	 * @generated
	 */
	public Adapter createExpressions_FeatureCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.NavigationCallExp
	 * @generated
	 */
	public Adapter createExpressions_NavigationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.AssociationClassCallExp
	 * @generated
	 */
	public Adapter createExpressions_AssociationClassCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.LiteralExp
	 * @generated
	 */
	public Adapter createExpressions_LiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.PrimitiveLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_PrimitiveLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.BooleanLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_BooleanLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.CollectionLiteralPart
	 * @generated
	 */
	public Adapter createExpressions_CollectionLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.CollectionItem
	 * @generated
	 */
	public Adapter createExpressions_CollectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.CollectionLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_CollectionLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.CollectionRange
	 * @generated
	 */
	public Adapter createExpressions_CollectionRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.EnumLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_EnumLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.IfExp
	 * @generated
	 */
	public Adapter createExpressions_IfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.NumericLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_NumericLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.IntegerLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_IntegerLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_UnlimitedNaturalLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.InvalidLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_InvalidLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.LoopExp
	 * @generated
	 */
	public Adapter createExpressions_LoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.IterateExp
	 * @generated
	 */
	public Adapter createExpressions_IterateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.IteratorExp
	 * @generated
	 */
	public Adapter createExpressions_IteratorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.LetExp
	 * @generated
	 */
	public Adapter createExpressions_LetExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.MessageExp
	 * @generated
	 */
	public Adapter createExpressions_MessageExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.NullLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_NullLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.OperationCallExp
	 * @generated
	 */
	public Adapter createExpressions_OperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.PropertyCallExp
	 * @generated
	 */
	public Adapter createExpressions_PropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.RealLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_RealLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.StateExp
	 * @generated
	 */
	public Adapter createExpressions_StateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.StringLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_StringLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.TupleLiteralExp
	 * @generated
	 */
	public Adapter createExpressions_TupleLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.TupleLiteralPart
	 * @generated
	 */
	public Adapter createExpressions_TupleLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.TypeExp
	 * @generated
	 */
	public Adapter createExpressions_TypeExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.UnspecifiedValueExp
	 * @generated
	 */
	public Adapter createExpressions_UnspecifiedValueExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.Variable
	 * @generated
	 */
	public Adapter createExpressions_VariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.expressions.VariableExp
	 * @generated
	 */
	public Adapter createExpressions_VariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.types.TemplateParameterType
	 * @generated
	 */
	public Adapter createTypes_TemplateParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_AnyTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createAnyType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_CollectionTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCollectionType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_BagTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createBagType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_ElementTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createElementType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_InvalidTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createInvalidType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_MessageTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createMessageType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_OrderedSetTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createOrderedSetType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_PrimitiveTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createPrimitiveType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_SequenceTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createSequenceType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_SetTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createSetType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_TupleTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createTupleType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_TypeTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createTypeType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createTypes_VoidTypeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createVoidType_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createUtilities_ExpressionInOCLAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createExpressionInOCL_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_OCLExpressionAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createOCLExpression_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_CallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_FeatureCallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createFeatureCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_NavigationCallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createNavigationCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_AssociationClassCallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createAssociationClassCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_LiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_PrimitiveLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createPrimitiveLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_BooleanLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createBooleanLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_CollectionLiteralPartAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCollectionLiteralPart_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_CollectionItemAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCollectionItem_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_CollectionLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCollectionLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_CollectionRangeAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createCollectionRange_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_EnumLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createEnumLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_IfExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createIfExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_NumericLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createNumericLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_IntegerLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createIntegerLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_UnlimitedNaturalLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createUnlimitedNaturalLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_InvalidLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createInvalidLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_LoopExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createLoopExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_IterateExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createIterateExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_IteratorExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createIteratorExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_LetExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createLetExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_MessageExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createMessageExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_NullLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createNullLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_OperationCallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createOperationCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_PropertyCallExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createPropertyCallExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_RealLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createRealLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_StateExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createStateExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_StringLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createStringLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_TupleLiteralExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createTupleLiteralExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_TupleLiteralPartAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createTupleLiteralPart_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_TypeExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createTypeExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_UnspecifiedValueExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createUnspecifiedValueExp_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_VariableAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createVariable_1Adapter() {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #createExpressions_VariableExpAdapter} method, instead.
	 */
	@Deprecated
	public Adapter createVariableExp_1Adapter() {
		return null;
	}

} //UMLAdapterFactory
