/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContexConfiguration.java,v 1.1 2011/02/07 16:48:25 auhl Exp $
 */
package configuration.context_drivers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contex Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.context_drivers.ContexConfiguration#getCategory <em>Category</em>}</li>
 *   <li>{@link configuration.context_drivers.ContexConfiguration#getIncludedValues <em>Included Values</em>}</li>
 *   <li>{@link configuration.context_drivers.ContexConfiguration#getConfiguredElement <em>Configured Element</em>}</li>
 *   <li>{@link configuration.context_drivers.ContexConfiguration#getExcludedValues <em>Excluded Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.context_drivers.Context_driversPackage#getContexConfiguration()
 * @model
 * @generated
 */
public interface ContexConfiguration extends EObject {
	/**
     * Returns the value of the '<em><b>Category</b></em>' reference.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategory#getCategoryConfiguration <em>Category Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Category</em>' reference.
     * @see #setCategory(ContextCategory)
     * @see configuration.context_drivers.Context_driversPackage#getContexConfiguration_Category()
     * @see configuration.context_drivers.ContextCategory#getCategoryConfiguration
     * @model opposite="categoryConfiguration" required="true"
     * @generated
     */
	ContextCategory getCategory();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContexConfiguration#getCategory <em>Category</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Category</em>' reference.
     * @see #getCategory()
     * @generated
     */
	void setCategory(ContextCategory value);

	/**
     * Returns the value of the '<em><b>Included Values</b></em>' reference list.
     * The list contents are of type {@link configuration.context_drivers.ContextCategoryValue}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategoryValue#getIncludedValuesConfiguration <em>Included Values Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Included Values</em>' reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContexConfiguration_IncludedValues()
     * @see configuration.context_drivers.ContextCategoryValue#getIncludedValuesConfiguration
     * @model opposite="includedValuesConfiguration"
     * @generated
     */
	EList<ContextCategoryValue> getIncludedValues();

	/**
     * Returns the value of the '<em><b>Configured Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextualElement#getContextualElementConfiguration <em>Contextual Element Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configured Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Configured Element</em>' container reference.
     * @see #setConfiguredElement(ContextualElement)
     * @see configuration.context_drivers.Context_driversPackage#getContexConfiguration_ConfiguredElement()
     * @see configuration.context_drivers.ContextualElement#getContextualElementConfiguration
     * @model opposite="ContextualElementConfiguration" required="true"
     * @generated
     */
	ContextualElement getConfiguredElement();

	/**
     * Sets the value of the '{@link configuration.context_drivers.ContexConfiguration#getConfiguredElement <em>Configured Element</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configured Element</em>' container reference.
     * @see #getConfiguredElement()
     * @generated
     */
	void setConfiguredElement(ContextualElement value);

	/**
     * Returns the value of the '<em><b>Excluded Values</b></em>' reference list.
     * The list contents are of type {@link configuration.context_drivers.ContextCategoryValue}.
     * It is bidirectional and its opposite is '{@link configuration.context_drivers.ContextCategoryValue#getExcludedValuesConfiguration <em>Excluded Values Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Excluded Values</em>' reference list.
     * @see configuration.context_drivers.Context_driversPackage#getContexConfiguration_ExcludedValues()
     * @see configuration.context_drivers.ContextCategoryValue#getExcludedValuesConfiguration
     * @model opposite="excludedValuesConfiguration"
     * @generated
     */
	EList<ContextCategoryValue> getExcludedValues();

} // ContexConfiguration
