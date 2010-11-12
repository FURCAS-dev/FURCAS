/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonAnnotationTypeInfo.java,v 1.1 2010/03/11 14:51:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.imp.services.IAnnotationTypeInfo;

/**
 * This is the same as SimpleAnnotationTypeInfo but with a non-static content so
 * that editors do not interact and accumulate.
 */
public class CommonAnnotationTypeInfo implements IAnnotationTypeInfo
{
    /*
     * For the management of associated problem-marker types
     */
    private List<String> problemMarkerTypes = new ArrayList<String>();

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
