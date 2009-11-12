//
// TrexClient - (c) 2008 SAP AG
//
// created from ViewAttribute.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewAttribute
{
    private String itsName;
    private String itsIndexId;
    private String itsIndexLang;
    private String itsAttributeName;
    private String itsDescription;
    private String itsVisible;

    public ViewAttribute ()
    {
        itsName = "";
        itsIndexId = "";
        itsIndexLang = "";
        itsAttributeName = "";
        itsDescription = "";
        itsVisible = "";
    }

    public void clear()
    {
        itsName = "";
        itsIndexId = "";
        itsIndexLang = "";
        itsAttributeName = "";
        itsDescription = "";
        itsVisible = "";
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        itsName = theStream.readString();
        itsIndexId = theStream.readString();
        itsIndexLang = theStream.readString();
        itsAttributeName = theStream.readString();
        itsDescription = theStream.readString();
        itsVisible = theStream.readString();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ViewAttribute");
    }

    /**
     * \class ViewAttribute
     *
     *   aka. Dimension
     *
     * \var name           -
     * \var indexId        -
     * \var indexLang      -
     * \var attributeName  -
     * \var description    -
     * \var visible        -
     */

    public String getName() 
    {
        return itsName;
    }

    public void setName(String theName)
    {
        itsName = theName; 
    }


    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }


    public String getIndexLang() 
    {
        return itsIndexLang;
    }

    public void setIndexLang(String theIndexLang)
    {
        itsIndexLang = theIndexLang; 
    }


    public String getAttributeName() 
    {
        return itsAttributeName;
    }

    public void setAttributeName(String theAttributeName)
    {
        itsAttributeName = theAttributeName; 
    }


    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public String getVisible() 
    {
        return itsVisible;
    }

    public void setVisible(String theVisible)
    {
        itsVisible = theVisible; 
    }

}