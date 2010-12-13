/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.tests.filterSynthesis;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.ocl.examples.eventmanager.EventManager;


/**
 * This special {@link EContentAdapter} is used to notify a given {@link EventManager} if any notification is raised
 * ATTENTION: for the right registration at a target one have to use <code>target.eAdapters().add(myAdapter);</code>
 * 
 * @author Philipp Berger
 *
 */
public class EventAdapter extends EContentAdapter {
    private final WeakReference<EventManager> eventManager;

    /**
     * Constructs a new Adapter with the given {@link EventManager} as instance to notify
     * NOTE: the EventManager is held as {@link WeakReference}
     */
    public EventAdapter(EventManager eventManager) {
        this.eventManager = new WeakReference<EventManager>(eventManager);
    }
    
    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        EventManager m = this.eventManager.get();
        if(m!=null) {
            m.handleEMFEvent(notification);
        }
    }
}
