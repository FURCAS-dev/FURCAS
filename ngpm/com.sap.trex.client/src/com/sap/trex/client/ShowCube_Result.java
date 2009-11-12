//
// TrexClient - (c) 2008 SAP AG
//
// created from ShowCube_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowCube_Result extends Result
{
    private String itsSchema;

    public ShowCube_Result ()
    {
        itsSchema = "";
    }

    public void clear()
    {
        super.clear();
        itsSchema = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsSchema = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ShowCube_Result");
    }

    /**
     * \class ShowCube_Result
     *
     * \var schema  -
     */

    public String getSchema() 
    {
        return itsSchema;
    }

    public void setSchema(String theSchema)
    {
        itsSchema = theSchema; 
    }

}