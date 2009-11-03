package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;


public abstract class AbstractTestLogicalFile extends AbstractTestLogicalResource {

    /*
     * Test setup related methods
     */

    private final String[] ARCHIVED_FILES_NAMES = new String[] { "hello.txt", "secret.key" };

    private final String[] ARCHIVED_FILES_CONTENT = new String[] { "hello world", "42" };

    /**
     * Returns a new logical file under test.
     */
    protected LogicalFileTestInstance createLogicalFileTestInstance( ) {

        // create a test file
        String createdFileName = "createdfile.ext";
        String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileName;
        String createdFileAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileName;

        IpiLogicalFile logicalFile = this.createLogicalFsFactoryTestInstance( ).createFile( createdFilePath );

        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
        assertNotNull( "Returned logical file must not be null.", logicalFile );

        // return file instance information
        LogicalFileTestInstance testInstance = new LogicalFileTestInstance( );
        testInstance.logicalFile = logicalFile;
        testInstance.fileLogicalFsPath = createdFilePath;
        testInstance.absoluteFile = new File( createdFileAbsolutePath );

        return testInstance;
    }

    protected LogicalFileTestInstance createLogicalFileTestArchiveInstance( ) {

        LogicalFileTestInstance testInstance = this.createLogicalFileTestInstance( );

        // write archive content to created test instance
        try {
            ZipOutputStream out = new ZipOutputStream( new FileOutputStream( testInstance.absoluteFile ) );
            for ( int i = 0; i < ARCHIVED_FILES_NAMES.length; i++ ) {
                out.putNextEntry( new ZipEntry( ARCHIVED_FILES_NAMES[i] ) );
                out.write( ARCHIVED_FILES_CONTENT[i].getBytes( ) );
                out.closeEntry( );
            }
            out.flush( );
            out.close( );
        } catch ( IOException e ) {
            fail( "Test set-up error: unable to write archive content to file " + testInstance.absoluteFile );
        }

        return testInstance;
    }

    public static final class LogicalFileTestInstance {

        public IpiLogicalFile logicalFile;

        public String fileLogicalFsPath;

        public File absoluteFile;
    }

    @Override
    protected LogicalResourceTestInstance createLogicalResourceTestInstance( ) {

        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );
        // return file instance information
        LogicalResourceTestInstance resourceUnderTest = new LogicalResourceTestInstance( );
        resourceUnderTest.logicalResource = fileUnderTest.logicalFile;
        resourceUnderTest.resourceLogicalFsPath = fileUnderTest.fileLogicalFsPath;
        resourceUnderTest.absoluteFile = fileUnderTest.absoluteFile;

        return resourceUnderTest;
    }

    /*
     * The actual test methods
     */

    @Test
    public void testIsReadOnly( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertFalse( "Read-only state of just created resource " + resourceUnderTest.absoluteFile + " should be false but was true.", ( (IpiLogicalFile) resourceUnderTest.logicalResource ).isReadOnly( ) );

        // make resource readonly
        boolean succeeded = resourceUnderTest.absoluteFile.setReadOnly( );
        assertTrue( "Test set-up error. Unable to set readonly state of resource " + resourceUnderTest.absoluteFile, succeeded );

        assertTrue( "Read-only state of resource " + resourceUnderTest.absoluteFile + " should be true but was false.", ( (IpiLogicalFile) resourceUnderTest.logicalResource ).isReadOnly( ) );
    }

    @Test
    public void testDelete( ) {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        // call interface method under test
        boolean wasDeleted = fileUnderTest.logicalFile.delete( );

        assertTrue( "File was not deleted.", wasDeleted );
        assertFalse( "File should be deleted " + fileUnderTest.absoluteFile + " but does still exist.", fileUnderTest.absoluteFile.exists( ) );
    }

//    @Test
//    @Ignore( "Implementations react inconsistent" )
//    public void testDeleteArchive( ) {
//
//        // create instance under test
//        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestArchiveInstance( );
//
//        // call interface method under test
//        boolean wasDeleted = fileUnderTest.logicalFile.delete( );
//
//        assertFalse( "Deletion of an archive file should not be supported but delete() returned true.", wasDeleted );
//        assertTrue( "File should not be deleted " + fileUnderTest.absoluteFile + " but does not exist.", fileUnderTest.absoluteFile.exists( ) );
//    }


    //    @Test
    //    @Staged
    //    public void testLogicalFileDeleteNotExisting( ) {
    //
    //        // try creation of: <tmpbase>\createdfile.test
    //        String createdFileName = "createdfile.test";
    //        String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileName;
    //        String createdFileAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileName;
    //
    //        // preconditions
    //        LogicalFile logicalFile = this.lfsFactory.createFile( createdFilePath );
    //
    //        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
    //        assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
    //        assertTrue( "Logical file returned unexpected result. Expected: exists() result true but was false. " + new File( createdFileAbsolutePath ), logicalFile.exists( ) );
    //        assertNotNull( "Returned logical file must not be null.", logicalFile );
    //
    //        boolean wasDeletedDirectly = new File( createdFileAbsolutePath ).delete( );
    //        assertTrue( "File was not deleted.", wasDeletedDirectly );
    ////        assertFalse( "Logical file returned unexpected result. Expected: exists() result false but was true. " + new File( createdFileAbsolutePath ), logicalFile.exists( ) );
    //
    //        // call interface method under test
    //        boolean wasDeleted = logicalFile.delete( );
    //
    ////        assertFalse( "File should not be deleteable since it did not exist.", wasDeleted );
    //        assertFalse( "Logical file returned unexpected result. Expected: exists() result false but was true. " + new File( createdFileAbsolutePath ), logicalFile.exists( ) );
    //        assertFalse( "File should be deleted " + new File( createdFileAbsolutePath ) + " but does still exist.", new File( createdFileAbsolutePath ).exists( ) );
    //    }

    @Test
    public void testDeleteWithOpenInputStream( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        OutputStream os = null;
        InputStream is = null;
        try {
            // fill created file with some content
            os = new FileOutputStream( fileUnderTest.absoluteFile );
            os.write( "content".getBytes( ) );
            os.flush( );
            os.close( );

            // open input stream (this should cause the deletion to fail)
            is = new FileInputStream( fileUnderTest.absoluteFile );
            is.read( ); // read first byte, stream si still open

            // call method under test
            boolean wasDeleted = fileUnderTest.logicalFile.delete( );

            // we expect no exception but false as return value
            assertTrue( "File should not be deleted due to an open input stream but does still exist: " + fileUnderTest.absoluteFile, fileUnderTest.absoluteFile.exists( ) );
            assertFalse( "File seems to be deleted even though an input stream was still open.", wasDeleted );

        } finally {
            if ( is != null ) {
                try {
                    is.close( );
                } catch ( Exception exc ) {
                }
            }
            if ( os != null ) {
                try {
                    os.close( );
                } catch ( Exception exc ) {
                }
            }
        }
    }

    @Test
    public void testDeleteNotExisting( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        // call interface method under test
        boolean wasDeleted = fileUnderTest.logicalFile.delete( );

        assertTrue( "File was not deleted.", wasDeleted );
        assertFalse( "File should be deleted " + fileUnderTest.absoluteFile + " but does still exist.", fileUnderTest.absoluteFile.exists( ) );

        // call interface method under test (try to delete a file which does not exist any more)
        wasDeleted = fileUnderTest.logicalFile.delete( );
        assertFalse( "Delete operation should not return true if the file to delete does not exist.", wasDeleted );
    }

    @Test
    public void testExists( ) {

        String createdFileName = "createdfile";
        String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileName;
        String createdFileAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileName;

        IpiLogicalResource logicalResource = this.createLogicalFsFactoryTestInstance( ).getResource( createdFilePath );

        // preconditions
        assertNull( "Not existing logical resource should be null.", logicalResource );
        assertFalse( "Created file " + new File( createdFileAbsolutePath ) + " was not yet created but does exist.", new File( createdFileAbsolutePath ).exists( ) );

        IpiLogicalFile logicalFile = this.createLogicalFsFactoryTestInstance( ).createFile( createdFilePath );
        logicalResource = this.createLogicalFsFactoryTestInstance( ).getResource( createdFilePath );

        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
        assertNotNull( "Logical resource must not be null.", logicalResource );
        assertTrue( "Logical resource returned unexpected result. Expected: exists() result true but was false. " + new File( createdFileAbsolutePath ), logicalResource.exists( ) );
        assertTrue( "Logical file returned unexpected result. Expected: exists() result true but was false. " + new File( createdFileAbsolutePath ), logicalFile.exists( ) );

        boolean wasDeleted = logicalFile.delete( );

        assertTrue( "File was not deleted.", wasDeleted );
        assertFalse( "Logical resource returned unexpected result. Expected: exists() result false but was true. " + new File( createdFileAbsolutePath ), logicalResource.exists( ) );
        assertFalse( "Logical file returned unexpected result. Expected: exists() result false but was true. " + new File( createdFileAbsolutePath ), logicalFile.exists( ) );
    }

    @Test
    public void testIsArchiveForNonArchive( ) {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        assertFalse( "isArchive() must not return true for a non archive file.", fileUnderTest.logicalFile.isArchive( ) );
    }

    @Test
    public void testIsArchiveForArchive( ) {

        // create instance under test
        LogicalFileTestInstance archiveFileUnderTest = this.createLogicalFileTestArchiveInstance( );

        assertTrue( "isArchive() must return true for an archive file.", archiveFileUnderTest.logicalFile.isArchive( ) );
    }

    @Test
    public void testGetArchiveContent( ) throws IOException {

        // create instance under test
        LogicalFileTestInstance archiveFileUnderTest = this.createLogicalFileTestArchiveInstance( );

        for ( int i = 0; i < ARCHIVED_FILES_NAMES.length; i++ ) {

            // get input stream for last archive entry
            InputStream is = null;
            try {
                is = archiveFileUnderTest.logicalFile.getArchiveContent( ARCHIVED_FILES_NAMES[i] );

                // read from stream
                byte bytes[] = new byte[ARCHIVED_FILES_CONTENT[i].getBytes( ).length];
                is.read( bytes );
                is.close( );

                assertArrayEquals( "Read content diverges from originial file content.", ARCHIVED_FILES_CONTENT[i].getBytes( ), bytes );
                assertEquals( "Read content diverges from originial file content.", ARCHIVED_FILES_CONTENT[i], new String( bytes ) );
            } finally {
                if ( is != null ) {
                    is.close( );
                }
            }
        }

        try {
            archiveFileUnderTest.logicalFile.getArchiveContent( "SomeEntryWhichDoesNotExist" );
            fail( "Request for not existing archive entry content should lead to a RuntimeException." );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ expected
        }
    }

    @Test
    public void testGetArchiveContentInputStreamOperations( ) throws IOException {

        // create instance under test
        LogicalFileTestInstance archiveFileUnderTest = this.createLogicalFileTestArchiveInstance( );

        int entryNumber = 0;

        InputStream is = null;
        try {
            // get input stream for last archive entry
            is = archiveFileUnderTest.logicalFile.getArchiveContent( ARCHIVED_FILES_NAMES[entryNumber] );

            // read one byte from stream
            int i = is.read( );
            assertEquals( "Input stream error (content='hello world'): first read character should be 'h'.", ARCHIVED_FILES_CONTENT[entryNumber].charAt( 0 ), ( (char) i ) );

            // discard one byte
            long l = is.skip( 1 );
            if ( l > 0 ) {
                i = is.read( );
                assertEquals( "Input stream error (content='hello world').", ARCHIVED_FILES_CONTENT[entryNumber].charAt( 2 ), ( (char) i ) );
            }

            byte bytes[] = new byte["lo w".getBytes( ).length];
            is.read( bytes, 0, bytes.length );
            assertEquals( "Input stream error (content='hello world'): read(byte b[], int off, int len) returned unexpected result.", "lo w", new String( bytes ) );

            assertEquals( "Input stream error (content='hello world'): available() returned wrong result.", 4, is.available( ) );

            assertFalse( "Mark should not be supported.", is.markSupported( ) );
            is.mark( 0 ); // NOP
            try {
                is.reset( );
                fail( "Reset should not be supported and therefore cause a IOException." );
            } catch ( IOException e ) {
                // $JL-EXC$ expected
            }
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }
    }

    @Test
    public void testGetInputStream( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "read this from file...".getBytes( );

        // prepare file
        OutputStream os = null;
        try {
            os = new FileOutputStream( fileUnderTest.absoluteFile );
            os.write( content );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        // call method under test
        InputStream is = null;
        byte readBytes[] = new byte[content.length];
        try {
            is = fileUnderTest.logicalFile.getInputStream( );
            is.read( readBytes );
            is.close( );
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) );
    }

    @Test
    public void testGetInputStreamNotExisting( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        boolean wasDeleted = fileUnderTest.logicalFile.delete( );
        assertTrue( "Test set-up error. File could not be deleted: " + fileUnderTest.absoluteFile, wasDeleted );
        assertFalse( "Test set-up error. File could not be deleted: " + fileUnderTest.absoluteFile, fileUnderTest.absoluteFile.exists( ) );

        // call method under test
        InputStream is = null;
        try {
            is = fileUnderTest.logicalFile.getInputStream( );
            fail( "Calling getInputStream() on a not existing resource should lead to a RuntimeException." );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ expected
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }
    }

    /**
     * Tests if the {@link OutptStream} returned by
     * {@link IpiLogicalFile#getOutputStream()} works correctly.
     */
    @Test
    public void testGetOutputStream( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "write this to file...".getBytes( );

        // call method under test
        OutputStream os = null;
        try {
            os = fileUnderTest.logicalFile.getOutputStream( );
            os.write( content );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        // get written content for comparison
        InputStream is = null;
        byte readBytes[] = new byte[content.length];
        try {
            is = new FileInputStream( fileUnderTest.absoluteFile );
            is.read( readBytes );
            is.close( );
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) );
    }

    /**
     * Tests if the {@link OutptStream} returned by
     * {@link IpiLogicalFile#getOutputStream()} works correctly if
     * {@link OutputStream#flush()} is used.
     */
    @Test
    @Ignore( "Current the eclipse implementation does not support flush (flush actually acts like close). Not critical." )
    public void testGetOutputStreamFlush( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "write this to file...".getBytes( );
        byte part1[] = "write ".getBytes( );
        byte part2[] = "this ".getBytes( );
        byte part3[] = "to file...".getBytes( );

        // call method under test
        OutputStream os = null;
        try {
            os = fileUnderTest.logicalFile.getOutputStream( );
            os.write( part1 );
            os.flush( );
            os.write( part2 );
            os.flush( );
            os.write( part3 );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        // get written content for comparison
        InputStream is = null;
        byte readBytes[] = new byte[content.length];
        try {
            is = new FileInputStream( fileUnderTest.absoluteFile );
            is.read( readBytes );
            is.close( );
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) );
    }

    @Test
    public void testGetOutputStreamNotExisting( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        // delete file
        boolean wasDeleted = fileUnderTest.absoluteFile.delete( );
        assertTrue( "Test set-up error. File could not be deleted: " + fileUnderTest.absoluteFile, wasDeleted );

        byte content[] = "write this to file...".getBytes( );

        // call method under test (should create the file if it does not exist)
        OutputStream os = null;
        try {
            os = fileUnderTest.logicalFile.getOutputStream( );
            os.write( content );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        assertTrue( "File " + fileUnderTest.absoluteFile + " does not exist but should have been implicitly created.", fileUnderTest.absoluteFile.exists( ) );

        // get written content for comparison
        InputStream is = null;
        byte readBytes[] = new byte[content.length];
        try {
            is = new FileInputStream( fileUnderTest.absoluteFile );
            is.read( readBytes );
            is.close( );
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) );
    }


    @Test
    @Ignore( "Currently the eclipse implementation throws an exception not until flush/close was called. Not critical." )
    public void testGetOutputStreamNotExistingUncreatable( ) {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        boolean wasDeleted = fileUnderTest.logicalFile.delete( );
        assertTrue( "Test set-up error. File could not be deleted: " + fileUnderTest.absoluteFile, wasDeleted );
        assertFalse( "Test set-up error. File could not be deleted: " + fileUnderTest.absoluteFile, fileUnderTest.absoluteFile.exists( ) );

        // create folder with the deleted file's name
        // -> OutputStream creation will not be able to create a file on the fly
        boolean wasCreated = fileUnderTest.absoluteFile.mkdir( );
        assertTrue( "Test set-up error. Folder could not be created: " + fileUnderTest.absoluteFile, wasCreated );

        // call method under test
        OutputStream os = null;
        try {
            os = fileUnderTest.logicalFile.getOutputStream( );
            fail( "Calling getOutputStream() on an underlaying folder resource should lead to a RuntimeException." );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ expected
        } finally {
            if ( os != null ) {
                try {
                    os.close( );
                } catch ( Exception e ) {
                    System.out.println( "Exception during os.close():" );
                    e.printStackTrace( System.out );
                }
            }
        }
    }

    /**
     * Tests if the {@link OutptStream} returned by
     * {@link IpiLogicalFile#getOutputStream()} works correctly if the
     * underlying resource changed after the tested {@link IpiLogicalFile}
     * instance was created.
     */
    @Test
    public void testGetOutputStreamRefresh( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "write this to file...".getBytes( );

        // screw up file
        OutputStream os = null;
        try {
            os = new FileOutputStream( fileUnderTest.absoluteFile );
            os.write( content );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }
        fileUnderTest.absoluteFile.setLastModified( new Date( ).getTime( ) );

        // call method under test
        os = null;
        try {
            os = fileUnderTest.logicalFile.getOutputStream( );
            os.write( content );
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        // get written content for comparison
        InputStream is = null;
        byte readBytes[] = new byte[content.length];
        try {
            is = new FileInputStream( fileUnderTest.absoluteFile );
            is.read( readBytes );
            is.close( );
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) );
    }


    @Test
    public void testGetLengthForNonArchive( ) throws IOException {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );
        String content = "write this to file...";

        assertTrue( "Incorrect file size detected: Should be 0 for an empty (just created) file.", 0 == fileUnderTest.logicalFile.getLength( ) );

        FileWriter fw = new FileWriter( fileUnderTest.absoluteFile );
        fw.append( content );
        fw.flush( );
        fw.close( );

        assertTrue( "Incorrect file size detected.", content.length( ) == fileUnderTest.logicalFile.getLength( ) );
    }

    @Test
    public void testGetLengthForArchive( ) throws IOException {

        // create instance under test
        LogicalFileTestInstance archiveFileUnderTest = this.createLogicalFileTestArchiveInstance( );

        for ( int i = 0; i < ARCHIVED_FILES_NAMES.length; i++ ) {

            // get input stream for last archive entry
            long length = archiveFileUnderTest.logicalFile.getArchiveContentLength( ARCHIVED_FILES_NAMES[i] );

            assertTrue( "Detected incorrect file length in archive", ARCHIVED_FILES_CONTENT[i].length( ) == length );
        }

        try {
            archiveFileUnderTest.logicalFile.getArchiveContentLength( "SomeEntryWhichDoesNotExist" );
            fail( "Request for not existing archive entry content should lead to a RuntimeException." );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ expected
        }
    }
}
