/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import abapmapping.abapdictionary.AbapType;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import sproxy_content.Attribute;
import sproxy_content.DataType;
import sproxy_content.Element;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.DataTypeImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link sproxy_content.impl.DataTypeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link sproxy_content.impl.DataTypeImpl#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeImpl extends NamedElementImpl implements DataType
{
  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<Element> elements;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getAbapType() <em>Abap Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbapType()
   * @generated
   * @ordered
   */
  protected AbapType abapType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeImpl()
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
    return Sproxy_contentPackage.Literals.DATA_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Element> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectResolvingEList<Element>(Element.class, this, Sproxy_contentPackage.DATA_TYPE__ELEMENTS);
    }
    return elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectResolvingEList<Attribute>(Attribute.class, this, Sproxy_contentPackage.DATA_TYPE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbapType getAbapType()
  {
    if (abapType != null && abapType.eIsProxy())
    {
      InternalEObject oldAbapType = (InternalEObject)abapType;
      abapType = (AbapType)eResolveProxy(oldAbapType);
      if (abapType != oldAbapType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE, oldAbapType, abapType));
      }
    }
    return abapType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbapType basicGetAbapType()
  {
    return abapType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbapType(AbapType newAbapType)
  {
    AbapType oldAbapType = abapType;
    abapType = newAbapType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE, oldAbapType, abapType));
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
      case Sproxy_contentPackage.DATA_TYPE__ELEMENTS:
        return getElements();
      case Sproxy_contentPackage.DATA_TYPE__ATTRIBUTES:
        return getAttributes();
      case Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE:
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
      case Sproxy_contentPackage.DATA_TYPE__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends Element>)newValue);
        return;
      case Sproxy_contentPackage.DATA_TYPE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE:
        setAbapType((AbapType)newValue);
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
      case Sproxy_contentPackage.DATA_TYPE__ELEMENTS:
        getElements().clear();
        return;
      case Sproxy_contentPackage.DATA_TYPE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE:
        setAbapType((AbapType)null);
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
      case Sproxy_contentPackage.DATA_TYPE__ELEMENTS:
        return elements != null && !elements.isEmpty();
      case Sproxy_contentPackage.DATA_TYPE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case Sproxy_contentPackage.DATA_TYPE__ABAP_TYPE:
        return abapType != null;
    }
    return super.eIsSet(featureID);
  }

} //DataTypeImpl
