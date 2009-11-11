//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SearchTable_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchTable_Request extends Request
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
    private ArrayList <KeyFigure>          itsKeyFigures;
    private String                         itsScriptName;
    private String                         itsScriptContent;
    private int                            itsScriptFlags;
    private ArrayList <String>             itsScriptParameters;

    public SearchTable_Request ()
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
        itsKeyFigures = new ArrayList <KeyFigure> ();
        itsScriptName = "";
        itsScriptContent = "";
        itsScriptFlags = 0;
        itsScriptParameters = new ArrayList <String> ();
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
        itsKeyFigures.clear();
        itsScriptName = "";
        itsScriptContent = "";
        itsScriptFlags = 0;
        itsScriptParameters.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"SearchTable_Request");
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
        theStream.writeVectorSize(itsKeyFigures.size());
        for(i=0; i<itsKeyFigures.size(); i++)
        {
            itsKeyFigures.get(i).write(theStream);
        }
        theStream.writeString(itsScriptName);
        theStream.writeString(itsScriptContent);
        theStream.writeInt(itsScriptFlags);
        theStream.writeVectorSize(itsScriptParameters.size());
        for(i=0; i<itsScriptParameters.size(); i++)
        {
            theStream.writeString(itsScriptParameters.get(i));
        }
    }

    /**
     * \class SearchTable_Request
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
     * \var keyFigures           -
     * \var scriptName           -
     * \var scriptContent        -
     * \var scriptFlags          -
     * \var scriptParameters     -
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


    public ArrayList <KeyFigure> getKeyFigures() 
    {
        return itsKeyFigures;
    }

    public void setKeyFigures(ArrayList <KeyFigure> theKeyFigures)
    {
        itsKeyFigures = theKeyFigures; 
    }

    public void addKeyFigure(KeyFigure theKeyFigures)
    {
        itsKeyFigures.add(theKeyFigures); 
    }


    public String getScriptName() 
    {
        return itsScriptName;
    }

    public void setScriptName(String theScriptName)
    {
        itsScriptName = theScriptName; 
    }


    public String getScriptContent() 
    {
        return itsScriptContent;
    }

    public void setScriptContent(String theScriptContent)
    {
        itsScriptContent = theScriptContent; 
    }


    public int getScriptFlags() 
    {
        return itsScriptFlags;
    }

    public void setScriptFlags(int theScriptFlags)
    {
        itsScriptFlags = theScriptFlags; 
    }


    public ArrayList <String> getScriptParameters() 
    {
        return itsScriptParameters;
    }

    public void setScriptParameters(ArrayList <String> theScriptParameters)
    {
        itsScriptParameters = theScriptParameters; 
    }

    public void addScriptParameter(String theScriptParameters)
    {
        itsScriptParameters.add(theScriptParameters); 
    }

}