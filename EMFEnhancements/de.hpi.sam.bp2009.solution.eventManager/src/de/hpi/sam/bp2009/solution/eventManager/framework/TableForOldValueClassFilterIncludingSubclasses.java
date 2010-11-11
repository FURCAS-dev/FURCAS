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
package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilterIncludingSubclasses;

public class TableForOldValueClassFilterIncludingSubclasses extends TableForEventFilter {

    public TableForOldValueClassFilterIncludingSubclasses(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    public Object getAffectedObject(Notification event) {
        if(isEmpty() || event.getOldValue() == null)
            return null;
        
        Collection<EClass> result= new HashSet<EClass>();
        if(event.getOldValue() instanceof EObject){
            EClass eClass = ((EObject)event.getOldValue()).eClass();
            result.add(eClass);
            result.addAll(eClass.getEAllSuperTypes());
        }else if(event.getOldValue() instanceof EList<?>){
            for(Object o: ((EList<?>)event.getOldValue())){
                if(o instanceof EObject){
                    
                    EClass eClass = ((EObject)o).eClass();
                    result.add(eClass);
                    result.addAll(eClass.getEAllSuperTypes());
                }
            }
        }else{
            return null;
        }
        return result;

    }

    @Override
    public Class<OldValueClassFilterIncludingSubclasses> getIdentifier() {
        return OldValueClassFilterIncludingSubclasses.class;
    }
    
    @Override
    protected String criterionToString(Object criterion) {
        StringBuilder result = new StringBuilder();
        if (criterion instanceof EClass) {
            result.append(((EClass) criterion).getName());
        } else {
            Set<?> eClassSet = (Set<?>) criterion;
            boolean first = true;
            for (Object eClass : eClassSet) {
                if (!first) {
                    result.append(", ");
                } else {
                    result.append(((EClass) eClass).getName());
                }
            }
        }
        return result.toString();
    }

}
