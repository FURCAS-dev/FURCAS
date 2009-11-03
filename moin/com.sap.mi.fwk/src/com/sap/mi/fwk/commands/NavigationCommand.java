package com.sap.mi.fwk.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * A convenience base class for a command that tells about an object
 * that should be navigated to after its execution.
 * 
 * @author d023588
 * @author d031150
 */
public abstract class NavigationCommand extends Command {

	/**
	 * Creates a command
	 * 
	 * @param connection the connection for the command
	 */
	public NavigationCommand(Connection connection) {
		super(connection);
	}

	/**
	 * Creates a command
	 * 
	 * @param connection the connection for the command
	 * @param description the description for the command
	 */
	public NavigationCommand(Connection connection, String description) {
		super(connection, description);
	}

	/**
	 * @return an object that should be used for the navigation to e.g. an
	 *         editor. Note that calling this method before the command has been
	 *         executed has undefined results.
	 */
	public abstract RefBaseObject getNavigationObject();

	/**
	 * @return <code>true</code> by default
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/**
	 * @return <code>null</code> by default
	 */
	public Collection<PartitionOperation> getAffectedPartitions() {
		return null;
	}		
	
}
