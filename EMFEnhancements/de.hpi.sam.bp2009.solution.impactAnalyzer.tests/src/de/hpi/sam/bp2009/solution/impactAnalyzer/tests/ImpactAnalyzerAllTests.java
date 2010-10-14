package de.hpi.sam.bp2009.solution.impactAnalyzer.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.tests.PartialEvaluatorTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests.FilterSynthesisEMEnabledTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests.FilterSynthesisTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.NavigationStepDebugGraphTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.OclIaTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.QuickOclParseAndEvalTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.NgpmModelBasedOclIaTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.RevPathComputationTest;


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
        suite.addTestSuite(OclIaTest.class);
        suite.addTestSuite(RevPathComputationTest.class);
        suite.addTestSuite(PartialEvaluatorTest.class);
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
