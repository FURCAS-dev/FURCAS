//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from TmxRequestType.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class TmxRequestType
{
    public static final int TMXREQUESTTYPE_UNDEFINED = 1729;
    public static final int TMXREQUESTTYPE_OPEN = 0;
    public static final int TMXREQUESTTYPE_CLOSE = 1;
    public static final int TMXREQUESTTYPE_EXECUTEQUERY = 2;
    public static final int TMXREQUESTTYPE_FETCHMETADATA = 3;
    public static final int TMXREQUESTTYPE_FASTOPEN = 4;
    public static final int TMXREQUESTTYPE_RELEASEMEMORY = 5;
    public static final int TMXREQUESTTYPE_EXECUTEQUERYWITHSINGLERESULT = 6;
}