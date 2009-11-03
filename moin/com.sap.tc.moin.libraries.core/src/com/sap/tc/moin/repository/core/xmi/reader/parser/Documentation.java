package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents a <code>&lt;XMI.documentation&gt;</code> element.
 */
class Documentation extends XmiElement {

    Documentation( XmiElement parent, XmiContext context ) {

        super( parent, context );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.XMI_EXPORTER ) ) {
            return new Exporter( this, context );
        }
        return new IgnoredElement( this );
    }
}