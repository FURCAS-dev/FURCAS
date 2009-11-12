//
// TrexClient - (c) 2008 SAP AG
//
// created from LastTransaction_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LastTransaction_Request extends Request
{
    private String itsIndexId;

    public LastTransaction_Request ()
    {
        itsIndexId = "";
    }

    public void clear()
    {
        itsIndexId = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"LastTransaction_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsIndexId);
    }

    /**
     * \class LastTransaction_Request
     *
     * \var indexId  -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }

}