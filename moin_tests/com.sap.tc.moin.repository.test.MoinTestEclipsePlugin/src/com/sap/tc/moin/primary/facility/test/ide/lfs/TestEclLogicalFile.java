package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl.EclFsFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;


public class TestEclLogicalFile extends AbstractTestLogicalFile {

    @Override
    protected IpiLogicalFsFactory createLogicalFsFactoryTestInstance( ) {

        return new EclFsFactoryImpl( );
    }

    @Override
    protected String getTransformedTemporaryDirectoryPath( ) {

        String workspaceRelativeBasePath;

        IPath tempDirectoryPath = Path.fromOSString( this.temporaryDirectory.getAbsolutePath( ) );
        IPath wsRootLocation = ResourcesPlugin.getWorkspace( ).getRoot( ).getLocation( );

        if ( wsRootLocation.isPrefixOf( tempDirectoryPath ) ) {
            workspaceRelativeBasePath = "/" + tempDirectoryPath.removeFirstSegments( wsRootLocation.segmentCount( ) ).setDevice( null ).toString( );
        } else {
            throw new RuntimeException( "Unable to calculate the path of the temporary directory relative to the workspace root." );
        }

        return workspaceRelativeBasePath;
    }

    @Override
    protected void refreshFileSystem( ) {

        // refreshes the workspace
        try {
            ResourcesPlugin.getWorkspace( ).getRoot( ).refreshLocal( IResource.DEPTH_INFINITE, null );
            Thread.sleep( 100 );
        } catch ( CoreException e ) {
            // $JL-EXC$ expected
        } catch ( InterruptedException e ) {
            // $JL-EXC$ expected
        }
    }

    @Test
    public void testGetInputStreamForOutOfSyncResource( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "read this from file...".getBytes( ); //$NON-NLS-1$

        // now we make a change on java.io.File level (resource is out of sync)
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

//        // assure that the file is out of sync
//        IFile file = ( (IFile) fileUnderTest.logicalFile.getUnderlyingResource( ) );
//        if ( file.isSynchronized( IFile.DEPTH_ZERO ) ) {
//            throw new RuntimeException( "Test setup failed: file '" + file.getFullPath( ).toString( ) + "' is expected not to be in sync with the eclipse file system but was in sync." ); //$NON-NLS-1$ //$NON-NLS-2$
//        }

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

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) ); //$NON-NLS-1$

//        // assure that the file is in sync now, allow refresh jobs to finish
//        Job.getJobManager( ).resume( );
//        Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );
//        try {
//            assertTrue( "File '" + file.getFullPath( ).toString( ) + "' is expected to be in sync with the eclipse file system but was not.", !file.isSynchronized( IFile.DEPTH_ZERO ) ); //$NON-NLS-1$ //$NON-NLS-2$
//        } finally {
//            Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
//        }

    }

    @Test
    public void testGetInputStreamForInSyncResource( ) throws Exception {

        // create instance under test
        LogicalFileTestInstance fileUnderTest = this.createLogicalFileTestInstance( );

        byte content[] = "read this from file...".getBytes( ); //$NON-NLS-1$

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

        // now we make the changed file change visible to the eclipse file system
        IFile file = fileUnderTest.logicalFile.getUnderlyingResource( IFile.class );
        file.refreshLocal( IFile.DEPTH_ZERO, null );

        // assure that the file is in sync
        if ( !file.isSynchronized( IFile.DEPTH_ZERO ) ) {
            throw new RuntimeException( "Test setup failed: file '" + file.getFullPath( ).toString( ) + "' is expected to be in sync with the eclipse file system but was not." ); //$NON-NLS-1$ //$NON-NLS-2$
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

        assertEquals( "Read unexpected file content.", new String( content ), new String( readBytes ) ); //$NON-NLS-1$

        // assert that the file is still in sync
        assertTrue( "File '" + file.getFullPath( ).toString( ) + "' is expected to be in sync with the eclipse file system but was not.", file.isSynchronized( IFile.DEPTH_ZERO ) ); //$NON-NLS-1$ //$NON-NLS-2$

    }

}
