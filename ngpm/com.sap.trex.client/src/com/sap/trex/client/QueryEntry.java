//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from QueryEntry.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryEntry
{
    private String             itsAttribute;
    private ArrayList <String> itsValues;
    private int                itsOperator; // enum
    private int                itsRowType; // enum
    private int                itsValueAction; // enum
    private int                itsFlags; // bitmask
    private int                itsPart;

    public QueryEntry ()
    {
        itsAttribute = "";
        itsValues = new ArrayList <String> ();
        itsOperator = com.sap.trex.client.Operator.OPERATOR_EQ;
        itsRowType = com.sap.trex.client.RowType.ROWTYPE_CONTENT;
        itsValueAction = com.sap.trex.client.TermAction.TERMACTION_EXACT;
        itsFlags = 0;
        itsPart = 0;
    }

    public void clear()
    {
        itsAttribute = "";
        itsValues.clear();
        itsOperator = com.sap.trex.client.Operator.OPERATOR_EQ;
        itsRowType = com.sap.trex.client.RowType.ROWTYPE_CONTENT;
        itsValueAction = com.sap.trex.client.TermAction.TERMACTION_EXACT;
        itsFlags = 0;
        itsPart = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"QueryEntry");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsAttribute);
        theStream.writeVectorSize(itsValues.size());
        for(i=0; i<itsValues.size(); i++)
        {
            theStream.writeString(itsValues.get(i));
        }
        theStream.writeEnum(itsOperator);
        theStream.writeEnum(itsRowType);
        theStream.writeEnum(itsValueAction);
        theStream.writeBitMask(itsFlags);
        theStream.writeInt(itsPart);
    }

    /**
     * \class QueryEntry
     *
     * \var attribute    only for rowType=attribute
     * \var values       only for rowType=content,attribute
     *                   for operator between,not between use 2 values
     *                   for string inlists use multiple values
     *                   for int inlists ues one value with space separated int's and
     *                   flags.OrValue
     * \var operator     only for rowType=content,attribute
     * \var rowType      -
     * \var valueAction  -
     * \var flags        -
     * \var part         Join:queryPart, Olap:fems
     */

    public String getAttribute() 
    {
        return itsAttribute;
    }

    public void setAttribute(String theAttribute)
    {
        itsAttribute = theAttribute; 
    }


    public ArrayList <String> getValues() 
    {
        return itsValues;
    }

    public void setValues(ArrayList <String> theValues)
    {
        itsValues = theValues; 
    }

    public void addValue(String theValues)
    {
        itsValues.add(theValues); 
    }


    public int getOperator() 
    {
        return itsOperator;
    }

    public void setOperator(int theOperator)
    {
        itsOperator = theOperator; 
    }


    public int getRowType() 
    {
        return itsRowType;
    }

    public void setRowType(int theRowType)
    {
        itsRowType = theRowType; 
    }


    public int getValueAction() 
    {
        return itsValueAction;
    }

    public void setValueAction(int theValueAction)
    {
        itsValueAction = theValueAction; 
    }


    public int getFlags() 
    {
        return itsFlags;
    }

    public void setFlags(int theFlags)
    {
        itsFlags = theFlags; 
    }


    public int getPart() 
    {
        return itsPart;
    }

    public void setPart(int thePart)
    {
        itsPart = thePart; 
    }

}