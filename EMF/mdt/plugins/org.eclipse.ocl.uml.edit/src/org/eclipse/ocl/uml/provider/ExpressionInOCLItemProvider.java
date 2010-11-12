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
 * $Id: ExpressionInOCLItemProvider.java,v 1.4 2010/04/08 06:25:33 ewillink Exp $
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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.types.TypesFactory;
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
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/ExpressionInOCL")); //$NON-NLS-1$
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
		case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE:
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

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createExpressionInOCL()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				UMLFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						EcoreFactory.eINSTANCE
								.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				EcoreFactory.eINSTANCE.createETypeParameter()));

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

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createElementImport()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPackageImport()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateBinding()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateSignature()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTemplateParameterSubstitution()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralization()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralizationSet()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createAbstraction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRealization()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createSubstitution()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOpaqueExpression()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createParameter()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createConnectorEnd()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDeployment()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createArtifact()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDeploymentSpecification()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createManifestation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInterfaceRealization()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInterface()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createReception()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSignal()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createStateMachine()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolStateMachine()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPort()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConnectionPointReference()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolConformance()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createConnector()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExtension()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createExtensionEnd()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createImage()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createProfile()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createModel()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createParameterSet()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDataType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOperationTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConnectableElementTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCollaborationUse()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createCollaboration()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInclude()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExtend()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExtensionPoint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRedefinableTemplateSignature()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClassifierTemplateParameter()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStringExpression()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createUsage()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPackageMerge()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProfileApplication()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInstanceSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createEnumerationLiteral()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSlot()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createPrimitiveType()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralInteger()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createLiteralString()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralBoolean()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLiteralNull()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createInstanceValue()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLiteralUnlimitedNatural()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOpaqueBehavior()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createFunctionBehavior()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createOpaqueAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStructuredActivityNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityPartition()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInterruptibleActivityRegion()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExceptionHandler()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPin()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOutputPin()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInputPin()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendSignalAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCallOperationAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCallBehaviorAction()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createSequenceNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createControlFlow()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInitialNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityParameterNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createValuePin()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInteraction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLifeline()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionUse()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createPartDecomposition()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createGate()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createGeneralOrdering()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionOperand()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInteractionConstraint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStateInvariant()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActionExecutionSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createBehaviorExecutionSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionEvent()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createCreationEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestructionEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendOperationEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createMessageOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionOccurrenceSpecification()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReceiveOperationEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReceiveSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createCallEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createChangeEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createSignalEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAnyReceiveEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createForkNode()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createFlowFinalNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCentralBufferNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createDecisionNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createObjectFlow()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActivityFinalNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createComponentRealization()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCommunicationPath()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDevice()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExecutionEnvironment()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCombinedFragment()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createContinuation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConsiderIgnoreFragment()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestroyObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTestIdentityAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadSelfAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRemoveStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAddStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLinkEndData()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createQualifierValue()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLinkEndCreationData()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateLinkAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDestroyLinkAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createLinkEndDestructionData()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearAssociationAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createBroadcastSignalAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createSendObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createValueSpecificationAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeExpression()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDuration()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInterval()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationInterval()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createIntervalConstraint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeConstraint()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createTimeInterval()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationConstraint()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createTimeObservation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createDurationObservation()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTimeEvent()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadVariableAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createClearVariableAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAddVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRemoveVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createRaiseExceptionAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createActionInputPin()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInformationItem()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createInformationFlow()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadExtentAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReclassifyObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadIsClassifiedObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStartClassifierBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkObjectEndAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createReadLinkObjectEndQualifierAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createCreateLinkObjectAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAcceptEventAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createAcceptCallAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createReplyAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createUnmarshallAction()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createReduceAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createStartObjectBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createJoinNode()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createDataStoreNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createConditionalNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClause()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createLoopNode()));

		newChildDescriptors
				.add(createChildParameter(
						UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
						org.eclipse.uml2.uml.UMLFactory.eINSTANCE
								.createExpansionNode()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createExpansionRegion()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
				org.eclipse.uml2.uml.UMLFactory.eINSTANCE
						.createProtocolTransition()));

		newChildDescriptors.add(createChildParameter(
				UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE,
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
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE
				|| childFeature == org.eclipse.uml2.uml.UMLPackage.Literals.ELEMENT__OWNED_COMMENT
				|| childFeature == org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME_EXPRESSION
				|| childFeature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION
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
		return OCLUMLEditPlugin.INSTANCE;
	}

}
