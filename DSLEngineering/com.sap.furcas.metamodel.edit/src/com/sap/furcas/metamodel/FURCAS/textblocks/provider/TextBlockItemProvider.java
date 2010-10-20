/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.provider;


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

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TextBlockItemProvider
        extends DocumentNodeItemProvider
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
        public TextBlockItemProvider(AdapterFactory adapterFactory) {
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

                        addTypePropertyDescriptor(object);
                        addParentAltChoicesPropertyDescriptor(object);
                        addElementsInContextPropertyDescriptor(object);
                        addCachedStringPropertyDescriptor(object);
                }
                return itemPropertyDescriptors;
        }

        /**
         * This adds a property descriptor for the Type feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addTypePropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_TextBlock_type_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_TextBlock_type_feature", "_UI_TextBlock_type"),
                                 TextblocksPackage.Literals.TEXT_BLOCK__TYPE,
                                 true,
                                 false,
                                 true,
                                 null,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Parent Alt Choices feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addParentAltChoicesPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_TextBlock_parentAltChoices_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_TextBlock_parentAltChoices_feature", "_UI_TextBlock_type"),
                                 TextblocksPackage.Literals.TEXT_BLOCK__PARENT_ALT_CHOICES,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Elements In Context feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addElementsInContextPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_TextBlock_elementsInContext_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_TextBlock_elementsInContext_feature", "_UI_TextBlock_type"),
                                 TextblocksPackage.Literals.TEXT_BLOCK__ELEMENTS_IN_CONTEXT,
                                 true,
                                 false,
                                 true,
                                 null,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Cached String feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addCachedStringPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_TextBlock_cachedString_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_TextBlock_cachedString_feature", "_UI_TextBlock_type"),
                                 TextblocksPackage.Literals.TEXT_BLOCK__CACHED_STRING,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
                        childrenFeatures.add(TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES);
                        childrenFeatures.add(TextblocksPackage.Literals.TEXT_BLOCK__FOR_EACH_CONTEXT);
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
         * This returns TextBlock.gif.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object getImage(Object object) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/TextBlock"));
        }

        /**
         * This returns the label text for the adapted class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String getText(Object object) {
                Version labelValue = ((TextBlock)object).getVersion();
                String label = labelValue == null ? null : labelValue.toString();
                return label == null || label.length() == 0 ?
                        getString("_UI_TextBlock_type") :
                        getString("_UI_TextBlock_type") + " " + label;
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

                switch (notification.getFeatureID(TextBlock.class)) {
                        case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
                        case TextblocksPackage.TEXT_BLOCK__CACHED_STRING:
                                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                                return;
                        case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
                        case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
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
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createTextBlock()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createAbstractToken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createOmittedToken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createLexedToken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createUnlexedToken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createEostoken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__SUB_NODES,
                                 TextblocksFactory.eINSTANCE.createBostoken()));

                newChildDescriptors.add
                        (createChildParameter
                                (TextblocksPackage.Literals.TEXT_BLOCK__FOR_EACH_CONTEXT,
                                 TextblocksFactory.eINSTANCE.createForEachContext()));
        }

}
