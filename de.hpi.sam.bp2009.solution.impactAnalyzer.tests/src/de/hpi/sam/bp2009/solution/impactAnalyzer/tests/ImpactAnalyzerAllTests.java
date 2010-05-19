package de.hpi.sam.bp2009.solution.impactAnalyzer.tests;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests.FilterSynthesisTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.OclIaTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests.RevPathComputationTest;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class ImpactAnalyzerAllTests extends TestSuite{

    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new ImpactAnalyzerAllTests("Impact Analyzer Tests");
        suite.addTestSuite(FilterSynthesisTest.class);
        suite.addTestSuite(OclIaTest.class);
        suite.addTestSuite(RevPathComputationTest.class);
        return suite;
    }

    public ImpactAnalyzerAllTests(String name) {
        super(name);
    }

}//ImpactAnalyzerAllTests
