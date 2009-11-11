//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ListTransaction_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListTransaction_Result extends Result
{
    private ArrayList <TransactionInfo> itsTransactions;

    public ListTransaction_Result ()
    {
        itsTransactions = new ArrayList <TransactionInfo> ();
    }

    public void clear()
    {
        super.clear();
        itsTransactions.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsTransactions.ensureCapacity(j);
        while(itsTransactions.size()<j)
            itsTransactions.add(new TransactionInfo());
        while(itsTransactions.size()>j)
            itsTransactions.remove(itsTransactions.size()-1);
        for(i=0; i<j; i++)
            itsTransactions.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ListTransaction_Result");
    }

    /**
     * \class ListTransaction_Result
     *
     * \var transactions  -
     */

    public ArrayList <TransactionInfo> getTransactions() 
    {
        return itsTransactions;
    }

    public void setTransactions(ArrayList <TransactionInfo> theTransactions)
    {
        itsTransactions = theTransactions; 
    }

    public void addTransaction(TransactionInfo theTransactions)
    {
        itsTransactions.add(theTransactions); 
    }

}