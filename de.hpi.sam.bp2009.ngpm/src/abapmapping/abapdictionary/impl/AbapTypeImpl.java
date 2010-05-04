/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapType;
import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.XsdType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.AbapTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.AbapTypeImpl#getXsdRepresentation <em>Xsd Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbapTypeImpl extends EObjectImpl implements AbapType
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String name;

  /**
   * The cached value of the '{@link #getXsdRepresentation() <em>Xsd Representation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsdRepresentation()
   * @generated
   * @ordered
   */
  protected XsdType xsdRepresentation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbapTypeImpl()
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
    return AbapdictionaryPackage.Literals.ABAP_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(runtime.primitivetypes.String newName, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.ABAP_TYPE__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(runtime.primitivetypes.String newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.ABAP_TYPE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.ABAP_TYPE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.ABAP_TYPE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsdType getXsdRepresentation()
  {
    if (xsdRepresentation != null && xsdRepresentation.eIsProxy())
    {
      InternalEObject oldXsdRepresentation = (InternalEObject)xsdRepresentation;
      xsdRepresentation = (XsdType)eResolveProxy(oldXsdRepresentation);
      if (xsdRepresentation != oldXsdRepresentation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION, oldXsdRepresentation, xsdRepresentation));
      }
    }
    return xsdRepresentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsdType basicGetXsdRepresentation()
  {
    return xsdRepresentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXsdRepresentation(XsdType newXsdRepresentation)
  {
    XsdType oldXsdRepresentation = xsdRepresentation;
    xsdRepresentation = newXsdRepresentation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION, oldXsdRepresentation, xsdRepresentation));
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
      case AbapdictionaryPackage.ABAP_TYPE__NAME:
        return basicSetName(null, msgs);
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
      case AbapdictionaryPackage.ABAP_TYPE__NAME:
        return getName();
      case AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION:
        if (resolve) return getXsdRepresentation();
        return basicGetXsdRepresentation();
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
      case AbapdictionaryPackage.ABAP_TYPE__NAME:
        setName((runtime.primitivetypes.String)newValue);
        return;
      case AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION:
        setXsdRepresentation((XsdType)newValue);
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
      case AbapdictionaryPackage.ABAP_TYPE__NAME:
        setName((runtime.primitivetypes.String)null);
        return;
      case AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION:
        setXsdRepresentation((XsdType)null);
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
      case AbapdictionaryPackage.ABAP_TYPE__NAME:
        return name != null;
      case AbapdictionaryPackage.ABAP_TYPE__XSD_REPRESENTATION:
        return xsdRepresentation != null;
    }
    return super.eIsSet(featureID);
  }

} //AbapTypeImpl
