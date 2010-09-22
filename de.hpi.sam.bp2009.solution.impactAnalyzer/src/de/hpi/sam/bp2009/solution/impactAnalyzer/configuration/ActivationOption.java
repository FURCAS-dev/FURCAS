package de.hpi.sam.bp2009.solution.impactAnalyzer.configuration;

public class ActivationOption {
    // Level 1 Optimizations
    private boolean isImpactAnalysisActive = true;

    // Level 2 Optimizations
    private boolean isDeltaPropagationActive = true;
    private boolean isInstanceScopeActive = true;
    private boolean isTracebackStepISAActive = true; // if set to false, NavigationStep method will be used
    private boolean isUnusedDetectionActive = true;

    private final String optionDescription;

    public ActivationOption(boolean isImpactAnalysisActive, boolean isDeltaPropagationActive, boolean isUnusedDetectionActive, String description) {
	this.isImpactAnalysisActive = isImpactAnalysisActive;
	this.isDeltaPropagationActive = isDeltaPropagationActive;
	this.optionDescription = description;
    }

    public void setImpactAnalysisActive(boolean isImpactAnalysisActive) {
	this.isImpactAnalysisActive = isImpactAnalysisActive;
    }

    public boolean isImpactAnalysisActive() {
	return isImpactAnalysisActive;
    }
    
    public void setDeltaPropagationActive(boolean isDeltaPropagationActive) {
	this.isDeltaPropagationActive = isDeltaPropagationActive;
    }

    public boolean isDeltaPropagationActive() {
	return isDeltaPropagationActive;
    }

    public void setInstanceScopeActive(boolean isInstanceScopeActive) {
	this.isInstanceScopeActive = isInstanceScopeActive;
    }

    public boolean isInstanceScopeActive() {
	return isInstanceScopeActive;
    }

    public void setTracebackStepIAActive(boolean isTracebackStepISAActive){
        this.isTracebackStepISAActive = isTracebackStepISAActive;
    }
    
    public boolean isTracebackStepIAActive(){
        return isTracebackStepISAActive;
    }
    
    public boolean isUnusedDetectionActive() {
        return isUnusedDetectionActive;
    }

    public void setUnusedDetectionActive(boolean isUnusedDetectionActive) {
        this.isUnusedDetectionActive = isUnusedDetectionActive;
    }

    public String getActivationString() {
	StringBuffer activationInformation = new StringBuffer();
	activationInformation.append("[IA=");
	activationInformation.append(isImpactAnalysisActive);
	activationInformation.append("]");

	activationInformation.append("[IS=");
	activationInformation.append(isInstanceScopeActive);
	activationInformation.append("]");
	
	activationInformation.append("[TM=");
	activationInformation.append(isTracebackStepISAActive);
	activationInformation.append("]");

	activationInformation.append("[DP=");
	activationInformation.append(isDeltaPropagationActive);
	activationInformation.append("]");

        activationInformation.append("[UD=");
        activationInformation.append(isUnusedDetectionActive);
        activationInformation.append("]");

	return activationInformation.toString();
    }

    // Level 3 Optimization
    // TODO: Add level 3 optimizations

    public String getOptionDescription() {
	return optionDescription;
    }

}
