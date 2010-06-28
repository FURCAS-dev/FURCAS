/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.SequenceElement#getElementSequence <em>Element Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getSequenceElement()
 * @model abstract="true"
 * @generated
 */
public interface SequenceElement extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Element Sequence</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link TCS.Sequence#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Sequence</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Sequence</em>' container reference.
	 * @see #setElementSequence(Sequence)
	 * @see TCS.TCSPackage#getSequenceElement_ElementSequence()
	 * @see TCS.Sequence#getElements
	 * @model opposite="elements" transient="false" ordered="false"
	 * @generated
	 */
	Sequence getElementSequence();

	/**
	 * Sets the value of the '{@link TCS.SequenceElement#getElementSequence <em>Element Sequence</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Sequence</em>' container reference.
	 * @see #getElementSequence()
	 * @generated
	 */
	void setElementSequence(Sequence value);

} // SequenceElement
