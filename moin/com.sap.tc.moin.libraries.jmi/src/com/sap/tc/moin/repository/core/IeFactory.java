package com.sap.tc.moin.repository.core;

import java.io.InputStream;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;

/**
 * Factory for accessing an instance of {@link ModelImporter} or
 * {@link ModelExporter}.
 */
public abstract class IeFactory {

    /**
     * Returns a Model Importer.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * If you use a Model Importer instance in different threads. The Model
     * Importer instance will serialize the import calls. Therefore we recommend
     * to use different Model Importer instances in different threads.
     * 
     * @param configuration configuration of the model importer, you get an
     * instance via
     * {@link XmParserConfiguration#getInstance(com.sap.tc.moin.repository.xm.parser.XmParserHandler, javax.xml.validation.Schema, com.sap.tc.moin.repository.xm.parser.ParserErrorHandler)}
     * @param connection MOIN connection (wrapped connection!)
     * @return model importer
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract ModelImporter getModelImporter( XmParserConfiguration configuration, Connection connection );

    /**
     * Returns a Model Exporter.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * If you use a Model Exporter instance in different threads. The Model
     * Exporter instance will serialize the export calls. Therefore we recommend
     * to use different Model Exporter instances in different threads.
     * 
     * @param configuration configuration of the model importer, you get an
     * instance via
     * {@link XmSerializerConfiguration#getInstance(Class, InputStream)}
     * @param connection MOIN connection (wrapped connection!)
     * @return model exporter
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract ModelExporter getModelExporter( XmSerializerConfiguration configuration, Connection connection );


}
