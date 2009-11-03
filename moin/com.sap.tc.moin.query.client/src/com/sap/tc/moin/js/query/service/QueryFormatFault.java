package com.sap.tc.moin.js.query.service;

/**
 * Exception class for service fault.
 */
@SuppressWarnings( "serial" )
@javax.xml.ws.WebFault( name = "processReport", targetNamespace = "http://sap.com/tc/moin/js/query/service/", faultBean = "com.sap.tc.moin.js.query.service.ProcessReport" )
public class QueryFormatFault extends java.lang.Exception {

    private final com.sap.tc.moin.js.query.service.ProcessReport _QueryFormatFault;

    public QueryFormatFault( String message, com.sap.tc.moin.js.query.service.ProcessReport faultInfo ) {

        super( message );
        this._QueryFormatFault = faultInfo;
    }

    public QueryFormatFault( String message, com.sap.tc.moin.js.query.service.ProcessReport faultInfo, Throwable cause ) {

        super( message, cause );
        this._QueryFormatFault = faultInfo;
    }

    public com.sap.tc.moin.js.query.service.ProcessReport getFaultInfo( ) {

        return this._QueryFormatFault;
    }

}
