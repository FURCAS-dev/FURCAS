/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart;
import de.hpi.sam.bp2009.benchframework.impl.EndOperatorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EventCounterEndImpl extends EndOperatorImpl implements EventCounterEnd {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventCounterEndImpl() {
		super();
		setName("Event Counter End");
		setDescription("Ends a event measurement.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventCounterPackage.Literals.EVENT_COUNTER_END;
	}

	@Override
	public void execute(){
		//remove the adapter of the start point
		Adapter adapter = ((EventCounterStart)getStartOperator()).getAdapter();
		adapter.getTarget().eAdapters().remove(adapter);
		
		//set the result message and the status
		EventCounterResultObject rslt = (EventCounterResultObject)((EventCounterStart)getStartOperator()).getResult();
		rslt.setStatus(Status.SUCCESSFUL);
		String msg = "";
		for (String key : rslt.getEventCounts().keySet()){
			msg += key + " " + rslt.getEventCounts().get(key).toString() + "; ";
		}
		rslt.setMessage(msg);
		setResult(rslt);
	}

} //ExecutionTimeBenchmarkerEndImpl
