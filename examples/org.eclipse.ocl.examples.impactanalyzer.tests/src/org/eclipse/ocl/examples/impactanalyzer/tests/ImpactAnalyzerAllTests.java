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

import org.eclipse.ocl.examples.impactanalyzer.configuration.OptimizationActivation;
import org.eclipse.ocl.examples.impactanalyzer.tests.deltaPropagation.PartialEvaluatorTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.filterSynthesis.FilterSynthesisEMEnabledTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.filterSynthesis.FilterSynthesisTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope.NavigationStepDebugGraphTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope.NgpmModelBasedOclIaTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope.OclIaTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope.QuickOclParseAndEvalTest;
import org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope.RevPathComputationTest;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class ImpactAnalyzerAllTests extends TestSuite {

    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new ImpactAnalyzerAllTests("Impact Analyzer Tests");
        if (System.getProperty("navigationStepIA", "false").equalsIgnoreCase("true")) {
            OptimizationActivation.getOption().setTracebackStepISAActive(false);
            OptimizationActivation.getOption().setUnusedDetectionActive(false);
            OptimizationActivation.getOption().setOperationCallSelectionActive(false);
        }
        if (System.getProperty("unusedCheckIA", "false").equalsIgnoreCase("true")) {
            OptimizationActivation.getOption().setUnusedDetectionActive(true);
        }
        suite.addTestSuite(OclIaTest.class);
        suite.addTestSuite(RevPathComputationTest.class);
        suite.addTestSuite(PartialEvaluatorTest.class);
        // TODO The NavigationPathCreationTest is not yet ready for inclusion here; takes too long and doesn't
        // pass because it tests with the individual PropertyCallExp without considering their context
        // suite.addTestSuite(NavigationPathCreationTest.class);
        suite.addTestSuite(NavigationStepDebugGraphTest.class);
        suite.addTestSuite(QuickOclParseAndEvalTest.class);
        suite.addTestSuite(FilterSynthesisTest.class);
        suite.addTestSuite(FilterSynthesisEMEnabledTest.class);
        suite.addTestSuite(NgpmModelBasedOclIaTest.class);
        return suite;
    }

    public ImpactAnalyzerAllTests(String name) {
        super(name);
    }

}//ImpactAnalyzerAllTests
