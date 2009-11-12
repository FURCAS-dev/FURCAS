//
// TrexClient - (c) 2008 SAP AG
//
// created from CreateJoinIndex_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJoinIndex_Request extends Request
{

    public CreateJoinIndex_Request ()
    {
    }

    public void clear()
    {
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"CreateJoinIndex_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
    }

    /**
     * \class CreateJoinIndex_Request
     *
     */
}