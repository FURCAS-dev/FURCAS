/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.AtomExp#getAndExp <em>And Exp</em>}</li>
 *   <li>{@link TCS.AtomExp#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getAtomExp()
 * @model abstract="true"
 * @generated
 */
public interface AtomExp extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>And Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link TCS.AndExp#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>And Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>And Exp</em>' container reference.
	 * @see #setAndExp(AndExp)
	 * @see TCS.TCSPackage#getAtomExp_AndExp()
	 * @see TCS.AndExp#getExpressions
	 * @model opposite="expressions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	AndExp getAndExp();

	/**
	 * Sets the value of the '{@link TCS.AtomExp#getAndExp <em>And Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>And Exp</em>' container reference.
	 * @see #getAndExp()
	 * @generated
	 */
	void setAndExp(AndExp value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see TCS.TCSPackage#getAtomExp_PropertyName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link TCS.AtomExp#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

} // AtomExp