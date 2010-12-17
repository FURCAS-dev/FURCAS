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

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;

/**
 * A RegistrationSet is used to pool multiple {@link Registration Registrations} that were created by one call to a register...()
 * method on the EventRegistry interface. This may happen when a client registers with multiple OR-connected filters. They are
 * mapped to multiple registrations internally. In order to distinguish between one registration using OR-connected filters and
 * several registrations, the resulting Registration objects are being pooled in the first case.
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
public class RegistrationSet {

    /**
     * The MoinEventFramework only stores <code>WeakReferences</code> to the registered listeners. Clients will have to
     * keep a reference to their listener in order ro prevent the garbage collector from cleaning up the instance.
     */
    private WeakReference<? extends Adapter> _listener = null;

    /**
     * defines the type of the registration. (whether it is a registration for PreChangeEvent, ChangeEvents,...)
     */
    private ListenerTypeEnum listenerType;

    private final Set<Registration> registrations;

    /**
     * Adds this {@link RegistrationSet} to all <code>registrations</code>' using
     * {@link Registration#addRegistrationSet(RegistrationSet)}
     */
    public RegistrationSet(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType, Collection<Registration> registrations) {
        _listener = listener;
        this.listenerType = listenerType;
        this.registrations = new HashSet<Registration>();
        for (Registration r : registrations) {
            this.registrations.add(r);
            r.addRegistrationSet(this);
        }
    }

    /**
     * Every Registration belongs exactly to one listener.
     * 
     * @return a <code>WeakReference</code> to the associated listener
     */
    WeakReference<? extends Adapter> getListener() {
        return _listener;
    }

    /**
     * The return value defines the type of the Listener
     * 
     * @see ListenerTypeEnum
     * @return 
     */
    public ListenerTypeEnum getListenerType() {
        return listenerType;
    }

    /**
     * @return a read-only collection with all {@link Registration}s that are pooled in this set
     */
    Set<Registration> getRegistrations() {
        return Collections.unmodifiableSet(registrations);
    }

}
