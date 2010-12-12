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
package org.eclipse.ocl.examples.impactanalyzer.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ImpactAnalyzerNavigationStepsSuite extends TestSuite {

	public static Test suite() {
        System.setProperty("navigationStepIA", "true");
        System.setProperty("de.hpi.sam.bp2009.solution.impactAnalyzer.debug", "false");
        System.setProperty("unusedCheckIA", "false");
        return ImpactAnalyzerAllTests.suite();
    }

}
