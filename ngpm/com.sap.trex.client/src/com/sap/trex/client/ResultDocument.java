//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ResultDocument.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultDocument
{
    private String                      itsIndexId;
    private String                      itsLanguage;
    private String                      itsKey;
    private ArrayList <ResultAttribute> itsAttributes;
    private String                      itsContent;
    private float                       itsRank;

    public ResultDocument ()
    {
        itsIndexId = "";
        itsLanguage = "";
        itsKey = "";
        itsAttributes = new ArrayList <ResultAttribute> ();
        itsContent = "";
        itsRank = 0.0f;
    }

    public void clear()
    {
        itsIndexId = "";
        itsLanguage = "";
        itsKey = "";
        itsAttributes.clear();
        itsContent = "";
        itsRank = 0.0f;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsIndexId = theStream.readString();
        itsLanguage = theStream.readString();
        itsKey = theStream.readString();
        j = theStream.readVectorSize();
        itsAttributes.ensureCapacity(j);
        while(itsAttributes.size()<j)
            itsAttributes.add(new ResultAttribute());
        while(itsAttributes.size()>j)
            itsAttributes.remove(itsAttributes.size()-1);
        for(i=0; i<j; i++)
            itsAttributes.get(i).read(theStream);
        itsContent = theStream.readString();
        itsRank = theStream.readFloat();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ResultDocument");
    }

    /**
     * \class ResultDocument
     *
     * \var indexId     -
     * \var language    -
     * \var key         -
     * \var attributes  -
     * \var content     -
     * \var rank        -
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


    public String getKey() 
    {
        return itsKey;
    }

    public void setKey(String theKey)
    {
        itsKey = theKey; 
    }


    public ArrayList <ResultAttribute> getAttributes() 
    {
        return itsAttributes;
    }

    public void setAttributes(ArrayList <ResultAttribute> theAttributes)
    {
        itsAttributes = theAttributes; 
    }

    public void addAttribute(ResultAttribute theAttributes)
    {
        itsAttributes.add(theAttributes); 
    }


    public String getContent() 
    {
        return itsContent;
    }

    public void setContent(String theContent)
    {
        itsContent = theContent; 
    }


    public float getRank() 
    {
        return itsRank;
    }

    public void setRank(float theRank)
    {
        itsRank = theRank; 
    }

}