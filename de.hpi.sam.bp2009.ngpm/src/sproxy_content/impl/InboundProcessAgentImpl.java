/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import sproxy_content.InboundProcessAgent;
import sproxy_content.ServiceInterface;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inbound Process Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.InboundProcessAgentImpl#getInboundServiceInterfaces <em>Inbound Service Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InboundProcessAgentImpl extends ProcessAgentImpl implements InboundProcessAgent
{
  /**
   * The cached value of the '{@link #getInboundServiceInterfaces() <em>Inbound Service Interfaces</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInboundServiceInterfaces()
   * @generated
   * @ordered
   */
  protected EList<ServiceInterface> inboundServiceInterfaces;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InboundProcessAgentImpl()
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
    return Sproxy_contentPackage.Literals.INBOUND_PROCESS_AGENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceInterface> getInboundServiceInterfaces()
  {
    if (inboundServiceInterfaces == null)
    {
      inboundServiceInterfaces = new EObjectResolvingEList<ServiceInterface>(ServiceInterface.class, this, Sproxy_contentPackage.INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES);
    }
    return inboundServiceInterfaces;
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
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES:
        return getInboundServiceInterfaces();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES:
        getInboundServiceInterfaces().clear();
        getInboundServiceInterfaces().addAll((Collection<? extends ServiceInterface>)newValue);
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
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES:
        getInboundServiceInterfaces().clear();
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
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES:
        return inboundServiceInterfaces != null && !inboundServiceInterfaces.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InboundProcessAgentImpl
