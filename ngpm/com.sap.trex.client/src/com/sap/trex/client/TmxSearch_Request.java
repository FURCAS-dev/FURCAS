//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from TmxSearch_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TmxSearch_Request extends Request
{
    private String               itsIndexId;
    private long                 itsCommitId;
    private long                 itsTransactionId;
    private int                  itsType; // enum
    private ArrayList <Property> itsProperties;
    private String               itsQuery;

    public TmxSearch_Request ()
    {
        itsIndexId = "";
        itsCommitId = 0;
        itsTransactionId = 0;
        itsType = com.sap.trex.client.TmxRequestType.TMXREQUESTTYPE_UNDEFINED;
        itsProperties = new ArrayList <Property> ();
        itsQuery = "";
    }

    public void clear()
    {
        itsIndexId = "";
        itsCommitId = 0;
        itsTransactionId = 0;
        itsType = com.sap.trex.client.TmxRequestType.TMXREQUESTTYPE_UNDEFINED;
        itsProperties.clear();
        itsQuery = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"TmxSearch_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsIndexId);
        theStream.writeLong(itsCommitId);
        theStream.writeLong(itsTransactionId);
        theStream.writeEnum(itsType);
        theStream.writeVectorSize(itsProperties.size());
        for(i=0; i<itsProperties.size(); i++)
        {
            itsProperties.get(i).write(theStream);
        }
        theStream.writeString(itsQuery);
    }

    /**
     * \class TmxSearch_Request
     *
     * \var indexId        -
     * \var commitId       -
     * \var transactionId  -
     * \var type           -
     * \var properties     -
     * \var query          -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
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


    public int getType() 
    {
        return itsType;
    }

    public void setType(int theType)
    {
        itsType = theType; 
    }


    public ArrayList <Property> getProperties() 
    {
        return itsProperties;
    }

    public void setProperties(ArrayList <Property> theProperties)
    {
        itsProperties = theProperties; 
    }

    public void addProperty(Property theProperties)
    {
        itsProperties.add(theProperties); 
    }


    public String getQuery() 
    {
        return itsQuery;
    }

    public void setQuery(String theQuery)
    {
        itsQuery = theQuery; 
    }

}