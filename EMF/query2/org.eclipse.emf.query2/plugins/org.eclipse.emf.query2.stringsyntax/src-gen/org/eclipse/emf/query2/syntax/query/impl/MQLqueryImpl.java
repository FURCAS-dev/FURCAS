/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query.impl;

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

import org.eclipse.emf.query2.syntax.query.FromEntry;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.SelectEntry;
import org.eclipse.emf.query2.syntax.query.WhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Lquery</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl#getFromEntries <em>From Entries</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl#getSelectEntries <em>Select Entries</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl#getWhereEntry <em>Where Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQLqueryImpl extends MinimalEObjectImpl.Container implements MQLquery
{
  /**
   * The cached value of the '{@link #getFromEntries() <em>From Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromEntries()
   * @generated
   * @ordered
   */
  protected EList<FromEntry> fromEntries;

  /**
   * The cached value of the '{@link #getSelectEntries() <em>Select Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectEntries()
   * @generated
   * @ordered
   */
  protected EList<SelectEntry> selectEntries;

  /**
   * The cached value of the '{@link #getWhereEntry() <em>Where Entry</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhereEntry()
   * @generated
   * @ordered
   */
  protected WhereEntry whereEntry;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MQLqueryImpl()
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
    return QueryPackage.Literals.MQ_LQUERY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FromEntry> getFromEntries()
  {
    if (fromEntries == null)
    {
      fromEntries = new EObjectContainmentEList<FromEntry>(FromEntry.class, this, QueryPackage.MQ_LQUERY__FROM_ENTRIES);
    }
    return fromEntries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectEntry> getSelectEntries()
  {
    if (selectEntries == null)
    {
      selectEntries = new EObjectContainmentEList<SelectEntry>(SelectEntry.class, this, QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
    }
    return selectEntries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhereEntry getWhereEntry()
  {
    return whereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhereEntry(WhereEntry newWhereEntry, NotificationChain msgs)
  {
    WhereEntry oldWhereEntry = whereEntry;
    whereEntry = newWhereEntry;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.MQ_LQUERY__WHERE_ENTRY, oldWhereEntry, newWhereEntry);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhereEntry(WhereEntry newWhereEntry)
  {
    if (newWhereEntry != whereEntry)
    {
      NotificationChain msgs = null;
      if (whereEntry != null)
        msgs = ((InternalEObject)whereEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.MQ_LQUERY__WHERE_ENTRY, null, msgs);
      if (newWhereEntry != null)
        msgs = ((InternalEObject)newWhereEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.MQ_LQUERY__WHERE_ENTRY, null, msgs);
      msgs = basicSetWhereEntry(newWhereEntry, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.MQ_LQUERY__WHERE_ENTRY, newWhereEntry, newWhereEntry));
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
      case QueryPackage.MQ_LQUERY__FROM_ENTRIES:
        return ((InternalEList<?>)getFromEntries()).basicRemove(otherEnd, msgs);
      case QueryPackage.MQ_LQUERY__SELECT_ENTRIES:
        return ((InternalEList<?>)getSelectEntries()).basicRemove(otherEnd, msgs);
      case QueryPackage.MQ_LQUERY__WHERE_ENTRY:
        return basicSetWhereEntry(null, msgs);
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
      case QueryPackage.MQ_LQUERY__FROM_ENTRIES:
        return getFromEntries();
      case QueryPackage.MQ_LQUERY__SELECT_ENTRIES:
        return getSelectEntries();
      case QueryPackage.MQ_LQUERY__WHERE_ENTRY:
        return getWhereEntry();
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
      case QueryPackage.MQ_LQUERY__FROM_ENTRIES:
        getFromEntries().clear();
        getFromEntries().addAll((Collection<? extends FromEntry>)newValue);
        return;
      case QueryPackage.MQ_LQUERY__SELECT_ENTRIES:
        getSelectEntries().clear();
        getSelectEntries().addAll((Collection<? extends SelectEntry>)newValue);
        return;
      case QueryPackage.MQ_LQUERY__WHERE_ENTRY:
        setWhereEntry((WhereEntry)newValue);
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
      case QueryPackage.MQ_LQUERY__FROM_ENTRIES:
        getFromEntries().clear();
        return;
      case QueryPackage.MQ_LQUERY__SELECT_ENTRIES:
        getSelectEntries().clear();
        return;
      case QueryPackage.MQ_LQUERY__WHERE_ENTRY:
        setWhereEntry((WhereEntry)null);
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
      case QueryPackage.MQ_LQUERY__FROM_ENTRIES:
        return fromEntries != null && !fromEntries.isEmpty();
      case QueryPackage.MQ_LQUERY__SELECT_ENTRIES:
        return selectEntries != null && !selectEntries.isEmpty();
      case QueryPackage.MQ_LQUERY__WHERE_ENTRY:
        return whereEntry != null;
    }
    return super.eIsSet(featureID);
  }

} //MQLqueryImpl
