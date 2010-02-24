/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerNotifyLiterals;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
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
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this, ModifiedImpactAnalyzerNotifyLiterals.START_CONTEXT_OBJECT_ANALYZATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedImpactAnalyzerNotifyLiterals.START_CONTEXT_OBJECT_ANALYZATION.getName()));
		EList<EObject> result = super.getContextObjects(event, query);
		eNotify(new ENotificationImpl(this, ModifiedImpactAnalyzerNotifyLiterals.END_CONTEXT_OBJECT_ANALYZATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedImpactAnalyzerNotifyLiterals.END_CONTEXT_OBJECT_ANALYZATION.getName()));
		return result;
	}
	
	@Override
	public EventFilter createFilterForQuery(OclQuery query) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this, ModifiedImpactAnalyzerNotifyLiterals.START_FILTER_CREATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedImpactAnalyzerNotifyLiterals.START_FILTER_CREATION.getName()));
		EventFilter result = super.createFilterForQuery(query);
		eNotify(new ENotificationImpl(this, ModifiedImpactAnalyzerNotifyLiterals.END_FILTER_CREATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedImpactAnalyzerNotifyLiterals.END_FILTER_CREATION.getName()));
		return result;
	}
	
} //ModifiedImpactAnalyzerImpl
