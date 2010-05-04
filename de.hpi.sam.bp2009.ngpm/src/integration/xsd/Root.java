/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Root#getId <em>Id</em>}</li>
 *   <li>{@link integration.xsd.Root#getAnno <em>Anno</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getRoot()
 * @model abstract="true"
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' containment reference.
   * @see #setId(runtime.primitivetypes.String)
   * @see integration.xsd.XsdPackage#getRoot_Id()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getId();

  /**
   * Sets the value of the '{@link integration.xsd.Root#getId <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' containment reference.
   * @see #getId()
   * @generated
   */
  void setId(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Anno</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anno</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anno</em>' reference.
   * @see #setAnno(Annotation)
   * @see integration.xsd.XsdPackage#getRoot_Anno()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  Annotation getAnno();

  /**
   * Sets the value of the '{@link integration.xsd.Root#getAnno <em>Anno</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Anno</em>' reference.
   * @see #getAnno()
   * @generated
   */
  void setAnno(Annotation value);

} // Root
