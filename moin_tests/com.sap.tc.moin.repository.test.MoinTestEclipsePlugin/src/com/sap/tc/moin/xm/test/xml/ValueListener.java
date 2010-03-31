package com.sap.tc.moin.xm.test.xml;



/** Listens for node values from the parser. */
interface ValueListener {

    /**
     * Adds the value of the current parsed XML element or attribute.
     * 
     * @param value value of the XML element or attribute; if an element is not
     * typed by a simple type, the value is the empty string.
     */
    void addValue( String value );

    //void addContext( XPath xpath );

    /** Event triggered when an XML element is closed. */
    void elementClosed( );

    // List<XPath> getAsXmlPaths( );
}
