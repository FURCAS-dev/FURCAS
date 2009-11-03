/*
 * Created on Dec 14, 2005
 */
package com.sap.tc.moin.repository.core.events;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreEventFactory;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;

/**
 * @author d024032
 */
public class EventFactoryImpl implements CoreEventFactory {

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventFactory#
     * createPartitionContentChangedEvent
     * (com.sap.tc.moin.repository.core.impl.MRI)
     */
    public PartitionContentChangeEvent createPartitionContentChangedEvent( Connection triggeringConnection, PRI affectedPartition ) {

        return new PartitionContentChangeEventImpl( (CoreConnection) triggeringConnection, affectedPartition );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createPartitionCreatedEvent
     * (com.sap.tc.moin.repository.core.impl.MRI)
     */
    public PartitionCreateEvent createPartitionCreatedEvent( Connection triggeringConnection, PRI affectedPartition ) {

        return new PartitionCreateEventImpl( (CoreConnection) triggeringConnection, affectedPartition );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventFactory#
     * createPartitionMembershipChangeEvent(com.sap.tc.moin.repository.mmi.reflect.RefObject,
     * com.sap.tc.moin.repository.core.impl.ModelPartition,
     * com.sap.tc.moin.repository.core.impl.ModelPartition)
     */
    public PartitionMembershipChangeEvent createPartitionMembershipChangeEvent( CoreConnection triggeringConnection, RefObject affectedElement, ModelPartition oldPartition, ModelPartition newPartition ) {

        return new PartitionMembershipChangeEventImpl( triggeringConnection, affectedElement, oldPartition, newPartition );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createPartitionRemovedEvent
     * (com.sap.tc.moin.repository.core.impl.MRI)
     */

    public PartitionDeleteEvent createPartitionRemovedEvent( Connection triggeringConnection, PRI affectedPartition ) {

        return new PartitionDeleteEventImpl( (CoreConnection) triggeringConnection, affectedPartition );
    }

    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object value, int position ) {

        return new AttributeValueAddEventImpl( triggeringConnection, affectedElementMri, affectedElementImmediatePackageMri, affectedElementParentLris, affectedElementMetaObject, attributeMetaObject, value, position );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createAttributeValueAddEvent
     * (com.sap.tc.moin.repository.mmi.reflect.RefFeatured, com.sap.tc.moin.repository.mmi.model.Attribute,
     * java.lang.Object)
     */
    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value ) {

        return new AttributeValueAddEventImpl( triggeringConnection, affectedElement, attributeMetaObject, value );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createAttributeValueAddEvent
     * (com.sap.tc.moin.repository.mmi.reflect.RefFeatured, com.sap.tc.moin.repository.mmi.model.Attribute,
     * java.lang.Object, int)
     */
    public AttributeValueAddEvent createAttributeValueAddEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position ) {

        return new AttributeValueAddEventImpl( triggeringConnection, affectedElement, attributeMetaObject, value, position );
    }

    public AttributeValueChangeEvent createAttributeValueChangeEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object oldValue,
        Object newValue ) {

        return new AttributeValueChangeEventImpl( triggeringConnection, affectedElementMri, affectedElementImmediatePackageMri, affectedElementParentLris, affectedElementMetaObject, attributeMetaObject, oldValue, newValue );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventFactory#
     * createAttributeValueChangeEvent(com.sap.tc.moin.repository.mmi.reflect.RefFeatured,
     * com.sap.tc.moin.repository.mmi.model.Attribute, java.lang.Object, java.lang.Object)
     */
    public AttributeValueChangeEvent createAttributeValueChangeEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object oldValue, Object newValue ) {

        return new AttributeValueChangeEventImpl( triggeringConnection, affectedElement, attributeMetaObject, oldValue, newValue );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventFactory#
     * createAttributeValueRemoveEvent(com.sap.tc.moin.repository.mmi.reflect.RefFeatured,
     * com.sap.tc.moin.repository.mmi.model.Attribute, java.lang.Object)
     */
    public AttributeValueRemoveEvent createAttributeValueRemoveEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value ) {

        return new AttributeValueRemoveEventImpl( triggeringConnection, affectedElement, attributeMetaObject, value );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventFactory#
     * createAttributeValueRemoveEvent(com.sap.tc.moin.repository.mmi.reflect.RefFeatured,
     * com.sap.tc.moin.repository.mmi.model.Attribute, java.lang.Object, int)
     */
    public AttributeValueRemoveEvent createAttributeValueRemoveEvent( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position ) {

        return new AttributeValueRemoveEventImpl( triggeringConnection, affectedElement, attributeMetaObject, value, position );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createElementCreateEvent
     * (com.sap.tc.moin.repository.mmi.reflect.RefFeatured)
     */
    public ElementCreateEvent createElementCreateEvent( CoreConnection triggeringConnection, MRI affectedElementMri, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        return new ElementCreateEventImpl( triggeringConnection, affectedElementMri, metaObjectMri, immediatePackageExtentMri );
    }

    public ElementCreateEvent createElementCreateEvent( CoreConnection triggeringConnection, MRI affectedElementMri, List<LRI> affectedElementParentLris, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        return new ElementCreateEventImpl( triggeringConnection, affectedElementMri, affectedElementParentLris, metaObjectMri, immediatePackageExtentMri );
    }

    public LinkAddEvent createLinkAddEvent( CoreConnection triggeringConnection, ModelElement linkMetaObject, int linkPosition, MRI firstLinkEndMri, List<LRI> firstLinkEndParentLris, MofClass firstLinkEndMetaObject, MRI secondLinkEndMri, List<LRI> secondLinkEndParentLris,
        MofClass secondLinkEndMetaObject ) {

        return new LinkAddEventImpl( triggeringConnection, linkMetaObject, linkPosition, firstLinkEndMri, firstLinkEndParentLris, firstLinkEndMetaObject, secondLinkEndMri, secondLinkEndParentLris, secondLinkEndMetaObject );
    }



    public LinkAddEvent createLinkAddEvent( CoreConnection triggeringConnection, EndStorageLink link, int position ) {

        return new LinkAddEventImpl( triggeringConnection, link, position );
    }



    public LinkRemoveEvent createLinkRemoveEvent( CoreConnection triggeringConnection, EndStorageLink link, int position ) {

        return new LinkRemoveEventImpl( triggeringConnection, link, position );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventFactory#createElementDeleteEvent
     * (com.sap.tc.moin.repository.mmi.reflect.RefFeatured)
     */
    public ElementDeleteEvent createElementDeleteEvent( CoreConnection triggeringConnection, RefFeatured affectedElement ) {

        return new ElementDeleteEventImpl( triggeringConnection, affectedElement );
    }
}
