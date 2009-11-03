package com.sap.tc.moin.repository.cps.test;

import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case025.C25;


public class SimpleTestCustomErrorHandler extends SpiDefaultParserErrorHandler {

    @Override
    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        // always return C25 ...
        return callback.getClass( C25.CLASS_DESCRIPTOR.getMofId( ), TestcasesPackage.PACKAGE_DESCRIPTOR.getModelContainerName( ), "testcases.case025.C25" );

    }

    @Override
    public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        return super.handleUnknownAttribute( callback, element, attributeName, attributeValue );
    }

}
