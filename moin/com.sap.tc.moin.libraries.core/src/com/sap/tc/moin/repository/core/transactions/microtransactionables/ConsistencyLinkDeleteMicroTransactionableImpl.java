package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.ConsistencyLinkDeleteMicroTransactionable;

public class ConsistencyLinkDeleteMicroTransactionableImpl extends AbstractMicroTransactionable implements ConsistencyLinkDeleteMicroTransactionable {

    private EndStorageLink endStorageLinkToDelete;

    public ConsistencyLinkDeleteMicroTransactionableImpl( CoreConnection aConnection, EndStorageLink link ) {

        super( aConnection );
        this.endStorageLinkToDelete = link;
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // getOrCreateUndoActions( ).add( ActionFactory.createLinkAddAction( connection, endStorageLinkToDelete, -1, endStorageLinkToDelete.getOrderedEnd( ) != -1 ) );
        String attributeOrAssociationEndMofId = null;
        RefObject metaObject = endStorageLinkToDelete.getMetaObject( );
        if ( metaObject instanceof Association ) {
            AssociationEnd end = getJmiHelper( ).getAssociationEnds( getConnection( ).getSession( ), (Association) metaObject ).get( endStorageLinkToDelete.getEndNumberOfOtherEnd( ) );
            attributeOrAssociationEndMofId = end.refMofId( );
        } else {
            attributeOrAssociationEndMofId = metaObject.refMofId( );
        }
        getOrCreateUndoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, endStorageLinkToDelete.getStorageEnd( ).getMri( ), attributeOrAssociationEndMofId, endStorageLinkToDelete, -1 ) );
        // clear caused dirty state
        addClearDirtyActionsToUndoActions( );
        // release obtained locks
        addReleaseLockActionsToUndoActions( );
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        computeDoActionsAndDoEvents( false );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            PRI affectedPartitionPri = this.endStorageLinkToDelete.getStorageEnd( ).getPri( );
            computePartitionsToLock( affectedPartitionPri );
            computePartitionsToEnsureEditing( affectedPartitionPri );
            computePartitionsToMarkDirty( affectedPartitionPri );
        }
        // aquire locks
        addEditLockActionsToDoActions( );
        // ensure editing allowed
        addEnsureEditingActionsToDoActions( );
        copyOnWrite( );
        // only delete link if it is still existing
        // copyOnWrite() might have reset the link to delete
        if ( this.endStorageLinkToDelete != null ) {

            String attributeOrAssociationEndMofId = null;
            RefObject metaObject = endStorageLinkToDelete.getMetaObject( );
            if ( metaObject instanceof Association ) {
                AssociationEnd end = getJmiHelper( ).getAssociationEnds( getConnection( ).getSession( ), (Association) metaObject ).get( endStorageLinkToDelete.getEndNumberOfOtherEnd( ) );
                attributeOrAssociationEndMofId = end.refMofId( );
            } else {
                attributeOrAssociationEndMofId = metaObject.refMofId( );
            }
            getOrCreateUndoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, endStorageLinkToDelete.getStorageEnd( ).getMri( ), attributeOrAssociationEndMofId, endStorageLinkToDelete, -1 ) );
            // set the dirty state
            addMarkDirtyActionsToDoActions( );
        }
    }

    private void copyOnWrite( ) {

        createPrivateCopy( endStorageLinkToDelete.getStorageEnd( ).getPri( ) );
        CorePartitionable element = getExistingElement( endStorageLinkToDelete.getStorageEnd( ).getMri( ) );
        RefObject metaObject = endStorageLinkToDelete.getMetaObject( );
        if ( metaObject instanceof Association ) {
            List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) metaObject );
            AssociationEnd end = ends.get( endStorageLinkToDelete.getEndNumberOfOtherEnd( ) );
            if ( end.getMultiplicity( ).getUpper( ) == 1 ) {
                endStorageLinkToDelete = ( (RefFeaturedExtension) element ).get___AssociationLink( end.refMofId( ) );
            } else {
                Collection<EndStorageLink> links = ( (RefFeaturedExtension) element ).get___AssociationLinks( end.refMofId( ) );
                findAndUpdateEndStorageLinkToDelete( links );
            }
        } else {
            Attribute attribute = (Attribute) endStorageLinkToDelete.getMetaObject( );
            if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                endStorageLinkToDelete = ( (RefFeaturedExtension) element ).get___AttributeLink( attribute.refMofId( ) );
            } else {
                Collection<EndStorageLink> links = ( (RefFeaturedExtension) element ).get___AttributeLinks( attribute.refMofId( ) );
                findAndUpdateEndStorageLinkToDelete( links );
            }
        }
    }

    private void findAndUpdateEndStorageLinkToDelete( Collection<EndStorageLink> linksToSearch ) {

        boolean linkFound = false;
        for ( EndStorageLink link : linksToSearch ) {
            if ( link.getOtherEndLri( ).equals( endStorageLinkToDelete.getOtherEndLri( ) ) ) {
                endStorageLinkToDelete = link;
                linkFound = true;
                break;
            }
        }
        assert linkFound : MicroTransactionablesMessages.COULDNOTFINDENDSTORAGELINKTODELETE;
    }
}