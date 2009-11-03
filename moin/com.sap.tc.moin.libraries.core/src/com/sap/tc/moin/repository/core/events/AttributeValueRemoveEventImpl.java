package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public class AttributeValueRemoveEventImpl extends AttributeMultiValueEventImpl implements AttributeValueRemoveEvent {

    /**
     * creates a new instance of <code>AttributeValueRemoveEventImpl</code>.
     * 
     * @see AttributeValueRemoveEvent
     * @param affectedElement the element in which the attribute is/was
     * contained
     * @param attributeMetaObject the type of the attribute
     * @param value the value of the removed attribute
     */
    public AttributeValueRemoveEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value ) {

        super( triggeringConnection, affectedElement, attributeMetaObject, value );
    }

    /**
     * creates a new instance of <code>AttributeValueRemoveEventImpl</code>.
     * This constructor is meant for attributes that are contained in a list.
     * 
     * @see AttributeValueRemoveEvent
     * @param affectedElement the element in which the attribute is/was
     * contained
     * @param attributeMetaObject the type of the attribute
     * @param value the value of the removed attribute
     * @param position the position of the attribute in the list
     */
    public AttributeValueRemoveEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position ) {

        super( triggeringConnection, affectedElement, attributeMetaObject, position, value );
    }

    @Override
    protected String getTypeString( ) {

        return "AttributeValueRemoveEvent"; //$NON-NLS-1$
    }

}
