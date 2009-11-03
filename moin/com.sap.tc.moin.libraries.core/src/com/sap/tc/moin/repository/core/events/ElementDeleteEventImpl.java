package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.ElementDeleteEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public class ElementDeleteEventImpl extends ElementLifeCycleEventImpl implements ElementDeleteEvent {

    /**
     * @param affectedElement the element that shall be / was deleted
     */
    public ElementDeleteEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement ) {

        super( triggeringConnection, affectedElement );
    }

    @Override
    protected String getTypeString( ) {

        return "ElementDeleteEvent"; //$NON-NLS-1$
    }

    @Override
    protected String getParameterString( ) {

        return super.getParameterString( ) + ",MRI=" + getAffectedElementMri( ).toString( ); //$NON-NLS-1$
    }
}
