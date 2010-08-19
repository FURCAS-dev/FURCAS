/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration;

import dataaccess.expressions.Expression;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Set Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#isCanBeChanged <em>Can Be Changed</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#isCanBeDeleted <em>Can Be Deleted</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getValueSet <em>Value Set</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry()
 * @model
 * @generated
 */
public interface ValueSetEntry extends NamedElement {
	/**
     * Returns the value of the '<em><b>Can Be Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If true, 
     * <!-- end-model-doc -->
     * @return the value of the '<em>Can Be Changed</em>' attribute.
     * @see #setCanBeChanged(boolean)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_CanBeChanged()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isCanBeChanged();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#isCanBeChanged <em>Can Be Changed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Can Be Changed</em>' attribute.
     * @see #isCanBeChanged()
     * @generated
     */
	void setCanBeChanged(boolean value);

	/**
     * Returns the value of the '<em><b>Can Be Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Be Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Can Be Deleted</em>' attribute.
     * @see #setCanBeDeleted(boolean)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_CanBeDeleted()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isCanBeDeleted();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#isCanBeDeleted <em>Can Be Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Can Be Deleted</em>' attribute.
     * @see #isCanBeDeleted()
     * @generated
     */
	void setCanBeDeleted(boolean value);

	/**
     * Returns the value of the '<em><b>Value Set</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link configuration.businessconfiguration.ValueSet#getEntries <em>Entries</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value Set</em>' container reference.
     * @see #setValueSet(ValueSet)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_ValueSet()
     * @see configuration.businessconfiguration.ValueSet#getEntries
     * @model opposite="entries" required="true"
     * @generated
     */
	ValueSet getValueSet();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#getValueSet <em>Value Set</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Set</em>' container reference.
     * @see #getValueSet()
     * @generated
     */
	void setValueSet(ValueSet value);

	/**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(Expression)
     * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_Value()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getValue();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
	void setValue(Expression value);

} // ValueSetEntry
