package com.sap.tc.moin.repository.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.spi.core.SpiEventFactory;

public interface CoreEventFactory extends SpiEventFactory {

    /*
     * ModelChangeEvents
     */
    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object value, int position );

    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value );

    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position );

    public AttributeValueChangeEvent createAttributeValueChangeEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object oldValue,
        Object newValue );

    public AttributeValueChangeEvent createAttributeValueChangeEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object oldValue, Object newValue );

    public AttributeValueRemoveEvent createAttributeValueRemoveEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value );

    public AttributeValueRemoveEvent createAttributeValueRemoveEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position );

    public ElementCreateEvent createElementCreateEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI metaObjectMri, MRI immediatePackageExtentMri );

    public ElementCreateEvent createElementCreateEvent( CoreConnection triggeringConnection, MRI affectedElementMri, List<LRI> affectedElementParentLris, MRI metaObjectMri, MRI immediatePackageExtentMri );

    public ElementDeleteEvent createElementDeleteEvent( CoreConnection triggeringConnection, RefFeatured affectedElement );

    public LinkAddEvent createLinkAddEvent( CoreConnection triggeringConnection, ModelElement linkMetaObject, int linkPosition, MRI firstLinkEndMri, List<LRI> firstLinkEndParentLris, MofClass firstLinkEndMetaObject, MRI secondLinkEndMri, List<LRI> secondLinkEndParentLris,
        MofClass secondLinkEndMetaObject );

    public LinkAddEvent createLinkAddEvent( CoreConnection triggeringConnection, EndStorageLink link, int position );


    public LinkRemoveEvent createLinkRemoveEvent( CoreConnection triggeringConnection, EndStorageLink link, int position );

    public PartitionMembershipChangeEvent createPartitionMembershipChangeEvent( CoreConnection triggeringConnection, RefObject affectedElement, ModelPartition oldPartition, ModelPartition newPartition );



}
