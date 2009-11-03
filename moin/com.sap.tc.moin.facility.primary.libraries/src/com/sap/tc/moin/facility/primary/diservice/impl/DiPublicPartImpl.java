package com.sap.tc.moin.facility.primary.diservice.impl;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiPublicPartProvider;
import com.sap.tc.moin.repository.PRI;

/**
 * @author d021091
 */

/**
 * hot_todo: Add implementation of missing parts of component model, i.e.:
 * handling of public parts with different kinds of entity types:
 * <p> - Model File
 * <p> - Model Folder
 * <p> - Modeling Folder Tree
 */

public class DiPublicPartImpl {

    /** ******************** Internals ************************************** */

    private final IpiDiPublicPartProvider _diPublicPartProvider;

    private final DiConfigurationImpl _diConfiguration;

    /** ******************** Construction *********************************** */

    DiPublicPartImpl( IpiDiPublicPartProvider diPublicPartProvider, DiConfigurationImpl diConfiguration ) {

        _diPublicPartProvider = diPublicPartProvider;
        _diConfiguration = diConfiguration;
    }

    /** ************************* API *************************************** */

    public String getName( ) {

        // Lazy retrieval:
        return _diPublicPartProvider.getName( );
    }

    public DiDevelopmentComponentImpl getDevelopmentComponent( ) {

        // Lazy retrieval:
        return _diConfiguration.getOrCreateMoinDcDefinition( _diPublicPartProvider.getDevelopmentComponent( ) );
    }

    public boolean hasPurposeCompilation( ) {

        // Lazy retrieval:
        return _diPublicPartProvider.hasPurpose( IpiDiPublicPartProvider.Purpose.COMPILATION );
    }

    public boolean containsPartition( PRI partition ) {

        // This public part contains the given partition when:
        // (1) the public part and the partition belong to the same DC 
        String partitionContainerName = partition.getContainerName( );
        if ( !partitionContainerName.equals( getDevelopmentComponent( ).getModelContainerName( ) ) ) {
            return false;
        }

        // (2) the partition is contained in this public part
        // todo: First hard coded impl: all partitions of the DC are contained in the public part
        // todo: Final impl: the entity types in the public part describe which partitions are contained --> interpret the entity types
        return true;
    }

    /**
     * hot_todo: Complete implementation of component model, i.e.: handling of
     * public parts with different kinds of entity types:
     * <p> - Model File
     * <p> - Model Folder
     * <p> - Modeling Folder Tree
     */

    /**
     * A reset-method is not needed:
     * <p>
     * If a DC has changed then DiDevelopmentComponentImpl takes care for a
     * proper refresh. The DiPublicPartImpl objects are not cached up to now and
     * do not need to be refreshed therefore.
     */

}
