/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impl;

import de.hpi.sam.bp2009.solution.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.OclEvaluator;
import de.hpi.sam.bp2009.solution.SolutionPackage;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl#getEventManager <em>Event Manager</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl#getOclEvaluator <em>Ocl Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactAnalyzerImpl extends EObjectImpl implements ImpactAnalyzer {
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
	 * The cached value of the '{@link #getOclEvaluator() <em>Ocl Evaluator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclEvaluator()
	 * @generated
	 * @ordered
	 */
	protected OclEvaluator oclEvaluator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactAnalyzerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.IMPACT_ANALYZER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER, oldEventManager, eventManager));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER, oldEventManager, eventManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclEvaluator getOclEvaluator() {
		if (oclEvaluator != null && oclEvaluator.eIsProxy()) {
			InternalEObject oldOclEvaluator = (InternalEObject)oclEvaluator;
			oclEvaluator = (OclEvaluator)eResolveProxy(oldOclEvaluator);
			if (oclEvaluator != oldOclEvaluator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR, oldOclEvaluator, oclEvaluator));
			}
		}
		return oclEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclEvaluator basicGetOclEvaluator() {
		return oclEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclEvaluator(OclEvaluator newOclEvaluator) {
		OclEvaluator oldOclEvaluator = oclEvaluator;
		oclEvaluator = newOclEvaluator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR, oldOclEvaluator, oclEvaluator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void analyze(ResourceSet resourceSet, EList<AbstractOCLCondition> ExpressionSet) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void callback(ModelChangeEvent event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				if (resolve) return getEventManager();
				return basicGetEventManager();
			case SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				if (resolve) return getOclEvaluator();
				return basicGetOclEvaluator();
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
			case SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				setEventManager((EventManager)newValue);
				return;
			case SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				setOclEvaluator((OclEvaluator)newValue);
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
			case SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				setEventManager((EventManager)null);
				return;
			case SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				setOclEvaluator((OclEvaluator)null);
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
			case SolutionPackage.IMPACT_ANALYZER__EVENT_MANAGER:
				return eventManager != null;
			case SolutionPackage.IMPACT_ANALYZER__OCL_EVALUATOR:
				return oclEvaluator != null;
		}
		return super.eIsSet(featureID);
	}

} //ImpactAnalyzerImpl
