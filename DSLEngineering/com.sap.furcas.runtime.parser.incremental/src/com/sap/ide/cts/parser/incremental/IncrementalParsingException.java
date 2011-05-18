package com.sap.ide.cts.parser.incremental;

import java.util.List;

import com.sap.furcas.runtime.parser.ParsingError;


public class IncrementalParsingException extends RuntimeException {

    private static final long serialVersionUID = -6808709784795050127L;
    private List<ParsingError> errorList;

    public IncrementalParsingException(String message,  List<ParsingError> errorList) {
        super(message);
        this.errorList = errorList;
    }

    public IncrementalParsingException(String message, Throwable e) {
        super(message, e);
    }
    
    public List<ParsingError> getIssuesList() {
        return errorList;
    }
    
    @Override
    public String toString() {
        if (errorList == null || errorList.isEmpty()) {
            return super.toString();
        }
        StringBuffer messages = new StringBuffer();
        messages.append(super.toString() + ":\n");
        for (ParsingError parsingError : errorList) {
            messages.append(parsingError.getMessage()).append(" in line ").append(parsingError.getLine()).append('\n');
        }
        return messages.toString();
    }

}
