/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events.impl;

import behavioral.actions.Block;

import behavioral.events.EventFilter;
import behavioral.events.EventsPackage;
import behavioral.events.Subscription;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.events.impl.EventFilterImpl#getSubscription <em>Subscription</em>}</li>
 *   <li>{@link behavioral.events.impl.EventFilterImpl#getTest <em>Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventFilterImpl extends EObjectImpl implements EventFilter {
	/**
     * The cached value of the '{@link #getTest() <em>Test</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTest()
     * @generated
     * @ordered
     */
	protected Block test;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EventFilterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EventsPackage.Literals.EVENT_FILTER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Subscription getSubscription() {
        if (eContainerFeatureID() != EventsPackage.EVENT_FILTER__SUBSCRIPTION) return null;
        return (Subscription)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Subscription basicGetSubscription() {
        if (eContainerFeatureID() != EventsPackage.EVENT_FILTER__SUBSCRIPTION) return null;
        return (Subscription)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSubscription(Subscription newSubscription, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSubscription, EventsPackage.EVENT_FILTER__SUBSCRIPTION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSubscription(Subscription newSubscription) {
        if (newSubscription != eInternalContainer() || (eContainerFeatureID() != EventsPackage.EVENT_FILTER__SUBSCRIPTION && newSubscription != null)) {
            if (EcoreUtil.isAncestor(this, newSubscription))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSubscription != null)
                msgs = ((InternalEObject)newSubscription).eInverseAdd(this, EventsPackage.SUBSCRIPTION__FILTERS, Subscription.class, msgs);
            msgs = basicSetSubscription(newSubscription, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FILTER__SUBSCRIPTION, newSubscription, newSubscription));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getTest() {
        if (test != null && test.eIsProxy()) {
            InternalEObject oldTest = (InternalEObject)test;
            test = (Block)eResolveProxy(oldTest);
            if (test != oldTest) {
                InternalEObject newTest = (InternalEObject)test;
                NotificationChain msgs = oldTest.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.EVENT_FILTER__TEST, null, null);
                if (newTest.eInternalContainer() == null) {
                    msgs = newTest.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.EVENT_FILTER__TEST, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.EVENT_FILTER__TEST, oldTest, test));
            }
        }
        return test;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Block basicGetTest() {
        return test;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTest(Block newTest, NotificationChain msgs) {
        Block oldTest = test;
        test = newTest;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FILTER__TEST, oldTest, newTest);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTest(Block newTest) {
        if (newTest != test) {
            NotificationChain msgs = null;
            if (test != null)
                msgs = ((InternalEObject)test).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.EVENT_FILTER__TEST, null, msgs);
            if (newTest != null)
                msgs = ((InternalEObject)newTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.EVENT_FILTER__TEST, null, msgs);
            msgs = basicSetTest(newTest, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EVENT_FILTER__TEST, newTest, newTest));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSubscription((Subscription)otherEnd, msgs);
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
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                return basicSetSubscription(null, msgs);
            case EventsPackage.EVENT_FILTER__TEST:
                return basicSetTest(null, msgs);
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
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                return eInternalContainer().eInverseRemove(this, EventsPackage.SUBSCRIPTION__FILTERS, Subscription.class, msgs);
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
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                if (resolve) return getSubscription();
                return basicGetSubscription();
            case EventsPackage.EVENT_FILTER__TEST:
                if (resolve) return getTest();
                return basicGetTest();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                setSubscription((Subscription)newValue);
                return;
            case EventsPackage.EVENT_FILTER__TEST:
                setTest((Block)newValue);
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
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                setSubscription((Subscription)null);
                return;
            case EventsPackage.EVENT_FILTER__TEST:
                setTest((Block)null);
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
            case EventsPackage.EVENT_FILTER__SUBSCRIPTION:
                return basicGetSubscription() != null;
            case EventsPackage.EVENT_FILTER__TEST:
                return test != null;
        }
        return super.eIsSet(featureID);
    }

} //EventFilterImpl
