package com.sap.tc.moin.repository.jmigenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import com.sap.tc.moin.repository.jmigenerator.controller.LogCallback;
import com.sap.tc.moin.repository.runtimehost.MetamodelRegistrationSerializer;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * Generates the deployment files
 */
public class DeploymentFilesGeneration {

    public static class ResourceBundleFilter implements FileFilter {

        public boolean accept( File file ) {

            // accept file with name and each directory for scanning subdirectories
            boolean isDirOrBundle = file.isDirectory( ) || file.getName( ).equals( MmInfoConst.MM_RESOURCEBUNDLE_ID_PROPS );
            return ( isDirOrBundle );
        }
    }

    private static final ResourceBundleFilter resourceBundleFilter = new ResourceBundleFilter( );

    public static String scanResourceBundleFileName( File javaDirectory ) {

        String metaModelLocalizationName = null;
        if ( javaDirectory != null ) {
            String absRootPath = javaDirectory.getAbsolutePath( );
            List<File> fileList = scanSubdirectories( new ArrayList<File>( ), javaDirectory, resourceBundleFilter );
            if ( fileList == null || fileList.size( ) < 1 ) {
                // ignore
                return null;
            } else if ( fileList.size( ) > 1 ) {
                StringBuffer buf = new StringBuffer( );
                boolean first = true;
                for ( File file : fileList ) {
                    if ( first ) {
                        first = false;
                    } else {
                        buf.append( ", " ); //$NON-NLS-1$
                    }
                    buf.append( getJavaName( absRootPath, file ) );
                }
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.MULTIPLEMETAMODELLOCALIZATIONPROPFILES, buf.toString( ) );
            } else {
                metaModelLocalizationName = getJavaName( absRootPath, fileList.get( 0 ) );
            }
        }
        return metaModelLocalizationName;
    }

    private static List<File> scanSubdirectories( List<File> result, File dir, FileFilter filter ) {

        // filter accepts all directories and the file with specified name 
        File[] filesInDir = dir.listFiles( filter );
        if ( filesInDir == null || filesInDir.length < 1 ) {
            // nothing found - return existing result
            return result;
        }
        for ( File file : filesInDir ) {
            if ( file.isFile( ) ) {
                // keep it
                result.add( file );
            } else if ( file.isDirectory( ) ) {
                result = scanSubdirectories( result, file, filter );
            }
        }
        return result;
    }

    private static String getJavaName( String absRootPath, File file ) {

        if ( file == null ) {
            // undefined
            return null;
        }
        String filePath = file.getAbsolutePath( );
        if ( filePath.startsWith( absRootPath ) ) {
            filePath = filePath.substring( absRootPath.length( ) + 1 );
            if ( filePath.endsWith( MmInfoConst.MM_PROPS_SUFFIX ) ) {
                filePath = filePath.substring( 0, filePath.length( ) - MmInfoConst.MM_PROPS_SUFFIX.length( ) );
            }
            filePath = filePath.replace( File.separatorChar, '.' );
        }
        return filePath;
    }

    private String _dcName;

    private String _dcDescription;

    private String _dcVendor;

    private String _dcVersion;

    private String _containerId;

    private String _archiveVersion;

    private String _xmiDir;

    // mapping partition name to both time stamp and content hash
    // - time stamp
    private HashMap<String, String> _xmiList;

    // content hash
    private HashMap<String, String> _xmiList2;

    private String _facilityName;

    private String _propertiesFileName;

    private String _propertiesV2FileName;

    private String _metaModelResourceBundleName = null;

    private LogCallback _logCallback;

    private Set<List<String>> generatedPathFragments = new HashSet<List<String>>( );

    /**
     * Nothing special here
     */
    public DeploymentFilesGeneration( ) {

        super( );
    }

    /**
     * Nothing special here
     */
    public DeploymentFilesGeneration( LogCallback logCallback ) {

        super( );
        this._logCallback = logCallback;
    }

    /**
     * @throws IllegalStateException
     * @throws IOException
     */
    public void execute( ) throws IllegalStateException, IOException {

        // check the name of the properties file
        if ( getPropertiesFileName( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.NAMEOFPROPERTIESFILENOTSPECIFIED );
        }

        // check the name of the DC
        if ( getDcName( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.DCNAMENOTSPECIFIED );
        }
        // check the vendor of the DC
        if ( getDcVendor( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.DCVENDORNOTSPECIFIED );
        }
        // check xmi directory
        if ( getXmiDir( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.XMIDIRNOTSPECIFIED );
        }

        // check xmi list
        if ( getXmiList( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.XMILISTNOTSPECIFIED );
        }

        // create xmi dir
        File fXmiDir = new File( getXmiDir( ) );
        if ( !fXmiDir.exists( ) ) {
            fXmiDir.mkdirs( );
        }

        File newPropsFile = evaluateNewPropertiesFile( );
        if ( newPropsFile != null ) {
            generateMetamodelDescriptorIfRequired( _containerId, _xmiList, _xmiList2, null );
            // skip classical properties file generation if no partitions are included
            if ( this._xmiList == null || this._xmiList.size( ) <= 0 ) {
                return;
            }

        }
        generatePropertiesFile( );

    }

    /**
     * Have forced generation of moinarch.properties file and new format
     * 
     * @throws IllegalStateException
     * @throws IOException
     */
    public void execute2( ) throws IllegalStateException, IOException {

        // check the name of the properties file
        if ( getPropertiesV2FileName( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.NAMEOFV2PROPERTIESFILENOTSPECIFIED );
        }

        // check the name of the DC
        if ( getDcName( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.DCNAMENOTSPECIFIED );
        }
        // check the vendor of the DC
        if ( getDcVendor( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.DCVENDORNOTSPECIFIED );
        }
        // check xmi directory
        if ( getXmiDir( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.XMIDIRNOTSPECIFIED );
        }

        // check xmi list
        if ( getXmiList( ) == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.XMILISTNOTSPECIFIED );
        }

        // create xmi dir
        File fXmiDir = new File( getXmiDir( ) );
        if ( !fXmiDir.exists( ) ) {
            fXmiDir.mkdirs( );
        }

        generateNewPropertiesFile( );
        _containerId = getDcVendor( ) + "/" + getDcName( ); //$NON-NLS-1$
        generateMetamodelDescriptorIfRequired( _containerId, _xmiList, _xmiList2, getMetaModelResourceBundleName( ) );

    }

    public Set<List<String>> getGeneratedPathFragments( ) {

        return generatedPathFragments;
    }

    private void generateNewPropertiesFile( ) throws FileNotFoundException, IOException {

        File propsFile = new File( getXmiDir( ) + File.separator + getPropertiesV2FileName( ) );
        File parentFile = propsFile.getParentFile( );
        if ( !parentFile.exists( ) ) {
            parentFile.mkdirs( );
        }

        List<String> propsEntries = new ArrayList<String>( );

        // --- moinarch content ---
        propsEntries.add( "# moin archive" ); //$NON-NLS-1$
        // archive_format_version 
        propsEntries.add( "# " ); //$NON-NLS-1$
        propsEntries.add( "# version" ); //$NON-NLS-1$
        propsEntries.add( "archive_format_version=2.0" ); //$NON-NLS-1$
        String version = getDcVersion( );
        if ( version != null ) {
            // semantic_version
            propsEntries.add( "semantic_version=" + getDcVersion( ) ); //$NON-NLS-1$
        }

        // containerId = vendor/dcName
        String metaModelId = getDcVendor( ) + "/" + getDcName( ); //$NON-NLS-1$
        propsEntries.add( "# " ); //$NON-NLS-1$
        propsEntries.add( "# container" ); //$NON-NLS-1$
        propsEntries.add( "containerId=" + metaModelId ); //$NON-NLS-1$

        // label
        String label = getDcDescription( );
        if ( label != null ) {
            propsEntries.add( "label=" + getDcDescription( ) ); //$NON-NLS-1$
        }
        // vendor
        propsEntries.add( "vendor=" + getDcVendor( ) ); //$NON-NLS-1$


        // write properties file
        BufferedWriter propertiesWriter = null;
        try {
            propertiesWriter = new BufferedWriter( new FileWriter( propsFile ) );
            for ( String entry : propsEntries ) {
                propertiesWriter.write( entry );
                propertiesWriter.newLine( );
            }
        } finally {
            if ( propertiesWriter != null ) {
                propertiesWriter.close( );
            }
        }

    }

    private void generatePropertiesFile( ) throws FileNotFoundException, IOException {

        File f = new File( getXmiDir( ) + File.separator + getPropertiesFileName( ) );
        Properties props = new Properties( );
        String metaModelId = getDcVendor( ) + "/" + getDcName( ); //$NON-NLS-1$

        props.setProperty( "metamodelId", metaModelId ); //$NON-NLS-1$
        props.setProperty( "vendor", getDcVendor( ) ); //$NON-NLS-1$
        props.setProperty( "partitionList", getXmiListAsString( ) ); //$NON-NLS-1$
        String version = getDcVersion( );
        if ( version != null ) {
            props.setProperty( "version", getDcVersion( ) ); //$NON-NLS-1$
        }
        String label = getDcDescription( );
        if ( label != null ) {
            props.setProperty( "label", getDcDescription( ) ); //$NON-NLS-1$
        }
        if ( this._facilityName != null ) {
            props.setProperty( "facilityName", this._facilityName ); //$NON-NLS-1$
        }

        props.setProperty( "metaModelExtensionPackage", Utilities.getMMPackageQualified( metaModelId ) ); //$NON-NLS-1$

        Set<String> partNames = this._xmiList.keySet( );
        for ( String partitionName : partNames ) {
            props.setProperty( "lastModified_" + partitionName, this._xmiList.get( partitionName ) ); //$NON-NLS-1$
        }

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream( f );
            props.store( fo, "metamodel meta information" ); //$NON-NLS-1$
        } finally {
            if ( fo != null ) {
                fo.close( );
            }
        }
    }

    /**
     * @return the DC name
     */
    public String getDcName( ) {

        return this._dcName;
    }

    /**
     * @param string
     */
    public void setDcName( String string ) {

        this._dcName = string;
    }

    /**
     * @return the vendoer
     */
    public String getDcVendor( ) {

        return this._dcVendor;
    }

    /**
     * @param string
     */
    public void setDcVendor( String string ) {

        this._dcVendor = string;
    }

    /**
     * @return the version
     */
    public String getDcVersion( ) {

        return this._dcVersion;
    }

    /**
     * @param version
     */
    public void setDcVersion( String version ) {

        this._dcVersion = version;
    }

    /**
     * @return directory
     */
    public String getXmiDir( ) {

        return this._xmiDir;
    }

    /**
     * @param dir
     */
    public void setXmiDir( String dir ) {

        this._xmiDir = dir;
    }

    /**
     * @return the list
     */
    public HashMap<String, String> getXmiList( ) {

        return this._xmiList;
    }

    /**
     * @return the list with content hash
     */
    public HashMap<String, String> getXmiList2( ) {

        return this._xmiList2;
    }

    private String getXmiListAsString( ) {

        StringBuffer pbuff = new StringBuffer( 200 );

        if ( this._xmiList != null && this._xmiList.size( ) > 0 ) {
            Set<String> partNames = this._xmiList.keySet( );

            int partNumber = partNames.size( );
            for ( String name : partNames ) {
                pbuff.append( name );
                partNumber--;
                if ( partNumber > 0 ) {
                    pbuff.append( ";" ); //$NON-NLS-1$
                }
            }
        }

        return pbuff.toString( );
    }

    /**
     * @return Returns the dcDescription.
     */
    public String getDcDescription( ) {

        return this._dcDescription;
    }

    /**
     * @param dcDescription The dcDescription to set.
     */
    public void setDcDescription( String dcDescription ) {

        this._dcDescription = dcDescription;
    }

    /**
     * @param xmiList
     */
    public void setXmiList( HashMap<String, String> xmiList ) {

        this._xmiList = xmiList;
    }

    /**
     * @param xmiList
     */
    public void setXmiList2( HashMap<String, String> xmiList ) {

        this._xmiList2 = xmiList;
    }

    /**
     * @param propertiesFileName
     */
    public void setPropertiesFileName( String propertiesFileName ) {

        this._propertiesFileName = propertiesFileName;
    }

    /**
     * @return the properties file name
     */
    public String getPropertiesFileName( ) {

        return this._propertiesFileName;
    }

    /**
     * @param propertiesFileName
     */
    public void setPropertiesV2FileName( String propertiesFileName ) {

        this._propertiesV2FileName = propertiesFileName;
    }

    /**
     * @return the properties file name
     */
    public String getPropertiesV2FileName( ) {

        return this._propertiesV2FileName;
    }


    public String getMetaModelResourceBundleName( ) {

        return _metaModelResourceBundleName;
    }


    public void setMetaModelResourceBundleName( String metaModelResourceBundleName ) {

        this._metaModelResourceBundleName = metaModelResourceBundleName;
    }

    /**
     * @return the facility name
     */
    public String getFacilityName( ) {

        return this._facilityName;
    }

    /**
     * @param facilityName
     */
    public void setFacilityName( String facilityName ) {

        this._facilityName = facilityName;
    }

    private File evaluateNewPropertiesFile( ) throws IOException {

        // ensure additional instance variables are reset before processing
        _containerId = null;
        _archiveVersion = null;

        String fileName = getPropertiesV2FileName( );
        if ( fileName == null ) {
            // not prepared for the new format - ignore this part
            return null;
        }
        File propsFile = new File( fileName );
        if ( !propsFile.exists( ) ) {
            // not the new format - ignore this part
            return null;
        }
        Properties props = new Properties( );
        FileInputStream fi = null;
        try {
            fi = new FileInputStream( propsFile );
            props.load( fi );
        } finally {
            if ( fi != null ) {
                fi.close( );
            }
        }

        // containerId = vendor/dcName: use additional _metaModelId as instance variable
        _containerId = props.getProperty( "containerId" ); //$NON-NLS-1$
        if ( _containerId == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYNOTDEFINEDINFILE, "ContainerId", "moinarch.properties" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        String metaModelId = getDcVendor( ) + "/" + getDcName( ); //$NON-NLS-1$
        if ( !metaModelId.equals( _containerId ) ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYDIFFERSINFILEANDBUILD, "containerId", _containerId, "moinarch.properties", "dcVendor / dcName", metaModelId ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
        }

        // archive_format_version 
        _archiveVersion = props.getProperty( "archive_format_version" ); //$NON-NLS-1$
        if ( _archiveVersion == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYNOTDEFINEDINFILE, "archive_format_version", "moinarch.properties" ); //$NON-NLS-1$//$NON-NLS-2$
        } else if ( _archiveVersion.startsWith( MmInfoConst.MM2_ARCHIVE_VERSION ) ) {
            // ok
        } else {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.UNSUPPORTEDPROPERTYVALUEINFILE, _archiveVersion, "archive_format_version", "moinarch.properties" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        // semantic_version
        String semanticVersion = props.getProperty( "semantic_version" ); //$NON-NLS-1$
        if ( semanticVersion == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYNOTDEFINEDINFILE, "semantic_version", "moinarch.properties" ); //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( getDcVersion( ) != null && !getDcVersion( ).equals( "" ) && !getDcVersion( ).equals( "null" ) && !getDcVersion( ).equals( "${mmVersion}" ) && !getDcVersion( ).equals( semanticVersion ) ) { //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYDIFFERSINFILEANDBUILD, "semantic_version", semanticVersion, "moinarch.properties", "metamodelVersion", getDcVersion( ) ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$

        }
        setDcVersion( semanticVersion );

        // label
        String label = props.getProperty( "label" ); //$NON-NLS-1$
        if ( label == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYNOTDEFINEDINFILE, "label", "moinarch.properties" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        String description = getDcDescription( );
        if ( description != null && !description.equals( "uNdEfInEd" ) && !description.equals( label ) ) { //$NON-NLS-1$
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYDIFFERSINFILEANDBUILD, "label", label, "moinarch.properties", "description", description ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
        }
        setDcDescription( label );

        // vendor
        String vendor = props.getProperty( "vendor" ); //$NON-NLS-1$
        if ( vendor == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYNOTDEFINEDINFILE, "vendor", "moinarch.properties" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        String myVendor = getDcVendor( );
        if ( myVendor != null && !myVendor.equals( vendor ) ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.PROPERTYDIFFERSINFILEANDBUILD, "vendor", vendor, "moinarch.properties", "vendor", myVendor ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
        }
        setDcVendor( vendor );

        return propsFile;

    }

    /**
     * Generate descriptor file
     * 
     * @param metaModelId <vendorId>/<dcId>
     * @param xmiList mapping partition names to time stamps (long as string)
     * @param xmiList2 mapping partition names to content hashes
     * @param metaModelResourceBundleName TODO
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void generateMetamodelDescriptorIfRequired( String metaModelId, HashMap<String, String> xmiList, HashMap<String, String> xmiList2, String metaModelResourceBundleName ) throws FileNotFoundException, IOException {

        HashMap<String, String> partitionList = xmiList2;
        if ( partitionList == null || partitionList.size( ) < 1 ) {
            // have fall back, using time stamps instead of content hashes  
            partitionList = xmiList;
        }
        if ( partitionList != null && partitionList.size( ) > 0 ) {
            File metamodelXmlFile = new File( getXmiDir( ), MmInfoConst.MM2_METAMODEL_XML_FILE_NAME );
            File parentFile = metamodelXmlFile.getParentFile( );
            if ( !parentFile.exists( ) ) {
                parentFile.mkdirs( );
            }
            OutputStream oStream = new FileOutputStream( metamodelXmlFile );

            // deploymentExtension class
            MetamodelRegistrationSerializer serializer = new MetamodelRegistrationSerializer( Utilities.getMMPackageQualified( metaModelId ) + ".MetamodelExtension", metaModelResourceBundleName, getFacilityName( ), partitionList ); //$NON-NLS-1$
            try {
                serializer.serialize( oStream );
                ArrayList<String> pathFragments = new ArrayList<String>( 2 );
                pathFragments.add( MmInfoConst.REGISTRATION_PARENT );
                pathFragments.add( MmInfoConst.REGISTRATION );
                generatedPathFragments.add( pathFragments );
            } finally {
                oStream.close( );
            }

        }

    }

    public String getContentHash( File file ) {

        final String MD5STRING = "MD5"; //$NON-NLS-1$
        boolean useMD5 = true;
        if ( useMD5 && _logCallback != null ) {
            try {
                MessageDigest md = MessageDigest.getInstance( MD5STRING );
                FileInputStream in = new FileInputStream( file );
                try {
                    int len;
                    byte[] data = new byte[1024];
                    while ( ( len = in.read( data ) ) > 0 ) {
                        //MessageDigest update
                        md.update( data, 0, len );
                    }
                    return getString( md.digest( ) );
                } catch ( IOException e ) {
                    _logCallback.logThrowable( e );
                } finally {
                    try {
                        in.close( );
                    } catch ( IOException e ) {
                        _logCallback.logThrowable( e );
                    }
                }
            } catch ( NoSuchAlgorithmException e ) {
                _logCallback.logThrowable( e );
            } catch ( FileNotFoundException e ) {
                _logCallback.logThrowable( e );
            }
        }
        // default implementation for time stamp
        return ( (Long) file.lastModified( ) ).toString( );

    }

    private String getString( byte[] byteArray ) {

        if ( byteArray == null || byteArray.length < 1 ) {
            return null;
        }
        StringBuffer buf = new StringBuffer( 2 * byteArray.length );
        for ( byte byteEntry : byteArray ) {
            // transform to hex representation
            int value = ( byteEntry & 0x7F ) + ( byteEntry < 0 ? 128 : 0 );
            buf.append( ( value < 16 ? "0" : "" ) ); //$NON-NLS-1$ //$NON-NLS-2$
            String hexString = Integer.toHexString( value ).toUpperCase( Locale.ENGLISH );
            buf.append( hexString );
            // try back conversion
            int testInt = Integer.parseInt( hexString, 16 );
            byte testByte = (byte) testInt;
            if ( byteEntry != testByte ) {
                throw new RuntimeException( "- " + byteEntry + "-hex->" + hexString + "-byte->" + testByte ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }
        return buf.toString( );
    }
}