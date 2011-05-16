package com.sap.ide.cts.parser.errorhandling;

import java.util.List;

import com.sap.furcas.runtime.parser.ParsingError;

public class SemanticParserException extends Exception {

    private static final long serialVersionUID = 1L;

    public enum Component { LEXER, PARSER }

    private final Component componentThatFailed;
    private final List<ParsingError> errorList;
    

    public SemanticParserException(List<ParsingError> errorList, Component componentThatFailed) {
        this.errorList = errorList;
        this.componentThatFailed = componentThatFailed;
    }

    public List<ParsingError> getIssuesList() {
        return errorList;
    }

    public Component getComponentThatFailed() {
        return componentThatFailed;
    }

}
