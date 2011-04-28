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
package org.eclipse.ocl.examples.eventmanager.framework;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Observes a {@link ReferenceQueue reference queue} and removes {@link Adapter}
 * s from it. It weakly references an {@link EventManagerTableBased}. When a
 * reference to an adapter was added to the queue and henceforth removed by this
 * thread, this means that the adapter is no longer strongly referenced. A
 * {@link EventManagerTableBased#deregister(Reference)} is issued to clean up
 * after the adapeter.
 * <p>
 * 
 * When the {@link EventManagerTableBased event manager} becomes eligible for
 * garbage collection, its {@link EventManagerTableBased#finalize()} method
 * stops this thread by calling {@link #stopCleaner()}.
 * 
 * @author Axel Uhl (d043530)
 * 
 */
public class CleanupThread extends Thread {
    private Logger logger = Logger.getLogger(CleanupThread.class.getName());

    private final ReferenceQueue<Adapter> adaptersNoLongerStronglyReferenced;
	private final WeakReference<EventManagerTableBased> eventManagerRef;

	/**
	 * A dummy adapter used by {@link #stopThreadMarker}. In order to stop the
	 * {@link #adapterCleanupThread}, this field must be set to
	 * <code>null</code>, causing the adapter to be no longer stongly
	 * referenced. This, in turn, will cause the {@link #stopThreadAdapter}
	 * reference to be enqueued in {@link #adaptersNoLongerStronglyReferenced}
	 * from where it is removed by {@link #adapterCleanupThread}. Successful
	 * comparison to {@link #stopThreadMarker} causes the thread to terminate.
	 */
	private Adapter stopThreadAdapter;

	/**
	 * Used to signal the {@link #adapterCleanupThread} to stop the thread.
	 */
	private final WeakReference<Adapter> stopThreadMarker;

	public CleanupThread(
			ReferenceQueue<Adapter> adaptersNoLongerStronglyReferenced,
			EventManagerTableBased eventManager) {
		super();
		this.adaptersNoLongerStronglyReferenced = adaptersNoLongerStronglyReferenced;
		this.stopThreadAdapter = new AdapterImpl();
		this.stopThreadMarker = new WeakReference<Adapter>(stopThreadAdapter,
				adaptersNoLongerStronglyReferenced);
		this.eventManagerRef = new WeakReference<EventManagerTableBased>(eventManager);
	}
	
	/**
	 * Indirectly but cleanly stops this thread. This happens by nulling the
	 * {@link #stopThreadAdapter} field which was the only strong reference to
	 * the adapter held by it. The weak reference in {@link #stopThreadMarker}
	 * will therefore be enqueued which serves as the stop marker, causing
	 * the {@link #run} loop to terminate.
	 */
	public void stopCleaner() {
		stopThreadAdapter = null;  // causes stopThreadMarker to get enqueued which stops adapterCleanupThread
	}

	public void run() {
		try {
			Reference<? extends Adapter> adapterRef = adaptersNoLongerStronglyReferenced
					.remove();
			while (adapterRef != stopThreadMarker) {
				EventManagerTableBased eventManager = eventManagerRef.get();
				if (eventManager != null) {
					eventManager.deregister(adapterRef);
				}
				adapterRef = adaptersNoLongerStronglyReferenced.remove();
			}
		} catch (InterruptedException e) {
			// Why are we being interrupted? log incident and terminate thread.
			logger.throwing(this.getClass().getName(), "run", e);
		}
	}
}
