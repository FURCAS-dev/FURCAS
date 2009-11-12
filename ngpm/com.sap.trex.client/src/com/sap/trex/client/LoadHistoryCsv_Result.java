//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from LoadHistoryCsv_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadHistoryCsv_Result extends Result
{
    private ArrayList <String> itsChunks;

    public LoadHistoryCsv_Result ()
    {
        itsChunks = new ArrayList <String> ();
    }

    public void clear()
    {
        super.clear();
        itsChunks.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsChunks.ensureCapacity(j);
        while(itsChunks.size()<j)
            itsChunks.add(new String());
        while(itsChunks.size()>j)
            itsChunks.remove(itsChunks.size()-1);
        for(i=0; i<j; i++)
            itsChunks.set(i,theStream.readString());
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"LoadHistoryCsv_Result");
    }

    /**
     * \class LoadHistoryCsv_Result
     *
     * \var chunks  -
     */

    public ArrayList <String> getChunks() 
    {
        return itsChunks;
    }

    public void setChunks(ArrayList <String> theChunks)
    {
        itsChunks = theChunks; 
    }

    public void addChunk(String theChunks)
    {
        itsChunks.add(theChunks); 
    }

}