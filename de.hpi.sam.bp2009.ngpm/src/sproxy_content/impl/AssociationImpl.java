/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sproxy_content.Association;
import sproxy_content.AssociationProperties;
import sproxy_content.BONode;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.AssociationImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link sproxy_content.impl.AssociationImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link sproxy_content.impl.AssociationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link sproxy_content.impl.AssociationImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EObjectImpl implements Association
{
  /**
   * The cached value of the '{@link #getComposite() <em>Composite</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComposite()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean composite;

  /**
   * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNode()
   * @generated
   * @ordered
   */
  protected BONode targetNode;

  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected BONode owner;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected AssociationProperties properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationImpl()
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
    return Sproxy_contentPackage.Literals.ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getComposite()
  {
    return composite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComposite(runtime.primitivetypes.Boolean newComposite, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldComposite = composite;
    composite = newComposite;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__COMPOSITE, oldComposite, newComposite);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComposite(runtime.primitivetypes.Boolean newComposite)
  {
    if (newComposite != composite)
    {
      NotificationChain msgs = null;
      if (composite != null)
        msgs = ((InternalEObject)composite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.ASSOCIATION__COMPOSITE, null, msgs);
      if (newComposite != null)
        msgs = ((InternalEObject)newComposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.ASSOCIATION__COMPOSITE, null, msgs);
      msgs = basicSetComposite(newComposite, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__COMPOSITE, newComposite, newComposite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode getTargetNode()
  {
    if (targetNode != null && targetNode.eIsProxy())
    {
      InternalEObject oldTargetNode = (InternalEObject)targetNode;
      targetNode = (BONode)eResolveProxy(oldTargetNode);
      if (targetNode != oldTargetNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.ASSOCIATION__TARGET_NODE, oldTargetNode, targetNode));
      }
    }
    return targetNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode basicGetTargetNode()
  {
    return targetNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetNode(BONode newTargetNode, NotificationChain msgs)
  {
    BONode oldTargetNode = targetNode;
    targetNode = newTargetNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__TARGET_NODE, oldTargetNode, newTargetNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetNode(BONode newTargetNode)
  {
    if (newTargetNode != targetNode)
    {
      NotificationChain msgs = null;
      if (targetNode != null)
        msgs = ((InternalEObject)targetNode).eInverseRemove(this, Sproxy_contentPackage.BO_NODE__ASSOCIATION, BONode.class, msgs);
      if (newTargetNode != null)
        msgs = ((InternalEObject)newTargetNode).eInverseAdd(this, Sproxy_contentPackage.BO_NODE__ASSOCIATION, BONode.class, msgs);
      msgs = basicSetTargetNode(newTargetNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__TARGET_NODE, newTargetNode, newTargetNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode getOwner()
  {
    if (owner != null && owner.eIsProxy())
    {
      InternalEObject oldOwner = (InternalEObject)owner;
      owner = (BONode)eResolveProxy(oldOwner);
      if (owner != oldOwner)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.ASSOCIATION__OWNER, oldOwner, owner));
      }
    }
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode basicGetOwner()
  {
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwner(BONode newOwner, NotificationChain msgs)
  {
    BONode oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__OWNER, oldOwner, newOwner);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwner(BONode newOwner)
  {
    if (newOwner != owner)
    {
      NotificationChain msgs = null;
      if (owner != null)
        msgs = ((InternalEObject)owner).eInverseRemove(this, Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS, BONode.class, msgs);
      if (newOwner != null)
        msgs = ((InternalEObject)newOwner).eInverseAdd(this, Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS, BONode.class, msgs);
      msgs = basicSetOwner(newOwner, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__OWNER, newOwner, newOwner));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationProperties getProperties()
  {
    if (properties != null && properties.eIsProxy())
    {
      InternalEObject oldProperties = (InternalEObject)properties;
      properties = (AssociationProperties)eResolveProxy(oldProperties);
      if (properties != oldProperties)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.ASSOCIATION__PROPERTIES, oldProperties, properties));
      }
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationProperties basicGetProperties()
  {
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperties(AssociationProperties newProperties)
  {
    AssociationProperties oldProperties = properties;
    properties = newProperties;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.ASSOCIATION__PROPERTIES, oldProperties, properties));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        if (targetNode != null)
          msgs = ((InternalEObject)targetNode).eInverseRemove(this, Sproxy_contentPackage.BO_NODE__ASSOCIATION, BONode.class, msgs);
        return basicSetTargetNode((BONode)otherEnd, msgs);
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        if (owner != null)
          msgs = ((InternalEObject)owner).eInverseRemove(this, Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS, BONode.class, msgs);
        return basicSetOwner((BONode)otherEnd, msgs);
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
      case Sproxy_contentPackage.ASSOCIATION__COMPOSITE:
        return basicSetComposite(null, msgs);
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        return basicSetTargetNode(null, msgs);
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        return basicSetOwner(null, msgs);
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
      case Sproxy_contentPackage.ASSOCIATION__COMPOSITE:
        return getComposite();
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        if (resolve) return getTargetNode();
        return basicGetTargetNode();
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        if (resolve) return getOwner();
        return basicGetOwner();
      case Sproxy_contentPackage.ASSOCIATION__PROPERTIES:
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
      case Sproxy_contentPackage.ASSOCIATION__COMPOSITE:
        setComposite((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        setTargetNode((BONode)newValue);
        return;
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        setOwner((BONode)newValue);
        return;
      case Sproxy_contentPackage.ASSOCIATION__PROPERTIES:
        setProperties((AssociationProperties)newValue);
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
      case Sproxy_contentPackage.ASSOCIATION__COMPOSITE:
        setComposite((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        setTargetNode((BONode)null);
        return;
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        setOwner((BONode)null);
        return;
      case Sproxy_contentPackage.ASSOCIATION__PROPERTIES:
        setProperties((AssociationProperties)null);
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
      case Sproxy_contentPackage.ASSOCIATION__COMPOSITE:
        return composite != null;
      case Sproxy_contentPackage.ASSOCIATION__TARGET_NODE:
        return targetNode != null;
      case Sproxy_contentPackage.ASSOCIATION__OWNER:
        return owner != null;
      case Sproxy_contentPackage.ASSOCIATION__PROPERTIES:
        return properties != null;
    }
    return super.eIsSet(featureID);
  }

} //AssociationImpl
