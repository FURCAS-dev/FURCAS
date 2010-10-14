/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events.impl;

import behavioral.events.EventProducer;
import behavioral.events.EventsPackage;
import behavioral.events.Subscription;

import data.classes.ClassesPackage;
import data.classes.MethodSignature;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Producer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.events.impl.EventProducerImpl#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link behavioral.events.impl.EventProducerImpl#getNotificationSignatures <em>Notification Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventProducerImpl extends EObjectImpl implements EventProducer {
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
     * The cached value of the '{@link #getNotificationSignatures() <em>Notification Signatures</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNotificationSignatures()
     * @generated
     * @ordered
     */
	protected EList<MethodSignature> notificationSignatures;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EventProducerImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EventsPackage.Literals.EVENT_PRODUCER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Subscription> getSubscriptions() {
        if (subscriptions == null) {
            subscriptions = new EObjectWithInverseResolvingEList<Subscription>(Subscription.class, this, EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS, EventsPackage.SUBSCRIPTION__PRODUCER);
        }
        return subscriptions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> getNotificationSignatures() {
        if (notificationSignatures == null) {
            notificationSignatures = new EObjectContainmentWithInverseEList.Resolving<MethodSignature>(MethodSignature.class, this, EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES, ClassesPackage.METHOD_SIGNATURE__PRODUCER);
        }
        return notificationSignatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubscriptions()).basicAdd(otherEnd, msgs);
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getNotificationSignatures()).basicAdd(otherEnd, msgs);
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
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                return ((InternalEList<?>)getSubscriptions()).basicRemove(otherEnd, msgs);
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                return ((InternalEList<?>)getNotificationSignatures()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                return getSubscriptions();
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                return getNotificationSignatures();
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
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                getSubscriptions().clear();
                getSubscriptions().addAll((Collection<? extends Subscription>)newValue);
                return;
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                getNotificationSignatures().clear();
                getNotificationSignatures().addAll((Collection<? extends MethodSignature>)newValue);
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
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                getSubscriptions().clear();
                return;
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                getNotificationSignatures().clear();
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
            case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS:
                return subscriptions != null && !subscriptions.isEmpty();
            case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES:
                return notificationSignatures != null && !notificationSignatures.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //EventProducerImpl
