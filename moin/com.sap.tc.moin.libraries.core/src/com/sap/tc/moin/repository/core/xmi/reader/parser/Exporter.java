package com.sap.tc.moin.repository.core.xmi.reader.parser;

/**
 * Represents a <code>&lt;XMI.exporter&gt;</code> element.
 */
class Exporter extends XmiElement {

    Exporter( XmiElement parent, XmiContext context ) {

        super( parent, context );
    }

    void characters( char[] buf, int offset, int len ) {

        // context.setXmiExporter(new String(buf, offset, len));
    }
}