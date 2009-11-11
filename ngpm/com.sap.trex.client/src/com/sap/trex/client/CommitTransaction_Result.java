//
// TrexClient - (c) 2008 SAP AG
//
// created from CommitTransaction_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommitTransaction_Result extends Result
{
    private long itsCommitId;

    public CommitTransaction_Result ()
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
        throw new TrexException(Error.TDBC_READ_ONLY,"CommitTransaction_Result");
    }

    /**
     * \class CommitTransaction_Result
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