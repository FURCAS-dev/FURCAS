/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage
 * @generated
 */
public interface StatesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StatesFactory eINSTANCE = org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Statemachine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statemachine</em>'.
   * @generated
   */
  Statemachine createStatemachine();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>Simple State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple State</em>'.
   * @generated
   */
  SimpleState createSimpleState();

  /**
   * Returns a new object of class '<em>Compound State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound State</em>'.
   * @generated
   */
  CompoundState createCompoundState();

  /**
   * Returns a new object of class '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition</em>'.
   * @generated
   */
  Transition createTransition();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  StatesPackage getStatesPackage();

} //StatesFactory
