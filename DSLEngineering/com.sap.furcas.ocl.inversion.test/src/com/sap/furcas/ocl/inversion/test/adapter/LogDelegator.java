package com.sap.furcas.ocl.inversion.test.adapter;

import uk.ac.kent.cs.kmf.util.ILog;

public class LogDelegator implements ILog {

    private final ILog delegate;
    
    public LogDelegator(ILog delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public void finalReport() {
        delegate.finalReport();
    }

    @Override
    public int getErrors() {
        return delegate.getErrors();
    }

    @Override
    public int getWarnings() {
        return delegate.getWarnings();
    }

    @Override
    public boolean hasErrors() {
        return delegate.hasErrors();
    }

    @Override
    public boolean hasViolations() {
        return delegate.hasViolations();
    }

    @Override
    public boolean hasWarnings() {
        return delegate.hasWarnings();
    }

    @Override
    public void printMessage(String arg0) {
        delegate.printMessage(arg0);
    }

    @Override
    public void reportError(String arg0) {
        delegate.reportError(arg0);
    }

    @Override
    public void reportError(String arg0, Exception arg1) {
        delegate.reportError(arg0, arg1);
    }

    @Override
    public void reportMessage(String arg0) {
        delegate.reportMessage(arg0);
    }

    @Override
    public void reportWarning(String arg0) {
        delegate.reportWarning(arg0);
    }

    @Override
    public void reportWarning(String arg0, Exception arg1) {
        delegate.reportWarning(arg0, arg1);
    }

    @Override
    public void reset() {
        delegate.reset();
    }

    @Override
    public void resetErrors() {
        delegate.resetErrors();
    }

    @Override
    public void resetViolations() {
        delegate.resetViolations();
    }

    @Override
    public void resetWarnings() {
        delegate.resetWarnings();
    }

    @Override
    public boolean tooManyViolations() {
        return delegate.tooManyViolations();
    }

}
