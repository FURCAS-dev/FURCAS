//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from AdminService.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sap.trex.client.*;

public class AdminService extends Service  {

    //
    // AdminService
    //

    public AdminService (Connection theConnection)
    { super(theConnection);}
    // Admin

    public boolean getLoadHistoryCsv(LoadHistoryCsv_Request theRequest, LoadHistoryCsv_Result theResult) throws Exception
    {
        return call("getLoadHistoryCsv", theRequest, theResult);
    }

    public boolean getVersion(Request theRequest, GetVersion_Result theResult) throws Exception
    {
        return call("getVersion", theRequest, theResult);
    }

    public boolean ping(Ping_Request theRequest, Ping_Result theResult) throws Exception
    {
        return call("ping", theRequest, theResult);
    }
}
