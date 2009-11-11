//
// TrexClient - (c) 2008 SAP AG
//
// created from RollbackTransaction_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RollbackTransaction_Request extends Request
{
    private ArrayList <String> itsIndexIds;
    private long               itsTransactionId;

    public RollbackTransaction_Request ()
    {
        itsIndexIds = new ArrayList <String> ();
        itsTransactionId = 0;
    }

    public void clear()
    {
        itsIndexIds.clear();
        itsTransactionId = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"RollbackTransaction_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeVectorSize(itsIndexIds.size());
        for(i=0; i<itsIndexIds.size(); i++)
        {
            theStream.writeString(itsIndexIds.get(i));
        }
        theStream.writeLong(itsTransactionId);
    }

    /**
     * \class RollbackTransaction_Request
     *
     * \var indexIds       -
     * \var transactionId  -
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


    public long getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(long theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }

}