/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Literal#getOperators <em>Operators</em>}</li>
 *   <li>{@link TCS.Literal#getLiteralRefs <em>Literal Refs</em>}</li>
 *   <li>{@link TCS.Literal#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getLiteral()
 * @model abstract="true"
 * @generated
 */
public interface Literal extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference list.
	 * The list contents are of type {@link TCS.Operator}.
	 * It is bidirectional and its opposite is '{@link TCS.Operator#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' reference list.
	 * @see TCS.TCSPackage#getLiteral_Operators()
	 * @see TCS.Operator#getLiteral
	 * @model opposite="literal" ordered="false"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Literal Refs</b></em>' reference list.
	 * The list contents are of type {@link TCS.LiteralRef}.
	 * It is bidirectional and its opposite is '{@link TCS.LiteralRef#getReferredLiteral <em>Referred Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Refs</em>' reference list.
	 * @see TCS.TCSPackage#getLiteral_LiteralRefs()
	 * @see TCS.LiteralRef#getReferredLiteral
	 * @model opposite="referredLiteral" ordered="false"
	 * @generated
	 */
	EList<LiteralRef> getLiteralRefs();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see TCS.TCSPackage#getLiteral_Value()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link TCS.Literal#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Literal
