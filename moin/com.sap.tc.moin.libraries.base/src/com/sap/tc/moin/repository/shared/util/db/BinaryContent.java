/**
 * 
 */
package com.sap.tc.moin.repository.shared.util.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;



/**
 * Represents the binary content for a database record represented by an integer
 * column for the length and a BLOB (or LONGVARBINARY) column for the data.
 * <p>
 * The utility class allows stream-based reading of the binary data, i.e.
 * without the necessity of full buffering of the whole data in memory. It can
 * be used for single-select queries (i.e. for result-sets with length 0 or 1).
 * <p>
 * The record is initialized from the specified result set. If data is present,
 * a corresponding stream object can be retrieved.
 * <p>
 * See DiDevConfStoreImpl.getDevConfContent(String) for a usage example.
 * 
 * @author d032434
 */
public class BinaryContent {

    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN, MoinLocationEnum.MOIN_UTIL_DB, BinaryContent.class );

    /**
     * Wraps an input stream retrieved from a BLOB column. Closes the stream and
     * the result-set, statement and connection upon close.
     * 
     * @author d032434
     */
    private class BlobInputStreamWrapper extends InputStream {

        private InputStream _blobInputStream;

        /**
         * @param inputStream
         */
        public BlobInputStreamWrapper( InputStream inputStream ) {

            super( );
            _blobInputStream = inputStream;
        }

        /**
         * @see java.io.InputStream#read()
         */
        @Override
        public int read( ) throws IOException {

            return _blobInputStream.read( );
        }

        /**
         * @param b
         * @param off
         * @param len
         * @return
         * @throws IOException
         * @see java.io.InputStream#read(byte[], int, int)
         */
        @Override
        public int read( byte[] b, int off, int len ) throws IOException {

            return _blobInputStream.read( b, off, len );
        }

        /**
         * Closes the stream and the result-set, statement and connection
         * 
         * @see java.io.InputStream#close()
         */
        @Override
        public void close( ) throws IOException {

            try {
                _blobInputStream.close( );
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "BLOB input stream for result-set of query {0} could not be closed.", _sqlQuery ); //$NON-NLS-1$
                }
            }

            // close the underlying connection here
            DatabaseUtilities.close( _connection );
        }
    }

    /**
     * Constructs a new binary content instance for the specified connection and
     * result-set.
     * 
     * @param contentLengthColumnName - name of the content-length column; must
     * be present in the specified result-set
     * @param contentDataColumnName - name of the content-data column; must be
     * present in the specified result-set
     * @param connection - the connection used for the query; is closed by the
     * {@link InputStream#close()} method of the result of
     * {@link #getContentInputStream}, if this method did not return
     * <code>null</code>
     * @param resultSet - the result-set of the query; must be on valid position
     * (i.e. {@link ResultSet#next()} had to be called before and returned
     * <code>true</code>) and contain columns for content-length and
     * content-data
     * @param sqlQuery - the query-string used to retrieve the result-set; only
     * used for tracing
     * @throws SQLException if result-set cannot be accessed
     */
    public BinaryContent( String contentLengthColumnName, String contentDataColumnName, Connection connection, ResultSet resultSet, String sqlQuery ) throws SQLException {

        _sqlQuery = sqlQuery;
        _contentLengthColumnName = contentLengthColumnName;
        _contentDataColumnName = contentDataColumnName;

        // read the content-length from the result-set
        _contentLength = resultSet.getInt( _contentLengthColumnName );

        // keep a reference to the result-set only if there is content present
        if ( _contentLength > 0 ) {
            _resultSet = resultSet;
            _connection = connection;
        }
    }

    // position of the content-length field in the result-set
    private final String _contentLengthColumnName;

    // position of the content-data field in the result-set
    private final String _contentDataColumnName;

    private int _contentLength;

    private ResultSet _resultSet;

    private Connection _connection;

    private final String _sqlQuery;

    /**
     * @return the _contentLength
     */
    public int getContentLength( ) {

        return _contentLength;
    }

    public boolean isEmpty( ) {

        return _contentLength <= 0;
    }

    /**
     * Gets the binary data of the content as stream. If this method is
     * successful (i.e. does not return <code>null</code> and does not throw an
     * exception), the corresponding result-set has to be kept open. Closing the
     * result-set would invalidate the stream object returned by this instance.
     * The returned stream instance ensures to close the result-set, statement
     * and connection in its own close method.
     * 
     * @return an input stream for the binary content or <code>null</code>, if
     * the content is empty
     * @throws SQLException if the stream data could not be read
     */
    public InputStream getContentInputStream( ) throws SQLException {

        if ( isEmpty( ) ) {
            return null;
        } else {
            InputStream blobInputStream = _resultSet.getBinaryStream( _contentDataColumnName );
            return new BlobInputStreamWrapper( blobInputStream );
        }
    }
}
