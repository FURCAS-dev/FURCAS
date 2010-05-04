/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sproxy_content.OutboundProcessAgent;
import sproxy_content.ServiceInterface;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outbound Process Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.OutboundProcessAgentImpl#getOutboundServiceInterface <em>Outbound Service Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutboundProcessAgentImpl extends ProcessAgentImpl implements OutboundProcessAgent
{
  /**
   * The cached value of the '{@link #getOutboundServiceInterface() <em>Outbound Service Interface</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutboundServiceInterface()
   * @generated
   * @ordered
   */
  protected ServiceInterface outboundServiceInterface;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutboundProcessAgentImpl()
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
    return Sproxy_contentPackage.Literals.OUTBOUND_PROCESS_AGENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceInterface getOutboundServiceInterface()
  {
    if (outboundServiceInterface != null && outboundServiceInterface.eIsProxy())
    {
      InternalEObject oldOutboundServiceInterface = (InternalEObject)outboundServiceInterface;
      outboundServiceInterface = (ServiceInterface)eResolveProxy(oldOutboundServiceInterface);
      if (outboundServiceInterface != oldOutboundServiceInterface)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE, oldOutboundServiceInterface, outboundServiceInterface));
      }
    }
    return outboundServiceInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceInterface basicGetOutboundServiceInterface()
  {
    return outboundServiceInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutboundServiceInterface(ServiceInterface newOutboundServiceInterface)
  {
    ServiceInterface oldOutboundServiceInterface = outboundServiceInterface;
    outboundServiceInterface = newOutboundServiceInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE, oldOutboundServiceInterface, outboundServiceInterface));
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
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE:
        if (resolve) return getOutboundServiceInterface();
        return basicGetOutboundServiceInterface();
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
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE:
        setOutboundServiceInterface((ServiceInterface)newValue);
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
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE:
        setOutboundServiceInterface((ServiceInterface)null);
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
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE:
        return outboundServiceInterface != null;
    }
    return super.eIsSet(featureID);
  }

} //OutboundProcessAgentImpl
