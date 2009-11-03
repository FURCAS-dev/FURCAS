package com.sap.tc.moin.repository.test.s2x;

import java.io.File;
import java.util.Collection;

import org.junit.Test;

import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.s2x.S2XSerializerException;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerDefaultCallback;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XTranslationUnit;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.case019.serializationcallback.B19Serialization;
import com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText;
import com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment;

/**
 * Tis class contains tests that test the S2X serialization callback
 * functionality
 */
@SuppressWarnings( "nls" )
public class TestS2XSerializerCallback extends TestS2XSerializerAbstract {

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    private ModelPartition partition = null;

    private File s2xFile = null;

    protected CoreConnection coreConnection = null;

    protected PartitionSerializationManagerImpl serializationManager = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        coreConnection = MOIN_IDE_TEST_HELPER.getCoreConnection( getMoinConnection( ) );
        SpiFacility facility = (SpiFacility) coreConnection.getSession( ).getMoin( ).getFacilityById( "PF" );
        serializationManager = (PartitionSerializationManagerImpl) facility.getPartitionSerializationManager( );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        coreConnection = null;
        serializationManager = null;
        partition = null;
        s2xFile = null;
    }

    /**
     * This test creates one class instance with one
     * {@link TranslatableTextFragment TranslatableTextFragment} as attribute
     * value in it and checks whether the S2X file content was written
     * accordingly to the registered callback handler
     * {@link SimpleTestS2XSerializerCallback SimpleTestS2XSerializerCallback}
     */
    @Test
    public void testS2XFileContentWithCallback( ) throws Exception {

        partition = createEmptyPartitionAndSave( "s2xFile" );
        // create a TranslatableTextFragment
        A19TranslatableTextFragment translatableTextFragment = case019Package.getTranslatabletexts( ).createA19TranslatableTextFragment( createStructureFieldContainer( (A19TranslatableTextFragment) null, 42, "simple text", "button" ) );
        // one a1f with a text
        B19Serialization b19Serialization = partition.createElement( B19Serialization.class );
        b19Serialization.setTestTranslatableTextFragment( translatableTextFragment );
        getMoinConnection( ).save( );
        // check whether the S2X file was written correctly
        // check the translation units
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        TranslationUnit translationUnit = getTranslationUnitWithGivenId( translationUnits, translatableTextFragment.getTransUnitId( ) );
        String serializedResName = "ModifiedBySimpleCallback";
        assertEquals( "The resource name of the translation unit (" + translationUnit.getResname( ) + ") should be \"" + serializedResName + "\", but it is \"" + translationUnit.getResname( ) + "\".", serializedResName, translationUnit.getResname( ) );
    }

    /**
     * This test creates one class instance with one {@link TranslatableText
     * TranslatableText} as attribute value in it and checks whether the S2X
     * file content was written correctly.
     * <p>
     * Note that there is no callback handler involved.
     */
    @Test
    public void testS2XFileContentWithoutCallback( ) throws Exception {

        partition = createEmptyPartitionAndSave( "s2xFile" );
        // create a TranslatableText, no TranslatableTextFragment
        A19TranslatableText translatableText = case019Package.getTranslatabletexts( ).createA19TranslatableText( createStructureFieldContainer( (A19TranslatableText) null, 42, "simple text", "testResName", "button", false ) );
        // one a1f with a text
        B19Serialization b19Serialization = partition.createElement( B19Serialization.class );
        b19Serialization.setTestTranslatableText( translatableText );
        getMoinConnection( ).save( );
        // check whether the S2X file was written correctly
        // check the translation units
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        TranslationUnit translationUnit = getTranslationUnitWithGivenId( translationUnits, translatableText.getTransUnitId( ) );
        String serializedResName = "testResName";
        assertEquals( "The resource name of the translation unit (" + translationUnit.getResname( ) + ") should be \"" + serializedResName + "\", but it is \"" + translationUnit.getResname( ) + "\".", serializedResName, translationUnit.getResname( ) );
    }

    @Test
    public void testS2XFileContentNoCallbackHandlerRegistered( ) throws Exception {
        // get the old serialization callback handler
        SpiS2XSerializerCustomCallback serializationCallbackBak = serializationManager.getCustomS2XSerializerCallback( TestMetaModels.TESTCASES_CN );
        // create a partition
        partition = createEmptyPartitionAndSave( "s2xFile" );
        // create a TranslatableTextFragment
        A19TranslatableTextFragment translatableTextFragment = case019Package.getTranslatabletexts( ).createA19TranslatableTextFragment( createStructureFieldContainer( (A19TranslatableTextFragment) null, 42, "simple text", "button" ) );
        // one a1f with a text
        B19Serialization b19Serialization = partition.createElement( B19Serialization.class );
        b19Serialization.setTestTranslatableTextFragment( translatableTextFragment );
        // remove the serialization callback handler from the registry
        serializationManager.removeS2XSerializerCallback( TestMetaModels.TESTCASES_CN );
        // save
        try {
            getMoinConnection( ).save( );
            errorAndStop( "The metamodel hasn't defined a serialization callback handler, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "The metamodel hasn't defined a serialization callback handler, should have thrown an S2X serializer exception", containsException( partitionsNotSavedEx, S2XSerializerException.class ) );
        }
        // reset the serialization callback handler
        if ( serializationCallbackBak != null ) {
            serializationManager.setS2XSerializerCallback( TestMetaModels.TESTCASES_CN, serializationCallbackBak );
        } else {
            serializationManager.removeS2XSerializerCallback( TestMetaModels.TESTCASES_CN );
        }
    }

    @Test
    public void testS2XFileContentErroneousCallbackHandlerRegistered( ) throws Exception {
        // get the old serialization callback handler
        SpiS2XSerializerCustomCallback serializationCallbackBak = serializationManager.getCustomS2XSerializerCallback( TestMetaModels.TESTCASES_CN );
        // create a partition
        partition = createEmptyPartitionAndSave( "s2xFile" );
        // create a TranslatableTextFragment
        A19TranslatableTextFragment translatableTextFragment = case019Package.getTranslatabletexts( ).createA19TranslatableTextFragment( createStructureFieldContainer( (A19TranslatableTextFragment) null, 42, "simple text", "button" ) );
        // one a1f with a text
        B19Serialization b19Serialization = partition.createElement( B19Serialization.class );
        b19Serialization.setTestTranslatableTextFragment( translatableTextFragment );
        // set a new serialization callback handler
        serializationManager.setS2XSerializerCallback( TestMetaModels.TESTCASES_CN, new ErroneousS2XSerializerCallback( ) );
        // save
        try {
            getMoinConnection( ).save( );
            errorAndStop( "The metamodel has defined an erroneous serialization callback handler, should have thrown a PartitionsNotSavedException" );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            assertTrue( "The metamodel has defined an erroneous serialization callback handler, should have thrown an S2X serializer exception", containsException( partitionsNotSavedEx, S2XSerializerException.class ) );
        }
        // reset the serialization callback handler
        if ( serializationCallbackBak != null ) {
            serializationManager.setS2XSerializerCallback( TestMetaModels.TESTCASES_CN, serializationCallbackBak );
        } else {
            serializationManager.removeS2XSerializerCallback( TestMetaModels.TESTCASES_CN );
        }
    }

    private class ErroneousS2XSerializerCallback extends SpiS2XSerializerDefaultCallback {

        public SpiS2XTranslationUnit getTranslationUnit( SpiElement translatableTextAttributeParent, String translatableTextAttributeName, SpiStructuredValue translatableTextValue ) {
            // returns null, this is not allowed
            return null;
        }
    }
}
