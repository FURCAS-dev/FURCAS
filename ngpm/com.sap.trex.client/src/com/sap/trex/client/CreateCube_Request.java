//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from CreateCube_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCube_Request extends Request
{
    private String itsSchema;
    private int    itsType; // enum

    public CreateCube_Request ()
    {
        itsSchema = "";
        itsType = com.sap.trex.client.CreateCubeType.CREATECUBETYPE_STANDARD;
    }

    public void clear()
    {
        itsSchema = "";
        itsType = com.sap.trex.client.CreateCubeType.CREATECUBETYPE_STANDARD;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"CreateCube_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsSchema);
        theStream.writeEnum(itsType);
    }

    /**
     * \class CreateCube_Request
     *
     * \var schema  -
     * \var type    -
     */

    public String getSchema() 
    {
        return itsSchema;
    }

    public void setSchema(String theSchema)
    {
        itsSchema = theSchema; 
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