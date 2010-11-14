package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;

public class ImpactAnalyzerImplWithPublicInstanceScopeAnalysis extends ImpactAnalyzerImpl {

    public ImpactAnalyzerImplWithPublicInstanceScopeAnalysis(OCLExpression expression,
            boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, notifyOnNewContextElements, configuration, oclFactory);
    }

    @Override
    public InstanceScopeAnalysis createInstanceScopeAnalysis() {
        return super.createInstanceScopeAnalysis();
    }
}
