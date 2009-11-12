//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SearchDocuments_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchDocuments_Result extends Result
{
    private long                                  itsNoOfAllHits;
    private long                                  itsIndexSize;
    private long                                  itsKernelTime;
    private ArrayList <ResultAttributeDefinition> itsAttributes;
    private ArrayList <ResultDocument>            itsDocuments;

    public SearchDocuments_Result ()
    {
        itsNoOfAllHits = 0;
        itsIndexSize = 0;
        itsKernelTime = 0;
        itsAttributes = new ArrayList <ResultAttributeDefinition> ();
        itsDocuments = new ArrayList <ResultDocument> ();
    }

    public void clear()
    {
        super.clear();
        itsNoOfAllHits = 0;
        itsIndexSize = 0;
        itsKernelTime = 0;
        itsAttributes.clear();
        itsDocuments.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsNoOfAllHits = theStream.readLong();
        itsIndexSize = theStream.readLong();
        itsKernelTime = theStream.readLong();
        j = theStream.readVectorSize();
        itsAttributes.ensureCapacity(j);
        while(itsAttributes.size()<j)
            itsAttributes.add(new ResultAttributeDefinition());
        while(itsAttributes.size()>j)
            itsAttributes.remove(itsAttributes.size()-1);
        for(i=0; i<j; i++)
            itsAttributes.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsDocuments.ensureCapacity(j);
        while(itsDocuments.size()<j)
            itsDocuments.add(new ResultDocument());
        while(itsDocuments.size()>j)
            itsDocuments.remove(itsDocuments.size()-1);
        for(i=0; i<j; i++)
            itsDocuments.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"SearchDocuments_Result");
    }

    /**
     * \class SearchDocuments_Result
     *
     * \var noOfAllHits  same as countDocuments() if there was no from/to
     *                   restriction.
     *                   could be exact or estimation or missing.
     * \var indexSize    -
     * \var kernelTime   micro seconds
     * \var attributes   -
     * \var documents    -
     */

    public long getNoOfAllHits() 
    {
        return itsNoOfAllHits;
    }

    public void setNoOfAllHits(long theNoOfAllHits)
    {
        itsNoOfAllHits = theNoOfAllHits; 
    }


    public long getIndexSize() 
    {
        return itsIndexSize;
    }

    public void setIndexSize(long theIndexSize)
    {
        itsIndexSize = theIndexSize; 
    }


    public long getKernelTime() 
    {
        return itsKernelTime;
    }

    public void setKernelTime(long theKernelTime)
    {
        itsKernelTime = theKernelTime; 
    }


    public ArrayList <ResultAttributeDefinition> getAttributes() 
    {
        return itsAttributes;
    }

    public void setAttributes(ArrayList <ResultAttributeDefinition> theAttributes)
    {
        itsAttributes = theAttributes; 
    }

    public void addAttribute(ResultAttributeDefinition theAttributes)
    {
        itsAttributes.add(theAttributes); 
    }


    public ArrayList <ResultDocument> getDocuments() 
    {
        return itsDocuments;
    }

    public void setDocuments(ArrayList <ResultDocument> theDocuments)
    {
        itsDocuments = theDocuments; 
    }

    public void addDocument(ResultDocument theDocuments)
    {
        itsDocuments.add(theDocuments); 
    }

}