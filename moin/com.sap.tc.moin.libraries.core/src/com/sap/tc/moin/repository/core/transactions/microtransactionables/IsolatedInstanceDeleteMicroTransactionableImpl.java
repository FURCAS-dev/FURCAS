package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;

public class IsolatedInstanceDeleteMicroTransactionableImpl extends SingleInstanceDeleteMicroTransactionableImpl {

    public IsolatedInstanceDeleteMicroTransactionableImpl( CoreConnection aConnection, RefObject aRefObject ) {

        super( aConnection, aRefObject );
    }

    @Override
    protected void computeParentData( ) {

        //do nothing as we want to delete only the element itself
    }

    @Override
    protected Map<EndStorageLink, Integer> getLinksToDelete( ArrayList<CorePartitionable> instancesToDelete ) {

        //for the isolated deletion of an element, only links that have storage at the element are removed
        //links that have storage at the "other end" must not be deleted, therefore they are filtered out here
        Map<EndStorageLink, Integer> linksToDelete = super.getLinksToDelete( instancesToDelete );
        for ( Iterator<EndStorageLink> iterator = linksToDelete.keySet( ).iterator( ); iterator.hasNext( ); ) {
            EndStorageLink link = iterator.next( );
            if ( !link.getStorageEnd( ).getMri( ).equals( ( (CorePartitionable) this.instanceDeleted ).get___Mri( ) ) ) {
                iterator.remove( );
            }
        }
        return linksToDelete;
    }



}
