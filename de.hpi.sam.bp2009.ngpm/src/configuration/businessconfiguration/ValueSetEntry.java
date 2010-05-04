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
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getCanBeChanged <em>Can Be Changed</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getCanBeDeleted <em>Can Be Deleted</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getValueSet <em>Value Set</em>}</li>
 *   <li>{@link configuration.businessconfiguration.ValueSetEntry#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry()
 * @model
 * @generated
 */
public interface ValueSetEntry extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Can Be Changed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * If true, 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Can Be Changed</em>' containment reference.
   * @see #setCanBeChanged(runtime.primitivetypes.Boolean)
   * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_CanBeChanged()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getCanBeChanged();

  /**
   * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#getCanBeChanged <em>Can Be Changed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Can Be Changed</em>' containment reference.
   * @see #getCanBeChanged()
   * @generated
   */
  void setCanBeChanged(runtime.primitivetypes.Boolean value);

  /**
   * Returns the value of the '<em><b>Can Be Deleted</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Can Be Deleted</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Can Be Deleted</em>' containment reference.
   * @see #setCanBeDeleted(runtime.primitivetypes.Boolean)
   * @see configuration.businessconfiguration.BusinessconfigurationPackage#getValueSetEntry_CanBeDeleted()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.Boolean getCanBeDeleted();

  /**
   * Sets the value of the '{@link configuration.businessconfiguration.ValueSetEntry#getCanBeDeleted <em>Can Be Deleted</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Can Be Deleted</em>' containment reference.
   * @see #getCanBeDeleted()
   * @generated
   */
  void setCanBeDeleted(runtime.primitivetypes.Boolean value);

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
   * @model containment="true" required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
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
