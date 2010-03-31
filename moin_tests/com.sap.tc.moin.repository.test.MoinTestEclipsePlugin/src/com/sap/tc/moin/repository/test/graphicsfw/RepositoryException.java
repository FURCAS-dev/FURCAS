/*
 * Created on 31.01.2006
 *
 */
package com.sap.tc.moin.repository.test.graphicsfw;

/**
 * Wrapper class for exceptions
 * 
 * @author d043982
 *
 */
public class RepositoryException extends Exception {

    public RepositoryException( Exception ex ) {

        super( ex );
    }

    public RepositoryException( String message ) {

        super( message );
    }

}
