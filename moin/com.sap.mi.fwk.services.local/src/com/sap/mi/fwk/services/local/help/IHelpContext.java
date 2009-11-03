package com.sap.mi.fwk.services.local.help;

/**
 * Protocol for help contexts, identified by their id. Not intended to be used
 * and implemented outside the MiE project.
 * 
 * @author d031150
 */
public interface IHelpContext {

	/**
	 * @return the fully qualified id of the help context, i.e. including the
	 *         plugin id
	 */
	String getId();

}
