package com.sap.tc.moin.repository.spi.ps.errorhandler;



/**
 * Factory for parser error handlers. This interface has to be implemented by
 * custom error handler providers.
 * <p>
 * Error handlers allow to react on problems that occur while parsing a model
 * file, e. g. because of incompatible metamodel changes. The error handler can
 * return the solution of the problem an allow the parser to continue to run.
 * </p>
 * 
 * @author d026715
 */
public interface SpiCustomErrorHandlerFactory {

    /**
     * Returns a parser error handler.
     * 
     * @return
     */
    SpiParserErrorHandler getParserErrorHandler( );

}
