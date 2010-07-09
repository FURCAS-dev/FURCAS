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

import java.util.Collection;
import modelmanagement.impl.PackageOwnerImpl;

import modelmanagement.processcomponents.ProcessComponent;
import modelmanagement.processcomponents.ProcesscomponentsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
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
	 * The cached value of the '{@link #getProvidedInterfaces() <em>Provided Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<SapClass> providedInterfaces;

	/**
	 * The cached value of the '{@link #getEventProducers() <em>Event Producers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventProducers()
	 * @generated
	 * @ordered
	 */
	protected EList<EventProducer> eventProducers;

	/**
	 * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractions()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessComponentInteraction> interactions;

	/**
	 * The cached value of the '{@link #getInitiatedInteractions() <em>Initiated Interactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatedInteractions()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessComponentInteraction> initiatedInteractions;

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
	public EList<SapClass> getProvidedInterfaces() {
		if (providedInterfaces == null) {
			providedInterfaces = new EObjectContainmentEList<SapClass>(SapClass.class, this, ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES);
		}
		return providedInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventProducer> getEventProducers() {
		if (eventProducers == null) {
			eventProducers = new EObjectContainmentEList<EventProducer>(EventProducer.class, this, ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS);
		}
		return eventProducers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessComponentInteraction> getInteractions() {
		if (interactions == null) {
			interactions = new EObjectContainmentEList<ProcessComponentInteraction>(ProcessComponentInteraction.class, this, ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS);
		}
		return interactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessComponentInteraction> getInitiatedInteractions() {
		if (initiatedInteractions == null) {
			initiatedInteractions = new EObjectContainmentEList<ProcessComponentInteraction>(ProcessComponentInteraction.class, this, ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS);
		}
		return initiatedInteractions;
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
				return ((InternalEList<?>)getProvidedInterfaces()).basicRemove(otherEnd, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				return ((InternalEList<?>)getEventProducers()).basicRemove(otherEnd, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				return ((InternalEList<?>)getInteractions()).basicRemove(otherEnd, msgs);
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				return ((InternalEList<?>)getInitiatedInteractions()).basicRemove(otherEnd, msgs);
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcesscomponentsPackage.PROCESS_COMPONENT__PROVIDED_INTERFACES:
				getProvidedInterfaces().clear();
				getProvidedInterfaces().addAll((Collection<? extends SapClass>)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				getEventProducers().clear();
				getEventProducers().addAll((Collection<? extends EventProducer>)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				getInteractions().clear();
				getInteractions().addAll((Collection<? extends ProcessComponentInteraction>)newValue);
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				getInitiatedInteractions().clear();
				getInitiatedInteractions().addAll((Collection<? extends ProcessComponentInteraction>)newValue);
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
				getProvidedInterfaces().clear();
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				getEventProducers().clear();
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				getInteractions().clear();
				return;
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				getInitiatedInteractions().clear();
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
				return providedInterfaces != null && !providedInterfaces.isEmpty();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__EVENT_PRODUCERS:
				return eventProducers != null && !eventProducers.isEmpty();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INTERACTIONS:
				return interactions != null && !interactions.isEmpty();
			case ProcesscomponentsPackage.PROCESS_COMPONENT__INITIATED_INTERACTIONS:
				return initiatedInteractions != null && !initiatedInteractions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcessComponentImpl
