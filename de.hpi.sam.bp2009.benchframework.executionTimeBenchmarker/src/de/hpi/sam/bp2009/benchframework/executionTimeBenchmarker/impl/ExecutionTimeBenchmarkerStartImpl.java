/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals;
import de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getMonitor <em>Monitor</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl#getStringToPoint <em>String To Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerStartImpl extends StartOperatorImpl implements ExecutionTimeBenchmarkerStart {
	/**
	 * The default value of the '{@link #getMonitor() <em>Monitor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitor()
	 * @generated
	 * @ordered
	 */
	protected static final EtmMonitor MONITOR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMonitor() <em>Monitor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitor()
	 * @generated
	 * @ordered
	 */
	protected EtmMonitor monitor = MONITOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected static final EtmPoint POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected EtmPoint point = POINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStringToPoint() <em>String To Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringToPoint()
	 * @generated
	 * @ordered
	 */
	protected Map<String, EtmPoint> stringToPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionTimeBenchmarkerStartImpl() {
		super();
		ExecutionTimeBenchmarkerOptionObject options = ExecutionTimeBenchmarkerFactory.eINSTANCE.createExecutionTimeBenchmarkerOptionObject();
		basicSetOption(options,null);
		setName("Execution Time Benchmark Start");
		setDescription("Starts a time measurement.");
		ExecutionTimeBenchmarkerEnd end = ExecutionTimeBenchmarkerFactory.eINSTANCE.createExecutionTimeBenchmarkerEnd();
		setEndOperator(end); //setStartPoint is the EOpposite of this reference, we don't need to set it explicitly
		end.setOption(options);
		setStringToPoint(new HashMap<String, EtmPoint>());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmMonitor getMonitor() {
		return monitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitor(EtmMonitor newMonitor) {
		EtmMonitor oldMonitor = monitor;
		monitor = newMonitor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR, oldMonitor, monitor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmPoint getPoint() {
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoint(EtmPoint newPoint) {
		EtmPoint oldPoint = point;
		point = newPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT, oldPoint, point));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, EtmPoint> getStringToPoint() {
		return stringToPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringToPoint(Map<String, EtmPoint> newStringToPoint) {
		Map<String, EtmPoint> oldStringToPoint = stringToPoint;
		stringToPoint = newStringToPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT, oldStringToPoint, stringToPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				return getMonitor();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				return getPoint();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT:
				return getStringToPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				setMonitor((EtmMonitor)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				setPoint((EtmPoint)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT:
				setStringToPoint((Map<String, EtmPoint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		if(getEndOperator()!=null)
			getEndOperator().setTestRun(newTestRun);
		msgs = eBasicSetContainer((InternalEObject)newTestRun, BenchframeworkPackage.START_OPERATOR__TEST_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				setMonitor(MONITOR_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			//make sure start and endpoint reference the same testrun
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__TEST_RUN:
				setTestRun(null);
				if(getEndOperator()!=null)
					getEndOperator().setTestRun(null);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__MONITOR:
				return MONITOR_EDEFAULT == null ? monitor != null : !MONITOR_EDEFAULT.equals(monitor);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT:
				return stringToPoint != null;
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
		result.append(" (monitor: ");
		result.append(monitor);
		result.append(", point: ");
		result.append(point);
		result.append(", stringToPoint: ");
		result.append(stringToPoint);
		result.append(')');
		return result.toString();
	}
	
	/* not sure if ETMMonitor is a singleton...might lead to problems when using more than one ExecutionTimeBenchmarker
	 * @see de.hpi.sam.bp2009.benchframework.impl.OperatorImpl#execute()
	 */
	@Override
	public void execute() {
		//reset results of the endpoint
		getEndOperator().setResult(null);
		BasicEtmConfigurator.configure();
		setMonitor(EtmManager.getEtmMonitor());
		getMonitor().start();
		setPoint(monitor.createPoint(UUID.randomUUID().toString()));
		final ExecutionTimeBenchmarkerOptionObject opt=(ExecutionTimeBenchmarkerOptionObject)option;
		if (opt.getEndLiteral()!=null && opt.getStartLiteral()!=null && opt.getClassLiteral()!=null){
			Notifier noti=null;
			if(opt.getClassLiteral().compareTo(MeasurableClassLiterals.EVENT_MANAGER_VALUE)==0 && getTestRun().getInstanceForClass(EventManager.class) != null)
				noti=(Notifier) getTestRun().getInstanceForClass(EventManager.class);
			else if (opt.getClassLiteral().compareTo(MeasurableClassLiterals.IMPACT_ANALYZER_VALUE)==0 && getTestRun().getInstanceForClass(ImpactAnalyzer.class) != null) {
				noti=(Notifier) getTestRun().getInstanceForClass(ImpactAnalyzer.class);
			}
			else if (opt.getClassLiteral().compareTo(MeasurableClassLiterals.OCL_EVALUATOR_VALUE)==0 && getTestRun().getInstanceForClass(QueryEvaluator.class) != null) {
				noti=(Notifier) getTestRun().getInstanceForClass(QueryEvaluator.class);
			}
			else {
				ResultObject rslt = BenchframeworkFactory.eINSTANCE.createResultObject();
				rslt.setStatus(Status.SUCCESSFUL);
				rslt.setMessage("Unknown Class Literal, just measure time to end point");
				setResult(rslt);
				return;
			}

			noti.eAdapters().add(new Adapter() {
				
				@Override
				public void setTarget(Notifier newTarget) {
				}
				
				@Override
				public void notifyChanged(Notification notification) {
					if(notification.getEventType() == opt.getStartLiteral()){
						createNewPoint(notification);						
					}else if(notification.getEventType() == opt.getEndLiteral() &&notification.getOldValue()!=null){
						collectPoint(notification);
					}
					
				}

				/**
				 * Collect a point, create from this point a new Result object, and add the Result to the Result of the end point
				 * @param notification
				 */
				private void collectPoint(Notification notification) {
					EtmPoint p=getStringToPoint().get(notification.getOldStringValue());
					if(p==null)
						return;
					p.collect();
					JETMResultObject r = ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMResultObject();
					r.setEndTime(p.getEndTime());
					r.setStartTime(p.getStartTime());
					r.setTicks(p.getTicks());
					r.setTransactionTime(p.getTransactionTime());
					r.setStatus(Status.SUCCESSFUL);
					r.setMessage("Point collected: " +notification.getNewStringValue() +"\nid:"+ notification.getOldStringValue());
					if(!(getEndOperator().getResult()!=null && getEndOperator().getResult() instanceof JETMMultiResultObject)){
						getEndOperator().setResult(ExecutionTimeBenchmarkerFactory.eINSTANCE.createJETMMultiResultObject());
					}
					((JETMMultiResultObject)getEndOperator().getResult()).getResults().add(r);
					getStringToPoint().remove(notification.getOldStringValue());
				}

				/**
				 * Create a new point with the UUID from the notification or a new one
				 * @param notification
				 */
				private void createNewPoint(Notification notification) {
					String uuid = UUID.randomUUID().toString();
					if(notification.getOldValue()!=null){
						uuid= notification.getOldStringValue();
					}
					EtmPoint startPoint = getMonitor().createPoint(notification.getNewStringValue() + "#####" + uuid);
					getStringToPoint().put(uuid, startPoint);
				}
				
				@Override
				public boolean isAdapterForType(Object type) {
					return false;
				}
				
				@Override
				public Notifier getTarget() {
					return null;
				}
			});
			
		}
			
		ResultObject rslt = BenchframeworkFactory.eINSTANCE.createResultObject();
		rslt.setStatus(Status.SUCCESSFUL);
		rslt.setMessage("Monitor started!");
		setResult(rslt);
	}

	@Override
	public EndOperator createEndOperator() {
		
		return ExecutionTimeBenchmarkerFactory.eINSTANCE.createExecutionTimeBenchmarkerEnd();
	}


} //ExecutionTimeBenchmarkerStartImpl
