/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier;

import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTimes <em>Times</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTask <em>Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getRandomModelModifierOptionObject()
 * @model
 * @generated
 */
public interface RandomModelModifierOptionObject extends RandomNumberOptionObject {
	/**
	 * Returns the value of the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Times</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Times</em>' attribute.
	 * @see #setTimes(Integer)
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getRandomModelModifierOptionObject_Times()
	 * @model
	 * @generated
	 */
	Integer getTimes();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTimes <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Times</em>' attribute.
	 * @see #getTimes()
	 * @generated
	 */
	void setTimes(Integer value);

	/**
	 * Returns the value of the '<em><b>Task</b></em>' attribute.
	 * The literals are from the enumeration {@link de.hpi.sam.bp2009.randomModelModifier.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' attribute.
	 * @see de.hpi.sam.bp2009.randomModelModifier.Task
	 * @see #setTask(Task)
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getRandomModelModifierOptionObject_Task()
	 * @model dataType="de.hpi.sam.bp2009.randomModelModifier.Task"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTask <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' attribute.
	 * @see de.hpi.sam.bp2009.randomModelModifier.Task
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

} // RandomModelModifierOptionObject
