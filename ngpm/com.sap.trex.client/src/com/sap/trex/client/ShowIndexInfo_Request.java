//
// TrexClient - (c) 2008 SAP AG
//
// created from ShowIndexInfo_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowIndexInfo_Request extends Request
{
    private String itsQuery;

    public ShowIndexInfo_Request ()
    {
        itsQuery = "";
    }

    public void clear()
    {
        itsQuery = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"ShowIndexInfo_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsQuery);
    }

    /**
     * \class ShowIndexInfo_Request
     *
     * \var query  -
     */

    public String getQuery() 
    {
        return itsQuery;
    }

    public void setQuery(String theQuery)
    {
        itsQuery = theQuery; 
    }

}