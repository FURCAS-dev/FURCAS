/**
 * This package contains the basis interfaces provided by the EventFramework. <br>
 * <ul>
 * <li>The listener interfaces, to be implemented by the client</li>
 * <li>The interfaces for registration and firing of events</li>
 * </ul>
 * <b>A brief overview on the most important interfaces:</b><br>
 * <br>
 * <b>PreChangeListener</b>: PreChangeListeners are notified before a change to
 * the model was made. This fact gives the listener a chance to veto the
 * operation using the veto(String reason) method on the event itself.
 * PreChangeListeners are not allowed to perform side effects on the model.<br>
 * <b>ChangeListener</b>: ChangeListeners are notified after a change to the
 * model has successfully been executed, but before the modification is
 * committed. At the moment, modification of the model are not possible.<br>
 * <b>PreCommitListener</b>: A PreCommitListener is notified before a command is
 * being committed. The listener will get an <code>EventChain</code> which
 * contains all events that were fired during the execution of the command.
 * Analog to the PreChangeListener, the PreCommitListener is also able to veto,
 * but it is not able to change the model in any way. A veto at this point of
 * time will result in a roll-back / undo of the command.<br>
 * <b>CommitListener</b>: CommitListeners are notified after a command could
 * successfully be committed. Of course, no veto is possible at this time.
 * Changes to the model are allowed, but they will not be associated to the
 * committed command, so an undo will not undo the changes made by this type of
 * listener.<br>
 * <br>
 * <b>EventManager</b>: This interface will only be used by the repository core.
 * It provides functionality to fire events and to notify the EventFramework
 * about commands.<br>
 * <b>EventRegistry</b>: This interface can be used to register and deregister
 * listeners.<br>
 * <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.events;

