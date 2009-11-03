package com.sap.tc.moin.repository.runtimehost.logger.ide;

import java.util.Enumeration;
import java.util.Properties;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.tssap.util.trace.DynamicTraceParticipant;

/**
 * Eclipse-specific MOIN logging and tracing configuration participant that is
 * used to integrate MOIN Logger with SAP Trace Configuration view (an Eclipse
 * plug-in).
 * 
 * @author d029324
 */
public class MoinLoggerDynamicParticipant extends DynamicTraceParticipant {

    /**
     * Returns the list (as Properties) already registered MOIN Loggers. (log or
     * trace objects).
     */
    @Override
    public Properties getConfigurableElements( ) {

        MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, this.getClass( ) );

        Properties props = MoinLoggerFactory.getRegisteredLogControllers( );

        Enumeration keys = props.keys( );
        while ( keys.hasMoreElements( ) ) {
            logger.trace( MoinSeverity.INFO, "Registered Controller " + keys.nextElement( ) ); //$NON-NLS-1$
        }

        return props;
    }

    /**
     * Returns true; therefore the SAP Trace Configuration plug-in each time
     * calls the {@link getConfigurableElements()} method obtaining the current
     * list of MOIN Loggers.
     */
    @Override
    public boolean hasChanged( ) {

        return true;
    }
}
