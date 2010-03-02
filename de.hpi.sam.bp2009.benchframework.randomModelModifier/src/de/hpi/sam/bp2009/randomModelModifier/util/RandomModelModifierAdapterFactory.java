/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.util;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;

import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage
 * @generated
 */
public class RandomModelModifierAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RandomModelModifierPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomModelModifierAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RandomModelModifierPackage.eINSTANCE;
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
	protected RandomModelModifierSwitch<Adapter> modelSwitch =
		new RandomModelModifierSwitch<Adapter>() {
			@Override
			public Adapter caseRandomModelModifier(RandomModelModifier object) {
				return createRandomModelModifierAdapter();
			}
			@Override
			public Adapter caseRandomModelModifierOptionObject(RandomModelModifierOptionObject object) {
				return createRandomModelModifierOptionObjectAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseOptionObject(OptionObject object) {
				return createOptionObjectAdapter();
			}
			@Override
			public Adapter caseRandomNumberOptionObject(RandomNumberOptionObject object) {
				return createRandomNumberOptionObjectAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier <em>Random Model Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier
	 * @generated
	 */
	public Adapter createRandomModelModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject
	 * @generated
	 */
	public Adapter createRandomModelModifierOptionObjectAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject <em>Random Number Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject
	 * @generated
	 */
	public Adapter createRandomNumberOptionObjectAdapter() {
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

} //RandomModelModifierAdapterFactory
