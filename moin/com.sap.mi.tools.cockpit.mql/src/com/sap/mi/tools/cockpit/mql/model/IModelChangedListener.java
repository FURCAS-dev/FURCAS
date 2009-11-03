package com.sap.mi.tools.cockpit.mql.model;

/**
 * @author d003456
 * 
 *@noimplement This interface is not intended to be implemented by clients.
 */
public interface IModelChangedListener {

	public void modelChanged(Object obj, OP operation);

}
