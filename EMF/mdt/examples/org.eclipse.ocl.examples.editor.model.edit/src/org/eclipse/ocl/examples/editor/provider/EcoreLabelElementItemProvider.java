/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EcoreLabelElementItemProvider.java,v 1.2 2010/04/08 06:24:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.ocl.examples.editor.EcoreLabelElement;
import org.eclipse.ocl.examples.editor.EditorPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.examples.editor.EcoreLabelElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreLabelElementItemProvider
	extends AbstractLabelElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreLabelElementItemProvider(AdapterFactory adapterFactory) {
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

			addPathPropertyDescriptor(object);
			addEndPropertyDescriptor(object);
			addHideIfBlankPropertyDescriptor(object);
			addPrefixPropertyDescriptor(object);
			addSeparatorPropertyDescriptor(object);
			addSuffixPropertyDescriptor(object);
			addTextProviderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_path_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_path_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__PATH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_end_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_end_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__END,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hide If Blank feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideIfBlankPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_hideIfBlank_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_hideIfBlank_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_prefix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_prefix_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Separator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeparatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_separator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_separator_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__SEPARATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_suffix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_suffix_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__SUFFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Text Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTextProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EcoreLabelElement_textProvider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EcoreLabelElement_textProvider_feature", "_UI_EcoreLabelElement_type"),
				 EditorPackage.Literals.ECORE_LABEL_ELEMENT__TEXT_PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns EcoreLabelElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EcoreLabelElement"));
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

	public String getLocalName(ENamedElement object) {
		String name = object != null ? object.getName() : null;
		return name != null ? name : "<???>";
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		StringBuffer s = new StringBuffer();
		for (EReference ref : ((EcoreLabelElement)object).getPath()) {
			if (s.length() != 0)
				s.append(", ");
			s.append(getLocalName(ref.getEContainingClass()));
			s.append(".");
			s.append(getLocalName(ref));				
		}
		EStructuralFeature end = ((EcoreLabelElement)object).getEnd();
		if (end != null) {
			if (s.length() != 0)
				s.append(", ");
			s.append(getLocalName(end.getEContainingClass()));
			s.append(".");
			s.append(getLocalName(end));				
		}
		return s.toString();
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

		switch (notification.getFeatureID(EcoreLabelElement.class)) {
			case EditorPackage.ECORE_LABEL_ELEMENT__HIDE_IF_BLANK:
			case EditorPackage.ECORE_LABEL_ELEMENT__PREFIX:
			case EditorPackage.ECORE_LABEL_ELEMENT__SEPARATOR:
			case EditorPackage.ECORE_LABEL_ELEMENT__SUFFIX:
			case EditorPackage.ECORE_LABEL_ELEMENT__TEXT_PROVIDER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}
}
