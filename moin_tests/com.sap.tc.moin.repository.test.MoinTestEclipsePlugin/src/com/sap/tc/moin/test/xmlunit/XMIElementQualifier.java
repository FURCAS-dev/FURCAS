package com.sap.tc.moin.test.xmlunit;

import org.custommonkey.xmlunit.ElementNameAndAttributeQualifier;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@SuppressWarnings( "nls" )
public class XMIElementQualifier extends ElementNameAndAttributeQualifier {

    public XMIElementQualifier( ) {

    }

    @Override
    public boolean qualifyForComparison( Element control, Element test ) {

        boolean nonNSNodeName = getNonNamespacedNodeName( control ).equals( getNonNamespacedNodeName( test ) );
        if ( nonNSNodeName ) {
            if ( control.hasAttribute( "name" ) && test.hasAttribute( "name" ) && control.getAttribute( "name" ).equals( test.getAttribute( "name" ) ) ) {
                return true;
            }
        }
        return super.qualifyForComparison( control, test );
    }

    @Override
    protected boolean equalsNamespace( Node control, Node test ) {

        String controlNS = control.getNamespaceURI( );
        String testNS = test.getNamespaceURI( );
        if ( controlNS == null ) {
            return testNS == null;
        } else {
            return controlNS.equals( testNS );
        }
    }

    @Override
    protected String getNonNamespacedNodeName( Node node ) {

        String name = node.getLocalName( );
        if ( name == null ) {
            return node.getNodeName( );
        } else {
            return name;
        }
    }
}
