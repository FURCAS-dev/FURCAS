//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from SortAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortAttribute
{
    private String itsName;
    private int    itsSortOrder; // enum
    private String itsViewAttributeName;

    public SortAttribute ()
    {
        itsName = "";
        itsSortOrder = com.sap.trex.client.SortOrder.SORTORDER_ASCENDING;
        itsViewAttributeName = "";
    }

    public SortAttribute(String theName)
    {
        itsName = theName;
        itsSortOrder = com.sap.trex.client.SortOrder.SORTORDER_ASCENDING;
        itsViewAttributeName = "";
    }

    public SortAttribute(String theName, int theSortOrder)
    {
        itsName = theName;
        itsSortOrder = theSortOrder;
        itsViewAttributeName = "";
    }

    public SortAttribute(String theName, int theSortOrder, String theViewAttributeName)
    {
        itsName = theName;
        itsSortOrder = theSortOrder;
        itsViewAttributeName = theViewAttributeName;
    }

    public void clear()
    {
        itsName = "";
        itsSortOrder = com.sap.trex.client.SortOrder.SORTORDER_ASCENDING;
        itsViewAttributeName = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"SortAttribute");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeEnum(itsSortOrder);
        theStream.writeString(itsViewAttributeName);
    }

    /**
     * \class SortAttribute
     *
     * \var name               -
     * \var sortOrder          -
     * \var viewAttributeName  -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public int getSortOrder() 
    {
        return itsSortOrder;
    }

    public void setSortOrder(int theSortOrder)
    {
        itsSortOrder = theSortOrder; 
    }


    public String getViewAttributeName() 
    {
        return itsViewAttributeName;
    }

    public void setViewAttributeName(String theViewAttributeName)
    {
        itsViewAttributeName = theViewAttributeName; 
    }

}