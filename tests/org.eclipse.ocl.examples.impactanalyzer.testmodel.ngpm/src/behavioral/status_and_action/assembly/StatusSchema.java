/**
 * <copyright>
 * </copyright>
 *
 * $Id: StatusSchema.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package behavioral.status_and_action.assembly;

import data.classes.SapClass;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.StatusSchema#getNode <em>Node</em>}</li>
 *   <li>{@link behavioral.status_and_action.assembly.StatusSchema#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.assembly.AssemblyPackage#getStatusSchema()
 * @model
 * @generated
 */
public interface StatusSchema extends NamedElement {
	/**
     * Returns the value of the '<em><b>Node</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getBehaviouralModel <em>Behavioural Model</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Node</em>' reference.
     * @see #setNode(SapClass)
     * @see behavioral.status_and_action.assembly.AssemblyPackage#getStatusSchema_Node()
     * @see data.classes.SapClass#getBehaviouralModel
     * @model opposite="behaviouralModel"
     * @generated
     */
	SapClass getNode();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.assembly.StatusSchema#getNode <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node</em>' reference.
     * @see #getNode()
     * @generated
     */
	void setNode(SapClass value);

	/**
     * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action.assembly.SchemaElement}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Elements</em>' containment reference list.
     * @see behavioral.status_and_action.assembly.AssemblyPackage#getStatusSchema_Elements()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='schema'"
     * @generated
     */
	EList<SchemaElement> getElements();

} // StatusSchema
