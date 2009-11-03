package com.sap.tc.moin.repository.commands;

/**
 * Represents an executed Command and a closed Command Group. Returned by
 * {@link CommandStack#execute(Command)} and {@link CommandStack#closeGroup()}.
 * 
 * @author d045996
 *<p>
 * @noimplement This interface is not intended to be implemented by clients.
 */

public interface CommandHandle {

    /**
     * @return the description of the command that was executed
     */
    public String getDescription( );

}
