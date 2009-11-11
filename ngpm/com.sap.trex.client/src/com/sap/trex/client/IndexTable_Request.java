//
// TrexClient - (c) 2008 SAP AG
//
// created from IndexTable_Request.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexTable_Request extends Request
{
    private String                      itsIndexId;
    private boolean                     itsAutoCommit;
    private long                        itsTransactionId;
    private ArrayList <IndexColumnSpec> itsColumns;
    private ArrayList <IndexTableRow>   itsRows;

    public IndexTable_Request ()
    {
        itsIndexId = "";
        itsAutoCommit = false;
        itsTransactionId = 0;
        itsColumns = new ArrayList <IndexColumnSpec> ();
        itsRows = new ArrayList <IndexTableRow> ();
    }

    public void clear()
    {
        itsIndexId = "";
        itsAutoCommit = false;
        itsTransactionId = 0;
        itsColumns.clear();
        itsRows.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_WRITE_ONLY,"IndexTable_Request");
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        int i,j;
        theStream.writeString(itsIndexId);
        theStream.writeBoolean(itsAutoCommit);
        theStream.writeLong(itsTransactionId);
        theStream.writeVectorSize(itsColumns.size());
        for(i=0; i<itsColumns.size(); i++)
        {
            itsColumns.get(i).write(theStream);
        }
        theStream.writeVectorSize(itsRows.size());
        for(i=0; i<itsRows.size(); i++)
        {
            itsRows.get(i).write(theStream);
        }
    }

    /**
     * \class IndexTable_Request
     *
     * \var indexId        -
     * \var autoCommit     -
     * \var transactionId  -
     * \var columns        -
     * \var rows           -
     */

    public String getIndexId() 
    {
        return itsIndexId;
    }

    public void setIndexId(String theIndexId)
    {
        itsIndexId = theIndexId; 
    }


    public boolean getAutoCommit() 
    {
        return itsAutoCommit;
    }

    public void setAutoCommit(boolean theAutoCommit)
    {
        itsAutoCommit = theAutoCommit; 
    }


    public long getTransactionId() 
    {
        return itsTransactionId;
    }

    public void setTransactionId(long theTransactionId)
    {
        itsTransactionId = theTransactionId; 
    }


    public ArrayList <IndexColumnSpec> getColumns() 
    {
        return itsColumns;
    }

    public void setColumns(ArrayList <IndexColumnSpec> theColumns)
    {
        itsColumns = theColumns; 
    }

    public void addColumn(IndexColumnSpec theColumns)
    {
        itsColumns.add(theColumns); 
    }


    public ArrayList <IndexTableRow> getRows() 
    {
        return itsRows;
    }

    public void setRows(ArrayList <IndexTableRow> theRows)
    {
        itsRows = theRows; 
    }

    public void addRow(IndexTableRow theRows)
    {
        itsRows.add(theRows); 
    }

}