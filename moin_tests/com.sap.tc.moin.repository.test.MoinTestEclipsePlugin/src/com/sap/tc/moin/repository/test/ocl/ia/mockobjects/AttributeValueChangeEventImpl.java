package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;

/**
 * The mock attribute value changed event
 */
public class AttributeValueChangeEventImpl extends AttributeValueEventImpl implements AttributeValueChangeEvent {

    private Object oldValue;

    private Object newValue;

    /**
     * @param affectedElement
     * @param affectedAttr
     * @param oldValue
     * @param newValue
     */
    public AttributeValueChangeEventImpl( CoreConnection connection, RefObject affectedElement, Attribute affectedAttr, Object oldValue, Object newValue ) {

        super( connection, affectedElement, affectedAttr );
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.AttributeValueChangeEvent#getOldValue()
     */
    public Object getOldValue( ) {

        return this.oldValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.AttributeValueChangeEvent#getNewValue()
     */
    public Object getNewValue( ) {

        return this.newValue;
    }

}
