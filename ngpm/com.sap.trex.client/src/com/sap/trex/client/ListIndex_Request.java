//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ListIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListIndex_Request extends Request
{
    private String              itsName;
    private ArrayList <Integer> itsType; // enum
    private int                 itsSubtype; // bitmask
    private String              itsLanguage;

    public ListIndex_Request ()
    {
        itsName = "";
        itsType = new ArrayList <Integer> ();
        itsSubtype = 0;
        itsLanguage = "";
    }

    public void clear()
    {
        itsName = "";
        itsType.clear();
        itsSubtype = 0;
        itsLanguage = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"ListIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsName);
        theStream.writeVectorSize(itsType.size());
        for(i=0; i<itsType.size(); i++)
        {
            theStream.writeEnum(itsType.get(i));
        }
        theStream.writeBitMask(itsSubtype);
        theStream.writeString(itsLanguage);
    }

    /**
     * \class ListIndex_Request
     *
     * \var name      filter: prefix or empty=all
     * \var type      filter: empty list or indextype.unknown in list=all
     * \var subtype   filter
     * \var language  description language. empty=default language
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public ArrayList <Integer> getType() 
    {
        return itsType;
    }

    public void setType(ArrayList <Integer> theType)
    {
        itsType = theType; 
    }
    public void setType(int theType) // set vector to single value
    {
        itsType.clear(); 
        itsType.add(theType); 
    }

    public void addType(int theType)
    {
        itsType.add(theType); 
    }


    public int getSubtype() 
    {
        return itsSubtype;
    }

    public void setSubtype(int theSubtype)
    {
        itsSubtype = theSubtype; 
    }


    public String getLanguage() 
    {
        return itsLanguage;
    }

    public void setLanguage(String theLanguage)
    {
        itsLanguage = theLanguage; 
    }

}