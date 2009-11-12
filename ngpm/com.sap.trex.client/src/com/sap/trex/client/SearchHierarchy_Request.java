//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SearchHierarchy_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchHierarchy_Request extends Request
{
    private IndexName itsIndexName;
    private long      itsCommitId;
    private long      itsTransactionId;
    private int       itsId;
    private int       itsType; // enum
    private int       itsFlags; // bitmask

    public SearchHierarchy_Request ()
    {
        itsIndexName = new IndexName ();
        itsCommitId = 0;
        itsTransactionId = 0;
        itsId = 0;
        itsType = com.sap.trex.client.HierarchyType.HIERARCHYTYPE_COUNTLEVELS;
        itsFlags = 0;
    }

    public void clear()
    {
        itsIndexName.clear();
        itsCommitId = 0;
        itsTransactionId = 0;
        itsId = 0;
        itsType = com.sap.trex.client.HierarchyType.HIERARCHYTYPE_COUNTLEVELS;
        itsFlags = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"SearchHierarchy_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        itsIndexName.write(theStream);
        theStream.writeLong(itsCommitId);
        theStream.writeLong(itsTransactionId);
        theStream.writeInt(itsId);
        theStream.writeEnum(itsType);
        theStream.writeBitMask(itsFlags);
    }

    /**
     * \class SearchHierarchy_Request
     *
     * \var indexName      -
     * \var commitId       -
     * \var transactionId  -
     * \var id             -
     * \var type           -
     * \var flags          -
     */

    public IndexName getIndexName() 
    {
        return itsIndexName;
    }

    public void setIndexName(IndexName theIndexName)
    {
        itsIndexName = theIndexName; 
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


    public int getId() 
    {
        return itsId;
    }

    public void setId(int theId)
    {
        itsId = theId; 
    }


    public int getType() 
    {
        return itsType;
    }

    public void setType(int theType)
    {
        itsType = theType; 
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