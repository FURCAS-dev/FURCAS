/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.query2.query.MQLquery;
import org.eclipse.emf.query2.query.QueryPackage;
import org.eclipse.emf.query2.query.SubselectWhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subselect Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl#isNotIn <em>Not In</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl#getSubQuery <em>Sub Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubselectWhereEntryImpl extends ReferenceWhereEntryImpl implements SubselectWhereEntry
{
  /**
   * The default value of the '{@link #isNotIn() <em>Not In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotIn()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_IN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNotIn() <em>Not In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotIn()
   * @generated
   * @ordered
   */
  protected boolean notIn = NOT_IN_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubQuery() <em>Sub Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubQuery()
   * @generated
   * @ordered
   */
  protected MQLquery subQuery;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubselectWhereEntryImpl()
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
    return QueryPackage.Literals.SUBSELECT_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNotIn()
  {
    return notIn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNotIn(boolean newNotIn)
  {
    boolean oldNotIn = notIn;
    notIn = newNotIn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.SUBSELECT_WHERE_ENTRY__NOT_IN, oldNotIn, notIn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MQLquery getSubQuery()
  {
    return subQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubQuery(MQLquery newSubQuery, NotificationChain msgs)
  {
    MQLquery oldSubQuery = subQuery;
    subQuery = newSubQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY, oldSubQuery, newSubQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubQuery(MQLquery newSubQuery)
  {
    if (newSubQuery != subQuery)
    {
      NotificationChain msgs = null;
      if (subQuery != null)
        msgs = ((InternalEObject)subQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY, null, msgs);
      if (newSubQuery != null)
        msgs = ((InternalEObject)newSubQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY, null, msgs);
      msgs = basicSetSubQuery(newSubQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY, newSubQuery, newSubQuery));
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
      case QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY:
        return basicSetSubQuery(null, msgs);
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
      case QueryPackage.SUBSELECT_WHERE_ENTRY__NOT_IN:
        return isNotIn();
      case QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY:
        return getSubQuery();
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
      case QueryPackage.SUBSELECT_WHERE_ENTRY__NOT_IN:
        setNotIn((Boolean)newValue);
        return;
      case QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY:
        setSubQuery((MQLquery)newValue);
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
      case QueryPackage.SUBSELECT_WHERE_ENTRY__NOT_IN:
        setNotIn(NOT_IN_EDEFAULT);
        return;
      case QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY:
        setSubQuery((MQLquery)null);
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
      case QueryPackage.SUBSELECT_WHERE_ENTRY__NOT_IN:
        return notIn != NOT_IN_EDEFAULT;
      case QueryPackage.SUBSELECT_WHERE_ENTRY__SUB_QUERY:
        return subQuery != null;
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
    result.append(" (notIn: ");
    result.append(notIn);
    result.append(')');
    return result.toString();
  }

} //SubselectWhereEntryImpl
