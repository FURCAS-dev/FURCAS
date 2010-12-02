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
package de.hpi.sam.bp2009.solution.impactAnalyzer.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ImpactAnalyzerIAAnnotationsSuite extends TestSuite {

	public static Test suite() {
        System.setProperty("de.hpi.sam.bp2009.solution.impactAnalyzer.debug", "true");
        return ImpactAnalyzerAllTests.suite();
    }

}
