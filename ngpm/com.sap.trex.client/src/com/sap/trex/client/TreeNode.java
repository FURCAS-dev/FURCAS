//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from TreeNode.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
    private int    itsLevel;
    private String itsName;
    private String itsValue;
    private int    itsFlags; // bitmask

    public TreeNode ()
    {
        itsLevel = 0;
        itsName = "";
        itsValue = "";
        itsFlags = 0;
    }

    public void clear()
    {
        itsLevel = 0;
        itsName = "";
        itsValue = "";
        itsFlags = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsLevel = theStream.readInt();
        itsName = theStream.readString();
        itsValue = theStream.readString();
        itsFlags = theStream.readBitMask();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"TreeNode");
    }

    /**
     * \class TreeNode
     *
     * \var level  -
     * \var name   -
     * \var value  -
     * \var flags  -
     */

    public int getLevel() 
    {
        return itsLevel;
    }

    public void setLevel(int theLevel)
    {
        itsLevel = theLevel; 
    }


    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public String getValue() 
    {
        return itsValue;
    }

    public void setValue(String theValue)
    {
        itsValue = theValue; 
    }


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }

}