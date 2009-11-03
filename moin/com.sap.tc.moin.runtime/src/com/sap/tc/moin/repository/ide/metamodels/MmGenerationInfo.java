package com.sap.tc.moin.repository.ide.metamodels;

import java.io.File;
import java.util.Properties;

public final class MmGenerationInfo extends MmExecutableInfo {

    private File jmiDirectory;

    private File outputLocation;

    private Properties metamodelProperties;

    private File[] metamodelPartitionFiles;


    public MmGenerationInfo( String sourcePath, File[] metamodelPartitionFiles, File jmiDirectory, File outputLocation, Properties metamodelProperties, boolean generateMof, boolean ignoreMetamodelChecks ) {

        super( sourcePath, metamodelProperties != null ? metamodelProperties.getProperty( MmGenerator.CONTAINER ) : null, generateMof, ignoreMetamodelChecks );
        init( metamodelPartitionFiles, jmiDirectory, outputLocation, metamodelProperties );
    }

    private void init( File[] metamodelPartitionFiles, File jmiDirectory, File outputLocation, Properties metamodelProperties ) {

        this.metamodelPartitionFiles = metamodelPartitionFiles;
        this.jmiDirectory = jmiDirectory;
        this.outputLocation = outputLocation;
        this.metamodelProperties = metamodelProperties;

    }

    public File getJmiDirectory( ) {

        return this.jmiDirectory;
    }

    public File getOutputLocation( ) {

        return this.outputLocation;
    }

    public Properties getMetamodelProperties( ) {

        return this.metamodelProperties;
    }

    public File[] getMetamodelPartitionFiles( ) {

        return metamodelPartitionFiles;
    }
}