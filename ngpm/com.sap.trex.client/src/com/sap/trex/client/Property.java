//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from Property.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Property
{
    private String itsName;
    private String itsValue;

    public Property ()
    {
        itsName = "";
        itsValue = "";
    }

    public void clear()
    {
        itsName = "";
        itsValue = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"Property");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeString(itsValue);
    }

    /**
     * \class Property
     *
     * \var name   -
     * \var value  -
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

}