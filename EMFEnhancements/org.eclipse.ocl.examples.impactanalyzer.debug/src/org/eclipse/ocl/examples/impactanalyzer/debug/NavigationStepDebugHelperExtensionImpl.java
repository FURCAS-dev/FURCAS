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
package org.eclipse.ocl.examples.impactanalyzer.debug;

import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.debug.NavigationStepDebugHelperExtension;

public class NavigationStepDebugHelperExtensionImpl implements NavigationStepDebugHelperExtension {

    public NavigationStepDebugHelperExtensionImpl() {

    }

    public void printGraph(NavigationStep step, String path) {
	NavigationStepDebugHelperImpl.printGraphFile(step, path);

    }

}
