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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassTemplateItemProvider
        extends ContextTemplateItemProvider
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
        public ClassTemplateItemProvider(AdapterFactory adapterFactory) {
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

            addModifiersPropertyDescriptor(object);
            addIsAbstractPropertyDescriptor(object);
            addIsDeepPropertyDescriptor(object);
            addIsOperatoredPropertyDescriptor(object);
            addOperatorListPropertyDescriptor(object);
            addIsMainPropertyDescriptor(object);
            addIsMultiPropertyDescriptor(object);
            addIsNonPrimaryPropertyDescriptor(object);
            addModePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

        /**
     * This adds a property descriptor for the Modifiers feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addModifiersPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_modifiers_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_modifiers_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__MODIFIERS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Abstract feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsAbstractPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isAbstract_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isAbstract_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_ABSTRACT,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Deep feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsDeepPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isDeep_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isDeep_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_DEEP,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Operatored feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsOperatoredPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isOperatored_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isOperatored_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_OPERATORED,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Operator List feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addOperatorListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_operatorList_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_operatorList_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__OPERATOR_LIST,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Main feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsMainPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isMain_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isMain_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_MAIN,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Multi feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsMultiPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isMulti_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isMulti_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_MULTI,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Is Non Primary feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addIsNonPrimaryPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_isNonPrimary_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_isNonPrimary_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__IS_NON_PRIMARY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Mode feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addModePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ClassTemplate_mode_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ClassTemplate_mode_feature", "_UI_ClassTemplate_type"),
                 TCSPackage.Literals.CLASS_TEMPLATE__MODE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This returns ClassTemplate.gif.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassTemplate"));
    }

        /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String getText(Object object) {
        String label = ((ClassTemplate)object).getDisambiguate();
        return label == null || label.length() == 0 ?
            getString("_UI_ClassTemplate_type") :
            getString("_UI_ClassTemplate_type") + " " + label;
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

        switch (notification.getFeatureID(ClassTemplate.class)) {
            case TCSPackage.CLASS_TEMPLATE__MODIFIERS:
            case TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT:
            case TCSPackage.CLASS_TEMPLATE__IS_DEEP:
            case TCSPackage.CLASS_TEMPLATE__IS_OPERATORED:
            case TCSPackage.CLASS_TEMPLATE__IS_MAIN:
            case TCSPackage.CLASS_TEMPLATE__IS_MULTI:
            case TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY:
            case TCSPackage.CLASS_TEMPLATE__MODE:
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
