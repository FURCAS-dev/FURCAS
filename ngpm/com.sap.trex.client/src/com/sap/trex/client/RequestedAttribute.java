//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from RequestedAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestedAttribute
{
    private String              itsName;
    private ArrayList <Integer> itsHierarchyNodes;
    private ArrayList <Integer> itsHierarchyLevels;

    public RequestedAttribute ()
    {
        itsName = "";
        itsHierarchyNodes = new ArrayList <Integer> ();
        itsHierarchyLevels = new ArrayList <Integer> ();
    }

    public RequestedAttribute(String theName)
    {
        itsName = theName;
        itsHierarchyNodes = new ArrayList <Integer>();
        itsHierarchyLevels = new ArrayList <Integer>();
    }

    public void clear()
    {
        itsName = "";
        itsHierarchyNodes.clear();
        itsHierarchyLevels.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"RequestedAttribute");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsName);
        theStream.writeVectorSize(itsHierarchyNodes.size());
        for(i=0; i<itsHierarchyNodes.size(); i++)
        {
            theStream.writeInt(itsHierarchyNodes.get(i));
        }
        theStream.writeVectorSize(itsHierarchyLevels.size());
        for(i=0; i<itsHierarchyLevels.size(); i++)
        {
            theStream.writeInt(itsHierarchyLevels.get(i));
        }
    }

    /**
     * \class RequestedAttribute
     *
     * \var name             -
     * \var hierarchyNodes   -
     * \var hierarchyLevels  -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public ArrayList <Integer> getHierarchyNodes() 
    {
        return itsHierarchyNodes;
    }

    public void setHierarchyNodes(ArrayList <Integer> theHierarchyNodes)
    {
        itsHierarchyNodes = theHierarchyNodes; 
    }

    public void addHierarchyNode(int theHierarchyNodes)
    {
        itsHierarchyNodes.add(theHierarchyNodes); 
    }


    public ArrayList <Integer> getHierarchyLevels() 
    {
        return itsHierarchyLevels;
    }

    public void setHierarchyLevels(ArrayList <Integer> theHierarchyLevels)
    {
        itsHierarchyLevels = theHierarchyLevels; 
    }

    public void addHierarchyLevel(int theHierarchyLevels)
    {
        itsHierarchyLevels.add(theHierarchyLevels); 
    }

}