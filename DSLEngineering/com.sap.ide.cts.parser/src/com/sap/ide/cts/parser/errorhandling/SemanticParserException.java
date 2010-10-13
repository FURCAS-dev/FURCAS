package com.sap.ide.cts.parser.errorhandling;

import java.util.List;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.impl.ParsingError;

public class SemanticParserException extends Exception {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final List<ParsingError> errorList;

	private final Object rootElement;

	private final TextBlock textBlock;

	public SemanticParserException(List<ParsingError> errorList2,
			TextBlock textBlock, Object rootElements) {
		this.errorList = errorList2;
		this.textBlock = textBlock;
		this.rootElement = rootElements;
	}

	public List<ParsingError> getIssuesList() {
		return errorList;
	}

	public Object getRootElement() {
		return rootElement;
	}

	public TextBlock getTextBlock() {
		return textBlock;
	}

}
