package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;

/**
 * Abstract mock event
 */
public abstract class AttributeValueEventImpl extends ElementChangeEventImpl implements AttributeValueEvent {

    private Attribute affectedAttribute;

    private MRI affectedMOMri;

    /**
     * @param affectedElement
     * @param affectedAttr
     */
    public AttributeValueEventImpl( CoreConnection connection, RefObject affectedElement, Attribute affectedAttr ) {

        super( connection, affectedElement );
        this.affectedAttribute = affectedAttr;
        this.affectedMOMri = new MRIImpl( this.affectedAttribute );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.AttributeValueEvent#getAffectedMetaObjectMRI()
     */
    public MRI getAffectedMetaObjectMri( ) {

        return this.affectedMOMri;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.AttributeValueEvent#getAffectedMetaObject(com.sap.tc.moin.repository.core.Connection)
     */
    public Attribute getAffectedMetaObject( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return this.affectedAttribute;
    }

}
