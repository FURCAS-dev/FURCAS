//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SearchHierarchy_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchHierarchy_Result extends Result
{
    private ArrayList <ResultHierarchy> itsHierarchy;

    public SearchHierarchy_Result ()
    {
        itsHierarchy = new ArrayList <ResultHierarchy> ();
    }

    public void clear()
    {
        super.clear();
        itsHierarchy.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsHierarchy.ensureCapacity(j);
        while(itsHierarchy.size()<j)
            itsHierarchy.add(new ResultHierarchy());
        while(itsHierarchy.size()>j)
            itsHierarchy.remove(itsHierarchy.size()-1);
        for(i=0; i<j; i++)
            itsHierarchy.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"SearchHierarchy_Result");
    }

    /**
     * \class SearchHierarchy_Result
     *
     * \var hierarchy  -
     */

    public ArrayList <ResultHierarchy> getHierarchy() 
    {
        return itsHierarchy;
    }

    public void setHierarchy(ArrayList <ResultHierarchy> theHierarchy)
    {
        itsHierarchy = theHierarchy; 
    }

    public void addHierarchy(ResultHierarchy theHierarchy)
    {
        itsHierarchy.add(theHierarchy); 
    }

}