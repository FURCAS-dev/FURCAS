//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ViewAttributeGroup.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewAttributeGroup
{
    private int                itsType; // enum
    private String             itsName;
    private ArrayList <String> itsDimensions;
    private ArrayList <String> itsLevelNames;
    private String             itsKeyDimension;
    private String             itsDescription;

    public ViewAttributeGroup ()
    {
        itsType = com.sap.trex.client.ViewAttributeGroupType.VIEWATTRIBUTEGROUPTYPE_MEASUREDVALUE;
        itsName = "";
        itsDimensions = new ArrayList <String> ();
        itsLevelNames = new ArrayList <String> ();
        itsKeyDimension = "";
        itsDescription = "";
    }

    public void clear()
    {
        itsType = com.sap.trex.client.ViewAttributeGroupType.VIEWATTRIBUTEGROUPTYPE_MEASUREDVALUE;
        itsName = "";
        itsDimensions.clear();
        itsLevelNames.clear();
        itsKeyDimension = "";
        itsDescription = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsType = theStream.readEnum();
        itsName = theStream.readString();
        j = theStream.readVectorSize();
        itsDimensions.ensureCapacity(j);
        while(itsDimensions.size()<j)
            itsDimensions.add(new String());
        while(itsDimensions.size()>j)
            itsDimensions.remove(itsDimensions.size()-1);
        for(i=0; i<j; i++)
            itsDimensions.set(i,theStream.readString());
        j = theStream.readVectorSize();
        itsLevelNames.ensureCapacity(j);
        while(itsLevelNames.size()<j)
            itsLevelNames.add(new String());
        while(itsLevelNames.size()>j)
            itsLevelNames.remove(itsLevelNames.size()-1);
        for(i=0; i<j; i++)
            itsLevelNames.set(i,theStream.readString());
        itsKeyDimension = theStream.readString();
        itsDescription = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ViewAttributeGroup");
    }

    /**
     * \class ViewAttributeGroup
     *
     * \var type          -
     * \var name          -
     * \var dimensions    -
     * \var levelNames    -
     * \var keyDimension  -
     * \var description   -
     */

    public int getType() 
    {
        return itsType;
    }

    public void setType(int theType)
    {
        itsType = theType; 
    }


    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public ArrayList <String> getDimensions() 
    {
        return itsDimensions;
    }

    public void setDimensions(ArrayList <String> theDimensions)
    {
        itsDimensions = theDimensions; 
    }

    public void addDimension(String theDimensions)
    {
        itsDimensions.add(theDimensions); 
    }


    public ArrayList <String> getLevelNames() 
    {
        return itsLevelNames;
    }

    public void setLevelNames(ArrayList <String> theLevelNames)
    {
        itsLevelNames = theLevelNames; 
    }

    public void addLevelName(String theLevelNames)
    {
        itsLevelNames.add(theLevelNames); 
    }


    public String getKeyDimension() 
    {
        return itsKeyDimension;
    }

    public void setKeyDimension(String theKeyDimension)
    {
        itsKeyDimension = theKeyDimension; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }

}
