package com.sap.tc.moin.repository.events.type;

/**
 * When a new persistence version is available, the MOIN Core will fire a
 * PartitionContentChangedEvent. This may happen for instance when clients
 * synchronize their workspace, which can happen without user interaction
 * (auto-sync). Clients are called upon reloading the affected partition because
 * there are probably changes in the model.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface PartitionContentChangeEvent extends PartitionChangeEvent {
}