package com.sap.tc.moin.repository.events.type;


/**
 * PartitionChangeEvents indicate changes to Partitions. <br>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @see com.sap.tc.moin.repository.events.type.PartitionCreateEvent
 * @see com.sap.tc.moin.repository.events.type.PartitionDeleteEvent
 * @see com.sap.tc.moin.repository.events.type.PartitionPropertyChangeEvent
 * @see com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent
 * @author Daniel Vocke (D044825)
 */
public interface PartitionChangeEvent extends PartitionEvent {

}