/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.IncomingEventNotification;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerFactory;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.OutgoingResultNotification;
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
	public void handleInternalEvent(EList<OclQuery> queries,
			EventNotification eventNotification) {
		for (Adapter a : eAdapters){
			//TODO: if there is no additional information in a IncomingEventNotification, just forward the EventNotification
			IncomingEventNotification notification = (IncomingEventNotification) eventNotification;
			a.notifyChanged(notification);
		}
		super.handleInternalEvent(queries, eventNotification);
	}
	
	@Override
	public void notifyApplication(Adapter application) {
		for (Adapter a : eAdapters){
			//TODO: if there is no additional information in a OutgoingResultNotification, just create an EventNotification
			OutgoingResultNotification notification = ModifiedImpactAnalyzerFactory.eINSTANCE.createOutgoingResultNotification();
			a.notifyChanged(notification);
		}
		super.notifyApplication(application);
	}
	

} //ModifiedImpactAnalyzerImpl
