/**
 * <copyright>
 *
 * Copyright (c) 2009 Eclipse Modeling Project and others.
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
 * $Id: ExpressionInOCLItemProvider.java,v 1.1 2009/10/30 19:05:03 ewillink Exp $
 */
package org.eclipse.ocl.uml.provider;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.expressions.ExpressionsFactory;

import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;

import org.eclipse.ocl.uml.edit.OCLUMLEditPlugin;

import org.eclipse.ocl.utilities.UtilitiesPackage;

import org.eclipse.uml2.uml.edit.providers.OpaqueExpressionItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.uml.ExpressionInOCL} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionInOCLItemProvider extends OpaqueExpressionItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
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
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/ExpressionInOCL")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExpressionInOCL) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ExpressionInOCL_type") : //$NON-NLS-1$
				getString("_UI_ExpressionInOCL_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
		case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
		case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
		case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
		case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
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
				UMLFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				UMLFactory.eINSTANCE.createVariableExp()));

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
				UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE,
						UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE,
						ExpressionsFactory.eINSTANCE.createVariable()));
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

		boolean qualify = childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE
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
		return OCLUMLEditPlugin.INSTANCE;
	}

}
