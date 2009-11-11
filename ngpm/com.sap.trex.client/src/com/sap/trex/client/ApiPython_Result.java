//
// TrexClient - (c) 2008 SAP AG
//
// created from ApiPython_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sap.trex.client.*;

public class ApiPython_Result extends Result
{
    private String itsResult;

    public ApiPython_Result ()
    {
        itsResult = "";
    }

    public void clear()
    {
        super.clear();
        itsResult="";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsResult = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        // unused
    }

    /**
     * \class ApiPython_Result
     *
     * \var result  -
     */

    public String getResult() 
    {
        return itsResult;
    }

    public void setResult(String theResult)
    {
        itsResult = theResult; 
    }

}