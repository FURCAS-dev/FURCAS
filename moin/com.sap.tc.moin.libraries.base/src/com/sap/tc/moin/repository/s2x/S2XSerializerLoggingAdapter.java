package com.sap.tc.moin.repository.s2x;

import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XTranslationUnit;

public class S2XSerializerLoggingAdapter {

    static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_S2X, S2XSerializer.class );

    void s2XSerializerStart( PRI pri, String language, String develContact ) {
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Begin of S2X serialization for partition \"{0}\", language = \"{1}\", develContact = \"{2}\"", pri, language, develContact ); //$NON-NLS-1$
        }
    }

    public void s2XSerializerException( Exception exception ) {
        if ( logger.isTraced( MoinSeverity.ERROR ) ) {
            logger.trace( exception, MoinSeverity.ERROR, "Exception during the creation of an S2X document: {0}", exception.getMessage( ) ); //$NON-NLS-1$
        }
    }

    public void s2XSerializerEnd( long duration, int numberOfTexts ) {
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "End of S2X serialization, time = {0}ms, texts serialized = {1}.", String.valueOf( duration ), numberOfTexts ); //$NON-NLS-1$
        }
    }

    public void s2XSerializerAddTranslationUnit( TranslationUnit translationUnit ) {
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String serializedTu = "["; //$NON-NLS-1$
            serializedTu += "maxwidth=" + translationUnit.getMaxwidth( ) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
            serializedTu += "source=" + translationUnit.getSource( ) + ", "; //$NON-NLS-1$//$NON-NLS-2$
            serializedTu += "restype=" + translationUnit.getRestype( ) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
            serializedTu += "translate=" + translationUnit.getTranslate( ) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
            serializedTu += "id=" + translationUnit.getID( ) + ", "; //$NON-NLS-1$//$NON-NLS-2$
            serializedTu += "resname=" + translationUnit.getResname( ) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
            serializedTu += "default length=" + translationUnit.getDefaultlength( ) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
            serializedTu += "status=" + translationUnit.getStatus( ); //$NON-NLS-1$
            serializedTu += "]"; //$NON-NLS-1$
            logger.trace( MoinSeverity.INFO, "Adding translation unit: {0}.", serializedTu ); //$NON-NLS-1$
        }
    }

    public void s2XSerializerCallback( SpiElement translatableTextAttributeParent, String translatableTextAttributeName, SpiStructuredValue translatableTextValue, SpiS2XTranslationUnit s2XTranslationUnit, long duration ) {
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String serializedInput = "["; //$NON-NLS-1$
            serializedInput += "parent=" + translatableTextAttributeParent.get___Type( ).get___QualifiedName( ) + ", attribute name=" + translatableTextAttributeName + ", attribute value =" + translatableTextValue; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            serializedInput += "]"; //$NON-NLS-1$
            String serializedOutput = "["; //$NON-NLS-1$
            serializedOutput += "resname=" + s2XTranslationUnit.getResName( ); //$NON-NLS-1$
            serializedOutput += "]"; //$NON-NLS-1$
            logger.trace( MoinSeverity.INFO, "End of S2X serialization callback, time = {0}ms, input = {1}, output = {2}", duration, serializedInput, serializedOutput ); //$NON-NLS-1$
        }
    }
}
