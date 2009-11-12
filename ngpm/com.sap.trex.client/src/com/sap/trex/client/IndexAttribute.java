//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexAttribute
{
    private String itsName;
    private String itsValue;
    private int    itsType; // enum

    public IndexAttribute ()
    {
        itsName = "";
        itsValue = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public IndexAttribute(String theName, String theValue, int theType)
    {
        itsName = theName;
        itsValue = theValue;
        itsType = theType;
    }

    public void clear()
    {
        itsName = "";
        itsValue = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexAttribute");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeString(itsValue);
        theStream.writeEnum(itsType);
    }

    /**
     * \class IndexAttribute
     *
     * \var name   -
     * \var value  -
     * \var type   -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public String getValue() 
    {
        return itsValue;
    }

    public void setValue(String theValue)
    {
        itsValue = theValue; 
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