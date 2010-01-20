/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;



import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getOclEvaluator <em>Ocl Evaluator</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getEventManager <em>Event Manager</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getCurrentQueries <em>Current Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactAnalyzerImpl extends EObjectImpl implements ImpactAnalyzer {
	/**
	 * The cached value of the '{@link #getOclEvaluator() <em>Ocl Evaluator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclEvaluator()
	 * @generated
	 * @ordered
	 */
	protected OCLEvaluator oclEvaluator;

	/**
	 * The cached value of the '{@link #getEventManager() <em>Event Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventManager()
	 * @generated
	 * @ordered
	 */
	protected EventManager eventManager;

	/**
	 * The cached value of the '{@link #getCurrentQueries() <em>Current Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<OclQuery> currentQueries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ImpactAnalyzerImpl() {
		super();
		this.setEventManager(EventManagerFactory.eINSTANCE.createEventManager());
		this.setOclEvaluator(OclEvaluatorFactory.eINSTANCE.createOCLEvaluator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactAnalyzerPackage.Literals.IMPACT_ANALYZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLEvaluator getOclEvaluator() {
		if (oclEvaluator != null && oclEvaluator.eIsProxy()) {
			InternalEObject oldOclEvaluator = (InternalEObject)oclEvaluator;
			oclEvaluator = (OCLEvaluator)eResolveProxy(oldOclEvaluator);
			if (oclEvaluator != oldOclEvaluator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR, oldOclEvaluator, oclEvaluator));
			}
		}
		return oclEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLEvaluator basicGetOclEvaluator() {
		return oclEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclEvaluator(OCLEvaluator newOclEvaluator) {
		OCLEvaluator oldOclEvaluator = oclEvaluator;
		oclEvaluator = newOclEvaluator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR, oldOclEvaluator, oclEvaluator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManager getEventManager() {
		if (eventManager != null && eventManager.eIsProxy()) {
			InternalEObject oldEventManager = (InternalEObject)eventManager;
			eventManager = (EventManager)eResolveProxy(oldEventManager);
			if (eventManager != oldEventManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER, oldEventManager, eventManager));
			}
		}
		return eventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManager basicGetEventManager() {
		return eventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventManager(EventManager newEventManager) {
		EventManager oldEventManager = eventManager;
		eventManager = newEventManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER, oldEventManager, eventManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclQuery> getCurrentQueries() {
		return currentQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentQueries(EList<OclQuery> newCurrentQueries) {
		EList<OclQuery> oldCurrentQueries = currentQueries;
		currentQueries = newCurrentQueries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactAnalyzerPackage.IMPACT_ANALYZER__CURRENT_QUERIES, oldCurrentQueries, currentQueries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> registerQueries(EList<OclQuery> oclQueries) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void register(EObject root, EList<OclQuery> oclQueries) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void register(Resource root, EList<OclQuery> oclQueries) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Object> analyze(ResourceSet resourceSet, EList<OclQuery> oclQueries) {

		return this.getOclEvaluator().evaluate(oclQueries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return 
	 */
	public void register(ResourceSet resourceSet, EList<OclQuery> oclQueries) {
		System.out.println("Start Analyse");
		ModelChangeEvent event = EventManagerFactory.eINSTANCE.createModelChangeEvent();
		event.setSourceResourceSet(resourceSet);
		this.getEventManager().subscribe(this, event);
		this.setCurrentQueries(oclQueries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void callback(ModelChangeEvent modelchangeEvent) {
		System.out.println("callback");
		this.analyze(modelchangeEvent.getSourceResourceSet(), this.getCurrentQueries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				if (resolve) return getOclEvaluator();
				return basicGetOclEvaluator();
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				if (resolve) return getEventManager();
				return basicGetEventManager();
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__CURRENT_QUERIES:
				return getCurrentQueries();
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				setOclEvaluator((OCLEvaluator)newValue);
				return;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				setEventManager((EventManager)newValue);
				return;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__CURRENT_QUERIES:
				setCurrentQueries((EList<OclQuery>)newValue);
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				setOclEvaluator((OCLEvaluator)null);
				return;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				setEventManager((EventManager)null);
				return;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__CURRENT_QUERIES:
				setCurrentQueries((EList<OclQuery>)null);
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				return oclEvaluator != null;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				return eventManager != null;
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__CURRENT_QUERIES:
				return currentQueries != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (currentQueries: ");
		result.append(currentQueries);
		result.append(')');
		return result.toString();
	}

} //ImpactAnalyzerImpl
