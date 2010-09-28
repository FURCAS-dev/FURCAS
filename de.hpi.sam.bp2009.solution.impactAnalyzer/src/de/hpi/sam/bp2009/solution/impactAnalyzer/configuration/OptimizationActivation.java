package de.hpi.sam.bp2009.solution.impactAnalyzer.configuration;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;

/**
 * Call {@link #getOption()} to obtain the singleton {@link ActivationOption} object through which you can configure the behavior
 * of the {@link ImpactAnalyzer} and more specifically, the {@link InstanceScopeAnalysis} component. The different
 * options are explained in the {@link ActivationOption} documentation. Clients may also use
 * {@link #setOption(ActivationOption)} to set a new {@link ActivationOption} object specifically configured.
 * It becomes effective at the time the setter is called. It is not recommended to change the configuration
 * once an {@link ImpactAnalyzer} or {@link InstanceScopeAnalysis} object has been created and used for the
 * first time because certain up-front calculations and caching may depend on the configuration chosen.
 */
public class OptimizationActivation {
    private static final ThreadLocal<ActivationOption> activeOption = new ThreadLocal<ActivationOption>() {
        @Override
        protected ActivationOption initialValue() {
            return new ActivationOption(true, true, true, true, "All optimizations activated");
        };
    };

    public static ActivationOption getOption() {
        return activeOption.get();
    }

    public static void setOption(ActivationOption option) {
        activeOption.set(option);
    }
}
