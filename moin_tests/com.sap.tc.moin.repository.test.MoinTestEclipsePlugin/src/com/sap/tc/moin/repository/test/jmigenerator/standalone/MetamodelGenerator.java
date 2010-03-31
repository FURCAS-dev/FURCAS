package com.sap.tc.moin.repository.test.jmigenerator.standalone;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.DeploymentFilesGeneration;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.jmigenerator.controller.DefaultMetaModelChecker;
import com.sap.tc.moin.repository.jmigenerator.controller.LogCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.MetaModelCheckerBuild;
import com.sap.tc.moin.repository.jmigenerator.controller.TimerCallback;

public class MetamodelGenerator {

    private String rootFolder;

    private MetaModelCheckerBuild metamodelChecker = null;

    public MetamodelGenerator( String aRootFolder, TimerCallback timerCallback, LogCallback logCallback ) {

        if ( aRootFolder == null ) {
            throw new IllegalArgumentException( "No root output folder specified!" );
        }
        rootFolder = aRootFolder;
        metamodelChecker = new DefaultMetaModelChecker( timerCallback, logCallback, true );
    }

    public String getRootFolder( ) {

        return rootFolder;
    }

    List<JmiGeneratorPathCodePair> generate( CoreConnection conn, String containerName, JmiGenerationKind[] jmiGenerationKinds ) throws Exception {

        List<JmiGeneratorPathCodePair> pathCodePair = new ArrayList<JmiGeneratorPathCodePair>( );
        DataAreaDescriptor dataArea = conn.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelDataArea( ).getDescriptor( );
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        CRI cri = conn.getSession( ).getMoin( ).createCri( dataArea.getFacilityId( ), dataArea.getDataAreaName( ), containerName );
        Collection<PRI> partitionPrisInContainer = conn.getSession( ).getInnerPartitions( cri );
        if ( partitionPrisInContainer.size( ) != 0 ) {
            for ( PRI pri : partitionPrisInContainer ) {
                partitions.add( conn.getPartition( pri ) );
            }
            String targetSourcePath = getTargetSourcePath( containerName );
            deleteDir( new File( targetSourcePath ) );
            metamodelChecker.doCheck( conn.getWrapper( ), partitions );
            generateDeploymentFiles( targetSourcePath, containerName );
            pathCodePair = generateCode( conn, targetSourcePath, containerName, partitions, true, jmiGenerationKinds );
        } else {
            // no generation, also no generation of deployment extension
        }
        return pathCodePair;
    }

    protected String getTargetContainerPath( String containerName ) {

        return rootFolder + File.separator + convertToPathName( containerName );
    }

    public String getTargetSourcePath( String containerName ) {

        return getTargetContainerPath( containerName ) + File.separator + "src";
    }

    protected List<JmiGeneratorPathCodePair> generateCode( CoreConnection conn, String targetPath, String containerName, Set<ModelPartition> partitions, boolean generateDeploymentExtension, JmiGenerationKind... kindFilter ) {

        System.setProperty( "targetPath", targetPath );
        JmiGenerator generator = new JmiGenerator( conn );
        List<JmiGeneratorPathCodePair> pathCodePairs = new ArrayList<JmiGeneratorPathCodePair>( );
        try {
            List<JmiGeneratorModelElementWrapper> wrappers = generator.createObjectList( containerName, partitions );
            for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                pathCodePairs.addAll( wrapper.createCode( kindFilter ) );
            }
            if ( generateDeploymentExtension ) {
                pathCodePairs.addAll( generator.getDeploymentExtensions( containerName, partitions, wrappers, kindFilter ) );
            }
            for ( JmiGeneratorPathCodePair pathCodePair : pathCodePairs ) {
                writeCode( pathCodePair, targetPath );
            }
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
        return pathCodePairs;
    }

    private void generateDeploymentFiles( String targetPath, String containerName ) throws IOException {

        DeploymentFilesGeneration deploymentFilesGenerator = new DeploymentFilesGeneration( );
        String vendorName = containerName.split( "/" )[0];
        String metamodelName = containerName.substring( vendorName.length( ) + 1, containerName.length( ) );
        deploymentFilesGenerator.setPropertiesFileName( "metamodel.properties" );
        deploymentFilesGenerator.setDcVersion( "0" );
        deploymentFilesGenerator.setDcName( metamodelName );
        deploymentFilesGenerator.setDcDescription( metamodelName );
        deploymentFilesGenerator.setDcVendor( vendorName );
        deploymentFilesGenerator.setXmiDir( targetPath );
        HashMap<String, String> xmiList = new HashMap<String, String>( 1 );
        xmiList.put( "moin/meta/myTestMetamodel.moinmm", ( (Long) System.currentTimeMillis( ) ).toString( ) );
        deploymentFilesGenerator.setXmiList( xmiList );
        deploymentFilesGenerator.setFacilityName( "PF" );
        deploymentFilesGenerator.execute( );
    }

    private void writeCode( JmiGeneratorPathCodePair pair, String targetPath ) throws Exception {

        StringBuilder hierarchy = new StringBuilder( );
        for ( String dir : pair.getRelativePath( ) ) {
            hierarchy.append( File.separatorChar ).append( dir );
        }
        String absolutePath = targetPath + hierarchy;
        new File( absolutePath ).mkdirs( );
        String fileName = absolutePath + File.separator + pair.getFileName( ) + "." + pair.getFileExtension( );
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( fileName ), "UTF-8" ) );
        try {
            writer.write( pair.getCode( ) );
        } finally {
            writer.close( );
        }
    }

    protected boolean deleteDir( File dir ) {

        if ( dir.isDirectory( ) ) {
            String[] children = dir.list( );
            for ( int i = 0; i < children.length; i++ ) {
                boolean success = deleteDir( new File( dir, children[i] ) );
                if ( !success ) {
                    return false;
                }
            }
        }
        return dir.delete( );
    }

    private String convertToPathName( String containerName ) {

        return containerName.replace( '/', '~' ).replaceFirst( "sap.com~", "_" );
    }
}