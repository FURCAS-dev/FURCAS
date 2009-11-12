//
// TrexClient - (c) 2008 SAP AG
//
// created from UnitConversion.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnitConversion
{
    private String itsUnitConversionName;
    private String itsDestinationUnit;

    public UnitConversion ()
    {
        itsUnitConversionName = "";
        itsDestinationUnit = "";
    }

    public void clear()
    {
        itsUnitConversionName = "";
        itsDestinationUnit = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsUnitConversionName = theStream.readString();
        itsDestinationUnit = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"UnitConversion");
    }

    /**
     * \class UnitConversion
     *
     * \var unitConversionName  -
     * \var destinationUnit     -
     */

    public String getUnitConversionName() 
    {
        return itsUnitConversionName;
    }

    public void setUnitConversionName(String theUnitConversionName)
    {
        itsUnitConversionName = theUnitConversionName; 
    }


    public String getDestinationUnit() 
    {
        return itsDestinationUnit;
    }

    public void setDestinationUnit(String theDestinationUnit)
    {
        itsDestinationUnit = theDestinationUnit; 
    }

}