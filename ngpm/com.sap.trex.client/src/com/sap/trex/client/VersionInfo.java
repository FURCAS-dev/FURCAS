//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from VersionInfo.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VersionInfo
{
    private String itsHostName;
    private int    itsActive; // enum
    private String itsSapsystem;
    private String itsVersion;
    private String itsBuildNr;
    private String itsChangeList;
    private String itsCompileTime;

    public VersionInfo ()
    {
        itsHostName = "";
        itsActive = com.sap.trex.client.Active.ACTIVE_NO;
        itsSapsystem = "";
        itsVersion = "";
        itsBuildNr = "";
        itsChangeList = "";
        itsCompileTime = "";
    }

    public void clear()
    {
        itsHostName = "";
        itsActive = com.sap.trex.client.Active.ACTIVE_NO;
        itsSapsystem = "";
        itsVersion = "";
        itsBuildNr = "";
        itsChangeList = "";
        itsCompileTime = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsHostName = theStream.readString();
        itsActive = theStream.readEnum();
        itsSapsystem = theStream.readString();
        itsVersion = theStream.readString();
        itsBuildNr = theStream.readString();
        itsChangeList = theStream.readString();
        itsCompileTime = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"VersionInfo");
    }

    /**
     * \class VersionInfo
     *
     * \var hostName     -
     * \var active       -
     * \var sapsystem    2 digit instance number
     * \var version      -
     * \var buildNr      -
     * \var changeList   -
     * \var compileTime  -
     */

    public String getHostName() 
    {
        return itsHostName;
    }

    public void setHostName(String theHostName)
    {
        itsHostName = theHostName; 
    }


    public int getActive() 
    {
        return itsActive;
    }

    public void setActive(int theActive)
    {
        itsActive = theActive; 
    }


    public String getSapsystem() 
    {
        return itsSapsystem;
    }

    public void setSapsystem(String theSapsystem)
    {
        itsSapsystem = theSapsystem; 
    }


    public String getVersion() 
    {
        return itsVersion;
    }

    public void setVersion(String theVersion)
    {
        itsVersion = theVersion; 
    }


    public String getBuildNr() 
    {
        return itsBuildNr;
    }

    public void setBuildNr(String theBuildNr)
    {
        itsBuildNr = theBuildNr; 
    }


    public String getChangeList() 
    {
        return itsChangeList;
    }

    public void setChangeList(String theChangeList)
    {
        itsChangeList = theChangeList; 
    }


    public String getCompileTime() 
    {
        return itsCompileTime;
    }

    public void setCompileTime(String theCompileTime)
    {
        itsCompileTime = theCompileTime; 
    }

}