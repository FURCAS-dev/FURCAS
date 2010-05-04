/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.processintegration.impl;

import behavioral.events.Subscription;

import dataaccess.expressions.MethodCallExpression;

import integration.processintegration.IntegrationScenario;
import integration.processintegration.ProcessComponentInteraction;
import integration.processintegration.ProcessintegrationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Component Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getMethodCalls <em>Method Calls</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessComponentInteractionImpl extends EObjectImpl implements ProcessComponentInteraction
{
  /**
   * The cached value of the '{@link #getMethodCalls() <em>Method Calls</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodCalls()
   * @generated
   * @ordered
   */
  protected EList<MethodCallExpression> methodCalls;

  /**
   * The cached value of the '{@link #getSubscriptions() <em>Subscriptions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubscriptions()
   * @generated
   * @ordered
   */
  protected EList<Subscription> subscriptions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcessComponentInteractionImpl()
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
    return ProcessintegrationPackage.Literals.PROCESS_COMPONENT_INTERACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegrationScenario getUses()
  {
    if (eContainerFeatureID() != ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES) return null;
    return (IntegrationScenario)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUses(IntegrationScenario newUses, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newUses, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUses(IntegrationScenario newUses)
  {
    if (newUses != eInternalContainer() || (eContainerFeatureID() != ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES && newUses != null))
    {
      if (EcoreUtil.isAncestor(this, newUses))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newUses != null)
        msgs = ((InternalEObject)newUses).eInverseAdd(this, ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS, IntegrationScenario.class, msgs);
      msgs = basicSetUses(newUses, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES, newUses, newUses));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MethodCallExpression> getMethodCalls()
  {
    if (methodCalls == null)
    {
      methodCalls = new EObjectResolvingEList<MethodCallExpression>(MethodCallExpression.class, this, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS);
    }
    return methodCalls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Subscription> getSubscriptions()
  {
    if (subscriptions == null)
    {
      subscriptions = new EObjectResolvingEList<Subscription>(Subscription.class, this, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS);
    }
    return subscriptions;
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetUses((IntegrationScenario)otherEnd, msgs);
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        return basicSetUses(null, msgs);
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        return eInternalContainer().eInverseRemove(this, ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS, IntegrationScenario.class, msgs);
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        return getUses();
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS:
        return getMethodCalls();
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS:
        return getSubscriptions();
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        setUses((IntegrationScenario)newValue);
        return;
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS:
        getMethodCalls().clear();
        getMethodCalls().addAll((Collection<? extends MethodCallExpression>)newValue);
        return;
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS:
        getSubscriptions().clear();
        getSubscriptions().addAll((Collection<? extends Subscription>)newValue);
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        setUses((IntegrationScenario)null);
        return;
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS:
        getMethodCalls().clear();
        return;
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS:
        getSubscriptions().clear();
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
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
        return getUses() != null;
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS:
        return methodCalls != null && !methodCalls.isEmpty();
      case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS:
        return subscriptions != null && !subscriptions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProcessComponentInteractionImpl
