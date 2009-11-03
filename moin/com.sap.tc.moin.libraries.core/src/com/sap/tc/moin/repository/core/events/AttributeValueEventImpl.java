package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.AttributeValueEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public abstract class AttributeValueEventImpl extends ElementChangeEventImpl implements AttributeValueEvent {

    protected MRI attributeMri = null;

    protected AttributeValueEventImpl( CoreConnection triggeringConnection ) {

        super( triggeringConnection );
    }

    /**
     * creates an instance of <code>AttributeValueEventImpl</code>.
     * 
     * @see AttributeValueEvent
     * @param affectedElement the element that contains the changed attribute
     * @param attributeMetaObject the type of the changed attribute
     */
    protected AttributeValueEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject ) {

        super( triggeringConnection, affectedElement );

        attributeMri = ( (Partitionable) attributeMetaObject ).get___Mri( );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.AttributeValueEvent#
     * getAffectedMetaObjectMri()
     */
    public MRI getAffectedMetaObjectMri( ) {

        return attributeMri;
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.AttributeValueEvent#getAffectedMetaObject
     * (com.sap.tc.moin.repository.core.impl.Connection)
     */
    public Attribute getAffectedMetaObject( Connection resolvingConnection ) {

        return (Attribute) resolvingConnection.getElement( attributeMri );
    }

    @Override
    protected String getParameterString( ) {

        Attribute attribute = getAffectedMetaObject( eventTriggerConnection );
        return super.getParameterString( ) + ",attribute=" + attribute.getName( ); //$NON-NLS-1$
    }

    protected static Object getCorrectedValue( Object value ) {

        if ( value instanceof Partitionable ) {
            return ( (Partitionable) value ).get___Mri( ).getLri( );
        } else if ( value instanceof MRI ) {
            return ( (MRI) value ).getLri( );
        }
        return value;
    }

}
