//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexDocument.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexDocument
{
    private String                     itsKey;
    private String                     itsLanguage;
    private int                        itsAction; // enum
    private String                     itsUrl;
    private String                     itsFileName;
    private String                     itsCodePage;
    private String                     itsMimeType;
    private ArrayList <IndexAttribute> itsAttributes;
    private String                     itsContent;
    private byte[]                     itsBinaryContent;

    public IndexDocument ()
    {
        itsKey = "";
        itsLanguage = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsUrl = "";
        itsFileName = "";
        itsCodePage = "";
        itsMimeType = "";
        itsAttributes = new ArrayList <IndexAttribute> ();
        itsContent = "";
        itsBinaryContent = null;
    }

    public void clear()
    {
        itsKey = "";
        itsLanguage = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsUrl = "";
        itsFileName = "";
        itsCodePage = "";
        itsMimeType = "";
        itsAttributes.clear();
        itsContent = "";
        itsBinaryContent = null;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexDocument");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsKey);
        theStream.writeString(itsLanguage);
        theStream.writeEnum(itsAction);
        theStream.writeString(itsUrl);
        theStream.writeString(itsFileName);
        theStream.writeString(itsCodePage);
        theStream.writeString(itsMimeType);
        theStream.writeVectorSize(itsAttributes.size());
        for(i=0; i<itsAttributes.size(); i++)
        {
            itsAttributes.get(i).write(theStream);
        }
        theStream.writeString(itsContent);
        theStream.writeBinary(itsBinaryContent);
    }

    /**
     * \class IndexDocument
     *
     * \var key            -
     * \var language       -
     * \var action         -
     * \var url            use url or fileName or content or binaryContent
     * \var fileName       -
     * \var codePage       -
     * \var mimeType       -
     * \var attributes     -
     * \var content        e.g. plain text or html
     * \var binaryContent  -
     */

    public String getKey() 
    {
        return itsKey;
    }

    public void setKey(String theKey)
    {
        itsKey = theKey; 
    }


    public String getLanguage() 
    {
        return itsLanguage;
    }

    public void setLanguage(String theLanguage)
    {
        itsLanguage = theLanguage; 
    }


    public int getAction() 
    {
        return itsAction;
    }

    public void setAction(int theAction)
    {
        itsAction = theAction; 
    }


    public String getUrl() 
    {
        return itsUrl;
    }

    public void setUrl(String theUrl)
    {
        itsUrl = theUrl; 
    }


    public String getFileName() 
    {
        return itsFileName;
    }

    public void setFileName(String theFileName)
    {
        itsFileName = theFileName; 
    }


    public String getCodePage() 
    {
        return itsCodePage;
    }

    public void setCodePage(String theCodePage)
    {
        itsCodePage = theCodePage; 
    }


    public String getMimeType() 
    {
        return itsMimeType;
    }

    public void setMimeType(String theMimeType)
    {
        itsMimeType = theMimeType; 
    }


    public ArrayList <IndexAttribute> getAttributes() 
    {
        return itsAttributes;
    }

    public void setAttributes(ArrayList <IndexAttribute> theAttributes)
    {
        itsAttributes = theAttributes; 
    }

    public void addAttribute(IndexAttribute theAttributes)
    {
        itsAttributes.add(theAttributes); 
    }


    public String getContent() 
    {
        return itsContent;
    }

    public void setContent(String theContent)
    {
        itsContent = theContent; 
    }


    public byte[] getBinaryContent() 
    {
        return itsBinaryContent;
    }

    public void setBinaryContent(byte[] theBinaryContent)
    {
        itsBinaryContent = theBinaryContent; 
    }

}