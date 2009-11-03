package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyMappingEntry;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * This class wraps a mapping table, so that the elements returned are always
 * wrapped elements.
 * 
 * @author d046918
 */

public class DeepCopyMapWrapper implements DeepCopyMap, Wrapper {

    private DeepCopyMap copyMap;

    private WorkspaceSet wsSet;

    private CoreConnection coreConn;

    private SynchronizationManager synchronizationManager;

    public DeepCopyMapWrapper( DeepCopyMap map, CoreConnection coreConn ) {

        copyMap = map;
        this.coreConn = coreConn;
        this.wsSet = coreConn.getSession( ).getWorkspaceSet( );
        this.synchronizationManager = this.wsSet.getSynchronizationManager( );
    }

    public void setMap( DeepCopyMap map ) {

        copyMap = map;
    }

    public DeepCopyMappingEntry get( RefObject wElement ) {

        synchronizationManager.acquireReadLock( );
        try {
            DeepCopyMappingEntry entry = copyMap.get( wElement );
            if ( entry == null ) {
                return null;
            }
            RefObject mappingTarget = entry.getMappingTarget( );
            RefObject wrappedElement = null;
            if ( mappingTarget != null ) {
                RefObject element = (RefObject) this.coreConn.getElement( mappingTarget.get___Mri( ) );
                wrappedElement = (RefObject) wsSet.getWrapperManager( ).wrapObject( coreConn, element );
            }

            return new DeepCopyMappingEntry( entry.getOriginalPolicy( ), entry.getModifiedPolicy( ), wrappedElement );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean containsKey( RefObject wElement ) {

        synchronizationManager.acquireReadLock( );
        try {
            return copyMap.containsKey( (RefObject) ( (Wrapper) wElement ).unwrap( ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public Object unwrap( ) {

        return copyMap;
    }

    @Override
    public String toString( ) {

        return copyMap.toString( );
    }

}
