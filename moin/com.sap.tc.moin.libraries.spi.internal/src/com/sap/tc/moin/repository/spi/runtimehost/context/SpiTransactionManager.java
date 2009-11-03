package com.sap.tc.moin.repository.spi.runtimehost.context;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The transaction manager.
 */
public interface SpiTransactionManager {

    /**
     * Requires a new JTA transaction to be started or an already open
     * transaction to be joined. If there is already an open transaction
     * associated with the current thread, this transaction is joined.
     * Otherwise, if no transaction exists, a new transaction is started and
     * associated with the current thread.
     * <p>
     * The method returns a transaction ticket as a unique identifier for this
     * transaction level. Later on, this ticket has to be passed as an argument
     * to the methods <code>commitLevel()</code> and <code>leaveLevel()</code>,
     * in order to associate them with the transaction level opened by this
     * call.
     * 
     * @return a transaction ticket.
     * @exception SpiTransactionException thrown if there is already a
     * transaction associated with the current thread and this transaction is
     * marked for rollback only, for example, as a result of a setRollbackOnly()
     * call.
     */
    public SpiTransactionTicket required( ) throws SpiTransactionException;

    /**
     * Requires a new transaction to be started. If there is already an open
     * transaction associated with the current thread, this transaction will be
     * suspended and the new transaction will be associated with the thread. The
     * suspended transaction will be resumed, when this transaction is completed
     * (either committed or rolled back).
     * <p>
     * The method returns a transaction ticket as a unique identifier for this
     * transaction level. Later on, this ticket has to be passed as an argument
     * to the methods <code>commitLevel()</code> and <code>leaveLevel()</code>,
     * in order to associate them with the transaction level opened by this
     * call.
     * 
     * @return a transaction ticket.
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation.
     */
    public SpiTransactionTicket requiresNew( ) throws SpiTransactionException;

    /**
     * Marks the current JTA transaction for rollback. The rollback is performed
     * when the <code>commitLevel()</code> method is called on the transaction
     * level that has started the JTA transaction.
     * <p>
     * 
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation.
     */

    public void setRollbackOnly( ) throws SpiTransactionException;

    /**
     * Commmits the transaction level associated with the given transaction
     * ticket.
     * <p>
     * If no JTA transaction has been started on the this transaction level,
     * then this method has no effect.
     * </p>
     * <p>
     * 
     * @param txticket a transaction ticket.
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation, e.g. the transaction was rolled
     * back rather than committed.
     */
    public void commitLevel( SpiTransactionTicket transactionTicket ) throws SpiTransactionException;

    /**
     * Finishes and leaves the transaction level associated with the given
     * transaction ticket.
     * <p>
     * If the <code>commitLevel()</code> method has already been called on the
     * transaction level identified by this ticket, this method has no further
     * effect than finishing the current transaction level. Otherwise, if the
     * <code>commitLevel()</code> method has not yet been called on this
     * transaction level, the following two cases must be distinguished:
     * </p>
     * <p>
     * <ul>
     * <li>If a JTA transaction was started on this transaction level, then it
     * will be rolled back. This also means that the
     * <code>afterCompletion()</code> methods of the registered
     * <code>Synchronization</code> objects are called immediately after the
     * rollback operation was executed.</code></li>
     * <li>Otherwise, if no JTA transaction was started on this transaction
     * level, then the joined JTA transaction will be marked for rollback only.</li>
     * </ul>
     * </p>
     * <p>
     * In both cases, a <code>DbTxRollbackException</code> is thrown in order to
     * indicate that the current JTA transaction has been rolled back or has
     * been marked for rollback only.
     * </p>
     * <p>
     * Finally, if a JTA transaction has been suspended on this transaction
     * level because a new one was started, then this suspended transaction will
     * be resumed before this method is left.
     * <p>
     * 
     * @param txticket a transaction ticket.
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation, e.g. the transaction was rolled
     * back rather than committed.
     */
    public void leaveLevel( SpiTransactionTicket transactionTicket ) throws SpiTransactionException;

    /**
     * Checks whether the transaction associated with the current thread is
     * marked for rollback.
     * 
     * @return true if the transaction associated with the current thread is
     * marked for rollback
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation.
     */
    public boolean isTxMarkedRollback( ) throws SpiTransactionException;


    /**
     * Registers the given <code>Synchronization</code> object with the current
     * transaction. The specified synchronization id (SID) is used to define an
     * order on the registered synchronization objects, thus reducing the
     * probability of database deadlocks.
     * <p>
     * 
     * @param sid a synchronization identifier; should always be prefixed by
     * {@link SpiTransactionSynchronization#SID_PREFIX}
     * @param sync a <code>Synchronization</code> object implementing the
     * <code>beforeCompletion()</code> and <code>afterCompletion()</code>
     * callbacks.
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation.
     */
    public void registerSynchronization( String syncId, SpiTransactionSynchronization sync ) throws SpiTransactionException;

    /**
     * Gets the <code>Synchronization</code> object previously registered with
     * the current transaction under the given synchronization id (sid).
     * <p>
     * 
     * @param sid a synchronization identifier
     * @return the <code>Synchronization</code> object registered with the
     * specified SID, <code>null</code> if no <code>Synchronization</code>
     * object has been registered under the given SID.
     * @exception SpiTransactionException thrown if the transaction manager
     * encounters an unexpected error situation.
     */
    public SpiTransactionSynchronization getRegisteredSynchronization( String syncId ) throws SpiTransactionException;


    /**
     * Returns the <code>java.sql.Connection</code> valid in the context of the
     * current ticket.
     * 
     * @return A transactional JDBC connection
     * @throws SQLException
     */
    public Connection getTxConnection( ) throws SQLException;

    /**
     * Gets a <code>java.sql.Connection</code> not related to any transaction
     * context.
     * 
     * @return A Non-transactional JDBC connection
     * @throws SQLException
     */
    public Connection getNonTxConnection( ) throws SQLException;
}
