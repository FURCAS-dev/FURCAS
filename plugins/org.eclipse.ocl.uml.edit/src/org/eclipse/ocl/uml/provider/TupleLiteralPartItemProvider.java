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
 * $Id: TupleLiteralPartItemProvider.java,v 1.4 2010/04/08 06:25:27 ewillink Exp $
 */
package org.eclipse.ocl.uml.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;

import org.eclipse.ocl.types.TypesFactory;

import org.eclipse.ocl.uml.TupleLiteralPart;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;

import org.eclipse.ocl.uml.edit.OCLUMLEditPlugin;

import org.eclipse.ocl.utilities.UtilitiesPackage;

import org.eclipse.uml2.uml.edit.providers.TypedElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.uml.TupleLiteralPart} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TupleLiteralPartItemProvider extends TypedElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralPartItemProvider(AdapterFactory adapterFactory) {
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

			addStartPositionPropertyDescriptor(object);
			addEndPositionPropertyDescriptor(object);
			addTypeStartPositionPropertyDescriptor(object);
			addTypeEndPositionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Start Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ASTNode_startPosition_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_ASTNode_startPosition_feature", "_UI_ASTNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UtilitiesPackage.Literals.AST_NODE__START_POSITION,
						true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the End Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ASTNode_endPosition_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_ASTNode_endPosition_feature", "_UI_ASTNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UtilitiesPackage.Literals.AST_NODE__END_POSITION, true,
						false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type Start Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypeStartPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_TypedASTNode_typeStartPosition_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_TypedASTNode_typeStartPosition_feature", "_UI_TypedASTNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UtilitiesPackage.Literals.TYPED_AST_NODE__TYPE_START_POSITION,
						true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type End Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypeEndPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_TypedASTNode_typeEndPosition_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_TypedASTNode_typeEndPosition_feature", "_UI_TypedASTNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UtilitiesPackage.Literals.TYPED_AST_NODE__TYPE_END_POSITION,
						true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
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
					.add(ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE);
			childrenFeatures
					.add(ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE);
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
	 * This returns TupleLiteralPart.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/TupleLiteralPart")); //$NON-NLS-1$
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
		String label = ((TupleLiteralPart) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_TupleLiteralPart_type") : //$NON-NLS-1$
				getString("_UI_TupleLiteralPart_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(TupleLiteralPart.class)) {
		case UMLPackage.TUPLE_LITERAL_PART__START_POSITION:
		case UMLPackage.TUPLE_LITERAL_PART__END_POSITION:
		case UMLPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION:
		case UMLPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case UMLPackage.TUPLE_LITERAL_PART__VALUE:
		case UMLPackage.TUPLE_LITERAL_PART__ATTRIBUTE:
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
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				UMLFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
						ExpressionsFactory.eINSTANCE
								.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE,
				ExpressionsFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createExpressionInOCL()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				UMLFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						EcoreFactory.eINSTANCE
								.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				EcoreFactory.eINSTANCE.createETypeParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				TypesFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						ExpressionsFactory.eINSTANCE
								.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				ExpressionsFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createElementImport()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPackageImport()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateBinding()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateSignature()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateParameterSubstitution()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralization()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralizationSet()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createAbstraction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRealization()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createSubstitution()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOpaqueExpression()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createParameter()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createConnectorEnd()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDeployment()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createArtifact()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDeploymentSpecification()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createManifestation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInterfaceRealization()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInterface()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createReception()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSignal()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createStateMachine()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolStateMachine()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPort()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConnectionPointReference()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolConformance()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createConnector()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExtension()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createExtensionEnd()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createImage()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createProfile()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createModel()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createParameterSet()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDataType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOperationTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConnectableElementTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCollaborationUse()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createCollaboration()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInclude()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExtend()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExtensionPoint()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRedefinableTemplateSignature()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClassifierTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStringExpression()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createUsage()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPackageMerge()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProfileApplication()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInstanceSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createEnumerationLiteral()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSlot()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralInteger()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createLiteralString()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralBoolean()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLiteralNull()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createInstanceValue()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralUnlimitedNatural()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOpaqueBehavior()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createFunctionBehavior()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createOpaqueAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStructuredActivityNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityPartition()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInterruptibleActivityRegion()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExceptionHandler()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPin()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOutputPin()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInputPin()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendSignalAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCallOperationAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCallBehaviorAction()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createSequenceNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createControlFlow()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInitialNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityParameterNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createValuePin()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInteraction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLifeline()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionUse()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createPartDecomposition()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createGate()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralOrdering()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionOperand()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionConstraint()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStateInvariant()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActionExecutionSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createBehaviorExecutionSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionEvent()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createCreationEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestructionEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendOperationEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createMessageOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReceiveOperationEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReceiveSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createCallEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createChangeEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAnyReceiveEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createForkNode()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createFlowFinalNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCentralBufferNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createDecisionNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createObjectFlow()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityFinalNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createComponentRealization()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCommunicationPath()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDevice()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionEnvironment()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCombinedFragment()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createContinuation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConsiderIgnoreFragment()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestroyObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTestIdentityAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadSelfAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRemoveStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAddStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLinkEndData()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createQualifierValue()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLinkEndCreationData()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateLinkAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestroyLinkAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLinkEndDestructionData()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearAssociationAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createBroadcastSignalAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createValueSpecificationAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeExpression()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDuration()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInterval()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationInterval()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createIntervalConstraint()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeConstraint()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createTimeInterval()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeObservation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationObservation()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTimeEvent()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadVariableAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearVariableAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAddVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRemoveVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRaiseExceptionAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActionInputPin()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInformationItem()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInformationFlow()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadExtentAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReclassifyObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadIsClassifiedObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStartClassifierBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkObjectEndAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkObjectEndQualifierAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateLinkObjectAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAcceptEventAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAcceptCallAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createReplyAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createUnmarshallAction()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createReduceAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStartObjectBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createJoinNode()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createDataStoreNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConditionalNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClause()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLoopNode()));

		newChildDescriptors
				.add(createChildParameter(
						ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createExpansionNode()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExpansionRegion()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolTransition()));

		newChildDescriptors.add(createChildParameter(
				ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAssociationClass()));
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

		boolean qualify = childFeature == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS
				|| childFeature == ExpressionsPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE
				|| childFeature == org.eclipse.uml2.uml.UMLPackage.Literals.ELEMENT__OWNED_COMMENT
				|| childFeature == org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME_EXPRESSION
				|| childFeature == ExpressionsPackage.Literals.TUPLE_LITERAL_PART__VALUE;

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
