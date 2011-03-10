/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getEvents <em>Events</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getDbgName <em>Dbg Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine()
 * @model
 * @generated
 */
public interface Statemachine extends EObject
{
  /**
   * Returns the value of the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial</em>' attribute.
   * @see #setInitial(boolean)
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_Initial()
   * @model
   * @generated
   */
  boolean isInitial();

  /**
   * Sets the value of the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#isInitial <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial</em>' attribute.
   * @see #isInitial()
   * @generated
   */
  void setInitial(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_Events()
   * @model containment="true"
   * @generated
   */
  EList<Event> getEvents();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

  /**
   * Returns the value of the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dbg Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dbg Name</em>' attribute.
   * @see #setDbgName(String)
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage#getStatemachine_DbgName()
   * @model
   * @generated
   */
  String getDbgName();

  /**
   * Sets the value of the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getDbgName <em>Dbg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dbg Name</em>' attribute.
   * @see #getDbgName()
   * @generated
   */
  void setDbgName(String value);

} // Statemachine
