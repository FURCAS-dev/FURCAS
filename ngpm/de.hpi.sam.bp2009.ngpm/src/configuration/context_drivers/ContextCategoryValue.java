/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.context_drivers;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Category Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getValue <em>Value</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getContext <em>Context</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getIncludedValuesConfiguration <em>Included Values Configuration</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getChildren <em>Children</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getParent <em>Parent</em>}</li>
 *   <li>{@link configuration.context_drivers.ContextCategoryValue#getExcludedValuesConfiguration <em>Excluded Values Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue()
 * @model
 * @generated
 */
public interface ContextCategoryValue extends ContextCategory {
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
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_Value()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getValue();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContextCategoryValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(String value);

	/**
     * Returns the value of the '<em><b>Context</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategory#getRootValue <em>Root Value</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' container reference.
     * @see #setContext(ContextCategory)
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_Context()
     * @see configuration.context_drivers.ContextCategory#getRootValue
     * @model opposite="rootValue"
     * @generated
     */
	ContextCategory getContext();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContextCategoryValue#getContext <em>Context</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' container reference.
     * @see #getContext()
     * @generated
     */
	void setContext(ContextCategory value);

	/**
     * Returns the value of the '<em><b>Included Values Configuration</b></em>' reference list.
     * The list contents are of type {@link configuration.context_drivers.ContexConfiguration}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContexConfiguration#getIncludedValues <em>Included Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Values Configuration</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Included Values Configuration</em>' reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_IncludedValuesConfiguration()
     * @see configuration.context_drivers.ContexConfiguration#getIncludedValues
     * @model opposite="includedValues"
     * @generated
     */
	EList<ContexConfiguration> getIncludedValuesConfiguration();

	/**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link configuration.context_drivers.ContextCategoryValue}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategoryValue#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_Children()
     * @see configuration.context_drivers.ContextCategoryValue#getParent
     * @model opposite="parent" containment="true" resolveProxies="true"
     * @generated
     */
	EList<ContextCategoryValue> getChildren();

	/**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategoryValue#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(ContextCategoryValue)
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_Parent()
     * @see configuration.context_drivers.ContextCategoryValue#getChildren
     * @model opposite="children"
     * @generated
     */
	ContextCategoryValue getParent();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContextCategoryValue#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
	void setParent(ContextCategoryValue value);

	/**
     * Returns the value of the '<em><b>Excluded Values Configuration</b></em>' reference list.
     * The list contents are of type {@link configuration.context_drivers.ContexConfiguration}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContexConfiguration#getExcludedValues <em>Excluded Values</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Values Configuration</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Excluded Values Configuration</em>' reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContextCategoryValue_ExcludedValuesConfiguration()
     * @see configuration.context_drivers.ContexConfiguration#getExcludedValues
     * @model opposite="excludedValues"
     * @generated
     */
	EList<ContexConfiguration> getExcludedValuesConfiguration();

} // ContextCategoryValue
