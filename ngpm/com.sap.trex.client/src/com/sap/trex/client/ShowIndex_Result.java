//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ShowIndex_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowIndex_Result extends Result
{
    private String                          itsDescription;
    private String                          itsDateCreated;
    private String                          itsDateModified;
    private boolean                         itsUseQueueServer;
    private ArrayList <AttributeDefinition> itsAttributes;
    private ArrayList <String>              itsKeyAttributes;
    private ArrayList <SidedAttribute>      itsSidedAttributes;

    public ShowIndex_Result ()
    {
        itsDescription = "";
        itsDateCreated = "";
        itsDateModified = "";
        itsUseQueueServer = false;
        itsAttributes = new ArrayList <AttributeDefinition> ();
        itsKeyAttributes = new ArrayList <String> ();
        itsSidedAttributes = new ArrayList <SidedAttribute> ();
    }

    public void clear()
    {
        super.clear();
        itsDescription = "";
        itsDateCreated = "";
        itsDateModified = "";
        itsUseQueueServer = false;
        itsAttributes.clear();
        itsKeyAttributes.clear();
        itsSidedAttributes.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsDescription = theStream.readString();
        itsDateCreated = theStream.readString();
        itsDateModified = theStream.readString();
        itsUseQueueServer = theStream.readBoolean();
        j = theStream.readVectorSize();
        itsAttributes.ensureCapacity(j);
        while(itsAttributes.size()<j)
            itsAttributes.add(new AttributeDefinition());
        while(itsAttributes.size()>j)
            itsAttributes.remove(itsAttributes.size()-1);
        for(i=0; i<j; i++)
            itsAttributes.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsKeyAttributes.ensureCapacity(j);
        while(itsKeyAttributes.size()<j)
            itsKeyAttributes.add(new String());
        while(itsKeyAttributes.size()>j)
            itsKeyAttributes.remove(itsKeyAttributes.size()-1);
        for(i=0; i<j; i++)
            itsKeyAttributes.set(i,theStream.readString());
        j = theStream.readVectorSize();
        itsSidedAttributes.ensureCapacity(j);
        while(itsSidedAttributes.size()<j)
            itsSidedAttributes.add(new SidedAttribute());
        while(itsSidedAttributes.size()>j)
            itsSidedAttributes.remove(itsSidedAttributes.size()-1);
        for(i=0; i<j; i++)
            itsSidedAttributes.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ShowIndex_Result");
    }

    /**
     * \class ShowIndex_Result
     *
     * \var description      -
     * \var dateCreated      -
     * \var dateModified     -
     * \var useQueueServer   -
     * \var attributes       -
     * \var keyAttributes    -
     * \var sidedAttributes  -
     */

    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public String getDateCreated() 
    {
        return itsDateCreated;
    }

    public void setDateCreated(String theDateCreated)
    {
        itsDateCreated = theDateCreated; 
    }


    public String getDateModified() 
    {
        return itsDateModified;
    }

    public void setDateModified(String theDateModified)
    {
        itsDateModified = theDateModified; 
    }


    public boolean getUseQueueServer() 
    {
        return itsUseQueueServer;
    }

    public void setUseQueueServer(boolean theUseQueueServer)
    {
        itsUseQueueServer = theUseQueueServer; 
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


    public ArrayList <SidedAttribute> getSidedAttributes() 
    {
        return itsSidedAttributes;
    }

    public void setSidedAttributes(ArrayList <SidedAttribute> theSidedAttributes)
    {
        itsSidedAttributes = theSidedAttributes; 
    }

    public void addSidedAttribute(SidedAttribute theSidedAttributes)
    {
        itsSidedAttributes.add(theSidedAttributes); 
    }

}