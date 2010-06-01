/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.processcomponents.impl;

import behavioral.events.EventProducer;

import data.classes.SapClass;

import integration.processintegration.ProcessComponentInteraction;

import modelmanagement.impl.PackageOwnerImpl;

import modelmanagement.processcomponents.ProcessComponent;
import modelmanagement.processcomponents.ProcesscomponentsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.processcomponents.impl.ProcessComponentImpl#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.impl.ProcessComponentImpl#getEventProducers <em>Event Producers</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.impl.ProcessComponentImpl#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.impl.ProcessComponentImpl#getInitiatedInteractions <em>Initiated Interactions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProcessComponentImpl extends PackageOwnerImpl implements ProcessComponent {
	/**
	 * The cached value of the '{@link #getProvidedInterfaces() <em>Provided Interfaces</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected SapClass providedInterfaces;

	/**
	 * The cached value of the '{@link #getEventProducers() <em>Event Producers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventProducers()
	 * @generated
	 * @ordered
	 */
	protected EventProducer eventProducers;

	/**
	 * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractions()
	 * @generated
	 * @ordered
	 */
	protected ProcessComponentInteraction interactions;

	/**
	 * The cached value of the '{@link #getInitiatedInteractions() <em>Initiated Interactions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatedInteractions()
	 * @generated
	 * @ordered
	 */
	protected ProcessComponentInteraction initiatedInteractions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcesscomponentsPackage.Literals.PROCESS_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SapClass getProvidedInterfaces() {
		return providedInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidedInterfaces(SapClass newProvidedInterfaces, NotificationChain msgs) {
		SapClass oldProvidedInterfaces = providedInterfaces;
		providedInterfaces = newProvidedInterfaces;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES, oldProvidedInterfaces, newProvidedInterfaces);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedInterfaces(SapClass newProvidedInterfaces) {
		if (newProvidedInterfaces != providedInterfaces) {
			NotificationChain msgs = null;
			if (providedInterfaces != null)
				msgs = ((InternalEObject)providedInterfaces).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES, null, msgs);
			if (newProvidedInterfaces != null)
				msgs = ((InternalEObject)newProvidedInterfaces).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES, null, msgs);
			msgs = basicSetProvidedInterfaces(newProvidedInterfaces, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES, newProvidedInterfaces, newProvidedInterfaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventProducer getEventProducers() {
		return eventProducers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventProducers(EventProducer newEventProducers, NotificationChain msgs) {
		EventProducer oldEventProducers = eventProducers;
		eventProducers = newEventProducers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS, oldEventProducers, newEventProducers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventProducers(EventProducer newEventProducers) {
		if (newEventProducers != eventProducers) {
			NotificationChain msgs = null;
			if (eventProducers != null)
				msgs = ((InternalEObject)eventProducers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS, null, msgs);
			if (newEventProducers != null)
				msgs = ((InternalEObject)newEventProducers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS, null, msgs);
			msgs = basicSetEventProducers(newEventProducers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS, newEventProducers, newEventProducers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessComponentInteraction getInteractions() {
		return interactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteractions(ProcessComponentInteraction newInteractions, NotificationChain msgs) {
		ProcessComponentInteraction oldInteractions = interactions;
		interactions = newInteractions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, oldInteractions, newInteractions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractions(ProcessComponentInteraction newInteractions) {
		if (newInteractions != interactions) {
			NotificationChain msgs = null;
			if (interactions != null)
				msgs = ((InternalEObject)interactions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, null, msgs);
			if (newInteractions != null)
				msgs = ((InternalEObject)newInteractions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, null, msgs);
			msgs = basicSetInteractions(newInteractions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS, newInteractions, newInteractions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessComponentInteraction getInitiatedInteractions() {
		return initiatedInteractions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitiatedInteractions(ProcessComponentInteraction newInitiatedInteractions, NotificationChain msgs) {
		ProcessComponentInteraction oldInitiatedInteractions = initiatedInteractions;
		initiatedInteractions = newInitiatedInteractions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, oldInitiatedInteractions, newInitiatedInteractions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatedInteractions(ProcessComponentInteraction newInitiatedInteractions) {
		if (newInitiatedInteractions != initiatedInteractions) {
			NotificationChain msgs = null;
			if (initiatedInteractions != null)
				msgs = ((InternalEObject)initiatedInteractions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, null, msgs);
			if (newInitiatedInteractions != null)
				msgs = ((InternalEObject)newInitiatedInteractions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, null, msgs);
			msgs = basicSetInitiatedInteractions(newInitiatedInteractions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS, newInitiatedInteractions, newInitiatedInteractions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				return basicSetProvidedInterfaces(null, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				return basicSetEventProducers(null, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				return basicSetInteractions(null, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				return basicSetInitiatedInteractions(null, msgs);
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
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				return getProvidedInterfaces();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				return getEventProducers();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				return getInteractions();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				return getInitiatedInteractions();
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
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				setProvidedInterfaces((SapClass)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				setEventProducers((EventProducer)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				setInteractions((ProcessComponentInteraction)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				setInitiatedInteractions((ProcessComponentInteraction)newValue);
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
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				setProvidedInterfaces((SapClass)null);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				setEventProducers((EventProducer)null);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				setInteractions((ProcessComponentInteraction)null);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				setInitiatedInteractions((ProcessComponentInteraction)null);
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
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				return providedInterfaces != null;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				return eventProducers != null;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				return interactions != null;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				return initiatedInteractions != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessComponentImpl
