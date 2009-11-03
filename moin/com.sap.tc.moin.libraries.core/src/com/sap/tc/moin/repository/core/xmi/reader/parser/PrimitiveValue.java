package com.sap.tc.moin.repository.core.xmi.reader.parser;

import com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Represents a value of a PrimitiveType.
 */
class PrimitiveValue extends XmiElement {

    // type of this primitive value
    private PrimitiveTypeInternal type;

    // value of xmi.value attribute (if present - XMI 1.1 compatibility)
    private String xmiValue;

    // buffer for value of characters event
    private StringBuilder valueAsText = new StringBuilder( );

    // flag indicating if <xmi.any> value is read
    private boolean xmiAnyValueEndExpected = false;

    // flag that is set as true when </xmi.any> is encountered
    private boolean stopCharsReading = false;

    PrimitiveValue( XmiElement parent, XmiContext context, PrimitiveTypeInternal type, Attributes attrs ) {

        super( parent, context );
        this.type = type;
        xmiValue = attrs.getValue( XmiConstants.XMI_VALUE );
    }

    PrimitiveValue( XmiContext context ) {

        super( context );
    }

    void init( XmiElement parent, PrimitiveTypeInternal type, Attributes attrs ) {

        this.parent = parent;
        this.type = type;
        xmiValue = attrs.getValue( XmiConstants.XMI_VALUE );
        valueAsText = new StringBuilder( );
        xmiAnyValueEndExpected = false;
        stopCharsReading = false;
    }

    @Override
    void characters( char buf[], int offset, int len ) {

        if ( !stopCharsReading ) {
            if ( buf != null && len > 0 && ( offset + len ) <= buf.length ) {
                valueAsText.append( buf, offset, len );
            }
        }
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        // =======================================
        // XMI 1.1 compatibility
        // =======================================
        if ( !( qName.equals( XmiConstants.XMI_ANY_TYPE ) ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1037, new Object[] { qName } );
        }
        xmiAnyValueEndExpected = true;
        valueAsText = new StringBuilder( );
        return this;
    }

    @Override
    XmiElement endElement( String qName ) {

        if ( xmiAnyValueEndExpected ) {
            stopCharsReading = true;
            xmiAnyValueEndExpected = false;
            return this;
        }
        String value = valueAsText.toString( );
        // =======================================
        // XMI 1.1 compatibility
        // =======================================
        if ( xmiValue != null ) {
            value = xmiValue;
        }
        parent.receiveValue( context.resolvePrimitiveValue( type, value ) );
        return parent;
    }
}