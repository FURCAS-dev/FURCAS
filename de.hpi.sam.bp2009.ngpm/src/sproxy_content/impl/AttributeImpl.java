/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import abapmapping.abapdictionary.UnstructuredAbapType;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sproxy_content.Attribute;
import sproxy_content.Field;
import sproxy_content.FieldProperties;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.AttributeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link sproxy_content.impl.AttributeImpl#getStatusAttribute <em>Status Attribute</em>}</li>
 *   <li>{@link sproxy_content.impl.AttributeImpl#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends NamedElementImpl implements Attribute
{
  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<FieldProperties> properties;

  /**
   * The cached value of the '{@link #getStatusAttribute() <em>Status Attribute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusAttribute()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean statusAttribute;

  /**
   * The cached value of the '{@link #getAbapType() <em>Abap Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbapType()
   * @generated
   * @ordered
   */
  protected UnstructuredAbapType abapType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
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
    return Sproxy_contentPackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FieldProperties> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectWithInverseResolvingEList<FieldProperties>(FieldProperties.class, this, Sproxy_contentPackage.ATTRIBUTE__PROPERTIES, Sproxy_contentPackage.FIELD_PROPERTIES__FIELD);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getStatusAttribute()
  {
    return statusAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatusAttribute(runtime.primitivetypes.Boolean newStatusAttribute, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldStatusAttribute = statusAttribute;
    statusAttribute = newStatusAttribute;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE, oldStatusAttribute, newStatusAttribute);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatusAttribute(runtime.primitivetypes.Boolean newStatusAttribute)
  {
    if (newStatusAttribute != statusAttribute)
    {
      NotificationChain msgs = null;
      if (statusAttribute != null)
        msgs = ((InternalEObject)statusAttribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE, null, msgs);
      if (newStatusAttribute != null)
        msgs = ((InternalEObject)newStatusAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE, null, msgs);
      msgs = basicSetStatusAttribute(newStatusAttribute, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE, newStatusAttribute, newStatusAttribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnstructuredAbapType getAbapType()
  {
    if (abapType != null && abapType.eIsProxy())
    {
      InternalEObject oldAbapType = (InternalEObject)abapType;
      abapType = (UnstructuredAbapType)eResolveProxy(oldAbapType);
      if (abapType != oldAbapType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE, oldAbapType, abapType));
      }
    }
    return abapType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnstructuredAbapType basicGetAbapType()
  {
    return abapType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbapType(UnstructuredAbapType newAbapType)
  {
    UnstructuredAbapType oldAbapType = abapType;
    abapType = newAbapType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE, oldAbapType, abapType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE:
        return basicSetStatusAttribute(null, msgs);
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
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        return getProperties();
      case Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE:
        return getStatusAttribute();
      case Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE:
        if (resolve) return getAbapType();
        return basicGetAbapType();
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
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends FieldProperties>)newValue);
        return;
      case Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE:
        setStatusAttribute((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE:
        setAbapType((UnstructuredAbapType)newValue);
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
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        getProperties().clear();
        return;
      case Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE:
        setStatusAttribute((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE:
        setAbapType((UnstructuredAbapType)null);
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
      case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case Sproxy_contentPackage.ATTRIBUTE__STATUS_ATTRIBUTE:
        return statusAttribute != null;
      case Sproxy_contentPackage.ATTRIBUTE__ABAP_TYPE:
        return abapType != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == Field.class)
    {
      switch (derivedFeatureID)
      {
        case Sproxy_contentPackage.ATTRIBUTE__PROPERTIES: return Sproxy_contentPackage.FIELD__PROPERTIES;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == Field.class)
    {
      switch (baseFeatureID)
      {
        case Sproxy_contentPackage.FIELD__PROPERTIES: return Sproxy_contentPackage.ATTRIBUTE__PROPERTIES;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //AttributeImpl
