package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents a <code>&lt;XMI.metamodel&gt;</code> element.
 */
class Metamodel extends XmiElement {

    Metamodel( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        context.addMetamodelContainer( attrs.getValue( XmiConstants.XMI_NAME_ATT ) );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.XMI_EXPORTER ) ) {
            return new Exporter( this, context );
        }
        return new IgnoredElement( this );
    }
}