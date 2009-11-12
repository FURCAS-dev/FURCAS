//
// TrexClient - (c) 2008 SAP AG
//
// created from CreateCube_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCube_Result extends Result
{
    private String itsResultXml;

    public CreateCube_Result ()
    {
        itsResultXml = "";
    }

    public void clear()
    {
        super.clear();
        itsResultXml = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsResultXml = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"CreateCube_Result");
    }

    /**
     * \class CreateCube_Result
     *
     * \var resultXml  -
     */

    public String getResultXml() 
    {
        return itsResultXml;
    }

    public void setResultXml(String theResultXml)
    {
        itsResultXml = theResultXml; 
    }

}