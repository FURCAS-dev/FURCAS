/**
 * 
 */
package com.sap.tc.moin.repository.spi.runtimehost.context;


/**
 * Wrapper for the <code>javax.transaction.Synchronization</code> interface. The
 * wrapper interface is introduced for decoupling from JTA (which is part of
 * Java EE).
 * 
 * @author d032434
 */
public interface SpiTransactionSynchronization {

    /**
     * Prefix for synchronization identifiers used by MOIN.
     */
    public static final String SID_PREFIX = "com.sap.tc.moin."; //$NON-NLS-1$

    /**
     * The beforeCompletion method is called by the transaction manager prior to
     * the start of the two-phase transaction commit process. This call is
     * executed with the transaction context of the transaction that is being
     * committed.
     */
    public abstract void beforeCompletion( );

    /**
     * This method is called by the transaction manager after the transaction is
     * committed or rolled back. Unlike the original method in
     * <code>javax.transaction.Synchronization</code>, the status can only be
     * committed or not-committed and is therefore expressed by a
     * <code>boolean</code> instead of an <code>int</code> parameter.
     * 
     * @param committed - Flag the status of the transaction completion -
     * <code>true</code>, if the transaction has been committed (i.e. JTA
     * transaction status code is
     * <code>javax.transaction.Status.STATUS_COMMITTED</code>.,
     * <code>false</code> in all other cases
     */
    public abstract void afterCompletion( boolean committed );
}
