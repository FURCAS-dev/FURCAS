package com.sap.furcas.parsergenerator.tcs.generator.errorhandling;

import com.sap.furcas.runtime.parser.impl.ParsingError;

/**
 * The Class LocalisedSyntaxParsingException.
 */
public class LocalisedSyntaxParsingException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1566983651956202346L;

    /** The message. */
    private String message;

    /** The line number. */
    private final int lineNumber;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Gets the line number.
     * 
     * @return the line number
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Instantiates a new localised syntax parsing exception.
     * 
     * @param message
     *            the message
     * @param lineNumber
     *            the line number
     */
    public LocalisedSyntaxParsingException(String message, int lineNumber) {
        super(message);
        this.lineNumber = lineNumber;
    }

    public LocalisedSyntaxParsingException(ParsingError error) {
        this(error.getMessage(), error.getLocation().getStartLine());
    }

}
