/**
 * 
 */
package com.sap.tc.moin.repository.shared.util.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;


/**
 * Shared class with static utility methods for database access components (via
 * standard JDBC).
 * 
 * @author d032434
 */
public class DatabaseUtilities {

    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN, MoinLocationEnum.MOIN_UTIL_DB, DatabaseUtilities.class );

    /**
     * Closes the following JDBC connection, statement and result set in the
     * right order (result-set, statement, connection). Each parameter may be
     * <code>null</code>. Exceptions during close are traced with ERROR.
     * 
     * @param connection the connection to close; may be <code>null</code>
     * @param statement the statement to close; may be <code>null</code>
     * @param resultSet the resultSet to close; may be <code>null</code>
     */
    public static void closeAll( Connection connection, Statement statement, ResultSet resultSet ) {

        // close all in the right order
        close( resultSet );
        close( statement );
        close( connection );
    }

    /**
     * Closes the specified JDBC connection. Exceptions during close are traced
     * with ERROR.
     * 
     * @param connection the connection to close; may be <code>null</code>
     */
    public static void close( Connection connection ) {

        if ( connection != null ) {
            try {
                connection.close( );
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "Database connection {0} could not be closed.", connection ); //$NON-NLS-1$
                }
            }
        }
    }

    /**
     * Closes the specified JDBC statement. Exceptions during close are traced
     * with ERROR.
     * 
     * @param connection the connection to close; may be <code>null</code>
     */
    public static void close( Statement statement ) {

        if ( statement != null ) {
            try {
                statement.close( );
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "Database statement {0} could not be closed.", statement ); //$NON-NLS-1$
                }
            }
        }
    }

    /**
     * Closes the specified JDBC result-set. Exceptions during close are traced
     * with ERROR.
     * 
     * @param connection the connection to close; may be <code>null</code>
     */
    public static void close( ResultSet resultSet ) {

        if ( resultSet != null ) {
            try {
                resultSet.close( );
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "Database result-set {0} could not be closed.", resultSet ); //$NON-NLS-1$
                }
            }
        }
    }

    /**
     * Closes the specified input stream. Exceptions during close are traced
     * with ERROR.
     * 
     * @param connection the connection to close; may be <code>null</code>
     */
    public static void close( InputStream inputStream ) {

        if ( inputStream != null ) {
            try {
                inputStream.close( );
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "InputStream {0} could not be closed.", inputStream ); //$NON-NLS-1$
                }
            }
        }
    }
}
