//
// TrexClient - (c) 2008 SAP AG
//
// created from VersionTest.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sap.trex.client.*;

public class VersionTest
{
    private String itsA;
    private String itsB;
    private String itsC;
    private float  itsD;

    public VersionTest ()
    {
        itsA = "";
        itsB = "";
        itsC = "";
    }

    public void clear()
    {
        itsA="";
        itsB="";
        itsC="";
        itsD=0.0f;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsA = theStream.readString();
        itsB = theStream.readString();
        itsC = theStream.readString();
        itsD = theStream.readFloat();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsA);
        theStream.writeString(itsB);
        theStream.writeString(itsC);
        theStream.writeFloat(itsD);
    }

    /**
     * \class VersionTest
     *
     * \var a  -
     * \var b  -
     * \var c  -
     * \var d  -
     */

    public String getA() 
    {
        return itsA;
    }

    public void setA(String theA)
    {
        itsA = theA; 
    }


    public String getB() 
    {
        return itsB;
    }

    public void setB(String theB)
    {
        itsB = theB; 
    }


    public String getC() 
    {
        return itsC;
    }

    public void setC(String theC)
    {
        itsC = theC; 
    }


    public float getD() 
    {
        return itsD;
    }

    public void setD(float theD)
    {
        itsD = theD; 
    }

}
