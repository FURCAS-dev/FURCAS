package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;

import org.junit.Before;
import org.junit.Test;

import com.sap.guid.GUID;
import com.sap.guid.GUIDFormatException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;
import com.sap.tc.moin.testcasesfoundation.case004f.ButtonTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.ShortTranslatableTextF;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;
import com.sap.tc.moin.textverticalization.TranslatableTextFragment;

@SuppressWarnings( "nls" )
public class TestTextverticalization extends CoreMoinTest {

    private TextverticalizationPackage tvp = null;

    private TestcasesfoundationPackage tfp = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        tvp = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );
        tfp = getMOINConnection( ).getPackage( TestcasesfoundationPackage.PACKAGE_DESCRIPTOR );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        tvp = null;
        tfp = null;
    }

    @Test
    public void testTranslatableTextCreation( ) {

        // test the creation of texts
        // empty translatable text, only the initial values are set
        TranslatableText translatableText = tvp.createTranslatableText( null );
        assertEquals( 255, translatableText.getMaxWidth( ) );
        assertEquals( null, translatableText.getOriginalText( ) );
        assertEquals( null, translatableText.getResType( ) );
        assertEquals( true, translatableText.isTranslate( ) );
        assertValidGuid( translatableText.getTransUnitId( ) );
        assertEquals( null, translatableText.getResName( ) );
        // non-empty translatable text, all fields are filled
        StructureFieldContainer<TranslatableText> translatableTextCont = new StructureFieldContainer<TranslatableText>( );
        translatableTextCont.put( TranslatableText.DESCRIPTORS.MAX_WIDTH( ), 42 ).put( TranslatableText.DESCRIPTORS.ORIGINAL_TEXT( ), "originalText" ).put( TranslatableText.DESCRIPTORS.RES_TYPE( ), "resType" );
        translatableTextCont.put( TranslatableText.DESCRIPTORS.TRANSLATE( ), false ).put( TranslatableText.DESCRIPTORS.TRANS_UNIT_ID( ), "transUnitId" ).put( TranslatableText.DESCRIPTORS.RES_NAME( ), "resName" );
        translatableText = tvp.createTranslatableText( translatableTextCont );
        assertEquals( 42, translatableText.getMaxWidth( ) );
        assertEquals( "originalText", translatableText.getOriginalText( ) );
        assertEquals( "resType", translatableText.getResType( ) );
        assertEquals( false, translatableText.isTranslate( ) );
        assertEquals( "transUnitId", translatableText.getTransUnitId( ) );
        assertEquals( "resName", translatableText.getResName( ) );
    }

    @Test
    public void testTranslatableTextFragmentCreation( ) {

        // test the creation of text fragments
        // empty translatable text, only the initial values are set
        TranslatableTextFragment translatableTextFragment = tvp.createTranslatableTextFragment( null );
        assertEquals( 255, translatableTextFragment.getMaxWidth( ) );
        assertEquals( null, translatableTextFragment.getOriginalText( ) );
        assertEquals( null, translatableTextFragment.getResType( ) );
        assertEquals( true, translatableTextFragment.isTranslate( ) );
        assertValidGuid( translatableTextFragment.getTransUnitId( ) );
        // non-empty translatable text, all fields are filled
        StructureFieldContainer<TranslatableText> translatableTextCont = new StructureFieldContainer<TranslatableText>( );
        translatableTextCont.put( TranslatableText.DESCRIPTORS.MAX_WIDTH( ), 42 ).put( TranslatableText.DESCRIPTORS.ORIGINAL_TEXT( ), "originalText" );
        translatableTextCont.put( TranslatableText.DESCRIPTORS.RES_TYPE( ), "resType" ).put( TranslatableText.DESCRIPTORS.TRANSLATE( ), false ).put( TranslatableText.DESCRIPTORS.TRANS_UNIT_ID( ), "transUnitId" );
        translatableTextFragment = tvp.createTranslatableText( translatableTextCont );
        assertEquals( 42, translatableTextFragment.getMaxWidth( ) );
        assertEquals( "originalText", translatableTextFragment.getOriginalText( ) );
        assertEquals( "resType", translatableTextFragment.getResType( ) );
        assertEquals( false, translatableTextFragment.isTranslate( ) );
        assertEquals( "transUnitId", translatableTextFragment.getTransUnitId( ) );
    }

    @Test
    public void testTranslatableTextInitialValues( ) {

        // test all initial values of text
        TranslatableText translatableText = tvp.createTranslatableText( null );
        // maxWidth is initialized with 255
        assertEquals( 255, translatableText.getMaxWidth( ) );
        // original text is not initialized
        assertEquals( null, translatableText.getOriginalText( ) );
        // resource type is not initialized
        assertEquals( null, translatableText.getResType( ) );
        // tanslate is initialized with true
        assertEquals( true, translatableText.isTranslate( ) );
        // translation unit ID is a GUID
        assertValidGuid( translatableText.getTransUnitId( ) );
        // resource name is not initialized
        assertEquals( null, translatableText.getResName( ) );
    }

    @Test
    public void testTranslatableTextFragmentInitialValues( ) {

        // test all initial values of text
        TranslatableTextFragment translatableTextFragment = tvp.createTranslatableTextFragment( null );
        // maxWidth is initialized with 255
        assertEquals( 255, translatableTextFragment.getMaxWidth( ) );
        // original text is not initialized
        assertEquals( null, translatableTextFragment.getOriginalText( ) );
        // resource type is not initialized
        assertEquals( null, translatableTextFragment.getResType( ) );
        // tanslate is initialized with true
        assertEquals( true, translatableTextFragment.isTranslate( ) );
        // translation unit ID is a GUID
        assertValidGuid( translatableTextFragment.getTransUnitId( ) );
    }

    @Test
    public void testTextInitialValuesForSubTexts( ) {

        // test all initial values for sub structures and sub sub structures of TranslatableText
        ShortTranslatableTextF shortTranslatableText = tfp.getCase004f( ).createShortTranslatableTextF( null );
        ButtonTextF buttonText = tfp.getCase004f( ).createButtonTextF( null );
        // maxWidth is initialized
        assertEquals( 255, shortTranslatableText.getMaxWidth( ) );
        assertEquals( 100, buttonText.getMaxWidth( ) );
        // tanslate is initialized with true
        assertEquals( true, shortTranslatableText.isTranslate( ) );
        assertEquals( true, buttonText.isTranslate( ) );
        // resType is initialized with button
        assertEquals( "button", buttonText.getResType( ) );
        // translation unit ID is a GUID
        assertValidGuid( shortTranslatableText.getTransUnitId( ) );
        assertValidGuid( buttonText.getTransUnitId( ) );
        // all others are not initialized
        assertEquals( null, shortTranslatableText.getOriginalText( ) );
        assertEquals( null, buttonText.getOriginalText( ) );
        assertEquals( null, shortTranslatableText.getResName( ) );
        assertEquals( null, buttonText.getResName( ) );
        assertEquals( null, shortTranslatableText.getResType( ) );
    }

    @Test
    public void testTranslatableTextNonExistingAttributes( ) {

        // test exceptions for non existing attributes
        TranslatableText translatableText = tvp.createTranslatableText( null );
        try {
            translatableText.refGetValue( (String) null );
            assertTrue( "Should have thrown an InvalidNameException", true );
        } catch ( InvalidCallException ex ) {
        }
        try {
            translatableText.refGetValue( "doesNotExist" );
            assertTrue( "Should have thrown an InvalidCallException", true );
        } catch ( InvalidCallException ex ) {
        }
    }

    @Test
    public void testTranslatableTextFragmentNonExistingAttributes( ) {

        // test exceptions for non existing attributes
        TranslatableTextFragment translatableTextFragment = tvp.createTranslatableTextFragment( null );
        try {
            translatableTextFragment.refGetValue( (String) null );
            assertTrue( "Should have thrown an InvalidNameException", true );
        } catch ( InvalidCallException ex ) {
        }
        try {
            translatableTextFragment.refGetValue( "doesNotExist" );
            assertTrue( "Should have thrown an InvalidCallException", true );
        } catch ( InvalidCallException ex ) {
        }
    }

    private void assertTextParameters( TranslatableText text, Integer maxWidth, String originalText, String resName, String resType, boolean translate, String transUnitId ) {

        assertEquals( maxWidth, (Integer)text.getMaxWidth( ) );
        assertEquals( originalText, text.getOriginalText( ) );
        assertEquals( resName, text.getResName( ) );
        assertEquals( resType, text.getResType( ) );
        assertEquals( translate, text.isTranslate( ) );
        assertEquals( transUnitId, text.getTransUnitId( ) );
    }

    private void assertValidGuid( String guid ) {

        assertNotNull( "Invalid GUID, GUID is null", guid );
        try {
            assertNotNull(  GUID.parseHexGUID( guid ).toBytes( ) );
        } catch ( GUIDFormatException GUIDFormatEx ) {
            fail( "Invalid GUID: \"" + guid + "\", " + GUIDFormatEx.getMessage( ) );
        }
    }
}
