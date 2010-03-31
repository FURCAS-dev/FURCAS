package com.sap.tc.moin.repository.test.s2x;

import org.junit.Test;

import com.sap.tc.moin.textverticalization.TranslatableText;

/**
 * This class contains tests that test the correct editing, creation, deletion
 * and versioning state of the generated S2X file per partition for the
 * partition edit use case.
 * <p>
 * It is based on the specification in the versioning state transition matrix
 * document
 * <p>
 * //TC/MOIN/doc/private/Design/I18N/Design/Rel 712/I18N_state_transitions.doc
 * <p>
 * Each versioning state transition in the document mentioned has a number with
 * which the corresponding test case can be found here.
 */
@SuppressWarnings( "nls" )
public class TestS2XSerializerExistenceAndVersioningForPartitionEdit extends TestS2XSerializerExistenceAndVersioning {

    /**
     * Versioning state transition number (5f2)
     * <p>
     * Initial state: partition with texts, no S2X file
     * <p>
     * Action: edit the partition
     * <p>
     * Final state: S2X file exists
     */
    @Test
    public void test_PartitionWithTexts_NoS2XFile_To_PartitionWithTexts_S2XFileExists( ) throws Exception {

        // initial state: partition with texts, no S2X file exists
        partition = createEmptyPartitionAndSave( "s2xFileEdited" );
        TranslatableText translatableText1 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text 1", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText1, partition );
        getMoinConnection( ).save( );
        // the save creates also an S2X file, in order to build the initial state we have to delete it again
        deleteS2XFileForPartition( partition.getPri( ) );
        // action: edit the partition
        // add a new a1f with a text in it
        TranslatableText translatableText2 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text 2", "testResName", "button", true ) );
        createA1fInPartition( translatableText2, partition );
        getMoinConnection( ).save( );
        // final state: S2X file exists
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should exist, but it doesn't.", s2xFile.exists( ) );
    }

    /**
     * Versioning state transition number (5h2)
     * <p>
     * Initial state: partition with texts, S2X file exists
     * <p>
     * Action: edit the partition
     * <p>
     * Final state: S2X file exists
     */
    @Test
    public void test_PartitionWithTexts_S2XFileExists_To_PartitionWithTexts_S2XFileExists( ) throws Exception {

        // initial state: partition with texts, S2X file exists
        partition = createEmptyPartitionAndSave( "s2xFileEdited" );
        TranslatableText translatableText1 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text 1", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText1, partition );
        getMoinConnection( ).save( );
        // action: edit the partition
        // add a new a1f with a text in it
        TranslatableText translatableText2 = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text 2", "testResName", "button", true ) );
        createA1fInPartition( translatableText2, partition );
        getMoinConnection( ).save( );
        // final state: S2X file exists
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        assertTrue( "The S2X file for partition \"s2xFileEdited\" should exist, but it doesn't.", s2xFile.exists( ) );
    }
}
