/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.Containable;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.ContainableImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link integration.xsd.impl.ContainableImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContainableImpl extends RootImpl implements Containable
{
  /**
   * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinOccurs()
   * @generated
   * @ordered
   */
  protected static final long MIN_OCCURS_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinOccurs()
   * @generated
   * @ordered
   */
  protected long minOccurs = MIN_OCCURS_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxOccurs()
   * @generated
   * @ordered
   */
  protected static final long MAX_OCCURS_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxOccurs()
   * @generated
   * @ordered
   */
  protected long maxOccurs = MAX_OCCURS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContainableImpl()
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
    return XsdPackage.Literals.CONTAINABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getMinOccurs()
  {
    return minOccurs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinOccurs(long newMinOccurs)
  {
    long oldMinOccurs = minOccurs;
    minOccurs = newMinOccurs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.CONTAINABLE__MIN_OCCURS, oldMinOccurs, minOccurs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getMaxOccurs()
  {
    return maxOccurs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxOccurs(long newMaxOccurs)
  {
    long oldMaxOccurs = maxOccurs;
    maxOccurs = newMaxOccurs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.CONTAINABLE__MAX_OCCURS, oldMaxOccurs, maxOccurs));
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
      case XsdPackage.CONTAINABLE__MIN_OCCURS:
        return getMinOccurs();
      case XsdPackage.CONTAINABLE__MAX_OCCURS:
        return getMaxOccurs();
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
      case XsdPackage.CONTAINABLE__MIN_OCCURS:
        setMinOccurs((Long)newValue);
        return;
      case XsdPackage.CONTAINABLE__MAX_OCCURS:
        setMaxOccurs((Long)newValue);
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
      case XsdPackage.CONTAINABLE__MIN_OCCURS:
        setMinOccurs(MIN_OCCURS_EDEFAULT);
        return;
      case XsdPackage.CONTAINABLE__MAX_OCCURS:
        setMaxOccurs(MAX_OCCURS_EDEFAULT);
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
      case XsdPackage.CONTAINABLE__MIN_OCCURS:
        return minOccurs != MIN_OCCURS_EDEFAULT;
      case XsdPackage.CONTAINABLE__MAX_OCCURS:
        return maxOccurs != MAX_OCCURS_EDEFAULT;
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
    result.append(" (minOccurs: ");
    result.append(minOccurs);
    result.append(", maxOccurs: ");
    result.append(maxOccurs);
    result.append(')');
    return result.toString();
  }

} //ContainableImpl
