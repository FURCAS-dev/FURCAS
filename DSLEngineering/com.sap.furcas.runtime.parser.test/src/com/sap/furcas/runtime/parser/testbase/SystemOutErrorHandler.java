package com.sap.furcas.runtime.parser.testbase;

import org.antlr.tool.Message;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.ParsingError;

class SystemOutErrorHandler implements GenerationErrorHandler {

    private boolean failedWithError = false;

    @Override
    public void error(ParsingError exception) {
        System.err.println("ERROR: " + exception.getMessage() + " in line " + exception.getLine());
        failedWithError = true;
    }

    @Override
    public void fatalError(ParsingError exception) {
        System.err.println("FATAL ERROR: " + exception.getMessage() + " in line " + exception.getLine());
        failedWithError = true;
    }

    @Override
    public void warning(ParsingError exception) {
        System.out.println("WARNING: " + exception.getMessage() + " in line " + exception.getLine());
    }

    @Override
    public void error(Message err) {
        System.err.println("ERROR: " + err + " in line " + err.line);
        failedWithError = true;
    }

    @Override
    public void warn(Message warn) {
        System.out.println("WARNING: " + warn + " in line " + warn.line);
    }

    @Override
    public void info(String info) {
        System.out.println("INFO: " + info);
    }

    public boolean hasFailedWithError() {
        return failedWithError;
    }

}