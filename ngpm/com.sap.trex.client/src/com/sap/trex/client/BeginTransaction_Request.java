//
// TrexClient - (c) 2008 SAP AG
//
// created from BeginTransaction_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeginTransaction_Request extends Request
{
    private ArrayList <String> itsIndexIds;

    public BeginTransaction_Request ()
    {
        itsIndexIds = new ArrayList <String> ();
    }

    public void clear()
    {
        itsIndexIds.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"BeginTransaction_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeVectorSize(itsIndexIds.size());
        for(i=0; i<itsIndexIds.size(); i++)
        {
            theStream.writeString(itsIndexIds.get(i));
        }
    }

    /**
     * \class BeginTransaction_Request
     *
     * \var indexIds  -
     */

    public ArrayList <String> getIndexIds() 
    {
        return itsIndexIds;
    }

    public void setIndexIds(ArrayList <String> theIndexIds)
    {
        itsIndexIds = theIndexIds; 
    }

    public void addIndexId(String theIndexIds)
    {
        itsIndexIds.add(theIndexIds); 
    }

}