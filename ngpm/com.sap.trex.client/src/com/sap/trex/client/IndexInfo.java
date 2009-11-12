//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexInfo.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexInfo
{
    private String             itsName;
    private int                itsType; // enum
    private int                itsSubtype; // bitmask
    private String             itsDescription;
    private int                itsMemSize;
    private int                itsDiskSize;
    private int                itsDocCount;
    private int                itsFlags;
    private ArrayList <String> itsParts;

    public IndexInfo ()
    {
        itsName = "";
        itsType = com.sap.trex.client.IndexType.INDEXTYPE_UNKNOWN;
        itsSubtype = 0;
        itsDescription = "";
        itsMemSize = 0;
        itsDiskSize = 0;
        itsDocCount = 0;
        itsFlags = 0;
        itsParts = new ArrayList <String> ();
    }

    public void clear()
    {
        itsName = "";
        itsType = com.sap.trex.client.IndexType.INDEXTYPE_UNKNOWN;
        itsSubtype = 0;
        itsDescription = "";
        itsMemSize = 0;
        itsDiskSize = 0;
        itsDocCount = 0;
        itsFlags = 0;
        itsParts.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        itsName = theStream.readString();
        itsType = theStream.readEnum();
        itsSubtype = theStream.readBitMask();
        itsDescription = theStream.readString();
        itsMemSize = theStream.readInt();
        itsDiskSize = theStream.readInt();
        itsDocCount = theStream.readInt();
        itsFlags = theStream.readInt();
        j = theStream.readVectorSize();
        itsParts.ensureCapacity(j);
        while(itsParts.size()<j)
            itsParts.add(new String());
        while(itsParts.size()>j)
            itsParts.remove(itsParts.size()-1);
        for(i=0; i<j; i++)
            itsParts.set(i,theStream.readString());
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"IndexInfo");
    }

    /**
     * \class IndexInfo
     *
     * \var name         -
     * \var type         -
     * \var subtype      -
     * \var description  -
     * \var memSize      -
     * \var diskSize     -
     * \var docCount     -
     * \var flags        -
     * \var parts        -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public int getType() 
    {
        return itsType;
    }

    public void setType(int theType)
    {
        itsType = theType; 
    }


    public int getSubtype() 
    {
        return itsSubtype;
    }

    public void setSubtype(int theSubtype)
    {
        itsSubtype = theSubtype; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public int getMemSize() 
    {
        return itsMemSize;
    }

    public void setMemSize(int theMemSize)
    {
        itsMemSize = theMemSize; 
    }


    public int getDiskSize() 
    {
        return itsDiskSize;
    }

    public void setDiskSize(int theDiskSize)
    {
        itsDiskSize = theDiskSize; 
    }


    public int getDocCount() 
    {
        return itsDocCount;
    }

    public void setDocCount(int theDocCount)
    {
        itsDocCount = theDocCount; 
    }


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }


    public ArrayList <String> getParts() 
    {
        return itsParts;
    }

    public void setParts(ArrayList <String> theParts)
    {
        itsParts = theParts; 
    }

    public void addPart(String theParts)
    {
        itsParts.add(theParts); 
    }

}