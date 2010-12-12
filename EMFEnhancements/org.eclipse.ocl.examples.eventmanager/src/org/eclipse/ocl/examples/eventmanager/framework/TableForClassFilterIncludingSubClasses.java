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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilterIncludingSubclasses;


/**
 * The ClassFilterTable manages all Registrations containing {@link ClassFilter}.
 * 
 * @see TableForEventFilter
 * @author Daniel Vocke (D044825)
 */
public class TableForClassFilterIncludingSubClasses extends TableForEventFilter {

    public TableForClassFilterIncludingSubClasses(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the <code>MRI</code> of the meta object of the affected element(s). If the passed event is not of type
     * <code>ModelChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() ||!(event.getNotifier() instanceof EObject))
            return null;
        Collection<EClass> classes = new HashSet<EClass>();
        EClass eClass = ((EObject)event.getNotifier()).eClass();
        classes.add(eClass);
        classes.addAll(eClass.getEAllSuperTypes());
        return classes;
        

    }

    @Override
    public Class<ClassFilterIncludingSubclasses> getIdentifier() {
        return ClassFilterIncludingSubclasses.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EClass) criterion).getName();
    }
}
