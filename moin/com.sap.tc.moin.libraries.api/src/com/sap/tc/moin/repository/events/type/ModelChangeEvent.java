package com.sap.tc.moin.repository.events.type;

/**
 * ModelChangeEvents have two traits:
 * <ul>
 * <li>they indicate a semantic change of the MOF Model</li>
 * <li>they provide information about the changes in a fine granularity</li>
 * </ul>
 * The fine grained informations about the indicated change are defined /
 * provided by the concrete subtype of this interface.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface ModelChangeEvent extends ChangeEvent {
}