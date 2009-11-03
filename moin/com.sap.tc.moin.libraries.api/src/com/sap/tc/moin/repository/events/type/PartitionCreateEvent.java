package com.sap.tc.moin.repository.events.type;

/**
 * The PartitionCreateEvent indicates the creation of a new partition. The
 * creation of so called "No-Partitions" is not covered. Both, the
 * PartitionCreatedEvent and the PartitionRemovedEvent do not only have global
 * character. They will also be used to indicate transient changes in a session
 * (which then of course only will be sent to local clients).
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface PartitionCreateEvent extends PartitionChangeEvent {

}