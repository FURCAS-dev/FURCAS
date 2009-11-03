package com.sap.tc.moin.repository.jmigenerator.controller;

public interface LogCallback {

    public void log( String message );

    public void logThrowable( Throwable throwable );

    public void logError( String message );

    public void logWarn( String message );

    public void logInfo( String message );
}