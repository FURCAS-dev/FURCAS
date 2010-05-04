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
import sproxy_content.Operation;
import sproxy_content.OperationProperties;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.OperationImpl#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link sproxy_content.impl.OperationImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends NamedElementImpl implements Operation
{
  /**
   * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterType()
   * @generated
   * @ordered
   */
  protected DataType parameterType;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected OperationProperties properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
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
    return Sproxy_contentPackage.Literals.OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getParameterType()
  {
    if (parameterType != null && parameterType.eIsProxy())
    {
      InternalEObject oldParameterType = (InternalEObject)parameterType;
      parameterType = (DataType)eResolveProxy(oldParameterType);
      if (parameterType != oldParameterType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.OPERATION__PARAMETER_TYPE, oldParameterType, parameterType));
      }
    }
    return parameterType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType basicGetParameterType()
  {
    return parameterType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterType(DataType newParameterType)
  {
    DataType oldParameterType = parameterType;
    parameterType = newParameterType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION__PARAMETER_TYPE, oldParameterType, parameterType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationProperties getProperties()
  {
    if (properties != null && properties.eIsProxy())
    {
      InternalEObject oldProperties = (InternalEObject)properties;
      properties = (OperationProperties)eResolveProxy(oldProperties);
      if (properties != oldProperties)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.OPERATION__PROPERTIES, oldProperties, properties));
      }
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationProperties basicGetProperties()
  {
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperties(OperationProperties newProperties)
  {
    OperationProperties oldProperties = properties;
    properties = newProperties;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION__PROPERTIES, oldProperties, properties));
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
      case Sproxy_contentPackage.OPERATION__PARAMETER_TYPE:
        if (resolve) return getParameterType();
        return basicGetParameterType();
      case Sproxy_contentPackage.OPERATION__PROPERTIES:
        if (resolve) return getProperties();
        return basicGetProperties();
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
      case Sproxy_contentPackage.OPERATION__PARAMETER_TYPE:
        setParameterType((DataType)newValue);
        return;
      case Sproxy_contentPackage.OPERATION__PROPERTIES:
        setProperties((OperationProperties)newValue);
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
      case Sproxy_contentPackage.OPERATION__PARAMETER_TYPE:
        setParameterType((DataType)null);
        return;
      case Sproxy_contentPackage.OPERATION__PROPERTIES:
        setProperties((OperationProperties)null);
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
      case Sproxy_contentPackage.OPERATION__PARAMETER_TYPE:
        return parameterType != null;
      case Sproxy_contentPackage.OPERATION__PROPERTIES:
        return properties != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationImpl
