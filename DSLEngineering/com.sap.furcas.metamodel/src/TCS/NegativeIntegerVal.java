/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negative Integer Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.NegativeIntegerVal#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getNegativeIntegerVal()
 * @model
 * @generated
 */
public interface NegativeIntegerVal extends Value {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(int)
	 * @see TCS.TCSPackage#getNegativeIntegerVal_Symbol()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getSymbol();

	/**
	 * Sets the value of the '{@link TCS.NegativeIntegerVal#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(int value);

} // NegativeIntegerVal
