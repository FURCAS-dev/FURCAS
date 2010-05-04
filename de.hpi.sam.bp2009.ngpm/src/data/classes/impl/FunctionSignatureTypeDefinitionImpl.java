/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.Signature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Signature Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.FunctionSignatureTypeDefinitionImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link data.classes.impl.FunctionSignatureTypeDefinitionImpl#getOwnedSignature <em>Owned Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionSignatureTypeDefinitionImpl extends TypeDefinitionImpl implements FunctionSignatureTypeDefinition
{
  /**
   * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignature()
   * @generated
   * @ordered
   */
  protected Signature signature;

  /**
   * The cached value of the '{@link #getOwnedSignature() <em>Owned Signature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedSignature()
   * @generated
   * @ordered
   */
  protected Signature ownedSignature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionSignatureTypeDefinitionImpl()
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
    return ClassesPackage.Literals.FUNCTION_SIGNATURE_TYPE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signature getSignature()
  {
    if (signature != null && signature.eIsProxy())
    {
      InternalEObject oldSignature = (InternalEObject)signature;
      signature = (Signature)eResolveProxy(oldSignature);
      if (signature != oldSignature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE, oldSignature, signature));
      }
    }
    return signature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signature basicGetSignature()
  {
    return signature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignature(Signature newSignature)
  {
    Signature oldSignature = signature;
    signature = newSignature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE, oldSignature, signature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signature getOwnedSignature()
  {
    return ownedSignature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedSignature(Signature newOwnedSignature, NotificationChain msgs)
  {
    Signature oldOwnedSignature = ownedSignature;
    ownedSignature = newOwnedSignature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE, oldOwnedSignature, newOwnedSignature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedSignature(Signature newOwnedSignature)
  {
    if (newOwnedSignature != ownedSignature)
    {
      NotificationChain msgs = null;
      if (ownedSignature != null)
        msgs = ((InternalEObject)ownedSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE, null, msgs);
      if (newOwnedSignature != null)
        msgs = ((InternalEObject)newOwnedSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE, null, msgs);
      msgs = basicSetOwnedSignature(newOwnedSignature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE, newOwnedSignature, newOwnedSignature));
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
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE:
        return basicSetOwnedSignature(null, msgs);
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
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE:
        if (resolve) return getSignature();
        return basicGetSignature();
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE:
        return getOwnedSignature();
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
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE:
        setSignature((Signature)newValue);
        return;
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE:
        setOwnedSignature((Signature)newValue);
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
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE:
        setSignature((Signature)null);
        return;
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE:
        setOwnedSignature((Signature)null);
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
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE:
        return signature != null;
      case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE:
        return ownedSignature != null;
    }
    return super.eIsSet(featureID);
  }

} //FunctionSignatureTypeDefinitionImpl
