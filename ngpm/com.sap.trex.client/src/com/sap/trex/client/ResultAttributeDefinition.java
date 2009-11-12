//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ResultAttributeDefinition.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultAttributeDefinition
{
    private String itsName;
    private int    itsType; // enum

    public ResultAttributeDefinition ()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public void clear()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsName = theStream.readString();
        itsType = theStream.readEnum();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ResultAttributeDefinition");
    }

    /**
     * \class ResultAttributeDefinition
     *
     * \var name  -
     * \var type  -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public int getType() 
    {
        return itsType;
    }

    public void setType(int theType)
    {
        itsType = theType; 
    }

}