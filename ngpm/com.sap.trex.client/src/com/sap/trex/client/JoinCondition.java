//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from JoinCondition.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoinCondition
{
    private String itsName;
    private String itsIndexId1;
    private String itsIndexLang1;
    private String itsAttributeName1;
    private String itsIndexId2;
    private String itsIndexLang2;
    private String itsAttributeName2;
    private int    itsJoinType; // bitmask
    private long   itsOrder;

    public JoinCondition ()
    {
        itsName = "";
        itsIndexId1 = "";
        itsIndexLang1 = "";
        itsAttributeName1 = "";
        itsIndexId2 = "";
        itsIndexLang2 = "";
        itsAttributeName2 = "";
        itsJoinType = 0;
        itsOrder = 0;
    }

    public void clear()
    {
        itsName = "";
        itsIndexId1 = "";
        itsIndexLang1 = "";
        itsAttributeName1 = "";
        itsIndexId2 = "";
        itsIndexLang2 = "";
        itsAttributeName2 = "";
        itsJoinType = 0;
        itsOrder = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsName = theStream.readString();
        itsIndexId1 = theStream.readString();
        itsIndexLang1 = theStream.readString();
        itsAttributeName1 = theStream.readString();
        itsIndexId2 = theStream.readString();
        itsIndexLang2 = theStream.readString();
        itsAttributeName2 = theStream.readString();
        itsJoinType = theStream.readBitMask();
        itsOrder = theStream.readLong();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeString(itsIndexId1);
        theStream.writeString(itsIndexLang1);
        theStream.writeString(itsAttributeName1);
        theStream.writeString(itsIndexId2);
        theStream.writeString(itsIndexLang2);
        theStream.writeString(itsAttributeName2);
        theStream.writeBitMask(itsJoinType);
        theStream.writeLong(itsOrder);
    }

    /**
     * \class JoinCondition
     *
     * \var name            -
     * \var indexId1        -
     * \var indexLang1      -
     * \var attributeName1  -
     * \var indexId2        -
     * \var indexLang2      -
     * \var attributeName2  -
     * \var joinType        -
     * \var order           -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public String getIndexId1() 
    {
        return itsIndexId1;
    }

    public void setIndexId1(String theIndexId1)
    {
        itsIndexId1 = theIndexId1; 
    }


    public String getIndexLang1() 
    {
        return itsIndexLang1;
    }

    public void setIndexLang1(String theIndexLang1)
    {
        itsIndexLang1 = theIndexLang1; 
    }


    public String getAttributeName1() 
    {
        return itsAttributeName1;
    }

    public void setAttributeName1(String theAttributeName1)
    {
        itsAttributeName1 = theAttributeName1; 
    }


    public String getIndexId2() 
    {
        return itsIndexId2;
    }

    public void setIndexId2(String theIndexId2)
    {
        itsIndexId2 = theIndexId2; 
    }


    public String getIndexLang2() 
    {
        return itsIndexLang2;
    }

    public void setIndexLang2(String theIndexLang2)
    {
        itsIndexLang2 = theIndexLang2; 
    }


    public String getAttributeName2() 
    {
        return itsAttributeName2;
    }

    public void setAttributeName2(String theAttributeName2)
    {
        itsAttributeName2 = theAttributeName2; 
    }


    public int getJoinType() 
    {
        return itsJoinType;
    }

    public void setJoinType(int theJoinType)
    {
        itsJoinType = theJoinType; 
    }


    public long getOrder() 
    {
        return itsOrder;
    }

    public void setOrder(long theOrder)
    {
        itsOrder = theOrder; 
    }

}