//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from TmxSearch_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TmxSearch_Result extends Result
{
    private TmxResultTable             itsResults_item;
    private int                        itsResults_size = 0;
    private int                        itsResults_pos = 0;
    private InputStream                itsResults_stream = null;

    public TmxSearch_Result ()
    {
        itsResults_item = new TmxResultTable ();
    }

    public void clear()
    {
        super.clear();
        itsResults_item.clear();
        itsResults_size = 0; itsResults_pos = 0;
        if(itsResults_stream!=null) { itsResults_stream.releaseRef(); itsResults_stream=null; }
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsResults_size = theStream.readVectorSize();
        itsResults_pos=0; itsResults_item.clear();
        if(itsResults_stream!=null) { itsResults_stream.releaseRef();  itsResults_stream=null; }
        if(itsResults_size>0)       { itsResults_stream=theStream; itsResults_stream.addRef(); }
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"TmxSearch_Result");
    }

    /**
     * \class TmxSearch_Result
     *
     * \var results  -
     */
    public int countResults() 
    {
        return itsResults_size;
    }

    public boolean nextResult() 
    {
        if(itsResults_stream==null)
            return false;
        try {
            if(itsResults_pos>0) itsResults_item.getTable().readAll(); // cleanup
            itsResults_item.read(itsResults_stream);
            itsResults_pos+=1;
            if(itsResults_pos==itsResults_size) {
                itsResults_stream.releaseRef(); itsResults_stream=null;
            }
            return true;
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
            itsResults_stream.releaseRef(); itsResults_stream=null;
            return false;
        } catch (TrexException ex1) {
            itsError = new Error(ex1);
            itsResults_stream.releaseRef(); itsResults_stream=null;
            return false;
        }
    }

    public TmxResultTable getResult() 
    {
        return itsResults_item;
    }


}