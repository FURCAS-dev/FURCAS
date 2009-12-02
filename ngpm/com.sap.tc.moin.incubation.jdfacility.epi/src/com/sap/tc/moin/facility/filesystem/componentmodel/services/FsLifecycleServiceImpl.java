package com.sap.tc.moin.facility.filesystem.componentmodel.services;

import com.sap.tc.moin.facility.componentmodel.services.LifecycleServiceImpl;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


public class FsLifecycleServiceImpl extends LifecycleServiceImpl {

    private IpiFsResourceManagement _fsPersistenceResourceHandler;

    private SpiPartitionSerializationManager _partitionSerializationManager;

    // binding
    public void bind( IpiFsResourceManagement fsPersistenceResourceHandler ) {

        _fsPersistenceResourceHandler = fsPersistenceResourceHandler;
    }

    public void bind( SpiPartitionSerializationManager partitionSerializationManager ) {

        _partitionSerializationManager = partitionSerializationManager;
    }


    // Create, edit, delete
    @Override
    public void ensureCreatingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionCreatingNotPossibleException {

        super.ensureCreatingAllowed( pri, clientSpec );

        if ( !_partitionSerializationManager.isSerializerAvailable( pri ) ) {
            throw new PartitionCreatingNotPossibleException( FsLifeCycleMessages.PARTITION_NO_SERIALIZER, pri );
        }
        //
        PartitionIsCreatableResultRecord resultRecord = null;
        try {
            resultRecord = _fsPersistenceResourceHandler.partitionIsCreatable( pri );
        } catch ( Exception e ) {
            throw new PartitionCreatingNotPossibleException( e, FsLifeCycleMessages.ERR_PCREATE_FSERROR, pri );
        }

        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.CREATABLE ) {
            return;
        }

        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT ) {
            throw new PartitionCreatingNotPossibleException( FsLifeCycleMessages.ERR_PCREATE_NAME_CONFLICT, pri, resultRecord.existingPath );
        }

        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS ) {
            throw new PartitionCreatingNotPossibleException( FsLifeCycleMessages.ERR_PCREATE_DUPLICATE, pri );
        }

        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_RESOURCE_ARCHIVE_NOT_WRITEABLE ) {
            throw new PartitionCreatingNotPossibleException( FsLifeCycleMessages.ERR_PCREATE_ARCHIVE_NOT_WRITEABLE, pri );
        }
    }

    @Override
    public void ensureDeletingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionDeletingNotPossibleException {

        super.ensureDeletingAllowed( pri, clientSpec );

        if ( !_fsPersistenceResourceHandler.partitionExists( pri ) ) {
            throw new PartitionDeletingNotPossibleException( FsLifeCycleMessages.ERR_PDEL_MISSING, pri );
        }
        if ( _fsPersistenceResourceHandler.partitionIsReadOnly( pri ) ) {
            throw new PartitionDeletingNotPossibleException( FsLifeCycleMessages.ERR_PDEL_READONLY, pri );
        }
    }

    @Override
    public void ensureEditingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionEditingNotPossibleException {

        super.ensureEditingAllowed( pri, clientSpec );

        if ( !_partitionSerializationManager.isSerializerAvailable( pri ) ) {
            throw new PartitionEditingNotPossibleException( FsLifeCycleMessages.PARTITION_NO_SERIALIZER, pri );
        }

        if ( !_fsPersistenceResourceHandler.partitionExists( pri ) ) {
            throw new PartitionEditingNotPossibleException( FsLifeCycleMessages.ERR_PEDIT_MISSING, pri );
        }
        if ( _fsPersistenceResourceHandler.partitionIsReadOnly( pri ) ) {
            throw new PartitionDeletingNotPossibleException( FsLifeCycleMessages.ERR_PEDIT_READONLY, pri );
        }
    }

};