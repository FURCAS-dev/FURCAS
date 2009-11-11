//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from JoinPhysicalIndex.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoinPhysicalIndex
{
    private String itsIndexId;
    private String itsIndexLang;
    private int    itsIndexType; // enum

    public JoinPhysicalIndex ()
    {
        itsIndexId = "";
        itsIndexLang = "";
        itsIndexType = com.sap.trex.client.JoinIndexType.JOININDEXTYPE_NONE;
    }

    public void clear()
    {
        itsIndexId = "";
        itsIndexLang = "";
        itsIndexType = com.sap.trex.client.JoinIndexType.JOININDEXTYPE_NONE;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsIndexId = theStream.readString();
        itsIndexLang = theStream.readString();
        itsIndexType = theStream.readEnum();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"JoinPhysicalIndex");
    }

    /**
     * \class JoinPhysicalIndex
     *
     * \var indexId    -
     * \var indexLang  -
     * \var indexType  -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }


    public String getIndexLang() 
    {
        return itsIndexLang;
    }

    public void setIndexLang(String theIndexLang)
    {
        itsIndexLang = theIndexLang; 
    }


    public int getIndexType() 
    {
        return itsIndexType;
    }

    public void setIndexType(int theIndexType)
    {
        itsIndexType = theIndexType; 
    }

}