/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;
import de.hpi.sam.bp2009.benchframework.impl.EndOperatorImpl;
import etm.core.monitor.EtmPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerEndImpl extends EndOperatorImpl implements ExecutionTimeBenchmarkerEnd {
	private static final String ENDS_A_TIME_MEASUREMENT = "Ends a time measurement.";
	private static final String EXECUTION_TIME_BENCHMARK_END = "Execution Time Benchmark End";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionTimeBenchmarkerEndImpl() {
		super();
		setName(EXECUTION_TIME_BENCHMARK_END);
		setDescription(ENDS_A_TIME_MEASUREMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER_END;
	}

	/* (non-Javadoc)
	 * @see de.hpi.sam.bp2009.benchframework.Operator#execute()
	 */
	@Override
	public void execute(){
		
		/*
		 * Ensure that result is a multi result object
		 */
		if(!(getResult()!=null && getResult() instanceof JETMMultiResultObject)){
			setResult(ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMMultiResultObject());
		}
		JETMMultiResultObject multiResult = (JETMMultiResultObject)getResult();
		
		/*
		 * Collect the start point (of the start operator, which symbolize the start of the measurement at all)
		 */
		multiResult.getResults().add(collectPoint(((ExecutionTimeBenchmarkerStart)getStartOperator()).getPoint(),false));
		/*
		 * all points, which not collect yet, so no matching End notification was fired
		 */
		Collection<EtmPoint> uncollectedPoints = ((ExecutionTimeBenchmarkerStart)getStartOperator()).getStringToPoint().values();
		
		for(EtmPoint p:uncollectedPoints){
			multiResult.getResults().add(collectPoint(p,true));
		}
		/*
		 * stop monitor and add successful status to the result
		 */
		((ExecutionTimeBenchmarkerStart)getStartOperator()).getMonitor().stop();
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Monitor stopped!");
	}

	/**
	 * Collect a point and map all relevant info to a new result object, which is returned
	 * @param point the point to collect
	 * @return the new ResultObject
	 */
	private JETMResultObject collectPoint(EtmPoint point, boolean aborted) {
		point.collect();
		JETMResultObject rslt = ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMResultObject();
		rslt.setStartTime(point.getStartTime());
		rslt.setEndTime(point.getEndTime());
		rslt.setTicks(point.getTicks());
		rslt.setTransactionTime(point.getTransactionTime());
		if(aborted){
			rslt.setStatus(Status.FAILED);
			rslt.setMessage("Point collection aborted: "+point.getName().replaceAll("#####", "\nid:"));
		}
		else{
			rslt.setStatus(Status.SUCCESSFUL);
			//if you like to show the uuid of the point just comment out the next line
			//rslt.setMessage("Point collected: "+point.getName().replaceAll("#####", "\n  id:"));
		}

		return rslt;
	}

} //ExecutionTimeBenchmarkerEndImpl
