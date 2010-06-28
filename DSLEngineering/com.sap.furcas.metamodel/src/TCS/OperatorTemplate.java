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
 * A representation of the model object '<em><b>Operator Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.OperatorTemplate#getOperators <em>Operators</em>}</li>
 *   <li>{@link TCS.OperatorTemplate#getSource <em>Source</em>}</li>
 *   <li>{@link TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}</li>
 *   <li>{@link TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}</li>
 *   <li>{@link TCS.OperatorTemplate#getOtSequence <em>Ot Sequence</em>}</li>
 *   <li>{@link TCS.OperatorTemplate#isIsContext <em>Is Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getOperatorTemplate()
 * @model
 * @generated
 */
public interface OperatorTemplate extends Template {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference list.
	 * The list contents are of type {@link TCS.Operator}.
	 * It is bidirectional and its opposite is '{@link TCS.Operator#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' reference list.
	 * @see TCS.TCSPackage#getOperatorTemplate_Operators()
	 * @see TCS.Operator#getTemplates
	 * @model opposite="templates" ordered="false"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see TCS.TCSPackage#getOperatorTemplate_Source()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link TCS.OperatorTemplate#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Store Op To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Op To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Op To</em>' attribute.
	 * @see #setStoreOpTo(String)
	 * @see TCS.TCSPackage#getOperatorTemplate_StoreOpTo()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getStoreOpTo();

	/**
	 * Sets the value of the '{@link TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Op To</em>' attribute.
	 * @see #getStoreOpTo()
	 * @generated
	 */
	void setStoreOpTo(String value);

	/**
	 * Returns the value of the '<em><b>Store Right To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Right To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Right To</em>' attribute.
	 * @see #setStoreRightTo(String)
	 * @see TCS.TCSPackage#getOperatorTemplate_StoreRightTo()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getStoreRightTo();

	/**
	 * Sets the value of the '{@link TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Right To</em>' attribute.
	 * @see #getStoreRightTo()
	 * @generated
	 */
	void setStoreRightTo(String value);

	/**
	 * Returns the value of the '<em><b>Ot Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link TCS.Sequence#getOtContainer <em>Ot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ot Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ot Sequence</em>' containment reference.
	 * @see #setOtSequence(Sequence)
	 * @see TCS.TCSPackage#getOperatorTemplate_OtSequence()
	 * @see TCS.Sequence#getOtContainer
	 * @model opposite="otContainer" containment="true" ordered="false"
	 * @generated
	 */
	Sequence getOtSequence();

	/**
	 * Sets the value of the '{@link TCS.OperatorTemplate#getOtSequence <em>Ot Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ot Sequence</em>' containment reference.
	 * @see #getOtSequence()
	 * @generated
	 */
	void setOtSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Is Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Context</em>' attribute.
	 * @see #setIsContext(boolean)
	 * @see TCS.TCSPackage#getOperatorTemplate_IsContext()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsContext();

	/**
	 * Sets the value of the '{@link TCS.OperatorTemplate#isIsContext <em>Is Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Context</em>' attribute.
	 * @see #isIsContext()
	 * @generated
	 */
	void setIsContext(boolean value);

} // OperatorTemplate
