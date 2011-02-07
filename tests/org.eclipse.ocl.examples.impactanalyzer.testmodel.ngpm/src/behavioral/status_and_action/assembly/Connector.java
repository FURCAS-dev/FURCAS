/**
 * <copyright>
 * </copyright>
 *
 * $Id: Connector.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package behavioral.status_and_action.assembly;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.Connector#getSource <em>Source</em>}</li>
 *   <li>{@link behavioral.status_and_action.assembly.Connector#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.assembly.AssemblyPackage#getConnector()
 * @model abstract="true"
 * @generated
 */
public interface Connector extends SchemaElement {
	/**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(ConnectableElement)
     * @see behavioral.status_and_action.assembly.AssemblyPackage#getConnector_Source()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='outgoing'"
     * @generated
     */
	ConnectableElement getSource();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.assembly.Connector#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
	void setSource(ConnectableElement value);

	/**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(ConnectableElement)
     * @see behavioral.status_and_action.assembly.AssemblyPackage#getConnector_Target()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='incoming'"
     * @generated
     */
	ConnectableElement getTarget();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.assembly.Connector#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
	void setTarget(ConnectableElement value);

} // Connector
