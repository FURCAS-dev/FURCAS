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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConditionalElementItemProvider
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
        public ConditionalElementItemProvider(AdapterFactory adapterFactory) {
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
            childrenFeatures.add(TCSPackage.Literals.CONDITIONAL_ELEMENT__CONDITION);
            childrenFeatures.add(TCSPackage.Literals.CONDITIONAL_ELEMENT__THEN_SEQUENCE);
            childrenFeatures.add(TCSPackage.Literals.CONDITIONAL_ELEMENT__ELSE_SEQUENCE);
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
     * This returns ConditionalElement.gif.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ConditionalElement"));
    }

        /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String getText(Object object) {
        return getString("_UI_ConditionalElement_type");
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

        switch (notification.getFeatureID(ConditionalElement.class)) {
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
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
                (TCSPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
                 TCSFactory.eINSTANCE.createAndExp()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.CONDITIONAL_ELEMENT__THEN_SEQUENCE,
                 TCSFactory.eINSTANCE.createSequence()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.CONDITIONAL_ELEMENT__THEN_SEQUENCE,
                 TCSFactory.eINSTANCE.createSequenceInAlternative()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.CONDITIONAL_ELEMENT__ELSE_SEQUENCE,
                 TCSFactory.eINSTANCE.createSequence()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.CONDITIONAL_ELEMENT__ELSE_SEQUENCE,
                 TCSFactory.eINSTANCE.createSequenceInAlternative()));
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
            childFeature == TCSPackage.Literals.CONDITIONAL_ELEMENT__THEN_SEQUENCE ||
            childFeature == TCSPackage.Literals.CONDITIONAL_ELEMENT__ELSE_SEQUENCE;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
