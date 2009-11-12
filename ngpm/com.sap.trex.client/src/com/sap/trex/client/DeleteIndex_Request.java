//
// TrexClient - (c) 2008 SAP AG
//
// created from DeleteIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteIndex_Request extends Request
{
    private IndexName itsIndexName;

    public DeleteIndex_Request ()
    {
        itsIndexName = new IndexName ();
    }

    public void clear()
    {
        itsIndexName.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"DeleteIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        itsIndexName.write(theStream);
    }

    /**
     * \class DeleteIndex_Request
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