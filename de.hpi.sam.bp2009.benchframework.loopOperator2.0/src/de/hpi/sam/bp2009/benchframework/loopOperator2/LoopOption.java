/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2;

import de.hpi.sam.bp2009.benchframework.OptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption#getRepetitions <em>Repetitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package#getLoopOption()
 * @model
 * @generated
 */
public interface LoopOption extends OptionObject {
	/**
	 * Returns the value of the '<em><b>Repetitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetitions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetitions</em>' attribute.
	 * @see #setRepetitions(Integer)
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package#getLoopOption_Repetitions()
	 * @model
	 * @generated
	 */
	Integer getRepetitions();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption#getRepetitions <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetitions</em>' attribute.
	 * @see #getRepetitions()
	 * @generated
	 */
	void setRepetitions(Integer value);

} // LoopOption
