/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modified Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModifiedImpactAnalyzerImpl extends ImpactAnalyzerImpl implements ModifiedImpactAnalyzer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiedImpactAnalyzerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifiedImpactAnalyzerPackage.Literals.MODIFIED_IMPACT_ANALYZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendBenchmarkNotification(Object communicationPartner, boolean incoming) {
		//TODO: think about adding the method that caused the notification as a parameter
		ENotificationImpl n;
		if (incoming)
			n = new ENotificationImpl(this, 1, null, null, communicationPartner);
		else
			n = new ENotificationImpl(this, 0, null, null, communicationPartner);

		for (Adapter a : eAdapters){
			a.notifyChanged(n);
		}
	}

	@Override
	public void handleInternalEvent(EList<OclQuery> queries,
			EventNotification eventNotification) {
		sendBenchmarkNotification(getEventManager(), true);
		super.handleInternalEvent(queries, eventNotification);
		sendBenchmarkNotification(getOclEvaluator(), false);
	}

	@Override
	public void notifyApplication(Adapter application,
			QueryReevaluateNotification msg) {
		sendBenchmarkNotification(application, false);
		super.notifyApplication(application, msg);
	}

	@Override
	public void evaluateQueries(EList<OclQuery> queries) {
		sendBenchmarkNotification(getOclEvaluator(), false);
		super.evaluateQueries(queries);
		sendBenchmarkNotification(getOclEvaluator(), true);
	}
	@Override
	public void register(Notifier root, Adapter receiver,
			EList<OclQuery> oclQueries) {
		sendBenchmarkNotification(receiver, true);
		super.register(root, receiver, oclQueries);
		sendBenchmarkNotification(receiver, false);
	}

} //ModifiedImpactAnalyzerImpl
