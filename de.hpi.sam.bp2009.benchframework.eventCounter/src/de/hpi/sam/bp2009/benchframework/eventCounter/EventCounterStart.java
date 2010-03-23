/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import org.eclipse.emf.common.notify.Adapter;

import de.hpi.sam.bp2009.benchframework.StartOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This operator starts event counting. It holds a map from string to int to identify the different types of events e.g. incoming events, mapped internal events, events sent to a specific application or thelike.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getAdapter <em>Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterStart()
 * @model
 * @generated
 */
public interface EventCounterStart extends StartOperator {
	/**
	 * Returns the value of the '<em><b>Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter</em>' attribute.
	 * @see #setAdapter(Adapter)
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterStart_Adapter()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.eventCounter.Adapter"
	 * @generated
	 */
	Adapter getAdapter();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getAdapter <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter</em>' attribute.
	 * @see #getAdapter()
	 * @generated
	 */
	void setAdapter(Adapter value);

} // EventCounterStart
