package com.sap.mi.fwk;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

import com.sap.tc.moin.repository.Connection;


/**
 * @author D020964
 * 
 * The <code>PartitionAlreadyModifiedException</code> is thrown when preparing a MOIN command execution fails
 * because there are other connections that lock the affected partitions.
 *
 */
public class PartitionAlreadyModifiedException extends Exception {

    private static final long serialVersionUID = -5327400052559452396L;

    private Collection<Connection> conflictingConnections = new ArrayList<Connection>();
    private IStatus status;
    
    public PartitionAlreadyModifiedException(Collection<Connection> connections, IStatus status) {
    	conflictingConnections.addAll(connections);
    	this.status = status;
    }
    
    /**
     * @return The method returns a list of connections that lock the affected partitions
     */
    public Collection<Connection> getConflictingConnections() {
        return conflictingConnections;
    }

    /**
     * @return The method returns an IStatus object describing the conflicting connections
     */    
    public IStatus getStatus() {
        return status;
    }
}
