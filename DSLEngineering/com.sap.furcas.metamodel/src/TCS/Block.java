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
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Block#getBlockSequence <em>Block Sequence</em>}</li>
 *   <li>{@link TCS.Block#getBlockArgs <em>Block Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends SequenceElement {
	/**
	 * Returns the value of the '<em><b>Block Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link TCS.Sequence#getBlockContainer <em>Block Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Sequence</em>' containment reference.
	 * @see #setBlockSequence(Sequence)
	 * @see TCS.TCSPackage#getBlock_BlockSequence()
	 * @see TCS.Sequence#getBlockContainer
	 * @model opposite="blockContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Sequence getBlockSequence();

	/**
	 * Sets the value of the '{@link TCS.Block#getBlockSequence <em>Block Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Sequence</em>' containment reference.
	 * @see #getBlockSequence()
	 * @generated
	 */
	void setBlockSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Block Args</b></em>' containment reference list.
	 * The list contents are of type {@link TCS.BlockArg}.
	 * It is bidirectional and its opposite is '{@link TCS.BlockArg#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Args</em>' containment reference list.
	 * @see TCS.TCSPackage#getBlock_BlockArgs()
	 * @see TCS.BlockArg#getBlock
	 * @model opposite="block" containment="true"
	 * @generated
	 */
	EList<BlockArg> getBlockArgs();

} // Block
