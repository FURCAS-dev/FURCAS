package com.sap.tc.moin.xm.test.xml;

/** Represents an XML Attribute. */
final class XmlAttribute {

    String name;

    String namespace;

    String value;

    XmlAttribute( String aName, String aUri, String aValue ) {

        this.name = aName;
        this.namespace = aUri;
        this.value = aValue;
    }
}
