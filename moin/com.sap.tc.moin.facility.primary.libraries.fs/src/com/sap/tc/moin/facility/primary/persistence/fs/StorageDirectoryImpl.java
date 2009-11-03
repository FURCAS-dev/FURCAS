/*
 * Created on 04.10.2005
 */
package com.sap.tc.moin.facility.primary.persistence.fs;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.FILE_SEPARATOR;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord.CreatableCheckResult;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * The implementation of the file system based persistence API, which can deal
 * with a single directory, for example within a NWDI DC or a JaPro subproject.
 */
public class StorageDirectoryImpl extends AbstractStorageImpl implements IpiStorage {

    static final String TEXT_FILE_EXTENSION = ".xlf"; //$NON-NLS-1$

    private final static char SystemFileSeparator = System.getProperty( FILE_SEPARATOR ).charAt( 0 );

    public StorageDirectoryImpl( CRI cri, String resourceFolder, String sourcePath, SpiPartitionNameVerifier serializationManager, IpiLogicalFsFactory logicalFsFactory ) {

        super( cri, resourceFolder, sourcePath, serializationManager, logicalFsFactory );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#getOutputStreamForPartitionStore
     * (com.sap.tc.moin.repository.spi.core.SpiModelPartition)
     */
    public OutputStream getOutputStreamForPartitionStore( PRI pri ) {

        String partitionName = pri.getPartitionName( );
        try {
            OutputStream fos = null;

            IpiLogicalFolder dir = null;
            IpiLogicalResource directory = this.logicalFsFactory.getResource( this.getSourcePath( ) );
            if ( directory == null ) {
                // create folder
                dir = this.logicalFsFactory.createFolder( this.getSourcePath( ) );
            } else {
                if ( !directory.isFolder( ) ) {
                    throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.ILLEGAL_SOURCE_PATH_DETECTED_FOLDER, directory.getPath( ) );
                }
                dir = (IpiLogicalFolder) directory;
            }
            IpiLogicalResource res = dir.getResource( partitionName );
            IpiLogicalFile file = null;
            if ( res == null || !res.exists( ) ) {
                file = dir.createFile( partitionName );
            } else {
                file = (IpiLogicalFile) res;
            }
            fos = file.getOutputStream( );
            return fos;

        } catch ( Exception e ) { // catch exceptions to add more information
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_WRITING, pri );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#getOutputStreamForPartitionTextStore
     * (com.sap.tc.moin.repository.spi.core.SpiModelPartition)
     */
    public OutputStream getOutputStreamForPartitionTextStore( PRI pri ) {

        String partitionName = pri.getPartitionName( );
        String textFileName = partitionName + TEXT_FILE_EXTENSION;
        try {
            OutputStream fos = null;

            IpiLogicalFolder dir = null;
            IpiLogicalResource directory = this.logicalFsFactory.getResource( this.getSourcePath( ) );
            if ( directory == null ) {
                // create folder
                dir = this.logicalFsFactory.createFolder( this.getSourcePath( ) );
            } else {
                if ( !directory.isFolder( ) ) {
                    throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.ILLEGAL_SOURCE_PATH_DETECTED_FOLDER, this.getSourcePath( ) );
                }
                dir = (IpiLogicalFolder) directory;
            }
            IpiLogicalResource res = dir.getResource( textFileName );
            IpiLogicalFile file = null;
            if ( res == null || !res.exists( ) ) {
                file = dir.createFile( textFileName );
            } else {
                file = (IpiLogicalFile) res;
            }
            fos = file.getOutputStream( );
            return fos;

        } catch ( Exception e ) { // catch exceptions to add more information
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_WRITING, pri );
        }
    }

    public InputStream getInputStreamForPartitionLoad( PRI pri ) {

        InputStream is = null;

        IpiLogicalFolder directory = this.getSourcePathFolder( );
        if ( directory != null ) {
            IpiLogicalResource fileRes = directory.getResource( pri.getPartitionName( ) );
            if ( fileRes != null && fileRes.isFile( ) ) {
                is = ( (IpiLogicalFile) fileRes ).getInputStream( );
            } else {
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.NO_FILE_AVAILABLE, directory.getPath( ), pri.getPartitionName( ) );
            }
        }

        return is;
    }

    public InputStream getInputStreamForPartitionTextLoad( PRI pri ) {

        InputStream is = null;
        IpiLogicalFolder directory = this.getSourcePathFolder( );
        if ( directory != null ) {
            IpiLogicalResource fileRes = directory.getResource( pri.getPartitionName( ) + TEXT_FILE_EXTENSION );
            if ( fileRes != null && fileRes.isFile( ) ) {
                is = ( (IpiLogicalFile) fileRes ).getInputStream( );
            } else {
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.NO_TEXT_FILE_AVAILABLE, directory.getPath( ), pri.getPartitionName( ) );
            }
        }
        return is;
    }

    public PartitionIsCreatableResultRecord isPathCreatable( String relativePath ) {

        PartitionIsCreatableResultRecord record = new PartitionIsCreatableResultRecord( );

        // we have to check if the given relative path can be created on top of the source path of this storage
        // construct the path that would be created
        IpiLogicalFolder sourcePathFolder = this.getSourcePathFolder( );
        if ( sourcePathFolder == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.FOLDER_DOES_NOT_EXIST, this.getSourcePath( ) );
        }
        String canonicalSourcePath = sourcePathFolder.getCanonicalPath( );
        String pathToCreate = canonicalSourcePath + "\\" + relativePath; //$NON-NLS-1$

        // use java.io means to determine the canonical path
        // (possibly already existing parts of the path are converted to their actual case)
        File fileToCreate = new File( pathToCreate );

        try {
            // normalize path representation (sub-strings like "//", "\/" or "\\\\" in paths are normalized)
            String canonicalPathToCreate = fileToCreate.getCanonicalPath( ); // get file path in capitalization as available on disc
            String absolutePathToCreate = fileToCreate.getAbsolutePath( ); // get file path in capitalization as intended to create 

            if ( canonicalPathToCreate.equals( absolutePathToCreate ) ) {
                // if the path to create and the canonical path to create are equal there is no case conflict
                // check we are not trying to override some existing directory or file (that was not indexed for some reason)
                if ( !fileToCreate.exists( ) ) {
                    record.result = CreatableCheckResult.CREATABLE;
                } else {
                    // resource referenced by the path already exists
                    record.result = CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS;
                }
            } else {
                // a part of the path exists in different case
                record.result = CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT;
            }

            // in case of a conflict we extract the existing path
            if ( record.result == CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT ) {

                // we look for a parent file that actually exists
                File existingPathCandidate = fileToCreate;
                while ( !existingPathCandidate.exists( ) ) {
                    existingPathCandidate = existingPathCandidate.getParentFile( );
                }

                record.existingPath = existingPathCandidate.getCanonicalPath( );
            }
        } catch ( IOException ioe ) {
            throw new MoinLocalizedBaseRuntimeException( ioe, PersistenceFsMessages.UNABLE_TO_DETERMINE_CANONICAL_PATH, pathToCreate );
        }

        return record;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#deletePartition(com.sap.tc.moin
     * .repository.PRI, com.sap.tc.moin.repository.spi.core.Stage)
     */
    public boolean deletePartition( PRI pri ) {

        IpiLogicalResource res = this.logicalFsFactory.getResource( this.getSourcePath( ) );
        if ( res == null ) {
            // not even container is found - return false for partition not
            // found
            return false;
        }
        IpiLogicalFolder directory = (IpiLogicalFolder) res;
        IpiLogicalResource fileRes = directory.getResource( pri.getPartitionName( ) );
        if ( fileRes != null ) {
            if ( fileRes.isFile( ) ) {
                return ( (IpiLogicalFile) fileRes ).delete( );
            } else {
                // folder -> error
                return false;
            }
        }
        // partition not found - return true (if partition is already deleted -> desired state.)
        return true;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#deletePartitionTexts(com.sap.tc
     * .moin.repository.PRI)
     */
    public boolean deletePartitionTexts( PRI pri ) {

        String textFileName = pri.getPartitionName( ) + TEXT_FILE_EXTENSION;
        IpiLogicalResource res = this.logicalFsFactory.getResource( this.getSourcePath( ) );
        if ( res == null ) {
            // not even container is found - return false for partition not found
            return false;
        }
        IpiLogicalFolder directory = (IpiLogicalFolder) res;
        IpiLogicalResource fileRes = directory.getResource( textFileName );
        if ( fileRes != null ) {
            if ( fileRes.isFile( ) ) {
                return ( (IpiLogicalFile) fileRes ).delete( );
            } else {
                // folder -> error
                return false;
            }
        }
        // partition not found - return true (if partition is already deleted -> desired state.)
        return true;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#isPartitionReadonly(com.sap.tc
     * .moin.repository.PRI, com.sap.tc.moin.repository.spi.core.Stage)
     */
    public boolean isPartitionReadonly( PRI pri ) {

        IpiLogicalResource res = this.logicalFsFactory.getResource( this.getSourcePath( ) );
        if ( res == null || !res.exists( ) ) {
            // is not there
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.PARTITION_DOES_NOT_EXIST_IN_FS, pri );
        }
        IpiLogicalFolder directory = (IpiLogicalFolder) res;
        IpiLogicalResource fileRes = directory.getResource( pri.getPartitionName( ) );
        if ( fileRes != null && fileRes.exists( ) ) {
            if ( fileRes.isFile( ) ) {
                return ( (IpiLogicalFile) fileRes ).isReadOnly( );
            } else {
                // can not be used as partition
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_DETERMINE_READ_ONLY_STATE_NOT_A_FILE, pri, this.getSourcePath( ) + "/" + pri.getPartitionName( ), this.toString( ) ); //$NON-NLS-1$
            }
        } else {
            // is not there
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.PARTITION_DOES_NOT_EXIST_IN_FS_STORAGE, pri, this.toString( ) );
        }
    }

    public List<PartitionInfo> getPartitionInfos( ) {

        List<PartitionInfo> partitionInfos = new ArrayList<PartitionInfo>( );
        String sourcePath = this.getSourcePath( );
        if ( sourcePath != null ) {

            String resource = this.getResourceFolder( );
            if ( resource != null ) {
                resource = this.ensureNoTrailingFileSeparator( resource );
                sourcePath = sourcePath + SystemFileSeparator + resource;
            }

            IpiLogicalResource res = this.logicalFsFactory.getResource( sourcePath );
            if ( res == null ) {
                return partitionInfos;
            }
            IpiLogicalFolder directory = null;

            if ( res.exists( ) ) {
                if ( res.isFolder( ) ) {
                    /*
                     * A directory in the filesystem.
                     */
                    directory = (IpiLogicalFolder) res;
                    this.getPartitionInfos( directory, resource, partitionInfos );
                } else {
                    throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.RESOURCE_FOLDER_NO_DIRECTORY, sourcePath );
                }
            }
        }
        return partitionInfos;
    }

    public long partitionLastChanged( PRI pri ) {

        long lastChanged = 0;

        IpiLogicalFolder sourcePathFolder = this.getSourcePathFolder( );
        if ( sourcePathFolder != null ) {
            IpiLogicalResource fileRes = sourcePathFolder.getResource( pri.getPartitionName( ) );
            if ( fileRes != null ) {
                lastChanged = fileRes.lastChangedTime( );
            }
        }

        return lastChanged;
    }

    public long partitionFileSize( PRI pri ) {

        long fileSize = -1;

        IpiLogicalFolder sourcePathFolder = this.getSourcePathFolder( );
        if ( sourcePathFolder != null ) {
            IpiLogicalResource resource = sourcePathFolder.getResource( pri.getPartitionName( ) );
            if ( resource != null && resource.isFile( ) ) {
                fileSize = ( (IpiLogicalFile) resource ).getLength( );
            }
        }

        return fileSize;
    }

    /**
     * Returns the logical folder referenced by the source path or null if the
     * <code>sourcePath</code> is null.
     */
    private IpiLogicalFolder getSourcePathFolder( ) {

        IpiLogicalFolder sourcePathFolder = null;

        IpiLogicalResource res = this.logicalFsFactory.getResource( this.getSourcePath( ) );
        if ( res != null ) {
            if ( res.isFolder( ) ) {
                sourcePathFolder = (IpiLogicalFolder) res;
            } else {
                // source path references a file (folder expected)
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.ILLEGALSOURCEPATHINDIR, this.getSourcePath( ) );
            }
        }

        return sourcePathFolder;
    }

    /**
     * @param dir
     * @param pathRelative
     * @param partitionInfos is a **return** parameter!!
     * @return
     */
    private void getPartitionInfos( IpiLogicalFolder dir, String pathRelative, List<PartitionInfo> partitionInfos ) {

        IpiLogicalResource childResources[] = dir.listResources( );
        for ( int i = 0; i < childResources.length; i++ ) {
            IpiLogicalResource childResource = childResources[i];
            if ( childResource.isFolder( ) ) {
                String pathRelativeNew = childResource.getName( );
                if ( pathRelative != null ) {
                    pathRelativeNew = pathRelative + '/' + pathRelativeNew;
                }
                this.getPartitionInfos( (IpiLogicalFolder) childResource, pathRelativeNew, partitionInfos );
            } else {
                String name = childResource.getName( );
                String partitionName = null;
                if ( pathRelative != null ) {
                    partitionName = pathRelative + '/' + name;
                } else {
                    partitionName = name;
                }

                if ( this.partitionNameVerifier.isValidPartitionName( partitionName ) ) {
                    long time = childResource.lastChangedTime( );
                    PartitionInfo partitionInfo = new PartitionInfo( );
                    partitionInfo.partitionName = partitionName;
                    partitionInfo.timeStamp = time;

                    partitionInfos.add( partitionInfo );
                }
            }
        }

    }

    private String ensureNoTrailingFileSeparator( String path ) {

        if ( path.endsWith( "/" ) ) { //$NON-NLS-1$
            return path.substring( 0, path.length( ) - 1 );
        }

        return path;
    }

    public boolean textFileExists( PRI pri ) {

        String xlfName = pri.getPartitionName( ) + TEXT_FILE_EXTENSION;

        IpiLogicalResource fileRes = this.logicalFsFactory.getResource( this.getSourcePath( ) + SystemFileSeparator + xlfName );

        if ( fileRes != null ) {
            if ( fileRes.isFile( ) ) {
                return true;
            } else {
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.TEXT_RESOURCE_EXISTS_BUT_IS_FOLDER, pri, xlfName );
            }
        } else {
            return false;
        }
    }

    public IpiLogicalResource getPartitionResourceHandle( PRI pri ) {

        return this.logicalFsFactory.getResource( this.getSourcePath( ) + SystemFileSeparator + pri.getPartitionName( ) );

    }

    public IpiLogicalResource getTextFileResourceHandle( PRI pri ) {

        String xlfName = pri.getPartitionName( ) + TEXT_FILE_EXTENSION;
        return this.logicalFsFactory.getResource( this.getSourcePath( ) + SystemFileSeparator + xlfName );
    }
}
