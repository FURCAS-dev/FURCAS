package com.sap.tc.moin.repository.core.events;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.LinkAddEvent}
 * 
 * @author Martin Kolb
 */
public class LinkAddEventImpl extends LinkChangeEventImpl implements LinkAddEvent {

    public LinkAddEventImpl( CoreConnection triggeringConnection, EndStorageLink link, int position ) {

        super( triggeringConnection, link, position );
    }

    public LinkAddEventImpl( CoreConnection triggeringConnection, ModelElement linkMetaObject, int linkPosition, MRI firstLinkEndMri, List<LRI> firstLinkEndParentLris, MofClass firstLinkEndMetaObject, MRI secondLinkEndMri, List<LRI> secondLinkEndParentLris, MofClass secondLinkEndMetaObject ) {

        super( triggeringConnection );
        associationMri = ( (Partitionable) linkMetaObject ).get___Mri( );
        this.position = linkPosition;
        byte storageEnd = eventTriggerConnection.getCoreJmiHelper( ).getStoredEnd( eventTriggerConnection.getSession( ), linkMetaObject );
        if ( storageEnd == 0 ) {
            if ( firstLinkEndMetaObject != null ) {
                affectedPartitionPRIs.add( ( (Partitionable) firstLinkEndMetaObject ).get___Partition( ).getPri( ) );
            }
            storedLinkEndMri = firstLinkEndMri;
            if ( secondLinkEndMri != null ) {
                nonStoredLinkEndLri = secondLinkEndMri.getLri( );
            }
        }
        if ( storageEnd == 1 ) {
            if ( secondLinkEndMetaObject != null ) {
                affectedPartitionPRIs.add( ( (Partitionable) secondLinkEndMetaObject ).get___Partition( ).getPri( ) );
            }
            storedLinkEndMri = secondLinkEndMri;
            if ( firstLinkEndMri != null ) {
                nonStoredLinkEndLri = firstLinkEndMri.getLri( );
            }
        }

        if ( firstLinkEndMri != null ) {
            linkEndInstanceMri0 = firstLinkEndMri;
            classFilterLris.add( ( (Partitionable) firstLinkEndMetaObject ).get___Mri( ).getLri( ) );
            getCompositeParentLRIsIncludingSelf( ).add( firstLinkEndMri.getLri( ) );
            getCompositeParentLRIsIncludingSelf( ).addAll( firstLinkEndParentLris );
        }
        if ( secondLinkEndMri != null ) {
            linkEndInstanceMri1 = secondLinkEndMri;
            classFilterLris.add( ( (Partitionable) secondLinkEndMetaObject ).get___Mri( ).getLri( ) );
            getCompositeParentLRIsIncludingSelf( ).add( secondLinkEndMri.getLri( ) );
            getCompositeParentLRIsIncludingSelf( ).addAll( secondLinkEndParentLris );
        }
        immediatePackageExtentLri = ( (Partitionable) linkMetaObject.refImmediatePackage( ) ).get___Mri( ).getLri( );
    }

    @Override
    protected String getTypeString( ) {

        return "LinkAddEvent"; //$NON-NLS-1$
    }
}
