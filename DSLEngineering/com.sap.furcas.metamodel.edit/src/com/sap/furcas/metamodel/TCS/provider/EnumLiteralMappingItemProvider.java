/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.provider;


import com.sap.furcas.metamodel.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.TCS.TCSFactory;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.TCS.EnumLiteralMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumLiteralMappingItemProvider
        extends LocatedElementItemProvider
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
        public EnumLiteralMappingItemProvider(AdapterFactory adapterFactory) {
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
        public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
                if (childrenFeatures == null) {
                        super.getChildrenFeatures(object);
                        childrenFeatures.add(TCSPackage.Literals.ENUM_LITERAL_MAPPING__LITERAL);
                        childrenFeatures.add(TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT);
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
         * This returns EnumLiteralMapping.gif.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object getImage(Object object) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/EnumLiteralMapping"));
        }

        /**
         * This returns the label text for the adapted class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String getText(Object object) {
                String label = ((EnumLiteralMapping)object).getLocation();
                return label == null || label.length() == 0 ?
                        getString("_UI_EnumLiteralMapping_type") :
                        getString("_UI_EnumLiteralMapping_type") + " " + label;
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

                switch (notification.getFeatureID(EnumLiteralMapping.class)) {
                        case TCSPackage.ENUM_LITERAL_MAPPING__LITERAL:
                        case TCSPackage.ENUM_LITERAL_MAPPING__ELEMENT:
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
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__LITERAL,
                                 TCSFactory.eINSTANCE.createEnumLiteralVal()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createLiteralRef()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createProperty()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createCustomSeparator()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createBlock()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createConditionalElement()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createAlternative()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createFunctionCall()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.ENUM_LITERAL_MAPPING__ELEMENT,
                                 TCSFactory.eINSTANCE.createInjectorActionsBlock()));
        }

}
