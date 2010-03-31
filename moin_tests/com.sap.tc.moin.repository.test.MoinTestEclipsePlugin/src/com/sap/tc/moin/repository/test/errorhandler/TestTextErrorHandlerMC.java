package com.sap.tc.moin.repository.test.errorhandler;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.testcasesfoundation.case005f.__impl.A5fMigrationAttributeTypeTranslatableTextImpl;
import com.sap.tc.moin.textverticalization.__impl.TranslatableTextImpl;

@SuppressWarnings( "nls" )
public class TestTextErrorHandlerMC extends TestErrorHandlerAbstract {

    @Test
    public void testTextErrorHandler( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "textPartitionMC" );
        // parse the partition
        parse( getContentOfMCPartition( ), partition );
        // check the partition content
        A5fMigrationAttributeTypeTranslatableTextImpl a5f = null;
        // get the one A5f... element
        for ( Partitionable partitionable : partition.getElements( ) ) {
            if ( partitionable instanceof A5fMigrationAttributeTypeTranslatableTextImpl ) {
                a5f = (A5fMigrationAttributeTypeTranslatableTextImpl) partitionable;
                break;
            }
        }
        TranslatableTextImpl translatableText = (TranslatableTextImpl) a5f.getTranslatableText( );
        assertEquals( "The translatable text max width      should be \"120\",                       but it is \"" + translatableText.getMaxWidth( ) + "\".", 120, translatableText.getMaxWidth( ) );
        assertEquals( "The translatable text original text  should be \"Service Group Description\", but it is \"" + translatableText.getOriginalText( ) + "\".", "Service Group Description", translatableText.getOriginalText( ) );
        assertEquals( "The translatable text resource type  should be \"description\",               but it is \"" + translatableText.getResType( ) + "\".", "description", translatableText.getResType( ) );
        assertEquals( "The translatable text translate flag should be \"true\",                      but it is \"" + translatableText.isTranslate( ) + "\".", true, translatableText.isTranslate( ) );
        assertTrue( "  The translatable text transUnit ID   should be valid,                         but it isn't.", translatableText.getTransUnitId( ) != null );
        assertEquals( "The translatable text resource name  should be \"ls.ServiceGroupName.desc\",  but it is \"" + translatableText.getResName( ) + "\".", "ls.ServiceGroupName.desc", translatableText.getResName( ) );
    }

    // this model partition is an adapted copy of a real MC model partition
    // the adaptions are: replacement of MC metamodel entities by suitable chosen entities from the testcases foundation metamodel
    private ByteArrayInputStream getContentOfMCPartition( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases/foundation' i='1' v=''/>" );
        buf.append( "<C n='sap.com/tc/moin/textverticalization' i='2' v=''/>" );
        buf.append( "<M c='1' q='testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText' i='48FEDD2F3CDD1BABA00F11DD8C38001558C93B47' ova='translatableText,generalTranslatableText,specializedTranslatableText'/>" );
        buf.append( "<M c='2' q='textverticalization.Text' i='45ED9217C0E2D7BE5B284C5F163B938D8DD1D7C9'/>" );
        buf.append( "<textverticalization.Text m:c='2' m:i='490EAF866DA307F0A97D11DDB99A001125F5383D' maxWidth='120' originalText='Service Group Description' resName='ls.ServiceGroupName.desc' resType='description' translate='true'/>" );
        buf.append( "<testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText m:c='1' m:i='491187372AA6A5C0AB2F11DDC89D001558C93B47' translatableText='490EAF866DA307F0A97D11DDB99A001125F5383D'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }
}
