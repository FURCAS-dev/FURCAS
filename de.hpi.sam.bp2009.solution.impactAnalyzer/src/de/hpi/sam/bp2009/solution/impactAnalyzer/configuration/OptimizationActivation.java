package de.hpi.sam.bp2009.solution.impactAnalyzer.configuration;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

public class OptimizationActivation {
	private static final ThreadLocal<ActivationOption> activeOption = new ThreadLocal<ActivationOption>() {
		@Override 
        protected ActivationOption initialValue() {
          	 return new ActivationOption(true, true);
        };
	};
	
	public static ActivationOption getOption(){
		return activeOption.get();
	}
	
	public static void setOption(ActivationOption option){
		activeOption.set(option);
	}
}
		
	
	