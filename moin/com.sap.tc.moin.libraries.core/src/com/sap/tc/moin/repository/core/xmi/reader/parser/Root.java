package com.sap.tc.moin.repository.core.xmi.reader.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;

/**
 * This class represents the root element of every XMI document, named <code>&lt;XMI&gt;</code>. According to the XMI
 * 1.2 specification, this element can have the following direct sub-elements:
 * <code>&lt;XMI.header&gt;, &lt;XMI.content&gt;, &lt;XMI.difference&gt;, &lt;XMI.extensions&gt;</code>.
 */
class Root extends XmiElement {

    Root( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        // Read the xmi.version and pass it to the context for validation.
        String xmiVersion = attrs.getValue( XmiConstants.XMI_VERSION_ATT );
        context.checkXmiVersion( xmiVersion );
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        // First, check for those XMI elements that we want to handle explicitly
        // using a subclass of XmiElement.
        if ( qName.equals( XmiConstants.XMI_HEADER ) ) {
            return new Header( this, context );
        } else if ( qName.equals( XmiConstants.XMI_CONTENT ) ) {
            return new Content( this, context );
        } else if ( qName.equals( XmiConstants.XMI_EXTENSIONS ) ) {
            String extender = attrs.getValue( XmiConstants.XMI_EXTENDER );
            // We are only interested in extensions from SAP. Other extensions
            // found during the import of external XMI documents are ignored.
            if ( extender.equals( XmiConstants.SAP_EXTENDER ) ) {
                return new SAPExtensions( this, context );
            }
        } else if ( qName.equals( XmiConstants.XMI_DIFFERENCE ) ) {
            return new Difference( this, context, attrs );
        }
        // For all other XMI elements found in the document, instances of
        // the class IgnoredElement are created, with this Root instance as
        // the parent. This effectively "skips" the complete subtree below the
        // element (technically, the subtree _is_ parsed, of course).
        return new IgnoredElement( this );
    }
}