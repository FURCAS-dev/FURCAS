package org.oslo.ocl20.syntax.parser;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;


public class StructuredErrorDescription {

	private String msg;
	private java_cup.runtime.Symbol at;
	private boolean isWarning;
	private boolean isError;
	private String source;
		
	public StructuredErrorDescription(boolean isError, boolean isWarning, String message, java_cup.runtime.Symbol info, String source) {
		this.isWarning=isWarning;
		this.isError=isError;
		msg=message;
		at=info;
		this.source=source;		
	}

	public String getMessage() {
		return msg;
	}

	public boolean isError() {
		return isError;
	}

	public boolean isWarning() {
		return isWarning;
	}
	
	public String getSource() {
		return source;
	}

	public int getBeginColumn() {
		return OclSemanticAnalyserVisitorImpl.getBeginColumn(at);
	}

	public int getBeginLine() {
		return OclSemanticAnalyserVisitorImpl.getBeginLine(at);
	}

	public int getEndColumn() {
		return OclSemanticAnalyserVisitorImpl.getEndColumn(at);
	}

	public int getEndLine() {
		return OclSemanticAnalyserVisitorImpl.getEndLine(at);
	}
}
