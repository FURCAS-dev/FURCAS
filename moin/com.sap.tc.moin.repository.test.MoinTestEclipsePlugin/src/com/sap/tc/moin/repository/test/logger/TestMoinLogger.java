package com.sap.tc.moin.repository.test.logger;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.test.testcase.MoinTestCase;

@SuppressWarnings( "nls" )
public class TestMoinLogger extends MoinTestCase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Test
    public void testCallLogger( ) {

        MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_TEST, this.getClass( ) );

        if ( logger != null ) {

            // Check logging methods

            if ( logger.isLoggedOrTraced( MoinSeverity.FATAL ) ) {
                logger.logAndTrace( MoinSeverity.FATAL, TestMessage.LOGGER_1001, new Object[] { "fatal" } );
                logger.logAndTrace( new Exception( ), MoinSeverity.FATAL, TestMessage.LOGGER_1002, new Object[] { "fatal" } );
            }

            if ( logger.isLoggedOrTraced( MoinSeverity.ERROR ) ) {
                logger.logAndTrace( MoinSeverity.ERROR, TestMessage.LOGGER_1001, new Object[] { "error" } );
                logger.logAndTrace( new Exception( ), MoinSeverity.ERROR, TestMessage.LOGGER_1002, new Object[] { "error" } );

                logger.logAndTrace( MoinSeverity.ERROR, TestMessage.LOGGER_1001, "error" );
            }

            if ( logger.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                logger.logAndTrace( MoinSeverity.WARNING, TestMessage.LOGGER_1001, new Object[] { "warning" } );
                logger.logAndTrace( new Exception( ), MoinSeverity.WARNING, TestMessage.LOGGER_1002, new Object[] { "warning" } );
            }

            if ( logger.isLoggedOrTraced( MoinSeverity.INFO ) ) {
                logger.logAndTrace( MoinSeverity.INFO, TestMessage.LOGGER_1001, new Object[] { "info" } );
                logger.logAndTrace( new Exception( ), MoinSeverity.INFO, TestMessage.LOGGER_1002, new Object[] { "info" } );
            }


            // Check tracing methods
            String msg = "Trace message created only for MOIN Logging test case purposes";
            String msg_1 = msg + " (severity {0})";
            String msg_2 = msg_1 + " (parameter_1 {1})";
            String msg_3 = msg_2 + " (parameter_2 {2})";
            String msg_4 = msg_3 + " (parameter_3 {3})";
            String msg_5 = msg_4 + " (parameter_4 {4})";
            String expMsg = "Trace exception created only for MOIN Logging test case purposes";
            String expMsg_1 = expMsg + " (severity {0})";
            String expMsg_2 = expMsg_1 + " (parameter_1 {1})";
            String expMsg_3 = expMsg_2 + " (parameter_2 {2})";
            String expMsg_4 = expMsg_3 + " (parameter_3 {3})";
            String expMsg_5 = expMsg_4 + " (parameter_4 {4})";

            if ( logger.isTraced( MoinSeverity.FATAL ) ) {
                logger.trace( MoinSeverity.FATAL, msg_1, new Object[] { "fatal" } );
                logger.trace( new Exception( ), MoinSeverity.FATAL, expMsg_1, new Object[] { "fatal" } );
            }

            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, msg );
                logger.trace( MoinSeverity.ERROR, msg_1, new Object[] { "error" } );
                logger.trace( MoinSeverity.ERROR, msg_2, new Object[] { "error", "one" } );
                logger.trace( MoinSeverity.ERROR, msg_3, new Object[] { "error", "one", "two" } );
                logger.trace( MoinSeverity.ERROR, msg_4, new Object[] { "error", "one", "two", "three" } );
                logger.trace( MoinSeverity.ERROR, msg_5, new Object[] { "error", "one", "two", "three", "four" } );

                logger.trace( MoinSeverity.ERROR, msg_1, "error" );
                logger.trace( MoinSeverity.ERROR, msg_2, "error", "one" );
                logger.trace( MoinSeverity.ERROR, msg_3, "error", "one", "two" );
                logger.trace( MoinSeverity.ERROR, msg_4, "error", "one", "two", "three" );
                logger.trace( MoinSeverity.ERROR, msg_5, "error", "one", "two", "three", "four" );

                logger.trace( MoinSeverity.ERROR, msg );

                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg );
                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_1, new Object[] { "error" } );
                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_2, new Object[] { "error", "one" } );
                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_3, new Object[] { "error", "one", "two" } );
                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_4, new Object[] { "error", "one", "two", "three" } );
                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_5, new Object[] { "error", "one", "two", "three", "four" } );

                logger.trace( new Exception( ), MoinSeverity.ERROR, expMsg_2, "error", msg );

                // testing tracing with stack included
                logger.traceWithStack( MoinSeverity.ERROR, msg );
            }

            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                logger.trace( MoinSeverity.WARNING, msg_1, new Object[] { "warning" } );
                logger.trace( new Exception( ), MoinSeverity.WARNING, expMsg_1, new Object[] { "warning" } );
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, msg_1, new Object[] { "info" } );
            }

            if ( logger.isTraced( MoinSeverity.PATH ) ) {
                logger.trace( MoinSeverity.PATH, msg_1, new Object[] { "path" } );
            }

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, msg_1, new Object[] { "debug" } );
            }

        } else {
            assertFalseAndContinue( "Could not initialize MOIN Logger - Category " + MoinCategoryEnum.MOIN_RUNTIME_HOST.toString( ) + "; Location " + this.getClass( ).toString( ), true );
        }

    }
}
