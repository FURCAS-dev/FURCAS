/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.provider;


import com.sap.furcas.metamodel.FURCAS.provider.FURCASEditPlugin;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentNodeItemProvider
        extends ItemProviderAdapter
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
        public DocumentNodeItemProvider(AdapterFactory adapterFactory) {
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

            addVersionPropertyDescriptor(object);
            addChildrenChangedPropertyDescriptor(object);
            addRelexingNeededPropertyDescriptor(object);
            addCorrespondingModelElementsPropertyDescriptor(object);
            addReferencedElementsPropertyDescriptor(object);
            addSequenceElementPropertyDescriptor(object);
            addOffsetPropertyDescriptor(object);
            addLengthPropertyDescriptor(object);
            addOtherVersionsPropertyDescriptor(object);
            addOffsetRelativePropertyDescriptor(object);
            addStartRowPropertyDescriptor(object);
            addStartColumnPropertyDescriptor(object);
            addEndRowPropertyDescriptor(object);
            addEndColumnPropertyDescriptor(object);
            addAbsoluteOffsetPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

        /**
     * This adds a property descriptor for the Version feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addVersionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_version_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_version_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__VERSION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Children Changed feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addChildrenChangedPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_childrenChanged_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_childrenChanged_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__CHILDREN_CHANGED,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Relexing Needed feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addRelexingNeededPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_relexingNeeded_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_relexingNeeded_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__RELEXING_NEEDED,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Corresponding Model Elements feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addCorrespondingModelElementsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_correspondingModelElements_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_correspondingModelElements_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__CORRESPONDING_MODEL_ELEMENTS,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Referenced Elements feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addReferencedElementsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_referencedElements_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_referencedElements_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__REFERENCED_ELEMENTS,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Sequence Element feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addSequenceElementPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_sequenceElement_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_sequenceElement_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__SEQUENCE_ELEMENT,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Offset feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_offset_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_offset_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__OFFSET,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Length feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addLengthPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_length_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_length_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__LENGTH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Other Versions feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addOtherVersionsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_otherVersions_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_otherVersions_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__OTHER_VERSIONS,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Offset Relative feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addOffsetRelativePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_offsetRelative_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_offsetRelative_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__OFFSET_RELATIVE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Start Row feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addStartRowPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_startRow_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_startRow_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__START_ROW,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Start Column feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addStartColumnPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_startColumn_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_startColumn_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__START_COLUMN,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the End Row feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addEndRowPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_endRow_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_endRow_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__END_ROW,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the End Column feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addEndColumnPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_endColumn_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_endColumn_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__END_COLUMN,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This adds a property descriptor for the Absolute Offset feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void addAbsoluteOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DocumentNode_absoluteOffset_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DocumentNode_absoluteOffset_feature", "_UI_DocumentNode_type"),
                 TextblocksPackage.Literals.DOCUMENT_NODE__ABSOLUTE_OFFSET,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

        /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String getText(Object object) {
        Version labelValue = ((DocumentNode)object).getVersion();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ?
            getString("_UI_DocumentNode_type") :
            getString("_UI_DocumentNode_type") + " " + label;
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

        switch (notification.getFeatureID(DocumentNode.class)) {
            case TextblocksPackage.DOCUMENT_NODE__VERSION:
            case TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED:
            case TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED:
            case TextblocksPackage.DOCUMENT_NODE__OFFSET:
            case TextblocksPackage.DOCUMENT_NODE__LENGTH:
            case TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE:
            case TextblocksPackage.DOCUMENT_NODE__START_ROW:
            case TextblocksPackage.DOCUMENT_NODE__START_COLUMN:
            case TextblocksPackage.DOCUMENT_NODE__END_ROW:
            case TextblocksPackage.DOCUMENT_NODE__END_COLUMN:
            case TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET:
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

        /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ResourceLocator getResourceLocator() {
        return FURCASEditPlugin.INSTANCE;
    }

}
