/**
 * This package contains the event type interfaces provided by the
 * EventFramework. <br>
 * <b>A brief overview on the most important interfaces:</b><br>
 * <br>
 * <b>PreElementCreateEvent</b>: The PreElementCreateEvent is fired before a MOF
 * element is being created.<br>
 * <b>ElementCreateEvent</b>: An ElementCreateEvent will be fired after a MOF
 * element was created.<br>
 * <b>ElementDeleteEvent</b>: The ElementDeleteEvent is fired every time a MOF
 * element is removed using the ref-Delete() operation on the model element
 * itself or on a composite parent.<br>
 * <b>AttributeValueChangeEvent</b>: The AttributeValueChangeEvent is fired when
 * a MOF attribute was changed.<br>
 * <b>AttributeValueAddEvent</b>: MOF also supports attributes with cardinality
 * greater than one. If an attribute value was added to the collection of
 * values, an AttributeValueAddEvent will be fired.<br>
 * <b>AttributeValueRemoveEvent</b>: This type of event indicates a removal of a
 * value from the collection.<br>
 * <b>LinkAddEvent</b>: The LinkAddEvent indicates the creation of a link (an
 * instance of a meta model association).<br>
 * <b>LinkRemoveEvent</b>: The LinkRemoveEvent indicates the removal of a link.<br>
 * <b>PartitionMembershipChangeEvent</b>: This event will be fired when a model
 * element is moved between different partitions.<br>
 * <b>PartitionCreateEvent</b>: The PartitionCreateEvent indicates the creation
 * of a new partition. The creation of so called "Transient-Partitions" is not
 * covered.<br>
 * <b>PartitionRemoveEvent</b>: The PartitionRemoveEvent indicates the removal
 * of a partition.<br>
 * <b>PartitionContentChangeEvent</b>: The PartitionContentChangeEvent is fired
 * when the persistence got a new version of a partition.<br>
 * <b>PartitionPropertyChangeEvent</b>: This kind of event indicates a change of
 * a property of the affected partition. There are currently 4 different
 * supported property changes which are reflected in the contained enum
 * <code>PartitionPropertyType</code>: WRITABLE_STATE,CAN_BE_CHECKED_OUT,VERSION
 * and VERSIONED_STATE.<br>
 * <b>PartitionSaveEvent</b>: A PartitionSaveEvent is fired every time a
 * partition is persisted.<br>
 * <br>
 * <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.events.type;

