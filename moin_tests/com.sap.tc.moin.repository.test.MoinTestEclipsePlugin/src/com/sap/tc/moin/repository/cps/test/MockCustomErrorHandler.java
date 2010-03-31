package com.sap.tc.moin.repository.cps.test;

import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;


public class MockCustomErrorHandler extends SpiDefaultParserErrorHandler {

    @Override
    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        // always return C25 ...
        return super.handleUnknownType( callback, typeMofId, metamodelContainer, dotSeparatedQualifiedName );

    }

    @Override
    public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        return super.handleUnknownAttribute( callback, element, attributeName, attributeValue );
    }

}
