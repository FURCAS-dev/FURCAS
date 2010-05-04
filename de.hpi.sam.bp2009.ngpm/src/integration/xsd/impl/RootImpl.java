/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.Annotation;
import integration.xsd.Root;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.RootImpl#getId <em>Id</em>}</li>
 *   <li>{@link integration.xsd.impl.RootImpl#getAnno <em>Anno</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RootImpl extends EObjectImpl implements Root
{
  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String id;

  /**
   * The cached value of the '{@link #getAnno() <em>Anno</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnno()
   * @generated
   * @ordered
   */
  protected Annotation anno;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RootImpl()
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
    return XsdPackage.Literals.ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetId(runtime.primitivetypes.String newId, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldId = id;
    id = newId;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.ROOT__ID, oldId, newId);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(runtime.primitivetypes.String newId)
  {
    if (newId != id)
    {
      NotificationChain msgs = null;
      if (id != null)
        msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ROOT__ID, null, msgs);
      if (newId != null)
        msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.ROOT__ID, null, msgs);
      msgs = basicSetId(newId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ROOT__ID, newId, newId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation getAnno()
  {
    if (anno != null && anno.eIsProxy())
    {
      InternalEObject oldAnno = (InternalEObject)anno;
      anno = (Annotation)eResolveProxy(oldAnno);
      if (anno != oldAnno)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsdPackage.ROOT__ANNO, oldAnno, anno));
      }
    }
    return anno;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation basicGetAnno()
  {
    return anno;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnno(Annotation newAnno)
  {
    Annotation oldAnno = anno;
    anno = newAnno;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ROOT__ANNO, oldAnno, anno));
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
      case XsdPackage.ROOT__ID:
        return basicSetId(null, msgs);
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
      case XsdPackage.ROOT__ID:
        return getId();
      case XsdPackage.ROOT__ANNO:
        if (resolve) return getAnno();
        return basicGetAnno();
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
      case XsdPackage.ROOT__ID:
        setId((runtime.primitivetypes.String)newValue);
        return;
      case XsdPackage.ROOT__ANNO:
        setAnno((Annotation)newValue);
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
      case XsdPackage.ROOT__ID:
        setId((runtime.primitivetypes.String)null);
        return;
      case XsdPackage.ROOT__ANNO:
        setAnno((Annotation)null);
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
      case XsdPackage.ROOT__ID:
        return id != null;
      case XsdPackage.ROOT__ANNO:
        return anno != null;
    }
    return super.eIsSet(featureID);
  }

} //RootImpl
