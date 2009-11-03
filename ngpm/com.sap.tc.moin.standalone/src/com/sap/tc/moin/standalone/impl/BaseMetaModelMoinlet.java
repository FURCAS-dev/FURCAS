package com.sap.tc.moin.standalone.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationAdaptorFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider.Scenario;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;

/**
 * Moinlet for operations in the meta-model build/generation context.
 * 
 * @author D046220
 */
public abstract class BaseMetaModelMoinlet extends AbstractMoinlet implements com.sap.tc.moin.standalone.Moinlet {

    private String dcName;

    private String[] arguments;

    public abstract void executeFunctionality( String[] arguments, Moin moin, Connection conn, String dataArea, String dcName );

    public void execute( Moin moin, CompoundClientSpec clientSpec ) {

        Connection conn = createConnection( moin, clientSpec );

        executeFunctionality( arguments, moin, conn, MoinBuildConstants.DEFAULT_DATA_AREA_NAME, dcName );

    }

    public IpiDiConfigurationProvider getDiConfigurationProvider( String[] arguments ) {

        this.arguments = arguments;
        this.dcName = getDcName( arguments );

        return getDiProvider( new File( getSourcePath( arguments ) ), getReferencedModelJars( arguments ), "sap.com", this.dcName );
    }

    private IpiDiConfigurationProvider getDiProvider(File sourcePath, String[] modelsRequiredPath, String vendor,
        String dc) {
        IpiDiDcDefinitionProvider dcDefinitionProvider = null;

        if (sourcePath == null) {
            throw new RuntimeException("Source path has not been specified.");
        }

        IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory = new IpiDiConfigurationAdaptorFactoryImpl();

        dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor(vendor, dc, sourcePath
            .getAbsolutePath());

        List<IpiDiDcDefinitionProvider> definitionProviders = new LinkedList<IpiDiDcDefinitionProvider>();

        definitionProviders.add(dcDefinitionProvider);

        ZipFile zip = null;

        try {
            if (modelsRequiredPath != null) {
                for (String path : modelsRequiredPath) {
                    zip = new ZipFile(path);
                    if (isMetamodelArchive(zip)) {
                        _DcDataRecord dr = readDcDataRecord(zip);

                        dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor(dr.dcVendor,
                            dr.dcName, Collections.singletonList(path));

                        definitionProviders.add(dcDefinitionProvider);
                    }
                    zip.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        IpiDiConfigurationProvider diConfigurationProvider = diAdaptorFactory.getMetaModelDiConfigurationAdaptor(
            Scenario.BUILD_SCENARIO, MoinBuildConstants.DEFAULT_DATA_AREA_NAME, definitionProviders);

        return diConfigurationProvider;

    }

    private boolean isMetamodelArchive(ZipFile archive) {
        Enumeration<? extends ZipEntry> entries = archive.entries();
        if (entries == null) {
            return false;
        }
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().equals("moin/meta/")) {
                return true;
            }
        }
        return false;
    }

    private _DcDataRecord readDcDataRecord( ZipFile zip ) {

        _DcDataRecord ret = new _DcDataRecord( );

        try {
            ZipEntry entry = zip.getEntry( "metamodel.properties" );

            if ( entry == null ) {
                throw new RuntimeException( "metamodel.properties has not been found in " + zip.getName( ) + "." );
            }

            InputStream is = zip.getInputStream( entry );
            Properties props = new Properties( );
            props.load( is );

            ret.dcName = props.getProperty( "metamodelId" );

            if ( ret.dcName == null ) {
                throw new RuntimeException( "Meta-model id has not been defined in " + zip.getName( ) );
            }

            ret.dcVendor = props.getProperty( "vendor" );

            if ( ret.dcVendor == null ) {
                throw new RuntimeException( "Meta-model vendor has not been defined in " + zip.getName( ) );
            }

            return ret;
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    private static class _DcDataRecord {

        public String dcName;

        public String dcVendor;
    }

}
