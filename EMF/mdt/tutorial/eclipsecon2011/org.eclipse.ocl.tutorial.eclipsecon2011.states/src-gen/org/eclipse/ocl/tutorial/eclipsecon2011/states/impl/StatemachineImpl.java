/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.tutorial.eclipsecon2011.states.Event;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.State;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.Statemachine;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statemachine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.StatemachineImpl#getDbgName <em>Dbg Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatemachineImpl extends MinimalEObjectImpl.Container implements Statemachine
{
  /**
   * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInitial()
   * @generated
   * @ordered
   */
  protected static final boolean INITIAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInitial()
   * @generated
   * @ordered
   */
  protected boolean initial = INITIAL_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final int VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected int value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<Event> events;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * The default value of the '{@link #getDbgName() <em>Dbg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbgName()
   * @generated
   * @ordered
   */
  protected static final String DBG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbgName() <em>Dbg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbgName()
   * @generated
   * @ordered
   */
  protected String dbgName = DBG_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatemachineImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StatesPackage.Literals.STATEMACHINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInitial()
  {
    return initial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitial(boolean newInitial)
  {
    boolean oldInitial = initial;
    initial = newInitial;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATEMACHINE__INITIAL, oldInitial, initial));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATEMACHINE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(int newValue)
  {
    int oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATEMACHINE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Event> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<Event>(Event.class, this, StatesPackage.STATEMACHINE__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, StatesPackage.STATEMACHINE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbgName()
  {
    return dbgName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbgName(String newDbgName)
  {
    String oldDbgName = dbgName;
    dbgName = newDbgName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATEMACHINE__DBG_NAME, oldDbgName, dbgName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StatesPackage.STATEMACHINE__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
      case StatesPackage.STATEMACHINE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case StatesPackage.STATEMACHINE__INITIAL:
        return isInitial();
      case StatesPackage.STATEMACHINE__NAME:
        return getName();
      case StatesPackage.STATEMACHINE__VALUE:
        return getValue();
      case StatesPackage.STATEMACHINE__EVENTS:
        return getEvents();
      case StatesPackage.STATEMACHINE__STATES:
        return getStates();
      case StatesPackage.STATEMACHINE__DBG_NAME:
        return getDbgName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StatesPackage.STATEMACHINE__INITIAL:
        setInitial((Boolean)newValue);
        return;
      case StatesPackage.STATEMACHINE__NAME:
        setName((String)newValue);
        return;
      case StatesPackage.STATEMACHINE__VALUE:
        setValue((Integer)newValue);
        return;
      case StatesPackage.STATEMACHINE__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends Event>)newValue);
        return;
      case StatesPackage.STATEMACHINE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
        return;
      case StatesPackage.STATEMACHINE__DBG_NAME:
        setDbgName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case StatesPackage.STATEMACHINE__INITIAL:
        setInitial(INITIAL_EDEFAULT);
        return;
      case StatesPackage.STATEMACHINE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case StatesPackage.STATEMACHINE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case StatesPackage.STATEMACHINE__EVENTS:
        getEvents().clear();
        return;
      case StatesPackage.STATEMACHINE__STATES:
        getStates().clear();
        return;
      case StatesPackage.STATEMACHINE__DBG_NAME:
        setDbgName(DBG_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case StatesPackage.STATEMACHINE__INITIAL:
        return initial != INITIAL_EDEFAULT;
      case StatesPackage.STATEMACHINE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case StatesPackage.STATEMACHINE__VALUE:
        return value != VALUE_EDEFAULT;
      case StatesPackage.STATEMACHINE__EVENTS:
        return events != null && !events.isEmpty();
      case StatesPackage.STATEMACHINE__STATES:
        return states != null && !states.isEmpty();
      case StatesPackage.STATEMACHINE__DBG_NAME:
        return DBG_NAME_EDEFAULT == null ? dbgName != null : !DBG_NAME_EDEFAULT.equals(dbgName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (initial: ");
    result.append(initial);
    result.append(", name: ");
    result.append(name);
    result.append(", value: ");
    result.append(value);
    result.append(", dbgName: ");
    result.append(dbgName);
    result.append(')');
    return result.toString();
  }

} //StatemachineImpl
