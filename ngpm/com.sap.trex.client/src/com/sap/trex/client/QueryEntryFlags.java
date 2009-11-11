//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from QueryEntryFlags.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class QueryEntryFlags
{
    public static final int QUERYENTRYFLAGS_ANDVALUE = 1; /**< formerly known as ContentType=And, for text(ae) and multivalued attributes, faster than many AND combined query entries */
    public static final int QUERYENTRYFLAGS_ORVALUE = 2; /**< formerly known as ContentType=Or, default if more than one value */
    public static final int QUERYENTRYFLAGS_CASESENSITIVE = 4;
}