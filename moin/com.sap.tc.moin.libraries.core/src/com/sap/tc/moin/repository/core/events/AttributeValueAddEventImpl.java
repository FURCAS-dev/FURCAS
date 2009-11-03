package com.sap.tc.moin.repository.core.events;

import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.AttributeValueAddEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public class AttributeValueAddEventImpl extends AttributeMultiValueEventImpl implements AttributeValueAddEvent {

    /**
     * creates an instance of <code>AttributeValueAddEventImpl</code>.
     * 
     * @see AttributeValueAddEvent
     * @param affectedElement the element where the attribute value was added to
     * @param attributeMetaObject the meta type of the added attribute
     * @param value the value of the added attribute
     */
    public AttributeValueAddEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value ) {

        super( triggeringConnection, affectedElement, attributeMetaObject, value );
    }

    /**
     * creates an instance of <code>AttributeValueAddEventImpl</code>.
     * Additionally, the position of the added attribute has to be defined.
     * 
     * @see AttributeValueAddEvent
     * @param affectedElement the element where the attribute value was added to
     * @param attributeMetaObject the meta type of the added attribute
     * @param value the value of the added attribute
     * @param position the position in the list of attributes where the
     * attribute was added
     */
    public AttributeValueAddEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value, int position ) {

        super( triggeringConnection, affectedElement, attributeMetaObject, position, value );
    }

    public AttributeValueAddEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object value, int position ) {

        super( triggeringConnection );
        this._position = position;
        this._value = getCorrectedValue( value );
        this.elementMri = affectedElementMri;
        this.attributeMri = ( (Partitionable) attributeMetaObject ).get___Mri( );
        this.immediatePackageExtentLri = affectedElementImmediatePackageMri.getLri( );
        this.classFilterLris = Collections.singletonList( ( (Partitionable) affectedElementMetaObject ).get___Mri( ).getLri( ) );
        getCompositeParentLRIsIncludingSelf( ).add( affectedElementMri.getLri( ) );
        getCompositeParentLRIsIncludingSelf( ).addAll( affectedElementParentLris );
    }

    @Override
    protected String getTypeString( ) {

        return "AttributeValueAddEvent"; //$NON-NLS-1$
    }
}
