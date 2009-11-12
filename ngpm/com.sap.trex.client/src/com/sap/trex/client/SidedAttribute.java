//
// TrexClient - (c) 2008 SAP AG
//
// created from SidedAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SidedAttribute
{
    private String itsUserAttribute;
    private String itsSidAttribute;

    public SidedAttribute ()
    {
        itsUserAttribute = "";
        itsSidAttribute = "";
    }

    public void clear()
    {
        itsUserAttribute = "";
        itsSidAttribute = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsUserAttribute = theStream.readString();
        itsSidAttribute = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"SidedAttribute");
    }

    /**
     * \class SidedAttribute
     *
     * \var userAttribute  -
     * \var sidAttribute   -
     */

    public String getUserAttribute() 
    {
        return itsUserAttribute;
    }

    public void setUserAttribute(String theUserAttribute)
    {
        itsUserAttribute = theUserAttribute; 
    }


    public String getSidAttribute() 
    {
        return itsSidAttribute;
    }

    public void setSidAttribute(String theSidAttribute)
    {
        itsSidAttribute = theSidAttribute; 
    }

}