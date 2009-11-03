package com.sap.tc.moin.js.query.service.client.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.js.query.service.WsColumnType;
import com.sap.tc.moin.js.query.service.WsResultObject;
import com.sap.tc.moin.js.query.service.WsResultRow;
import com.sap.tc.moin.js.query.service.WsResultSet;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.query.messages.MQLApiMessages;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLResultException;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;


/**
 * Alternative implementation of
 * {@link com.sap.tc.moin.repository.mql.MQLResultSet} with a
 * {@link com.sap.tc.moin.js.query.service.WsResultSet} backend.
 * 
 * @author D044522
 */
public class WsMqlResultSetImpl implements MQLResultSet {

    private static final String NULL = "null"; //$NON-NLS-1$

    private static final String LS = System.getProperty( "line.separator", //$NON-NLS-1$
                                                         "\n" ); //$NON-NLS-1$

    // separation character for CSV
    private static final char SEP_CHAR = ';';

    // separation character for multi-valued attributes
    private static final char MV_SEP_CHAR = ',';

    private static final String NO_GET_REF_OBJECT = Localization.REMOTE_ME_CANNOT_BE_RESOLVED.format( );

    private final static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN, MoinLocationEnum.MOIN_QUERY_MQL, WsMqlResultSetImpl.class );

    private int resultSetSize;

    private final WsResultSet wrs;

    /**
     * A cache for transformed column types.
     */
    private MQLColumnType[] mColumnTypes = null;

    /**
     * Maps column alias names to a list of column indices where this alias is
     * used (potentially more than one if multiple attributes of the same alias
     * are queried).
     */
    private Map<String, List<Integer>> aliases = null;

    /**
     * Maps column alias + attribute names (without a dot in between) to the
     * column index where it is used.
     */
    private Map<String, Integer> attribs = null;

    public WsMqlResultSetImpl( WsResultSet wrs ) {

        assert ( wrs != null );

        this.wrs = wrs;
        this.resultSetSize = wrs.getResultRow( ).size( );
    }

    public void asCSV( Writer writer ) throws MQLResultException {

        // obtain header data
        final MQLColumnType[] headerData = this.getQueryColumnTypes( );

        try {
            // create table header
            for ( int k = 0; k < headerData.length; k++ ) {
                writer.append( headerData[k].alias );
                // writer.append(aliasesHeaderList.get(k));
                if ( headerData[k].attribute != null ) {
                    writer.append( '.' );
                    writer.append( headerData[k].attribute );
                    if ( headerData[k].multiValued ) {
                        writer.append( "[multi]" ); //$NON-NLS-1$
                    }
                }
                writer.append( " : " ); //$NON-NLS-1$
                writer.append( headerData[k].typeName );

                // CSV lines do not have a final separation character
                if ( k < ( headerData.length - 1 ) ) {
                    writer.append( SEP_CHAR );
                }
            }
            writer.append( LS );

            // create table data
            for ( int l = 0; l < this.resultSetSize; l++ ) {
                for ( int k = 0; k < headerData.length; k++ ) {
                    final Object value = this.getAttribute( l, k );
                    if ( value == null ) {
                        writer.append( NULL );
                    } else {
                        if ( headerData[k].multiValued ) {
                            final Object[] mvAttr = (Object[]) value;
                            for ( int i = 0; i < mvAttr.length; i++ ) {
                                writer.append( mvAttr[i].toString( ) );
                                if ( i < mvAttr.length - 1 ) {
                                    writer.append( MV_SEP_CHAR );
                                }
                            }
                        } else {
                            writer.append( value.toString( ) );
                        }
                    }
                    if ( k < headerData.length - 1 ) {
                        writer.append( SEP_CHAR );
                    }
                }
                writer.append( LS );
            }
        } catch ( IOException e ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( e, MoinSeverity.WARNING, MQLApiMessages.IO_DURING_CSV_SERIALIZATION );
            }
            throw new MQLResultException( e, MQLApiMessages.IO_DURING_CSV_SERIALIZATION );
        }


    }

    private Object getAttribute( int row, int column ) {

        final WsResultObject wro = wrs.getResultRow( ).get( row ).getCell( ).get( column );
        if ( getQueryColumnTypes( )[column].multiValued ) {
            final List<String> mvs = wro.getMulti( );
            final String[] retval = new String[mvs.size( )];
            for ( int i = 0; i < retval.length; i++ ) {
                retval[i] = mvs.get( i );
            }
            return retval;
        }
        return wro.getSimple( );
    }

    public Object getAttribute( int position, String alias, String attrName ) throws MQLResultException {

        if ( position >= 0 && position < this.resultSetSize ) {

            if ( aliases == null ) {
                // this ensures that attribs is set as well, which we will need later on.
                getQueryColumnTypes( );
            }

            final Integer colPos = this.attribs.get( alias + attrName );
            if ( colPos != null ) {
                try {
                    return getAttribute( position, colPos );
                } catch ( NullPointerException npe ) {
                    if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                        _log.logAndTrace( npe, MoinSeverity.WARNING, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias );
                    }
                    throw new MQLResultException( npe, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias );
                }
            }
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias );
            }
            throw new MQLResultException( MQLApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias );
        }
        if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
            _log.logAndTrace( MoinSeverity.WARNING, MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public Object[] getAttributes( int position, String alias ) throws MQLResultException {

        if ( position >= 0 && position < this.resultSetSize ) {
            if ( aliases == null ) {
                getQueryColumnTypes( );
            }

            final List<Integer> attrs = this.aliases.get( alias );
            if ( attrs != null ) {
                try {
                    final Object[] res = new Object[attrs.size( )];
                    for ( int i = 0; i < res.length; i++ ) {
                        res[i] = getAttribute( position, attrs.get( i ) );
                    }
                    return res;
                } catch ( NullPointerException npe ) {
                    if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                        _log.logAndTrace( npe, MoinSeverity.WARNING, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, '*', alias );
                    }
                    throw new MQLResultException( npe, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, '*', alias );
                }
            }
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, MQLApiMessages.ATTRIBUTE_NOT_SELECTED, '*', alias );
            }
            throw new MQLResultException( MQLApiMessages.ATTRIBUTE_NOT_SELECTED, '*', alias );
        }
        if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
            _log.logAndTrace( MoinSeverity.WARNING, MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public MRI getMri( int position, String alias ) throws MQLResultException {

        return StringWrapperResourceIdentifierFactory.getInstance( ).createMri( (String) this.getAttribute( position, alias, null ) );
    }

    public MRI[] getMris( String alias ) throws MQLResultException {

        final MRI[] mris = new MRI[resultSetSize];

        if ( resultSetSize > 0 ) {
            for ( int i = 0; i < mris.length; i++ ) {
                mris[i] = getMri( i, alias );
            }
        }

        return mris;
    }

    /**
     * Implements lazy evaluation (calculated on first access).
     */
    public MQLColumnType[] getQueryColumnTypes( ) {

        if ( mColumnTypes == null ) {
            final List<WsColumnType> wColumnTypes = wrs.getColumnType( );
            boolean calcAliases = false;

            // aliases and attribs caches also not yet initialized? 
            if ( aliases == null && resultSetSize > 0 ) {
                aliases = new HashMap<String, List<Integer>>( wColumnTypes.size( ) );
                attribs = new HashMap<String, Integer>( wColumnTypes.size( ) );
                calcAliases = true;
            }

            mColumnTypes = new MQLColumnType[wColumnTypes.size( )];
            for ( int i = 0; i < mColumnTypes.length; i++ ) {
                final WsColumnType wColumnType = wColumnTypes.get( i );
                final MQLColumnType mColumnType = new MQLColumnType( );
                mColumnType.alias = wColumnType.getAlias( );
                mColumnType.attribute = wColumnType.getAttribute( );
                mColumnType.isOrdered = wColumnType.isOrdered( );
                mColumnType.isUnique = wColumnType.isOrdered( );
                mColumnType.multiValued = wColumnType.isMultiValued( );
                mColumnType.typeName = wColumnType.getTypeName( );
                mColumnTypes[i] = mColumnType;
                if ( calcAliases ) {
                    final Integer mI = Integer.valueOf( i );
                    List<Integer> list = aliases.get( mColumnType.alias );
                    if ( list == null ) {
                        list = new ArrayList<Integer>( );
                        aliases.put( mColumnType.alias, list );
                    }
                    list.add( mI );
                    attribs.put( mColumnType.alias + mColumnType.attribute, mI );
                }
            }
        }
        // Findbugs "N V EI: com.sap.tc.moin.js.query.service.client.impl.WsMqlResultSetImpl.getQueryColumnTypes() may expose internal representation by returning WsMqlResultSetImpl.mColumnTypes"
        // Can be safely ignored!
        return mColumnTypes;
    }

    public RefObject getRefObject( int position, String alias ) throws MQLResultException {

        if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
            _log.logAndTrace( MoinSeverity.WARNING, Localization.REMOTE_ME_CANNOT_BE_RESOLVED );
        }
        throw new UnsupportedOperationException( NO_GET_REF_OBJECT );
    }

    public RefObject[] getRefObjects( String alias ) throws MQLResultException {

        if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
            _log.logAndTrace( MoinSeverity.WARNING, Localization.REMOTE_ME_CANNOT_BE_RESOLVED );
        }
        throw new UnsupportedOperationException( NO_GET_REF_OBJECT );
    }

    public int getSize( ) {

        return wrs.getResultRow( ).size( );
    }

    public boolean isEmpty( ) {

        return wrs.getResultRow( ).isEmpty( );
    }


    public int removeRow( int position ) throws MQLResultException {

        final List<WsResultRow> rrs = wrs.getResultRow( );
        if ( rrs == null || rrs.isEmpty( ) || position < 0 || position >= rrs.size( ) ) {
            throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
        }

        // Note: The WS proxy implementation (an ArrayList created on demand) will always allow this! 
        rrs.remove( position );
        resultSetSize = rrs.size( );
        return resultSetSize;
    }

    @Override
    public String toString( ) {

        final StringWriter sw = new StringWriter( );
        this.asCSV( sw );
        return sw.toString( );
    }

}
