package com.sap.tc.moin.repository.test.s2x;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.Test;

import com.sap.s2x.S2XDocument;
import com.sap.s2x.etc.TranslationUnit;
import com.sap.s2x.validation.ValidationException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.testcases.case015.A15;
import com.sap.tc.moin.testcases.case019.B19;
import com.sap.tc.moin.testcasesfoundation.case004f.ButtonTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.ShortTranslatableTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.VeryShortTranslatableTextF;
import com.sap.tc.moin.textverticalization.TranslatableText;

/**
 * Tis class contains tests that test the correct content of the generated S2X
 * file per partition
 */
@SuppressWarnings( "nls" )
public class TestS2XSerializerContent extends TestS2XSerializerAbstract {

    private ModelPartition partition = null;

    private File s2xFile = null;

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        partition = null;
        s2xFile = null;
    }

    /**
     * This test creates one class instance with one TranslatableText as
     * attribute values in it and checks whether the S2X file was written at
     * all.
     */
    @Test
    public void testS2XFileCreation( ) throws Exception {

        partition = createEmptyPartitionAndSave( "s2xFileExists" );
        // create a TranslatableText
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 42, "simple text", "testResName", "button", false ) );
        // one a1f with a text
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // check whether the S2X file was written
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertTrue( "The S2X file for partition \"s2xFileExists\" should exist, but it doesn't.", s2xFile.exists( ) );
    }

    /**
     * This test creates one class instance with one TranslatableText as
     * attribute values in it in a before created DC and checks whether the S2X
     * file contains the correct values from the DC metadata.
     */
    @Test
    public void testS2XFileContentDCMetadata( ) throws Exception {

        String expectedLocale = "it";
        String expectedAch = "BC-DWB-MOD";
        String expectedProductName = "MOIN S2X File Generator";
        partition = createEmptyPartitionAndSave( "s2xFileCheckDCMetadata", expectedLocale, expectedAch );
        // create a TranslatableText
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 42, "simple text", "testResName", "button", false ) );
        // one a1f with a text
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // check whether the S2X file was written correctly
        S2XDocument s2xDocument = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getS2XDocument( getS2XFileForPartition( partition.getPri( ) ) );
        String actualLocale = s2xDocument.getOriginalLocale( );
        String actualAch = s2xDocument.getDevelContact( );
        String actualProductName = s2xDocument.getProductname( );
        assertEquals( "The original locale of the S2X file should be \"" + expectedLocale + "\", but it is \"" + actualLocale + "\".", expectedLocale, actualLocale );
        assertEquals( "The application component hierarchy of the S2X file should be \"" + expectedAch + "\", but it is \"" + actualAch + "\".", expectedAch, actualAch );
        assertEquals( "The product name of the S2X file should be \"" + expectedProductName + "\", but it is \"" + actualProductName + "\".", expectedProductName, actualProductName );
    }

    /**
     * This test creates an instance of a class that has no attributes and saves
     * the partition.
     */
    @Test
    public void testS2XFileContentForClassesWithNoAttributes( ) throws Exception {

        partition = createEmptyPartitionAndSave( "s2xFileNoAttributes" );
        // one a15, has no attributes
        A15 a15 = partition.createElement( A15.class );
        // ensure that a15 really don't has any attribute, i.e. whether the metamodel was changed in the meanwhile
        List<Attribute> attributes = getMoinConnection( ).getJmiHelper( ).getAttributes( (MofClass) a15.refMetaObject( ), true );
        assertTrue( "The class A15 doesn't has to have any attribute, but it has.", attributes.isEmpty( ) );
        // now check whether the save runs through
        getMoinConnection( ).save( );
        // check whether the S2X file was not written
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertFalse( "The S2X file for partition \"s2xFileNoAttributes\" should not exist, but it does.", s2xFile.exists( ) );
    }

    /**
     * This test creates an instance of a class that has only single-valued
     * attributes filled with texts.
     */
    @Test
    public void testS2XFileContentForClassesWithSingleValuedAttributes( ) throws Exception {

        createEmptyPartitionAndS2XFileAndSave( "s2xFileSingleValuedAttributes" );
        // one b19, has only single-valued attributes filled
        ShortTranslatableTextF shortTranslatableText = case004fPackage.createShortTranslatableTextF( createStructureFieldContainer( (ShortTranslatableTextF) null, 255, "my short test text", "testResName", "button", true ) );
        createB19InPartition( shortTranslatableText, null, null, partition );
        getMoinConnection( ).save( );
        // check the translation units
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        TranslationUnit translationUnit = getTranslationUnitWithGivenId( translationUnits, shortTranslatableText.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, shortTranslatableText );
    }

    /**
     * This test creates an instance of a class that has only multi-valued
     * attributes filled with texts.
     */
    @Test
    public void testS2XFileContentForClassesWithMultiValuedAttributes( ) throws Exception {

        createEmptyPartitionAndS2XFileAndSave( "s2xFileMultiValuedAttributes" );
        // one b19, has only multi-valued attributes filled
        ButtonTextF buttonText1 = case004fPackage.createButtonTextF( createStructureFieldContainer( (ButtonTextF) null, 100, "my button text 1", "testResName", "button", true ) );
        ButtonTextF buttonText2 = case004fPackage.createButtonTextF( createStructureFieldContainer( (ButtonTextF) null, 100, "my button text 2", "testResName", "button", true ) );
        Collection<ButtonTextF> buttonTexts = new HashSet<ButtonTextF>( 2 );
        buttonTexts.add( buttonText1 );
        buttonTexts.add( buttonText2 );
        createB19InPartition( null, null, buttonTexts, partition );
        getMoinConnection( ).save( );
        // check the translation units
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        TranslationUnit translationUnit = null;
        translationUnit = getTranslationUnitWithGivenId( translationUnits, buttonText1.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, buttonText1 );
        translationUnit = getTranslationUnitWithGivenId( translationUnits, buttonText2.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, buttonText2 );
    }

    /**
     * This test creates some class instances with the same TranslatableTexts as
     * attribute values.
     */
    @Test
    public void testS2XFileContentWithSameTranslatableTextInDifferentAttributes( ) throws Exception {

        createEmptyPartitionAndS2XFileAndSave( "s2xFileSameText" );
        // create a TranslatableText
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 42, "same text at different attributes", "testResName", "button", false ) );
        // two a1fs with the same text
        createA1fInPartition( translatableText, partition );
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // check whether the text was written only once in the S2X file
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        int translationUnitsCount = translationUnits.size( );
        assertEquals( "The S2X file for partition \"s2xFileSameText\" should only contain 1 translation unit, but it contains " + translationUnitsCount + ".", 1, translationUnitsCount );
    }

    /**
     * This test creates some class instances with
     * <p>
     * a) null as TranslatableText in it
     * <p>
     * b) not null TranslatableText but null originalText
     * <p>
     * b) not null TranslatableText not null but empty originalText
     */
    @Test
    public void testS2XFileContentWithNullAsTranslatableText( ) throws Exception {

        partition = createEmptyPartitionAndSave( "s2xFileNullText" );
        // an a1f with a text equals to null
        createA1fInPartition( null, partition );
        // an a1f with an original text equals to null
        TranslatableText translatableTextWithNullOriginalText = tvPackage.createTranslatableText( null );
        createA1fInPartition( translatableTextWithNullOriginalText, partition );
        // an a1f with an empty original text
        TranslatableText translatableTextWithEmptyOriginalText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 0, "", "testResName", "button", false ) );
        createA1fInPartition( translatableTextWithEmptyOriginalText, partition );
        getMoinConnection( ).save( );
        // check whether the S2X file was not written
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertFalse( "The S2X file for partition \"s2xFileNullText\" should not exist, but it does.", s2xFile.exists( ) );
    }

    /**
     * This test creates some class instances with sub structures of
     * TranslatableText and saves the partition and the text file.
     */
    @Test
    public void testS2XFileContentWithSubTranslatableTexts( ) throws Exception {

        createEmptyPartitionAndS2XFileAndSave( "s2xFileSubTexts" );
        ShortTranslatableTextF shortTranslatableText = case004fPackage.createShortTranslatableTextF( createStructureFieldContainer( (ShortTranslatableTextF) null, 255, "my short test text", "testResName", "button", true ) );
        VeryShortTranslatableTextF veryShortTranslatableText = case004fPackage.createVeryShortTranslatableTextF( createStructureFieldContainer( (VeryShortTranslatableTextF) null, 100, "my very short test text", "testResName", "button", true ) );
        ButtonTextF buttonText1 = case004fPackage.createButtonTextF( createStructureFieldContainer( (ButtonTextF) null, 100, "my button text 1", "testResName", "button", true ) );
        ButtonTextF buttonText2 = case004fPackage.createButtonTextF( createStructureFieldContainer( (ButtonTextF) null, 100, "my button text 2", "testResName", "button", true ) );
        Collection<ButtonTextF> buttonTexts = new HashSet<ButtonTextF>( 2 );
        buttonTexts.add( buttonText1 );
        buttonTexts.add( buttonText2 );
        createB19InPartition( shortTranslatableText, veryShortTranslatableText, buttonTexts, partition );
        getMoinConnection( ).save( );
        // check whether the S2X file was written correctly
        // check the number of translation units, we should have 4
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        assertEquals( "The S2X file for partition \"s2xFileSubTexts\" should have 4 translation units, but it has " + translationUnits.size( ) + ".", 4, translationUnits.size( ) );
        // check the translation units
        TranslationUnit translationUnit = null;
        translationUnit = getTranslationUnitWithGivenId( translationUnits, shortTranslatableText.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, shortTranslatableText );
        translationUnit = getTranslationUnitWithGivenId( translationUnits, veryShortTranslatableText.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, veryShortTranslatableText );
        translationUnit = getTranslationUnitWithGivenId( translationUnits, buttonText1.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, buttonText1 );
        translationUnit = getTranslationUnitWithGivenId( translationUnits, buttonText2.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, buttonText2 );
    }

    /**
     * This test creates some class instances with erroneous texts and tries to
     * save the partition and the text file.
     */
    @Test
    public void testS2XFileContentWithErroneousTexts( ) throws Exception {
        createEmptyPartitionAndS2XFileAndSave( "s2xFileErroneousTexts" );

        // a short text with a maximum length that is too long, a "Button" is a short text, i.e. it can only have 255 characters at maximum
        TranslatableText translatableShortTextWithMaxWidthTooLong = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 256, "maximum width of this short text is too long", "testResName", "button", false ) );
        createA1fInPartition( translatableShortTextWithMaxWidthTooLong, partition );
        try {
            getMoinConnection( ).save( );
            errorAndStop( "Text maximum width of this short text is too long, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "Text maximum width of this short text is too long, should have thrown an S2X exception", containsException( partitionsNotSavedEx, ValidationException.class ) );
        }
        partition.deleteElements( );
        getMoinConnection( ).save( );

        // a long text with a maximum length that is too long, a "Description" is a long text, i.e. it can only have 16.384 characters at maximum
        TranslatableText translatableLongTextWithMaxWidthTooLong = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 16385, "maximum width of this long text is too long", "testResName", "description", false ) );
        createA1fInPartition( translatableLongTextWithMaxWidthTooLong, partition );
        try {
            getMoinConnection( ).save( );
            errorAndStop( "Text maximum width of this long text is too long, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "Text maximum width of this long text is too long, should have thrown an S2X exception", containsException( partitionsNotSavedEx, ValidationException.class ) );
        }
        partition.deleteElements( );
        getMoinConnection( ).save( );

        // a text which is longer than the maximum length
        TranslatableText translatableTextTooLong = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 10, "text is too long", "testResName", "button", false ) );
        createA1fInPartition( translatableTextTooLong, partition );
        try {
            getMoinConnection( ).save( );
            errorAndStop( "Text text is too long, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "Text text is too long, should have thrown an S2X exception", containsException( partitionsNotSavedEx, ValidationException.class ) );
        }
        partition.deleteElements( );
        getMoinConnection( ).save( );

        // a text with a resource type equals to null
        TranslatableText translatableTextWithNullResType = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 100, "resource type is null", "testResName", null, false ) );
        createA1fInPartition( translatableTextWithNullResType, partition );
        try {
            getMoinConnection( ).save( );
            errorAndStop( "Text resource type is null, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "Text resource type is null, should have thrown an S2X exception", containsException( partitionsNotSavedEx, ValidationException.class ) );
        }
        partition.deleteElements( );
        getMoinConnection( ).save( );

        // a text with an invalid resource type
        TranslatableText translatableTextWithInvalidResType = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 100, "resource type is invalid", "testResName", "myInvalidResType", false ) );
        createA1fInPartition( translatableTextWithInvalidResType, partition );
        try {
            getMoinConnection( ).save( );
            errorAndStop( "Text resource type is invalid, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "Text resource type is invalid, should have thrown an S2X exception", containsException( partitionsNotSavedEx, ValidationException.class ) );
        }
        partition.deleteElements( );
        getMoinConnection( ).save( );
    }

    private B19 createB19InPartition( ShortTranslatableTextF translatableTextShort1, VeryShortTranslatableTextF translatableTextVeryShort1, Collection<? extends ButtonTextF> translatableButtons, ModelPartition partition ) {

        B19 b19 = partition.createElement( B19.class );
        b19.setTranslatableTextShort1( translatableTextShort1 );
        b19.setTranslatableTextVeryShort1( translatableTextVeryShort1 );
        b19.getTranslatableButtons( ).addAll( translatableButtons );
        return b19;
    }

    protected void createEmptyPartitionAndS2XFileAndSave( String partitionName ) throws Exception {

        // get or create the partition
        partition = createEmptyPartitionAndSave( partitionName );
        // generate an empty S2X file
        s2xFile = createEmptyS2XFileForPartition( partition.getPri( ) );
    }
}
