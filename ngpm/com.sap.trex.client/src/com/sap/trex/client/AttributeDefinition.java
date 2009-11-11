//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from AttributeDefinition.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttributeDefinition
{
    private String itsName;
    private int    itsType; // enum
    private int    itsFlags; // bitmask
    private int    itsLength;
    private int    itsScale;
    private int    itsUsageType; // enum

    public AttributeDefinition ()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsFlags = 0;
        itsLength = 0;
        itsScale = 0;
        itsUsageType = com.sap.trex.client.AttributeUsageType.ATTRIBUTEUSAGETYPE_STANDARD;
    }

    public AttributeDefinition(String theName, int theType)
    {
        itsName = theName;
        itsType = theType;
        itsFlags = 0;
        itsLength = 0;
        itsScale = 0;
        itsUsageType = com.sap.trex.client.AttributeUsageType.ATTRIBUTEUSAGETYPE_STANDARD;
    }

    public AttributeDefinition(String theName, int theType, int theFlags)
    {
        itsName = theName;
        itsType = theType;
        itsFlags = theFlags;
        itsLength = 0;
        itsScale = 0;
        itsUsageType = com.sap.trex.client.AttributeUsageType.ATTRIBUTEUSAGETYPE_STANDARD;
    }

    public AttributeDefinition(String theName, int theType, int theFlags, int theLength, int theScale)
    {
        itsName = theName;
        itsType = theType;
        itsFlags = theFlags;
        itsLength = theLength;
        itsScale = theScale;
        itsUsageType = com.sap.trex.client.AttributeUsageType.ATTRIBUTEUSAGETYPE_STANDARD;
    }

    public AttributeDefinition(String theName, int theType, int theFlags, int theLength, int theScale, int theUsageType)
    {
        itsName = theName;
        itsType = theType;
        itsFlags = theFlags;
        itsLength = theLength;
        itsScale = theScale;
        itsUsageType = theUsageType;
    }

    public void clear()
    {
        itsName = "";
        itsType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsFlags = 0;
        itsLength = 0;
        itsScale = 0;
        itsUsageType = com.sap.trex.client.AttributeUsageType.ATTRIBUTEUSAGETYPE_STANDARD;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsName = theStream.readString();
        itsType = theStream.readEnum();
        itsFlags = theStream.readBitMask();
        itsLength = theStream.readInt();
        itsScale = theStream.readInt();
        itsUsageType = theStream.readEnum();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeEnum(itsType);
        theStream.writeBitMask(itsFlags);
        theStream.writeInt(itsLength);
        theStream.writeInt(itsScale);
        theStream.writeEnum(itsUsageType);
    }

    /**
     * \class AttributeDefinition
     *
     * \var name       -
     * \var type       -
     * \var flags      -
     * \var length     attributetype fixed: number of all digits (=precision)
     *                 attributetype alphanum: length for 0 padding
     *                 other types: length hint
     * \var scale      attributetype fixed: number of digits after decimal point
     * \var usageType  -
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


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }


    public int getLength() 
    {
        return itsLength;
    }

    public void setLength(int theLength)
    {
        itsLength = theLength; 
    }


    public int getScale() 
    {
        return itsScale;
    }

    public void setScale(int theScale)
    {
        itsScale = theScale; 
    }


    public int getUsageType() 
    {
        return itsUsageType;
    }

    public void setUsageType(int theUsageType)
    {
        itsUsageType = theUsageType; 
    }

}