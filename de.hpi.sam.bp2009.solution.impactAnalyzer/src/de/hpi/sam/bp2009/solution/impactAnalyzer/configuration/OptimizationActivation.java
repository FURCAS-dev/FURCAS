package de.hpi.sam.bp2009.solution.impactAnalyzer.configuration;


public class OptimizationActivation {
	private static final ThreadLocal<ActivationOption> activeOption = new ThreadLocal<ActivationOption>() {
		@Override
        protected ActivationOption initialValue() {
          	 return new ActivationOption(true, true, true, false, "All optimizations activated");
        };
	};

	public static ActivationOption getOption(){
		return activeOption.get();
	}

	public static void setOption(ActivationOption option){
		activeOption.set(option);
	}
}


