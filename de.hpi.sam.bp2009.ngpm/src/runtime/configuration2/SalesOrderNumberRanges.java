/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sales Order Number Ranges</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.configuration2.SalesOrderNumberRanges#getNr1 <em>Nr1</em>}</li>
 *   <li>{@link runtime.configuration2.SalesOrderNumberRanges#getNr2 <em>Nr2</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.configuration2.Configuration2Package#getSalesOrderNumberRanges()
 * @model
 * @generated
 */
public interface SalesOrderNumberRanges extends EObject
{
  /**
   * Returns the value of the '<em><b>Nr1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nr1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nr1</em>' containment reference.
   * @see #setNr1(runtime.primitivetypes.String)
   * @see runtime.configuration2.Configuration2Package#getSalesOrderNumberRanges_Nr1()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getNr1();

  /**
   * Sets the value of the '{@link runtime.configuration2.SalesOrderNumberRanges#getNr1 <em>Nr1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nr1</em>' containment reference.
   * @see #getNr1()
   * @generated
   */
  void setNr1(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Nr2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nr2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nr2</em>' containment reference.
   * @see #setNr2(runtime.primitivetypes.String)
   * @see runtime.configuration2.Configuration2Package#getSalesOrderNumberRanges_Nr2()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getNr2();

  /**
   * Sets the value of the '{@link runtime.configuration2.SalesOrderNumberRanges#getNr2 <em>Nr2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nr2</em>' containment reference.
   * @see #getNr2()
   * @generated
   */
  void setNr2(runtime.primitivetypes.String value);

} // SalesOrderNumberRanges
