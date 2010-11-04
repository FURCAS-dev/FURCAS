package com.sap.furcas.parsergenerator.tcs.generator.errorhandling;

import org.antlr.tool.Message;

import com.sap.furcas.runtime.parser.impl.ParsingError;

public interface GenerationErrorHandler {

    /**
     * Error.
     * 
     * @param exception
     *            the exception
     */
    public void error(ParsingError exception);

    /**
     * Fatal error.
     * 
     * @param exception
     *            the exception
     */
    public void fatalError(ParsingError exception);

    /**
     * Warning.
     * 
     * @param exception
     *            the exception
     */
    public void warning(ParsingError exception);

    /**
     * for antlr errors
     * 
     * @param arg0
     */
    public void error(Message err);

    /**
     * @param arg0
     */
    public void warn(Message warn);

    /**
     * @param arg0
     */
    public void info(String info);

}