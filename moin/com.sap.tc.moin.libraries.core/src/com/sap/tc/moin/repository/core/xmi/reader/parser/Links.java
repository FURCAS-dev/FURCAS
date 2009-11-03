package com.sap.tc.moin.repository.core.xmi.reader.parser;

import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;

import org.xml.sax.Attributes;

/**
 * Represents a <code>&lt;Links&gt;</code> element (MOIN-specific element inside
 * an &lt;XMI.extension&gt; element).
 */
class Links extends XmiElement {

    Links( XmiElement parent, XmiContext context ) {

        super( parent, context );
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        AssociationInternal assoc = (AssociationInternal) context.resolveQualifiedName( qName );
        return new AssociationElement( this, context, assoc );
    }
}