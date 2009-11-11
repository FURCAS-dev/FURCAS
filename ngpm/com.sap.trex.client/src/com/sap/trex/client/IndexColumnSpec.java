//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexColumnSpec.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexColumnSpec
{
    private String itsName;
    private int    itsType; // enum

    public IndexColumnSpec ()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public IndexColumnSpec(String theName, int theType)
    {
        itsName = theName;
        itsType = theType;
    }

    public void clear()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexColumnSpec");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeEnum(itsType);
    }

    /**
     * \class IndexColumnSpec
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