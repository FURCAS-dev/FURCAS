package com.sap.tc.moin.repository.cps.test;

import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerDefaultCallback;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XTranslationUnit;

public class SimpleTestS2XSerializerCallback extends SpiS2XSerializerDefaultCallback {

    public SpiS2XTranslationUnit getTranslationUnit( SpiElement translatableTextAttributeParent, String translatableTextAttributeName, SpiStructuredValue translatableTextValue ) {
        SpiS2XTranslationUnit translationUnit = new SpiS2XTranslationUnit( );
        translationUnit.setResName( "ModifiedBySimpleCallback" ); //$NON-NLS-1$
        return translationUnit;
    }
}
