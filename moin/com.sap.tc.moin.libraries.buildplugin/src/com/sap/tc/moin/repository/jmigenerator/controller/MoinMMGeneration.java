package com.sap.tc.moin.repository.jmigenerator.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecord;
import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecordReaderWriter;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The meta model build
 */
public final class MoinMMGeneration {

    private static final String SLASH = "/"; //$NON-NLS-1$

    /**
     * Generation Mode
     */
    public static enum JmiGenerationMode {
        /**
         * Generation of the client API
         */
        API,
        /**
         * Generation of the implementation classes
         */
        IMPL,
        /**
         * Complete generation
         */
        ALL
    }

    private static final TimerCallback DO_NOTHING_TIMER_CALLBACK = new DoNothingTimerCallback( );

    private static final LogCallback DO_NOTHING_LOG_CALLBACK = new DoNothingLogCallback( );

    private String destPathJmi = null;

    private TimerCallback timerCallback;

    private LogCallback logCallback;

    private boolean generateMof = false;

    private boolean ignoreMetaModelCheck = false;

    private JmiGenerationMode generationMode = JmiGenerationMode.ALL;

    private Map<String, File> directories = new HashMap<String, File>( );

    private String metamodelContainer = null;

    private Set<List<String>> generatedPathFragments = Collections.emptySet( );

    /**
     * @param actTimer
     * @param actLog
     */
    public MoinMMGeneration( TimerCallback actTimer, LogCallback actLog ) {

        if ( actTimer == null ) {
            this.timerCallback = DO_NOTHING_TIMER_CALLBACK;
        } else {
            this.timerCallback = actTimer;
        }

        if ( actLog == null ) {
            this.logCallback = DO_NOTHING_LOG_CALLBACK;
        } else {
            this.logCallback = actLog;
        }

    }

    /**
     * @param connection
     * @param dataAreaDescriptor
     */
    public void execute( Connection connection, DataAreaDescriptor dataAreaDescriptor ) {

        if ( this.metamodelContainer == null ) {
            JmiGeneratorRuntimeException ex = new JmiGeneratorRuntimeException( JmiGeneratorTraces.MMCONSTAINTERNOTSPECIFIED );
            this.logCallback.logThrowable( ex );
            throw ex;
        }

        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );

        this.timerCallback.startTimer( );

        CRI cri = connection.getSession( ).getMoin( ).createCri( dataAreaDescriptor.getFacilityId( ), dataAreaDescriptor.getDataAreaName( ), this.metamodelContainer );
        Collection<PRI> partPRIs = connection.getSession( ).getInnerPartitions( cri );

        for ( PRI pri : partPRIs ) {
            ModelPartition part = connection.getPartition( pri );

            if ( part == null ) {
                MoinLocalizedBaseRuntimeException ex = new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.PARTITIONNOTFOUND, pri );
                this.logCallback.logThrowable( ex );
                throw ex;
            }

            partitions.add( part );
        }

        this.timerCallback.endTimer( JmiGeneratorTraces.MMLOADEDTIMER.format( ) );

        this.execute( connection, partitions, this.metamodelContainer );

    }

    /**
     * @param connection
     * @param partitions
     * @param actContainer
     */
    public void execute( Connection connection, Set<ModelPartition> partitions, String actContainer ) {

        if ( actContainer != null && !actContainer.equals( "" ) ) { //$NON-NLS-1$
            this.metamodelContainer = actContainer;
        }

        MetaModelCheckerBuild metaModelChecker = null;

        // if the meta-model checks are to be ignored, apply the do nothing checker
        metaModelChecker = new DefaultMetaModelChecker( this.timerCallback, this.logCallback, this.ignoreMetaModelCheck );

        metaModelChecker.doCheck( connection, partitions );

        this.timerCallback.startTimer( );

        this.logCallback.log( JmiGeneratorTraces.JMIOUTPUT.format( getDestPathJmi( ) ) );

        JmiGenerator gen = new JmiGenerator( ( (Wrapper<CoreConnection>) connection ).unwrap( ) );
        String targetPath = getDestPathJmi( ).replace( SLASH, File.separator );

        List<JmiGeneratorModelElementWrapper> wrappers = gen.createObjectList( this.metamodelContainer, partitions );
        JmiGenerationKind[] kindFilter;
        switch ( this.generationMode ) {
            case API:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.INTERFACE };
                break;
            case IMPL:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.CLASS, JmiGenerationKind.WRAPPER };
                break;
            case ALL:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.INTERFACE, JmiGenerationKind.CLASS, JmiGenerationKind.WRAPPER };
                break;
            default:
                kindFilter = null;
                break;
        }

        generatedPathFragments = new HashSet<List<String>>( );

        if ( kindFilter != null ) {
            for ( JmiGeneratorModelElementWrapper modelElementWrapper : wrappers ) {
                List<JmiGeneratorPathCodePair> code = modelElementWrapper.createCode( kindFilter );
                for ( JmiGeneratorPathCodePair pair : code ) {
                    try {
                        this.writeFile( pair, targetPath );
                        generatedPathFragments.add( pair.getRelativePath( ) );
                    } catch ( IOException e ) {
                        this.logCallback.logThrowable( e );
                        throw new RuntimeException( e );
                    }
                }
            }

            // skip generation if no partitions are included
            if ( partitions != null && partitions.size( ) > 0 ) {
                List<JmiGeneratorPathCodePair> extensions = gen.getDeploymentExtensions( this.metamodelContainer, partitions, wrappers, kindFilter );
                for ( JmiGeneratorPathCodePair pair : extensions ) {
                    try {
                        this.writeFile( pair, targetPath );
                        generatedPathFragments.add( pair.getRelativePath( ) );
                    } catch ( IOException e ) {
                        this.logCallback.logThrowable( e );
                        throw new RuntimeException( e );
                    }
                }

                generateDeploymentExtensionIndex( partitions, targetPath, wrappers, kindFilter );
            }
        }

        this.timerCallback.endTimer( JmiGeneratorTraces.GENERATEJMITIMER.format( ) );
    }

    public Set<List<String>> getGeneratedPathFragments( ) {

        return this.generatedPathFragments;
    }

    private void generateDeploymentExtensionIndex( Set<ModelPartition> partitions, String targetPath, List<JmiGeneratorModelElementWrapper> wrappers, JmiGenerationKind[] kindFilter ) {

        Set<JmiGenerationKind> kinds = new HashSet<JmiGenerationKind>( );

        for ( int i = 0; i < kindFilter.length; i++ ) {
            kinds.add( kindFilter[i] );
        }

        if ( kinds.contains( JmiGenerationKind.CLASS ) ) {
            String indexesPrefix = targetPath + SLASH + Utilities.getMMPackageQualified( this.metamodelContainer ).replace( '.', '/' ) + SLASH;

            File indexPath = new File( indexesPrefix );

            if ( !indexPath.exists( ) ) {
                indexPath.mkdirs( );
            }

            File deploymentExtensionIndexFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.EXTENSION_INDEX_NAME );
            FileOutputStream deploymentExtensionRecordFileStream = null;

            File deploymentExtensionIndexLogFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.EXTENSION_INDEX_LOG_NAME );
            FileOutputStream deploymentExtensionIndexLogFileStream = null;

            File modelElementNamesFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.NAMES_INDEX_NAME );
            FileOutputStream modelElementNamesFileStream = null;

            try {
                if ( !deploymentExtensionIndexFile.exists( ) ) {
                    deploymentExtensionIndexFile.createNewFile( );
                }

                deploymentExtensionRecordFileStream = new FileOutputStream( deploymentExtensionIndexFile );

                if ( !deploymentExtensionIndexLogFile.exists( ) ) {
                    deploymentExtensionIndexLogFile.createNewFile( );
                }

                deploymentExtensionIndexLogFileStream = new FileOutputStream( deploymentExtensionIndexLogFile );

                if ( !modelElementNamesFile.exists( ) ) {
                    modelElementNamesFile.createNewFile( );
                }

                modelElementNamesFileStream = new FileOutputStream( modelElementNamesFile );

                Set<Partitionable> allModelElements = new HashSet<Partitionable>( );
                Set<MofClass> allClasses = new HashSet<MofClass>( );

                for ( ModelPartition partition : partitions ) {
                    allModelElements.addAll( partition.getElements( ) );

                    for ( Partitionable el : partition.getElements( ) ) {
                        if ( el instanceof MofClass ) {
                            allClasses.add( (MofClass) el );
                        }
                    }
                }

                MetaModelExtensionRecord rec = new MetaModelExtensionRecord( wrappers.size( ), wrappers.size( ), wrappers.size( ), allModelElements.size( ), allClasses.size( ) );

                // fill the partitionable based maps
                for ( Partitionable part : allModelElements ) {
                    if ( part instanceof ModelElement ) {
                        ModelElement me = (ModelElement) part;

                        rec.getMofIdToQualifiedNameMapping( ).put( part.refMofId( ), new ArrayList<String>( me.getQualifiedName( ) ) );
                    }
                }

                // fill the template based maps
                List<String> modelElementNames = new ArrayList<String>( wrappers.size( ) );
                List<String> modelElementMofIds = new ArrayList<String>( wrappers.size( ) );
                for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                    if ( wrapper.getMofType( ) != JmiGeneratorMofType.EXCEPTION ) {
                        String javaClassName = wrapper.getJavaClassName( JmiGenerationKind.CLASS, true );

                        rec.getMofIdClassNameMap( ).put( wrapper.getModelElementMofId( ), javaClassName );
                        rec.getNameClassNameMap( ).put( wrapper.getModelElementQualifiedName( ), javaClassName );

                        rec.getJmiClasses( ).add( javaClassName );

                        modelElementNames.add( wrapper.getModelElementQualifiedName( ) );
                        modelElementMofIds.add( wrapper.getModelElementMofId( ) );
                    }
                }

                // fill class based maps.
                for ( MofClass clazz : allClasses ) {
                    HashSet<String> set = new HashSet<String>( );

                    for ( GeneralizableElement gEl : clazz.allSupertypes( ) ) {
                        set.add( gEl.refMofId( ) );
                    }

                    rec.getTypeMofIdToSuperTypesMapping( ).put( clazz.refMofId( ), set );
                }

                // write the index
                MetaModelExtensionRecordReaderWriter.writeExtensionRecord( deploymentExtensionRecordFileStream, rec );
                MetaModelExtensionRecordReaderWriter.writeHumanReadableRecordLog( deploymentExtensionIndexLogFileStream, rec );
                MetaModelExtensionRecordReaderWriter.writeElementNames( modelElementNamesFileStream, modelElementMofIds );
            } catch ( IOException e ) {
                this.logCallback.logThrowable( e );
                throw new RuntimeException( e );
            } finally {
                if ( deploymentExtensionRecordFileStream != null ) {
                    try {
                        deploymentExtensionRecordFileStream.close( );
                    } catch ( IOException e ) {
                        this.logCallback.logThrowable( e );
                        throw new RuntimeException( e );
                    }
                }

                if ( deploymentExtensionIndexLogFileStream != null ) {
                    try {
                        deploymentExtensionIndexLogFileStream.close( );
                    } catch ( IOException e ) {
                        this.logCallback.logThrowable( e );
                        throw new RuntimeException( e );
                    }
                }

                if ( modelElementNamesFileStream != null ) {
                    try {
                        modelElementNamesFileStream.close( );
                    } catch ( IOException e ) {
                        this.logCallback.logThrowable( e );
                        throw new RuntimeException( e );
                    }
                }
            }
        }
    }

    /**
     * @return the destination path for the generated classes
     */
    public String getDestPathJmi( ) {

        return this.destPathJmi;
    }

    /**
     * @param actPath the path for the generated classes
     */
    public void setDestPathJmi( String actPath ) {

        this.destPathJmi = actPath;
    }

    /**
     * @param genMof in case of MOF generation, no information provider etc.
     * must be generated
     */
    public void setGenerateMof( boolean genMof ) {

        this.generateMof = genMof;
    }

    /**
     * @param executeMetaModelChecks if false, the meta model checks will be
     * executed, if true nothing will be checked.
     */
    public void setIgnoreMetamodelCheck( boolean ignoreMetaModelCheck ) {

        this.ignoreMetaModelCheck = ignoreMetaModelCheck;
    }

    /**
     * @param actGenMode
     */
    public void setGenerationMode( JmiGenerationMode actGenMode ) {

        this.generationMode = actGenMode;
    }

    public void setMetaModelContainer( String metamodelContainer ) {

        this.metamodelContainer = metamodelContainer;
    }

    private void writeFile( JmiGeneratorPathCodePair pair, String targetPath ) throws IOException {

        String code = pair.getCode( );
        StringBuilder fullpath = new StringBuilder( targetPath );
        for ( String comp : pair.getRelativePath( ) ) {
            fullpath.append( File.separator );
            fullpath.append( comp );
        }

        File directory = this.directories.get( fullpath.toString( ) );
        if ( directory == null || !directory.exists( ) ) {
            directory = new File( targetPath );
            for ( String dir : pair.getRelativePath( ) ) {
                String[] subdirs = directory.list( );
                if ( subdirs == null ) {
                    File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                    childDirectory.mkdirs( );
                    directory = childDirectory;
                    continue;
                }
                boolean found = false;
                for ( int i = 0; i < subdirs.length; i++ ) {
                    if ( subdirs[i].equals( dir ) ) {
                        directory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                        found = true;
                        continue;
                    }
                }
                if ( !found ) {
                    File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                    childDirectory.mkdirs( );
                    directory = childDirectory;
                    continue;
                }

            }

            this.directories.put( fullpath.toString( ), directory );

        }

        String filepath = directory.getPath( ) + File.separator + pair.getFileName( ) + '.' + pair.getFileExtension( );
        File prog = new File( filepath );
        prog.createNewFile( );

        FileWriter w = null;
        BufferedWriter bw = null;
        try {
            w = new FileWriter( prog );
            bw = new BufferedWriter( w );
            bw.write( code );
        } finally {
            if ( bw != null ) {
                bw.close( );
            }

            if ( w != null ) {
                w.close( );
            }
        }
    }
}
