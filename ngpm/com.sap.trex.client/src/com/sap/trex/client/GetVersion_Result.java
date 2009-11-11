//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from GetVersion_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetVersion_Result extends Result
{
    private String                  itsSapsystemName;
    private ArrayList <VersionInfo> itsVersionInfos;

    public GetVersion_Result ()
    {
        itsSapsystemName = "";
        itsVersionInfos = new ArrayList <VersionInfo> ();
    }

    public void clear()
    {
        super.clear();
        itsSapsystemName = "";
        itsVersionInfos.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsSapsystemName = theStream.readString();
        j = theStream.readVectorSize();
        itsVersionInfos.ensureCapacity(j);
        while(itsVersionInfos.size()<j)
            itsVersionInfos.add(new VersionInfo());
        while(itsVersionInfos.size()>j)
            itsVersionInfos.remove(itsVersionInfos.size()-1);
        for(i=0; i<j; i++)
            itsVersionInfos.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"GetVersion_Result");
    }

    /**
     * \class GetVersion_Result
     *
     * \var sapsystemName  -
     * \var versionInfos   -
     */

    public String getSapsystemName() 
    {
        return itsSapsystemName;
    }

    public void setSapsystemName(String theSapsystemName)
    {
        itsSapsystemName = theSapsystemName; 
    }


    public ArrayList <VersionInfo> getVersionInfos() 
    {
        return itsVersionInfos;
    }

    public void setVersionInfos(ArrayList <VersionInfo> theVersionInfos)
    {
        itsVersionInfos = theVersionInfos; 
    }

    public void addVersionInfo(VersionInfo theVersionInfos)
    {
        itsVersionInfos.add(theVersionInfos); 
    }

}
