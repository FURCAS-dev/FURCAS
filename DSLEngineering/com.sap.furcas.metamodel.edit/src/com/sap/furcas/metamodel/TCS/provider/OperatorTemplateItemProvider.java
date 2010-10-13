/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.provider;


import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.TCSFactory;
import com.sap.furcas.metamodel.TCS.TCSPackage;

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

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.TCS.OperatorTemplate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorTemplateItemProvider
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
        public OperatorTemplateItemProvider(AdapterFactory adapterFactory) {
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

                        addOperatorsPropertyDescriptor(object);
                        addSourcePropertyDescriptor(object);
                        addStoreOpToPropertyDescriptor(object);
                        addStoreRightToPropertyDescriptor(object);
                        addStoreOperatorToPropertyDescriptor(object);
                        addStoreLeftSideToPropertyDescriptor(object);
                        addStoreRightSideToPropertyDescriptor(object);
                }
                return itemPropertyDescriptors;
        }

        /**
         * This adds a property descriptor for the Operators feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addOperatorsPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_operators_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_operators_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__OPERATORS,
                                 true,
                                 false,
                                 true,
                                 null,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Source feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addSourcePropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_source_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_source_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__SOURCE,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Store Op To feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addStoreOpToPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_storeOpTo_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_storeOpTo_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__STORE_OP_TO,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Store Right To feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addStoreRightToPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_storeRightTo_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_storeRightTo_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__STORE_RIGHT_TO,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Store Operator To feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addStoreOperatorToPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_storeOperatorTo_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_storeOperatorTo_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__STORE_OPERATOR_TO,
                                 true,
                                 false,
                                 true,
                                 null,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Store Left Side To feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addStoreLeftSideToPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_storeLeftSideTo_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_storeLeftSideTo_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO,
                                 true,
                                 false,
                                 true,
                                 null,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Store Right Side To feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addStoreRightSideToPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_OperatorTemplate_storeRightSideTo_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_OperatorTemplate_storeRightSideTo_feature", "_UI_OperatorTemplate_type"),
                                 TCSPackage.Literals.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO,
                                 true,
                                 false,
                                 true,
                                 null,
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
                        childrenFeatures.add(TCSPackage.Literals.OPERATOR_TEMPLATE__OT_SEQUENCE);
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
         * This returns OperatorTemplate.gif.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object getImage(Object object) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/OperatorTemplate"));
        }

        /**
         * This returns the label text for the adapted class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String getText(Object object) {
                String label = ((OperatorTemplate)object).getLocation();
                return label == null || label.length() == 0 ?
                        getString("_UI_OperatorTemplate_type") :
                        getString("_UI_OperatorTemplate_type") + " " + label;
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

                switch (notification.getFeatureID(OperatorTemplate.class)) {
                        case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
                        case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
                        case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
                                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                                return;
                        case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
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
                                (TCSPackage.Literals.OPERATOR_TEMPLATE__OT_SEQUENCE,
                                 TCSFactory.eINSTANCE.createSequence()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.OPERATOR_TEMPLATE__OT_SEQUENCE,
                                 TCSFactory.eINSTANCE.createSequenceInAlternative()));
        }

}
