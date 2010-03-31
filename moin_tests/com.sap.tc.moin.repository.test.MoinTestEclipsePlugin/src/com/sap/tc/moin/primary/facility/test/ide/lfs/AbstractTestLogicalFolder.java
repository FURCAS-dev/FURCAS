package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;


public abstract class AbstractTestLogicalFolder extends AbstractTestLogicalResource {

    /*
     * Test setup related methods
     */

    /**
     * Returns a new logical folder under test.
     */
    protected LogicalFolderTestInstance createLogicalFolderTestInstance( ) {

        // create folder to test
        String createdFolderName = "createdfolder";
        String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderName;
        String createdFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderName;

        // create folder to test
        IpiLogicalFolder logicalFolder = this.createLogicalFsFactoryTestInstance( ).createFolder( createdFolderPath );

        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a folder.", new File( createdFolderAbsolutePath ).isDirectory( ) );
        assertNotNull( "Returned logical folder must not be null.", logicalFolder );

        // return file instance information
        LogicalFolderTestInstance testInstance = new LogicalFolderTestInstance( );
        testInstance.logicalFolder = logicalFolder;
        testInstance.folderLogicalFsPath = createdFolderPath;
        testInstance.absoluteFile = new File( createdFolderAbsolutePath );

        return testInstance;
    }

    public static final class LogicalFolderTestInstance {

        public IpiLogicalFolder logicalFolder;

        public String folderLogicalFsPath;

        public File absoluteFile;
    }

    @Override
    protected LogicalResourceTestInstance createLogicalResourceTestInstance( ) {

        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );
        // return file instance information
        LogicalResourceTestInstance resourceUnderTest = new LogicalResourceTestInstance( );
        resourceUnderTest.logicalResource = folderUnderTest.logicalFolder;
        resourceUnderTest.resourceLogicalFsPath = folderUnderTest.folderLogicalFsPath;
        resourceUnderTest.absoluteFile = folderUnderTest.absoluteFile;

        return resourceUnderTest;
    }

    /*
     * The actual test methods
     */

    @Test
    public void testExists( ) {

        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        String createdFolderName = "createdfolder";
        String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderName;
        String createdFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderName;

        IpiLogicalResource logicalResource = lfsFactory.getResource( createdFolderPath );

        // preconditions
        assertNull( "Not existing logical resource should be null.", logicalResource );
        assertFalse( "Created folder " + new File( createdFolderAbsolutePath ) + " was not yet created but does exist.", new File( createdFolderAbsolutePath ).exists( ) );

        IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );
        logicalResource = lfsFactory.getResource( createdFolderPath );

        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
        assertNotNull( "Logical resource must not be null.", logicalResource );
        assertTrue( "Logical resource returned unexpected result. Expected: exists() result true but was false. " + new File( createdFolderAbsolutePath ), logicalResource.exists( ) );
        assertTrue( "Logical folder returned unexpected result. Expected: exists() result true but was false. " + new File( createdFolderAbsolutePath ), logicalFolder.exists( ) );

        boolean wasDeleted = new File( createdFolderAbsolutePath ).delete( );

        // update refresh based logical file system implementations
        this.refreshFileSystem( );
        // still there -> we give it another try (max. 5 times)
        for ( int i = 0; ( i < 5 && logicalFolder.exists( ) ); i++ ) {
            this.refreshFileSystem( );
        }

        assertTrue( "Folder was not deleted.", wasDeleted );
        assertFalse( "Logical folder returned unexpected result. Expected: exists() result false but was true. " + new File( createdFolderAbsolutePath ), logicalFolder.exists( ) );
        assertFalse( "Logical resource returned unexpected result. Expected: exists() result false but was true. " + new File( createdFolderAbsolutePath ), logicalResource.exists( ) );
    }

    @Test
    public void testCreateFile( ) {

        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        String createdFileRelativePaths[] = new String[] { "createdfile", "createdfile.file", ".createdfile.ext", ".createdfile", "subfolder\\createdfile", "../createdfile" };

        for ( int i = 0; i < createdFileRelativePaths.length; i++ ) {
            String createdFileRelativePath = createdFileRelativePaths[i];

            String createdFolderName = "createdfolder" + i;
            String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderName;
            String createdFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderName;
            String createdFilePath = createdFolderAbsolutePath + "\\" + createdFileRelativePath;

            // create folder to test
            IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );

            // call interface method under test
            IpiLogicalFile logicalFile = logicalFolder.createFile( createdFileRelativePath );

            assertTrue( "Created file " + new File( createdFilePath ) + " does not exist.", new File( createdFilePath ).exists( ) );
            assertTrue( "Created resource " + new File( createdFilePath ) + " is not a file.", new File( createdFilePath ).isFile( ) );
            assertNotNull( "Returned logical file must not be null.", logicalFile );
        }
    }

    @Test
    public void testCreateFileIllegalArgument( ) {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        try {
            // call interface method under test
            folderUnderTest.logicalFolder.createFile( null );
            fail( "Passing null should lead to a NullPointerException" );
        } catch ( NullPointerException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on null argument (NullPointerException expected)." );
        }

        try {
            // call interface method under test
            folderUnderTest.logicalFolder.createFile( "" );
            fail( "Passing an empty path string should lead to an IllegalArgumentException" );
        } catch ( IllegalArgumentException e ) {
            // $JL-EXC$ expected
        } catch ( Exception e ) {
            fail( "Unexpected exception '" + e.getClass( ) + "' on empty path string (IllegalArgumentException expected)." );
        }

        // test reaction on illegal file name
        for ( int i = 0; i < ILLEGAL_FILE_NAMES.length; i++ ) {
            // test reaction on illegal file name
            String illegalfilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + i + "\\" + ILLEGAL_FILE_NAMES[i];

            try {
                // call interface method under test
                folderUnderTest.logicalFolder.createFile( illegalfilePath );
                fail( "The attempt to create a file with the illegal name '" + ILLEGAL_FILE_NAMES[i] + "' should lead to a RuntimeException. The complete path of the file to create was: " + illegalfilePath );
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
    public void testCreateFileAndIllegalParentFolder( ) {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        for ( int i = 0; i < ILLEGAL_FOLDER_NAMES.length; i++ ) {
            // try creation of: <tmpbase>\<ilegal_name>\createdfile.test
            String illegalCreatedFileParentName = ILLEGAL_FOLDER_NAMES[i];
            String createdFileName = "createdfile.test";
            String createdFilePath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + illegalCreatedFileParentName + "\\" + createdFileName;
            String createdFileParentAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + illegalCreatedFileParentName;
            String createdFileAbsolutePath = createdFileParentAbsolutePath + "\\" + createdFileName;

            try {
                // call interface method under test
                folderUnderTest.logicalFolder.createFile( createdFilePath );
                fail( "The attempt to create a file " + createdFileName + " with a illegal parent folder named '" + illegalCreatedFileParentName + "' should lead to a RuntimeException. The complete path of the file to create was: " + createdFileAbsolutePath );
            } catch ( RuntimeException e ) {
                // $JL-EXC$ expected
            }
        }
    }

    @Test
    public void testListResources( ) throws IOException {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        String createdFolderAbsolutePath = folderUnderTest.absoluteFile.getAbsolutePath( );

        // create some contained resources
        List<String> createdChildren = new ArrayList<String>( );
        File file1 = new File( createdFolderAbsolutePath + "/file1" );
        file1.createNewFile( );
        createdChildren.add( file1.getName( ) );
        File file2 = new File( createdFolderAbsolutePath + "/file2" );
        file2.createNewFile( );
        createdChildren.add( file2.getName( ) );
        File file3 = new File( createdFolderAbsolutePath + "/dir1/file2" );
        file3.getParentFile( ).mkdir( );
        file3.createNewFile( );
        createdChildren.add( file3.getParentFile( ).getName( ) );
        File file4 = new File( createdFolderAbsolutePath + "/dir2/file4" );
        file4.getParentFile( ).mkdir( );
        file4.createNewFile( );
        createdChildren.add( file4.getParentFile( ).getName( ) );

        // ... and update refresh based implementations
        this.refreshFileSystem( );

        // call interface method under test
        IpiLogicalResource childResources[] = folderUnderTest.logicalFolder.listResources( );

        assertNotNull( "Child resource array must not be null since childs exist in the file system.", childResources );
        assertTrue( "Child resource array must not be empty since childs exist in the file system.", ( childResources.length > 0 ) );
        assertTrue( "Incorrecr number of child resources.", ( childResources.length == 4 ) );

        for ( int i = 0; i < childResources.length; i++ ) {
            if ( !createdChildren.contains( childResources[i].getName( ) ) ) {
                fail( "Returned child resource '" + childResources[i] + "' not expected." );
            }
        }
    }

    @Test
    public void testListResourcesEmptyFolder( ) {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        // call interface method under test
        IpiLogicalResource childResources[] = folderUnderTest.logicalFolder.listResources( );
        assertNotNull( "Returned child resource array must not be null.", childResources );
        assertTrue( "Length of child resource array of empty folder must be 0.", ( childResources.length == 0 ) );
    }

    @Test
    public void testListResourcesNotExistingFolder( ) {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        boolean wasDeleted = folderUnderTest.absoluteFile.delete( );
        assertTrue( "Folder was not deleted.", wasDeleted );

        // update refresh based logical file system implementations
        this.refreshFileSystem( );
        // still there -> we give it another try (max. 5 times)
        for ( int i = 0; ( i < 5 && folderUnderTest.logicalFolder.exists( ) ); i++ ) {
            this.refreshFileSystem( );
        }

        // call interface method under test
        IpiLogicalResource childResources[] = folderUnderTest.logicalFolder.listResources( );
        assertNull( "Returned child resource array should be null for a not existing folder.", childResources );
    }

    /**
     * Tests the getter <code>getResource()</code>.
     * 
     * @throws IOException
     */
    @Test
    public void testGetResource( ) throws IOException {

        IpiLogicalFsFactory lfsFactory = this.createLogicalFsFactoryTestInstance( );

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        String baseFolderName = "base";
        String baseFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + baseFolderName;
        String baseFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + baseFolderName;

        // create folder to test
        IpiLogicalFolder logicalBaseFolder = lfsFactory.createFolder( baseFolderPath );

        assertNull( "Logical folder returned unexpected result. Expected: getResource() should return null for not existing resource.", logicalBaseFolder.getResource( "SomeNotExistingPath" ) );

        /*
         * test getter with previously created folder.
         */
        String createdFolderParentName = "parent1";
        String createdFolderName = "createdfolder";
        String createdFolderParentPath = baseFolderPath + "\\" + createdFolderParentName;
        String createdFolderPath = createdFolderParentPath + "\\" + createdFolderName;
        String createdFolderParentAbsolutePath = baseFolderAbsolutePath + "\\" + createdFolderParentName;
        String createdFolderAbsolutePath = createdFolderParentAbsolutePath + "\\" + createdFolderName;
        String createdFolderPathRelativeToBase = createdFolderParentName + "\\" + createdFolderName;

        // assert the folders do not exist in file system
        assertFalse( "Parent folder " + new File( createdFolderParentAbsolutePath ) + " does exist but was not yet created.", new File( createdFolderParentAbsolutePath ).exists( ) );
        assertFalse( "Created folder " + new File( createdFolderAbsolutePath ) + " does exist but was not yet created.", new File( createdFolderPath ).exists( ) );

        // assert the folders do not exist via getter under test
        assertNull( "getResource() should return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderParentName ) );
        assertNull( "getResource() should return null since the requested folder " + new File( createdFolderAbsolutePath ) + " was not yet created.", lfsFactory.getResource( createdFolderPathRelativeToBase ) );

        // call interface method under test
        IpiLogicalFolder logicalFolder = lfsFactory.createFolder( createdFolderPath );

        // assert the folders exist in file system
        assertTrue( "Parent folder " + new File( createdFolderParentAbsolutePath ) + " does not exist.", new File( createdFolderParentAbsolutePath ).exists( ) );
        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a directory.", new File( createdFolderAbsolutePath ).isDirectory( ) );
        assertNotNull( "Returned logical folder must not be null.", logicalFolder );

        // assert the folders exist via getter under test
        assertNotNull( "getResource() must not return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", logicalBaseFolder.getResource( createdFolderParentName ) );
        assertNotNull( "getResource() must not return null since the requested folder " + new File( createdFolderAbsolutePath ) + " was not yet created.", logicalBaseFolder.getResource( createdFolderPathRelativeToBase ) );

        // some basic checks for folder correctness -> complete test for LogicalFolder has to be done separately
        assertTrue( "Logical folder returned unexpected result. Expected: exists() result true but was false. " + new File( createdFolderAbsolutePath ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).exists( ) );
        assertFalse( "Logical folder returned unexpected result. Expected: isFile() result false but was true. " + new File( createdFolderAbsolutePath ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).isFile( ) );
        assertTrue( "Logical folder returned unexpected result. Expected: isFolder() result true but was false. " + new File( createdFolderAbsolutePath ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).isFolder( ) );
        assertNotNull( "Logical folder returned unexpected result. getName() was null", logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).getName( ) );
        assertEquals( "Logical folder returned unexpected result. getName() returned wrong value. " + new File( createdFolderAbsolutePath ), createdFolderName, logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).getName( ) );
        assertNotNull( "Logical folder returned unexpected result. logicalFolder.getPath() was null. " + new File( createdFolderAbsolutePath ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).getPath( ) );
        assertNotNull( "Logical folder returned unexpected result. listResources() was null. " + new File( createdFolderAbsolutePath ), ( (IpiLogicalFolder) logicalBaseFolder.getResource( createdFolderPathRelativeToBase ) ).listResources( ) );
        assertArrayEquals( "Logical folder returned unexpected result. listResources() returned wrong value. " + new File( createdFolderAbsolutePath ), new IpiLogicalResource[0], ( (IpiLogicalFolder) logicalBaseFolder.getResource( createdFolderPathRelativeToBase ) ).listResources( ) );
        assertEquals( "Logical folder returned unexpected result. lastChangedTime() returned wrong value. " + new File( createdFolderAbsolutePath ), new File( createdFolderAbsolutePath ).lastModified( ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase ).lastChangedTime( ) );
        assertEquals( "Logical folder returned unexpected result. getCanonicalPath() returned wrong value. " + new File( createdFolderAbsolutePath ).getCanonicalPath( ), new File( createdFolderAbsolutePath ).getCanonicalPath( ), logicalBaseFolder.getResource( createdFolderPathRelativeToBase )
            .getCanonicalPath( ) );

        /*
         * test getter with previously created file.
         */

        // creation: <tmpbase>\parentfolder\createdfile.test
        String createdFileParentName = "parent2";
        String createdFileName = "createdfile.test";
        String createdFileParentPath = baseFolderPath + "\\" + createdFileParentName;
        String createdFilePath = createdFileParentPath + "\\" + createdFileName;
        String createdFileParentAbsolutePath = baseFolderAbsolutePath + "\\" + createdFileParentName;
        String createdFileAbsolutePath = createdFileParentAbsolutePath + "\\" + createdFileName;
        String createdFilePathRelativeToBase = createdFileParentName + "\\" + createdFileName;

        // assert parent folder and file do not exist in file system
        assertFalse( "Parent folder " + new File( createdFileParentAbsolutePath ) + " does not exist but was not yet created.", new File( createdFileParentAbsolutePath ).exists( ) );
        assertFalse( "Created file " + new File( createdFileAbsolutePath ) + " does not exist but was not yet created.", new File( createdFileAbsolutePath ).exists( ) );

        // assert parent folder and file do not exist via getter under test
        assertNull( "getResource() should return null since the requested parent folder " + new File( createdFolderParentAbsolutePath ) + " was not yet created.", logicalBaseFolder.getResource( createdFileParentName ) );
        assertNull( "getResource() should return null since the requested file " + new File( createdFolderAbsolutePath ) + " was not yet created.", logicalBaseFolder.getResource( createdFilePathRelativeToBase ) );

        // call interface method under test
        IpiLogicalFile logicalFile = lfsFactory.createFile( createdFilePath );

        // assert parent folder and file exist in file system
        assertTrue( "Parent folder " + new File( createdFileParentAbsolutePath ) + " does not exist.", new File( createdFileParentAbsolutePath ).exists( ) );
        assertTrue( "Created file " + new File( createdFileAbsolutePath ) + " does not exist.", new File( createdFileAbsolutePath ).exists( ) );
        assertTrue( "Created resource " + new File( createdFileAbsolutePath ) + " is not a file.", new File( createdFileAbsolutePath ).isFile( ) );
        assertNotNull( "Returned logical file must not be null.", logicalFile );

        // assert parent folder and file exist via getter under test
        assertNotNull( "getResource() must not return null since the requested parent folder " + new File( createdFileParentAbsolutePath ) + " exists.", logicalBaseFolder.getResource( createdFileParentName ) );
        assertNotNull( "getResource() must not return null since the requested file " + new File( createdFileAbsolutePath ) + " exists.", logicalBaseFolder.getResource( createdFilePathRelativeToBase ) );

        // some basic checks for file correctness -> complete test for LogicalFile has to be done separately
        assertTrue( "Logical file returned unexpected result. Expected: exists() result true but was false. " + new File( createdFileAbsolutePath ), logicalBaseFolder.getResource( createdFilePathRelativeToBase ).exists( ) );
        assertTrue( "Logical file returned unexpected result. Expected: isFile() result true but was false. " + new File( createdFileAbsolutePath ), logicalBaseFolder.getResource( createdFilePathRelativeToBase ).isFile( ) );
        assertFalse( "Logical file returned unexpected result. Expected: isFolder() result false but was true. " + new File( createdFileAbsolutePath ), logicalBaseFolder.getResource( createdFilePathRelativeToBase ).isFolder( ) );
        assertNotNull( "Logical file returned unexpected result. getName() was null", logicalBaseFolder.getResource( createdFilePathRelativeToBase ).getName( ) );
        assertEquals( "Logical file returned unexpected result. getName() returned wrong value. " + new File( createdFileAbsolutePath ), createdFileName, logicalBaseFolder.getResource( createdFilePathRelativeToBase ).getName( ) );
        assertNotNull( "Logical file returned unexpected result. logicalFolder.getPath() was null. " + new File( createdFileAbsolutePath ), logicalBaseFolder.getResource( createdFilePathRelativeToBase ).getPath( ) );
        assertEquals( "Logical file returned unexpected result. lastChangedTime() returned wrong value. " + new File( createdFileAbsolutePath ), new File( createdFileAbsolutePath ).lastModified( ), logicalBaseFolder.getResource( createdFilePathRelativeToBase ).lastChangedTime( ) );
        assertEquals( "Logical file returned unexpected result. getCanonicalPath() returned wrong value. " + new File( createdFileAbsolutePath ).getCanonicalPath( ), new File( createdFileAbsolutePath ).getCanonicalPath( ), logicalBaseFolder.getResource( createdFilePathRelativeToBase )
            .getCanonicalPath( ) );
    }

    //    @Test
    //    @Ignore( "Tested feature not supported." )
    //    // uncomment test code in testExists() as soon as this works
    //    public void testLogicalFolderDelete( ) {
    //
    //        // try creation of: <tmpbase>\createdfolder
    //        String createdFolderName = "createdfolder";
    //        String createdFolderPath = this.getTransformedTemporaryDirectoryPath( ) + "\\" + createdFolderName;
    //        String createdFolderAbsolutePath = this.getAbsoluteTemporaryDirectoryPath( ) + "\\" + createdFolderName;
    //
    //        LogicalResource logicalFolder = this.lfsFactory.createFolder( createdFolderPath );
    //
    //        // preconditions
    //        assertTrue( "Created folder " + new File( createdFolderAbsolutePath ) + " does not exist.", new File( createdFolderAbsolutePath ).exists( ) );
    //        assertTrue( "Created resource " + new File( createdFolderAbsolutePath ) + " is not a directory.", new File( createdFolderAbsolutePath ).isDirectory( ) );
    //        assertNotNull( "Returned logical folder must not be null.", logicalFolder );
    //
    //        // call interface method under test
    //        boolean wasDeleted = logicalFolder.delete( );
    //
    //        assertTrue( "Folder was not deleted.", wasDeleted );
    //        assertTrue( "Folder should be deleted " + new File( createdFolderAbsolutePath ) + " but does still exist.", new File( createdFolderAbsolutePath ).exists( ) );
    //    }

    @Test
    public void testIsArchive( ) {

        // create instance under test
        LogicalFolderTestInstance folderUnderTest = this.createLogicalFolderTestInstance( );

        assertFalse( "isArchive() must not return true for a folder.", folderUnderTest.logicalFolder.isArchive( ) );
    }
}
