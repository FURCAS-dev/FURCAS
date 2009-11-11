//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ListIndex_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListIndex_Result extends Result
{
    private ArrayList <IndexInfo> itsIndexes;

    public ListIndex_Result ()
    {
        itsIndexes = new ArrayList <IndexInfo> ();
    }

    public void clear()
    {
        super.clear();
        itsIndexes.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsIndexes.ensureCapacity(j);
        while(itsIndexes.size()<j)
            itsIndexes.add(new IndexInfo());
        while(itsIndexes.size()>j)
            itsIndexes.remove(itsIndexes.size()-1);
        for(i=0; i<j; i++)
            itsIndexes.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ListIndex_Result");
    }

    /**
     * \class ListIndex_Result
     *
     * \var indexes  -
     */

    public ArrayList <IndexInfo> getIndexes() 
    {
        return itsIndexes;
    }

    public void setIndexes(ArrayList <IndexInfo> theIndexes)
    {
        itsIndexes = theIndexes; 
    }

    public void addIndexe(IndexInfo theIndexes)
    {
        itsIndexes.add(theIndexes); 
    }

}