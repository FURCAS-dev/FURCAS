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
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.TCS.Property} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyItemProvider
        extends SequenceElementItemProvider
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
        public PropertyItemProvider(AdapterFactory adapterFactory) {
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

            addPropertyReferencePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

        /**
     * This adds a property descriptor for the Property Reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPropertyReferencePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Property_propertyReference_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Property_propertyReference_feature", "_UI_Property_type"),
                 TCSPackage.Literals.PROPERTY__PROPERTY_REFERENCE,
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
            childrenFeatures.add(TCSPackage.Literals.PROPERTY__PROPERTY_ARGS);
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
     * This returns Property.gif.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Property"));
    }

        /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String getText(Object object) {
        return getString("_UI_Property_type");
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

        switch (notification.getFeatureID(Property.class)) {
            case TCSPackage.PROPERTY__PROPERTY_ARGS:
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
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createRefersToPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createLookInPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createCreateInPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createRefersToKeyPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createSeparatorPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createAutoCreatePArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createImportContextPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createForcedLowerPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createCreateAsPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createAsPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createModePArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createForcedUpperPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createLookupScopePArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createReferenceByPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createPrefixPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createPostfixPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createPartialPArg()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.PROPERTY__PROPERTY_ARGS,
                 TCSFactory.eINSTANCE.createDisambiguatePArg()));
    }

}
