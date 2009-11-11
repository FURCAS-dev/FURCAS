//
// TrexClient - (c) 2008 SAP AG
//
// created from ShowIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowIndex_Request extends Request
{
    private IndexName itsIndexName;

    public ShowIndex_Request ()
    {
        itsIndexName = new IndexName ();
    }

    public void clear()
    {
        itsIndexName.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"ShowIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        itsIndexName.write(theStream);
    }

    /**
     * \class ShowIndex_Request
     *
     * \var indexName  -
     */

    public IndexName getIndexName() 
    {
        return itsIndexName;
    }

    public void setIndexName(IndexName theIndexName)
    {
        itsIndexName = theIndexName; 
    }

}