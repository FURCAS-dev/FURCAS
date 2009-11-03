package com.sap.tc.moin.xm.test.xml;

import java.util.Map;

/**
 * Represents an XML Element which must be compared with an other XML Element.
 */
class XmlElement {

    final Map<String, XmlAttribute> attrs;

    final ComparablePath xpath;

    final String value;


    XmlElement( ComparablePath aXPath, Map<String, XmlAttribute> aAttributes, String aValue ) {

        if ( aXPath == null ) {
            throw new NullPointerException( "aXPath must not be null" );
        }
        if ( aAttributes == null ) {
            throw new NullPointerException( "aAttributes must not be null" );
        }
        if ( aValue == null ) {
            throw new NullPointerException( "aValue must not be null" );
        }
        this.xpath = aXPath;
        this.attrs = aAttributes;
        this.value = aValue;
    }

}
