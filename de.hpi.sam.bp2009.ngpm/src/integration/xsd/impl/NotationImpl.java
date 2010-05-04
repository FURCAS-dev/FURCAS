/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.Notation;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.NotationImpl#getPublicDec <em>Public Dec</em>}</li>
 *   <li>{@link integration.xsd.impl.NotationImpl#getSystemDec <em>System Dec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotationImpl extends NamedElementImpl implements Notation
{
  /**
   * The cached value of the '{@link #getPublicDec() <em>Public Dec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPublicDec()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String publicDec;

  /**
   * The cached value of the '{@link #getSystemDec() <em>System Dec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemDec()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String systemDec;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NotationImpl()
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
    return XsdPackage.Literals.NOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getPublicDec()
  {
    return publicDec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPublicDec(runtime.primitivetypes.String newPublicDec, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldPublicDec = publicDec;
    publicDec = newPublicDec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__PUBLIC_DEC, oldPublicDec, newPublicDec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPublicDec(runtime.primitivetypes.String newPublicDec)
  {
    if (newPublicDec != publicDec)
    {
      NotificationChain msgs = null;
      if (publicDec != null)
        msgs = ((InternalEObject)publicDec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.NOTATION__PUBLIC_DEC, null, msgs);
      if (newPublicDec != null)
        msgs = ((InternalEObject)newPublicDec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.NOTATION__PUBLIC_DEC, null, msgs);
      msgs = basicSetPublicDec(newPublicDec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__PUBLIC_DEC, newPublicDec, newPublicDec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getSystemDec()
  {
    return systemDec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSystemDec(runtime.primitivetypes.String newSystemDec, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldSystemDec = systemDec;
    systemDec = newSystemDec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__SYSTEM_DEC, oldSystemDec, newSystemDec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystemDec(runtime.primitivetypes.String newSystemDec)
  {
    if (newSystemDec != systemDec)
    {
      NotificationChain msgs = null;
      if (systemDec != null)
        msgs = ((InternalEObject)systemDec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.NOTATION__SYSTEM_DEC, null, msgs);
      if (newSystemDec != null)
        msgs = ((InternalEObject)newSystemDec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.NOTATION__SYSTEM_DEC, null, msgs);
      msgs = basicSetSystemDec(newSystemDec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__SYSTEM_DEC, newSystemDec, newSystemDec));
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
      case XsdPackage.NOTATION__PUBLIC_DEC:
        return basicSetPublicDec(null, msgs);
      case XsdPackage.NOTATION__SYSTEM_DEC:
        return basicSetSystemDec(null, msgs);
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
      case XsdPackage.NOTATION__PUBLIC_DEC:
        return getPublicDec();
      case XsdPackage.NOTATION__SYSTEM_DEC:
        return getSystemDec();
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
      case XsdPackage.NOTATION__PUBLIC_DEC:
        setPublicDec((runtime.primitivetypes.String)newValue);
        return;
      case XsdPackage.NOTATION__SYSTEM_DEC:
        setSystemDec((runtime.primitivetypes.String)newValue);
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
      case XsdPackage.NOTATION__PUBLIC_DEC:
        setPublicDec((runtime.primitivetypes.String)null);
        return;
      case XsdPackage.NOTATION__SYSTEM_DEC:
        setSystemDec((runtime.primitivetypes.String)null);
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
      case XsdPackage.NOTATION__PUBLIC_DEC:
        return publicDec != null;
      case XsdPackage.NOTATION__SYSTEM_DEC:
        return systemDec != null;
    }
    return super.eIsSet(featureID);
  }

} //NotationImpl
