package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements;

public class OptimizationActivationOptions {

    // Level 1 Optimizations
    private static boolean isImpactAnalysisActive = true;

    // Level 2 Optimizations
    private static boolean isDeltaPropagationActive = true;
    private static boolean isInstanceScopeActive = true;

    public static void setImpactAnalysisActive(boolean isImpactAnalysisActive) {
	OptimizationActivationOptions.isImpactAnalysisActive = isImpactAnalysisActive;
    }

    public static boolean isImpactAnalysisActive() {
	return isImpactAnalysisActive;
    }

    public static void setDeltaPropagationActive(boolean isDeltaPropagationActive) {
	OptimizationActivationOptions.isDeltaPropagationActive = isDeltaPropagationActive;
    }

    public static boolean isDeltaPropagationActive() {
	return isDeltaPropagationActive;
    }

    public static void setInstanceScopeActive(boolean isInstanceScopeActive) {
	OptimizationActivationOptions.isInstanceScopeActive = isInstanceScopeActive;
    }

    public static boolean isInstanceScopeActive() {
	return isInstanceScopeActive;
    }

    public static String getActivationString(){
	StringBuffer activationInformation = new StringBuffer();
	activationInformation.append("[IA=");
	activationInformation.append(isImpactAnalysisActive);
	activationInformation.append("]");

	activationInformation.append("[IS=");
	activationInformation.append(isInstanceScopeActive);
	activationInformation.append("]");

	activationInformation.append("[DP=");
	activationInformation.append(isDeltaPropagationActive);
	activationInformation.append("]");

	return activationInformation.toString();
    }
    // Level 3 Optimization
    //TODO: Add level 3 optimizations
}
