/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;
import etm.core.monitor.EtmPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl#getStartPoint <em>Start Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerEndImpl extends EObjectImpl implements ExecutionTimeBenchmarkerEnd {
	private static final String ENDS_A_TIME_MEASUREMENT = "Ends a time measurement.";
	private static final String EXECUTION_TIME_BENCHMARK_END = "Execution Time Benchmark End";
	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected OptionObject option;
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ResultObject result;
	/**
	 * The cached value of the '{@link #getTestRun() <em>Test Run</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestRun()
	 * @generated
	 * @ordered
	 */
	protected TestRun testRun;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStartPoint() <em>Start Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPoint()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTimeBenchmarkerStart startPoint;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject getOption() {
		if (option != null && option.eIsProxy()) {
			InternalEObject oldOption = (InternalEObject)option;
			option = (OptionObject)eResolveProxy(oldOption);
			if (option != oldOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION, oldOption, option));
			}
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject basicGetOption() {
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(OptionObject newOption) {
		OptionObject oldOption = option;
		option = newOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION, oldOption, option));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ResultObject)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ResultObject newResult) {
		ResultObject oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (testRun != null && testRun.eIsProxy()) {
			InternalEObject oldTestRun = (InternalEObject)testRun;
			testRun = (TestRun)eResolveProxy(oldTestRun);
			if (testRun != oldTestRun) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN, oldTestRun, testRun));
			}
		}
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun basicGetTestRun() {
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		TestRun oldTestRun = testRun;
		testRun = newTestRun;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN, oldTestRun, newTestRun);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != testRun) {
			NotificationChain msgs = null;
			if (testRun != null)
				msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			if (newTestRun != null)
				msgs = ((InternalEObject)newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			msgs = basicSetTestRun(newTestRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN, newTestRun, newTestRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerStart getStartPoint() {
		if (startPoint != null && startPoint.eIsProxy()) {
			InternalEObject oldStartPoint = (InternalEObject)startPoint;
			startPoint = (ExecutionTimeBenchmarkerStart)eResolveProxy(oldStartPoint);
			if (startPoint != oldStartPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, oldStartPoint, startPoint));
			}
		}
		return startPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerStart basicGetStartPoint() {
		return startPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartPoint(ExecutionTimeBenchmarkerStart newStartPoint, NotificationChain msgs) {
		ExecutionTimeBenchmarkerStart oldStartPoint = startPoint;
		startPoint = newStartPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, oldStartPoint, newStartPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPoint(ExecutionTimeBenchmarkerStart newStartPoint) {
		if (newStartPoint != startPoint) {
			NotificationChain msgs = null;
			if (startPoint != null)
				msgs = ((InternalEObject)startPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
			if (newStartPoint != null)
				msgs = ((InternalEObject)newStartPoint).eInverseAdd(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
			msgs = basicSetStartPoint(newStartPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT, newStartPoint, newStartPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				if (testRun != null)
					msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
				return basicSetTestRun((TestRun)otherEnd, msgs);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				if (startPoint != null)
					msgs = ((InternalEObject)startPoint).eInverseRemove(this, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__END_POINT, ExecutionTimeBenchmarkerStart.class, msgs);
				return basicSetStartPoint((ExecutionTimeBenchmarkerStart)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				return basicSetTestRun(null, msgs);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				return basicSetStartPoint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION:
				if (resolve) return getOption();
				return basicGetOption();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				if (resolve) return getTestRun();
				return basicGetTestRun();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__NAME:
				return getName();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION:
				return getDescription();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				if (resolve) return getStartPoint();
				return basicGetStartPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION:
				setOption((OptionObject)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT:
				setResult((ResultObject)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__NAME:
				setName((String)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				setStartPoint((ExecutionTimeBenchmarkerStart)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION:
				setOption((OptionObject)null);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT:
				setResult((ResultObject)null);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				setStartPoint((ExecutionTimeBenchmarkerStart)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__OPTION:
				return option != null;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__RESULT:
				return result != null;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__TEST_RUN:
				return testRun != null;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END__START_POINT:
				return startPoint != null;
		}
		return super.eIsSet(featureID);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
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
		multiResult.getResults().add(collectPoint(getStartPoint().getPoint(),false));
		/*
		 * all points, which not collect yet, so no matching End notification was fired
		 */
		Collection<EtmPoint> uncollectedPoints = getStartPoint().getStringToPoint().values();
		
		for(EtmPoint p:uncollectedPoints){
			multiResult.getResults().add(collectPoint(p,true));
		}
		/*
		 * stop monitor and add successful status to the result
		 */
		getStartPoint().getMonitor().stop();
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
