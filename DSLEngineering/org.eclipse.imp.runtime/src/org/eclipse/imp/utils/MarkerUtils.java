/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.utils;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.imp.runtime.RuntimePlugin;

public class MarkerUtils {
    private MarkerUtils() { }

    /**
     * Returns the maximum problem marker severity for the given resource, and, if
     * depth is IResource.DEPTH_INFINITE, its children. The return value will be
     * one of IMarker.SEVERITY_ERROR, IMarker.SEVERITY_WARNING, IMarker.SEVERITY_INFO
     * or 0, indicating that no problem markers exist on the given resource.
     * @param depth TODO
     */
    public static int getMaxProblemMarkerSeverity(IResource res, int depth) {
        if (res == null || !res.isAccessible())
            return 0;
    
        boolean hasWarnings= false; // if resource has errors, will return error image immediately
        IMarker[] markers= null;
    
        try {
            markers= res.findMarkers(IMarker.PROBLEM, true, depth);
        } catch (CoreException e) {
            RuntimePlugin.getInstance().logException("Error obtaining markers on resource " + res.getName(), e);
        }
        if (markers == null)
            return 0; // don't know - say no errors/warnings/infos
    
        for(int i= 0; i < markers.length; i++) {
            IMarker m= markers[i];
            int priority= m.getAttribute(IMarker.SEVERITY, -1);
    
            if (priority == IMarker.SEVERITY_WARNING) {
        	hasWarnings= true;
            } else if (priority == IMarker.SEVERITY_ERROR) {
        	return IMarker.SEVERITY_ERROR;
            }
        }
        return hasWarnings ? IMarker.SEVERITY_WARNING : 0;
    }
}
