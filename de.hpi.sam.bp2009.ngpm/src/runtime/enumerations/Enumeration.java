/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.enumerations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An enumeration type declares a number of literals that constitute the instances of the enumeration type. Enumerations can thus also be used to implement a concept known as "Code List" that is used, e.g., to encode ISO code lists of currencies, countries or others.
 * 
 * However, I wonder if the choice of a Code List / Enumeration is appropriate for, e.g., currency encoding, given the fact that the set of currencies available worldwide may change over time (think "Euro"). Similar for countries (Soviet Union --> GUS, Yugoslavia, ...). Probably, those would better have been instances of classes, only marked as not changing very frequently.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.enumerations.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.enumerations.EnumerationsPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends EObject
{
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link runtime.enumerations.EnumerationLiteral}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see runtime.enumerations.EnumerationsPackage#getEnumeration_Literals()
   * @model containment="true" required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<EnumerationLiteral> getLiterals();

} // Enumeration
