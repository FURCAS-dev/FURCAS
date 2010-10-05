/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.provider;


import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
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
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.TCS.ConcreteSyntax} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConcreteSyntaxItemProvider
        extends NamedElementItemProvider
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
        public ConcreteSyntaxItemProvider(AdapterFactory adapterFactory) {
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

                        addKPropertyDescriptor(object);
                        addLexerPropertyDescriptor(object);
                }
                return itemPropertyDescriptors;
        }

        /**
         * This adds a property descriptor for the K feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addKPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_ConcreteSyntax_k_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_k_feature", "_UI_ConcreteSyntax_type"),
                                 TCSPackage.Literals.CONCRETE_SYNTAX__K,
                                 true,
                                 false,
                                 false,
                                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                 null,
                                 null));
        }

        /**
         * This adds a property descriptor for the Lexer feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected void addLexerPropertyDescriptor(Object object) {
                itemPropertyDescriptors.add
                        (createItemPropertyDescriptor
                                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                 getResourceLocator(),
                                 getString("_UI_ConcreteSyntax_lexer_feature"),
                                 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_lexer_feature", "_UI_ConcreteSyntax_type"),
                                 TCSPackage.Literals.CONCRETE_SYNTAX__LEXER,
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
                        childrenFeatures.add(TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES);
                        childrenFeatures.add(TCSPackage.Literals.CONCRETE_SYNTAX__KEYWORDS);
                        childrenFeatures.add(TCSPackage.Literals.CONCRETE_SYNTAX__SYMBOLS);
                        childrenFeatures.add(TCSPackage.Literals.CONCRETE_SYNTAX__OPERATOR_LISTS);
                        childrenFeatures.add(TCSPackage.Literals.CONCRETE_SYNTAX__TOKENS);
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
         * This returns ConcreteSyntax.gif.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object getImage(Object object) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/ConcreteSyntax"));
        }

        /**
         * This returns the label text for the adapted class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String getText(Object object) {
                String label = ((ConcreteSyntax)object).getName();
                return label == null || label.length() == 0 ?
                        getString("_UI_ConcreteSyntax_type") :
                        getString("_UI_ConcreteSyntax_type") + " " + label;
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

                switch (notification.getFeatureID(ConcreteSyntax.class)) {
                        case TCSPackage.CONCRETE_SYNTAX__K:
                        case TCSPackage.CONCRETE_SYNTAX__LEXER:
                                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                                return;
                        case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                        case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                        case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                        case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                        case TCSPackage.CONCRETE_SYNTAX__TOKENS:
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
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createFunctionTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createContextTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createClassTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createPrimitiveTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createOperatorTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TEMPLATES,
                                 TCSFactory.eINSTANCE.createEnumerationTemplate()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__KEYWORDS,
                                 TCSFactory.eINSTANCE.createKeyword()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__SYMBOLS,
                                 TCSFactory.eINSTANCE.createSymbol()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__OPERATOR_LISTS,
                                 TCSFactory.eINSTANCE.createOperatorList()));

                newChildDescriptors.add
                        (createChildParameter
                                (TCSPackage.Literals.CONCRETE_SYNTAX__TOKENS,
                                 TCSFactory.eINSTANCE.createToken()));
        }

}
