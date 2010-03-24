/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator;

import de.hpi.sam.bp2009.benchframework.OptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getLoopCount <em>Loop Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage#getLoopOperatorOptionObject()
 * @model
 * @generated
 */
public interface LoopOperatorOptionObject extends OptionObject {
	/**
	 * Returns the value of the '<em><b>Loop Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Count</em>' attribute.
	 * @see #setLoopCount(int)
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage#getLoopOperatorOptionObject_LoopCount()
	 * @model
	 * @generated
	 */
	int getLoopCount();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getLoopCount <em>Loop Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Count</em>' attribute.
	 * @see #getLoopCount()
	 * @generated
	 */
	void setLoopCount(int value);

} // LoopOperatorOptionObject
