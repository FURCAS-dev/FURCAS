package com.sap.tc.moin.facility.primary.riservice;

import java.util.Set;

import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * This Di implementation of ResourceIdentifierVerifier knows about the format
 * of resource identifiers in the PrimaryFacility.
 * 
 * @author d047015
 */
public class DiResourceIdentifierVerifierImpl implements ResourceIdentifierVerifier {

    private IpiFsResourceManagement fsResourceHandler;

    private SpiPartitionNameVerifier partitionSerializationManager;

    protected DiResourceIdentifierVerifierImpl( IpiFsResourceManagement fsResourceHandler, SpiPartitionNameVerifier serializationManager ) {

        this.fsResourceHandler = fsResourceHandler;
        this.partitionSerializationManager = serializationManager;
    }

    /**
     * Performs dynamic checks on the given {@link PRI}. <br>
     * The result of those checks depend on the current state of MOIN.
     * <p>
     * The following checks are performed:<br>
     * - the <code>partitionName</code> starts with a prefix which is currently
     * backed by a registered resource folder for the given <code>cri</code><br>
     * - the <code>partitionName</code> is formed upon a currently registered
     * name pattern
     * 
     * @param pri The {@link PRI} to check
     * @throws InvalidResourceIdentifierException if one of the performed checks
     * fails
     */
    public void performDynamicValidation( PRI pri ) {

        // checks must not be performed on volatile and mm partitions
        if ( !pri.isMetaModelPartition( ) && !pri.isVolatilePartition( ) ) {

            // check if the partition name starts with a prefix which is currently backed by a registered resource folder for the given CRI 
            if ( !isPrefixBackedByRegisterdResourceFolder( pri.getCri( ), pri.getPartitionName( ) ) ) {
                Set<String> resourceFoldersForCri = this.fsResourceHandler.getRegisteredResourceFoldersForContainer( pri.getCri( ) );
                throw new InvalidResourceIdentifierException( RiServiceMessages.INVALIDRESOURCEFOLDER, pri.getPartitionName( ), pri.getCri( ), resourceFoldersForCri );
            }

            // check if the partition name is formed upon a currently registered name pattern
            try {
                this.partitionSerializationManager.validatePartitionName( pri.getPartitionName( ) );
            } catch ( MoinLocalizedBaseRuntimeException e ) {
                // wrap caught exception in correct exception type
                throw new InvalidResourceIdentifierException( e );
            }

        }
    }

    /**
     * Determines registered resource folders for a given <code>cri</code> and
     * checks if the given <code>partitionName</code> starts with one of them.
     * 
     * @param cri The container which hosts the partition
     * @param partitionName The partition name to check
     * @return <code>true</code> if the partition name starts with a resource
     * folder registered for the given container, <code>false</code> otherwise
     */
    private boolean isPrefixBackedByRegisterdResourceFolder( CRI cri, String partitionName ) {

        Set<String> allowedPartitionPrefixes = this.fsResourceHandler.getRegisteredResourceFoldersForContainer( cri );
        for ( String allowedPartitionPrefix : allowedPartitionPrefixes ) {
            if ( partitionName.startsWith( allowedPartitionPrefix ) ) {
                return true;
            }
        }
        return false;
    }

}
