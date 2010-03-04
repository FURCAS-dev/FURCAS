/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getLoopCount <em>Loop Count</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage#getLoopOperatorOptionObject()
 * @model
 * @generated
 */
public interface LoopOperatorOptionObject extends StartAndEndOperatorOptionObject {
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

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' reference.
	 * @see #setOperator(Operator)
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage#getLoopOperatorOptionObject_Operator()
	 * @model
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getOperator <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

} // LoopOperatorOptionObject
