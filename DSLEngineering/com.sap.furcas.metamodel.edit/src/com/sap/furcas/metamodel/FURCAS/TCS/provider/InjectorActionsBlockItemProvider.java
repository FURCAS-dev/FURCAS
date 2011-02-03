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

import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InjectorActionsBlockItemProvider
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
        public InjectorActionsBlockItemProvider(AdapterFactory adapterFactory) {
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
            childrenFeatures.add(TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS);
            childrenFeatures.add(TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS);
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
     * This returns InjectorActionsBlock.gif.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/InjectorActionsBlock"));
    }

        /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String getText(Object object) {
        String label = ((InjectorActionsBlock)object).getLocation();
        return label == null || label.length() == 0 ?
            getString("_UI_InjectorActionsBlock_type") :
            getString("_UI_InjectorActionsBlock_type") + " " + label;
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

        switch (notification.getFeatureID(InjectorActionsBlock.class)) {
            case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
            case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
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
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS,
                 TCSFactory.eINSTANCE.createPrimitivePropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS,
                 TCSFactory.eINSTANCE.createOclPropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS,
                 TCSFactory.eINSTANCE.createForeachPredicatePropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS,
                 TCSFactory.eINSTANCE.createLookupPropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS,
                 TCSFactory.eINSTANCE.createPrimitivePropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS,
                 TCSFactory.eINSTANCE.createOclPropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS,
                 TCSFactory.eINSTANCE.createForeachPredicatePropertyInit()));

        newChildDescriptors.add
            (createChildParameter
                (TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS,
                 TCSFactory.eINSTANCE.createLookupPropertyInit()));
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
            childFeature == TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS ||
            childFeature == TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
