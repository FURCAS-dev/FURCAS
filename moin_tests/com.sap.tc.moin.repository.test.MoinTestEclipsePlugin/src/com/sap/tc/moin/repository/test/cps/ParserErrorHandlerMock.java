package com.sap.tc.moin.repository.test.cps;

import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;

/**
 * @author d026715
 */
public class ParserErrorHandlerMock implements SpiParserErrorHandler {

    public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        // TODO Auto-generated method stub
        return false;
    }

    public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        // TODO Auto-generated method stub
        return false;
    }

    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        // TODO Auto-generated method stub
        return null;
    }

}
