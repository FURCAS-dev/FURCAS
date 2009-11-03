package com.sap.tc.moin.repository.spi.runtimehost.cp;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;

public interface SpiPartitionSerializationJmxTracer {

    public boolean isJmxNotificationsEnabled( );

    public void elementOfNonExistingMofClassAdded( PRI pri, String get___MetamodelContainer, String get___QualifiedName, String get___MofId, String mofId );

    public void elementAdded( PRI pri, SpiElement newElement );

    public void linkAdded( PRI pri, SpiAssociation assoc, Object elementAtFirstEnd, Object elementAtSecondEnd );

    public void errorHandlerStart( SpiParserErrorHandler errorHandler, String string, Map<String, String> args );

    public void errorHandlerEnd( SpiParserErrorHandler errorHandler, boolean errorHandled, String string );

    public void attributeValueAdded( PRI pri, SpiElement element, Attribute attribute, Object originalValue );

    public void s2xSerializerStart( PRI pri, String language, String develContact );

    public void s2xSerializerEnd( String content, long duration, int numberOfTexts );

    public void s2xSerializerException( Exception exception );

    public void s2xSerializerAddTranslationUnit( String serializedTranslationUnit );

    public void s2xSerializerCallback( String serializedInput, String serializedOutput, long duration );
}
