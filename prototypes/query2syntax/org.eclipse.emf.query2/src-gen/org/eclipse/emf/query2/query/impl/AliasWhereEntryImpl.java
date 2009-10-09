/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.query2.query.AliasWhereEntry;
import org.eclipse.emf.query2.query.FromEntry;
import org.eclipse.emf.query2.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.impl.AliasWhereEntryImpl#getRightAlias <em>Right Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AliasWhereEntryImpl extends AbstractAliasWhereEntryImpl implements AliasWhereEntry
{
  /**
   * The cached value of the '{@link #getRightAlias() <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightAlias()
   * @generated
   * @ordered
   */
  protected FromEntry rightAlias;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AliasWhereEntryImpl()
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
    return QueryPackage.Literals.ALIAS_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getRightAlias()
  {
    if (rightAlias != null && rightAlias.eIsProxy())
    {
      InternalEObject oldRightAlias = (InternalEObject)rightAlias;
      rightAlias = (FromEntry)eResolveProxy(oldRightAlias);
      if (rightAlias != oldRightAlias)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
      }
    }
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetRightAlias()
  {
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightAlias(FromEntry newRightAlias)
  {
    FromEntry oldRightAlias = rightAlias;
    rightAlias = newRightAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
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
      case QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        if (resolve) return getRightAlias();
        return basicGetRightAlias();
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
      case QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)newValue);
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
      case QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)null);
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
      case QueryPackage.ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        return rightAlias != null;
    }
    return super.eIsSet(featureID);
  }

} //AliasWhereEntryImpl
