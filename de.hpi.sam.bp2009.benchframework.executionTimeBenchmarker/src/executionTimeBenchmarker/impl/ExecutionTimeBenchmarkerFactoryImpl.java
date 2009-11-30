/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker.impl;

import executionTimeBenchmarker.*;

import org.eclipse.emf.ecore.EClass;
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER: return createExecutionTimeBenchmarker();
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
	public ExecutionTimeBenchmarker createExecutionTimeBenchmarker() {
		ExecutionTimeBenchmarkerImpl executionTimeBenchmarker = new ExecutionTimeBenchmarkerImpl();
		return executionTimeBenchmarker;
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
