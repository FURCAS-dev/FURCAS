/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.Annotation;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.AnnotationImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link integration.xsd.impl.AnnotationImpl#getAppInfo <em>App Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends EObjectImpl implements Annotation
{
  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String documentation;

  /**
   * The cached value of the '{@link #getAppInfo() <em>App Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppInfo()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String appInfo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationImpl()
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
    return XsdPackage.Literals.ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getDocumentation()
  {
    return documentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDocumentation(runtime.primitivetypes.String newDocumentation, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldDocumentation = documentation;
    documentation = newDocumentation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.ANNOTATION__DOCUMENTATION, oldDocumentation, newDocumentation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(runtime.primitivetypes.String newDocumentation)
  {
    if (newDocumentation != documentation)
    {
      NotificationChain msgs = null;
      if (documentation != null)
        msgs = ((InternalEObject)documentation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ANNOTATION__DOCUMENTATION, null, msgs);
      if (newDocumentation != null)
        msgs = ((InternalEObject)newDocumentation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ANNOTATION__DOCUMENTATION, null, msgs);
      msgs = basicSetDocumentation(newDocumentation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ANNOTATION__DOCUMENTATION, newDocumentation, newDocumentation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getAppInfo()
  {
    return appInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAppInfo(runtime.primitivetypes.String newAppInfo, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldAppInfo = appInfo;
    appInfo = newAppInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.ANNOTATION__APP_INFO, oldAppInfo, newAppInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAppInfo(runtime.primitivetypes.String newAppInfo)
  {
    if (newAppInfo != appInfo)
    {
      NotificationChain msgs = null;
      if (appInfo != null)
        msgs = ((InternalEObject)appInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ANNOTATION__APP_INFO, null, msgs);
      if (newAppInfo != null)
        msgs = ((InternalEObject)newAppInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ANNOTATION__APP_INFO, null, msgs);
      msgs = basicSetAppInfo(newAppInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ANNOTATION__APP_INFO, newAppInfo, newAppInfo));
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
      case XsdPackage.ANNOTATION__DOCUMENTATION:
        return basicSetDocumentation(null, msgs);
      case XsdPackage.ANNOTATION__APP_INFO:
        return basicSetAppInfo(null, msgs);
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
      case XsdPackage.ANNOTATION__DOCUMENTATION:
        return getDocumentation();
      case XsdPackage.ANNOTATION__APP_INFO:
        return getAppInfo();
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
      case XsdPackage.ANNOTATION__DOCUMENTATION:
        setDocumentation((runtime.primitivetypes.String)newValue);
        return;
      case XsdPackage.ANNOTATION__APP_INFO:
        setAppInfo((runtime.primitivetypes.String)newValue);
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
      case XsdPackage.ANNOTATION__DOCUMENTATION:
        setDocumentation((runtime.primitivetypes.String)null);
        return;
      case XsdPackage.ANNOTATION__APP_INFO:
        setAppInfo((runtime.primitivetypes.String)null);
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
      case XsdPackage.ANNOTATION__DOCUMENTATION:
        return documentation != null;
      case XsdPackage.ANNOTATION__APP_INFO:
        return appInfo != null;
    }
    return super.eIsSet(featureID);
  }

} //AnnotationImpl
