/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events.impl;

import behavioral.events.EventFilter;
import behavioral.events.EventProducer;
import behavioral.events.EventsPackage;
import behavioral.events.Subscription;

import data.classes.ClassesPackage;
import data.classes.SapClass;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subscription</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.events.impl.SubscriptionImpl#getProducer <em>Producer</em>}</li>
 *   <li>{@link behavioral.events.impl.SubscriptionImpl#getFilters <em>Filters</em>}</li>
 *   <li>{@link behavioral.events.impl.SubscriptionImpl#getSubscribingClass <em>Subscribing Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubscriptionImpl extends NamedElementImpl implements Subscription {
	/**
     * The cached value of the '{@link #getProducer() <em>Producer</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProducer()
     * @generated
     * @ordered
     */
	protected EventProducer producer;

	/**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFilters()
     * @generated
     * @ordered
     */
	protected EList<EventFilter> filters;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SubscriptionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EventsPackage.Literals.SUBSCRIPTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventProducer getProducer() {
        if (producer != null && producer.eIsProxy()) {
            InternalEObject oldProducer = (InternalEObject)producer;
            producer = (EventProducer)eResolveProxy(oldProducer);
            if (producer != oldProducer) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.SUBSCRIPTION__PRODUCER, oldProducer, producer));
            }
        }
        return producer;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventProducer basicGetProducer() {
        return producer;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetProducer(EventProducer newProducer, NotificationChain msgs) {
        EventProducer oldProducer = producer;
        producer = newProducer;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.SUBSCRIPTION__PRODUCER, oldProducer, newProducer);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProducer(EventProducer newProducer) {
        if (newProducer != producer) {
            NotificationChain msgs = null;
            if (producer != null)
                msgs = ((InternalEObject)producer).eInverseRemove(this, EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS, EventProducer.class, msgs);
            if (newProducer != null)
                msgs = ((InternalEObject)newProducer).eInverseAdd(this, EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS, EventProducer.class, msgs);
            msgs = basicSetProducer(newProducer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.SUBSCRIPTION__PRODUCER, newProducer, newProducer));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EventFilter> getFilters() {
        if (filters == null) {
            filters = new EObjectContainmentWithInverseEList.Resolving<EventFilter>(EventFilter.class, this, EventsPackage.SUBSCRIPTION__FILTERS, EventsPackage.EVENT_FILTER__SUBSCRIPTION);
        }
        return filters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getSubscribingClass() {
        if (eContainerFeatureID() != EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetSubscribingClass() {
        if (eContainerFeatureID() != EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSubscribingClass(SapClass newSubscribingClass, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSubscribingClass, EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSubscribingClass(SapClass newSubscribingClass) {
        if (newSubscribingClass != eInternalContainer() || (eContainerFeatureID() != EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS && newSubscribingClass != null)) {
            if (EcoreUtil.isAncestor(this, newSubscribingClass))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSubscribingClass != null)
                msgs = ((InternalEObject)newSubscribingClass).eInverseAdd(this, ClassesPackage.SAP_CLASS__SUBSCRIPTION, SapClass.class, msgs);
            msgs = basicSetSubscribingClass(newSubscribingClass, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS, newSubscribingClass, newSubscribingClass));
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                if (producer != null)
                    msgs = ((InternalEObject)producer).eInverseRemove(this, EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS, EventProducer.class, msgs);
                return basicSetProducer((EventProducer)otherEnd, msgs);
            case EventsPackage.SUBSCRIPTION__FILTERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFilters()).basicAdd(otherEnd, msgs);
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSubscribingClass((SapClass)otherEnd, msgs);
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                return basicSetProducer(null, msgs);
            case EventsPackage.SUBSCRIPTION__FILTERS:
                return ((InternalEList<?>)getFilters()).basicRemove(otherEnd, msgs);
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                return basicSetSubscribingClass(null, msgs);
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
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__SUBSCRIPTION, SapClass.class, msgs);
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                if (resolve) return getProducer();
                return basicGetProducer();
            case EventsPackage.SUBSCRIPTION__FILTERS:
                return getFilters();
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                if (resolve) return getSubscribingClass();
                return basicGetSubscribingClass();
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                setProducer((EventProducer)newValue);
                return;
            case EventsPackage.SUBSCRIPTION__FILTERS:
                getFilters().clear();
                getFilters().addAll((Collection<? extends EventFilter>)newValue);
                return;
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                setSubscribingClass((SapClass)newValue);
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                setProducer((EventProducer)null);
                return;
            case EventsPackage.SUBSCRIPTION__FILTERS:
                getFilters().clear();
                return;
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                setSubscribingClass((SapClass)null);
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
            case EventsPackage.SUBSCRIPTION__PRODUCER:
                return producer != null;
            case EventsPackage.SUBSCRIPTION__FILTERS:
                return filters != null && !filters.isEmpty();
            case EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS:
                return basicGetSubscribingClass() != null;
        }
        return super.eIsSet(featureID);
    }

} //SubscriptionImpl
