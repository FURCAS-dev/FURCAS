/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification;
import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getOclEvaluator <em>Ocl Evaluator</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getEventManager <em>Event Manager</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl#getQueries <em>Queries</em>}</li>
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
	private class TautologyFilter extends InstanceFilterImpl{
		@Override
		public boolean matchesFor(ModelChangeEvent event) {
			return true;
		}
	}
	private class EventManagerAdapter extends AdapterImpl {
		private OclQuery query;
		public EventManagerAdapter(OclQuery query) {
			super();
			this.query=query;
		}
		@Override
		public void notifyChanged(Notification msg) {
				if(msg instanceof EventNotification){
					BasicEList<OclQuery> list= new BasicEList<OclQuery>();
					list.add(query);
					handleInternalEvent(list, (EventNotification)msg);
				}
					
		}
	}

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
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<OclQuery> queries;

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
	public EList<OclQuery> getQueries() {
		return queries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueries(EList<OclQuery> newQueries) {
		EList<OclQuery> oldQueries = queries;
		queries = newQueries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES, oldQueries, queries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void handleInternalEvent(EList<OclQuery> queries, EventNotification eventNotification) {
		evaluateQueries(queries);
		QueryReevaluateNotification noti= ImpactAnalyzerFactory.eINSTANCE.createQueryReevaluateNotification();
		noti.setEvent(eventNotification.getEvent());
		noti.setReevaluatedQueries(queries);
		for (Adapter a : eAdapters())
			notifyApplication(a, noti);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void notifyApplication(Adapter application, QueryReevaluateNotification msg) {
		application.notifyChanged(msg);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void register(Notifier root, Adapter receiver, EList<OclQuery> oclQueries) {
		//TODO Generate the correct Filter
		EventFilter filter = new TautologyFilter();
		
		
		//TODO mapping between Application and registered query vs. multiple IA instances
		eAdapters().add(receiver);
		for(OclQuery each: oclQueries)
			this.getEventManager().subscribe(root,filter, new EventManagerAdapter(each));
		this.setQueries(oclQueries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void evaluateQueries(EList<OclQuery> queries) {
		getOclEvaluator().evaluate(queries);
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES:
				return getQueries();
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES:
				setQueries((EList<OclQuery>)newValue);
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES:
				setQueries((EList<OclQuery>)null);
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
			case ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES:
				return queries != null;
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
		result.append(" (queries: ");
		result.append(queries);
		result.append(')');
		return result.toString();
	}

} //ImpactAnalyzerImpl
