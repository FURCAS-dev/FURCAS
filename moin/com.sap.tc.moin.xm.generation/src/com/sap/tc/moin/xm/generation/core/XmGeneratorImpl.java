package com.sap.tc.moin.xm.generation.core;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.XmGenerator;
import com.sap.tc.moin.xm.generation.XmGeneratorException;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.code.ParserSerializerGenerator;
import com.sap.tc.moin.xm.generation.core.code.cps.XmCpsPartsGenerator;
import com.sap.tc.moin.xm.generation.core.metamodel.XmMetaModelGenerator;

/* The implementation is thread safe! */
public final class XmGeneratorImpl extends XmGenerator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmGeneratorImpl.class );

    @Override
    public XmGeneratorOutputImpl execute( final XmGeneratorInput input ) throws XmGeneratorException {

        if ( input == null ) {
            throw new MoinNullPointerException( "input" ); //$NON-NLS-1$
        }
        try {
            final GeneratorCommand command = new GeneratorCommand( input );
            command.execute( );
            return command.getOutput( );
        } catch ( final RuntimeException e ) {
            // see ImportCommand.doExecute()
            if ( e.getCause( ) instanceof XmGeneratorException ) {
                throw (XmGeneratorException) e.getCause( );
            } else {
                throw e;
            }
        }
    }


    static class GeneratorCommand extends Command {


        private final Collection<PartitionOperation> partions = new ArrayList<PartitionOperation>( 1 );

        private XmGeneratorOutputImpl output;


        private final XmGeneratorInput input;

        GeneratorCommand( final XmGeneratorInput aInput ) {

            super( aInput.getConnection( ), "XM Generation" ); //$NON-NLS-1$
            this.input = aInput;
            if ( this.input.getMetamodelPartition( ) != null ) {
                this.partions.add( new PartitionOperation( PartitionOperation.Operation.EDIT, this.input.getMetamodelPartition( ).getPri( ) ) );
            }
        }

        @Override
        public void doExecute( ) {

            LOGGER.trace( MoinSeverity.INFO, "Generation started" ); //$NON-NLS-1$
            try {
                // validate XML schema
                new XsdValidator( ).validate( input.getSchema( ), false );
                // create protocol
                final XmGenerationProtocolImpl protocol = new XmGenerationProtocolImpl( );
                // meta model generation
                final XmMetaModelGenerator metaModelGenerator = new XmMetaModelGenerator( input, protocol );
                metaModelGenerator.createMetaModel( );
                // templates for code generation
                final ParserSerializerGenerator parserSerializerGenerator = new ParserSerializerGenerator( metaModelGenerator, input, protocol );
                parserSerializerGenerator.execute( );
                // CPS parts
                final XmCpsPartsGenerator cpsGenerator = new XmCpsPartsGenerator( input );
                cpsGenerator.execute( );
                // create output
                this.output = new XmGeneratorOutputImpl( parserSerializerGenerator.getParserCode( ), parserSerializerGenerator.getSerializerCode( ), cpsGenerator.getXmCpsFactoryCode( ), cpsGenerator.getModelstorageXml( ), protocol );
            } catch ( final XmGeneratorException e ) {
                throw new RuntimeException( e );
            } finally {
                this.partions.clear( );
            }
            LOGGER.trace( MoinSeverity.INFO, "Generation finished" ); //$NON-NLS-1$
        }

        XmGeneratorOutputImpl getOutput( ) {

            return this.output;
        }


        @Override
        public boolean canExecute( ) {

            return !this.partions.isEmpty( );
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return this.partions;
        }
    }

}
