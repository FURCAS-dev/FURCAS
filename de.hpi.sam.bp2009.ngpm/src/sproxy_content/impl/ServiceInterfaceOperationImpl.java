/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sproxy_content.DataType;
import sproxy_content.ServiceInterfaceOperation;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Interface Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.ServiceInterfaceOperationImpl#getRequestMessageType <em>Request Message Type</em>}</li>
 *   <li>{@link sproxy_content.impl.ServiceInterfaceOperationImpl#getResponseMessageType <em>Response Message Type</em>}</li>
 *   <li>{@link sproxy_content.impl.ServiceInterfaceOperationImpl#getFaultMessageType <em>Fault Message Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceInterfaceOperationImpl extends NamedElementImpl implements ServiceInterfaceOperation
{
  /**
   * The cached value of the '{@link #getRequestMessageType() <em>Request Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequestMessageType()
   * @generated
   * @ordered
   */
  protected DataType requestMessageType;

  /**
   * The cached value of the '{@link #getResponseMessageType() <em>Response Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponseMessageType()
   * @generated
   * @ordered
   */
  protected DataType responseMessageType;

  /**
   * The cached value of the '{@link #getFaultMessageType() <em>Fault Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFaultMessageType()
   * @generated
   * @ordered
   */
  protected DataType faultMessageType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceInterfaceOperationImpl()
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
    return Sproxy_contentPackage.Literals.SERVICE_INTERFACE_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getRequestMessageType()
  {
    if (requestMessageType != null && requestMessageType.eIsProxy())
    {
      InternalEObject oldRequestMessageType = (InternalEObject)requestMessageType;
      requestMessageType = (DataType)eResolveProxy(oldRequestMessageType);
      if (requestMessageType != oldRequestMessageType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE, oldRequestMessageType, requestMessageType));
      }
    }
    return requestMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType basicGetRequestMessageType()
  {
    return requestMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequestMessageType(DataType newRequestMessageType)
  {
    DataType oldRequestMessageType = requestMessageType;
    requestMessageType = newRequestMessageType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE, oldRequestMessageType, requestMessageType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getResponseMessageType()
  {
    if (responseMessageType != null && responseMessageType.eIsProxy())
    {
      InternalEObject oldResponseMessageType = (InternalEObject)responseMessageType;
      responseMessageType = (DataType)eResolveProxy(oldResponseMessageType);
      if (responseMessageType != oldResponseMessageType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE, oldResponseMessageType, responseMessageType));
      }
    }
    return responseMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType basicGetResponseMessageType()
  {
    return responseMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResponseMessageType(DataType newResponseMessageType)
  {
    DataType oldResponseMessageType = responseMessageType;
    responseMessageType = newResponseMessageType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE, oldResponseMessageType, responseMessageType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getFaultMessageType()
  {
    if (faultMessageType != null && faultMessageType.eIsProxy())
    {
      InternalEObject oldFaultMessageType = (InternalEObject)faultMessageType;
      faultMessageType = (DataType)eResolveProxy(oldFaultMessageType);
      if (faultMessageType != oldFaultMessageType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE, oldFaultMessageType, faultMessageType));
      }
    }
    return faultMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType basicGetFaultMessageType()
  {
    return faultMessageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFaultMessageType(DataType newFaultMessageType)
  {
    DataType oldFaultMessageType = faultMessageType;
    faultMessageType = newFaultMessageType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE, oldFaultMessageType, faultMessageType));
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
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE:
        if (resolve) return getRequestMessageType();
        return basicGetRequestMessageType();
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE:
        if (resolve) return getResponseMessageType();
        return basicGetResponseMessageType();
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE:
        if (resolve) return getFaultMessageType();
        return basicGetFaultMessageType();
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
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE:
        setRequestMessageType((DataType)newValue);
        return;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE:
        setResponseMessageType((DataType)newValue);
        return;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE:
        setFaultMessageType((DataType)newValue);
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
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE:
        setRequestMessageType((DataType)null);
        return;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE:
        setResponseMessageType((DataType)null);
        return;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE:
        setFaultMessageType((DataType)null);
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
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE:
        return requestMessageType != null;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE:
        return responseMessageType != null;
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE:
        return faultMessageType != null;
    }
    return super.eIsSet(featureID);
  }

} //ServiceInterfaceOperationImpl
