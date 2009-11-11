//
// TrexClient - (c) 2008 SAP AG
//
// created from LoadHistoryCsv_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadHistoryCsv_Request extends Request
{
    private long itsBegin;

    public LoadHistoryCsv_Request ()
    {
        itsBegin = 0;
    }

    public void clear()
    {
        itsBegin = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"LoadHistoryCsv_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeLong(itsBegin);
    }

    /**
     * \class LoadHistoryCsv_Request
     *
     * \var begin  -
     */

    public long getBegin() 
    {
        return itsBegin;
    }

    public void setBegin(long theBegin)
    {
        itsBegin = theBegin; 
    }

}