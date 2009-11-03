package com.sap.tc.moin.repository.test.s2x;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.junit.Test;

import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.textverticalization.TranslatableText;

/**
 * This class contains tests that test the correct editing, creation, deletion
 * and versioning state of the generated S2X file per partition for the
 * partition create use case.
 * <p>
 * It is based on the specification in the versioning state transition matrix
 * document
 * <p>
 * //TC/MOIN/doc/private/Design/I18N/Design/Rel 712/I18N_state_transitions.doc
 * <p>
 * Each versioning state transition in the document mentioned has a number with
 * which the corresponding test case can be found here.
 * <p>
 * The respective versioning is tested here for the use case of a local
 * development configuration (versioning must also handle this case !).
 * <p>
 * The corresponding tests concerning imported development configurations from a
 * DiTrack is /com/sap/tc/moin/facility/primary/versioning/ide/test/sc3/
 * TestVersioningForPartitionCreate.java in
 * _com.sap.tc.moin.testcases.fct_nwdi_ide.
 */
@SuppressWarnings( "nls" )
public class TestS2XSerializerExistenceAndVersioningForPartitionCreate extends TestS2XSerializerExistenceAndVersioning {

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    /**
     * Versioning state transition number (5a)
     * <p>
     * Initial state: no partition, no S2X file
     * <p>
     * Action: create a partition without any texts
     * <p>
     * Final state: no S2X file created
     */
    @Test
    public void test_NoPartition_NoS2XFile_To_PartitionWithNoTexts_NoS2XFile( ) throws Exception {

        // initial state: no partition, no S2X file
        // action: create a partition without any texts
        partition = createEmptyPartitionAndSave( "s2xFileNotCreated" );
        // an a1f without a text in the partition, no text file should be written
        partition.createElement( A1.class );
        getMoinConnection( ).save( );
        // final state: no S2X file created
        File s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertFalse( "The S2X file for partition \"s2xFileNotCreated\" should not have been created, but was.", s2xFile.exists( ) );
    }

    /**
     * Versioning state transition number (5c)
     * <p>
     * Initial state: no partition, S2X file exists and has texts
     * <p>
     * Action: create a partition without any texts
     * <p>
     * Final state: S2X file exists and has no texts in it
     */
    @Test
    public void test_NoPartition_S2XFileExists_To_PartitionWithoutTexts_S2XFileExists( ) throws Exception {

        // initial state: no partition, S2X file exists
        // in order to get the S2X file we need to create a dummy partition with texts that is going to be deleted again
        ModelPartition partitionDummy = createEmptyPartitionAndSave( "dummy" );
        IFile partitionDummyFileHandle = getFileHandle( partitionDummy.getPri( ) );
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my dummy test text", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText, partitionDummy );
        getMoinConnection( ).save( );

        // Copy the xlf-file and notify Eclipse that there is a new file
        File s2xFileDummy = getS2XFileForPartition( partitionDummy.getPri( ) );
        s2xFile = new File( s2xFileDummy.getAbsolutePath( ).replace( "dummy", "s2xFileEdited" ) );
        MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( s2xFileDummy, s2xFile );
        IFile s2xFileHandle = MOIN_IDE_TEST_HELPER.getFileUtil( ).getEclipseFile( partitionDummyFileHandle, s2xFile );
        if ( !s2xFileHandle.exists( ) ) {
            s2xFileHandle.refreshLocal( IResource.DEPTH_ZERO, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        }
        assertTrue( "The copied S2X file for partition \"s2xFileEdited\" should exist, but it doesn't.", s2xFileHandle.exists( ) );

        partitionDummy.delete( );
        getMoinConnection( ).save( );
        // action: create a partition without any texts
        partition = createEmptyPartitionAndSave( "s2xFileEdited" );
        // final state: S2X file exists and it is empty
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should exist, but it doesn't.", s2xFile.exists( ) );
        Integer textNumber = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile ).size( );
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should contain no text, but it contains " + textNumber + " texts.", textNumber == 0 );
    }

    /**
     * Versioning state transition number (5f1)
     * <p>
     * Initial state: no partition, no S2X file
     * <p>
     * Action: create a partition with texts
     * <p>
     * Final state: S2X file created
     */
    @Test
    public void test_NoPartition_NoS2XFile_To_PartitionWithTexts_S2XFileExists( ) throws Exception {

        // initial state: no partition, no S2X file
        // action: create a partition with texts
        partition = createEmptyPartitionAndSave( "s2xFileCreated" );
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // final state: S2X file created
        File s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertTrue( "The S2X file for partition \"s2xFileCreated\" should have been created, but wasn't.", s2xFile.exists( ) );
    }

    /**
     * Versioning state transition number (5h1)
     * <p>
     * Initial state: no partition, S2X file exists and has texts
     * <p>
     * Action: create a partition with another texts
     * <p>
     * Final state: S2X file exists and has the other texts in it
     */
    @Test
    public void test_NoPartition_S2XFileExists_To_PartitionWithTexts_S2XFileExists( ) throws Exception {

        // initial state: no partition, S2X file exists
        // in order to get the S2X file we need to create a dummy partition with texts that is going to be deleted again
        ModelPartition partitionDummy = createEmptyPartitionAndSave( "dummy" );
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my dummy test text", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText, partitionDummy );
        getMoinConnection( ).save( );
        File s2xFileDummy = getS2XFileForPartition( partitionDummy.getPri( ) );
        s2xFile = new File( s2xFileDummy.getAbsolutePath( ).replace( "dummy", "s2xFileEdited" ) );
        MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( s2xFileDummy, s2xFile );
        partitionDummy.delete( );
        getMoinConnection( ).save( );
        // action: create a partition with another texts
        partition = createEmptyPartitionAndSave( "s2xFileEdited" );
        TranslatableText translatableTextNew1 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my new test text 1", "testResName", "button", true ) );
        TranslatableText translatableTextNew2 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my new test text 2", "testResName", "button", true ) );
        // some a1f with a text in the partition
        createA1fInPartition( translatableTextNew1, partition );
        createA1fInPartition( translatableTextNew2, partition );
        getMoinConnection( ).save( );
        // final state: S2X file exists and has the other texts in it
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should exist, but it doesn't.", s2xFile.exists( ) );
        // check the content, i.e. whether the texts "translatableTextNew1" and "translatableTextNew2" are really contained in the S2X file
        Collection<TranslationUnit> translationUnits = MOIN_IDE_TEST_HELPER.getS2XUtil( ).getTranslationUnits( s2xFile );
        Integer textNumber = translationUnits.size( );
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should contain 2 texts, but it contains " + textNumber + " texts.", textNumber == 2 );
        TranslationUnit translationUnit = null;
        translationUnit = getTranslationUnitWithGivenId( translationUnits, translatableTextNew1.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, translatableTextNew1 );
        translationUnit = getTranslationUnitWithGivenId( translationUnits, translatableTextNew2.getTransUnitId( ) );
        assertEqualsContentsOfTranslationUnitAndTranslatableText( translationUnit, translatableTextNew2 );
    }
}
