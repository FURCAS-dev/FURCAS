package com.sap.ide.cts.parser.incremental;

import com.sap.mi.textual.grammar.exceptions.DeferredModelElementCreationException;

public class IncrementalParsingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808709784795050127L;

	public IncrementalParsingException(String message) {
		super(message);
	}

	public IncrementalParsingException(
		DeferredModelElementCreationException e) {
	    super(e);
	}

}
