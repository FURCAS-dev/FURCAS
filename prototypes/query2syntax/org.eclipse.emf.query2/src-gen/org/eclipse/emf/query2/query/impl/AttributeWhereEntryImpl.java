/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.query2.query.AttributeWhereEntry;
import org.eclipse.emf.query2.query.FromEntry;
import org.eclipse.emf.query2.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeWhereEntryImpl extends WhereEntryImpl implements AttributeWhereEntry
{
  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected FromEntry alias;

  /**
   * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute()
   * @generated
   * @ordered
   */
  protected EAttribute attribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeWhereEntryImpl()
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
    return QueryPackage.Literals.ATTRIBUTE_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getAlias()
  {
    if (alias != null && alias.eIsProxy())
    {
      InternalEObject oldAlias = (InternalEObject)alias;
      alias = (FromEntry)eResolveProxy(oldAlias);
      if (alias != oldAlias)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS, oldAlias, alias));
      }
    }
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(FromEntry newAlias)
  {
    FromEntry oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS, oldAlias, alias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute()
  {
    if (attribute != null && attribute.eIsProxy())
    {
      InternalEObject oldAttribute = (InternalEObject)attribute;
      attribute = (EAttribute)eResolveProxy(oldAttribute);
      if (attribute != oldAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE, oldAttribute, attribute));
      }
    }
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetAttribute()
  {
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttribute(EAttribute newAttribute)
  {
    EAttribute oldAttribute = attribute;
    attribute = newAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE, oldAttribute, attribute));
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
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS:
        if (resolve) return getAlias();
        return basicGetAlias();
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
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
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS:
        setAlias((FromEntry)newValue);
        return;
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE:
        setAttribute((EAttribute)newValue);
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
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS:
        setAlias((FromEntry)null);
        return;
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE:
        setAttribute((EAttribute)null);
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
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ALIAS:
        return alias != null;
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE:
        return attribute != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributeWhereEntryImpl
