//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from TransactionInfo.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionInfo
{
    private String             itsTransactionId;
    private ArrayList <String> itsIndexIds;

    public TransactionInfo ()
    {
        itsTransactionId = "";
        itsIndexIds = new ArrayList <String> ();
    }

    public void clear()
    {
        itsTransactionId = "";
        itsIndexIds.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsTransactionId = theStream.readString();
        j = theStream.readVectorSize();
        itsIndexIds.ensureCapacity(j);
        while(itsIndexIds.size()<j)
            itsIndexIds.add(new String());
        while(itsIndexIds.size()>j)
            itsIndexIds.remove(itsIndexIds.size()-1);
        for(i=0; i<j; i++)
            itsIndexIds.set(i,theStream.readString());
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"TransactionInfo");
    }

    /**
     * \class TransactionInfo
     *
     * \var transactionId  -
     * \var indexIds       -
     */

    public String getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(String theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }


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