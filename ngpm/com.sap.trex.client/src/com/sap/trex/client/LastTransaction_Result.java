//
// TrexClient - (c) 2008 SAP AG
//
// created from LastTransaction_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LastTransaction_Result extends Result
{
    private long itsCommitId;

    public LastTransaction_Result ()
    {
        itsCommitId = 0;
    }

    public void clear()
    {
        super.clear();
        itsCommitId = 0;
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        super.read(theStream);
        itsCommitId = theStream.readLong();
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"LastTransaction_Result");
    }

    /**
     * \class LastTransaction_Result
     *
     * \var commitId  -
     */

    public long getCommitId() 
    {
        return itsCommitId;
    }

    public void setCommitId(long theCommitId)
    {
        itsCommitId = theCommitId; 
    }

}