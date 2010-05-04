/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Multiplicity#getLowerMultiplicity <em>Lower Multiplicity</em>}</li>
 *   <li>{@link data.classes.Multiplicity#getUpperMultiplicity <em>Upper Multiplicity</em>}</li>
 *   <li>{@link data.classes.Multiplicity#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link data.classes.Multiplicity#isUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getMultiplicity()
 * @model abstract="true"
 * @generated
 */
public interface Multiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The lower bounds of this multiplicity.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Lower Multiplicity</em>' attribute.
   * @see #setLowerMultiplicity(long)
   * @see data.classes.ClassesPackage#getMultiplicity_LowerMultiplicity()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getLowerMultiplicity();

  /**
   * Sets the value of the '{@link data.classes.Multiplicity#getLowerMultiplicity <em>Lower Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Multiplicity</em>' attribute.
   * @see #getLowerMultiplicity()
   * @generated
   */
  void setLowerMultiplicity(long value);

  /**
   * Returns the value of the '<em><b>Upper Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The upper bounds of this multiplicity. Unlimited is encoded as -1.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Upper Multiplicity</em>' attribute.
   * @see #setUpperMultiplicity(long)
   * @see data.classes.ClassesPackage#getMultiplicity_UpperMultiplicity()
   * @model dataType="primitivetypes.Integer"
   * @generated
   */
  long getUpperMultiplicity();

  /**
   * Sets the value of the '{@link data.classes.Multiplicity#getUpperMultiplicity <em>Upper Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Multiplicity</em>' attribute.
   * @see #getUpperMultiplicity()
   * @generated
   */
  void setUpperMultiplicity(long value);

  /**
   * Returns the value of the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ordered</em>' attribute.
   * @see #setOrdered(boolean)
   * @see data.classes.ClassesPackage#getMultiplicity_Ordered()
   * @model dataType="primitivetypes.Boolean"
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link data.classes.Multiplicity#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @see data.classes.ClassesPackage#getMultiplicity_Unique()
   * @model dataType="primitivetypes.Boolean"
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link data.classes.Multiplicity#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self.upperMultiplicity > 1 or self.upperMultiplicity = -1'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  boolean isMany();

} // Multiplicity
