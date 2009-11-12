//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexAliasOperation.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexAliasOperation
{
    private String itsOrigin;
    private String itsAlias;
    private int    itsOperation; // enum

    public IndexAliasOperation ()
    {
        itsOrigin = "";
        itsAlias = "";
        itsOperation = com.sap.trex.client.AliasOperation.ALIASOPERATION_NONE;
    }

    public void clear()
    {
        itsOrigin = "";
        itsAlias = "";
        itsOperation = com.sap.trex.client.AliasOperation.ALIASOPERATION_NONE;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexAliasOperation");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsOrigin);
        theStream.writeString(itsAlias);
        theStream.writeEnum(itsOperation);
    }

    /**
     * \class IndexAliasOperation
     *
     * \var origin     -
     * \var alias      -
     * \var operation  -
     */

    public String getOrigin() 
    {
        return itsOrigin;
    }

    public void setOrigin(String theOrigin)
    {
        itsOrigin = theOrigin; 
    }


    public String getAlias() 
    {
        return itsAlias;
    }

    public void setAlias(String theAlias)
    {
        itsAlias = theAlias; 
    }


    public int getOperation() 
    {
        return itsOperation;
    }

    public void setOperation(int theOperation)
    {
        itsOperation = theOperation; 
    }

}