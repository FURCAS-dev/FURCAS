//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ShowJoinIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowJoinIndex_Request extends Request
{
    private IndexName itsIndexName;

    public ShowJoinIndex_Request ()
    {
        itsIndexName = new IndexName ();
    }

    public void clear()
    {
        itsIndexName.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"ShowJoinIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        itsIndexName.write(theStream);
    }

    /**
     * \class ShowJoinIndex_Request
     *
     * \var indexName  language is for descriptions. default language if empty
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