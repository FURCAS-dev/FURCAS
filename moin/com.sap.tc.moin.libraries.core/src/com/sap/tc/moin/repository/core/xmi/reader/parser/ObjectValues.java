package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

/**
 * Represents an element that consists of a sequence of ObjectValue elements. If an attribute of Class type or a
 * reference is encountered, this element is created to handle resolving its (multi-)value.
 */
class ObjectValues extends XmiElement {

    // storage of (multi-)value(s)
    private List<Object> values;

    ObjectValues( XmiElement parent, XmiContext context ) {

        super( parent, context );
        values = new ArrayList<Object>( );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        return context.resolveInstanceOrXmiReference( this, qName, attrs );
    }

    void receiveValue( Object value ) {

        values.add( value );
    }

    XmiElement endElement( String qName ) {

        parent.receiveValue( values );
        return parent;
    }
}