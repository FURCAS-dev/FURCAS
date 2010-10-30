package de.hpi.sam.bp2009.solution.oclToAst.impl;

import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;

/**
 * Data container for all informations around an exception
 * @author Philipp
 */
public class ErrorMessageImpl implements ErrorMessage{
    private Exception e;
    private String m;
    private Object o;

    public ErrorMessageImpl(Exception exception, String message, Object object) {
        this.e=exception;
        this.m=message;
        this.o=object;
    }

    @Override
    public Object getAffectedObject() {
        return o;
    }

    @Override
    public Exception getException() {
        return e;                   
    }

    @Override
    public String getMessageString() {
        return m;
    }

}
