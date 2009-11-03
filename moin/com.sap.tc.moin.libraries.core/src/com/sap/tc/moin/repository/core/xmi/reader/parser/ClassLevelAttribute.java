package com.sap.tc.moin.repository.core.xmi.reader.parser;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Represents a classifier-level attribute.
 */
class ClassLevelAttribute extends XmiElement {

    private Classifier type;

    ClassLevelAttribute( XmiElement parent, XmiContext context, AttributeInternal attr ) {

        super( parent, context );
        //FIXME HACK!!! 
        CoreConnection connection = context.getSession( ) != null ? context.getSession( ).getConnections( ).iterator( ).next( ) : null;
        type = attr.getType( connection );
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        return context.resolveValue( this, type, attrs );
    }

    @Override
    void receiveValue( Object value ) {

        parent.receiveValue( value );
    }
}