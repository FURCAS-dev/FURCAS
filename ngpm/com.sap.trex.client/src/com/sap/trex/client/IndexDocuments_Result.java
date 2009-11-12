//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexDocuments_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexDocuments_Result extends Result
{
    private ArrayList <ErrorDocument> itsErrorDocuments;

    public IndexDocuments_Result ()
    {
        itsErrorDocuments = new ArrayList <ErrorDocument> ();
    }

    public void clear()
    {
        super.clear();
        itsErrorDocuments.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsErrorDocuments.ensureCapacity(j);
        while(itsErrorDocuments.size()<j)
            itsErrorDocuments.add(new ErrorDocument());
        while(itsErrorDocuments.size()>j)
            itsErrorDocuments.remove(itsErrorDocuments.size()-1);
        for(i=0; i<j; i++)
            itsErrorDocuments.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"IndexDocuments_Result");
    }

    /**
     * \class IndexDocuments_Result
     *
     * \var errorDocuments  -
     */

    public ArrayList <ErrorDocument> getErrorDocuments() 
    {
        return itsErrorDocuments;
    }

    public void setErrorDocuments(ArrayList <ErrorDocument> theErrorDocuments)
    {
        itsErrorDocuments = theErrorDocuments; 
    }

    public void addErrorDocument(ErrorDocument theErrorDocuments)
    {
        itsErrorDocuments.add(theErrorDocuments); 
    }

}