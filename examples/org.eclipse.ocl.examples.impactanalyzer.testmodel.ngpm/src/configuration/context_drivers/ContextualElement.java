/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextualElement.java,v 1.1 2011/02/07 16:48:25 auhl Exp $
 */
package configuration.context_drivers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contextual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.context_drivers.ContextualElement#getContextualElementConfiguration <em>Contextual Element Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.context_drivers.Context_driversPackage#getContextualElement()
 * @model
 * @generated
 */
public interface ContextualElement extends EObject {
	/**
     * Returns the value of the '<em><b>Contextual Element Configuration</b></em>' containment reference list.
     * The list contents are of type {@link configuration.context_drivers.ContexConfiguration}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContexConfiguration#getConfiguredElement <em>Configured Element</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contextual Element Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Contextual Element Configuration</em>' containment reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContextualElement_ContextualElementConfiguration()
     * @see configuration.context_drivers.ContexConfiguration#getConfiguredElement
     * @model opposite="configuredElement" containment="true" resolveProxies="true"
     * @generated
     */
	EList<ContexConfiguration> getContextualElementConfiguration();

} // ContextualElement
