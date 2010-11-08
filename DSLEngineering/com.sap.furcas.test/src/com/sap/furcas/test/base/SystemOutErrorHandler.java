package com.sap.furcas.test.base;

import org.antlr.tool.Message;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.ParsingError;

class SystemOutErrorHandler implements GenerationErrorHandler {

    private boolean failedWithError = false;

    @Override
    public void error(ParsingError exception) {
        failedWithError = true;
        System.err.println("ERROR: " + exception.getMessage());
    }

    @Override
    public void fatalError(ParsingError exception) {
        failedWithError = true;
        System.err.println("FATAL ERROR: " + exception.getMessage());
    }

    @Override
    public void warning(ParsingError exception) {
        System.out.println("WARNING: " + exception.getMessage());
    }

    @Override
    public void error(Message err) {
        failedWithError = true;
        System.err.println("ERROR: " + err);
    }

    @Override
    public void warn(Message warn) {
        System.out.println("WARNING: " + warn);
    }

    @Override
    public void info(String info) {
        System.out.println("INFO: " + info);
    }

    public boolean hasFailedWithError() {
        return failedWithError;
    }

}