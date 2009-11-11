//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexTableRow.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexTableRow
{
    private String itsLanguage;
    private int    itsAction; // enum
    private Buffer itsBuffer;

    public IndexTableRow ()
    {
        itsLanguage = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsBuffer = new Buffer ();
    }

    public void clear()
    {
        itsLanguage = "";
        itsAction = com.sap.trex.client.DocumentAction.DOCUMENTACTION_INDEX;
        itsBuffer.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexTableRow");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        theStream.writeString(itsLanguage);
        theStream.writeEnum(itsAction);
        itsBuffer.write(theStream);
        theStream.writeBoolean(false); // end-of-row marker

    }

    /**
     * \class IndexTableRow
     *
     * \fn  clearBuffer()      clears buffer before reusing row with add...()
     * \fn  addString(string)  -
     * \fn  addInt(int)        -
     * \fn  addFloat(float)    -
     * \fn  addDouble(double)  -
     * \fn  addNull()          -
     * \var language           -
     * \var action             -
     */
    public void clearBuffer() {
        itsBuffer.clear();
    }

    public void addString(String theVal){
        try {
            itsBuffer.output().writeString(theVal);
        } catch (IOException ex0) {
            /*only a string is filled, nothing can happen*/;
        } catch (TrexException ex1) {
              /*only a string is filled, nothing can happen*/;
        }
    }


    public void addInt(int theVal) {
        try {
            itsBuffer.output().writeInt(theVal);
        } catch (IOException ex0) {
            /*only a string is filled, nothing can happen*/;
        } catch (TrexException ex1) {
            /*only a string is filled, nothing can happen*/;
        }
    }


    public void addFloat(float theVal)    {
        try {
            itsBuffer.output().writeFloat(theVal);
        } catch (IOException ex0) {
            /*only a string is filled, nothing can happen*/;
        } catch (TrexException ex1) {
            /*only a string is filled, nothing can happen*/;
        }
    }



    public void addDouble(double theVal) {
        try {
            itsBuffer.output().writeDouble(theVal);
        } catch (IOException ex0) {
            /*only a string is filled, nothing can happen*/;
        } catch (TrexException ex1) {
            /*only a string is filled, nothing can happen*/;
        }
    }


    public void addNull() {
        try {
            itsBuffer.output().writeNull();
        } catch (IOException ex0) {
            /*only a string is filled, nothing can happen*/;
        } catch (TrexException ex1) {
            /*only a string is filled, nothing can happen*/;
        }
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


    public Buffer getBuffer() 
    {
        return itsBuffer;
    }

    public void setBuffer(Buffer theBuffer)
    {
        itsBuffer = theBuffer; 
    }

}