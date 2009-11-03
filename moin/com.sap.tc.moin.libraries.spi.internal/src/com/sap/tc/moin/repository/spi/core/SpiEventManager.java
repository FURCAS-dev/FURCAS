package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * The EventManager is the central interface that will be used by the MOIN Core
 * and the JMI implementations when changes to the model shall be notified to
 * registered clients.
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author Daniel Vocke (D044825)
 */
public interface SpiEventManager {

    /**
     * This method is used to notify all interested (post-)ChangeListeners about
     * the change that the event describes.
     * 
     * @param event the event to deliver to clients
     */

    public void fireChangeEvent( ChangeEvent event );

    /**
     * This method is used to notify all interested PreChangeListeners about the
     * change the event describes.
     * 
     * @param event the event to deliver to clients
     */
    public void firePreChangeEvent( ChangeEvent event );

    /**
     * This method is used to notify the event framework that a command has
     * started. Upon this call the event framework collects post events which
     * will be delivered to listeners that have registered "PreCommit" and
     * "PostCommit" interfaces.
     * 
     * @param connection the command that is about to be started
     */
    public void beginCommand( Connection connection );

    /**
     * This method is used to notify the event framework that a command is about
     * to be committed. Upon this call the event framework calls listeners that
     * have registered "PreCommit" interfaces.
     * 
     * @param connection the command that is about to be committed
     */
    public void preCommitCommand( Connection connection );

    /**
     * This method is used to notify the event framework that a command has been
     * committed. Upon this call the event framework calls listeners that have
     * registered "PostCommit" interfaces.
     * 
     * @param connection the command that has been committed
     */
    public void postCommitCommand( Connection connection );

    /**
     * This method is used to notify the event framework that a command has been
     * canceled. Upon this call the event framework discards all collected
     * events.
     * 
     * @param connection the command that has been canceled
     */
    public void cancelCommand( Connection connection );

    /**
     * This method is used to notify the event framework that the events for
     * "update" shall now be collected. Upon this call the event framework
     * collects post events which will be delivered to listeners that have
     * registered "UpdateUserInterface".
     * 
     * @param connection the connection for which the events shall be gathered
     */
    public void beginUpdate( Connection connection );

    /**
     * This method is used to notify the event framework that the events for
     * "update" shall now be delivered. Upon this call the event framework
     * delivers events to listeners that have registered "UpdateUserInterface".
     * 
     * @param connection the connection for which the events shall be delivered
     */
    public void deliverUpdate( Connection connection );

    /**
     * This method is used to notify the event framework that collected events
     * for "update" shall now be discarded.
     * 
     * @param connection the connection for which the events shall be discarded
     */
    public void cancelUpdate( Connection connection );

    /**
     * Returns whether at least one event listener is currently registered.
     */
    public boolean hasListeners( );
}