package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

/**
 * A VetoException is thrown when a client wants to retard an action which is
 * indicated by a <b>pre-ChangeEvent </b>. Note, that a
 * <code>VetoException</code> <b>must not be thrown in the
 * {@link com.sap.tc.moin.repository.events.ChangeListener#notify(ChangeEvent)
 * notify()} method </b> of the <code>ChangeListener</code> interface < which
 * recieves only post- ChangeEvents. <b>This Exception is meant to be thrown
 * only in the
 * {@link com.sap.tc.moin.repository.events.PreChangeListener#prepare(ChangeEvent)
 * prepare()} method of the <code>PreChangeListener</code> interface </b> in
 * order to prevent the execution of the action that the event indicates. <br>
 * If the vetoed action was part of a transaction, MOIN will try to roll back
 * the whole transaction, but it is not guaranteed that the rollback will finish
 * successfully.
 */
public class VetoException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -8781761359057121249L;

    /**
     * @param reason a human readable reason why the VetoException was thrown
     */
    public VetoException( String reason ) {

        super( RepositoryCoreMessages.EVENTVETOED, reason );
    }
}