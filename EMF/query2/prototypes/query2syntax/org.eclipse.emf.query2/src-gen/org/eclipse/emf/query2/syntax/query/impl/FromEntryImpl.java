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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.syntax.query.FromEntry;
import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.ScopeClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl#isWithoutsubtypes <em>Withoutsubtypes</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl#getWithoutsubtypesTypes <em>Withoutsubtypes Types</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl#getScopeClause <em>Scope Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromEntryImpl extends MinimalEObjectImpl.Container implements FromEntry
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClass type;

  /**
   * The default value of the '{@link #isWithoutsubtypes() <em>Withoutsubtypes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWithoutsubtypes()
   * @generated
   * @ordered
   */
  protected static final boolean WITHOUTSUBTYPES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWithoutsubtypes() <em>Withoutsubtypes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWithoutsubtypes()
   * @generated
   * @ordered
   */
  protected boolean withoutsubtypes = WITHOUTSUBTYPES_EDEFAULT;

  /**
   * The cached value of the '{@link #getWithoutsubtypesTypes() <em>Withoutsubtypes Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWithoutsubtypesTypes()
   * @generated
   * @ordered
   */
  protected EList<EClass> withoutsubtypesTypes;

  /**
   * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected static final String ALIAS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected String alias = ALIAS_EDEFAULT;

  /**
   * The cached value of the '{@link #getScopeClause() <em>Scope Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScopeClause()
   * @generated
   * @ordered
   */
  protected ScopeClause scopeClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FromEntryImpl()
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
    return QueryPackage.Literals.FROM_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EClass)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.FROM_ENTRY__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(EClass newType)
  {
    EClass oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_ENTRY__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWithoutsubtypes()
  {
    return withoutsubtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWithoutsubtypes(boolean newWithoutsubtypes)
  {
    boolean oldWithoutsubtypes = withoutsubtypes;
    withoutsubtypes = newWithoutsubtypes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES, oldWithoutsubtypes, withoutsubtypes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EClass> getWithoutsubtypesTypes()
  {
    if (withoutsubtypesTypes == null)
    {
      withoutsubtypesTypes = new EObjectResolvingEList<EClass>(EClass.class, this, QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES_TYPES);
    }
    return withoutsubtypesTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(String newAlias)
  {
    String oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_ENTRY__ALIAS, oldAlias, alias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopeClause getScopeClause()
  {
    return scopeClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetScopeClause(ScopeClause newScopeClause, NotificationChain msgs)
  {
    ScopeClause oldScopeClause = scopeClause;
    scopeClause = newScopeClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_ENTRY__SCOPE_CLAUSE, oldScopeClause, newScopeClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScopeClause(ScopeClause newScopeClause)
  {
    if (newScopeClause != scopeClause)
    {
      NotificationChain msgs = null;
      if (scopeClause != null)
        msgs = ((InternalEObject)scopeClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FROM_ENTRY__SCOPE_CLAUSE, null, msgs);
      if (newScopeClause != null)
        msgs = ((InternalEObject)newScopeClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FROM_ENTRY__SCOPE_CLAUSE, null, msgs);
      msgs = basicSetScopeClause(newScopeClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_ENTRY__SCOPE_CLAUSE, newScopeClause, newScopeClause));
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
      case QueryPackage.FROM_ENTRY__SCOPE_CLAUSE:
        return basicSetScopeClause(null, msgs);
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
      case QueryPackage.FROM_ENTRY__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES:
        return isWithoutsubtypes();
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES_TYPES:
        return getWithoutsubtypesTypes();
      case QueryPackage.FROM_ENTRY__ALIAS:
        return getAlias();
      case QueryPackage.FROM_ENTRY__SCOPE_CLAUSE:
        return getScopeClause();
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
      case QueryPackage.FROM_ENTRY__TYPE:
        setType((EClass)newValue);
        return;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES:
        setWithoutsubtypes((Boolean)newValue);
        return;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES_TYPES:
        getWithoutsubtypesTypes().clear();
        getWithoutsubtypesTypes().addAll((Collection<? extends EClass>)newValue);
        return;
      case QueryPackage.FROM_ENTRY__ALIAS:
        setAlias((String)newValue);
        return;
      case QueryPackage.FROM_ENTRY__SCOPE_CLAUSE:
        setScopeClause((ScopeClause)newValue);
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
      case QueryPackage.FROM_ENTRY__TYPE:
        setType((EClass)null);
        return;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES:
        setWithoutsubtypes(WITHOUTSUBTYPES_EDEFAULT);
        return;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES_TYPES:
        getWithoutsubtypesTypes().clear();
        return;
      case QueryPackage.FROM_ENTRY__ALIAS:
        setAlias(ALIAS_EDEFAULT);
        return;
      case QueryPackage.FROM_ENTRY__SCOPE_CLAUSE:
        setScopeClause((ScopeClause)null);
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
      case QueryPackage.FROM_ENTRY__TYPE:
        return type != null;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES:
        return withoutsubtypes != WITHOUTSUBTYPES_EDEFAULT;
      case QueryPackage.FROM_ENTRY__WITHOUTSUBTYPES_TYPES:
        return withoutsubtypesTypes != null && !withoutsubtypesTypes.isEmpty();
      case QueryPackage.FROM_ENTRY__ALIAS:
        return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
      case QueryPackage.FROM_ENTRY__SCOPE_CLAUSE:
        return scopeClause != null;
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
    result.append(" (withoutsubtypes: ");
    result.append(withoutsubtypes);
    result.append(", alias: ");
    result.append(alias);
    result.append(')');
    return result.toString();
  }

} //FromEntryImpl
