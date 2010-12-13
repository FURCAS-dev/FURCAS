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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.debug;

import java.util.logging.Logger;

import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;


/**
 * The NavigationStepDebugHelper provides additional functionalities, which can be used to debug NavigationStep structures.
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepDebugHelper {
    static private Logger logger = Logger.getLogger(NavigationStepDebugHelper.class.getName());
    
    private static NavigationStepDebugHelperExtension debugHelperExtension;

    public static void setNavigationStepDebugHelperExtension(NavigationStepDebugHelperExtension ext) {
        debugHelperExtension = ext;
    }

    public static void printGraphFile(NavigationStep step, String path) {
        NavigationStepDebugHelperExtension extension = getDebugHelperExtension();
        if (extension != null) {
            extension.printGraph(step, path);
        }
    }

    private static NavigationStepDebugHelperExtension getDebugHelperExtension() {
        NavigationStepDebugHelperExtension result = debugHelperExtension;
        if (result == null) {
            try {
                result = (NavigationStepDebugHelperExtension) Class.forName("de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.NavigationStepDebugHelperExtensionImpl").newInstance();
            } catch (Exception e) {
                logger.throwing(NavigationStepDebugHelper.class.getName(), "getDebugHelperExtension", e);
            }
        }
        return result;
    }
}
