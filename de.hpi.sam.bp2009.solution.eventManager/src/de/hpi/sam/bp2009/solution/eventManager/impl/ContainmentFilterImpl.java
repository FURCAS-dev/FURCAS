/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContainmentFilterImpl extends EventFilterImpl implements ContainmentFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.CONTAINMENT_FILTER;
	}

	@Override
	public boolean matchesFor(Notification event) {
		if(event.getFeature() instanceof EReference){
			return ((EReference)event.getFeature()).isContainment();
		}
		return false;
		
	}

	@Override
	public EList<NotificationIdentifier> buildNotificationIdentifiers(
			NotificationIdentifier identifier) {
		identifier.setContainment(true);
		return this.getEListForNotificationIdentifier(identifier);
		
	}

} //ContainmentFilterImpl
