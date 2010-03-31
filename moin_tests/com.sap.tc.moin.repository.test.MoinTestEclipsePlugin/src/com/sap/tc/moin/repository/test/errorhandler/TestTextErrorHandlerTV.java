package com.sap.tc.moin.repository.test.errorhandler;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.testcasesfoundation.case005f.__impl.A5fMigrationAttributeTypeTranslatableTextImpl;
import com.sap.tc.moin.textverticalization.TranslatableText;

@SuppressWarnings( "nls" )
public class TestTextErrorHandlerTV extends TestErrorHandlerAbstract {

    @Test
    public void testTextErrorHandler( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "textPartitionTV" );
        // parse the partition
        parse( getContentOfTextverticalizationPartition( ), partition );
        // check the partition content
        A5fMigrationAttributeTypeTranslatableTextImpl a5f = (A5fMigrationAttributeTypeTranslatableTextImpl) partition.getElements( ).iterator( ).next( );
        TranslatableText translatableText = a5f.getTranslatableText( );
        assertEquals( "The translatable text max width      should be \"80\",               but it is \"" + translatableText.getMaxWidth( ) + "\".", 80, translatableText.getMaxWidth( ) );
        assertEquals( "The translatable text original text  should be \"My original text\", but it is \"" + translatableText.getOriginalText( ) + "\".", "My original text", translatableText.getOriginalText( ) );
        assertEquals( "The translatable text resource type  should be \"button\",           but it is \"" + translatableText.getResType( ) + "\".", "button", translatableText.getResType( ) );
        assertEquals( "The translatable text translate flag should be \"true\",             but it is \"" + translatableText.isTranslate( ) + "\".", true, translatableText.isTranslate( ) );
        assertEquals( "The translatable text transUnit ID   should be \"42\",               but it is \"" + translatableText.getTransUnitId( ) + "\".", "42", translatableText.getTransUnitId( ) );
        assertEquals( "The translatable text resource name  should be \"BTN_42\",           but it is \"" + translatableText.getResName( ) + "\".", "BTN_42", translatableText.getResName( ) );
    }

    private ByteArrayInputStream getContentOfTextverticalizationPartition( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases/foundation' i='1' v=''/>" );
        buf.append( "<C n='sap.com/tc/moin/textverticalization' i='2' v=''/>" );
        buf.append( "<M c='1' q='testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText' i='48FEDD2F3CDD1BABA00F11DD8C38001558C93B47' ova='translatableText,generalTranslatableText,specializedTranslatableText'/>" );
        buf.append( "<M c='2' q='textverticalization.Text' i='45ED9217C0E2D7BE5B284C5F163B938D8DD1D7C9'/>" );
        buf.append( "<textverticalization.Text m:c='2' m:i='491187372AA916C0AB2F11DDCB10001558C93B47' maxWidth='80' originalText='My original text' resType='button' translate='true' transUnitId='42' resName='BTN_42'/>" );
        buf.append( "<testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText m:c='1' m:i='491187372AA6A5C0AB2F11DDC89D001558C93B47' translatableText='491187372AA916C0AB2F11DDCB10001558C93B47'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }
}