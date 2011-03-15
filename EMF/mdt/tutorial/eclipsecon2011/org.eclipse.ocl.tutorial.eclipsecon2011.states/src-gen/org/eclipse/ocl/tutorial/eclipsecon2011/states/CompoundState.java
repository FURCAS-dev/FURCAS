/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getCompoundState()
 * @model
 * @generated
 */
public interface CompoundState extends State
{
  /**
   * Returns the value of the '<em><b>Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Machine</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Machine</em>' reference.
   * @see #setMachine(Statemachine)
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getCompoundState_Machine()
   * @model
   * @generated
   */
  Statemachine getMachine();

  /**
   * Sets the value of the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState#getMachine <em>Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Machine</em>' reference.
   * @see #getMachine()
   * @generated
   */
  void setMachine(Statemachine value);

} // CompoundState
