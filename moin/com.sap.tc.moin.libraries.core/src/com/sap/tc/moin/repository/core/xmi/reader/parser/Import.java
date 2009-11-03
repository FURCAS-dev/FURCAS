package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Represents a <code>&lt;XMI.import&gt;</code> element.
 */
class Import extends XmiElement {

    // href defining the import target
    private String href;

    Import( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        href = attrs.getValue( XmiConstants.XMI_HREF );
        if ( href == null || href.equals( "" ) ) { //$NON-NLS-1$
            throw new XmiParseException( XMI.MOIN_XMI_1032, new Object[] { href } );
        }
    }

    XmiElement endElement( String qName ) {

        if ( !context.isLoadingPartition( ) ) {
            // In import mode, queue the document with the href as it was found
            // in the XMI document.
            context.queueDocument( href );
        }
        return parent;
    }
}