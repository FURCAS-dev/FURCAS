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
 * $Id: LetExpItemProvider.java,v 1.3 2010/04/08 06:27:39 ewillink Exp $
 */
package org.eclipse.ocl.expressions.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.LetExp;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.expressions.LetExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LetExpItemProvider extends OCLExpressionItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpItemProvider(AdapterFactory adapterFactory) {
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

			addInPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the In feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LetExp_in_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LetExp_in_feature", "_UI_LetExp_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						ExpressionsPackage.Literals.LET_EXP__IN, true, false,
						false, null, null, null));
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
			childrenFeatures.add(ExpressionsPackage.Literals.LET_EXP__IN);
			childrenFeatures.add(ExpressionsPackage.Literals.LET_EXP__VARIABLE);
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
	 * This returns LetExp.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/LetExp")); //$NON-NLS-1$
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
		LetExp<?, ?> letExp = (LetExp<?, ?>) object;
		return getString("_UI_LetExp_type") + " " + letExp.getStartPosition(); //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(LetExp.class)) {
		case ExpressionsPackage.LET_EXP__IN:
		case ExpressionsPackage.LET_EXP__VARIABLE:
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
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.LET_EXP__IN,
						ExpressionsFactory.eINSTANCE
								.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__IN,
				ExpressionsFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.LET_EXP__VARIABLE,
				ExpressionsFactory.eINSTANCE.createVariable()));
	}

}
