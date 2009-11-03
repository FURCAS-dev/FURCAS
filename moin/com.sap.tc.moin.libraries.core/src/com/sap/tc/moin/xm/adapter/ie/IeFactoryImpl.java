package com.sap.tc.moin.xm.adapter.ie;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.IeFactory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.xm.kernel.XmFactory;
import com.sap.tc.moin.xm.kernel.XmParser;
import com.sap.tc.moin.xm.kernel.XmSerializer;

/**
 * Factory for accessing an instances of {@link ModelImporter} or
 * {@link ModelExporter}.
 */
public final class IeFactoryImpl extends IeFactory {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, IeFactory.class );

    private final XmFactory<RefObject, RefClass, RefAssociation> xmFactory;

    public IeFactoryImpl( ) {

        this.xmFactory = XmFactory.getInstance( );
    }



    @Override
    public ModelImporter getModelImporter( final XmParserConfiguration config, final Connection connection ) {


        final XmParser<RefObject, RefClass, RefAssociation> parser = this.xmFactory.getParser( config );
        final ImportCallback callback = new ImportCallback( connection );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Model Importer for XM Parser Handler {0} created", config.getHandler( ).getClass( ).getName( ) ); //$NON-NLS-1$
        }
        return new ModelImporterImpl( parser, callback );
    }

    @Override
    public ModelExporter getModelExporter( final XmSerializerConfiguration config, final Connection connection ) {

        final XmSerializer<RefObject, RefClass, RefAssociation> serializer = this.xmFactory.getSerializer( config );
        final ExportCallback callback = new ExportCallback( connection );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Model Exporter for XM Serializer {0} created", config.getCustomSerializer( ).getClass( ).getName( ) ); //$NON-NLS-1$
        }
        return new ModelExporterImpl( serializer, callback );
    }


}
