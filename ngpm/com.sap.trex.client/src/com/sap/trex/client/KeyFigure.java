//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from KeyFigure.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeyFigure
{
    private String itsName;
    private int    itsAggregationType; // enum
    private int    itsAttributeType; // enum
    private String itsDescription;
    private String itsUnitConversionName;
    private String itsExpression;
    private String itsRestriction;

    public KeyFigure ()
    {
        itsName = "";
        itsAggregationType = com.sap.trex.client.AggregationType.AGGREGATIONTYPE_NONE;
        itsAttributeType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsDescription = "";
        itsUnitConversionName = "";
        itsExpression = "";
        itsRestriction = "";
    }

    public KeyFigure(String theName)
    {
        itsName = theName;
        itsAggregationType = com.sap.trex.client.AggregationType.AGGREGATIONTYPE_NONE;
        itsAttributeType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsDescription = "";
        itsUnitConversionName = "";
        itsExpression = "";
        itsRestriction = "";
    }

    public KeyFigure(String theName, int theAggregationType)
    {
        itsName = theName;
        itsAggregationType = theAggregationType;
        itsAttributeType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsDescription = "";
        itsUnitConversionName = "";
        itsExpression = "";
        itsRestriction = "";
    }

    public void clear()
    {
        itsName = "";
        itsAggregationType = com.sap.trex.client.AggregationType.AGGREGATIONTYPE_NONE;
        itsAttributeType = com.sap.trex.client.AttributeType.ATTRIBUTETYPE_UNDEFINED;
        itsDescription = "";
        itsUnitConversionName = "";
        itsExpression = "";
        itsRestriction = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsName = theStream.readString();
        itsAggregationType = theStream.readEnum();
        itsAttributeType = theStream.readEnum();
        itsDescription = theStream.readString();
        itsUnitConversionName = theStream.readString();
        itsExpression = theStream.readString();
        itsRestriction = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsName);
        theStream.writeEnum(itsAggregationType);
        theStream.writeEnum(itsAttributeType);
        theStream.writeString(itsDescription);
        theStream.writeString(itsUnitConversionName);
        theStream.writeString(itsExpression);
        theStream.writeString(itsRestriction);
    }

    /**
     * \class KeyFigure
     *
     *   aka. Measure
     *
     * \var name                -
     * \var aggregationType     -
     * \var attributeType       -
     * \var description         -
     * \var unitConversionName  -
     * \var expression          -
     * \var restriction         -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public int getAggregationType() 
    {
        return itsAggregationType;
    }

    public void setAggregationType(int theAggregationType)
    {
        itsAggregationType = theAggregationType; 
    }


    public int getAttributeType() 
    {
        return itsAttributeType;
    }

    public void setAttributeType(int theAttributeType)
    {
        itsAttributeType = theAttributeType; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public String getUnitConversionName() 
    {
        return itsUnitConversionName;
    }

    public void setUnitConversionName(String theUnitConversionName)
    {
        itsUnitConversionName = theUnitConversionName; 
    }


    public String getExpression() 
    {
        return itsExpression;
    }

    public void setExpression(String theExpression)
    {
        itsExpression = theExpression; 
    }


    public String getRestriction() 
    {
        return itsRestriction;
    }

    public void setRestriction(String theRestriction)
    {
        itsRestriction = theRestriction; 
    }

}