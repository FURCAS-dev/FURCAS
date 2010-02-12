/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals;
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

	@Override
	public void handleInternalEvent(EList<OclQuery> queries,
			EventNotification eventNotification) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_INTERNAL_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, null, null));
		super.handleInternalEvent(queries, eventNotification);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_INTERNAL_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, null, null));
	}

	@Override
	public void notifyApplication(Adapter application,
			QueryReevaluateNotification msg) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, null, application));
		super.notifyApplication(application, msg);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, null, application));

	}

	@Override
	public void evaluateQueries(EList<OclQuery> queries) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_QUERY_EVALUATION_VALUE, Notification.NO_FEATURE_ID, null, getOclEvaluator()));
		super.evaluateQueries(queries);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_QUERY_EVALUATION_VALUE, Notification.NO_FEATURE_ID, null, getOclEvaluator()));
	}
	@Override
	public void register(Notifier root, Adapter receiver,
			EList<OclQuery> oclQueries) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_APPLICATION_REGISTRATION_VALUE, Notification.NO_FEATURE_ID, null, receiver));
		super.register(root, receiver, oclQueries);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_APPLICATION_REGISTRATION_VALUE, Notification.NO_FEATURE_ID, null, receiver));
	}

} //ModifiedImpactAnalyzerImpl
