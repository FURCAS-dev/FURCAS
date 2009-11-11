//
// TrexClient - (c) 2008 SAP AG
//
// created from PythonCall_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PythonCall_Result extends Result
{
    private String itsResult;

    public PythonCall_Result ()
    {
        itsResult = "";
    }

    public void clear()
    {
        super.clear();
        itsResult = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsResult = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"PythonCall_Result");
    }

    /**
     * \class PythonCall_Result
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