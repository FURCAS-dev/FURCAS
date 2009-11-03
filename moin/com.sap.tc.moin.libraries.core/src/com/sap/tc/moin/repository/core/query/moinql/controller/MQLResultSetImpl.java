/*
 * Created on 20.03.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLApiMessages;
import com.sap.tc.moin.repository.core.query.moinql.internal.SelectEntry;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLResultException;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * An MQL Result Set wraps the {@link SpiFqlQueryResultSet} structure. It does
 * some book-keeping to map user-defined aliases and attribute references to the
 * correct position in the wrapped result set.
 */
public class MQLResultSetImpl implements MQLResultSet {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MQLResultSetImpl.class );

    // we keep the result set as a BasicQueryResultSet
    private final SpiFqlQueryResultSet resultSet;

    // the size of the result set
    private int resultSetSize;

    // we keep a connection to resolve MRIs if asked for
    private final CoreConnection conn;

    // keeps the format of each column in the result set
    private final MQLColumnType[] columnTypes;

    // this maps the alias String to the number of select list
    private final Map<String, Integer> aliasToPosition;

    // this list contains maps of attribute names to their positions in the
    // select list of a particular alias.
    // The position of the alias in a record is the index in this list of maps
    private final List<Map<String, Integer>> attrsToPosition;

    /**
     * @param _aliasResultStructures the structure of the query which is
     * responsible for this result set
     * @param _resultSet the encapsulated BasicQuery result set
     * @param _aliasToPosition the map from alias strings to Integer positions
     * @param _attrToPosition the array of maps from attribute names to Integer
     * positions. For each alias position, we have a map in this array at the
     * position of the alias position
     */
    public MQLResultSetImpl( Connection _conn, List<SelectEntry> selectEntries, SpiFqlQueryResultSet _resultSet, Map<String, Integer> _aliasToPosition, List<Map<String, Integer>> _attrsToPosition ) {

        this.conn = (CoreConnection) _conn;
        this.resultSet = _resultSet;
        this.aliasToPosition = _aliasToPosition;
        this.attrsToPosition = _attrsToPosition;
        this.resultSetSize = ( _resultSet == null ? 0 : _resultSet.getSize( ) );

        // construct the column types
        this.columnTypes = new MQLColumnType[selectEntries.size( )];

        int j = 0;
        for ( Iterator<SelectEntry> iter = selectEntries.iterator( ); iter.hasNext( ); j++ ) {
            this.columnTypes[j] = iter.next( ).getColumnType( );
        }

        // because original aliases might have disappeared during query processing, 
        // we add them here and give them the same value as the "new" alias
        this.addOriginalAliases( );

        // put a lexicographical sort on the result set
        this.lexicographicSort( );
    }

    /**
     * this method makes sure that all originally used aliases are also given a
     * position
     */
    private void addOriginalAliases( ) {

        if ( this.aliasToPosition != null ) {
            // only for the non-empty set
            for ( int i = 0; i < this.columnTypes.length; i++ ) {
                this.aliasToPosition.put( this.columnTypes[i].alias, this.aliasToPosition.get( this.columnTypes[i].newRuntimeAlias ) );
            }
        }
    }

    public MQLResultSetImpl( Connection _conn, List<SelectEntry> selectEntries ) {

        this( _conn, selectEntries, null, null, null );
    }

    public int getSize( ) {

        return this.resultSetSize;
    }

    public boolean isEmpty( ) {

        return this.resultSetSize == 0;
    }

    public MRI getMri( int position, String alias ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            return this.resultSet.getMri( position, this.getAliasPosition( alias ) );
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public int removeRow( int position ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            if ( this.resultSet.removeEntry( position ) ) {
                return ( --this.resultSetSize );
            }
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public RefObject getRefObject( int position, String alias ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            RefBaseObject unWrappedObject = this.conn.getElement( this.getMri( position, alias ) );
            if ( unWrappedObject != null ) {
                return (RefObject) ( this.conn.getWrapperForJmiObject( unWrappedObject ) );
            }
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public MRI[] getMris( String alias ) throws MQLResultException {

        MRI[] resultMRI = new MRI[this.resultSetSize];

        // for empty sets, since there is no getAliasPosition for such result sets
        if ( resultMRI.length == 0 ) {
            return resultMRI;
        }

        // build the result set
        int aliasPosition = this.getAliasPosition( alias );
        for ( int i = 0; i < resultMRI.length; i++ ) {
            resultMRI[i] = this.resultSet.getMri( i, aliasPosition );
        }

        return resultMRI;
    }

    public RefObject[] getRefObjects( String alias ) throws MQLResultException {

        RefObject[] resultRefBaseObjects = new RefObject[this.resultSetSize];

        // for empty sets, since there is no getAliasPosition for such result sets
        if ( resultRefBaseObjects.length == 0 ) {
            return resultRefBaseObjects;
        }

        Connection connection = conn.getWrapper( );
        // build the result set
        int aliasPosition = this.getAliasPosition( alias );
        for ( int i = 0; i < resultRefBaseObjects.length; i++ ) {
            resultRefBaseObjects[i] = (RefObject) connection.getElement( this.resultSet.getMri( i, aliasPosition ) );
        }

        return resultRefBaseObjects;
    }

    public Object getAttribute( int position, String alias, String attrName ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            // obtain the number of the selection list
            int aliasPos = this.getAliasPosition( alias );

            // obtain the attributeName mapper for this alias
            Map<String, Integer> aliasAttrNames = this.attrsToPosition.get( aliasPos );

            Integer attrPos = aliasAttrNames.get( attrName );

            if ( attrPos != null ) {
                return this.getAttributeValueForPosition( position, aliasPos, attrPos );
            }
            // the attribute name was not defined for the particular alias of the result set
            throw new MQLResultException( MQLApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias );
        }
        // index out of bounds
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public Object[] getAttributes( int position, String alias ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            // obtain the position of the alias
            int aliasPos = this.getAliasPosition( alias );

            // obtain the number of attributes for that alias
            int numberOfAttrs = this.attrsToPosition.get( aliasPos ).values( ).size( );

            // construct the result set
            Object[] result = new Object[numberOfAttrs];

            // iterate over the to-be-constructed result
            for ( int attrPos = 0; attrPos < result.length; attrPos++ ) {
                result[attrPos] = this.getAttributeValueForPosition( position, aliasPos, attrPos );
            }

            return result;
        }

        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    private int getAliasPosition( String alias ) throws MQLResultException {

        // observe that the pre-condition is a non-empty result set
        Integer aliasPosition = this.aliasToPosition.get( alias );

        if ( aliasPosition != null ) {
            return aliasPosition;
        }
        // the alias was not defined for the particular result set
        throw new MQLResultException( MQLApiMessages.UNDEFINED_ALIAS, alias );
    }

    private Object getAttributeValueForPosition( int position, int aliasPos, int attrPos ) throws MQLResultException {

        // check for index out of bounds
        if ( position >= 0 && position < this.resultSetSize ) {
            return this.resultSet.getAttributeValue( position, aliasPos, attrPos );
        }
        throw new MQLResultException( MQLApiMessages.QUERY_RESULT_OUT_OF_BOUNDS );
    }

    public MQLColumnType[] getQueryColumnTypes( ) {

        return this.columnTypes;
    }

    @Override
    public String toString( ) {

        StringWriter sw = new StringWriter( );
        this.asCSV( sw );

        return sw.toString( );
    }

    public void asCSV( Writer writer ) throws MQLResultException {

        // separation character for CSV
        char sep_char = ';';

        // separation character for multi-valued attributes
        char mv_sep_char = ',';

        // obtain header data
        MQLColumnType[] headerData = this.getQueryColumnTypes( );

        try {

            // create table header
            for ( int k = 0; k < headerData.length; k++ ) {
                writer.append( headerData[k].alias );
                // writer.append(aliasesHeaderList.get(k));
                if ( headerData[k].attribute != null ) {
                    writer.append( "." ); //$NON-NLS-1$
                    writer.append( headerData[k].attribute );
                    if ( headerData[k].multiValued ) {
                        writer.append( "[multi]" ); //$NON-NLS-1$
                    }
                }
                writer.append( " : " ); //$NON-NLS-1$
                writer.append( headerData[k].typeName );

                // CSV lines do not have a final separation character
                if ( k < ( headerData.length - 1 ) ) {
                    writer.append( sep_char );
                }
            }
            writer.append( "\n" ); //$NON-NLS-1$

            // create table data

            for ( int l = 0; l < this.resultSetSize; l++ ) {

                for ( int k = 0; k < headerData.length; k++ ) {
                    // if no attribute is specified, return MRI of the
                    // ModelElement
                    if ( headerData[k].attribute == null ) {
                        writer.append( this.getMri( l, headerData[k].alias ).toString( ) );
                    } else {
                        // for multivalued attributes, put all values in one
                        // field
                        if ( headerData[k].multiValued ) {
                            Object[] mvAttr = (Object[]) ( this.getAttribute( l, headerData[k].alias, headerData[k].attribute ) );
                            if ( mvAttr == null ) {
                                writer.append( "null" ); //$NON-NLS-1$
                            } else {
                                for ( int i = 0; i < mvAttr.length; i++ ) {
                                    writer.append( mvAttr[i].toString( ) );
                                    if ( i < mvAttr.length - 1 ) {
                                        writer.append( mv_sep_char );
                                    }
                                }
                            }

                        } else {
                            Object value = this.getAttribute( l, headerData[k].alias, headerData[k].attribute );
                            if ( value == null ) {
                                writer.append( "null" ); //$NON-NLS-1$
                            } else {
                                writer.append( value.toString( ) );
                            }
                        }
                    }
                    if ( k < headerData.length - 1 ) {
                        writer.append( sep_char );
                    }
                }
                writer.append( "\n" ); //$NON-NLS-1$
            }

        } catch ( IOException e ) {
            throw new MQLResultException( e, MQLApiMessages.IO_DURING_CSV_SERIALIZATION );
        }
    }

    /**
     * Puts a lexicographic ordering on the result set
     */
    private void lexicographicSort( ) {

        // only if not null!
        if ( this.resultSet != null && this.resultSet.getSize( ) > 1 ) {

            long timeStamp = System.nanoTime( );

            // based on the query columns, make a sort-list
            int[][] positions = new int[this.columnTypes.length][2];
            for ( int i = 0; i < this.columnTypes.length; i++ ) {
                MQLColumnType columnType = this.columnTypes[i];
                // for aliases, we only need the alias position
                positions[i][0] = this.aliasToPosition.get( columnType.alias );
                if ( columnType.attribute != null ) {
                    // for attributes, we also get the attribute position
                    positions[i][1] = this.attrsToPosition.get( positions[i][0] ).get( columnType.attribute );
                } else {
                    positions[i][1] = -1;
                }
            }

            // do the actual sorting
            this.resultSet.lexicographicSort( positions );

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                long queryTime = ( System.nanoTime( ) - timeStamp ) / 1000000;
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_PUTTING_FIX_ORDER_ON_RESULT_SET, queryTime );
            }
        }
    }
}
