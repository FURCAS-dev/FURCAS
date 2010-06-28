/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Auto Create PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.AutoCreatePArg#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getAutoCreatePArg()
 * @model
 * @generated
 */
public interface AutoCreatePArg extends PropertyArg {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link TCS.AutoCreateKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see TCS.AutoCreateKind
	 * @see #setValue(AutoCreateKind)
	 * @see TCS.TCSPackage#getAutoCreatePArg_Value()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	AutoCreateKind getValue();

	/**
	 * Sets the value of the '{@link TCS.AutoCreatePArg#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see TCS.AutoCreateKind
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AutoCreateKind value);

} // AutoCreatePArg
