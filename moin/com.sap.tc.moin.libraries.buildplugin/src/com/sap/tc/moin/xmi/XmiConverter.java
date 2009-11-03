package com.sap.tc.moin.xmi;

import static com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl.JMI_TAG_ID_IS_STRUCTURE_TYPE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.VisibilityKind;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.AttributeInitializerConstraint;
import org.omg.ocl.attaching.InitializedElement;
import org.omg.ocl.attaching.OclConstraint;

import com.sap.tc.moin.mmimport.MetamodelImporter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiInstantiator;
import com.sap.tc.moin.repository.core.ModelPartitionWrapper;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.controller.DefaultMetaModelChecker;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingTimerCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.LogCallback;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.shared.util.XmiPatcherForUnisysPlugin;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Utility for converting rose XMLs into MOIN partition XMIs. The tool patches
 * the rose XMLs and converts them into MOIN partition XMIs. In addition, the
 * tool creates the necessary japro build files.
 */
public class XmiConverter {

    private static final String _COMP = "_comp"; //$NON-NLS-1$

    private static final String MOIN_META = "/moin/meta"; //$NON-NLS-1$

    /**
     * Logging location for this class
     */
    private static com.sap.tc.logging.Location location = null;

    static {
        location = com.sap.tc.logging.Location.getLocation( XmiConverter.class );
    }

    public static final String MM_IMPORT_CLIENT_ID = "metamodel_import"; //$NON-NLS-1$

    public static final String MM_IMPORT_USER_ID = "metamodel_importer"; //$NON-NLS-1$

    public static final String MM_IMPORT_USER_PW = "metamodel_importer"; //$NON-NLS-1$

    private static final String XML_FILE_SUFFIX = ".xml"; //$NON-NLS-1$

    private static final String PROPERTIES_FILE_SUFFIX = ".properties"; //$NON-NLS-1$

    private static final String PROJECT_SOURCE = "/mmr/meta/"; //$NON-NLS-1$

    private static final String PROJECT_TARGET = "/"; //$NON-NLS-1$

    private static final String VERSION_FILE_NAME = "version.info"; //$NON-NLS-1$

    private static final String INITIAL_VERSION = "1.0.0"; //$NON-NLS-1$

    private Moin moin;

    private boolean verbose;

    private boolean convertMof;

    private long duration;

    private long totalDuration = 0;

    private String projectPath = null;

    private boolean patchDisabled = false;

    private Connection connection;

    private boolean ignoreCheck;

    /**
     * Overridden log method from ANT.
     */
    public static void log( String message ) {

        location.infoT( message );
        System.out.println( message );
    }

    /**
     * Overridden log method from ANT.
     */
    public static void logThrowable( Throwable throwable ) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream( );
        PrintWriter writer = new PrintWriter( bos );
        throwable.printStackTrace( writer );
        writer.flush( );
        try {
            log( bos.toString( "UTF-8" ) ); //$NON-NLS-1$
        } catch ( UnsupportedEncodingException e ) {
            // $JL-EXC$
        }
    }

    /**
     * If "verbose" is set, store the current time in {@link #duration}.
     */
    private void startTimer( ) {

        if ( verbose ) {
            duration = System.currentTimeMillis( );
        }
    }

    /**
     * If "verbose" is set, compute the duration, log it with the given message
     * and add it to the total runtime.
     */
    private void endTimer( String actionPerformed ) {

        if ( verbose ) {
            duration = System.currentTimeMillis( ) - duration;
            log( actionPerformed + " ... done (" + duration + " ms)" ); //$NON-NLS-1$ //$NON-NLS-2$
            totalDuration += duration;
        }
    }

    public XmiConverter( Moin moin, Connection connection, String projectPath, boolean verbose, boolean patchDisabled, boolean doConvertMof ) {

        this( moin, connection, projectPath, verbose, patchDisabled, doConvertMof, false );
    }

    public XmiConverter( Moin moin, Connection connection, String projectPath, boolean verbose, boolean patchDisabled, boolean doConvertMof, boolean ignoreMetamodelCheckFailure ) {

        init( moin, connection, projectPath, verbose, patchDisabled, doConvertMof, ignoreMetamodelCheckFailure );

    }

    private void init( Moin moin, Connection connection, String projectPath, boolean verbose, boolean patchDisabled, boolean doConvertMof, boolean ignoreMetamodelCheckFailure ) {

        this.convertMof = doConvertMof;
        this.verbose = verbose;
        this.projectPath = projectPath;
        this.patchDisabled = patchDisabled;

        // check project path
        if ( !new File( this.getFullSourcePath( "" ) ).exists( ) ) { //$NON-NLS-1$
            error( this.projectPath + " is not a valid project." ); //$NON-NLS-1$
        }

        this.moin = moin;
        this.connection = connection;

        this.ignoreCheck = ignoreMetamodelCheckFailure;
    }

    /**
     * Does the conversion.
     */
    public void run( ) throws Exception {

        // load the import configuration file
        Configuration configuration = loadImportConfiguration( this.projectPath );
        this.run( configuration );
    }

    public void run( Configuration configuration ) throws Exception {

        try {

            // patch files with regular expressions
            if ( !patchDisabled ) {
                this.patchFiles( );
            }

            // perform the import of the patched XMI file
            Collection<ModelPartition> partitions = importXmiFiles( connection, configuration.getImportProperties( ), configuration.getXmlFile( ) );

            // patch the repository content
            // set isRoot = isLeaf = true for all Packages, Associations and DataTypes (except StructureTypes)
            this.patchIsRootIsLeaf( connection, partitions );
            // The ImportingRepositoryService automatically converts a Class into a StructureType if there exists an
            // old StructureType with the same qualified name. The result is a StructureType with the content of the Class
            // that was converted. In this case we have to convert the StructureType content because it still contains
            // Attributes for example that need to be converted into StructureFields.
            // In the case where one converts for the first time, i.e. no old StructureType with the same qualified name
            // exists, we have to convert as well the Classes as the Attributes.
            this.convertClasses2Structures( connection, partitions );
            // delete the obsolete indicators for StructureTypes
            // Note that the tags can not be deleted because in the federation use case they are expected to be present in the federated metamodel if they are present in the XMI file
//            this.deleteIsStructureTypeTags( connection, partitions );

            // success messages
            for ( ModelPartition p : partitions ) {
                log( "Converted Partition: " + p.getPri( ) ); //$NON-NLS-1$
            }

            // check the metamodel
            try {

                if ( this.ignoreCheck ) {
                    log( "Metamodel check results will be ignored." ); //$NON-NLS-1$
                }

                Set<ModelPartition> partitionSet = new HashSet<ModelPartition>( partitions );
                this.checkMetamodel( connection, partitionSet );

            } catch ( RuntimeException ex ) {

                if ( this.ignoreCheck ) {
                    logThrowable( ex );
                    log( "Metamodel check failed. Will be ignored." ); //$NON-NLS-1$
                } else {
                    error( "Metamodel check failed.", ex ); //$NON-NLS-1$
                }
            }

            commitChanges( connection );

            // update version at last
            this.updateVersion( );

            log( "Conversion successfully finished." ); //$NON-NLS-1$

        } catch ( Throwable ex ) {
            // log exception since this is not done properly in japro
            logThrowable( ex );
            throw new Exception( ex );
        } finally {
            if ( connection != null ) {
                connection.close( );
            }
        }
    }

    private void checkMetamodel( Connection connection, Set<ModelPartition> partitions ) {

        LogCallback loggerCallback = new LogCallback( ) {

            public void logWarn( String message ) {

                XmiConverter.log( "[Warning] " + message ); //$NON-NLS-1$
            }

            public void logThrowable( Throwable throwable ) {

                XmiConverter.logThrowable( throwable );
            }

            public void logInfo( String message ) {

                XmiConverter.log( "[Info] " + message ); //$NON-NLS-1$
            }

            public void log( String message ) {

                XmiConverter.log( message );
            }

            public void logError( String message ) {

                XmiConverter.log( "[Error] " + message ); //$NON-NLS-1$
            }

        };

        DefaultMetaModelChecker metaModelChecker = new DefaultMetaModelChecker( new DoNothingTimerCallback( ), loggerCallback, this.ignoreCheck );

        metaModelChecker.doCheck( connection, partitions );
    }

    private void updateVersion( ) throws IOException {

        String targetPath = this.getFullTargetPath( VERSION_FILE_NAME );

        File targetFile = new File( targetPath );

        String targetVersion = null;

        if ( targetFile.exists( ) ) {
            RandomAccessFile versionFile = new RandomAccessFile( targetFile, "r" ); //$NON-NLS-1$
            targetVersion = versionFile.readLine( );

            versionFile.close( );
        }

        byte[] content = INITIAL_VERSION.getBytes( "UTF-8" ); //$NON-NLS-1$
        String sourceVersion = INITIAL_VERSION;

        try {
            InputStream source = new FileInputStream( this.getFullSourcePath( VERSION_FILE_NAME ) );
            content = new byte[source.available( )];
            source.read( content );
            sourceVersion = new String( content, "UTF-8" ); //$NON-NLS-1$
            source.close( );
        } catch ( FileNotFoundException ex ) {
            log( "Version file not found in " + this.getFullSourcePath( VERSION_FILE_NAME ) ); //$NON-NLS-1$
        }

        try {
            if ( ( targetVersion == null ) || ( targetVersion.compareTo( sourceVersion ) < 0 ) ) {
                FileOutputStream target = new FileOutputStream( this.getFullTargetPath( VERSION_FILE_NAME ) );
                target.write( content );
                target.close( );
            }
        } catch ( FileNotFoundException ex ) {
            // does not matter - most probably because of the new format
            log( "Version file not created since new metamodel project format is used." ); //$NON-NLS-1$
        }

    }

    /**
     * Loads the import configuration file defining the partition mapping and
     * the source status of each XMI file.
     */
    public static Configuration loadImportConfiguration( String projectPath ) {

        String propertyFile = findPropertyFile( getFullSourcePath( "", projectPath ) ); //$NON-NLS-1$
        return loadImportConfigurationFromPropertyFile( propertyFile );
    }

    public static Configuration loadImportConfigurationFromPropertyFile( String propertyFile ) {

        String xmlFile = null;
        Properties importProperties = null;
        Properties firstPropertyLine = null;
        // try to find config file
        try {
            xmlFile = getXmlFileNameFromConfigFileName( propertyFile );
            importProperties = loadConfigurationFromFile( propertyFile );

            // first property must be read from file to really get the first
            // line
            firstPropertyLine = loadFirstPropertyFromFile( propertyFile );

        } catch ( IOException ex ) {
            error( "Loading of configuration from property file " + propertyFile + " failed.", ex ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        String dcVendor = null;
        String dcName = null;
        String label = null;
        String dataArea = null;

        // parse and patch first property line - line has not yet been patched
        // since it is loaded directly from the file
        if ( !firstPropertyLine.isEmpty( ) ) {
            String firstEntry = (String) firstPropertyLine.values( ).iterator( ).next( );
            String priString = firstEntry.split( "," )[0]; //$NON-NLS-1$
            String patchedPriString = createPatchedPriString( priString );

            String dcString = patchedPriString.substring( patchedPriString.indexOf( "DCs/" ) + 4 ); //$NON-NLS-1$
            dcString = dcString.substring( 0, dcString.indexOf( "/_comp" ) ); //$NON-NLS-1$

            String[] dcParts = dcString.split( "/", 2 ); //$NON-NLS-1$
            dcVendor = dcParts[0];
            dcName = dcParts[1];
            dataArea = patchedPriString.substring( 0, patchedPriString.indexOf( ":" ) ); //$NON-NLS-1$
            dataArea = dataArea.substring( dataArea.indexOf( "." ) + 1 ); //$NON-NLS-1$

            label = patchedPriString.substring( patchedPriString.indexOf( "/_comp/" ) + 7 ); //$NON-NLS-1$
        } else {
            error( "Configuration file is empty." ); //$NON-NLS-1$
        }

        log( "Configuration successfully read." ); //$NON-NLS-1$

        return new Configuration( xmlFile, importProperties, dataArea, dcName, dcVendor, label );
    }

    public static String findPropertyFile( String projectPath ) {

        // try to find property files
        File sourceFolder = new File( projectPath );
        final ArrayList<String> allPropertyFiles = new ArrayList<String>( );
        sourceFolder.list( new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                if ( name.endsWith( PROPERTIES_FILE_SUFFIX ) ) {
                    String canonicalPath;
                    try {
                        canonicalPath = dir.getCanonicalPath( ) + File.separator + name;
                        allPropertyFiles.add( canonicalPath );
                        return true;
                    } catch ( IOException e ) {
                        return false;
                    }

                }
                return false;
            }

        } );

        if ( allPropertyFiles.size( ) == 0 ) {
            error( "Import property file missing." ); //$NON-NLS-1$
        } else if ( allPropertyFiles.size( ) > 1 ) {
            error( "More than one property file." ); //$NON-NLS-1$
        }
        return allPropertyFiles.get( 0 );
    }

    private static String createPatchedPriString( String priString ) {

        String patchedPriString = priString;
        if ( priString.indexOf( MOIN_META ) < 0 ) {
            // insert /moin/meta
            patchedPriString = priString.replace( _COMP, _COMP + MOIN_META );
        }
        if ( !patchedPriString.endsWith( MetaModelCatalog.META_MODEL_EXTENSION ) ) {
            patchedPriString += MetaModelCatalog.META_MODEL_EXTENSION;
        }
        return patchedPriString;
    }

    private static String getXmlFileNameFromConfigFileName( String configFileName ) {

        return configFileName.substring( 0, configFileName.length( ) - PROPERTIES_FILE_SUFFIX.length( ) ) + XML_FILE_SUFFIX;
    }

    /**
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static Properties loadConfigurationFromFile( String configurationFile ) throws IOException, FileNotFoundException {

        Properties configuration;
        configuration = new Properties( );

        String fullConfigPath = configurationFile;

        configuration.load( new FileInputStream( fullConfigPath ) );

        // Fix current problem with new resource folder "moin/meta" for
        // metamodels
        // by adding a folder "moin/meta" after the "_comp" separator.
        Properties patchedConfiguration = new Properties( );

        // fix moin meta
        for ( Iterator it = configuration.keySet( ).iterator( ); it.hasNext( ); ) {
            String key = (String) it.next( );
            String value = configuration.getProperty( key );
            String[] options = value.split( "," ); //$NON-NLS-1$
            // Perform a simple sanity check of the options.
            if ( options.length != 2 ) {
                throw new MoinLocalizedBaseRuntimeException( MoinXmiMessages.ILLEGALNUMBEROFTOKENSINPROPERTY, key );
            }
            if ( !options[1].equalsIgnoreCase( "true" ) && !options[1].equalsIgnoreCase( "false" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                throw new MoinLocalizedBaseRuntimeException( MoinXmiMessages.SECONDOPTIONINPROPERTYMUSTBETRUEORFALSE, key );
            }
            StringBuilder patchedValue = new StringBuilder( );

            patchedValue.append( createPatchedPriString( options[0] ) );

            patchedValue.append( "," ); //$NON-NLS-1$
            patchedValue.append( options[1] );

            patchedConfiguration.put( key, patchedValue.toString( ) );
        }

        return patchedConfiguration;
    }

    /**
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static Properties loadFirstPropertyFromFile( String configurationFile ) throws IOException, FileNotFoundException {

        Properties configuration;
        configuration = new Properties( );

        String fullConfigPath = configurationFile;

        RandomAccessFile file = new RandomAccessFile( fullConfigPath, "r" ); //$NON-NLS-1$

        String firstPropertyLine = file.readLine( );
        configuration.load( new ByteArrayInputStream( firstPropertyLine.getBytes( "UTF-8" ) ) ); //$NON-NLS-1$
        while ( configuration.isEmpty( ) ) {
            firstPropertyLine = file.readLine( );
            configuration.load( new ByteArrayInputStream( firstPropertyLine.getBytes( "UTF-8" ) ) ); //$NON-NLS-1$
        }

        return configuration;
    }

    private String getFullSourcePath( String path ) {

        return getFullSourcePath( path, this.projectPath );
    }

    public static String getFullSourcePath( String path, String projectPath ) {

        return projectPath + PROJECT_SOURCE + path;
    }

    private String getFullTargetPath( String path ) {

        return this.projectPath + MOIN_META + PROJECT_TARGET + path;
    }

    /**
     * Imports the given main XMI document and returns the collection of all
     * partitions flagged as "isSource=true".
     */
    private Collection importXmiFiles( Connection connection, Properties configuration, String xmlFile ) throws IOException, MalformedXMIException {

        Collection sourcePartitions = null;

        File file = new File( xmlFile );
        startTimer( );
        sourcePartitions = MetamodelImporter.run( moin, connection, file, configuration, this.convertMof );
        endTimer( "Importing " + file.getAbsolutePath( ) ); //$NON-NLS-1$
        log( file.getAbsolutePath( ) + " imported." ); //$NON-NLS-1$
        return sourcePartitions;
    }

    private void patchFiles( ) throws IOException {

        File projectDirectory = new File( this.getFullSourcePath( "" ) ); //$NON-NLS-1$
        String[] allXmlFiles = projectDirectory.list( new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                return ( name.endsWith( XML_FILE_SUFFIX ) );
            }

        } );

        for ( String xmlFile : allXmlFiles ) {
            patchXmlFile( this.getFullSourcePath( xmlFile ) );
        }

    }

    private void convertClasses2Structures( Connection connection, Collection<ModelPartition> partitions ) {

        // walk through the partitions and collect the elements to patch and to convert
        List<MofClass> classesToConvertToStructureTypes = new ArrayList<MofClass>( 1 );
        List<Attribute> attributesToDelete = new ArrayList<Attribute>( 1 );
        List<StructureType> structuresToPatch = new ArrayList<StructureType>( 1 );
        for ( Iterator<ModelPartition> partitionIterator = partitions.iterator( ); partitionIterator.hasNext( ); ) {
            ModelPartition partition = partitionIterator.next( );
            Collection<Partitionable> elements = partition.getElements( );
            for ( Iterator<Partitionable> elementIterator = elements.iterator( ); elementIterator.hasNext( ); ) {
                Partitionable partitionable = elementIterator.next( );
                // search the Tag that tagges our Classes or StructureTypes
                if ( partitionable instanceof Tag && ( (Tag) partitionable ).getTagId( ).equals( JMI_TAG_ID_IS_STRUCTURE_TYPE ) ) {
                    Tag isStructureTypeTag = (Tag) partitionable;
                    Collection<ModelElement> taggedElements = isStructureTypeTag.getElements( );
                    for ( Iterator<ModelElement> taggedElementIterator = taggedElements.iterator( ); taggedElementIterator.hasNext( ); ) {
                        ModelElement taggedElement = taggedElementIterator.next( );
                        if ( taggedElement instanceof MofClass ) {
                            // classes to convert to StructureTypes
                            classesToConvertToStructureTypes.add( (MofClass) taggedElement );
                        } else if ( taggedElement instanceof StructureType ) {
                            // StructureTypes to patch
                            structuresToPatch.add( (StructureType) taggedElement );
                        }
                    }
                }
            }
        }
        // Classes to convert to StructureTypes
        // Note that we only need to recreate those association links that have storage on the sides of the converted Classes and Attributes
        // because these are deleted together with the Class and Attribute resp. All other association links are recreated automatically after
        // the StructureTypes and StructureFields are created with the same MOF IDs as the Classes and Attributes.
        // get the Model package, the OCL package and some Associations
        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        OclPackage oclPackage = connection.getPackage( OclPackage.PACKAGE_DESCRIPTOR );
        Contains contains = modelPackage.getContains( );
        IsOfType isOfType = modelPackage.getIsOfType( );
        Generalizes generalizes = modelPackage.getGeneralizes( );
        AttributeInitializerConstraint attributeInitializerConstraint = oclPackage.getAttaching( ).getAttributeInitializerConstraint( );
        InitializedElement initializedElement = oclPackage.getAttaching( ).getInitializedElement( );
        // collect all necessary information for the creation of the structures
        List<Map<MRI, MRI>> containsToAdd = new ArrayList<Map<MRI, MRI>>( );
        List<Map<MRI, MRI>> isOfTypeToAdd = new ArrayList<Map<MRI, MRI>>( );
        List<Map<MRI, MRI>> generalizesToAdd = new ArrayList<Map<MRI, MRI>>( );
        List<Map<MRI, MRI>> attributeInitializerConstraintToDelete = new ArrayList<Map<MRI, MRI>>( );
        List<Map<MRI, MRI>> initializedElementToAdd = new ArrayList<Map<MRI, MRI>>( );
        List<Map<String, Object>> propertiesForStructureTypes = new ArrayList<Map<String, Object>>( classesToConvertToStructureTypes.size( ) );
        List<Map<String, Object>> propertiesForStructureFields = new ArrayList<Map<String, Object>>( );
        for ( MofClass classToConvert : classesToConvertToStructureTypes ) {
            // split the content of the class into Attributes, Constraints and Tags, delete the rest
            // the Attributes are needed for the conversion into StructureFields and are deleted separately
            // the Constraints and Tags are linked to the created StructureTypes
            List<ModelElement> containedElementsToDelete = new ArrayList<ModelElement>( );
            List<Attribute> attributesToConvertToStructureFields = new ArrayList<Attribute>( 1 );
            for ( ModelElement modelElement : classToConvert.getContents( ) ) {
                if ( modelElement instanceof Attribute ) {
                    attributesToConvertToStructureFields.add( (Attribute) modelElement );
                } else if ( modelElement instanceof Constraint ) {
                } else if ( modelElement instanceof Tag ) {
                } else if ( modelElement instanceof AliasType ) {
                } else {
                    containedElementsToDelete.add( modelElement );
                }
            }
            // delete the obsolete contents and its composite children
            for ( ModelElement containedElementToDelete : containedElementsToDelete ) {
                containedElementToDelete.refDelete( );
            }
            // get the ModelElements that are already contained in the Class
            for ( ModelElement modelElement : contains.getContainedElement( classToConvert ) ) {
                Map<MRI, MRI> namespace2ModelElementMap = new HashMap<MRI, MRI>( 1 );
                namespace2ModelElementMap.put( ( (Partitionable) classToConvert ).get___Mri( ), ( (Partitionable) modelElement ).get___Mri( ) );
                containsToAdd.add( namespace2ModelElementMap );
            }
            // get those supertypes of the Class that are also Classes to be converted to StructureTypes
            List<GeneralizableElement> generalizableElements = classToConvert.getSupertypes( );
            for ( GeneralizableElement generalizableElement : generalizableElements ) {
                if ( generalizableElement instanceof MofClass && classesToConvertToStructureTypes.contains( generalizableElement ) ) {
                    Map<MRI, MRI> superType2subtypeMap = new HashMap<MRI, MRI>( 1 );
                    superType2subtypeMap.put( ( (Partitionable) generalizableElement ).get___Mri( ), ( (Partitionable) classToConvert ).get___Mri( ) );
                    generalizesToAdd.add( superType2subtypeMap );
                }
            }
            // create the StructureFields from the Class Attributes
            List<MRI> structureFieldMris = new ArrayList<MRI>( );
            for ( Attribute attribute : attributesToConvertToStructureFields ) {
                // create the StructureField from the Attribute
                Map<String, Object> properties = new HashMap<String, Object>( 5 );
                properties.put( "partition", ( (Partitionable) attribute ).get___Partition( ) ); //$NON-NLS-1$
                properties.put( "mofId", attribute.refMofId( ) ); //$NON-NLS-1$
                properties.put( "immediatePackage", attribute.refImmediatePackage( ) ); //$NON-NLS-1$
                properties.put( "annotation", attribute.getAnnotation( ) ); //$NON-NLS-1$
                properties.put( "name", attribute.getName( ) ); //$NON-NLS-1$
                propertiesForStructureFields.add( properties );
                // get the type information
                Map<MRI, MRI> type2TypedElementMap = new HashMap<MRI, MRI>( 1 );
                type2TypedElementMap.put( ( (Partitionable) attribute.getType( ) ).get___Mri( ), ( (Partitionable) attribute ).get___Mri( ) );
                isOfTypeToAdd.add( type2TypedElementMap );
                // get the initializer information
                Collection<OclConstraint> constraints = attributeInitializerConstraint.getConstraints( attribute );
                for ( OclConstraint constraint : constraints ) {
                    Map<MRI, MRI> attribute2OclConstraintMap = new HashMap<MRI, MRI>( 1 );
                    Map<MRI, MRI> typedElement2OclConstraintMap = new HashMap<MRI, MRI>( 1 );
                    attribute2OclConstraintMap.put( ( (Partitionable) attribute ).get___Mri( ), ( (Partitionable) constraint ).get___Mri( ) );
                    attributeInitializerConstraintToDelete.add( attribute2OclConstraintMap );
                    typedElement2OclConstraintMap.put( ( (Partitionable) attribute ).get___Mri( ), ( (Partitionable) constraint ).get___Mri( ) );
                    initializedElementToAdd.add( typedElement2OclConstraintMap );
                }
                // add the MRI to the structure field MRI list
                structureFieldMris.add( ( (Partitionable) attribute ).get___Mri( ) );
                // Attribute can be deleted
                attributesToDelete.add( attribute );
            }
            // create the StructureType from the Class
            Map<String, Object> properties = new HashMap<String, Object>( 9 );
            properties.put( "partition", ( (Partitionable) classToConvert ).get___Partition( ) ); //$NON-NLS-1$
            properties.put( "mofId", classToConvert.refMofId( ) ); //$NON-NLS-1$
            properties.put( "immediatePackage", classToConvert.refImmediatePackage( ) ); //$NON-NLS-1$
            properties.put( "annotation", classToConvert.getAnnotation( ) ); //$NON-NLS-1$
            properties.put( "container", classToConvert.getContainer( ) ); //$NON-NLS-1$
            properties.put( "isLeaf", classToConvert.isLeaf( ) ); //$NON-NLS-1$
            properties.put( "name", classToConvert.getName( ) ); //$NON-NLS-1$
            properties.put( "isRoot", classToConvert.isRoot( ) ); //$NON-NLS-1$
            properties.put( "visibility", classToConvert.getVisibility( ) ); //$NON-NLS-1$
            propertiesForStructureTypes.add( properties );
        }
        // StructureTypes to patch
        for ( StructureType structureToPatch : structuresToPatch ) {
            List<ModelElement> containedElementsToDelete = new ArrayList<ModelElement>( );
            List<Attribute> attributesToConvertToStructureFields = new ArrayList<Attribute>( 1 );
            for ( ModelElement modelElement : structureToPatch.getContents( ) ) {
                // DataTypeContainmentRules (C-17) for StructureTypes
                if ( modelElement instanceof Attribute ) {
                    attributesToConvertToStructureFields.add( (Attribute) modelElement );
                } else if ( modelElement instanceof StructureField ) {
                } else if ( modelElement instanceof Constraint ) {
                } else if ( modelElement instanceof Tag ) {
                } else if ( modelElement instanceof AliasType ) {
                } else {
                    containedElementsToDelete.add( modelElement );
                }
            }
            // delete the obsolete contents and its composite children
            for ( ModelElement containedElementToDelete : containedElementsToDelete ) {
                containedElementToDelete.refDelete( );
            }
            // create the StructureFields from the Class Attributes
            for ( Attribute attribute : attributesToConvertToStructureFields ) {
                // create the StructureField from the Attribute
                Map<String, Object> properties = new HashMap<String, Object>( 5 );
                properties.put( "partition", ( (Partitionable) attribute ).get___Partition( ) ); //$NON-NLS-1$
                properties.put( "mofId", attribute.refMofId( ) ); //$NON-NLS-1$
                properties.put( "immediatePackage", attribute.refImmediatePackage( ) ); //$NON-NLS-1$
                properties.put( "annotation", attribute.getAnnotation( ) ); //$NON-NLS-1$
                properties.put( "name", attribute.getName( ) ); //$NON-NLS-1$
                propertiesForStructureFields.add( properties );
                // get the type information
                Map<MRI, MRI> type2TypedElementMap = new HashMap<MRI, MRI>( 1 );
                type2TypedElementMap.put( ( (Partitionable) attribute.getType( ) ).get___Mri( ), ( (Partitionable) attribute ).get___Mri( ) );
                isOfTypeToAdd.add( type2TypedElementMap );
                // get the initializer information
                Collection<OclConstraint> constraints = attributeInitializerConstraint.getConstraints( attribute );
                for ( OclConstraint constraint : constraints ) {
                    Map<MRI, MRI> attribute2OclConstraintMap = new HashMap<MRI, MRI>( 1 );
                    Map<MRI, MRI> typedElement2OclConstraintMap = new HashMap<MRI, MRI>( 1 );
                    attribute2OclConstraintMap.put( ( (Partitionable) attribute ).get___Mri( ), ( (Partitionable) constraint ).get___Mri( ) );
                    attributeInitializerConstraintToDelete.add( attribute2OclConstraintMap );
                    typedElement2OclConstraintMap.put( ( (Partitionable) attribute ).get___Mri( ), ( (Partitionable) constraint ).get___Mri( ) );
                    initializedElementToAdd.add( typedElement2OclConstraintMap );
                }
                // Attribute can be deleted
                attributesToDelete.add( attribute );
            }
        }
        // delete the links between the Attributes and their initializer OclConstraints
        for ( Map<MRI, MRI> toDelete : attributeInitializerConstraintToDelete ) {
            Entry<MRI, MRI> attribute2OclConstraintEntry = toDelete.entrySet( ).iterator( ).next( );
            Attribute attribute = (Attribute) connection.getElement( attribute2OclConstraintEntry.getKey( ) );
            OclConstraint oclConstraint = (OclConstraint) connection.getElement( attribute2OclConstraintEntry.getValue( ) );
            attributeInitializerConstraint.remove( attribute, oclConstraint );
        }
        // Attributes not necessary anymore, delete them before the StructureFields with the same MOF IDs are created
        for ( Attribute attributeToDelete : attributesToDelete ) {
            deleteRefObject( (ConnectionWrapper) connection, (Wrapper<RefObject>) attributeToDelete );
        }
        // Classes not necessary anymore, delete them before the StructureTypes with the same MOF IDs are created
        for ( MofClass classToConvert : classesToConvertToStructureTypes ) {
            deleteRefObject( (ConnectionWrapper) connection, (Wrapper<RefObject>) classToConvert );
        }
        // create the StructureFields
        for ( Map<String, Object> propertyForStructureFields : propertiesForStructureFields ) {
            convertAttributeToStructureField( connection, propertyForStructureFields );
        }
        // create the StructureTypes
        for ( Map<String, Object> propertyForStructureTypes : propertiesForStructureTypes ) {
            convertClassToStructureType( connection, propertyForStructureTypes );
        }
        // link the new StructureFields to their initializer OclConstraints
        for ( Map<MRI, MRI> toAdd : initializedElementToAdd ) {
            Entry<MRI, MRI> typedElement2OclConstraintEntry = toAdd.entrySet( ).iterator( ).next( );
            TypedElement typedElement = (TypedElement) connection.getElement( typedElement2OclConstraintEntry.getKey( ) );
            OclConstraint oclConstraint = (OclConstraint) connection.getElement( typedElement2OclConstraintEntry.getValue( ) );
            initializedElement.add( typedElement, oclConstraint );
        }
        // link the new StructureFields to the types of the converted Attributes
        for ( Map<MRI, MRI> toAdd : isOfTypeToAdd ) {
            Entry<MRI, MRI> type2TypedElementEntry = toAdd.entrySet( ).iterator( ).next( );
            Classifier classifier = (Classifier) connection.getElement( type2TypedElementEntry.getKey( ) );
            TypedElement typedElement = (TypedElement) connection.getElement( type2TypedElementEntry.getValue( ) );
            isOfType.add( classifier, typedElement );
        }
        // recreate the containment hierarchy
        for ( Map<MRI, MRI> toAdd : containsToAdd ) {
            Entry<MRI, MRI> namespace2ModelElementEntry = toAdd.entrySet( ).iterator( ).next( );
            Namespace container = (Namespace) connection.getElement( namespace2ModelElementEntry.getKey( ) );
            ModelElement containedElement = (ModelElement) connection.getElement( namespace2ModelElementEntry.getValue( ) );
            contains.add( container, containedElement );
        }
        // recreate the inheritance tree for the new StructureTypes
        for ( Map<MRI, MRI> toAdd : generalizesToAdd ) {
            Entry<MRI, MRI> superType2SubTypeEntry = toAdd.entrySet( ).iterator( ).next( );
            GeneralizableElement superType = (GeneralizableElement) connection.getElement( superType2SubTypeEntry.getKey( ) );
            GeneralizableElement subType = (GeneralizableElement) connection.getElement( superType2SubTypeEntry.getValue( ) );
            generalizes.add( superType, subType );
        }
    }

    private void deleteIsStructureTypeTags( Connection connection, Collection<ModelPartition> partitions ) {

        // walk through the partitions and collect the elements to patch
        List<Tag> isStructureTypeTags = new ArrayList<Tag>( 1 );
        for ( Iterator<ModelPartition> partitionIterator = partitions.iterator( ); partitionIterator.hasNext( ); ) {
            ModelPartition partition = partitionIterator.next( );
            Collection<Partitionable> elements = partition.getElements( );
            for ( Iterator<Partitionable> elementIterator = elements.iterator( ); elementIterator.hasNext( ); ) {
                Partitionable partitionable = elementIterator.next( );
                // search the Tag that tagges Classes that should be converted to StructureTypes
                if ( partitionable instanceof Tag && ( (Tag) partitionable ).getTagId( ).equals( JMI_TAG_ID_IS_STRUCTURE_TYPE ) ) {
                    Tag isStructureTypeTag = (Tag) partitionable;
                    isStructureTypeTags.add( isStructureTypeTag );
                }
            }
        }
        // delete the isStructureType Tags
        for ( Tag tag : isStructureTypeTags ) {
            tag.refDelete( );
        }
    }

    private void patchIsRootIsLeaf( Connection connection, Collection<ModelPartition> partitions ) {

        // walk through the partitions and patch the elements
        for ( Iterator<ModelPartition> partitionIterator = partitions.iterator( ); partitionIterator.hasNext( ); ) {
            ModelPartition partition = partitionIterator.next( );
            Collection<Partitionable> elements = partition.getElements( );
            for ( Iterator<Partitionable> elementIterator = elements.iterator( ); elementIterator.hasNext( ); ) {
                Partitionable partitionable = elementIterator.next( );
                // Packages and Associations are not generalizable
                if ( partitionable instanceof MofPackage || partitionable instanceof Association ) {
                    ( (GeneralizableElement) partitionable ).setRoot( true );
                    ( (GeneralizableElement) partitionable ).setLeaf( true );
                }
                // DataTypes
                if ( partitionable instanceof DataType ) {
                    if ( partitionable instanceof StructureType ) {
                        // StructureTypes are generalizable, except the MultiplicityType of MOF
                        if ( convertMof ) {
                            // MultiplicityType
                            ( (GeneralizableElement) partitionable ).setRoot( true );
                            ( (GeneralizableElement) partitionable ).setLeaf( true );
                        } else {
                            ( (GeneralizableElement) partitionable ).setRoot( false );
                            ( (GeneralizableElement) partitionable ).setLeaf( false );
                        }
                    } else {
                        // other DataTypes are not generalizable
                        ( (GeneralizableElement) partitionable ).setRoot( true );
                        ( (GeneralizableElement) partitionable ).setLeaf( true );
                    }
                }
            }
        }
    }

    /**
     * @param xmlFile
     * @throws IOException
     */
    private void patchXmlFile( String xmlFile ) throws IOException {

        XmiPatcherForUnisysPlugin.PatchResult patchResult = XmiPatcherForUnisysPlugin.getInstance( ).getPatchedXmiContent( xmlFile );

        // only write file if necessary
        if ( patchResult.getPatchCount( ) > 0 ) {

            this.startTimer( );
            try {
                FileOutputStream fos = new FileOutputStream( xmlFile );

                fos.write( patchResult.getPatchedContent( ).getBytes( "UTF-8" ) ); //$NON-NLS-1$
                fos.close( );
            } catch ( FileNotFoundException ex ) {
                throw new FileNotFoundException( ex.getMessage( ) + " - is the file writable/checked out from perforce?" ); //$NON-NLS-1$
            }
            this.endTimer( "Patching Rose XML file: " + xmlFile ); //$NON-NLS-1$
            log( "Patched XML file: " + xmlFile ); //$NON-NLS-1$
        }
    }

    /**
     * Save the model partitions that were created or modified by the import.
     */
    private void commitChanges( Connection connection ) throws PartitionsNotSavedException, NullPartitionNotEmptyException {

        startTimer( );
        connection.save( );
        endTimer( "Saving partition xmis." ); //$NON-NLS-1$
    }

    /**
     * Handles errors in the {@link #main(String[])} method.
     */
    private static void error( String message ) {

        throw new RuntimeException( message );
    }

    /**
     * Handles errors in the {@link #main(String[])} method.
     * 
     * @throws Exception
     */
    private static void error( String message, Exception ex ) {

        log( message );
        throw new RuntimeException( ex );
    }

    @SuppressWarnings( "nls" )
    private static Properties getLoggingProperties( ) {

        String loggingProperties = "formatter[DefaultTrace] = TraceFormatter\n" + "formatter[DefaultTrace].pattern = %24d [%t] %-44l %s: %m\n" + "log[File] = FileLog\n" + "log[File].pattern = log/moin.log\n" + "log[File].formatter = formatter[DefaultTrace]\n" + "log[Console] = ConsoleLog\n"
                                   + "log[Console].formatter = formatter[DefaultTrace]\n" + "log[Console].severity = WARNING\n" + "com.sap.tc.moin.logs = log[Console]\n" + "com.sap.tc.moin.severity = INFO\n";//+ "com.sap.tc.moin.xmi.severity = WARNING\n";

        Properties properties = new Properties( );

        try {
            ByteArrayInputStream stream = new ByteArrayInputStream( loggingProperties.getBytes( "UTF-8" ) ); //$NON-NLS-1$
            properties.load( stream );
        } catch ( IOException e ) {
            e.printStackTrace( );
        }

        return properties;
    }

    public static final class Configuration {

        private String xmlFile;

        private Properties importProperties;

        private String dcName;

        private String dcVendor;

        private String label;

        private String dataArea;

        public String getDataArea( ) {

            return dataArea;
        }

        public Configuration( String xmlFile, Properties importProperties, String dataArea, String dcName, String dcVendor, String label ) {

            this.xmlFile = xmlFile;
            this.importProperties = importProperties;
            this.dcName = dcName;
            this.dcVendor = dcVendor;
            this.label = label;
            this.dataArea = dataArea;
        }

        public Properties getImportProperties( ) {

            return importProperties;
        }

        public String getXmlFile( ) {

            return xmlFile;
        }

        public String getDcName( ) {

            return dcName;
        }

        public String getDcVendor( ) {

            return dcVendor;
        }

        public String getLabel( ) {

            return label;
        }

    }

    private void deleteRefObject( ConnectionWrapper connectionWrapper, Wrapper<RefObject> refObject ) {

        ( (CorePartitionable) refObject.unwrap( ) ).delete___Isolated( connectionWrapper.unwrap( ) );
    }

    private Wrapper<RefObject> createRefObject( ConnectionWrapper connectionWrapper, String mofId, RefPackage immediatePackage, Wrapper<MofClass> mofClassWrapper, ModelPartitionWrapper partitionWrapper ) {

        CoreConnection connection = connectionWrapper.unwrap( );
        MofClass mofClass = mofClassWrapper.unwrap( );
        CoreModelPartition partition = partitionWrapper.unwrap( );
        RefClass refClass = (RefClass) ( (CorePartitionable) mofClass ).get___Workspace( ).getWorkspaceSet( ).getMoin( ).getExtentManager( ).getDefaultExtentForMetaObject( mofClass );

        Workspace workspace = partition.getWorkspace( );
        JmiInstantiator jmiInstantiator = workspace.getJmiInstantiator( );
        WrapperManager wrapperManager = workspace.getWorkspaceSet( ).getWrapperManager( );
        RefObject refObject = jmiInstantiator.createRefObject( connection, mofId, immediatePackage, mofClass, refClass, partition );
//        return (Wrapper<RefObject>) wrapperManager.getWrapperForJmiObject( connection, refObject );
        return (Wrapper<RefObject>) wrapperManager.wrapObject( connection, refObject );
    }

    private StructureType convertClassToStructureType( Connection connection, Map<String, Object> properties ) {

        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        RefClass structureTypeClass = modelPackage.getStructureType( );
        ModelPartition partition = (ModelPartition) properties.get( "partition" ); //$NON-NLS-1$
        String mofId = (String) properties.get( "mofId" ); //$NON-NLS-1$
        RefPackage immediatePackage = (RefPackage) properties.get( "immediatePackage" ); //$NON-NLS-1$
        // create the StructureType and fill its attributes
        StructureType structureType = (StructureType) createRefObject( (ConnectionWrapper) connection, mofId, immediatePackage, (Wrapper<MofClass>) structureTypeClass.refMetaObject( ), (ModelPartitionWrapper) partition );
        structureType.setAbstract( false ); // C-20 "DataTypesCannotBeAbstract"
        structureType.setAnnotation( (String) properties.get( "annotation" ) ); //$NON-NLS-1$
        structureType.setContainer( (Namespace) properties.get( "container" ) ); //$NON-NLS-1$
        structureType.setLeaf( (Boolean) properties.get( "isLeaf" ) ); //$NON-NLS-1$
        structureType.setName( (String) properties.get( "name" ) ); //$NON-NLS-1$
        structureType.setRoot( (Boolean) properties.get( "isRoot" ) ); //$NON-NLS-1$
        structureType.setVisibility( (VisibilityKind) properties.get( "visibility" ) ); //$NON-NLS-1$
        return structureType;
    }

    private StructureField convertAttributeToStructureField( Connection connection, Map<String, Object> properties ) {

        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        RefClass structureFieldClass = modelPackage.getStructureField( );
        ModelPartition partition = (ModelPartition) properties.get( "partition" ); //$NON-NLS-1$
        String mofId = (String) properties.get( "mofId" ); //$NON-NLS-1$
        RefPackage immediatePackage = (RefPackage) properties.get( "immediatePackage" ); //$NON-NLS-1$
        // create the StructureType and fill its attributes
        StructureField structureField = (StructureField) createRefObject( (ConnectionWrapper) connection, mofId, immediatePackage, (Wrapper<MofClass>) structureFieldClass.refMetaObject( ), (ModelPartitionWrapper) partition );
        structureField.setAnnotation( (String) properties.get( "annotation" ) ); //$NON-NLS-1$
        structureField.setName( (String) properties.get( "name" ) ); //$NON-NLS-1$
        return structureField;
    }

}
