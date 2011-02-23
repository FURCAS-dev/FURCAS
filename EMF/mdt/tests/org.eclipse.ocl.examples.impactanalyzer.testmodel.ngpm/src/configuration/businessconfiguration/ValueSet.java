/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueSet.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package configuration.businessconfiguration;

import data.classes.TypedElement;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A set of values of a specific type which can be added to a system. For example, if the type is "Country" then the value set could be a list of countries known to or relevant for the application.
 * 
 * Value sets may be extensible or constant. In the "Country" example, the list of countries may change, be it because new countries are created or countries cease to exist because they get merged, or just because more countries are relevant for the application than originally thought.
 * 
 * Such value sets are also known as "BC Sets" (Business Configuration Sets).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.ValueSet#isExtensible <em>Extensible</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSet#getConfigurationBusinessOption <em>Configuration Business Option</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSet#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSet()
 * @model
 * @generated
 */
public interface ValueSet extends NamedElement, TypedElement {
	/**
     * Returns the value of the '<em><b>Extensible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Extensible</em>' attribute.
     * @see #setExtensible(boolean)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSet_Extensible()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isExtensible();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSet#isExtensible <em>Extensible</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Extensible</em>' attribute.
     * @see #isExtensible()
     * @generated
     */
	void setExtensible(boolean value);

	/**
     * Returns the value of the '<em><b>Configuration Business Option</b></em>' reference.
     * It is bidirectional and its opposite is '{@link configuration.businessconfiguration.BusinessOption#getValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Business Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration Business Option</em>' reference.
     * @see #setConfigurationBusinessOption(BusinessOption)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSet_ConfigurationBusinessOption()
     * @see configuration.businessconfiguration.BusinessOption#getValueSet
     * @model opposite="valueSet" required="true"
     * @generated
     */
	BusinessOption getConfigurationBusinessOption();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSet#getConfigurationBusinessOption <em>Configuration Business Option</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Business Option</em>' reference.
     * @see #getConfigurationBusinessOption()
     * @generated
     */
	void setConfigurationBusinessOption(BusinessOption value);

	/**
     * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
     * The list contents are of type {@link configuration.businessconfiguration.ValueSetEntry}.
     * It is bidirectional and its opposite is '{@link configuration.businessconfiguration.ValueSetEntry#getValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Entries</em>' containment reference list.
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSet_Entries()
     * @see configuration.businessconfiguration.ValueSetEntry#getValueSet
     * @model opposite="valueSet" containment="true" resolveProxies="true"
     * @generated
     */
	EList<ValueSetEntry> getEntries();

} // ValueSet
