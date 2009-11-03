package com.sap.tc.moin.repository.events.type;

/**
 * The PartitionDeleteEvent indicates the removal of a partition. Like the
 * PartitionCreatedEvent, this kind of event can also be used to indicate
 * transient changes that are only visible to clients that are connected to the
 * same session(which then of course only will be sent to local clients). The
 * removal of TransientPartitions is not covered.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface PartitionDeleteEvent extends PartitionChangeEvent {

}