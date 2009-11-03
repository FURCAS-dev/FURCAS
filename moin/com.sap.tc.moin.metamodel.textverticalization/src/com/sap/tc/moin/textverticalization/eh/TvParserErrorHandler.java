package com.sap.tc.moin.textverticalization.eh;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiAttributeInfo;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;

public class TvParserErrorHandler extends SpiDefaultParserErrorHandler {

    // qualified name of the old class
    private String TEXT_CLASS_QNAME = "textverticalization.Text"; //$NON-NLS-1$

    public TvParserErrorHandler( ) {
    }

    @Override
    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        if ( dotSeparatedQualifiedName.equals( TEXT_CLASS_QNAME ) ) {
            List<SpiAttributeInfo> attributeInfos = new ArrayList<SpiAttributeInfo>( 6 );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.MAX_WIDTH_ATTRIBUTE_NAME, TranslatableTextClass.MAX_WIDTH_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_INTEGER, false /* isMultiValued */, false /* isObjectValued */) );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.ORIGINAL_TEXT_ATTRIBUTE_NAME, TranslatableTextClass.ORIGINAL_TEXT_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_STRING, false/* isMultiValued */, false /* isObjectValued */) );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.RES_NAME_ATTRIBUTE_NAME, TranslatableTextClass.RES_NAME_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_STRING, false/* isMultiValued */, false /* isObjectValued */) );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.RES_TYPE_ATTRIBUTE_NAME, TranslatableTextClass.RES_TYPE_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_STRING, false/* isMultiValued */, false /* isObjectValued */) );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.TRANSLATE_ATTRIBUTE_NAME, TranslatableTextClass.TRANSLATE_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_BOOLEAN, false/* isMultiValued */, false /* isObjectValued */) );
            attributeInfos.add( callback.createAttributeInfo( TranslatableTextClass.TRANS_UNIT_ID_ATTRIBUTE_NAME, TranslatableTextClass.TRANS_UNIT_ID_ATTRIBUTE_MOF_ID, SpiValueTypeEnum.PRIMITIVE_TYPE_STRING, false/* isMultiValued */, false /* isObjectValued */) );
            return callback.getClassForNonExistingMofClass( typeMofId, metamodelContainer, dotSeparatedQualifiedName, attributeInfos );
        }
        return null;
    }

    @Override
    public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        boolean handled = false;
        if ( attributeValue instanceof SpiElement && ( (SpiElement) attributeValue ).get___Type( ).get___QualifiedName( ).equals( TEXT_CLASS_QNAME ) ) {
            SpiStructuredValue structuredValue = callback.createStructuredValue( );
            structuredValue.set___FieldValue( TranslatableTextClass.MAX_WIDTH_FIELD_NAME, (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.MAX_WIDTH_ATTRIBUTE_NAME ) );
            structuredValue.set___FieldValue( TranslatableTextClass.ORIGINAL_TEXT_FIELD_NAME, (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.ORIGINAL_TEXT_ATTRIBUTE_NAME ) );
            structuredValue.set___FieldValue( TranslatableTextClass.RES_NAME_FIELD_NAME, (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.RES_NAME_ATTRIBUTE_NAME ) );
            structuredValue.set___FieldValue( TranslatableTextClass.RES_TYPE_FIELD_NAME, (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.RES_TYPE_ATTRIBUTE_NAME ) );
            structuredValue.set___FieldValue( TranslatableTextClass.TRANSLATE_FIELD_NAME, (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.TRANSLATE_ATTRIBUTE_NAME ) );
            String transUnitId = (String) ( (SpiElement) attributeValue ).get___AttributeValue( TranslatableTextClass.TRANS_UNIT_ID_ATTRIBUTE_NAME );
            if ( transUnitId == null || transUnitId.length( ) == 0 ) {
                // the legacy data hasn't had a valid translation unit ID, so create one here
                transUnitId = MoinMetamodelCode.createGUID( );
            }
            structuredValue.set___FieldValue( TranslatableTextClass.TRANS_UNIT_ID_FIELD_NAME, transUnitId );
            element.add___StructuredValue( attributeName, structuredValue );
            handled = true;
        }
        return handled;
    }

    private static class TranslatableTextClass {

        // old attribute names and IDs
        public static final String MAX_WIDTH_ATTRIBUTE_NAME = "maxWidth"; //$NON-NLS-1$

        public static final String MAX_WIDTH_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        public static final String ORIGINAL_TEXT_ATTRIBUTE_NAME = "originalText"; //$NON-NLS-1$

        public static final String ORIGINAL_TEXT_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        public static final String RES_NAME_ATTRIBUTE_NAME = "resName"; //$NON-NLS-1$

        public static final String RES_NAME_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        public static final String RES_TYPE_ATTRIBUTE_NAME = "resType"; //$NON-NLS-1$

        public static final String RES_TYPE_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        public static final String TRANSLATE_ATTRIBUTE_NAME = "translate"; //$NON-NLS-1$

        public static final String TRANSLATE_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        public static final String TRANS_UNIT_ID_ATTRIBUTE_NAME = "transUnitId"; //$NON-NLS-1$

        public static final String TRANS_UNIT_ID_ATTRIBUTE_MOF_ID = "465FDC12BCFC64DD9FD145912FD0AD31EBBF7A28"; //$NON-NLS-1$

        // new field names
        public static final String MAX_WIDTH_FIELD_NAME = "maxWidth"; //$NON-NLS-1$

        public static final String ORIGINAL_TEXT_FIELD_NAME = "originalText"; //$NON-NLS-1$

        public static final String RES_TYPE_FIELD_NAME = "resType"; //$NON-NLS-1$

        public static final String TRANSLATE_FIELD_NAME = "translate"; //$NON-NLS-1$

        public static final String TRANS_UNIT_ID_FIELD_NAME = "transUnitId"; //$NON-NLS-1$

        public static final String RES_NAME_FIELD_NAME = "resName"; //$NON-NLS-1$
    }
}
