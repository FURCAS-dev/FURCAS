package com.sap.tc.moin.friends.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.friends.AssociationLink;
import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;

public class RefObjectUtilImpl implements RefObjectUtil {

    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target ) {

        addLinkTarget( host, targetAssociationEnd, target, -1 );
    }

    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target, int position ) {

        if ( host == null ) {
            throw new MoinIllegalNullArgumentException( "host" ); //$NON-NLS-1$
        }
        AssociationEnd unwrappedAssocEnd = targetAssociationEnd != null ? ( (AbstractConnectionAwareWrapper<AssociationEnd>) targetAssociationEnd ).unwrap( ) : null;
        AbstractConnectionAwareWrapper<RefObject> hostWrapper = ( (AbstractConnectionAwareWrapper<RefObject>) host );
        RefObject unwrappedHost = hostWrapper.unwrap( );
        synchronized ( hostWrapper.getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            hostWrapper.assertConnectionAlive( );
            hostWrapper.attachConnectionIfRequired( );
            CoreConnection connection = hostWrapper.getCoreConnection( );
            connection.addLinkTarget( unwrappedHost, unwrappedAssocEnd, target, position );
        }
    }

    public AssociationLink getCompositeAssociationParentLink( RefObject child ) {

        if ( child == null ) {
            throw new MoinIllegalNullArgumentException( "child" ); //$NON-NLS-1$
        }
        AbstractConnectionAwareWrapper<RefObject> hostWrapper = ( (AbstractConnectionAwareWrapper<RefObject>) child );
        RefObject unwrappedHost = hostWrapper.unwrap( );
        synchronized ( hostWrapper.getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            hostWrapper.assertConnectionAlive( );
            hostWrapper.attachConnectionIfRequired( );
            EndStorageLink endStorageLink = ( (RefObjectImpl) unwrappedHost ).get___CompositeParentLink( );
            if ( endStorageLink != null && endStorageLink.getMetaObject( ) instanceof Association ) {
                AssociationLinkImpl associationLink = new AssociationLinkImpl( endStorageLink.getStorageEnd( ).getMri( ), endStorageLink.getOtherEnd( ).getLri( ), endStorageLink.getMetaObjectMri( ), -1 );
                return associationLink;
            }
            return null;
        }
    }

    public void deleteIsolated( RefObject elementToDelete ) {

        if ( elementToDelete == null ) {
            throw new MoinIllegalNullArgumentException( "elementToDelete" ); //$NON-NLS-1$
        }
        AbstractConnectionAwareWrapper<RefObject> elementWrapper = ( (AbstractConnectionAwareWrapper<RefObject>) elementToDelete );
        CorePartitionable unwrappedElementToDelete = (CorePartitionable) elementWrapper.unwrap( );
        synchronized ( elementWrapper.getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            elementWrapper.assertConnectionAlive( );
            elementWrapper.attachConnectionIfRequired( );
            CoreConnection connection = elementWrapper.getCoreConnection( );
            unwrappedElementToDelete.delete___Isolated( connection );
        }
    }

    public Collection<AssociationLink> getAssociationLinks( RefObject element ) {

        if ( element == null ) {
            throw new MoinIllegalNullArgumentException( "element" ); //$NON-NLS-1$
        }
        AbstractConnectionAwareWrapper<RefObject> elementWrapper = ( (AbstractConnectionAwareWrapper<RefObject>) element );
        RefObject unwrappedElement = elementWrapper.unwrap( );
        SynchronizationManager synchronizationManager = elementWrapper.getSynchronizationManager( );
        synchronizationManager.acquireReadLock( );
        try {
            elementWrapper.assertConnectionAlive( );
            elementWrapper.attachConnectionIfRequired( );
            RefFeaturedExtension extendedElement = (RefFeaturedExtension) unwrappedElement;
            List<EndStorageLink> allStoredAssociationLinks = extendedElement.get___AllStoredAssociationLinks( );
            if ( allStoredAssociationLinks != null ) {
                ArrayList<AssociationLink> result = new ArrayList<AssociationLink>( allStoredAssociationLinks.size( ) );
                RefObject currentMetaObject = null;
                Association formerMetaObject = null;
                boolean positionRelevant = false;
                int position = -1;
                //the algorithm assumes that the links are grouped by metaobject
                for ( int i = 0, n = allStoredAssociationLinks.size( ); i < n; i++ ) {
                    EndStorageLink endStorageLink = allStoredAssociationLinks.get( i );
                    currentMetaObject = endStorageLink.getMetaObject( );
                    if ( !currentMetaObject.equals( formerMetaObject ) ) {
                        //switch to other metaobject
                        formerMetaObject = (Association) currentMetaObject;
                        int orderedEnd = endStorageLink.getOrderedEnd( );
                        if ( orderedEnd != -1 && orderedEnd == endStorageLink.getEndNumberOfOtherEnd( ) ) {
                            positionRelevant = true;
                            position = 0;
                        } else {
                            positionRelevant = false;
                            position = -1;
                        }
                    }
                    AssociationLinkImpl associationLink = new AssociationLinkImpl( endStorageLink.getStorageEnd( ).getMri( ), endStorageLink.getOtherEnd( ).getLri( ), ( (Partitionable) currentMetaObject ).get___Mri( ), position );
                    result.add( associationLink );
                    if ( positionRelevant ) {
                        position++;
                    }
                }
                return result;
            }
            return Collections.emptyList( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }
}