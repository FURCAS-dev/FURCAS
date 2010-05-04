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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sproxy_content.BO;
import sproxy_content.BONode;
import sproxy_content.Sproxy_contentPackage;
import sproxy_content.StatusDerivator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.BOImpl#getRootNode <em>Root Node</em>}</li>
 *   <li>{@link sproxy_content.impl.BOImpl#getStatusDerivators <em>Status Derivators</em>}</li>
 *   <li>{@link sproxy_content.impl.BOImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link sproxy_content.impl.BOImpl#getProjections <em>Projections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BOImpl extends NamedElementImpl implements BO
{
  /**
   * The cached value of the '{@link #getRootNode() <em>Root Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootNode()
   * @generated
   * @ordered
   */
  protected BONode rootNode;

  /**
   * The cached value of the '{@link #getStatusDerivators() <em>Status Derivators</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusDerivators()
   * @generated
   * @ordered
   */
  protected EList<StatusDerivator> statusDerivators;

  /**
   * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplate()
   * @generated
   * @ordered
   */
  protected BO template;

  /**
   * The cached value of the '{@link #getProjections() <em>Projections</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjections()
   * @generated
   * @ordered
   */
  protected EList<BO> projections;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BOImpl()
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
    return Sproxy_contentPackage.Literals.BO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode getRootNode()
  {
    return rootNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRootNode(BONode newRootNode, NotificationChain msgs)
  {
    BONode oldRootNode = rootNode;
    rootNode = newRootNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO__ROOT_NODE, oldRootNode, newRootNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootNode(BONode newRootNode)
  {
    if (newRootNode != rootNode)
    {
      NotificationChain msgs = null;
      if (rootNode != null)
        msgs = ((InternalEObject)rootNode).eInverseRemove(this, Sproxy_contentPackage.BO_NODE__BO, BONode.class, msgs);
      if (newRootNode != null)
        msgs = ((InternalEObject)newRootNode).eInverseAdd(this, Sproxy_contentPackage.BO_NODE__BO, BONode.class, msgs);
      msgs = basicSetRootNode(newRootNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO__ROOT_NODE, newRootNode, newRootNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatusDerivator> getStatusDerivators()
  {
    if (statusDerivators == null)
    {
      statusDerivators = new EObjectResolvingEList<StatusDerivator>(StatusDerivator.class, this, Sproxy_contentPackage.BO__STATUS_DERIVATORS);
    }
    return statusDerivators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BO getTemplate()
  {
    if (template != null && template.eIsProxy())
    {
      InternalEObject oldTemplate = (InternalEObject)template;
      template = (BO)eResolveProxy(oldTemplate);
      if (template != oldTemplate)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.BO__TEMPLATE, oldTemplate, template));
      }
    }
    return template;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BO basicGetTemplate()
  {
    return template;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplate(BO newTemplate, NotificationChain msgs)
  {
    BO oldTemplate = template;
    template = newTemplate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO__TEMPLATE, oldTemplate, newTemplate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplate(BO newTemplate)
  {
    if (newTemplate != template)
    {
      NotificationChain msgs = null;
      if (template != null)
        msgs = ((InternalEObject)template).eInverseRemove(this, Sproxy_contentPackage.BO__PROJECTIONS, BO.class, msgs);
      if (newTemplate != null)
        msgs = ((InternalEObject)newTemplate).eInverseAdd(this, Sproxy_contentPackage.BO__PROJECTIONS, BO.class, msgs);
      msgs = basicSetTemplate(newTemplate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.BO__TEMPLATE, newTemplate, newTemplate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BO> getProjections()
  {
    if (projections == null)
    {
      projections = new EObjectWithInverseResolvingEList<BO>(BO.class, this, Sproxy_contentPackage.BO__PROJECTIONS, Sproxy_contentPackage.BO__TEMPLATE);
    }
    return projections;
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        if (rootNode != null)
          msgs = ((InternalEObject)rootNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.BO__ROOT_NODE, null, msgs);
        return basicSetRootNode((BONode)otherEnd, msgs);
      case Sproxy_contentPackage.BO__TEMPLATE:
        if (template != null)
          msgs = ((InternalEObject)template).eInverseRemove(this, Sproxy_contentPackage.BO__PROJECTIONS, BO.class, msgs);
        return basicSetTemplate((BO)otherEnd, msgs);
      case Sproxy_contentPackage.BO__PROJECTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjections()).basicAdd(otherEnd, msgs);
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        return basicSetRootNode(null, msgs);
      case Sproxy_contentPackage.BO__TEMPLATE:
        return basicSetTemplate(null, msgs);
      case Sproxy_contentPackage.BO__PROJECTIONS:
        return ((InternalEList<?>)getProjections()).basicRemove(otherEnd, msgs);
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        return getRootNode();
      case Sproxy_contentPackage.BO__STATUS_DERIVATORS:
        return getStatusDerivators();
      case Sproxy_contentPackage.BO__TEMPLATE:
        if (resolve) return getTemplate();
        return basicGetTemplate();
      case Sproxy_contentPackage.BO__PROJECTIONS:
        return getProjections();
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        setRootNode((BONode)newValue);
        return;
      case Sproxy_contentPackage.BO__STATUS_DERIVATORS:
        getStatusDerivators().clear();
        getStatusDerivators().addAll((Collection<? extends StatusDerivator>)newValue);
        return;
      case Sproxy_contentPackage.BO__TEMPLATE:
        setTemplate((BO)newValue);
        return;
      case Sproxy_contentPackage.BO__PROJECTIONS:
        getProjections().clear();
        getProjections().addAll((Collection<? extends BO>)newValue);
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        setRootNode((BONode)null);
        return;
      case Sproxy_contentPackage.BO__STATUS_DERIVATORS:
        getStatusDerivators().clear();
        return;
      case Sproxy_contentPackage.BO__TEMPLATE:
        setTemplate((BO)null);
        return;
      case Sproxy_contentPackage.BO__PROJECTIONS:
        getProjections().clear();
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
      case Sproxy_contentPackage.BO__ROOT_NODE:
        return rootNode != null;
      case Sproxy_contentPackage.BO__STATUS_DERIVATORS:
        return statusDerivators != null && !statusDerivators.isEmpty();
      case Sproxy_contentPackage.BO__TEMPLATE:
        return template != null;
      case Sproxy_contentPackage.BO__PROJECTIONS:
        return projections != null && !projections.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BOImpl
