//
// TrexClient - (c) 2008 SAP AG
//
// created from IndexDocuments_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexDocuments_Request extends Request
{
    private String                    itsIndexId;
    private boolean                   itsAutoOptimize;
    private long                      itsTransactionId;
    private ArrayList <IndexDocument> itsDocuments;

    public IndexDocuments_Request ()
    {
        itsIndexId = "";
        itsAutoOptimize = false;
        itsTransactionId = 0;
        itsDocuments = new ArrayList <IndexDocument> ();
    }

    public void clear()
    {
        itsIndexId = "";
        itsAutoOptimize = false;
        itsTransactionId = 0;
        itsDocuments.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexDocuments_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsIndexId);
        theStream.writeBoolean(itsAutoOptimize);
        theStream.writeLong(itsTransactionId);
        theStream.writeVectorSize(itsDocuments.size());
        for(i=0; i<itsDocuments.size(); i++)
        {
            itsDocuments.get(i).write(theStream);
        }
    }

    /**
     * \class IndexDocuments_Request
     *
     * \var indexId        -
     * \var autoOptimize   -
     * \var transactionId  -
     * \var documents      -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }


    public boolean getAutoOptimize() 
    {
        return itsAutoOptimize;
    }

    public void setAutoOptimize(boolean theAutoOptimize)
    {
        itsAutoOptimize = theAutoOptimize; 
    }


    public long getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(long theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }


    public ArrayList <IndexDocument> getDocuments() 
    {
        return itsDocuments;
    }

    public void setDocuments(ArrayList <IndexDocument> theDocuments)
    {
        itsDocuments = theDocuments; 
    }

    public void addDocument(IndexDocument theDocuments)
    {
        itsDocuments.add(theDocuments); 
    }

}