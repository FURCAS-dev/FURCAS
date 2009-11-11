//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from PythonCall_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PythonCall_Request extends Request
{
    private int                itsMode; // bitmask
    private String             itsObjectName;
    private ArrayList <String> itsParameter;

    public PythonCall_Request ()
    {
        itsMode = 0;
        itsObjectName = "";
        itsParameter = new ArrayList <String> ();
    }

    public void clear()
    {
        itsMode = 0;
        itsObjectName = "";
        itsParameter.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"PythonCall_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeBitMask(itsMode);
        theStream.writeString(itsObjectName);
        theStream.writeVectorSize(itsParameter.size());
        for(i=0; i<itsParameter.size(); i++)
        {
            theStream.writeString(itsParameter.get(i));
        }
    }

    /**
     * \class PythonCall_Request
     *
     * \var mode        -
     * \var objectName  -
     * \var parameter   -
     */

    public int getMode() 
    {
        return itsMode;
    }

    public void setMode(int theMode)
    {
        itsMode = theMode; 
    }


    public String getObjectName() 
    {
        return itsObjectName;
    }

    public void setObjectName(String theObjectName)
    {
        itsObjectName = theObjectName; 
    }


    public ArrayList <String> getParameter() 
    {
        return itsParameter;
    }

    public void setParameter(ArrayList <String> theParameter)
    {
        itsParameter = theParameter; 
    }

    public void addParameter(String theParameter)
    {
        itsParameter.add(theParameter); 
    }

}