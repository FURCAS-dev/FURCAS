package com.sap.tc.moin.xm.generation.core.code.util;

import org.antlr.stringtemplate.StringTemplateErrorListener;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Listener for StringTemplate errors, delegates to the logging infrastructure.
 */
public final class MoinStringTemplateErrorListener implements StringTemplateErrorListener {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, MoinStringTemplateErrorListener.class );

    public void warning( final String message ) {

        LOGGER.trace( MoinSeverity.WARNING, message );
    }

    public void error( final String message, final Throwable ex ) {

        //only use warning as otherwise this will lead to a lot of error markings, especially in eclipse use case
        LOGGER.trace( ex, MoinSeverity.WARNING, message );
    }
}