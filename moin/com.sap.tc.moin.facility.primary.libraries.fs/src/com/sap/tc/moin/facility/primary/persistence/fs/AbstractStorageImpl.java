/*
 * Created on 04.10.2005
 */
package com.sap.tc.moin.facility.primary.persistence.fs;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * Common part of the implementation of the file system based persistence API,
 * which can deal with a single directory, for example within a NWDI DC or a
 * JaPro subproject.
 */
public abstract class AbstractStorageImpl implements IpiStorage {

    protected SpiPartitionNameVerifier partitionNameVerifier;

    protected IpiLogicalFsFactory logicalFsFactory;

    /**
     * The container this storage operates in.
     */
    final CRI cri;

    /**
     * The name of the resource folder this storage operates on.
     */
    final private String resourceFolder;

    /**
     * The base path to the resource folder this storage operates on.
     */
    final private String sourcePath;

    public AbstractStorageImpl( CRI cri, String resourceFolder, String sourcePath, SpiPartitionNameVerifier partitionNameVerifier, IpiLogicalFsFactory logicalFsFactory ) {

        // input checks
        assert ( cri != null ) : PersistenceFsMessages.ARGUMENT_MUST_NOT_BE_NULL.format( "cri" ); //$NON-NLS-1$
        assert ( resourceFolder != null ) : PersistenceFsMessages.ARGUMENT_MUST_NOT_BE_NULL.format( "resourceFolder" ); //$NON-NLS-1$
        assert ( sourcePath != null ) : PersistenceFsMessages.ARGUMENT_MUST_NOT_BE_NULL.format( "sourcePath" ); //$NON-NLS-1$

        this.partitionNameVerifier = partitionNameVerifier;
        this.logicalFsFactory = logicalFsFactory;
        this.cri = cri;
        this.resourceFolder = resourceFolder;
        this.sourcePath = sourcePath;
    }

    public String getSourcePath( ) {

        return sourcePath;
    }

    public String getResourceFolder( ) {

        return this.resourceFolder;
    }

    @Override
    public String toString( ) {

        StringBuilder stringBuilder = new StringBuilder( );

        stringBuilder.append( this.getClass( ).getName( ) ).append( ": " ); //$NON-NLS-1$
        stringBuilder.append( "cri=" ).append( this.cri ).append( "; " ); //$NON-NLS-1$ //$NON-NLS-2$
        stringBuilder.append( "sourcePath=" ).append( this.sourcePath ).append( "; " ); //$NON-NLS-1$ //$NON-NLS-2$
        stringBuilder.append( "resourceFolder=" ).append( this.resourceFolder ); //$NON-NLS-1$

        return stringBuilder.toString( );
    }

    public boolean isResponsible( PRI pri ) {

        boolean isResponsible = false;

        // compare container
        if ( this.cri == pri.getCri( ) ) {
            // compare resource folder if registered
            if ( pri.getPartitionName( ).startsWith( this.resourceFolder ) ) {
                isResponsible = true;
            }
        }
        return isResponsible;
    }

}
