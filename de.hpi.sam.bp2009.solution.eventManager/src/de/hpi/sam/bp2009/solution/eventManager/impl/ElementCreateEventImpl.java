/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Create Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ElementCreateEventImpl extends ElementLifeCycleEventImpl implements ElementCreateEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementCreateEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ELEMENT_CREATE_EVENT;
	}

} //ElementCreateEventImpl
