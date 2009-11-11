//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ErrorDocument.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErrorDocument
{
    private String itsKey;
    private int    itsAction; // enum
    private int    itsErrorCode;

    public ErrorDocument ()
    {
        itsKey = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsErrorCode = 0;
    }

    public void clear()
    {
        itsKey = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsErrorCode = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsKey = theStream.readString();
        itsAction = theStream.readEnum();
        itsErrorCode = theStream.readInt();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ErrorDocument");
    }

    /**
     * \class ErrorDocument
     *
     * \var key        -
     * \var action     -
     * \var errorCode  -
     */

    public String getKey() 
    {
        return itsKey;
    }

    public void setKey(String theKey)
    {
        itsKey = theKey; 
    }


    public int getAction() 
    {
        return itsAction;
    }

    public void setAction(int theAction)
    {
        itsAction = theAction; 
    }


    public int getErrorCode() 
    {
        return itsErrorCode;
    }

    public void setErrorCode(int theErrorCode)
    {
        itsErrorCode = theErrorCode; 
    }

}