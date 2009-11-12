//
// TrexClient - (c) 2008 SAP AG
//
// created from ResultHierarchy.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultHierarchy
{
    private int    itsId;
    private int    itsParentId;
    private int    itsLevel;
    private int    itsNumber;
    private String itsText;
    private int    itsChildCount;

    public ResultHierarchy ()
    {
        itsId = 0;
        itsParentId = 0;
        itsLevel = 0;
        itsNumber = 0;
        itsText = "";
        itsChildCount = 0;
    }

    public void clear()
    {
        itsId = 0;
        itsParentId = 0;
        itsLevel = 0;
        itsNumber = 0;
        itsText = "";
        itsChildCount = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsId = theStream.readInt();
        itsParentId = theStream.readInt();
        itsLevel = theStream.readInt();
        itsNumber = theStream.readInt();
        itsText = theStream.readString();
        itsChildCount = theStream.readInt();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ResultHierarchy");
    }

    /**
     * \class ResultHierarchy
     *
     * \var id          -
     * \var parentId    -
     * \var level       -
     * \var number      -
     * \var text        -
     * \var childCount  -
     */

    public int getId() 
    {
        return itsId;
    }

    public void setId(int theId)
    {
        itsId = theId; 
    }


    public int getParentId() 
    {
        return itsParentId;
    }

    public void setParentId(int theParentId)
    {
        itsParentId = theParentId; 
    }


    public int getLevel() 
    {
        return itsLevel;
    }

    public void setLevel(int theLevel)
    {
        itsLevel = theLevel; 
    }


    public int getNumber() 
    {
        return itsNumber;
    }

    public void setNumber(int theNumber)
    {
        itsNumber = theNumber; 
    }


    public String getText() 
    {
        return itsText;
    }

    public void setText(String theText)
    {
        itsText = theText; 
    }


    public int getChildCount() 
    {
        return itsChildCount;
    }

    public void setChildCount(int theChildCount)
    {
        itsChildCount = theChildCount; 
    }

}