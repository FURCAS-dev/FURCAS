/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage
 * @generated
 */
public class ExecutionTimeBenchmarkerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionTimeBenchmarkerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExecutionTimeBenchmarkerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTimeBenchmarkerSwitch<Adapter> modelSwitch =
		new ExecutionTimeBenchmarkerSwitch<Adapter>() {
			@Override
			public Adapter caseExecutionTimeBenchmarkerStart(ExecutionTimeBenchmarkerStart object) {
				return createExecutionTimeBenchmarkerStartAdapter();
			}
			@Override
			public Adapter caseExecutionTimeBenchmarkerEnd(ExecutionTimeBenchmarkerEnd object) {
				return createExecutionTimeBenchmarkerEndAdapter();
			}
			@Override
			public Adapter caseJETMResultObject(JETMResultObject object) {
				return createJETMResultObjectAdapter();
			}
			@Override
			public Adapter caseExecutionTimeBenchmarkerOptionObject(ExecutionTimeBenchmarkerOptionObject object) {
				return createExecutionTimeBenchmarkerOptionObjectAdapter();
			}
			@Override
			public Adapter caseJETMMultiResultObject(JETMMultiResultObject object) {
				return createJETMMultiResultObjectAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseStartOperator(StartOperator object) {
				return createStartOperatorAdapter();
			}
			@Override
			public Adapter caseEndOperator(EndOperator object) {
				return createEndOperatorAdapter();
			}
			@Override
			public Adapter caseResultObject(ResultObject object) {
				return createResultObjectAdapter();
			}
			@Override
			public Adapter caseOptionObject(OptionObject object) {
				return createOptionObjectAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart
	 * @generated
	 */
	public Adapter createExecutionTimeBenchmarkerStartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd
	 * @generated
	 */
	public Adapter createExecutionTimeBenchmarkerEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject <em>JETM Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject
	 * @generated
	 */
	public Adapter createJETMResultObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject
	 * @generated
	 */
	public Adapter createExecutionTimeBenchmarkerOptionObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject <em>JETM Multi Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject
	 * @generated
	 */
	public Adapter createJETMMultiResultObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.StartOperator <em>Start Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.StartOperator
	 * @generated
	 */
	public Adapter createStartOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.EndOperator <em>End Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.EndOperator
	 * @generated
	 */
	public Adapter createEndOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.ResultObject <em>Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.ResultObject
	 * @generated
	 */
	public Adapter createResultObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.OptionObject
	 * @generated
	 */
	public Adapter createOptionObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExecutionTimeBenchmarkerAdapterFactory
