//
// TrexClient - (c) 2008 SAP AG
//
// created from ResultTable.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultTable
{
        private InputStream  itsStream;
        private long         itsRow,itsRows;
        private long         itsCol,itsCols;
        private boolean      itsColRead;

    private Error  itsError;

    public ResultTable ()
    {
        itsRow    = 0;
        itsRows = 0;
        itsCol    = 0;
        itsCols = 0;
        itsColRead = true;
        itsError = new Error();
        itsStream = null;
    }

    protected void finalize () throws Throwable
    {
        if(itsStream!=null)
            itsStream.releaseRef();
        super.finalize();
    }

    public void clear()
    {
        itsRow    = 0;
        itsRows = 0;
        itsCol    = 0;
        itsCols = 0;
        itsColRead = true;
        if(itsStream != null) {
            itsStream.releaseRef();
            itsStream = null;
        }

        itsError.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
    clear();
    itsStream = theStream;
    itsRows = itsStream.readUint();
    itsCols = itsStream.readUint();
    itsStream.addRef();

    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ResultTable");
    }

    /**
     * \class ResultTable
     *
     *   Streaming interface to searchTable result
     *   Use like:
     *   . while(nextRow()) {
     *   . . while(nextColumn()) {
     *   . . . get...();
     *   . . }
     *   . }
     *   * For Languages where error is part of the class:
     *   ** next...() returns false when the end is reached or an error occured when
     *   reading from it's input stream. When an error occurs in get...() a dummy
     *   value is returned and the next next...() returns false.
     *   ** Check the error after reading all rows.
     *   * For other languages:
     *   ** An exception is thrown by get...() and next...()
     *
     * \fn  size_t countRows()       -
     * \fn  size_t countColumns()    Matches length of
     *                               vector<ResultAttributeDefinition>
     * \fn  boolean nextRow()        -
     * \fn  boolean nextColumn()     -
     * \fn  ColumnType getType()     Returns the type for the get...Value() method
     *                               that should be used to access the current column
     *                               value.
     *                               ColumnType is a subset of AttributeType because
     *                               multiple attribute types are send as string
     *                               column.
     * \fn  boolean isNull()         shortcut for getType()==AttributeType::Unknown
     * \fn  string getStringValue()  -
     * \fn  int getIntValue()        -
     * \fn  float getFloatValue()    -
     * \fn  double getDoubleValue()  -
     * \fn  object getValue()        returns any value. only for languages that
     *                               support polymorphic data types
     * \var error                    -
     */
    public void readAll()
    {
        while(nextRow())
            while(nextColumn())
                /*nop*/;
    }

    public long countRows()
    { return itsRows; }


    public long countColumns()
    { return itsCols; }


    public boolean nextRow() {
        if(itsStream == null)
            return false;
        if(itsRow>=itsRows) {
            itsStream.releaseRef();
            itsStream = null;
            return false;
        }
        if(itsRow>0) {
            while(nextColumn())
                ;
            if(itsStream == null)
                return false;
        }
        ++itsRow;
        itsCol = 0;
        itsColRead = true; // force error if using get...Value() without prior nextColumn()
        return true;
    }


    public boolean nextColumn() {
        if(itsStream == null)
            return false;
        if(itsCol>itsCols)
            return false;
        if(itsCol>0 && !itsColRead) { // ignore unread column, e.g. null value
            try {
                itsStream.ignoreOne();
            } catch(IOException ex0) {
                itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
                itsStream=null;
                return false;
            } catch (TrexException ex1) {
                itsError = new Error(ex1);
                itsStream.releaseRef();
                itsStream = null;
                return false;
            }
        }
        ++itsCol;
        if(itsCol>itsCols)
            return false;
        itsColRead=false;
        return true;
    }


    public int getType() {
        if (itsStream == null)
            return ColumnType.COLUMNTYPE_UNDEFINED;
        if(itsColRead) {
            itsError.set(Error.TDBC_COLUMN_READ);
            return ColumnType.COLUMNTYPE_UNDEFINED;
        }
        try {
            int aType = itsStream.peekType();
            if (aType == BufferedIO.TyNull)        return ColumnType.COLUMNTYPE_NULL;
            else if (aType == BufferedIO.TyString) return ColumnType.COLUMNTYPE_STRING;
            else if (aType == BufferedIO.TyInt)    return ColumnType.COLUMNTYPE_INT;
            else if (aType == BufferedIO.TyFloat)  return ColumnType.COLUMNTYPE_FLOAT;
            else if (aType == BufferedIO.TyDouble) return ColumnType.COLUMNTYPE_DOUBLE;
            else itsError.set(Error.IMSRC_TCPIP_OBJECT_ID_MISMATCH,"ResultTable");
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
        } catch (TrexException ex1) {
            itsError = new Error(ex1);
        }
        itsStream.releaseRef();
        itsStream = null;
        return ColumnType.COLUMNTYPE_UNDEFINED;
    }


    public boolean isNull() throws TrexException
    { return    (getType() == ColumnType.COLUMNTYPE_NULL); }


    public String getStringValue() {
        String theString = "";
        if (itsStream == null)
            return "";
        if(itsColRead) {
            itsError.set(Error.TDBC_COLUMN_READ);
            return "";
        }
        try {
            theString = itsStream.readString();
            itsColRead = true;
            return theString;
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
            itsStream.releaseRef();
            itsStream = null;
            return "";
        } catch (TrexException ex1) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex1.getMessage());
            return "";
        } catch (Exception ex2)    {
            itsStream = null;
            itsError.set(Error.TREX_SAPRC_UNKNOWN_EXCEPTION, ex2.getMessage());
            return "";
        }
    }


    public int getIntValue() {
        if (itsStream == null)
            return 0;
        if(itsColRead) {
            itsError.set(Error.TDBC_COLUMN_READ);
            return 0;
        }
        try {
            int anInt;
            anInt = itsStream.readInt();
            itsColRead = true;
            return anInt;
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
            itsStream.releaseRef();
            itsStream = null;
            return 0;
        }catch (Exception ex) {
            itsStream = null;
            itsError.set(Error.TREX_SAPRC_UNKNOWN_EXCEPTION, ex.getMessage());
            return 0;
        }
    }


    public float getFloatValue() {
        if (itsStream == null)
                return 0;
        if(itsColRead) {
            itsError.set(Error.TDBC_COLUMN_READ);
            return 0;
        }
        try {
            float aFloat;
            aFloat = itsStream.readFloat();
            itsColRead = true;
            return aFloat;
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
            itsStream.releaseRef();
            itsStream = null;
            return 0;
        } catch (Exception ex1) {
            itsStream = null;
            itsError.set(Error.TREX_SAPRC_UNKNOWN_EXCEPTION, ex1.getMessage());
            return 0;
        }
    }


    public double getDoubleValue() {
        if (itsStream == null)
            return 0.0;
        if(itsColRead) {
            itsError.set(Error.TDBC_COLUMN_READ);
            return 0.0;
        }
        try {
            double aDouble;
            aDouble = itsStream.readDouble();
            itsColRead = true;
            return aDouble;
        } catch(IOException ex0) {
            itsError.set(Error.TDBC_IOEXCEPTION, ex0.getMessage());
            itsStream.releaseRef();
            itsStream = null;
            return 0.0;
        } catch (Exception ex1) {
            itsStream = null;
            itsError.set(Error.TREX_SAPRC_UNKNOWN_EXCEPTION, ex1.getMessage());
            return 0.0;
        }
    }


    public Error getError() {
            return itsError;
    }


    public Object getValue() {
        switch(getType()) {
            case com.sap.trex.client.ColumnType.COLUMNTYPE_STRING:
                return getStringValue();
            case com.sap.trex.client.ColumnType.COLUMNTYPE_FLOAT:
                 return new Float(getFloatValue());
            case com.sap.trex.client.ColumnType.COLUMNTYPE_DOUBLE:
                return new Double(getDoubleValue());
            case com.sap.trex.client.ColumnType.COLUMNTYPE_INT:
                return new Integer(getIntValue());
            default:
                return null;
        }
    }



}