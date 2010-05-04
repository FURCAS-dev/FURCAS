/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import sproxy_content.Action;
import sproxy_content.Association;
import sproxy_content.BO;
import sproxy_content.BONode;
import sproxy_content.DataType;
import sproxy_content.FieldProperties;
import sproxy_content.NodeProperties;
import sproxy_content.Query;
import sproxy_content.Sproxy_contentPackage;
import sproxy_content.StatusAndActionSchema;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BO Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getNodeDataType <em>Node Data Type</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getBo <em>Bo</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getStatusAndActionSchemas <em>Status And Action Schemas</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getOutboundAssociations <em>Outbound Associations</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link sproxy_content.impl.BONodeImpl#getFieldProperties <em>Field Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BONodeImpl extends NamedElementImpl implements BONode
{
  /**
   * The cached value of the '{@link #getNodeDataType() <em>Node Data Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeDataType()
   * @generated
   * @ordered
   */
  protected DataType nodeDataType;

  /**
   * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActions()
   * @generated
   * @ordered
   */
  protected EList<Action> actions;

  /**
   * The cached value of the '{@link #getStatusAndActionSchemas() <em>Status And Action Schemas</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusAndActionSchemas()
   * @generated
   * @ordered
   */
  protected EList<StatusAndActionSchema> statusAndActionSchemas;

  /**
   * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation()
   * @generated
   * @ordered
   */
  protected EList<Association> association;

  /**
   * The cached value of the '{@link #getOutboundAssociations() <em>Outbound Associations</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutboundAssociations()
   * @generated
   * @ordered
   */
  protected EList<Association> outboundAssociations;

  /**
   * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueries()
   * @generated
   * @ordered
   */
  protected EList<Query> queries;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected NodeProperties properties;

  /**
   * The cached value of the '{@link #getFieldProperties() <em>Field Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldProperties()
   * @generated
   * @ordered
   */
  protected EList<FieldProperties> fieldProperties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BONodeImpl()
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
    return Sproxy_contentPackage.Literals.BO_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getNodeDataType()
  {
    if (nodeDataType != null && nodeDataType.eIsProxy())
    {
      InternalEObject oldNodeDataType = (InternalEObject)nodeDataType;
      nodeDataType = (DataType)eResolveProxy(oldNodeDataType);
      if (nodeDataType != oldNodeDataType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE, oldNodeDataType, nodeDataType));
      }
    }
    return nodeDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType basicGetNodeDataType()
  {
    return nodeDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeDataType(DataType newNodeDataType)
  {
    DataType oldNodeDataType = nodeDataType;
    nodeDataType = newNodeDataType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE, oldNodeDataType, nodeDataType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BO getBo()
  {
    if (eContainerFeatureID() != Sproxy_contentPackage.BO_NODE__BO) return null;
    return (BO)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBo(BO newBo, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newBo, Sproxy_contentPackage.BO_NODE__BO, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBo(BO newBo)
  {
    if (newBo != eInternalContainer() || (eContainerFeatureID() != Sproxy_contentPackage.BO_NODE__BO && newBo != null))
    {
      if (EcoreUtil.isAncestor(this, newBo))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newBo != null)
        msgs = ((InternalEObject)newBo).eInverseAdd(this, Sproxy_contentPackage.BO__ROOT_NODE, BO.class, msgs);
      msgs = basicSetBo(newBo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO_NODE__BO, newBo, newBo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Action> getActions()
  {
    if (actions == null)
    {
      actions = new EObjectContainmentEList<Action>(Action.class, this, Sproxy_contentPackage.BO_NODE__ACTIONS);
    }
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatusAndActionSchema> getStatusAndActionSchemas()
  {
    if (statusAndActionSchemas == null)
    {
      statusAndActionSchemas = new EObjectContainmentEList<StatusAndActionSchema>(StatusAndActionSchema.class, this, Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS);
    }
    return statusAndActionSchemas;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Association> getAssociation()
  {
    if (association == null)
    {
      association = new EObjectWithInverseResolvingEList<Association>(Association.class, this, Sproxy_contentPackage.BO_NODE__ASSOCIATION, Sproxy_contentPackage.ASSOCIATION__TARGET_NODE);
    }
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Association> getOutboundAssociations()
  {
    if (outboundAssociations == null)
    {
      outboundAssociations = new EObjectWithInverseResolvingEList<Association>(Association.class, this, Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS, Sproxy_contentPackage.ASSOCIATION__OWNER);
    }
    return outboundAssociations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Query> getQueries()
  {
    if (queries == null)
    {
      queries = new EObjectContainmentEList<Query>(Query.class, this, Sproxy_contentPackage.BO_NODE__QUERIES);
    }
    return queries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeProperties getProperties()
  {
    if (properties != null && properties.eIsProxy())
    {
      InternalEObject oldProperties = (InternalEObject)properties;
      properties = (NodeProperties)eResolveProxy(oldProperties);
      if (properties != oldProperties)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.BO_NODE__PROPERTIES, oldProperties, properties));
      }
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeProperties basicGetProperties()
  {
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperties(NodeProperties newProperties)
  {
    NodeProperties oldProperties = properties;
    properties = newProperties;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO_NODE__PROPERTIES, oldProperties, properties));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FieldProperties> getFieldProperties()
  {
    if (fieldProperties == null)
    {
      fieldProperties = new EObjectContainmentEList<FieldProperties>(FieldProperties.class, this, Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES);
    }
    return fieldProperties;
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
      case Sproxy_contentPackage.BO_NODE__BO:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetBo((BO)otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociation()).basicAdd(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutboundAssociations()).basicAdd(otherEnd, msgs);
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
      case Sproxy_contentPackage.BO_NODE__BO:
        return basicSetBo(null, msgs);
      case Sproxy_contentPackage.BO_NODE__ACTIONS:
        return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS:
        return ((InternalEList<?>)getStatusAndActionSchemas()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        return ((InternalEList<?>)getAssociation()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        return ((InternalEList<?>)getOutboundAssociations()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__QUERIES:
        return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
      case Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES:
        return ((InternalEList<?>)getFieldProperties()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case Sproxy_contentPackage.BO_NODE__BO:
        return eInternalContainer().eInverseRemove(this, Sproxy_contentPackage.BO__ROOT_NODE, BO.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE:
        if (resolve) return getNodeDataType();
        return basicGetNodeDataType();
      case Sproxy_contentPackage.BO_NODE__BO:
        return getBo();
      case Sproxy_contentPackage.BO_NODE__ACTIONS:
        return getActions();
      case Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS:
        return getStatusAndActionSchemas();
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        return getAssociation();
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        return getOutboundAssociations();
      case Sproxy_contentPackage.BO_NODE__QUERIES:
        return getQueries();
      case Sproxy_contentPackage.BO_NODE__PROPERTIES:
        if (resolve) return getProperties();
        return basicGetProperties();
      case Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES:
        return getFieldProperties();
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
      case Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE:
        setNodeDataType((DataType)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__BO:
        setBo((BO)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__ACTIONS:
        getActions().clear();
        getActions().addAll((Collection<? extends Action>)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS:
        getStatusAndActionSchemas().clear();
        getStatusAndActionSchemas().addAll((Collection<? extends StatusAndActionSchema>)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        getAssociation().clear();
        getAssociation().addAll((Collection<? extends Association>)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        getOutboundAssociations().clear();
        getOutboundAssociations().addAll((Collection<? extends Association>)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__QUERIES:
        getQueries().clear();
        getQueries().addAll((Collection<? extends Query>)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__PROPERTIES:
        setProperties((NodeProperties)newValue);
        return;
      case Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES:
        getFieldProperties().clear();
        getFieldProperties().addAll((Collection<? extends FieldProperties>)newValue);
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
      case Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE:
        setNodeDataType((DataType)null);
        return;
      case Sproxy_contentPackage.BO_NODE__BO:
        setBo((BO)null);
        return;
      case Sproxy_contentPackage.BO_NODE__ACTIONS:
        getActions().clear();
        return;
      case Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS:
        getStatusAndActionSchemas().clear();
        return;
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        getAssociation().clear();
        return;
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        getOutboundAssociations().clear();
        return;
      case Sproxy_contentPackage.BO_NODE__QUERIES:
        getQueries().clear();
        return;
      case Sproxy_contentPackage.BO_NODE__PROPERTIES:
        setProperties((NodeProperties)null);
        return;
      case Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES:
        getFieldProperties().clear();
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
      case Sproxy_contentPackage.BO_NODE__NODE_DATA_TYPE:
        return nodeDataType != null;
      case Sproxy_contentPackage.BO_NODE__BO:
        return getBo() != null;
      case Sproxy_contentPackage.BO_NODE__ACTIONS:
        return actions != null && !actions.isEmpty();
      case Sproxy_contentPackage.BO_NODE__STATUS_AND_ACTION_SCHEMAS:
        return statusAndActionSchemas != null && !statusAndActionSchemas.isEmpty();
      case Sproxy_contentPackage.BO_NODE__ASSOCIATION:
        return association != null && !association.isEmpty();
      case Sproxy_contentPackage.BO_NODE__OUTBOUND_ASSOCIATIONS:
        return outboundAssociations != null && !outboundAssociations.isEmpty();
      case Sproxy_contentPackage.BO_NODE__QUERIES:
        return queries != null && !queries.isEmpty();
      case Sproxy_contentPackage.BO_NODE__PROPERTIES:
        return properties != null;
      case Sproxy_contentPackage.BO_NODE__FIELD_PROPERTIES:
        return fieldProperties != null && !fieldProperties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BONodeImpl
