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

package org.eclipse.imp.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.imp.services.IAnnotationTypeInfo;

public class SimpleAnnotationTypeInfo implements IAnnotationTypeInfo {
    /*
     * For the management of associated problem-marker types
     */
    private List<String> problemMarkerTypes= new ArrayList<String>();

    public List<String> getProblemMarkerTypes() {
        return problemMarkerTypes;
    }

    public void addProblemMarkerType(String problemMarkerType) {
        problemMarkerTypes.add(problemMarkerType);
    }

    public void removeProblemMarkerType(String problemMarkerType) {
        problemMarkerTypes.remove(problemMarkerType);
    }
}
