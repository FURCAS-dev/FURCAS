package org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;
import org.eclipse.ocl.examples.impactanalyzer.impl.ImpactAnalyzerImpl;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.InstanceScopeAnalysis;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;


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
