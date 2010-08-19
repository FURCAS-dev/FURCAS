/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.context_drivers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.context_drivers.ContextCategory#getName <em>Name</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategory#getRootValue <em>Root Value</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategory#getCategoryConfiguration <em>Category Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.context_drivers.Context_driversPackage#getContextCategory()
 * @model
 * @generated
 */
public interface ContextCategory extends EObject {
	/**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see configuration.context_drivers.Context_driversPackage#getContextCategory_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContextCategory#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Root Value</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategoryValue#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Root Value</em>' containment reference.
     * @see #setRootValue(ContextCategoryValue)
     * @see configuration.context_drivers.Context_driversPackage#getContextCategory_RootValue()
     * @see configuration.context_drivers.ContextCategoryValue#getContext
     * @model opposite="context" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	ContextCategoryValue getRootValue();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContextCategory#getRootValue <em>Root Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root Value</em>' containment reference.
     * @see #getRootValue()
     * @generated
     */
	void setRootValue(ContextCategoryValue value);

	/**
     * Returns the value of the '<em><b>Category Configuration</b></em>' reference list.
     * The list contents are of type {@link configuration.context_drivers.ContexConfiguration}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContexConfiguration#getCategory <em>Category</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Configuration</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Category Configuration</em>' reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContextCategory_CategoryConfiguration()
     * @see configuration.context_drivers.ContexConfiguration#getCategory
     * @model opposite="category"
     * @generated
     */
	EList<ContexConfiguration> getCategoryConfiguration();

} // ContextCategory
