/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.ComplexContent;
import integration.xsd.Containable;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.ComplexContentImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link integration.xsd.impl.ComplexContentImpl#getContentModel <em>Content Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexContentImpl extends AbstractContentImpl implements ComplexContent
{
  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean mixed;

  /**
   * The cached value of the '{@link #getContentModel() <em>Content Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentModel()
   * @generated
   * @ordered
   */
  protected Containable contentModel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComplexContentImpl()
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
    return XsdPackage.Literals.COMPLEX_CONTENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getMixed()
  {
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMixed(runtime.primitivetypes.Boolean newMixed, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldMixed = mixed;
    mixed = newMixed;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_CONTENT__MIXED, oldMixed, newMixed);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMixed(runtime.primitivetypes.Boolean newMixed)
  {
    if (newMixed != mixed)
    {
      NotificationChain msgs = null;
      if (mixed != null)
        msgs = ((InternalEObject)mixed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.COMPLEX_CONTENT__MIXED, null, msgs);
      if (newMixed != null)
        msgs = ((InternalEObject)newMixed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.COMPLEX_CONTENT__MIXED, null, msgs);
      msgs = basicSetMixed(newMixed, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_CONTENT__MIXED, newMixed, newMixed));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Containable getContentModel()
  {
    if (contentModel != null && contentModel.eIsProxy())
    {
      InternalEObject oldContentModel = (InternalEObject)contentModel;
      contentModel = (Containable)eResolveProxy(oldContentModel);
      if (contentModel != oldContentModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL, oldContentModel, contentModel));
      }
    }
    return contentModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Containable basicGetContentModel()
  {
    return contentModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContentModel(Containable newContentModel)
  {
    Containable oldContentModel = contentModel;
    contentModel = newContentModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL, oldContentModel, contentModel));
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
      case XsdPackage.COMPLEX_CONTENT__MIXED:
        return basicSetMixed(null, msgs);
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
      case XsdPackage.COMPLEX_CONTENT__MIXED:
        return getMixed();
      case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
        if (resolve) return getContentModel();
        return basicGetContentModel();
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
      case XsdPackage.COMPLEX_CONTENT__MIXED:
        setMixed((runtime.primitivetypes.Boolean)newValue);
        return;
      case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
        setContentModel((Containable)newValue);
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
      case XsdPackage.COMPLEX_CONTENT__MIXED:
        setMixed((runtime.primitivetypes.Boolean)null);
        return;
      case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
        setContentModel((Containable)null);
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
      case XsdPackage.COMPLEX_CONTENT__MIXED:
        return mixed != null;
      case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
        return contentModel != null;
    }
    return super.eIsSet(featureID);
  }

} //ComplexContentImpl
