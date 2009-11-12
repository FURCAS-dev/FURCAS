//
// TrexClient - (c) 2008 SAP AG
//
// created from ApiPython_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sap.trex.client.*;

public class ApiPython_Request extends Request
{
    private String             itsFunction;
    private ArrayList <String> itsParameters;

    public ApiPython_Request ()
    {
        itsFunction = "";
        itsParameters = new ArrayList <String> ();
    }

    public void clear()
    {
        itsFunction="";
        itsParameters.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsFunction);
        theStream.writeVectorSize(itsParameters.size());
        for(i=0; i<itsParameters.size(); i++)
        {
            theStream.writeString(itsParameters.get(i));
        }
    }

    /**
     * \class ApiPython_Request
     *
     * \var function    -
     * \var parameters  -
     */

    public String getFunction() 
    {
        return itsFunction;
    }

    public void setFunction(String theFunction)
    {
        itsFunction = theFunction; 
    }


    public ArrayList <String> getParameters() 
    {
        return itsParameters;
    }

    public void setParameters(ArrayList <String> theParameters)
    {
        itsParameters = theParameters; 
    }

    public void addParameter(String theParameters)
    {
        itsParameters.add(theParameters); 
    }

}