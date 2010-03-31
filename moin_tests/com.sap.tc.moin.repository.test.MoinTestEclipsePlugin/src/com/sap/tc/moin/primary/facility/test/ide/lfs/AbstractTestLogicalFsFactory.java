package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;

/**
 * An abstract test class for {@link IpiLogicalFsFactory} test implementations.
 * <p>
 * A derived test class has to overwrite the method {@link #beforeTestMethod()}
 * and set the member {@link #lfsFactory} with an instance of the specific
 * {@link IpiLogicalFsFactory} implementation it intends to test.
 * 
 * @author d047015
 */
public abstract class AbstractTestLogicalFsFactory extends AbstractTestLogicalFilesystemBase {

    /**
     * Tests if a folder is properly created (based on legal argument).
     */
    @Test
    public void testCreateFolder( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        for ( int i = 0; i < LEGAL_FOLDER_NAMES.length; i++ ) {
            // try creation of: <tmpbase>\createdfolder
            String createdFolderName = LEGAL_FOLDER_NAMES[i];
            String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + i + "\\" + createdFolderName;
            String createdFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + i + "\\" + createdFolderName;

            // call interface method under test
            IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );

            assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
            assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a directory.", new File( createdFolderAbsolutePath ).isDirectory( ) );
            assertNotNull( "Returned logical folder must not be null.", logicalFolder );
        }
    }

    /**
     * Tests if a file is properly created (based on legal argument).
     */
    @Test
    public void testCreateFile( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        for ( int i = 0; i < LEGAL_FILE_NAMES.length; i++ ) {
            // try creation of: <tmpbase>\<filename>
            String createdFileName = LEGAL_FILE_NAMES[i];
            String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + i + "\\" + createdFileName;
            String createdFileAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + i + "\\" + createdFileName;

            // call interface method under test
            IpiLogicalFile logicalFile = lfsFactory.createFile( createdFilePath );

            assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
            assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
            assertNotNull( "Returned logical file must not be null.", logicalFile );
        }
    }

    /**
     * Tests if a request for the creation of a already existing file is handled
     * correctly.
     */
    @Test
    public void testCreateFileAlreadyExists( ) throws IOException {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        // try creation of: <tmpbase>\<filename>
        String createdFileName = "createdfile";
        String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileName;
        String createdFileAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileName;

        // make shure the file already exists
        boolean wasCreated = new File( createdFileAbsolutePath ).createNewFile( );

        if ( !wasCreated || !new File( createdFileAbsolutePath ).exists( ) ) {
            fail( "Test set-up failed. Unable to create file " + new File( createdFileAbsolutePath ) );
        }

        // update refresh based implementations
        this.refreshFileSystem( );

        try {
            // call interface method under test
            lfsFactory.createFile( createdFilePath );
            fail( "The attempt to create an already existing file should cause a RuntimeException." );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ expected
        }
    }

    /**
     * Tests if a folder and a non existing parent folder are properly created
     * (based on legal arguments).
     */
    @Test
    public void testCreateFolderAndParentFolder( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        // try creation of: <tmpbase>\parentfolder\createdfolder
        String createdFolderName = "createdfolder";
        String createdFolderParentName = "parentfolder";
        String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderParentName + "\\" + createdFolderName;
        String createdFolderParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderParentName;
        String createdFolderAbsolutePath = createdFolderParentAbsolutePath + "\\" + createdFolderName;

        // call interface method under test
        IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );

        assertTrue( "Parent folder " + new File( createdFolderParentAbsolutePath ) + " does not exist.", new File( createdFolderParentAbsolutePath ).exists( ) );
        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a directory.", new File( createdFolderAbsolutePath ).isDirectory( ) );
        assertNotNull( "Returned logical folder must not be null.", logicalFolder );
    }

    /**
     * Tests if a file and a non existing parent folder are properly created
     * (based on legal arguments).
     */
    @Test
    public void testCreateFileAndParentFolder( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        // try creation of: <tmpbase>\parentfolder\createdfile.test
        String createdFileParentName = "parentfolder";
        String createdFileName = "createdfile.test";
        String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileParentName + "\\" + createdFileName;
        String createdFileParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileParentName;
        String createdFileAbsolutePath = createdFileParentAbsolutePath + "\\" + createdFileName;

        // call interface method under test
        IpiLogicalFile logicalFile = lfsFactory.createFile( createdFilePath );

        assertTrue( "Parent folder " + new File( createdFileParentAbsolutePath ) + " does not exist.", new File( createdFileParentAbsolutePath ).exists( ) );
        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
        assertNotNull( "Returned logical file must not be null.", logicalFile );
    }

    /**
     * Tests the behavior on illegal arguments (<code>null</code>, empty
     * {@link String}, and illegal file name).
     */
    @Test
    public void testCreateFileIllegalArgument( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        try {
            // call interface method under test
            lfsFactory.createFile( null );
            fail( "Passing null should lead to a NullPointerException" );
        } catch ( NullPointerException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on null argument (NullPointerException expected)." );
        }

        try {
            // call interface method under test
            lfsFactory.createFile( "" );
            fail( "Passing an empty path string should lead to an IllegalArgumentException" );
        } catch ( IllegalArgumentException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on empty path string (IllegalArgumentException expected)." );
        }

        // test reaction on illegal file name
        for ( int i = 0; i < ILLEGAL_FILE_NAMES.length; i++ ) {

            String illegalName = ILLEGAL_FILE_NAMES[i]; // this should be an illegal file name in windows and linux filesystems
            String illegalfilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + i + "\\" + illegalName;
            String illegalfileAbstractPath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + i + "\\" + illegalName;

            try {
                // call interface method under test
                lfsFactory.createFile( illegalfilePath );
                boolean exists = new File( illegalfileAbstractPath ).exists( );
                String existsMessage = ( exists ) ? ( "The file was created." ) : ( "The file was not created as expected." );
                fail( "The attempt to create a file with the illegal name '" + illegalName + "' should lead to a RuntimeException. " + existsMessage + " The complete path of the file to create was: '" + illegalfileAbstractPath + "'" );
            } catch ( RuntimeException e ) {
                // $JL-EXC$ expected
            }
        }
    }

    /**
     * Tests the behavior on illegal arguments (<code>null</code>, empty
     * {@link String}, and illegal folder name).
     */
    @Test
    public void testCreateFolderIllegalArgument( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        try {
            // call interface method under test
            lfsFactory.createFolder( null );
            fail( "Passing null should lead to a NullPointerException" );
        } catch ( NullPointerException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on null argument (NullPointerException expected)." );
        }

        try {
            // call interface method under test
            lfsFactory.createFolder( "" );
            fail( "Passing an empty path string should lead to an IllegalArgumentException" );
        } catch ( IllegalArgumentException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on empty path string (IllegalArgumentException expected)." );
        }

        // test reaction on illegal file name
        for ( int i = 0; i < ILLEGAL_FOLDER_NAMES.length; i++ ) {
            String illegalName = ILLEGAL_FOLDER_NAMES[i];
            String illegalFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + illegalName;
            String illegalAbsoluteFolderPath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + illegalName;

            try {
                // call interface method under test
                lfsFactory.createFolder( illegalFolderPath );
                // we should not reach this point -> check: was the folder created?
                boolean exists = new File( illegalAbsoluteFolderPath ).exists( );
                String existsMessage = ( exists ) ? ( "The folder was created." ) : ( "The folder was not created as expected." );
                fail( "The attempt to create a folder with the illegal name '" + illegalName + "' should lead to a RuntimeException. " + existsMessage + " The complete path of the folder to create was: '" + illegalAbsoluteFolderPath + "'" );
            } catch ( RuntimeException e ) {
                // $JL-EXC$ expected
            }
        }
    }

    /**
     * Tests the behavior for folder creation with invalidly named parent
     * folder.
     */
    @Test
    public void testCreateFolderAndIllegalParentFolder( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        for ( int i = 0; i < ILLEGAL_FOLDER_NAMES.length; i++ ) {
            // try creation of: <tmpbase>\<illegal_name>\createdfile.test
            String illegalCreatedFolderParentName = ILLEGAL_FOLDER_NAMES[i];
            String createdFolderName = "createdfile.test";
            String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + illegalCreatedFolderParentName + "\\" + createdFolderName;
            String createdFolderParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + illegalCreatedFolderParentName;
            String createdFolderAbsolutePath = createdFolderParentAbsolutePath + "\\" + createdFolderName;

            try {
                // call interface method under test
                lfsFactory.createFolder( createdFolderPath );
                fail( "The attempt to create a folder " + createdFolderName + " with a illegal parent folder named '" + illegalCreatedFolderParentName + "' should lead to a RuntimeException. The complete path of the folder to create was: " + createdFolderAbsolutePath );
            } catch ( RuntimeException e ) {
                // $JL-EXC$ expected
            }
        }
    }

    /**
     * Tests the behavior for file creation with invalidly named parent folder.
     */
    @Test
    public void testCreateFileAndIllegalParentFolder( ) {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        for ( int i = 0; i < ILLEGAL_FOLDER_NAMES.length; i++ ) {
            // try creation of: <tmpbase>\<ilegal_name>\createdfile.test
            String illegalCreatedFileParentName = ILLEGAL_FOLDER_NAMES[i];
            String createdFileName = "createdfile.test";
            String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + illegalCreatedFileParentName + "\\" + createdFileName;
            String createdFileParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + illegalCreatedFileParentName;
            String createdFileAbsolutePath = createdFileParentAbsolutePath + "\\" + createdFileName;

            try {
                // call interface method under test
                lfsFactory.createFile( createdFilePath );
                fail( "The attempt to create a file " + createdFileName + " with a illegal parent folder named '" + illegalCreatedFileParentName + "' should lead to a RuntimeException. The complete path of the file to create was: " + createdFileAbsolutePath );
            } catch ( RuntimeException e ) {
                // $JL-EXC$ expected
            }
        }
    }

//    /**
//     * Tests if an implicitly created parent folder is properly removed in case
//     * the intended creation fails for some reason in the context of a folder
//     * creation.<br>
//     * The expected behavior is that folders implicitly created during an
//     * operation are removed if an enclosed file or folder can not be created.
//     */
//    @Test
//    @Ignore( "Tested feature was not implemented yet." )
//    public void testCleanupOfImplicitlyCreatedParentFoldersOnFolderCreationError( ) {
//
//        // try creation of: <tmpbase>\parentfolder\<illegal_name>
//        String createdResourceParentName = "parentfolder";
//        String illegalCreatedResourceName = ILLEGAL_CHARACTERS_RESOURCE_NAME;
//        String illegalCreatedResourcePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdResourceParentName + "\\" + illegalCreatedResourceName;
//        String createdResourceParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdResourceParentName;
//        String illegalCreatedFileAbsolutePath = createdResourceParentAbsolutePath + "\\" + illegalCreatedResourceName;
//
//        assertFalse( "Test setup problem: folder to be cerated already exists: " + illegalCreatedFileAbsolutePath, new File( illegalCreatedFileAbsolutePath ).exists( ) );
//        assertFalse( "Test setup problem: parent folder already exists: " + createdResourceParentAbsolutePath, new File( createdResourceParentAbsolutePath ).exists( ) );
//        try {
//            // call interface method under test
//            this.lfsFactory.createFolder( illegalCreatedResourcePath );
//            fail( "The attempt to create a file with the illegal name '" + illegalCreatedResourceName + "' should lead to a RuntimeException. The complete path of the file to create was: " + illegalCreatedFileAbsolutePath );
//        } catch ( RuntimeException e ) {
//            // $JL-EXC$ expected
//        }
//        assertFalse( "The implicitly created parent folder " + new File( createdResourceParentAbsolutePath ) + " does still exist. It should have been removed since the actual folder creation failed.", new File( createdResourceParentAbsolutePath ).exists( ) );
//    }

//    /**
//     * Tests if an implicitly created parent folder is properly removed in case
//     * the intended creation fails for some reason in the context of a file
//     * creation.<br>
//     * The expected behavior is that folders implicitly created during an
//     * operation are removed if an enclosed file or folder can not be created.
//     */
//    @Test
//    @Ignore( "Tested feature was not implemented yet." )
//    public void testCleanupOfImplicitlyCreatedParentFoldersOnFileCreationError( ) {
//
//        // try creation of: <tmpbase>\parentfolder\<illegal_name>
//        String createdResourceParentName = "parentfolder";
//        String illegalCreatedResourceName = ILLEGAL_CHARACTERS_RESOURCE_NAME;
//        String illegalCreatedResourcePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdResourceParentName + "\\" + illegalCreatedResourceName;
//        String createdResourceParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdResourceParentName;
//        String illegalCreatedFileAbsolutePath = createdResourceParentAbsolutePath + "\\" + illegalCreatedResourceName;
//
//        assertFalse( "Test setup problem: file to be cerated already exists: " + illegalCreatedFileAbsolutePath, new File( illegalCreatedFileAbsolutePath ).exists( ) );
//        assertFalse( "Test setup problem: parent folder already exists: " + createdResourceParentAbsolutePath, new File( createdResourceParentAbsolutePath ).exists( ) );
//        try {
//            // call interface method under test
//            this.lfsFactory.createFile( illegalCreatedResourcePath );
//            fail( "The attempt to create a file with the illegal name '" + illegalCreatedResourceName + "' should lead to a RuntimeException. The complete path of the file to create was: " + illegalCreatedFileAbsolutePath );
//        } catch ( RuntimeException e ) {
//            // $JL-EXC$ expected
//        }
//        assertFalse( "The implicitly created parent folder " + new File( createdResourceParentAbsolutePath ) + " does still exist. It should have been removed since the actual file creation failed.", new File( createdResourceParentAbsolutePath ).exists( ) );
//    }

    /**
     * Tests the getter <code>getResource()</code>.
     * 
     * @throws IOException
     */
    @Test
    public void testGetResource( ) throws IOException {

        // create instance under test
        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        /*
         * test getter witch previously created folder.
         */

        // creation: <tmpbase>\parentfolder\createdfolder
        String createdFolderParentName = "parent";
        String createdFolderName = "createdfolder";
        String createdFolderParentPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderParentName;
        String createdFolderPath = createdFolderParentPath + "\\" + createdFolderName;
        String createdFolderParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderParentName;
        String createdFolderAbsolutePath = createdFolderParentAbsolutePath + "\\" + createdFolderName;

        // assert the folders do not exist in file system
        assertFalse( "Parent folder " + new File( createdFolderParentAbsolutePath ) + " does exist but was not yet created.", new File( createdFolderParentAbsolutePath ).exists( ) );
        assertFalse( "Created folder " + new File( createdFolderAbsolutePath ) + " does exist but was not yet created.", new File( createdFolderPath ).exists( ) );

        // assert the folders do not exist via getter under test
        assertNull( "getResource() should return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderParentPath ) );
        assertNull( "getResource() should return null since the requested folder " + new File( createdFolderAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderPath ) );

        // create folder to test
        IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );

        // assert the folders exist in file system
        assertTrue( "Parent folder " + new File( createdFolderParentAbsolutePath ) + " does not exist.", new File( createdFolderParentAbsolutePath ).exists( ) );
        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a directory.", new File( createdFolderAbsolutePath ).isDirectory( ) );
        assertNotNull( "Returned logical folder must not be null.", logicalFolder );

        // assert the folders exist via getter under test
        assertNotNull( "getResource() must not return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderParentPath ) );
        assertNotNull( "getResource() must not return null since the requested folder " + new File( createdFolderAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderPath ) );

        // some basic checks for folder correctness -> complete test for LogicalFolder has to be done separately
        assertTrue( "Logical folder returned unexpected result. Expected: exists() result true but was false. " + new File( createdFolderAbsolutePath ), lfsFactory.getResource( createdFolderPath ).exists( ) );
        assertFalse( "Logical folder returned unexpected result. Expected: isFile() result false but was true. " + new File( createdFolderAbsolutePath ), lfsFactory.getResource( createdFolderPath ).isFile( ) );
        assertTrue( "Logical folder returned unexpected result. Expected: isFolder() result true but was false. " + new File( createdFolderAbsolutePath ), lfsFactory.getResource( createdFolderPath ).isFolder( ) );
        assertNotNull( "Logical folder returned unexpected result. getName() was null", lfsFactory.getResource( createdFolderPath ).getName( ) );
        assertEquals( "Logical folder returned unexpected result. getName() returned wrong value. " + new File( createdFolderAbsolutePath ), createdFolderName, lfsFactory.getResource( createdFolderPath ).getName( ) );
        assertNotNull( "Logical folder returned unexpected result. logicalFolder.getPath() was null. " + new File( createdFolderAbsolutePath ), lfsFactory.getResource( createdFolderPath ).getPath( ) );
        assertNotNull( "Logical folder returned unexpected result. listResources() was null. " + new File( createdFolderAbsolutePath ), ( (IpiLogicalFolder) lfsFactory.getResource( createdFolderPath ) ).listResources( ) );
        assertArrayEquals( "Logical folder returned unexpected result. listResources() returned wrong value. " + new File( createdFolderAbsolutePath ), new IpiLogicalResource[0], ( (IpiLogicalFolder) lfsFactory.getResource( createdFolderPath ) ).listResources( ) );
        assertEquals( "Logical folder returned unexpected result. lastChangedTime() returned wrong value. " + new File( createdFolderAbsolutePath ), new File( createdFolderAbsolutePath ).lastModified( ), lfsFactory.getResource( createdFolderPath ).lastChangedTime( ) );
        assertEquals( "Logical folder returned unexpected result. getCanonicalPath() returned wrong value. " + new File( createdFolderAbsolutePath ).getCanonicalPath( ), new File( createdFolderAbsolutePath ).getCanonicalPath( ), lfsFactory.getResource( createdFolderPath ).getCanonicalPath( ) );

        /*
         * test getter witch previously created file
         */

        // creation: <tmpbase>\parentfolder\createdfile.test
        String createdFileParentName = "parent2";
        String createdFileName = "createdfile.test";
        String createdFileParentPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFileParentName;
        String createdFilePath = createdFileParentPath + "\\" + createdFileName;
        String createdFileParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFileParentName;
        String createdFileAbsolutePath = createdFileParentAbsolutePath + "\\" + createdFileName;

        // assert parent folder and file do not exist in file system
        assertFalse( "Parent folder " + new File( createdFileParentAbsolutePath ) + " does not exist but was not yet created.", new File( createdFileParentAbsolutePath ).exists( ) );
        assertFalse( "Created file " + new File( createdFileAbsolutePath ) + " does not exist but was not yet created.", new File( createdFileAbsolutePath ).exists( ) );

        // assert parent folder and file do not exist via getter under test
        assertNull( "getResource() should return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFileParentPath ) );
        assertNull( "getResource() should return null since the requested file " + new File( createdFolderAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFilePath ) );

        // call interface method under test
        IpiLogicalFile logicalFile = lfsFactory.createFile( createdFilePath );

        // assert parent folder and file exist in file system
        assertTrue( "Parent folder " + new File( createdFileParentAbsolutePath ) + " does not exist.", new File( createdFileParentAbsolutePath ).exists( ) );
        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
        assertNotNull( "Returned logical file must not be null.", logicalFile );

        // assert parent folder and file exist via getter under test
        assertNotNull( "getResource() must not return null since the requested parent folder " + new File( createdFileParentAbsolutePath ) + " exists.", lfsFactory.getResource( createdFileParentPath ) );
        assertNotNull( "getResource() must not return null since the requested file " + new File( createdFileAbsolutePath ) + " exists.", lfsFactory.getResource( createdFilePath ) );

        // some basic checks for file correctness -> complete test for LogicalFile has to be done separately
        assertTrue( "Logical file returned unexpected result. Expected: exists() result true but was false. " + new File( createdFileAbsolutePath ), lfsFactory.getResource( createdFilePath ).exists( ) );
        assertTrue( "Logical file returned unexpected result. Expected: isFile() result true but was false. " + new File( createdFileAbsolutePath ), lfsFactory.getResource( createdFilePath ).isFile( ) );
        assertFalse( "Logical file returned unexpected result. Expected: isFolder() result false but was true. " + new File( createdFileAbsolutePath ), lfsFactory.getResource( createdFilePath ).isFolder( ) );
        assertNotNull( "Logical file returned unexpected result. getName() was null", lfsFactory.getResource( createdFilePath ).getName( ) );
        assertEquals( "Logical file returned unexpected result. getName() returned wrong value. " + new File( createdFileAbsolutePath ), createdFileName, lfsFactory.getResource( createdFilePath ).getName( ) );
        assertNotNull( "Logical file returned unexpected result. logicalFolder.getPath() was null. " + new File( createdFileAbsolutePath ), lfsFactory.getResource( createdFilePath ).getPath( ) );
        assertEquals( "Logical file returned unexpected result. lastChangedTime() returned wrong value. " + new File( createdFileAbsolutePath ), new File( createdFileAbsolutePath ).lastModified( ), lfsFactory.getResource( createdFilePath ).lastChangedTime( ) );
        assertEquals( "Logical file returned unexpected result. getCanonicalPath() returned wrong value. " + new File( createdFileAbsolutePath ).getCanonicalPath( ), new File( createdFileAbsolutePath ).getCanonicalPath( ), lfsFactory.getResource( createdFilePath ).getCanonicalPath( ) );
    }

}
