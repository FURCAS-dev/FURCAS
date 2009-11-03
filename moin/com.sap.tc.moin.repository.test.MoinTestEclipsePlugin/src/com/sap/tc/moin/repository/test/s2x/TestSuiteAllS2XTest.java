package com.sap.tc.moin.repository.test.s2x;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.logging.ConsoleLog;
import com.sap.tc.logging.Formatter;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.Log;
import com.sap.tc.logging.PropertiesConfigurator;
import com.sap.tc.logging.Severity;
import com.sap.tc.logging.TraceFormatter;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {
//
    TestS2XSerializerContent.class,
    TestS2XSerializerCallback.class,
    TestS2XSerializerExistenceAndVersioningForPartitionEdit.class,
    TestS2XSerializerExistenceAndVersioningForPartitionCreate.class,
    TestS2XSerializerExistenceAndVersioningForPartitionDelete.class } )
@SuppressWarnings( "nls" )
public class TestSuiteAllS2XTest {

    @BeforeClass
    static public void beforeClass( ) {
        // logging & tracing documentation see
        // http://bis.wdf.sap.corp:1080/twiki/bin/view/Techdev/JavaMonitoringAndManagement#Logging%20and%20Tracing
        // http://bis.wdf.sap.corp:1080/twiki/pub/Techdev/JavaMonitoringAndManagement/Logging_Tutorial.doc
        Location location = Location.getLocation( MoinLocationEnum.MOIN_S2X.getLocationName( ) );
        int severity = Severity.DEBUG;
//        configureLoggerVerySimple( location, severity );
//        configureLoggerViaProperties( location, severity );
//        configureLoggerViaApi( location, severity );
    }

    static private void configureLoggerVerySimple( Location location, int severity ) {
        location.setEffectiveSeverity( severity );
        location.addLog( new ConsoleLog( ) );
    }

    static private void configureLoggerViaProperties( Location location, int severity ) {
        Properties properties = new Properties( );
        properties.put( "log[Console]", "ConsoleLog" );
        properties.put( "log[Console].formatter", "formatter[Trace]" );
        properties.put( "formatter[Trace]", "TraceFormatter" );
        properties.put( "formatter[Trace].pattern", "%s: %24d: %m" );
        properties.put( location.getName( ) + ".severity", Severity.toString( severity ) );
        properties.put( location.getName( ) + ".logs", "+ log[Console]" );
        PropertiesConfigurator configurator = new PropertiesConfigurator( properties );
        configurator.configure( );
    }

    static private void configureLoggerViaApi( Location location, int severity ) {
        // s=message severity, 24d=timestamp in 24 hour format, m=message
        String pattern = "%s: %24d: %m"; //$NON-NLS-1$
        Formatter formatter = new TraceFormatter( pattern );
        Log consoleLog = new ConsoleLog( formatter );
        location.setEffectiveSeverity( severity );
        location.addLog( consoleLog );
    }
}
