//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ResultAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultAttribute
{
    private int                itsRef;
    private ArrayList <String> itsValues;

    public ResultAttribute ()
    {
        itsRef = 0;
        itsValues = new ArrayList <String> ();
    }

    public void clear()
    {
        itsRef = 0;
        itsValues.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsRef = theStream.readVectorSize();
        j = theStream.readVectorSize();
        itsValues.ensureCapacity(j);
        while(itsValues.size()<j)
            itsValues.add(new String());
        while(itsValues.size()>j)
            itsValues.remove(itsValues.size()-1);
        for(i=0; i<j; i++)
            itsValues.set(i,theStream.readString());
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ResultAttribute");
    }

    /**
     * \class ResultAttribute
     *
     * \var ref     points into ResultAttributeDefinition vector
     * \var values  -
     */

    public int getRef() 
    {
        return itsRef;
    }

    public void setRef(int theRef)
    {
        itsRef = theRef; 
    }


    public ArrayList <String> getValues() 
    {
        return itsValues;
    }

    public void setValues(ArrayList <String> theValues)
    {
        itsValues = theValues; 
    }

    public void addValue(String theValues)
    {
        itsValues.add(theValues); 
    }

}