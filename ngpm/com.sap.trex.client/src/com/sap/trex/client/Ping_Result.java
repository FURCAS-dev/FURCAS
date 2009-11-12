//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from Ping_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ping_Result extends Result
{
    private String             itsServer1;
    private int                itsSize1;
    private long               itsTime2;
    private int                itsSize2;
    private ArrayList <String> itsPayload;

    public Ping_Result ()
    {
        itsServer1 = "";
        itsSize1 = 0;
        itsTime2 = 0;
        itsSize2 = 0;
        itsPayload = new ArrayList <String> ();
    }

    public void clear()
    {
        super.clear();
        itsServer1 = "";
        itsSize1 = 0;
        itsTime2 = 0;
        itsSize2 = 0;
        itsPayload.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsServer1 = theStream.readString();
        itsSize1 = theStream.readInt();
        itsTime2 = theStream.readLong();
        itsSize2 = theStream.readInt();
        j = theStream.readVectorSize();
        itsPayload.ensureCapacity(j);
        while(itsPayload.size()<j)
            itsPayload.add(new String());
        while(itsPayload.size()>j)
            itsPayload.remove(itsPayload.size()-1);
        for(i=0; i<j; i++)
            itsPayload.set(i,theStream.readString());
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"Ping_Result");
    }

    /**
     * \class Ping_Result
     *
     * \var server1  -
     * \var size1    request size from client to server1
     * \var time2    time from server1 to server2 in msec
     * \var size2    request size from server1 to server2
     * \var payload  -
     */

    public String getServer1() 
    {
        return itsServer1;
    }

    public void setServer1(String theServer1)
    {
        itsServer1 = theServer1; 
    }


    public int getSize1() 
    {
        return itsSize1;
    }

    public void setSize1(int theSize1)
    {
        itsSize1 = theSize1; 
    }


    public long getTime2() 
    {
        return itsTime2;
    }

    public void setTime2(long theTime2)
    {
        itsTime2 = theTime2; 
    }


    public int getSize2() 
    {
        return itsSize2;
    }

    public void setSize2(int theSize2)
    {
        itsSize2 = theSize2; 
    }


    public ArrayList <String> getPayload() 
    {
        return itsPayload;
    }

    public void setPayload(ArrayList <String> thePayload)
    {
        itsPayload = thePayload; 
    }

    public void addPayload(String thePayload)
    {
        itsPayload.add(thePayload); 
    }

}