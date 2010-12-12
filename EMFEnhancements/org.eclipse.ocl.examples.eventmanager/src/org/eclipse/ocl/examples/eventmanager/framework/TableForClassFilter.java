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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;


/**
 * The ClassFilterTable manages all Registrations containing {@link ClassFilter}.
 * 
 * @see TableForEventFilter
 * @author Daniel Vocke (D044825)
 */
public class TableForClassFilter extends TableForEventFilter {

    public TableForClassFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the <code>MRI</code> of the meta object of the affected element(s). If the passed event is not of type
     * <code>ModelChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() ||!(event.getNotifier() instanceof EObject))
            return null;
        return ((EObject)event.getNotifier()).eClass();

    }

    @Override
    public Class<ClassFilter> getIdentifier() {
        return ClassFilter.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EClass) criterion).getName();
    }
}
