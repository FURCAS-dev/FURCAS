//
// TrexClient - (c) 2008 SAP AG
//
// created from CreateHierarchyIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateHierarchyIndex_Request extends Request
{
    private String itsIndexName;
    private String itsDescription;
    private String itsPredSuccIndex;
    private String itsIntervalIndex;
    private String itsSidIndex;
    private String itsSidAttribute;
    private int    itsRootNode;
    private int    itsOthersNode;

    public CreateHierarchyIndex_Request ()
    {
        itsIndexName = "";
        itsDescription = "";
        itsPredSuccIndex = "";
        itsIntervalIndex = "";
        itsSidIndex = "";
        itsSidAttribute = "";
        itsRootNode = 0;
        itsOthersNode = 0;
    }

    public void clear()
    {
        itsIndexName = "";
        itsDescription = "";
        itsPredSuccIndex = "";
        itsIntervalIndex = "";
        itsSidIndex = "";
        itsSidAttribute = "";
        itsRootNode = 0;
        itsOthersNode = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"CreateHierarchyIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsIndexName);
        theStream.writeString(itsDescription);
        theStream.writeString(itsPredSuccIndex);
        theStream.writeString(itsIntervalIndex);
        theStream.writeString(itsSidIndex);
        theStream.writeString(itsSidAttribute);
        theStream.writeInt(itsRootNode);
        theStream.writeInt(itsOthersNode);
    }

    /**
     * \class CreateHierarchyIndex_Request
     *
     * \var indexName      without language
     * \var description    -
     * \var predSuccIndex  index will be created
     * \var intervalIndex  optional, index will be created
     * \var sidIndex       index has to exist
     * \var sidAttribute   attribute in sidIndex
     * \var rootNode       -
     * \var othersNode     -
     */

    public String getIndexName() 
    {
        return itsIndexName;
    }

    public void setIndexName(String theIndexName)
    {
        itsIndexName = theIndexName; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public String getPredSuccIndex() 
    {
        return itsPredSuccIndex;
    }

    public void setPredSuccIndex(String thePredSuccIndex)
    {
        itsPredSuccIndex = thePredSuccIndex; 
    }


    public String getIntervalIndex() 
    {
        return itsIntervalIndex;
    }

    public void setIntervalIndex(String theIntervalIndex)
    {
        itsIntervalIndex = theIntervalIndex; 
    }


    public String getSidIndex() 
    {
        return itsSidIndex;
    }

    public void setSidIndex(String theSidIndex)
    {
        itsSidIndex = theSidIndex; 
    }


    public String getSidAttribute() 
    {
        return itsSidAttribute;
    }

    public void setSidAttribute(String theSidAttribute)
    {
        itsSidAttribute = theSidAttribute; 
    }


    public int getRootNode() 
    {
        return itsRootNode;
    }

    public void setRootNode(int theRootNode)
    {
        itsRootNode = theRootNode; 
    }


    public int getOthersNode() 
    {
        return itsOthersNode;
    }

    public void setOthersNode(int theOthersNode)
    {
        itsOthersNode = theOthersNode; 
    }

}