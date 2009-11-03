package com.sap.tc.moin.js.query.service;

/**
 * Exception class for service fault.
 */
@SuppressWarnings( "serial" )
@javax.xml.ws.WebFault( name = "InvalidResourceIdentifierFaultInfo", targetNamespace = "http://sap.com/tc/moin/js/query/service/", faultBean = "java.lang.String" )
public class InvalidResourceIdentifierFault extends java.lang.Exception {

    private java.lang.String _InvalidResourceIdentifierFault;

    public InvalidResourceIdentifierFault( String message, java.lang.String faultInfo ) {

        super( message );
        this._InvalidResourceIdentifierFault = faultInfo;
    }

    public InvalidResourceIdentifierFault( String message, java.lang.String faultInfo, Throwable cause ) {

        super( message, cause );
        this._InvalidResourceIdentifierFault = faultInfo;
    }

    public java.lang.String getFaultInfo( ) {

        return this._InvalidResourceIdentifierFault;
    }

}
