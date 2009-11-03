package com.sap.tc.moin.repository.spi.ps.errorhandler;

import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;

/**
 * Provides a default implementation of the {@link SpiParserErrorHandler}
 * interface. Clients are strongly encouraged to inherit from this class instead
 * of implementing {@link SpiParserErrorHandler} directly, to avoid compile
 * errors if the {@link SpiParserErrorHandler} interface should need to be
 * extended in the future.
 */
public abstract class SpiDefaultParserErrorHandler implements SpiParserErrorHandler {

    public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        return false; // by default not handled
    }

    public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        return false; // by default not handled
    }

    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return null; // by default not handled
    }
}