package com.sap.tc.moin.repository.core.xmi.reader.parser;

import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Represents an enumeration literal.
 */
class EnumerationValue extends XmiElement {

    EnumerationValue( XmiContext context ) {

        super( context );
    }

    void init( XmiElement parent, EnumerationTypeInternal type, Attributes attrs ) {

        this.parent = parent;
        String enumValue = attrs.getValue( XmiConstants.XMI_VALUE );
        if ( enumValue == null ) {
            throw new MoinLocalizedBaseRuntimeException( XMI.COULDNOTRETRIEVEENUMVALUE );
        }
        parent.receiveValue( context.getEnumerationValue( type, enumValue ) );
    }
}