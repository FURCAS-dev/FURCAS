/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.eventmanager.EventManager;

/**
 * Used to observe and filter for model changes that affect derived properties
 * defined by OCL expression. Construct an instance for a single
 * {@link EStructuralFeature} or all properties of an {@link EPackage} and
 * {@link #subscribe(EventManager) subscribe} for change notifications at an
 * {@link EventManager}. When changes affecting a derived property's value are
 * received, the actual changes are determined, and new {@link Notification}s
 * are created for those objects on which the derived property's value did
 * change.
 * 
 * @author Axel Uhl
 */
public interface DerivedPropertyNotifier {

	/**
	 * Activates the services of this notifier for the scope observed by the <code>eventManager</code>.
	 * If the event manager is {@link EventManager#setActive(boolean) set inactive}, no notifications
	 * are created by this notifier until the event manager is activated again.
	 */
	public abstract void subscribe(EventManager eventManager);
	
	/**
	 * Deactivates this notifier by unregistering all its internal adapters from the
	 * <code>eventManager</code> again.
	 */
	public abstract void unsubscribe(EventManager eventManager);

}
