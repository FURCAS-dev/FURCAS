package com.sap.tc.moin.repository.s2x;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.io.OutputStream;

import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XTranslationUnit;

public class S2XSerializerJmxAdapter {

    S2XSerializer s2XSerializer = null;

    S2XSerializerJmxAdapter( S2XSerializer s2XSerializer ) {
        this.s2XSerializer = s2XSerializer;
    }

    void s2XSerializerStart( PRI pri, String language, String develContact ) {
        if ( JMX_ENABLED && s2XSerializer.partitionSerializationManager.isJmxNotificationsEnabled( ) ) {
            s2XSerializer.partitionSerializationManager.s2xSerializerStart( pri, language, develContact );
        }
    }

    void s2XSerializerEnd( OutputStream outputStream, long duration, int numberOfTexts ) {
        if ( JMX_ENABLED && s2XSerializer.partitionSerializationManager.isJmxNotificationsEnabled( ) ) {
            s2XSerializer.partitionSerializationManager.s2xSerializerEnd( outputStream.toString( ), duration, numberOfTexts );
        }
    }

    void s2XSerializerException( Exception exception ) {
        if ( JMX_ENABLED && s2XSerializer.partitionSerializationManager.isJmxNotificationsEnabled( ) ) {
            s2XSerializer.partitionSerializationManager.s2xSerializerException( exception );
        }
    }

    void s2XSerializerAddTranslationUnit( TranslationUnit translationUnit ) {
        if ( JMX_ENABLED && s2XSerializer.partitionSerializationManager.isJmxNotificationsEnabled( ) ) {
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
            s2XSerializer.partitionSerializationManager.s2xSerializerAddTranslationUnit( serializedTu );
        }
    }

    void s2XSerializerCallback( SpiElement translatableTextAttributeParent, String translatableTextAttributeName, SpiStructuredValue translatableTextValue, SpiS2XTranslationUnit s2XTranslationUnit, long duration ) {
        if ( JMX_ENABLED && s2XSerializer.partitionSerializationManager.isJmxNotificationsEnabled( ) ) {
            String serializedInput = "["; //$NON-NLS-1$
            serializedInput += "parent=" + translatableTextAttributeParent.get___Type( ).get___QualifiedName( ) + ", attribute name=" + translatableTextAttributeName + ", attribute value =" + translatableTextValue; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            serializedInput += "]"; //$NON-NLS-1$
            String serializedOutput = "["; //$NON-NLS-1$
            serializedOutput += "resname=" + s2XTranslationUnit.getResName( ); //$NON-NLS-1$
            serializedOutput += "]"; //$NON-NLS-1$
            s2XSerializer.partitionSerializationManager.s2xSerializerCallback( serializedInput, serializedOutput, duration );
        }
    }
}
