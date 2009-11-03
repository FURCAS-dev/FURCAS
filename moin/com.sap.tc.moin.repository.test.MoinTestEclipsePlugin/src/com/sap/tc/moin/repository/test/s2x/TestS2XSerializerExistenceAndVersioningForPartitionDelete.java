package com.sap.tc.moin.repository.test.s2x;

import org.junit.Test;

import com.sap.tc.moin.textverticalization.TranslatableText;

/**
 * This class contains tests that test the correct editing, creation, deletion
 * and versioning state of the generated S2X file per partition for the
 * partition delete use case.
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
public class TestS2XSerializerExistenceAndVersioningForPartitionDelete extends TestS2XSerializerExistenceAndVersioning {

    /**
     * Versioning state transition number (6c)
     * <p>
     * Initial state: partition with texts, S2X file exists
     * <p>
     * Action: delete the partition
     * <p>
     * Final state: S2X file deleted
     */
    @Test
    public void test_PartitionWithTexts_S2XFileExists_To_NoPartition_NoS2XFile( ) throws Exception {

        // initial state: partition with texts, S2X file exists
        partition = createEmptyPartitionAndSave( "s2xFileDeleted" );
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // action: delete the partition, get the S2X file before the delete, after the delete this wouldn't be possible anymore
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        partition.delete( );
        getMoinConnection( ).save( );
        // final state: S2X file deleted
        assertFalse( "The S2X file for partition \"s2xFileDeleted\" should have been deleted, but wasn't.", s2xFile.exists( ) );
    }

    /**
     * Versioning state transition number (6d)
     * <p>
     * Initial state: partition with texts, no S2X file
     * <p>
     * Action: delete the partition
     * <p>
     * Final state: S2X file deleted
     */
    @Test
    public void test_PartitionWithTexts_NoS2XFile_To_NoPartition_NoS2XFile( ) throws Exception {

        // initial state: partition with texts, no S2X file exists
        partition = createEmptyPartitionAndSave( "s2xFileDeleted" );
        TranslatableText translatableText = tvPackage.createTranslatableText( createStructureFieldContainer( (TranslatableText) null, 255, "my test text", "testResName", "button", true ) );
        // an a1f with a text in the partition
        createA1fInPartition( translatableText, partition );
        getMoinConnection( ).save( );
        // the save creates also an S2X file, in order to build the initial state we have to delete it again
        deleteS2XFileForPartition( partition.getPri( ) );
        // action: delete the partition, get the S2X file before the delete, after the delete this wouldn't be possible anymore
        s2xFile = getS2XFileForPartition( partition.getPri( ) );
        partition.delete( );
        getMoinConnection( ).save( );
        // final state: S2X file deleted
        assertFalse( "The S2X file for partition \"s2xFileDeleted\" should have been deleted, but wasn't.", s2xFile.exists( ) );
    }
}
