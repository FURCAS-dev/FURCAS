package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.LinkRemoveEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public class LinkRemoveEventImpl extends LinkChangeEventImpl implements LinkRemoveEvent {


    public LinkRemoveEventImpl( CoreConnection triggeringConnection, EndStorageLink link, int position ) {

        super( triggeringConnection, link, position );
    }

    @Override
    protected String getTypeString( ) {

        return "LinkRemoveEvent"; //$NON-NLS-1$
    }
}
