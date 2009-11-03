package com.sap.tc.moin.js.query.service;

/**
 * Exception class for service fault.
 */
@SuppressWarnings( "serial" )
@javax.xml.ws.WebFault( name = "QueryExecutionFaultInfo", targetNamespace = "http://sap.com/tc/moin/js/query/service/", faultBean = "java.lang.String" )
public class QueryExecutionFault extends java.lang.Exception {

    private java.lang.String _QueryExecutionFault;

    public QueryExecutionFault( String message, java.lang.String faultInfo ) {

        super( message );
        this._QueryExecutionFault = faultInfo;
    }

    public QueryExecutionFault( String message, java.lang.String faultInfo, Throwable cause ) {

        super( message, cause );
        this._QueryExecutionFault = faultInfo;
    }

    public java.lang.String getFaultInfo( ) {

        return this._QueryExecutionFault;
    }

}
