/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesFactory
 * @model kind="package"
 * @generated
 */
public interface StatesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "states";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://ocl.eclipse.org/tutorial/eclipsecon2011/States";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "states";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StatesPackage eINSTANCE = org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.ModuleImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getModule()
   * @generated
   */
  int MODULE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Machines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__MACHINES = 1;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl <em>Statemachine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getStatemachine()
   * @generated
   */
  int STATEMACHINE = 1;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__INITIAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__NAME = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__VALUE = 2;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__EVENTS = 3;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__STATES = 4;

  /**
   * The feature id for the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__DBG_NAME = 5;

  /**
   * The number of structural features of the '<em>Statemachine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.EventImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StateImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getState()
   * @generated
   */
  int STATE = 3;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__INITIAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__TRANSITIONS = 2;

  /**
   * The feature id for the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__DBG_NAME = 3;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.SimpleStateImpl <em>Simple State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.SimpleStateImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getSimpleState()
   * @generated
   */
  int SIMPLE_STATE = 4;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__INITIAL = STATE__INITIAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__NAME = STATE__NAME;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__TRANSITIONS = STATE__TRANSITIONS;

  /**
   * The feature id for the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__DBG_NAME = STATE__DBG_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__VALUE = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.CompoundStateImpl <em>Compound State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.CompoundStateImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getCompoundState()
   * @generated
   */
  int COMPOUND_STATE = 5;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE__INITIAL = STATE__INITIAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE__NAME = STATE__NAME;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE__TRANSITIONS = STATE__TRANSITIONS;

  /**
   * The feature id for the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE__DBG_NAME = STATE__DBG_NAME;

  /**
   * The feature id for the '<em><b>Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE__MACHINE = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Compound State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 6;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__EVENT = 0;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__STATE = 1;

  /**
   * The feature id for the '<em><b>Dbg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__DBG_NAME = 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Module#getMachines <em>Machines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Machines</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Module#getMachines()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Machines();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statemachine</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine
   * @generated
   */
  EClass getStatemachine();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#isInitial()
   * @see #getStatemachine()
   * @generated
   */
  EAttribute getStatemachine_Initial();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getName()
   * @see #getStatemachine()
   * @generated
   */
  EAttribute getStatemachine_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getValue()
   * @see #getStatemachine()
   * @generated
   */
  EAttribute getStatemachine_Value();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getEvents()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_Events();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getStates()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_States();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getDbgName <em>Dbg Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dbg Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine#getDbgName()
   * @see #getStatemachine()
   * @generated
   */
  EAttribute getStatemachine_DbgName();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Event#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Event#getName()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.State#isInitial()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Initial();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getTransitions()
   * @see #getState()
   * @generated
   */
  EReference getState_Transitions();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getDbgName <em>Dbg Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dbg Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.State#getDbgName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_DbgName();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.SimpleState <em>Simple State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple State</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.SimpleState
   * @generated
   */
  EClass getSimpleState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.SimpleState#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.SimpleState#getValue()
   * @see #getSimpleState()
   * @generated
   */
  EAttribute getSimpleState_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState <em>Compound State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound State</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState
   * @generated
   */
  EClass getCompoundState();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState#getMachine <em>Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Machine</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.CompoundState#getMachine()
   * @see #getCompoundState()
   * @generated
   */
  EReference getCompoundState_Machine();

  /**
   * Returns the meta object for class '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getEvent()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Event();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getState()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_State();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getDbgName <em>Dbg Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dbg Name</em>'.
   * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition#getDbgName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_DbgName();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StatesFactory getStatesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.ModuleImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__MACHINES = eINSTANCE.getModule_Machines();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl <em>Statemachine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getStatemachine()
     * @generated
     */
    EClass STATEMACHINE = eINSTANCE.getStatemachine();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMACHINE__INITIAL = eINSTANCE.getStatemachine_Initial();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMACHINE__NAME = eINSTANCE.getStatemachine_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMACHINE__VALUE = eINSTANCE.getStatemachine_Value();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__EVENTS = eINSTANCE.getStatemachine_Events();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__STATES = eINSTANCE.getStatemachine_States();

    /**
     * The meta object literal for the '<em><b>Dbg Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMACHINE__DBG_NAME = eINSTANCE.getStatemachine_DbgName();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.EventImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StateImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__INITIAL = eINSTANCE.getState_Initial();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__TRANSITIONS = eINSTANCE.getState_Transitions();

    /**
     * The meta object literal for the '<em><b>Dbg Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__DBG_NAME = eINSTANCE.getState_DbgName();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.SimpleStateImpl <em>Simple State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.SimpleStateImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getSimpleState()
     * @generated
     */
    EClass SIMPLE_STATE = eINSTANCE.getSimpleState();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_STATE__VALUE = eINSTANCE.getSimpleState_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.CompoundStateImpl <em>Compound State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.CompoundStateImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getCompoundState()
     * @generated
     */
    EClass COMPOUND_STATE = eINSTANCE.getCompoundState();

    /**
     * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOUND_STATE__MACHINE = eINSTANCE.getCompoundState_Machine();

    /**
     * The meta object literal for the '{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl
     * @see org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatesPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__EVENT = eINSTANCE.getTransition_Event();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__STATE = eINSTANCE.getTransition_State();

    /**
     * The meta object literal for the '<em><b>Dbg Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__DBG_NAME = eINSTANCE.getTransition_DbgName();

  }

} //StatesPackage
