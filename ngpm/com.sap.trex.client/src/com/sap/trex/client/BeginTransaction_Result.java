//
// TrexClient - (c) 2008 SAP AG
//
// created from BeginTransaction_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeginTransaction_Result extends Result
{
    private long itsTransactionId;

    public BeginTransaction_Result ()
    {
        itsTransactionId = 0;
    }

    public void clear()
    {
        super.clear();
        itsTransactionId = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsTransactionId = theStream.readLong();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"BeginTransaction_Result");
    }

    /**
     * \class BeginTransaction_Result
     *
     * \var transactionId  -
     */

    public long getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(long theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }

}