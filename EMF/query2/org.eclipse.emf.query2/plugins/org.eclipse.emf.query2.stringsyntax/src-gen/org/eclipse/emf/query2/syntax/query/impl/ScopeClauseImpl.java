/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.ScopeClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl#isNotIn <em>Not In</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeClauseImpl extends MinimalEObjectImpl.Container implements ScopeClause
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
   * The cached value of the '{@link #getUris() <em>Uris</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUris()
   * @generated
   * @ordered
   */
  protected EList<String> uris;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScopeClauseImpl()
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
    return QueryPackage.Literals.SCOPE_CLAUSE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.SCOPE_CLAUSE__NOT_IN, oldNotIn, notIn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getUris()
  {
    if (uris == null)
    {
      uris = new EDataTypeEList<String>(String.class, this, QueryPackage.SCOPE_CLAUSE__URIS);
    }
    return uris;
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
      case QueryPackage.SCOPE_CLAUSE__NOT_IN:
        return isNotIn();
      case QueryPackage.SCOPE_CLAUSE__URIS:
        return getUris();
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
      case QueryPackage.SCOPE_CLAUSE__NOT_IN:
        setNotIn((Boolean)newValue);
        return;
      case QueryPackage.SCOPE_CLAUSE__URIS:
        getUris().clear();
        getUris().addAll((Collection<? extends String>)newValue);
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
      case QueryPackage.SCOPE_CLAUSE__NOT_IN:
        setNotIn(NOT_IN_EDEFAULT);
        return;
      case QueryPackage.SCOPE_CLAUSE__URIS:
        getUris().clear();
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
      case QueryPackage.SCOPE_CLAUSE__NOT_IN:
        return notIn != NOT_IN_EDEFAULT;
      case QueryPackage.SCOPE_CLAUSE__URIS:
        return uris != null && !uris.isEmpty();
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
    result.append(", uris: ");
    result.append(uris);
    result.append(')');
    return result.toString();
  }

} //ScopeClauseImpl
