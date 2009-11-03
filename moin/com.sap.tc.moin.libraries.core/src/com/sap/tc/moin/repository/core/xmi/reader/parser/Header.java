package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents a <code>&lt;XMI.header&gt;</code> element.
 */
class Header extends XmiElement {

    Header( XmiElement parent, XmiContext context ) {

        super( parent, context );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.XMI_DOCUMENTATION ) ) {
            return new Documentation( this, context );
        } else if ( qName.equals( XmiConstants.XMI_METAMODEL ) ) {
            return new Metamodel( this, context, attrs );
        } else if ( qName.equals( XmiConstants.XMI_IMPORT ) ) {
            return new Import( this, context, attrs );
        }
        // Ignore all other sub-elements of <XMI.header> for now.
        return new IgnoredElement( this );
    }

    @Override
    XmiElement endElement( String qName ) {

        context.endOfHeader( );
        return parent;
    }
}