/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Separator PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.SeparatorPArg#getSeparatorSequence <em>Separator Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getSeparatorPArg()
 * @model
 * @generated
 */
public interface SeparatorPArg extends PropertyArg {
	/**
	 * Returns the value of the '<em><b>Separator Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link TCS.Sequence#getSeparatorContainer <em>Separator Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Separator Sequence</em>' containment reference.
	 * @see #setSeparatorSequence(Sequence)
	 * @see TCS.TCSPackage#getSeparatorPArg_SeparatorSequence()
	 * @see TCS.Sequence#getSeparatorContainer
	 * @model opposite="separatorContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Sequence getSeparatorSequence();

	/**
	 * Sets the value of the '{@link TCS.SeparatorPArg#getSeparatorSequence <em>Separator Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator Sequence</em>' containment reference.
	 * @see #getSeparatorSequence()
	 * @generated
	 */
	void setSeparatorSequence(Sequence value);

} // SeparatorPArg
