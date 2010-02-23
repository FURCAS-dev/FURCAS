/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter;

import de.hpi.sam.bp2009.benchframework.Operator;
import org.eclipse.emf.common.notify.Adapter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This operator starts execution time measurement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getCount <em>Count</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getAdapter <em>Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterStart()
 * @model
 * @generated
 */
public interface EventCounterStart extends Operator {
	/**
	 * Returns the value of the '<em><b>End Point</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint <em>Start Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Point</em>' reference.
	 * @see #setEndPoint(EventCounterEnd)
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterStart_EndPoint()
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd#getStartPoint
	 * @model opposite="startPoint"
	 * @generated
	 */
	EventCounterEnd getEndPoint();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getEndPoint <em>End Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Point</em>' reference.
	 * @see #getEndPoint()
	 * @generated
	 */
	void setEndPoint(EventCounterEnd value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#getEventCounterStart_Count()
	 * @model
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

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
