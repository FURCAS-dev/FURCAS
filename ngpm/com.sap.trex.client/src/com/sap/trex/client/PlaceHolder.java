//
// TrexClient - (c) 2008 SAP AG
//
// created from PlaceHolder.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaceHolder
{
    private String itsKey;
    private String itsValue;

    public PlaceHolder ()
    {
        itsKey = "";
        itsValue = "";
    }

    public PlaceHolder(String theKey)
    {
        itsKey = theKey;
        itsValue = "";
    }

    public PlaceHolder(String theKey, String theValue)
    {
        itsKey = theKey;
        itsValue = theValue;
    }

    public void clear()
    {
        itsKey = "";
        itsValue = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"PlaceHolder");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsKey);
        theStream.writeString(itsValue);
    }

    /**
     * \class PlaceHolder
     *
     * \var key    -
     * \var value  -
     */

    public String getKey() 
    {
        return itsKey;
    }

    public void setKey(String theKey)
    {
        itsKey = theKey; 
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