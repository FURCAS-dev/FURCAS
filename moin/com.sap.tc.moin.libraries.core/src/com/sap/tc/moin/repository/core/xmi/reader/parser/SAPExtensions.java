package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * Represents the MOIN-specific <code>&lt;XMI.extensions xmi.extender="SAP"&gt;</code> element.
 */
class SAPExtensions extends XmiElement {

    SAPExtensions( XmiElement parent, XmiContext context ) {

        super( parent, context );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.SAP_LINKS ) ) {
            return new Links( this, context );
        }
        return super.startElement( qName, attrs );
    }
}