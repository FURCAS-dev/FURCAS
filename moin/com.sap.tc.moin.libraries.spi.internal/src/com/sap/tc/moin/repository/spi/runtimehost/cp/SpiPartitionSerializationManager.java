package com.sap.tc.moin.repository.spi.runtimehost.cp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Properties;


import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;

/**
 * Interface for the partition serialization component. The component manages
 * the custom parsers/serializers as well as the build in partition reader. It
 * delegates to the right parser/serializer according the the PRI.
 * 
 * @author d026715
 */
public interface SpiPartitionSerializationManager extends SpiPartitionNameVerifier, SpiPartitionSerializationJmxTracer {

    /**
     * Triggers the parser for the given {@link PRI}. The parser calls the
     * {@link SpiParserCallback} to create the needed data structure (MOIN core
     * instances or index update).
     * 
     * @param pri PRI of the partition to be read.
     * @param inputStream Source of the serialized partition
     * @param parserCallback Callback for creating the needed data structure.
     * @throws IOException
     */
    public void parse( PRI pri, InputStream inputStream, SpiParserCallback parserCallback, long fileSize ) throws IOException;

    /**
     * Returns the {@link SpiParserErrorHandler error handler} for the metamodel
     * with the specified container name, or <code>null</code> if the metamodel
     * does not deliver an error handler.
     * 
     * @param modelVersion TODO
     */
    public SpiParserErrorHandler getParserErrorHandler( String metamodelContainerName, String modelVersion );

    /**
     * Returns the {@link SpiS2XSerializerCustomCallback S2X serialization
     * callback handler} for the metamodel with the specified container name, or
     * <code>null</code> if the metamodel does not deliver a callback handler.
     * 
     * @param metamodelContainerName The container name of the metamodel
     */
    public SpiS2XSerializerCustomCallback getCustomS2XSerializerCallback( String metamodelContainerName );

    /**
     * Checks if a serializer is available for the given {@link PRI}. If no
     * serializer is available, partition can be read only.
     * 
     * @param pri
     */
    public boolean isSerializerAvailable( PRI pri );

    /**
     * Triggers the serializer for the given {@link PRI}. The serializer calls
     * the {@link SpiSerializerCallback} to retrieve information about the model
     * elements and links in the partition to be serialized.
     * 
     * @param pri PRI of the partition to be read.
     * @param outputStream the target for the serialized partition
     * @param serializerCallback callback for retrieving information about the
     * partition content
     * @throws IOException
     */
    public void serialize( PRI pri, OutputStream outputStream, SpiSerializerCallback serializerCallback ) throws IOException;

    /**
     * Triggers the text serializer for the given {@link PRI}. The serializer
     * calls the {@link SpiSerializerCallback} to retrieve information about the
     * model elements and links in the partition to be serialized.
     * 
     * @param pri The PRI of the partition for which the texts should be
     * serialized.
     * @param outputStream The target for the serialized texts in the partition.
     * @param s2xDocument The S2X document that holds information from the MOIN
     * core.
     * @param serializerCallback The Callback for retrieving information about
     * the partition content.
     * @throws IOException
     */
    public void serializeTexts( PRI pri, OutputStream outputStream, SpiS2XDocument s2xDocument, SpiSerializerCallback serializerCallback ) throws IOException;

    /**
     * Returns the custom model content selection criteria. The result is a
     * generic property collection that is to be interpreted by the given
     * lifecycle management system.
     * 
     * @param contentSelectionType Type of the lifecycle management system
     * @return
     */
    public Collection<Properties> getCustomContentSelections( String contentSelectionType );

    /**
     * Parses a partition with the parser specified by the serialization id.
     * 
     * @param serializationId
     * @param inputStream
     * @param parserCallback
     * @param fileSize
     * @throws IOException
     */
    public void parse( String serializationId, InputStream inputStream, SpiParserCallback parserCallback, long fileSize ) throws IOException;
}