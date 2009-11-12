//
// TrexClient - (c) 2008 SAP AG
//
// created from IndexName.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexName
{
    private String itsIndexId;
    private String itsLanguage;

    public IndexName ()
    {
        itsIndexId = "";
        itsLanguage = "";
    }

    public IndexName(String theIndexId)
    {
        itsIndexId = theIndexId;
        itsLanguage = "";
    }

    public IndexName(String theIndexId, String theLanguage)
    {
        itsIndexId = theIndexId;
        itsLanguage = theLanguage;
    }

    public void clear()
    {
        itsIndexId = "";
        itsLanguage = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexName");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsIndexId);
        theStream.writeString(itsLanguage);
    }

    /**
     * \class IndexName
     *
     * \var indexId   -
     * \var language  -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }


    public String getLanguage() 
    {
        return itsLanguage;
    }

    public void setLanguage(String theLanguage)
    {
        itsLanguage = theLanguage; 
    }

}