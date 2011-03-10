/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.ocl.tutorial.eclipsecon2011.states.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.tutorial.eclipsecon2011.states.Event;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.State;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.ocl.tutorial.eclipsecon2011.states.impl.TransitionImpl#getDbgName <em>Dbg Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition
{
  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected Event event;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected State state;

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
  protected TransitionImpl()
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
    return StatesPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event getEvent()
  {
    if (event != null && event.eIsProxy())
    {
      InternalEObject oldEvent = (InternalEObject)event;
      event = (Event)eResolveProxy(oldEvent);
      if (event != oldEvent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatesPackage.TRANSITION__EVENT, oldEvent, event));
      }
    }
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event basicGetEvent()
  {
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvent(Event newEvent)
  {
    Event oldEvent = event;
    event = newEvent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.TRANSITION__EVENT, oldEvent, event));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (State)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatesPackage.TRANSITION__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(State newState)
  {
    State oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.TRANSITION__STATE, oldState, state));
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
      eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.TRANSITION__DBG_NAME, oldDbgName, dbgName));
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
      case StatesPackage.TRANSITION__EVENT:
        if (resolve) return getEvent();
        return basicGetEvent();
      case StatesPackage.TRANSITION__STATE:
        if (resolve) return getState();
        return basicGetState();
      case StatesPackage.TRANSITION__DBG_NAME:
        return getDbgName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StatesPackage.TRANSITION__EVENT:
        setEvent((Event)newValue);
        return;
      case StatesPackage.TRANSITION__STATE:
        setState((State)newValue);
        return;
      case StatesPackage.TRANSITION__DBG_NAME:
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
      case StatesPackage.TRANSITION__EVENT:
        setEvent((Event)null);
        return;
      case StatesPackage.TRANSITION__STATE:
        setState((State)null);
        return;
      case StatesPackage.TRANSITION__DBG_NAME:
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
      case StatesPackage.TRANSITION__EVENT:
        return event != null;
      case StatesPackage.TRANSITION__STATE:
        return state != null;
      case StatesPackage.TRANSITION__DBG_NAME:
        return DBG_NAME_EDEFAULT == null ? dbgName != null : !DBG_NAME_EDEFAULT.equals(dbgName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer();
    result.append("Transition: ");
    result.append(event.getName());
    result.append(" => ");
    result.append(state.getName());
    return result.toString();
  }

} //TransitionImpl
