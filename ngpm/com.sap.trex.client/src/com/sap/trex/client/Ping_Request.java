//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from Ping_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ping_Request extends Request
{
    private String             itsServer2;
    private ArrayList <String> itsPayload;

    public Ping_Request ()
    {
        itsServer2 = "";
        itsPayload = new ArrayList <String> ();
    }

    public void clear()
    {
        itsServer2 = "";
        itsPayload.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"Ping_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsServer2);
        theStream.writeVectorSize(itsPayload.size());
        for(i=0; i<itsPayload.size(); i++)
        {
            theStream.writeString(itsPayload.get(i));
        }
    }

    /**
     * \class Ping_Request
     *
     * \var server2  optional
     * \var payload  -
     */

    public String getServer2() 
    {
        return itsServer2;
    }

    public void setServer2(String theServer2)
    {
        itsServer2 = theServer2; 
    }


    public ArrayList <String> getPayload() 
    {
        return itsPayload;
    }

    public void setPayload(ArrayList <String> thePayload)
    {
        itsPayload = thePayload; 
    }

    public void addPayload(String thePayload)
    {
        itsPayload.add(thePayload); 
    }

}