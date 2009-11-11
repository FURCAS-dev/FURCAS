//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SearchDocuments_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchDocuments_Request extends Request
{
    private ArrayList <IndexName>          itsIndexNames;
    private long                           itsCommitId;
    private long                           itsTransactionId;
    private ArrayList <QueryEntry>         itsQueryEntries;
    private ArrayList <RequestedAttribute> itsRequestedAttributes;
    private ArrayList <SortAttribute>      itsSortAttributes;
    private int                            itsFrom;
    private int                            itsTo;
    private int                            itsFlags; // bitmask

    public SearchDocuments_Request ()
    {
        itsIndexNames = new ArrayList <IndexName> ();
        itsCommitId = 0;
        itsTransactionId = 0;
        itsQueryEntries = new ArrayList <QueryEntry> ();
        itsRequestedAttributes = new ArrayList <RequestedAttribute> ();
        itsSortAttributes = new ArrayList <SortAttribute> ();
        itsFrom = 0;
        itsTo = 0;
        itsFlags = 0;
    }

    public void clear()
    {
        itsIndexNames.clear();
        itsCommitId = 0;
        itsTransactionId = 0;
        itsQueryEntries.clear();
        itsRequestedAttributes.clear();
        itsSortAttributes.clear();
        itsFrom = 0;
        itsTo = 0;
        itsFlags = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"SearchDocuments_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeVectorSize(itsIndexNames.size());
        for(i=0; i<itsIndexNames.size(); i++)
        {
            itsIndexNames.get(i).write(theStream);
        }
        theStream.writeLong(itsCommitId);
        theStream.writeLong(itsTransactionId);
        theStream.writeVectorSize(itsQueryEntries.size());
        for(i=0; i<itsQueryEntries.size(); i++)
        {
            itsQueryEntries.get(i).write(theStream);
        }
        theStream.writeVectorSize(itsRequestedAttributes.size());
        for(i=0; i<itsRequestedAttributes.size(); i++)
        {
            itsRequestedAttributes.get(i).write(theStream);
        }
        theStream.writeVectorSize(itsSortAttributes.size());
        for(i=0; i<itsSortAttributes.size(); i++)
        {
            itsSortAttributes.get(i).write(theStream);
        }
        theStream.writeInt(itsFrom);
        theStream.writeInt(itsTo);
        theStream.writeBitMask(itsFlags);
    }

    /**
     * \class SearchDocuments_Request
     *
     * \var indexNames           -
     * \var commitId             -
     * \var transactionId        -
     * \var queryEntries         -
     * \var requestedAttributes  -
     * \var sortAttributes       -
     * \var from                 first row
     * \var to                   last row
     * \var flags                -
     */

    public ArrayList <IndexName> getIndexNames() 
    {
        return itsIndexNames;
    }

    public void setIndexNames(ArrayList <IndexName> theIndexNames)
    {
        itsIndexNames = theIndexNames; 
    }

    public void addIndexName(IndexName theIndexNames)
    {
        itsIndexNames.add(theIndexNames); 
    }


    public long getCommitId() 
    {
        return itsCommitId;
    }

    public void setCommitId(long theCommitId)
    {
        itsCommitId = theCommitId; 
    }


    public long getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(long theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }


    public ArrayList <QueryEntry> getQueryEntries() 
    {
        return itsQueryEntries;
    }

    public void setQueryEntries(ArrayList <QueryEntry> theQueryEntries)
    {
        itsQueryEntries = theQueryEntries; 
    }

    public void addQueryEntry(QueryEntry theQueryEntries)
    {
        itsQueryEntries.add(theQueryEntries); 
    }


    public ArrayList <RequestedAttribute> getRequestedAttributes() 
    {
        return itsRequestedAttributes;
    }

    public void setRequestedAttributes(ArrayList <RequestedAttribute> theRequestedAttributes)
    {
        itsRequestedAttributes = theRequestedAttributes; 
    }

    public void addRequestedAttribute(RequestedAttribute theRequestedAttributes)
    {
        itsRequestedAttributes.add(theRequestedAttributes); 
    }


    public ArrayList <SortAttribute> getSortAttributes() 
    {
        return itsSortAttributes;
    }

    public void setSortAttributes(ArrayList <SortAttribute> theSortAttributes)
    {
        itsSortAttributes = theSortAttributes; 
    }

    public void addSortAttribute(SortAttribute theSortAttributes)
    {
        itsSortAttributes.add(theSortAttributes); 
    }


    public int getFrom() 
    {
        return itsFrom;
    }

    public void setFrom(int theFrom)
    {
        itsFrom = theFrom; 
    }


    public int getTo() 
    {
        return itsTo;
    }

    public void setTo(int theTo)
    {
        itsTo = theTo; 
    }


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }

}