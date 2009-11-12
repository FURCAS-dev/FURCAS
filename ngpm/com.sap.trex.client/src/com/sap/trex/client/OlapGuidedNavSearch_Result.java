//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from OlapGuidedNavSearch_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlapGuidedNavSearch_Result extends Result
{
    private long                                  itsKernelTime;
    private ArrayList <ResultAttributeDefinition> itsAttributes;
    private ResultTable                           itsTable;

    public OlapGuidedNavSearch_Result ()
    {
        itsKernelTime = 0;
        itsAttributes = new ArrayList <ResultAttributeDefinition> ();
        itsTable = new ResultTable ();
    }

    public void clear()
    {
        super.clear();
        itsKernelTime = 0;
        itsAttributes.clear();
        itsTable.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsKernelTime = theStream.readLong();
        j = theStream.readVectorSize();
        itsAttributes.ensureCapacity(j);
        while(itsAttributes.size()<j)
            itsAttributes.add(new ResultAttributeDefinition());
        while(itsAttributes.size()>j)
            itsAttributes.remove(itsAttributes.size()-1);
        for(i=0; i<j; i++)
            itsAttributes.get(i).read(theStream);
        itsTable.read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"OlapGuidedNavSearch_Result");
    }

    /**
     * \class OlapGuidedNavSearch_Result
     *
     * \var kernelTime  -
     * \var attributes  -
     * \var table       -
     */

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


    public ResultTable getTable() 
    {
        return itsTable;
    }

    public void setTable(ResultTable theTable)
    {
        itsTable = theTable; 
    }

}