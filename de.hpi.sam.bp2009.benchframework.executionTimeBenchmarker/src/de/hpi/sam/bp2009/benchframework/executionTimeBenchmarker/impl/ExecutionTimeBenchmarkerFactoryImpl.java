/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.*;

import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionTimeBenchmarkerFactoryImpl extends EFactoryImpl implements ExecutionTimeBenchmarkerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionTimeBenchmarkerFactory init() {
		try {
			ExecutionTimeBenchmarkerFactory theExecutionTimeBenchmarkerFactory = (ExecutionTimeBenchmarkerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker"); 
			if (theExecutionTimeBenchmarkerFactory != null) {
				return theExecutionTimeBenchmarkerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExecutionTimeBenchmarkerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_START: return createExecutionTimeBenchmarkerStart();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_END: return createExecutionTimeBenchmarkerEnd();
			case ExecutionTimeBenchmarkerPackage.JETM_RESULT_OBJECT: return createJETMResultObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionTimeBenchmarkerPackage.ETM_MONITOR:
				return createETMMonitorFromString(eDataType, initialValue);
			case ExecutionTimeBenchmarkerPackage.ETM_POINT:
				return createETMPointFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionTimeBenchmarkerPackage.ETM_MONITOR:
				return convertETMMonitorToString(eDataType, instanceValue);
			case ExecutionTimeBenchmarkerPackage.ETM_POINT:
				return convertETMPointToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerStart createExecutionTimeBenchmarkerStart() {
		ExecutionTimeBenchmarkerStartImpl executionTimeBenchmarkerStart = new ExecutionTimeBenchmarkerStartImpl();
		return executionTimeBenchmarkerStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerEnd createExecutionTimeBenchmarkerEnd() {
		ExecutionTimeBenchmarkerEndImpl executionTimeBenchmarkerEnd = new ExecutionTimeBenchmarkerEndImpl();
		return executionTimeBenchmarkerEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JETMResultObject createJETMResultObject() {
		JETMResultObjectImpl jetmResultObject = new JETMResultObjectImpl();
		return jetmResultObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmMonitor createETMMonitorFromString(EDataType eDataType, String initialValue) {
		return (EtmMonitor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETMMonitorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtmPoint createETMPointFromString(EDataType eDataType, String initialValue) {
		return (EtmPoint)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETMPointToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerPackage getExecutionTimeBenchmarkerPackage() {
		return (ExecutionTimeBenchmarkerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionTimeBenchmarkerPackage getPackage() {
		return ExecutionTimeBenchmarkerPackage.eINSTANCE;
	}

} //ExecutionTimeBenchmarkerFactoryImpl
