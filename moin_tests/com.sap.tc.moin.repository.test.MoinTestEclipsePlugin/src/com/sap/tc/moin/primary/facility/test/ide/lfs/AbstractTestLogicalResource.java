package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;


public abstract class AbstractTestLogicalResource extends AbstractTestLogicalFilesystemBase {

    abstract protected LogicalResourceTestInstance createLogicalResourceTestInstance( );

    public static final class LogicalResourceTestInstance {

        public IpiLogicalResource logicalResource;

        public String resourceLogicalFsPath;

        public File absoluteFile;
    }

    @Test
    public void testGetName( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        // call method under test
        String name = resourceUnderTest.logicalResource.getName( );

        assertNotNull( "Returned resource name must not be null.", name );
        assertEquals( resourceUnderTest.absoluteFile.getName( ), name );
    }

    @Test
    public void testIsFolder( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertEquals( resourceUnderTest.absoluteFile.isDirectory( ), resourceUnderTest.logicalResource.isFolder( ) );
    }

    @Test
    public void testIsFile( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertEquals( resourceUnderTest.absoluteFile.isFile( ), resourceUnderTest.logicalResource.isFile( ) );
    }

    @Test
    public void testGetPath( ) throws IOException {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertEquals( resourceUnderTest.resourceLogicalFsPath.replaceAll( "\\\\", "/" ), resourceUnderTest.logicalResource.getPath( ).replaceAll( "\\\\", "/" ) );
    }

    @Test
    public void testGetCanonicalPath( ) throws IOException {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertEquals( resourceUnderTest.absoluteFile.getCanonicalPath( ), resourceUnderTest.logicalResource.getCanonicalPath( ) );
    }

    @Test
    public void testLastChangedTime( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        assertEquals( resourceUnderTest.absoluteFile.lastModified( ), resourceUnderTest.logicalResource.lastChangedTime( ) );
    }

    @Test
    public void testLastChangedTimeNotExisting( ) {

        // create instance under test
        LogicalResourceTestInstance resourceUnderTest = this.createLogicalResourceTestInstance( );

        resourceUnderTest.absoluteFile.delete( );
        this.refreshFileSystem( );

        assertEquals( -1, resourceUnderTest.logicalResource.lastChangedTime( ) );
    }

}
