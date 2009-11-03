package com.sap.tc.moin.repository.spi.runtimehost.context;

/**
 * /**
 * The transaction ticket is a MOIN Wrapper of the JTA transaction ticket.
 * The Wrapper is necessary in order to provide transaction handling for MOIN running in
 * Java Server environment using DB persistence.
 */
public interface SpiTransactionTicket {
    /**
     * Has the JTA transaction been started on the transaction level associated
     * with this ticket?
     * 
     * @return 	true if the JTA transaction was started on this ticket's transaction level, false otherwise.
     */
    public boolean wasStarted();
}
