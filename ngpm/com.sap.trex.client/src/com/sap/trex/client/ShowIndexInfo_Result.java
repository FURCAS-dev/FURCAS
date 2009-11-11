//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ShowIndexInfo_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowIndexInfo_Result extends Result
{
    private ArrayList <TreeNode> itsNodes;

    public ShowIndexInfo_Result ()
    {
        itsNodes = new ArrayList <TreeNode> ();
    }

    public void clear()
    {
        super.clear();
        itsNodes.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        j = theStream.readVectorSize();
        itsNodes.ensureCapacity(j);
        while(itsNodes.size()<j)
            itsNodes.add(new TreeNode());
        while(itsNodes.size()>j)
            itsNodes.remove(itsNodes.size()-1);
        for(i=0; i<j; i++)
            itsNodes.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ShowIndexInfo_Result");
    }

    /**
     * \class ShowIndexInfo_Result
     *
     * \var nodes  -
     */

    public ArrayList <TreeNode> getNodes() 
    {
        return itsNodes;
    }

    public void setNodes(ArrayList <TreeNode> theNodes)
    {
        itsNodes = theNodes; 
    }

    public void addNode(TreeNode theNodes)
    {
        itsNodes.add(theNodes); 
    }

}