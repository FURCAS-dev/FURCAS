//
// TrexClient - (c) 2008 SAP AG
//
// created from DeleteCube_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteCube_Request extends Request
{
    private String itsIndexId;

    public DeleteCube_Request ()
    {
        itsIndexId = "";
    }

    public void clear()
    {
        itsIndexId = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"DeleteCube_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsIndexId);
    }

    /**
     * \class DeleteCube_Request
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