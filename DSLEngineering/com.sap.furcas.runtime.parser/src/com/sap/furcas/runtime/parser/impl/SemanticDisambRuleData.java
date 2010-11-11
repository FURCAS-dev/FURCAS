package com.sap.furcas.runtime.parser.impl;

public class SemanticDisambRuleData {
	
	private final String rule;
	private final String ocl;
	public SemanticDisambRuleData(String rule, String ocl) {
		super();
		this.rule = rule;
		this.ocl = ocl;
	}
	public String getRule() {
		return rule;
	}
	public String getOcl() {
		return ocl;
	}
	

}
