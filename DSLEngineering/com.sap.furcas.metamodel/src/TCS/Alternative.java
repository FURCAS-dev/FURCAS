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
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Alternative#getSequences <em>Sequences</em>}</li>
 *   <li>{@link TCS.Alternative#isIsMulti <em>Is Multi</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends SequenceElement {
	/**
	 * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link TCS.Sequence}.
	 * It is bidirectional and its opposite is '{@link TCS.Sequence#getAlternativeContainer <em>Alternative Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequences</em>' containment reference list.
	 * @see TCS.TCSPackage#getAlternative_Sequences()
	 * @see TCS.Sequence#getAlternativeContainer
	 * @model opposite="alternativeContainer" containment="true" lower="2"
	 * @generated
	 */
	EList<Sequence> getSequences();

	/**
	 * Returns the value of the '<em><b>Is Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Multi</em>' attribute.
	 * @see #setIsMulti(boolean)
	 * @see TCS.TCSPackage#getAlternative_IsMulti()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMulti();

	/**
	 * Sets the value of the '{@link TCS.Alternative#isIsMulti <em>Is Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multi</em>' attribute.
	 * @see #isIsMulti()
	 * @generated
	 */
	void setIsMulti(boolean value);

} // Alternative
