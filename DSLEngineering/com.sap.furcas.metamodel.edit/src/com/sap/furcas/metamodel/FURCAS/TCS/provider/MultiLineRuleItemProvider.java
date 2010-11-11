/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.provider;


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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiLineRuleItemProvider
        extends RuleItemProvider
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
        public MultiLineRuleItemProvider(AdapterFactory adapterFactory) {
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

			addDropStartPropertyDescriptor(object);
			addDropEndPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

        /**
	 * This adds a property descriptor for the Drop Start feature.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected void addDropStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiLineRule_dropStart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiLineRule_dropStart_feature", "_UI_MultiLineRule_type"),
				 TCSPackage.Literals.MULTI_LINE_RULE__DROP_START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

        /**
	 * This adds a property descriptor for the Drop End feature.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected void addDropEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiLineRule_dropEnd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiLineRule_dropEnd_feature", "_UI_MultiLineRule_type"),
				 TCSPackage.Literals.MULTI_LINE_RULE__DROP_END,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
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
        public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TCSPackage.Literals.MULTI_LINE_RULE__START);
			childrenFeatures.add(TCSPackage.Literals.MULTI_LINE_RULE__END);
			childrenFeatures.add(TCSPackage.Literals.MULTI_LINE_RULE__ESC);
			childrenFeatures.add(TCSPackage.Literals.MULTI_LINE_RULE__ESC_MAPPINGS);
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
	 * This returns MultiLineRule.gif.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MultiLineRule"));
	}

        /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public String getText(Object object) {
		String label = ((MultiLineRule)object).getLocation();
		return label == null || label.length() == 0 ?
			getString("_UI_MultiLineRule_type") :
			getString("_UI_MultiLineRule_type") + " " + label;
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

		switch (notification.getFeatureID(MultiLineRule.class)) {
			case TCSPackage.MULTI_LINE_RULE__DROP_START:
			case TCSPackage.MULTI_LINE_RULE__DROP_END:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TCSPackage.MULTI_LINE_RULE__START:
			case TCSPackage.MULTI_LINE_RULE__END:
			case TCSPackage.MULTI_LINE_RULE__ESC:
			case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__START,
				 TCSFactory.eINSTANCE.createStringPattern()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__END,
				 TCSFactory.eINSTANCE.createStringPattern()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__ESC,
				 TCSFactory.eINSTANCE.createStringPattern()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__ESC_MAPPINGS,
				 TCSFactory.eINSTANCE.createSimpleMapping()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__ESC_MAPPINGS,
				 TCSFactory.eINSTANCE.createWildcardMapping()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__ESC_MAPPINGS,
				 TCSFactory.eINSTANCE.createOctalMapping()));

		newChildDescriptors.add
			(createChildParameter
				(TCSPackage.Literals.MULTI_LINE_RULE__ESC_MAPPINGS,
				 TCSFactory.eINSTANCE.createHexadecimalMapping()));
	}

        /**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TCSPackage.Literals.MULTI_LINE_RULE__START ||
			childFeature == TCSPackage.Literals.MULTI_LINE_RULE__END ||
			childFeature == TCSPackage.Literals.MULTI_LINE_RULE__ESC;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
