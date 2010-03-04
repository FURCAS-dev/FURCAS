/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start And End Operator Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject#getOtherEnd <em>Other End</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getStartAndEndOperatorOptionObject()
 * @model
 * @generated
 */
public interface StartAndEndOperatorOptionObject extends OptionObject {
	/**
	 * Returns the value of the '<em><b>Other End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other End</em>' reference.
	 * @see #setOtherEnd(Operator)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getStartAndEndOperatorOptionObject_OtherEnd()
	 * @model
	 * @generated
	 */
	Operator getOtherEnd();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject#getOtherEnd <em>Other End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other End</em>' reference.
	 * @see #getOtherEnd()
	 * @generated
	 */
	void setOtherEnd(Operator value);

} // StartAndEndOperatorOptionObject
