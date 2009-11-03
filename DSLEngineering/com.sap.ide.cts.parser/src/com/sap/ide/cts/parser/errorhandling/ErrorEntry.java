package com.sap.ide.cts.parser.errorhandling;

import org.antlr.runtime.RecognitionException;


public class ErrorEntry implements IIssue {
	private RecognitionException ex = null;
	private String errorText = null;
	
	public ErrorEntry(RecognitionException ex, String errorText) {
		super();
		this.ex = ex;
		this.errorText = errorText;
	}
	
	public RecognitionException getEx() {
		return ex;
	}
	
	public String getMessage() {
		return errorText;
	}
	
	public SeverityEnum getSeverity() {
		return SeverityEnum.ERROR;
	}
}
