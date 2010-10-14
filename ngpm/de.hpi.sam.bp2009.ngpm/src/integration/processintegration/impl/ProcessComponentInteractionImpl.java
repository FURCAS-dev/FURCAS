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

import modelmanagement.processcomponents.ProcessComponent;
import modelmanagement.processcomponents.ProcesscomponentsPackage;
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
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getInitiatorProcessComponent <em>Initiator Process Component</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getProcessComponent <em>Process Component</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getMethodCalls <em>Method Calls</em>}</li>
 *   <li>{@link integration.processintegration.impl.ProcessComponentInteractionImpl#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessComponentInteractionImpl extends EObjectImpl implements ProcessComponentInteraction {
	/**
     * The cached value of the '{@link #getInitiatorProcessComponent() <em>Initiator Process Component</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInitiatorProcessComponent()
     * @generated
     * @ordered
     */
	protected ProcessComponent initiatorProcessComponent;

	/**
     * The cached value of the '{@link #getProcessComponent() <em>Process Component</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProcessComponent()
     * @generated
     * @ordered
     */
	protected ProcessComponent processComponent;

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
	protected ProcessComponentInteractionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ProcessintegrationPackage.Literals.PROCESS_COMPONENT_INTERACTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponent getInitiatorProcessComponent() {
        if (initiatorProcessComponent != null && initiatorProcessComponent.eIsProxy()) {
            InternalEObject oldInitiatorProcessComponent = (InternalEObject)initiatorProcessComponent;
            initiatorProcessComponent = (ProcessComponent)eResolveProxy(oldInitiatorProcessComponent);
            if (initiatorProcessComponent != oldInitiatorProcessComponent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT, oldInitiatorProcessComponent, initiatorProcessComponent));
            }
        }
        return initiatorProcessComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponent basicGetInitiatorProcessComponent() {
        return initiatorProcessComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInitiatorProcessComponent(ProcessComponent newInitiatorProcessComponent, NotificationChain msgs) {
        ProcessComponent oldInitiatorProcessComponent = initiatorProcessComponent;
        initiatorProcessComponent = newInitiatorProcessComponent;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT, oldInitiatorProcessComponent, newInitiatorProcessComponent);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInitiatorProcessComponent(ProcessComponent newInitiatorProcessComponent) {
        if (newInitiatorProcessComponent != initiatorProcessComponent) {
            NotificationChain msgs = null;
            if (initiatorProcessComponent != null)
                msgs = ((InternalEObject)initiatorProcessComponent).eInverseRemove(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, ProcessComponent.class, msgs);
            if (newInitiatorProcessComponent != null)
                msgs = ((InternalEObject)newInitiatorProcessComponent).eInverseAdd(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, ProcessComponent.class, msgs);
            msgs = basicSetInitiatorProcessComponent(newInitiatorProcessComponent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT, newInitiatorProcessComponent, newInitiatorProcessComponent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponent getProcessComponent() {
        if (processComponent != null && processComponent.eIsProxy()) {
            InternalEObject oldProcessComponent = (InternalEObject)processComponent;
            processComponent = (ProcessComponent)eResolveProxy(oldProcessComponent);
            if (processComponent != oldProcessComponent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT, oldProcessComponent, processComponent));
            }
        }
        return processComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponent basicGetProcessComponent() {
        return processComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetProcessComponent(ProcessComponent newProcessComponent, NotificationChain msgs) {
        ProcessComponent oldProcessComponent = processComponent;
        processComponent = newProcessComponent;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT, oldProcessComponent, newProcessComponent);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProcessComponent(ProcessComponent newProcessComponent) {
        if (newProcessComponent != processComponent) {
            NotificationChain msgs = null;
            if (processComponent != null)
                msgs = ((InternalEObject)processComponent).eInverseRemove(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, ProcessComponent.class, msgs);
            if (newProcessComponent != null)
                msgs = ((InternalEObject)newProcessComponent).eInverseAdd(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, ProcessComponent.class, msgs);
            msgs = basicSetProcessComponent(newProcessComponent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT, newProcessComponent, newProcessComponent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IntegrationScenario getUses() {
        if (eContainerFeatureID() != ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES) return null;
        return (IntegrationScenario)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntegrationScenario basicGetUses() {
        if (eContainerFeatureID() != ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES) return null;
        return (IntegrationScenario)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetUses(IntegrationScenario newUses, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newUses, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUses(IntegrationScenario newUses) {
        if (newUses != eInternalContainer() || (eContainerFeatureID() != ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES && newUses != null)) {
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
	public EList<MethodCallExpression> getMethodCalls() {
        if (methodCalls == null) {
            methodCalls = new EObjectResolvingEList<MethodCallExpression>(MethodCallExpression.class, this, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS);
        }
        return methodCalls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Subscription> getSubscriptions() {
        if (subscriptions == null) {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                if (initiatorProcessComponent != null)
                    msgs = ((InternalEObject)initiatorProcessComponent).eInverseRemove(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, ProcessComponent.class, msgs);
                return basicSetInitiatorProcessComponent((ProcessComponent)otherEnd, msgs);
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                if (processComponent != null)
                    msgs = ((InternalEObject)processComponent).eInverseRemove(this, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, ProcessComponent.class, msgs);
                return basicSetProcessComponent((ProcessComponent)otherEnd, msgs);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                return basicSetInitiatorProcessComponent(null, msgs);
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                return basicSetProcessComponent(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                if (resolve) return getInitiatorProcessComponent();
                return basicGetInitiatorProcessComponent();
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                if (resolve) return getProcessComponent();
                return basicGetProcessComponent();
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
                if (resolve) return getUses();
                return basicGetUses();
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
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                setInitiatorProcessComponent((ProcessComponent)newValue);
                return;
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                setProcessComponent((ProcessComponent)newValue);
                return;
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
	public void eUnset(int featureID) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                setInitiatorProcessComponent((ProcessComponent)null);
                return;
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                setProcessComponent((ProcessComponent)null);
                return;
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
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT:
                return initiatorProcessComponent != null;
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT:
                return processComponent != null;
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES:
                return basicGetUses() != null;
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__METHOD_CALLS:
                return methodCalls != null && !methodCalls.isEmpty();
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS:
                return subscriptions != null && !subscriptions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ProcessComponentInteractionImpl
