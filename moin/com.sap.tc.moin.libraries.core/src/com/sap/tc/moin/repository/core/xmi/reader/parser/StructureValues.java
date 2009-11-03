package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents one or more StructureType values.
 */
class StructureValues extends XmiElement {

    // storage of (multi-)value(s)
    private List<Object> values;

    // type of serialized structure value(s)
    private StructureTypeInternal type;

    // if true, structure values are serialized using <XMI.field> elements
    private boolean oldFormat;

    StructureValues( XmiElement parent, XmiContext context, StructureTypeInternal type ) {

        super( parent, context );
        this.type = type;
        values = new ArrayList<Object>( );
        oldFormat = false;
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.XMI_FIELD ) ) {
            oldFormat = true;
        }
        StructureValue struct = new StructureValue( this, context, type, attrs, oldFormat );
        if ( oldFormat ) {
            /*
             * A PATCH - we need to call startSubElement method, because items
             * of the structure (that will be read) are encapsulated directly by
             * StructureValues element (compare to "class style" serialization,
             * where items are encapsulated by StructureValue element rather
             * than StructureValues. There is matched call of this.endElement ()
             * in StructureValue.endElement() method.
             */
            return struct.startElement( qName, attrs );
        }
        return struct;
    }

    @Override
    void receiveValue( Object value ) {

        values.add( value );
    }

    @Override
    XmiElement endElement( String qName ) {

        parent.receiveValue( values );
        return parent;
    }
}