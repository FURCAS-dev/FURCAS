package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents a <code>&lt;XMI.extension&gt;</code> element.
 */
class Extension extends XmiElement {

    // private String extender;

    // private String extenderId;

    Extension( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        // extender = attrs.getValue(XmiConstants.XMI_EXTENDER);
        // extenderId = attrs.getValue(XmiConstants.XMI_EXTENDER_ID);
    }

    void characters( char[] buf, int offset, int len ) {

        /**
         * TODO pass the event to the extension handler registered for <code>extender</code>
         */
    }

    XmiElement endElement( String qName ) {

        /**
         * TODO pass the event to the extension handler registered for <code>extender</code>
         */
        if ( qName.equals( XmiConstants.XMI_EXTENSION ) ) {
            return parent;
        }
        return this;
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        /**
         * TODO pass the event to the extension handler registered for <code>extender</code>
         */
        return super.startElement( qName, attrs );
    }
}