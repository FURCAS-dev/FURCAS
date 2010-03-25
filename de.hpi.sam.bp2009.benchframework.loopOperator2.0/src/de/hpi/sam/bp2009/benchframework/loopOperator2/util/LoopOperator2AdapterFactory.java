/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.util;

import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.StartOperator;

import de.hpi.sam.bp2009.benchframework.loopOperator2.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package
 * @generated
 */
public class LoopOperator2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LoopOperator2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperator2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LoopOperator2Package.eINSTANCE;
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
	protected LoopOperator2Switch<Adapter> modelSwitch =
		new LoopOperator2Switch<Adapter>() {
			@Override
			public Adapter caseStartLoop(StartLoop object) {
				return createStartLoopAdapter();
			}
			@Override
			public Adapter caseEndLoop(EndLoop object) {
				return createEndLoopAdapter();
			}
			@Override
			public Adapter caseLoopOption(LoopOption object) {
				return createLoopOptionAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop <em>Start Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop
	 * @generated
	 */
	public Adapter createStartLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop <em>End Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop
	 * @generated
	 */
	public Adapter createEndLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption <em>Loop Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption
	 * @generated
	 */
	public Adapter createLoopOptionAdapter() {
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

} //LoopOperator2AdapterFactory
