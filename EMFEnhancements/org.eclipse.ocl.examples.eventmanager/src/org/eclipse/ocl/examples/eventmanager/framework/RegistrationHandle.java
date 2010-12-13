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

import org.eclipse.emf.common.notify.Adapter;

/**
 * The <code>RegistrationHandle</code> is returned when clients register as listener on the
 * EventRegistry. This handle is needed when clients want to undo their registration call.
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
public class RegistrationHandle {
    private final Adapter listener;
    private final RegistrationSet registrationSet;
    
    public RegistrationHandle(Adapter listener, RegistrationSet registrationSet) {
        super();
        this.listener = listener;
        this.registrationSet = registrationSet;
    }

    protected Adapter getListener() {
        return listener;
    }
    
    protected RegistrationSet getRegistrationSet() {
        return registrationSet;
    }
}
