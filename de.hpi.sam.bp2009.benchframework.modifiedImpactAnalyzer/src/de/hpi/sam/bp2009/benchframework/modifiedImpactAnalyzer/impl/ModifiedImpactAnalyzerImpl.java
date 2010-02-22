/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
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
	public EList<EObject> getContextObjects(EventNotification event,
			OclQuery query) {
		eNotify(new ENotificationImpl(this, NotifyLiterals.START_CONTEXT_OBJECT_ANALYZATION_VALUE, Notification.NO_FEATURE_ID, null, null));
		EList<EObject> result = super.getContextObjects(event, query);
		eNotify(new ENotificationImpl(this, NotifyLiterals.END_CONTEXT_OBJECT_ANALYZATION_VALUE, Notification.NO_FEATURE_ID, null, null));
		return result;
	}
	
	@Override
	public EventFilter createFilterForQuery(OclQuery query) {
		eNotify(new ENotificationImpl(this, NotifyLiterals.START_FILTER_CREATION_VALUE, Notification.NO_FEATURE_ID, null, null));
		EventFilter result = super.createFilterForQuery(query);
		eNotify(new ENotificationImpl(this, NotifyLiterals.END_FILTER_CREATION_VALUE, Notification.NO_FEATURE_ID, null, null));
		return result;
	}
	
} //ModifiedImpactAnalyzerImpl
