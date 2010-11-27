/**
 * <copyright>
 *
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExpressionInOCLItemProvider.java,v 1.4 2010/04/08 06:27:11 ewillink Exp $
 */
package org.eclipse.ocl.ecore.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ExpressionInOCL;

import org.eclipse.ocl.ecore.edit.OCLEcoreEditPlugin;

import org.eclipse.ocl.expressions.ExpressionsFactory;

import org.eclipse.ocl.types.TypesFactory;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.ecore.ExpressionInOCL} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionInOCLItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionInOCLItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION);
			childrenFeatures
					.add(UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
			childrenFeatures
					.add(UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE);
			childrenFeatures
					.add(UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
			childrenFeatures
					.add(UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ExpressionInOCL.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ExpressionInOCL")); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ExpressionInOCL_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ExpressionInOCL.class)) {
		case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
		case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
		case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
		case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
		case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				EcoreFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
						ExpressionsFactory.eINSTANCE
								.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				ExpressionsFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				EcoreFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				EcoreFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE,
						EcoreFactory.eINSTANCE.createVariable()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE,
						ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createCallOperationAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createSendSignalAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createExpressionInOCL()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.createEAttribute()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
						.createEAnnotation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.createEDataType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
						.createEEnumLiteral()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.createEOperation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.createEParameter()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.createEReference()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
								.create(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
						.createEGenericType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.emf.ecore.EcoreFactory.eINSTANCE
						.createETypeParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				TypesFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						ExpressionsFactory.eINSTANCE
								.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				ExpressionsFactory.eINSTANCE.createVariableExp()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject),
							getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OCLEcoreEditPlugin.INSTANCE;
	}

}
