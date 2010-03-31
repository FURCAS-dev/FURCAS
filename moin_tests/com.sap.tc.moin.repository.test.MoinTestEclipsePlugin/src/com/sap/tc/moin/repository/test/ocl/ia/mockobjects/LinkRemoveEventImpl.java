package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;

/**
 * Mock Link Remove Event
 */
public class LinkRemoveEventImpl extends LinkChangeEventImpl implements LinkRemoveEvent {

    /**
     * @param orderedElements
     * @param metaObject
     */
    public LinkRemoveEventImpl( CoreConnection connection, List<MRI> orderedElements, RefFeatured metaObject ) {

        super( connection, orderedElements, metaObject instanceof AssociationEndInternal ? ( (AssociationEndInternal) metaObject ).getContainer( connection ) : metaObject );
    }

}
