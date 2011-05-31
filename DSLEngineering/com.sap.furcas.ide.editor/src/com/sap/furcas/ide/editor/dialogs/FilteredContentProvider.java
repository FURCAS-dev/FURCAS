/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

/**
 * Provider that only yields the children which either match the filer or which
 * have (transitive) children matching the filter.
 * 
 * @author Stephan Erb
 *
 */
public class FilteredContentProvider extends AdapterFactoryContentProvider {

    private final HashMap<Object, Boolean> childStateCache = new HashMap<Object, Boolean>();
    private final Collection<Class<?>> filterList;

    public FilteredContentProvider(AdapterFactory adapterFactory, Collection<Class<?>> filterList) {
        super(adapterFactory);
        this.filterList = filterList;
    }
    
    @Override
    public Object[] getChildren(Object object) {
        Object[] unfilteredResult = super.getChildren(object);
        
        ArrayList<Object> filteredResult = new ArrayList<Object>();
        for (Object childObj : unfilteredResult) {
            if (childObj == null) {
                continue;
            }
            if (isOfDesiredType(childObj) || hasChildOfDesiredTypeRecursive(childObj)) {
                filteredResult.add(childObj);
            }
        }
        return filteredResult.toArray(new Object[filteredResult.size()]);
    }

    private boolean isOfDesiredType(Object obj) {
        for (Class<?> c : filterList) {
            if (c.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasChildOfDesiredTypeRecursive(Object childObj) {
        // Cache prevents that a hierarchy is walked downwards over
        // and over again. The cache is populated when the root element 
        // is inspected.
        if (childStateCache.containsKey(childObj)) {
            return childStateCache.get(childObj);
        }

        boolean childHasChildrenOfDesiredType = getChildren(childObj).length > 0;
        childStateCache.put(childObj, childHasChildrenOfDesiredType);
        
        return childHasChildrenOfDesiredType;
    }
}
