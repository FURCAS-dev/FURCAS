package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

/**
 * Instances of this class are used if a complete XML subtree should not be parsed, but skipped.
 */
class IgnoredElement extends XmiElement {

    private int level = 0;

    IgnoredElement( XmiElement parent ) {

        super( parent, null );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        level++;
        return this;
    }

    XmiElement endElement( String qName ) {

        if ( level == 0 ) {
            return parent;
        } else {
            level--;
            return this;
        }
    }
}