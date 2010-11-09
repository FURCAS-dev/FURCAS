package com.sap.ide.cts.parser.errorhandling;

import org.antlr.runtime.RecognitionException;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

public class IncompleteRecognitionException extends RecognitionException {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final TextBlock incompleteTextBlock;
	private final RecognitionException e;

	public IncompleteRecognitionException(RecognitionException e,
			TextBlock itb) {
		super();
		this.e = e;
		this.incompleteTextBlock = itb;
	}

	public RecognitionException getNestedException() {
		return e;
	}

	public TextBlock getIncompleteTextBlock() {
		return incompleteTextBlock;
	}
	
	

}
