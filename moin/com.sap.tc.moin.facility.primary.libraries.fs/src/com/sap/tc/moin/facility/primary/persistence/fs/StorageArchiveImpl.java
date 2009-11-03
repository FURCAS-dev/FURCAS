/*
 * Created on 04.10.2005
 */
package com.sap.tc.moin.facility.primary.persistence.fs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * The implementation of the file system based persistence API, which can deal
 * with a single build result, which is a JAR.
 * 
 * @author d025744
 */
public class StorageArchiveImpl extends AbstractStorageImpl implements IpiStorage {

    public StorageArchiveImpl( CRI cri, String resourceFolder, String sourcePath, SpiPartitionNameVerifier serializationManager, IpiLogicalFsFactory logicalFsFactory ) {

        super( cri, resourceFolder, sourcePath, serializationManager, logicalFsFactory );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#isPartitionReadonly(com.sap.tc
     * .moin.repository.PRI, com.sap.tc.moin.repository.spi.core.Stage)
     */
    public boolean isPartitionReadonly( PRI pri ) {

        // always read only
        return true;
    }

    public PartitionIsCreatableResultRecord isPathCreatable( String relativePath ) {

        throw new MoinUnsupportedOperationException( PersistenceFsMessages.METHODNOTSUPPORTEDFORTHISIMPLEMENTATION );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#getOutputStreamForPartitionStore
     * (com.sap.tc.moin.repository.spi.core.SpiModelPartition)
     */
    public OutputStream getOutputStreamForPartitionStore( PRI pri ) {

        throw new MoinUnsupportedOperationException( PersistenceFsMessages.METHODNOTSUPPORTEDFORTHISIMPLEMENTATION );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#getOutputStreamForPartitionTextStore
     * (com.sap.tc.moin.repository.spi.core.SpiModelPartition)
     */
    public OutputStream getOutputStreamForPartitionTextStore( PRI pri ) {

        throw new MoinUnsupportedOperationException( PersistenceFsMessages.METHODNOTSUPPORTEDFORTHISIMPLEMENTATION );
    }

    public InputStream getInputStreamForPartitionLoad( PRI pri ) {

        InputStream is = null;

        IpiLogicalFile archive = this.getSourcePathArchive( );
        if ( archive != null ) {
            is = archive.getArchiveContent( pri.getPartitionName( ) );
        }

        return is;
    }

    public InputStream getInputStreamForPartitionTextLoad( PRI pri ) {

        InputStream is = null;

        IpiLogicalFile archive = this.getSourcePathArchive( );
        if ( archive != null ) {
            is = archive.getArchiveContent( pri.getPartitionName( ) + StorageDirectoryImpl.TEXT_FILE_EXTENSION );
        }

        return is;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#deletePartition(com.sap.tc.moin
     * .repository.PRI, com.sap.tc.moin.repository.spi.core.Stage)
     */
    public boolean deletePartition( PRI pri ) {

        throw new MoinUnsupportedOperationException( PersistenceFsMessages.METHODNOTSUPPORTEDFORTHISIMPLEMENTATION );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.fs.Storage#deletePartitionTexts(com.sap.tc
     * .moin.repository.PRI)
     */
    public boolean deletePartitionTexts( PRI pri ) {

        throw new MoinUnsupportedOperationException( PersistenceFsMessages.METHODNOTSUPPORTEDFORTHISIMPLEMENTATION );
    }

    public List<PartitionInfo> getPartitionInfos( ) {

        List<PartitionInfo> partitionInfos = new ArrayList<PartitionInfo>( );

        String sourcePath = this.getSourcePath( );
        if ( sourcePath != null ) {
            String resourceFolderId = this.getResourceFolder( );
            if ( resourceFolderId == null ) {
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.RESOURCE_FOLDER_NOT_ALLOWED, this.getSourcePath( ), this.cri.getDataAreaDescriptor( ).getDataAreaName( ), this.cri.getContainerName( ) );
            }
            File file = new File( sourcePath );
            long changed = file.lastModified( );

            ZipFile zipFile = null;
            try {
                zipFile = new ZipFile( sourcePath );
                Enumeration<? extends ZipEntry> enumeration = zipFile.entries( );
                while ( enumeration.hasMoreElements( ) ) {
                    ZipEntry je = enumeration.nextElement( );
                    String partitionName = je.getName( );
                    if ( this.partitionNameVerifier.isValidPartitionName( partitionName ) ) {
                        if ( partitionName.startsWith( resourceFolderId ) ) {
                            PartitionInfo partitionInfo = new PartitionInfo( );
                            partitionInfo.partitionName = partitionName;
                            partitionInfo.timeStamp = changed;
                            partitionInfos.add( partitionInfo );
                        }
                    }
                }
            } catch ( IOException e ) {
                throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.UNABLE_TO_OPEN_ARCHIVE_FOR_READING, sourcePath );
            } finally {
                if ( zipFile != null ) {
                    try {
                        zipFile.close( );
                    } catch ( IOException e ) {
                        throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.UNABLE_TO_CLOSE_ARCHIVE, sourcePath );
                    }
                }
            }
        }

        return partitionInfos;
    }

    public long partitionLastChanged( PRI pri ) {

        long lastChanged = 0;

        IpiLogicalFile sourcePathArchive = this.getSourcePathArchive( );
        if ( sourcePathArchive != null ) {
            lastChanged = sourcePathArchive.lastChangedTime( );
        }

        return lastChanged;
    }

    public long partitionFileSize( PRI pri ) {

        long fileSize = -1;

        IpiLogicalFile archive = this.getSourcePathArchive( );
        if ( archive != null ) {
            fileSize = archive.getArchiveContentLength( pri.getPartitionName( ) );
        }

        return fileSize;
    }

    /**
     * Returns the logical file referenced by the source path or null if the
     * <code>sourcePath</code> is null.
     */
    private IpiLogicalFile getSourcePathArchive( ) {

        IpiLogicalFile sourcePathArchive = null;

        IpiLogicalResource res = this.logicalFsFactory.getResource( this.getSourcePath( ) );
        if ( res != null ) {
            if ( res.isFile( ) ) {
                sourcePathArchive = (IpiLogicalFile) res;
            } else {
                // source path references a file (folder expected)
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.ILLEGAL_SOURCE_PATH_DETECTED_ARCHIVE, res.getPath( ) );
            }
        }

        return sourcePathArchive;
    }

    public boolean textFileExists( PRI pri ) {

        String xlfName = pri.getPartitionName( ) + StorageDirectoryImpl.TEXT_FILE_EXTENSION;

        IpiLogicalFile archive = this.getSourcePathArchive( );
        return archive != null && archive.existsInArchive( xlfName );

    }

    public IpiLogicalResource getPartitionResourceHandle( PRI pri ) {

        return null;
    }

    public IpiLogicalResource getTextFileResourceHandle( PRI pri ) {

        return null;
    }
}
