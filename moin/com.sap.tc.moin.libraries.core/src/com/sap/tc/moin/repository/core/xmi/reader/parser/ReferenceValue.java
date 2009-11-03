package com.sap.tc.moin.repository.core.xmi.reader.parser;

/**
 * Represents an XMI reference, either document-internal (<code>xmi.idref</code>) or cross-document (<code>href</code>).
 */
class ReferenceValue extends XmiElement {

    /*
     * This element reads an object value stored as reference, example: <Model:Class xmi.idref = 'a1' />
     */

    ReferenceValue( XmiContext context ) {

        super( context );
    }

    final Object init( XmiElement parent, String xmiId ) {

        this.parent = parent;
        Object obj = context.getReferencedObject( xmiId );
        if ( obj == null ) {
            obj = new UnresolvedReference( );
            context.registerUnresolvedRef( xmiId, (UnresolvedReference) obj );
        }
        parent.receiveValue( obj );
        return obj;
    }

    final Object initExternal( XmiElement parent, String href, String qName ) {

        this.parent = parent;
        Object obj = null;
        obj = context.initExternal( href, qName );
        parent.receiveValue( obj );
        return obj;
    }
}