package com.sap.tc.moin.xm.adapter.cps;

import java.io.IOException;
import java.io.InputStream;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.xm.kernel.XmParser;

/**
 * CPS Parser which delegates the parsing to a XM Parser.
 */
final class XmCpsParser implements SpiCustomParser {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsParser.class );

    private final XmParser<SpiElement, SpiClass, SpiAssociation> xmParser;

    XmCpsParser( final XmParser<SpiElement, SpiClass, SpiAssociation> aXmParser ) {

        if ( aXmParser == null ) {
            throw new MoinNullPointerException( "aXmParser" ); //$NON-NLS-1$
        }
        this.xmParser = aXmParser;
    }

    public void parse( final InputStream stream, final SpiParserCallback callback, final long fileSize ) throws IOException {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Parsing of model partition {0} started", callback.getPri( ) ); //$NON-NLS-1$
        }
        this.xmParser.parse( stream, new XmCpsParserCallback( callback ) );
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Parsing of model partition {0} finished", callback.getPri( ) ); //$NON-NLS-1$
        }
    }
}
