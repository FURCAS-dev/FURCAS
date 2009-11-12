//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from CreateIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateIndex_Request extends Request
{
    private IndexName                       itsIndexName;
    private String                          itsDescription;
    private int                             itsFlags; // bitmask
    private ArrayList <AttributeDefinition> itsAttributes;
    private ArrayList <String>              itsKeyAttributes;

    public CreateIndex_Request ()
    {
        itsIndexName = new IndexName ();
        itsDescription = "";
        itsFlags = 0;
        itsAttributes = new ArrayList <AttributeDefinition> ();
        itsKeyAttributes = new ArrayList <String> ();
    }

    public void clear()
    {
        itsIndexName.clear();
        itsDescription = "";
        itsFlags = 0;
        itsAttributes.clear();
        itsKeyAttributes.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"CreateIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsIndexName.write(theStream);
        theStream.writeString(itsDescription);
        theStream.writeBitMask(itsFlags);
        theStream.writeVectorSize(itsAttributes.size());
        for(i=0; i<itsAttributes.size(); i++)
        {
            itsAttributes.get(i).write(theStream);
        }
        theStream.writeVectorSize(itsKeyAttributes.size());
        for(i=0; i<itsKeyAttributes.size(); i++)
        {
            theStream.writeString(itsKeyAttributes.get(i));
        }
    }

    /**
     * \class CreateIndex_Request
     *
     * \var indexName      -
     * \var description    -
     * \var flags          -
     * \var attributes     -
     * \var keyAttributes  -
     */

    public IndexName getIndexName() 
    {
        return itsIndexName;
    }

    public void setIndexName(IndexName theIndexName)
    {
        itsIndexName = theIndexName; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }


    public ArrayList <AttributeDefinition> getAttributes() 
    {
        return itsAttributes;
    }

    public void setAttributes(ArrayList <AttributeDefinition> theAttributes)
    {
        itsAttributes = theAttributes; 
    }

    public void addAttribute(AttributeDefinition theAttributes)
    {
        itsAttributes.add(theAttributes); 
    }


    public ArrayList <String> getKeyAttributes() 
    {
        return itsKeyAttributes;
    }

    public void setKeyAttributes(ArrayList <String> theKeyAttributes)
    {
        itsKeyAttributes = theKeyAttributes; 
    }

    public void addKeyAttribute(String theKeyAttributes)
    {
        itsKeyAttributes.add(theKeyAttributes); 
    }

}