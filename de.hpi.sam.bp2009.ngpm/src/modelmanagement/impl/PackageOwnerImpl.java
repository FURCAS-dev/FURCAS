/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.impl;

import modelmanagement.ModelmanagementPackage;
import modelmanagement.PackageOwner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.impl.PackageOwnerImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageOwnerImpl extends NamedElementImpl implements PackageOwner
{
  /**
   * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedPackages()
   * @generated
   * @ordered
   */
  protected modelmanagement.Package ownedPackages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageOwnerImpl()
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
    return ModelmanagementPackage.Literals.PACKAGE_OWNER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public modelmanagement.Package getOwnedPackages()
  {
    return ownedPackages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedPackages(modelmanagement.Package newOwnedPackages, NotificationChain msgs)
  {
    modelmanagement.Package oldOwnedPackages = ownedPackages;
    ownedPackages = newOwnedPackages;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, oldOwnedPackages, newOwnedPackages);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedPackages(modelmanagement.Package newOwnedPackages)
  {
    if (newOwnedPackages != ownedPackages)
    {
      NotificationChain msgs = null;
      if (ownedPackages != null)
        msgs = ((InternalEObject)ownedPackages).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, null, msgs);
      if (newOwnedPackages != null)
        msgs = ((InternalEObject)newOwnedPackages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, null, msgs);
      msgs = basicSetOwnedPackages(newOwnedPackages, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, newOwnedPackages, newOwnedPackages));
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
      case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
        return basicSetOwnedPackages(null, msgs);
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
      case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
        return getOwnedPackages();
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
      case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
        setOwnedPackages((modelmanagement.Package)newValue);
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
      case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
        setOwnedPackages((modelmanagement.Package)null);
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
      case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
        return ownedPackages != null;
    }
    return super.eIsSet(featureID);
  }

} //PackageOwnerImpl
